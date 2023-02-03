/*
 * Copyright (c) 2022. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

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
import fang.ecommerce.clothes.dto.MyUser;
import fang.ecommerce.clothes.entity.*;
import fang.ecommerce.clothes.service.*;
import fang.ecommerce.clothes.service.serviceImpl.OrderServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Controller
@RequestMapping("shoppingCart")
public class ShoppingCartController {

    @Autowired
    ClothesService clothesService;

    @Autowired
    ShoppingCartService shoppingCartService;


    @Autowired
    OrderServiceImpl orderService;

    @Autowired
    OrderDetailService orderDetailService;

    @Autowired
    SizeService sizeService;

    @Autowired
    UserService userService;




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


    @GetMapping("viewShipping")
    public String viewShipping(Authentication authentication, Model model){
        Collection<CartItem> cartItems = shoppingCartService.getCartItems();
        if(authentication == null){
            model.addAttribute("MESSAGE", "you need login to process this request");
            model.addAttribute("CART_ITEMS", cartItems);
            model.addAttribute("TOTAL", shoppingCartService.getAmount());
            model.addAttribute("NO_OF_ITEMS", shoppingCartService.getCount());
            return "redirect:/shoppingCart/cart";
        }else{
            //get MyUser
            //Ussing myUser to get UserEntity (Address load from UserEntity)
            //update userImage and name on Invoice Page
            //User Can choose the Address after loading
            //Get the billCode, update Date,
            //show up CartItem
            //Calculator if has Discount 



        }
        return "invoiceDetail";
    }

    @GetMapping("checkOut")
    public String checkOutPage(Authentication authentication, Model model) {
        Collection<CartItem> cartItems = shoppingCartService.getCartItems();

        //Check if User is null
        if (authentication == null) {
            model.addAttribute("MESSAGE", "you need login to process this request");
            model.addAttribute("CART_ITEMS", cartItems);
            model.addAttribute("TOTAL", shoppingCartService.getAmount());
            model.addAttribute("NO_OF_ITEMS", shoppingCartService.getCount());
            return "redirect:/shoppingCart/cart";
        } else {
            MyUser userDetails = (MyUser) authentication.getPrincipal();
            AddressEntity addressEntity = new AddressEntity();
            addressEntity.setAddress("123123");
            addressEntity.setUserEntity_Address(userService.getById(userDetails.getId()));
            OrderEntity order = new OrderEntity();
            order.setCode("123456");
            order.setAddressEntity(addressEntity);
            order.setUserEntity(userService.getById(userDetails.getId()));
            orderService.insertOrder(order);


            List<OrderDetailEntity> orderDetailEntityList = new ArrayList<>();
            for (CartItem cart : cartItems
            ) {
                OrderDetailEntity orderDetail = new OrderDetailEntity();
                orderDetail.setQuantity(cart.getQuantity());
                orderDetail.setOrderEntity(order);
                orderDetail.setClothesEntity(clothesService.getById(cart.getProductid()));
                orderDetail.setPrice(cart.getProductprice());
                orderDetailEntityList.add(orderDetail);
            }
            orderDetailService.saveAll(orderDetailEntityList);
            return "redirect:/shop/";
        }
    }
}
