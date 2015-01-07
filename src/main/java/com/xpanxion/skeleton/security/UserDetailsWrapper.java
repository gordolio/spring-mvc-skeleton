package com.xpanxion.skeleton.security;

import com.xpanxion.skeleton.dto.beans.UserBean;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * Created by gchild on 1/5/2015.
 */
public class UserDetailsWrapper extends UserBean implements UserDetails {

    private UserBean bean;

    public UserDetailsWrapper(final UserBean bean) {
        this.bean = bean;
        this.setPassword(bean.getPassword());
        this.setUsername(bean.getUsername());
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        List<GrantedAuthority> authList = new ArrayList<>();
        authList.add(new SimpleGrantedAuthority("ROLE_USER"));
        return authList;
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
