package fang.ecommerce.clothes.entity;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "orders")
public class OrderEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "code")
    private String code;


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "address_id", referencedColumnName = "id")
    private AddressEntity addressEntity;


    @OneToMany(mappedBy = "orderEntity")
    private Set<OrderDetailEntity> detailEntitySet;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "users_id", referencedColumnName = "id")
    private UserEntity userEntity_Order;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public AddressEntity getAddressEntity() {
        return addressEntity;
    }

    public void setAddressEntity(AddressEntity addressEntity) {
        this.addressEntity = addressEntity;
    }

    public Set<OrderDetailEntity> getDetailEntitySet() {
        return detailEntitySet;
    }

    public void setDetailEntitySet(Set<OrderDetailEntity> detailEntitySet) {
        this.detailEntitySet = detailEntitySet;
    }

    public UserEntity getUserEntity() {
        return userEntity_Order;
    }

    public void setUserEntity(UserEntity userEntity) {
        this.userEntity_Order = userEntity;
    }
}
