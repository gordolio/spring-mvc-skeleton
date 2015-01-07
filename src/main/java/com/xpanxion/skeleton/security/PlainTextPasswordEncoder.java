package com.xpanxion.skeleton.security;

import org.springframework.security.crypto.password.PasswordEncoder;

/**
 * This is an extremely non-secure password encoder
 * @author Gordon Child
 */
public class PlainTextPasswordEncoder implements PasswordEncoder {
    @Override
    public String encode(CharSequence rawPassword) {
        return rawPassword.toString();
    }

    @Override
    public boolean matches(CharSequence rawPassword, String encodedPassword) {
        if(rawPassword == null) {
            return false;
        }
        return rawPassword.toString().equals(encodedPassword);
    }
}
