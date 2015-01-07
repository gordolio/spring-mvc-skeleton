package com.xpanxion.skeleton.security;

import org.springframework.security.authentication.dao.SaltSource;
import org.springframework.security.core.userdetails.UserDetails;

/**
 * Salt Source
 */
public class UserDetailsSaltSource implements SaltSource {

    @Override
    public Object getSalt(UserDetails user) {
        return ((UserDetailsWrapper)user).getSalt();
    }
}
