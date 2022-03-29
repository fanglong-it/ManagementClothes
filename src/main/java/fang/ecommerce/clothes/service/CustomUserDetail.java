package fang.ecommerce.clothes.service;

import fang.ecommerce.clothes.entity.AccountEntity;
import fang.ecommerce.clothes.entity.RoleEntity;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class CustomUserDetail implements UserDetails {
    private AccountEntity accountEntity;


    public CustomUserDetail(AccountEntity accountEntity) {
        this.accountEntity = accountEntity;
    }


    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        List<RoleEntity> roleEntities = accountEntity.getRoles();
        List<SimpleGrantedAuthority> grantedAuthorities = new ArrayList<>();
        for (RoleEntity role : roleEntities) {
            grantedAuthorities.add(new SimpleGrantedAuthority(role.getName()));
        }
        return grantedAuthorities;
    }

    public boolean hasRole(String name) {
        return this.accountEntity.hasRole(name);

    }

    @Override
    public String getPassword() {
        return null;
    }

    @Override
    public String getUsername() {
        return null;
    }

    @Override
    public boolean isAccountNonExpired() {
        return false;
    }

    @Override
    public boolean isAccountNonLocked() {
        return false;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return false;
    }

    @Override
    public boolean isEnabled() {
        return false;
    }
}
