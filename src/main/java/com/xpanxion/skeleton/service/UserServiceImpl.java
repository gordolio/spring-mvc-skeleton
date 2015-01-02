package com.xpanxion.skeleton.service;

import com.xpanxion.skeleton.dao.UserDao;
import com.xpanxion.skeleton.dto.beans.UserBean;
import com.xpanxion.skeleton.dto.entity.UserEntity;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by gchild on 1/2/2015.
 */
@Transactional
@Service
public class UserServiceImpl implements UserService {

    private UserDao userDao;

    @Override
    public List<UserBean> getUsers() {
        List<UserEntity> userItems = this.userDao.getAllItems();
        List<UserBean> output = new ArrayList<>();
        for(UserEntity entity : userItems) {
            UserBean bean = new UserBean();
            BeanUtils.copyProperties(entity, bean);
            output.add(bean);
        }

        return output;
    }

    @Resource
    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }
}
