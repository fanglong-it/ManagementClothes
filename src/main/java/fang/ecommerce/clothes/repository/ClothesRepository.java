package fang.ecommerce.clothes.repository;


import fang.ecommerce.clothes.entity.ClothesEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ClothesRepository extends JpaRepository<ClothesEntity, Long> {

}
