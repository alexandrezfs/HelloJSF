package com.supinfo.hellojsf.controller;

import com.supinfo.hellojsf.entity.EmployeeEntity;
import com.supinfo.hellojsf.entity.ManagerEntity;
import com.supinfo.hellojsf.service.UserService;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import java.io.IOException;
import java.io.Serializable;
import java.sql.Date;

/**
 * Created by Alexandre NGUYEN on 14/10/2014.
 */

@ManagedBean
public class UserController implements Serializable {

    @EJB
    private UserService userService;

    private String username;
    private String password;

    public void addEmployee() {

        EmployeeEntity employeeEntity = new EmployeeEntity();
        employeeEntity.setEmail("test@hellojsf.com");
        employeeEntity.setDateOfBirth(new Date(0));
        employeeEntity.setFirstname("AlexEmployee");
        employeeEntity.setLastname("Nguyen");
        employeeEntity.setPassword("Supinfo123@");
        employeeEntity.setUsername("alexEployee");

        userService.addUser(employeeEntity);
    }

    public void addManager() {

        ManagerEntity managerEntity = new ManagerEntity();
        managerEntity.setEmail("test@hellojsf.com");
        managerEntity.setDateOfBirth(new Date(0));
        managerEntity.setFirstname("AlexManager");
        managerEntity.setLastname("Nguyen");
        managerEntity.setPassword("Supinfo123@");
        managerEntity.setUsername("alexManager");

        userService.addUser(managerEntity);
    }

    public void logout() {

        ExternalContext eC = FacesContext.getCurrentInstance().getExternalContext();
        eC.getSessionMap().put("UserSession", null);

        redirectAfterLogin(eC, "login.xhtml");
    }

    public void login() {

        ExternalContext eC = FacesContext.getCurrentInstance().getExternalContext();

        Object obj = userService.getUserByUsernamePassword(username, password);

        if(obj instanceof ManagerEntity) {
            eC.getSessionMap().put("UserSession", obj);
            redirectAfterLogin(eC, "manager_home.xhtml");
        }
        else if(obj instanceof EmployeeEntity) {
            eC.getSessionMap().put("UserSession", obj);
            redirectAfterLogin(eC, "employee_home.xhtml");
        }
        else {
            System.out.println("this is a user instance...");
            redirectAfterLogin(eC, "login.xhtml");
        }

    }

    private void redirectAfterLogin(ExternalContext eC, String page) {
        try {
            eC.redirect(eC.getRequestContextPath() + "/" + page);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
