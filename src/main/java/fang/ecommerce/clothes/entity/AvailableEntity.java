package fang.ecommerce.clothes.entity;


import javax.persistence.*;

@Entity
@Table(name = "available")
public class AvailableEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "stock")
    private long stock;

    @OneToOne
    @JoinColumn(name = "size_id", referencedColumnName = "id")
    private SizeEntity sizeEntity;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public long getStock() {
        return stock;
    }

    public void setStock(long stock) {
        this.stock = stock;
    }

    public SizeEntity getSizeEntity() {
        return sizeEntity;
    }

    public void setSizeEntity(SizeEntity sizeEntity) {
        this.sizeEntity = sizeEntity;
    }
}
