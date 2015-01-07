package com.xpanxion.skeleton.service;

import com.xpanxion.skeleton.dto.beans.UserBean;
import junit.framework.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.Collection;

import static junit.framework.Assert.assertNotNull;
import static junit.framework.TestCase.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.mockito.BDDMockito.given;

/**
 * Test UserDetailsServiceImpl
 *
 * @author Gordon Child
 */
@RunWith(MockitoJUnitRunner.class)
public class UserDetailsServiceImplTest {

    @InjectMocks
    private UserDetailsServiceImpl testee;

    @Mock
    private UserService userService;

    @Test
    public void testLoadValidUser() {
        //given
        final String username = "TestUser1";
        final String password = "test123";
        UserBean userBean = new UserBean();
        userBean.setUsername(username);
        userBean.setPassword(password);

        given(userService.getUserByUsername(username)).willReturn(userBean);

        // when
        UserDetails user = testee.loadUserByUsername(username);
        Collection<? extends GrantedAuthority> auths = user.getAuthorities();

        // then
        assertNotNull(user);
        assertEquals(username, user.getUsername());
        assertEquals(password, user.getPassword());
        assertFalse(auths.isEmpty());

        for(GrantedAuthority auth : auths) {
            assertEquals("ROLE_USER", auth.getAuthority());
        }
        assertTrue(user.isAccountNonExpired());
        assertTrue(user.isAccountNonLocked());
        assertTrue(user.isCredentialsNonExpired());
        assertTrue(user.isEnabled());
    }

    @Test(expected=UsernameNotFoundException.class)
    public void loadInvalidUserTest() {
        // given
        given(userService.getUserByUsername("bogusUser")).willReturn(null);
        testee.loadUserByUsername("bogusUser");

    }

    @Test(expected=UsernameNotFoundException.class)
    public void testThrownExceptionUserDetails() {
        // given
        given(userService.getUserByUsername("bogusUser")).willThrow(RuntimeException.class);
        testee.loadUserByUsername("bogusUser");
    }
}
