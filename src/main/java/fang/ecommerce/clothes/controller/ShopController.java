package fang.ecommerce.clothes.controller;

import fang.ecommerce.clothes.entity.CategoryEntity;
import fang.ecommerce.clothes.entity.ClothesEntity;
import fang.ecommerce.clothes.service.CategoryService;
import fang.ecommerce.clothes.service.ClothesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/shop")
public class ShopController {

    @Autowired
    ClothesService clothesService;

    @Autowired
    CategoryService categoryService;


    @GetMapping("/")
    public String homePage(Model model){
        List<ClothesEntity> clothesEntityList = clothesService.findAll();
        List<CategoryEntity> categoryEntityList = null;
        model.addAttribute("LIST_CLOTHES", clothesEntityList);
//        model.addAttribute("LIST_CATEGORY", categoryEntityList);
        return "index";

    }
}
