package com.gobnl.main.entity;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Set;

public class FuncionarioDetails extends Funcionario implements UserDetails {

    public FuncionarioDetails(Funcionario funcionario) {
        super(funcionario);
    }
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        Set<Roles> roles = getRoles();
        List<SimpleGrantedAuthority> authorityList = new ArrayList<>();
        for(Roles role : roles) {
            authorityList.add(new SimpleGrantedAuthority("ROLE_" + role.getName().toUpperCase()));
        }
        return authorityList;
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
