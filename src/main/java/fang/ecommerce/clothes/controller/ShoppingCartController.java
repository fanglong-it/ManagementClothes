package fang.ecommerce.clothes.controller;/*
 *
 *
 * Project ProductManager
 * Copyright (C) $year by Fanglong-it. All Rights Reserved.
 * For more information : Fang.longpc@gmail.com
 * Example project exist at : https://github.com/fanglong-it/
 * 10/22/21, 1:58 PM
 *
 *
 */

import fang.ecommerce.clothes.dto.CartItem;
import fang.ecommerce.clothes.entity.ClothesEntity;
import fang.ecommerce.clothes.service.ClothesService;
import fang.ecommerce.clothes.service.ShoppingCartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

/*
 *
 *
 * Project ProductManager
 * Copyright (C) $year by Fanglong-it. All Rights Reserved.
 * For more information : Fang.longpc@gmail.com
 * Example project exist at : https://github.com/fanglong-it/
 * 10/23/21, 7:29 PM
 *
 *
 */

@Controller
@RequestMapping("shoppingCart")
public class ShoppingCartController {

    @Autowired
    ClothesService clothesService;

    @Autowired
    ShoppingCartService shoppingCartService;

    @GetMapping("cart")
    public String list(Model model) {
        Collection<CartItem> cartItems = shoppingCartService.getCartItems();
        model.addAttribute("CART_ITEMS", cartItems);
        model.addAttribute("TOTAL", shoppingCartService.getAmount());
        model.addAttribute("NO_OF_ITEMS", shoppingCartService.getCount());

        return "cartItems";
    }

    @RequestMapping(value = "add/", method = RequestMethod.POST)
    public String addPost(@RequestParam("txtclothesid") Long productId, @RequestParam("txtsize") String size) {
        ClothesEntity clothes = clothesService.getById(productId);
        if (clothes != null) {
            CartItem item = new CartItem(clothes.getId(), clothes.getName(),
                    clothes.getPrice(), 1, clothes.getCategoryEntity().getName(), size, clothes.getPhotoPath());


            item.setQuantity(1);
            shoppingCartService.add(item);
        }
        return "redirect:/shoppingCart/cart";
    }

    @RequestMapping(value = "add/{id}/{size}", method = RequestMethod.GET)
    public String addGet(@PathVariable("id") Long productId, @PathVariable("size") String size) {
        ClothesEntity clothes = clothesService.getById(productId);
        if (clothes != null) {
            CartItem item = new CartItem(clothes.getId(), clothes.getName(),
                    clothes.getPrice(), 1, clothes.getCategoryEntity().getName(), size, clothes.getPhotoPath());
            item.setQuantity(1);
            shoppingCartService.add(item);
        }
        return "redirect:/shoppingCart/cart";
    }

    @GetMapping("remove/{id}")
    public String remove(@PathVariable(name = "id") Long productid) {
        shoppingCartService.remove(productid);
        return "redirect:/shoppingCart/cart";
    }

    @PostMapping("update")
    public String update(@RequestParam("productId") Long productId,
                         @RequestParam("quantity") Integer quantity,
                         @RequestParam("txtsize") String size) {

        shoppingCartService.update(productId, quantity, size);

        return "redirect:/shoppingCart/cart";
    }

    @GetMapping("clear")
    public String clear() {
        shoppingCartService.clear();
        return "redirect:/shoppingCart/cart";

    }

}
