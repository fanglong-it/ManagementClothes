package fang.ecommerce.clothes.repository;

import fang.ecommerce.clothes.entity.CategoryEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<CategoryEntity, Long> {

}
