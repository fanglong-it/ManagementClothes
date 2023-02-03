/*
 * Copyright (c) 2022. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package fang.ecommerce.clothes.service;

import fang.ecommerce.clothes.entity.AvailableEntity;
import fang.ecommerce.clothes.repository.AvailableRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AvailableService {
    @Autowired
    private AvailableRepository availableRepository;

    public AvailableEntity getAvailableEntityBySizeId(Long SizeId) {
        return availableRepository.getBySizeEntity_Id(SizeId);
    }
}
