/*
 * Copyright (c) 2022. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package fang.ecommerce.clothes.service;/*
 *
 *
 * Project ProductManager
 * Copyright (C) $year by Fanglong-it. All Rights Reserved.
 * For more information : Fang.longpc@gmail.com
 * Example project exist at : https://github.com/fanglong-it/
 * 10/22/21, 1:44 PM
 *
 *
 */

import fang.ecommerce.clothes.dto.CartItem;

import java.util.Collection;

public interface ShoppingCartService {

    void add(CartItem item);

    void remove(Long ProductId);

    Collection<CartItem> getCartItems();

    void clear();

    void update(Long productId, int quantity, String size);

    double getAmount();

    int getCount();

}
