package fang.ecommerce.clothes.service;

import fang.ecommerce.clothes.entity.CategoryEntity;
import fang.ecommerce.clothes.entity.ClothesEntity;
import fang.ecommerce.clothes.repository.ClothesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClothesService {

    @Autowired
    ClothesRepository clothesRepository;

    @Autowired
    CategoryService categoryService;


    public List<ClothesEntity> findAll(){
        List<ClothesEntity> clothesEntityList = clothesRepository.findAll();
        return clothesEntityList;
    }
}
