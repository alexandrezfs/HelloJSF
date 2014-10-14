package com.supinfo.hellojsf.service;

import com.supinfo.hellojsf.dao.UserDao;
import com.supinfo.hellojsf.entity.UserEntity;

import javax.ejb.EJB;
import javax.ejb.Stateless;

/**
 * Created by Alexandre NGUYEN on 14/10/2014.
 */
@Stateless
public class UserService {

    @EJB
    private UserDao userDao;

    public void addUser(UserEntity userEntity) {
        userDao.addUser(userEntity);
    }

    public Object getUserByUsernamePassword(String username, String password) {
        return userDao.getUserByUsernamePassword(username, password);
    }
}
