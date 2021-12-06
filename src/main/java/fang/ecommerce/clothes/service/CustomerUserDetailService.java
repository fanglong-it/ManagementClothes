package fang.ecommerce.clothes.service;



import fang.ecommerce.clothes.dto.MyUser;
import fang.ecommerce.clothes.entity.RoleEntity;

import fang.ecommerce.clothes.entity.UserEntity;
import fang.ecommerce.clothes.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.ArrayList;
import java.util.List;

public class CustomerUserDetailService implements UserDetailsService {

    @Autowired
    UserRepository repository;

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        UserEntity userEntity = repository.findUserEntityByEmail(s);
        if(userEntity == null){
            throw new UsernameNotFoundException("USERNAME NOT FOUND!");
        }
        // put thong tin vao security duy tri thong tin nguoi dung
        List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
        for (RoleEntity role : userEntity.getRoles()) {
            authorities.add(new SimpleGrantedAuthority(role.getName()));
        }

        MyUser myUser = new MyUser(userEntity.getLastname(), userEntity.getPassword(), true, true, true, true, authorities);
        myUser.setFullname(userEntity.getFirstname() + userEntity.getLastname());
        myUser.setId(userEntity.getId());
        myUser.setEmail(userEntity.getEmail());
        return myUser;

    }
}
