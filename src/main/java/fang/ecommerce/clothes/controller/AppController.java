package fang.ecommerce.clothes.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AppController {

    @GetMapping("/")
    public String redirectHome(){
        return "redirect:/shop/";
    }
}
