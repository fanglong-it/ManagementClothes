package fang.ecommerce.clothes.controller;

import fang.ecommerce.clothes.entity.CategoryEntity;
import fang.ecommerce.clothes.entity.ClothesEntity;
import fang.ecommerce.clothes.service.CategoryService;
import fang.ecommerce.clothes.service.ClothesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/shop")
public class ShopController {

    @Autowired
    ClothesService clothesService;

    @Autowired
    CategoryService categoryService;


    @GetMapping("/")
    public String homePage(Model model) {
        int pageNo = 1;
        int pageSize = 3;
        Page<ClothesEntity> page = clothesService.findPaginated(pageNo,pageSize);
        List<ClothesEntity> clothesEntityList = page.getContent();
        List<CategoryEntity> categoryEntityList = null;
        model.addAttribute("LIST_CLOTHES", clothesEntityList);
        model.addAttribute("currentPage", pageNo);
        model.addAttribute("totalPages", page.getTotalPages());
        model.addAttribute("totalItems", page.getTotalElements());
//        model.addAttribute("LIST_CATEGORY", categoryEntityList);
        return "index";

    }

    @GetMapping("/viewDetail/{clothesId}")
    public String viewProductDetail(@PathVariable("clothesId") Long clothesId, Model model) {
        model.addAttribute("CLOTHES", clothesService.getById(clothesId));
        return "detail";

    }

    @GetMapping("/page/{pageNo}")
    public String findPaginated(@PathVariable("pageNo") int pageNo, Model model, @RequestParam("searchValue") String value) {
        int pageSize = 3;
        Page<ClothesEntity> page = null;
        if(value != null){
            page = clothesService.findByName(pageNo, pageSize, value);
            if(page.getTotalElements() > 0 && page.getTotalElements() < pageSize){
                page=clothesService.findByName(1,pageSize,value);
            }
        }else{
            page = clothesService.findPaginated(pageNo, pageSize);
        }

        List<ClothesEntity> clothesEntityList = page.getContent();


        model.addAttribute("currentPage", pageNo);
        model.addAttribute("totalPages", page.getTotalPages());
        model.addAttribute("totalItems", page.getTotalElements());
        model.addAttribute("searchValue",value);
        model.addAttribute("LIST_CLOTHES", clothesEntityList);

        return "index";
    }


}
