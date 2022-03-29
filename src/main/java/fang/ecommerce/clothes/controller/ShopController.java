package fang.ecommerce.clothes.controller;

import fang.ecommerce.clothes.entity.AvailableEntity;
import fang.ecommerce.clothes.entity.CategoryEntity;
import fang.ecommerce.clothes.entity.ClothesEntity;
import fang.ecommerce.clothes.entity.SizeEntity;
import fang.ecommerce.clothes.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.HashMap;
import java.util.List;

@Controller
@RequestMapping("/shop")
public class ShopController {

    @Autowired
    ClothesService clothesService;

    @Autowired
    CategoryService categoryService;

    @Autowired
    SizeService sizeService;

    @Autowired
    AvailableService availableService;

    @Autowired
    ShoppingCartService shoppingCartService;


    @GetMapping("/")
    public String homePage(Model model) {
        int pageNo = 1;
        int pageSize = 3;
        Page<ClothesEntity> page = clothesService.findPaginated(pageNo, pageSize);
        List<ClothesEntity> clothesEntityList = page.getContent();
        List<CategoryEntity> categoryEntityList = null;
        model.addAttribute("LIST_CLOTHES", clothesEntityList);
        model.addAttribute("currentPage", pageNo);
        model.addAttribute("totalPages", page.getTotalPages());
        model.addAttribute("totalItems", page.getTotalElements());
        model.addAttribute("LIST_CATEGORY", categoryService.findAllCategory());
        return "index";

    }


    @GetMapping("/viewDetail/{clothesId}")
    public String viewProductDetail(@PathVariable("clothesId") Long clothesId, Model model, ModelMap modelMap) {
        model.addAttribute("CLOTHES", clothesService.getById(clothesId));
        model.addAttribute("SIZE", sizeService.findAllSizeById(clothesId));
        List<SizeEntity> sizeEntityList = sizeService.findAllSizeById(clothesId);
        HashMap<SizeEntity, AvailableEntity> hashMap = new HashMap<>();
        for (SizeEntity size :
                sizeEntityList) {
            AvailableEntity availableEntity = availableService.getAvailableEntityBySizeId(size.getId());

            hashMap.put(size, availableEntity);
        }
        modelMap.put("SIZE_STOCK", hashMap);
        return "detail";
    }


    @GetMapping("/page/{pageNo}")
    public String findPaginated(@PathVariable("pageNo") int pageNo, Model model, @RequestParam("searchValue") String value) {
        int pageSize = 6;
        Page<ClothesEntity> page = null;
        if (value != null) {
            page = clothesService.findByName(pageNo, pageSize, value);
            if (page.getTotalElements() > 0 && page.getTotalElements() < pageSize) {
                page = clothesService.findByName(1, pageSize, value);
            }
        } else {
            page = clothesService.findPaginated(pageNo, pageSize);
        }

        List<ClothesEntity> clothesEntityList = page.getContent();

        model.addAttribute("searchValue", value);

        model.addAttribute("currentPage", pageNo);
        model.addAttribute("totalPages", page.getTotalPages());
        model.addAttribute("totalItems", page.getTotalElements());
        model.addAttribute("LIST_CLOTHES", clothesEntityList);
        model.addAttribute("LIST_CATEGORY", categoryService.findAllCategory());
        return "index";
    }


}
