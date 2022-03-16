package fang.ecommerce.clothes.repository;

import fang.ecommerce.clothes.entity.AvailableEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AvailableRepository extends JpaRepository<AvailableEntity, Long> {

    AvailableEntity getBySizeEntity_Id(Long sizeId);

}

