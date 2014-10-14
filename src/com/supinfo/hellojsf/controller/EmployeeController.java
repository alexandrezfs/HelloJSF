package com.supinfo.hellojsf.controller;

import com.supinfo.hellojsf.entity.EmployeeEntity;
import com.supinfo.hellojsf.service.EmployeeService;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.faces.model.ArrayDataModel;
import javax.faces.model.DataModel;
import java.io.IOException;
import java.io.Serializable;
import java.util.List;

/**
 * Created by Alexandre NGUYEN on 14/10/2014.
 */

@ManagedBean
public class EmployeeController implements Serializable {

    @EJB
    private EmployeeService employeeService;

    private EmployeeEntity employeeEntity = new EmployeeEntity();

    private DataModel<EmployeeEntity> employeeEntities;

    @PostConstruct
    public void init() {

        List<EmployeeEntity> employeeEntitiesList = employeeService.getAllEmployees();
        EmployeeEntity[] employeeEntitiesArray = new EmployeeEntity[employeeEntitiesList.size()];
        employeeEntitiesList.toArray(employeeEntitiesArray);

        employeeEntities = new ArrayDataModel<EmployeeEntity>(employeeEntitiesArray);
    }

    public void addEmployee() {

        ExternalContext eC = FacesContext.getCurrentInstance().getExternalContext();

        employeeService.addEmployee(employeeEntity);

        redirectAfterAdding(eC, "manager_home.xhtml");
    }

    private void redirectAfterAdding(ExternalContext eC, String page) {
        try {
            eC.redirect(eC.getRequestContextPath() + "/" + page);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public EmployeeEntity getEmployeeEntity() {
        return employeeEntity;
    }

    public void setEmployeeEntity(EmployeeEntity employeeEntity) {
        this.employeeEntity = employeeEntity;
    }

    public DataModel<EmployeeEntity> getEmployeeEntities() {
        return employeeEntities;
    }

    public void setEmployeeEntities(DataModel<EmployeeEntity> employeeEntities) {
        this.employeeEntities = employeeEntities;
    }
}
