package fang.ecommerce.clothes.service;

import fang.ecommerce.clothes.entity.SizeEntity;
import fang.ecommerce.clothes.repository.SizeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class SizeService {


    @Autowired
    private SizeRepository sizeRepository;

    public List<SizeEntity> findAllSizeById(Long clothesId){
        List<SizeEntity> sizeEntityList = sizeRepository.findAllByClothesEntity_Id(clothesId);
        return sizeEntityList;
    }

}
