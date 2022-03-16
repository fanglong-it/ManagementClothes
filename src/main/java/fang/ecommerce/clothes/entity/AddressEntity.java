package fang.ecommerce.clothes.entity;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "address")
public class AddressEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "address")
    private String address;


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "users_id")
    private UserEntity userEntity_Address;

    @OneToMany(mappedBy = "addressEntity")
    private Set<OrderEntity> orderEntitySet;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public UserEntity getUserEntity() {
        return userEntity_Address;
    }

    public void setUserEntity(UserEntity userEntity) {
        this.userEntity_Address = userEntity;
    }


    public UserEntity getUserEntity_Address() {
        return userEntity_Address;
    }

    public void setUserEntity_Address(UserEntity userEntity_Address) {
        this.userEntity_Address = userEntity_Address;
    }


    public Set<OrderEntity> getOrderEntitySet() {
        return orderEntitySet;
    }

    public void setOrderEntitySet(Set<OrderEntity> orderEntitySet) {
        this.orderEntitySet = orderEntitySet;
    }
}
