package fang.ecommerce.clothes.entity;

import javax.persistence.*;

@Entity
@Table(name = "order_details")
public class OrderDetailEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    @Column(name = "quantity")
    private int quantity;

    @Column(name = "price")
    private Float price;


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "orders_id", referencedColumnName = "id")
    private OrderEntity orderEntity;

    @OneToOne
    @JoinColumn(name = "clothes_id", referencedColumnName = "id")
    private ClothesEntity clothesEntity;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "sizes_id", referencedColumnName = "id")
    private SizeEntity sizeEntity_OrderDetail;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public OrderEntity getOrderEntity() {
        return orderEntity;
    }

    public void setOrderEntity(OrderEntity orderEntity) {
        this.orderEntity = orderEntity;
    }

    public ClothesEntity getClothesEntity() {
        return clothesEntity;
    }

    public void setClothesEntity(ClothesEntity clothesEntity) {
        this.clothesEntity = clothesEntity;
    }

    public SizeEntity getSizeEntity() {
        return sizeEntity_OrderDetail;
    }

    public void setSizeEntity(SizeEntity sizeEntity) {
        this.sizeEntity_OrderDetail = sizeEntity;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public Float getPrice() {
        return price;
    }

    public void setPrice(Float price) {
        this.price = price;
    }
}
