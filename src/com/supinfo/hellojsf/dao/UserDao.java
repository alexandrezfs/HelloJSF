package com.supinfo.hellojsf.dao;

import com.supinfo.hellojsf.entity.EmployeeEntity;
import com.supinfo.hellojsf.entity.UserEntity;

import javax.ejb.Local;
import java.util.List;

/**
 * Created by Alexandre NGUYEN on 14/10/2014.
 */

@Local
public interface UserDao {

    public void addUser(UserEntity userEntity);
    public Object getUserByUsernamePassword(String username, String password);
    public List<EmployeeEntity> getAllEmployees();

}
