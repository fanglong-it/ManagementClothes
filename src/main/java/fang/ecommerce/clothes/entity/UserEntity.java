/*
 *
 *
 * Project ProductManager
 * Copyright (C) $year by Fanglong-it. All Rights Reserved.
 * For more information : Fang.longpc@gmail.com
 * Example project exist at : https://github.com/fanglong-it/
 * 11/11/21, 2:15 PM
 *
 *
 */

package fang.ecommerce.clothes.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;


@Entity
@Table(name = "users")
public class UserEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "firstname", nullable = false)
    private String firstname;

    @Column(name = "lastname", nullable = false)
    private String lastname;

    @Column(name = "photo")
    private String photoPath;

    @Column(name = "phonenumber", nullable = false, length = 10)
    private String phoneNumber;

    @OneToOne
    @JoinColumn(name = "account_id", referencedColumnName = "id")
    private AccountEntity accountEntity;

    @OneToMany(mappedBy = "userEntity_Address")
    private Set<AddressEntity> addressEntitySet;

    @OneToMany(mappedBy = "userEntity_Order")
    private Set<OrderEntity> orderEntitySet;


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getPhotoPath() {
        return photoPath;
    }

    public void setPhotoPath(String photoPath) {
        this.photoPath = photoPath;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public AccountEntity getAccountEntity() {
        return accountEntity;
    }

    public void setAccountEntity(AccountEntity accountEntity) {
        this.accountEntity = accountEntity;
    }

    public Set<AddressEntity> getAddressEntitySet() {
        return addressEntitySet;
    }

    public void setAddressEntitySet(Set<AddressEntity> addressEntitySet) {
        this.addressEntitySet = addressEntitySet;
    }

    public Set<OrderEntity> getOrderEntitySet() {
        return orderEntitySet;
    }

    public void setOrderEntitySet(Set<OrderEntity> orderEntitySet) {
        this.orderEntitySet = orderEntitySet;
    }


}
