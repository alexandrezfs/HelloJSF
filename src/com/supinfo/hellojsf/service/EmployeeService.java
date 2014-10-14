package com.supinfo.hellojsf.service;

import com.supinfo.hellojsf.dao.UserDao;
import com.supinfo.hellojsf.entity.EmployeeEntity;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import java.util.List;

/**
 * Created by Alexandre NGUYEN on 14/10/2014.
 */

@Stateless
public class EmployeeService {

    @EJB
    private UserDao userDao;

    public void addEmployee(EmployeeEntity employeeEntity) {
        userDao.addUser(employeeEntity);
    }

    public List<EmployeeEntity> getAllEmployees() {

        return userDao.getAllEmployees();
    }
}
