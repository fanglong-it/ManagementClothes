/*
 * Copyright (c) 2022. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package fang.ecommerce.clothes.entity;

import javax.persistence.*;
import java.util.Set;

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

    @OneToMany(mappedBy = "sizeEntity_OrderDetail")
    private Set<OrderDetailEntity> orderDetailEntitySet;

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

    public Set<OrderDetailEntity> getOrderDetailEntitySet() {
        return orderDetailEntitySet;
    }

    public void setOrderDetailEntitySet(Set<OrderDetailEntity> orderDetailEntitySet) {
        this.orderDetailEntitySet = orderDetailEntitySet;
    }

    public AvailableEntity getAvailableEntity() {
        return availableEntity;
    }

    public void setAvailableEntity(AvailableEntity availableEntity) {
        this.availableEntity = availableEntity;
    }
}
