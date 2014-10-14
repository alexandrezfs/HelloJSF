package com.supinfo.hellojsf.dao;

import com.supinfo.hellojsf.entity.UserEntity;

import javax.ejb.Local;

/**
 * Created by Alexandre NGUYEN on 14/10/2014.
 */

@Local
public interface UserDao {

    public void addUser(UserEntity userEntity);
    public UserEntity getUserById(int id);
    public Object getUserByUsernamePassword(String username, String password);

}
