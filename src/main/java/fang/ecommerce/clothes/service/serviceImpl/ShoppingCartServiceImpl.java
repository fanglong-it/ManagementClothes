package fang.ecommerce.clothes.service.serviceImpl;/*
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
import fang.ecommerce.clothes.service.ShoppingCartService;
import org.springframework.stereotype.Service;
import org.springframework.web.context.annotation.SessionScope;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

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

@Service
@SessionScope
public class ShoppingCartServiceImpl implements ShoppingCartService {

    private Map<Long, CartItem> map = new HashMap<>();

    @Override
    public void add(CartItem item) {

        CartItem existItem = map.get(item.getProductid());
        if (existItem != null) {
            existItem.setQuantity(item.getQuantity() + existItem.getQuantity());

        } else {
            map.put(item.getProductid(), item);
        }
    }

    @Override
    public void remove(Long ProductId) {
        map.remove(ProductId);
    }

    @Override
    public Collection<CartItem> getCartItems() {
        return map.values();
    }

    @Override
    public void clear() {
        map.clear();
    }

    @Override
    public void update(Long productId, int quantity, String size) {
        CartItem item = map.get(productId);
        item.setQuantity(quantity);
        item.setSize(size);
        if (item.getQuantity() <= 0) {
            map.remove(productId);
        }
    }

    @Override
    public double getAmount() {
        return map.values().stream().mapToDouble(item -> item.getQuantity() * item.getProductprice()).sum();
    }

    @Override
    public int getCount() {
        if (map.isEmpty()) {
            return 0;
        }
        return map.values().size();
    }


}
