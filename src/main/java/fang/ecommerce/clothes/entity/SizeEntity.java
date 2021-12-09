package fang.ecommerce.clothes.entity;

import javax.persistence.*;

@Entity
@Table(name = "size")
public class SizeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "clothes_id", referencedColumnName = "id")
    private ClothesEntity clothesEntity;

    @OneToOne(mappedBy = "sizeEntity_OrderDetail")
    private OrderDetailEntity orderDetailEntity;

    @OneToOne(mappedBy = "sizeEntity")
    private AvailableEntity availableEntity;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ClothesEntity getClothesEntity() {
        return clothesEntity;
    }

    public void setClothesEntity(ClothesEntity clothesEntity) {
        this.clothesEntity = clothesEntity;
    }

    public OrderDetailEntity getOrderDetailEntity() {
        return orderDetailEntity;
    }

    public void setOrderDetailEntity(OrderDetailEntity orderDetailEntity) {
        this.orderDetailEntity = orderDetailEntity;
    }

    public AvailableEntity getAvailableEntity() {
        return availableEntity;
    }

    public void setAvailableEntity(AvailableEntity availableEntity) {
        this.availableEntity = availableEntity;
    }
}
