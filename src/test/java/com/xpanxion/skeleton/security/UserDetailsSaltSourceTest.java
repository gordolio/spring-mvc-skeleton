package com.xpanxion.skeleton.security;

import com.xpanxion.skeleton.dto.beans.UserBean;
import org.junit.Test;

import static junit.framework.Assert.assertEquals;

/**
 * Created by gchild on 1/7/2015.
 */
public class UserDetailsSaltSourceTest {

    @Test
    public void testUserDetailsSalt() {
        final String salt = "test123";
        UserBean bean = new UserBean();
        bean.setSalt(salt);
        UserDetailsWrapper wrapper = new UserDetailsWrapper(bean);

        UserDetailsSaltSource saltSource = new UserDetailsSaltSource();
        assertEquals(salt, saltSource.getSalt(wrapper));
    }
}
