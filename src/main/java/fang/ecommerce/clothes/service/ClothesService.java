/*
 * Copyright (c) 2022. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package fang.ecommerce.clothes.service;

import fang.ecommerce.clothes.entity.ClothesEntity;
import fang.ecommerce.clothes.repository.ClothesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClothesService {

    @Autowired
    ClothesRepository clothesRepository;

    @Autowired
    CategoryService categoryService;


    public List<ClothesEntity> findAll() {
        List<ClothesEntity> clothesEntityList = clothesRepository.findAll();
        return clothesEntityList;
    }

    public ClothesEntity getById(Long id) {
        return clothesRepository.getById(id);
    }

    public Page<ClothesEntity> findPaginated(int pageNo, int pageSize) {
        Pageable pageable = PageRequest.of(pageNo - 1, pageSize);
        return this.clothesRepository.findAll(pageable);
    }

    public Page<ClothesEntity> findByName(int pageNo, int pageSize, String name) {
        Pageable pageable = PageRequest.of(pageNo - 1, pageSize);
        if (name != null) {
            return this.clothesRepository.findClothesEntitiesByNameContaining(name, pageable);
        }
        return this.clothesRepository.findAll(pageable);
    }
}
