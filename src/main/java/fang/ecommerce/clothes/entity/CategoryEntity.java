package fang.ecommerce.clothes.entity;


import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "category")
public class CategoryEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;


    @OneToMany(mappedBy = "categoryEntity")
    private Set<ClothesEntity> clothesEntity;


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

    public Set<ClothesEntity> getClothesEntity() {
        return clothesEntity;
    }

    public void setClothesEntity(Set<ClothesEntity> clothesEntity) {
        this.clothesEntity = clothesEntity;
    }
}
