package fang.ecommerce.clothes.controller;

import fang.ecommerce.clothes.dto.MyUser;
import fang.ecommerce.clothes.entity.AccountEntity;
import fang.ecommerce.clothes.service.CustomerUserDetailService;
import org.apache.tomcat.util.descriptor.web.ContextHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.context.SecurityContextHolder;
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
