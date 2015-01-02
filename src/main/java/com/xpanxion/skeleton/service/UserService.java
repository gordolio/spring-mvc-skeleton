package com.xpanxion.skeleton.service;

import com.xpanxion.skeleton.dto.beans.UserBean;

import java.util.List;

/**
 * Created by gchild on 1/2/2015.
 */
public interface UserService {

    public List<UserBean> getUsers();
}
