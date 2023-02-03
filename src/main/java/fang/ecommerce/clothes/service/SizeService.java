/*
 * Copyright (c) 2022. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package fang.ecommerce.clothes.service;

import fang.ecommerce.clothes.entity.SizeEntity;
import fang.ecommerce.clothes.repository.SizeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SizeService {


    @Autowired
    private SizeRepository sizeRepository;

    public List<SizeEntity> findAllSizeById(Long clothesId) {
        List<SizeEntity> sizeEntityList = sizeRepository.findAllByClothesEntity_Id(clothesId);
        return sizeEntityList;
    }
    public SizeEntity getSizeById(Long sizeId){
        return sizeRepository.getById(sizeId);
    }



}
