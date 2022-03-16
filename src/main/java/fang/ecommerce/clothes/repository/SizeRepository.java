package fang.ecommerce.clothes.repository;

import fang.ecommerce.clothes.entity.SizeEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SizeRepository extends JpaRepository<SizeEntity, Long> {

    List<SizeEntity> findAllByClothesEntity_Id(Long clothesId);

}
