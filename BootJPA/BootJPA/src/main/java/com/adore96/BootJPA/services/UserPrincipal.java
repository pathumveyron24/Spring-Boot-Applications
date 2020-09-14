package com.adore96.BootJPA.services;

import com.adore96.BootJPA.model.Roledetails;
import com.adore96.BootJPA.model.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class UserPrincipal implements UserDetails {

    @Autowired
    Roledetails roledetails;

    private Users users;

    public UserPrincipal(Users users) {
        super();
        System.out.println("UserPrincipal constructor -- UserPrincipal");
        this.users = users;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        List<GrantedAuthority> authorities = new ArrayList<>();
        System.out.println("GrantedAuthority--UserPrincipal");

        String role = users.getRoleid();
        authorities.add(new SimpleGrantedAuthority(roledetails.getRoleid()));
        System.out.println(new SimpleGrantedAuthority(roledetails.getRolename()));
        return authorities;
    }

    @Override
    public String getPassword() {
        return users.getPassword();
    }

    @Override
    public String getUsername() {
        System.out.println(users.getUsername());
        return users.getUsername();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
