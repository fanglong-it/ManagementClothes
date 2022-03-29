package fang.ecommerce.clothes.repository;


import fang.ecommerce.clothes.entity.ClothesEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface ClothesRepository extends JpaRepository<ClothesEntity, Long> {

    @Query("select c from ClothesEntity c where c.name like %?1%")
    Page<ClothesEntity> findClothesEntitiesByNameContaining(String name, Pageable pageable);

}
