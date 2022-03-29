package fang.ecommerce.clothes.service;

import fang.ecommerce.clothes.entity.CategoryEntity;
import fang.ecommerce.clothes.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService {
    @Autowired
    CategoryRepository categoryRepository;

    public List<CategoryEntity> findAllCategory() {
        List<CategoryEntity> categoryEntityList = categoryRepository.findAll();
        return categoryEntityList;
    }


}
