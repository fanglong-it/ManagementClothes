package fang.ecommerce.clothes.repository;

import fang.ecommerce.clothes.entity.CategoryEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CategoryRepository extends JpaRepository<CategoryEntity, Long> {
    @Query(value = "select * from category",nativeQuery = true)
    List<CategoryEntity> getListCategoryEntity();
}
