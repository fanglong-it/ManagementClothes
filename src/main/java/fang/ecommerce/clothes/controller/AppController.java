package fang.ecommerce.clothes.controller;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.security.AuthProvider;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Controller
public class AppController {


    @GetMapping("/")
    public String redirectHome(Authentication authentication) {
        if (authentication != null) {
            Set<String> roles = AuthorityUtils.authorityListToSet(authentication.getAuthorities());
            if (roles.contains("ADMIN")) {
                return "redirect:/admin/";
            } else {
                return "redirect:/shop/";

            }
        }
        return "redirect:/shop/";
    }
}
