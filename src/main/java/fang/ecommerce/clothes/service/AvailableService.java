package fang.ecommerce.clothes.service;

import fang.ecommerce.clothes.entity.AvailableEntity;
import fang.ecommerce.clothes.repository.AvailableRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AvailableService {
    @Autowired
    private AvailableRepository availableRepository;

    public AvailableEntity getAvailableEntityBySizeId(Long SizeId) {
        return availableRepository.getBySizeEntity_Id(SizeId);
    }
}
