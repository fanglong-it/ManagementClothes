package fang.ecommerce.clothes.repository;

import fang.ecommerce.clothes.entity.AccountEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountRepository extends JpaRepository<AccountEntity, Long> {

    AccountEntity getAccountEntitiesByEmail(String email);

}
