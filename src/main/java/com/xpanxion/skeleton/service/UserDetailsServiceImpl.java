package com.xpanxion.skeleton.service;


import com.xpanxion.skeleton.dto.beans.UserBean;
import com.xpanxion.skeleton.security.UserDetailsWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

/**
 * Created by gchild on 1/5/2015.
 */
@Service("userDetailsService")
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private UserService userService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserBean bean;
        try {
            bean = userService.getUserByUsername(username);
        } catch(RuntimeException ex) {
            throw new UsernameNotFoundException("User: " + username + " not found.", ex);
        }
        if(bean == null) {
            throw new UsernameNotFoundException("User: " + username + " not found.");
        }
        return new UserDetailsWrapper(bean);
    }
}
