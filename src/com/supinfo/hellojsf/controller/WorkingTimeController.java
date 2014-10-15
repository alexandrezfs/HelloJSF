package com.supinfo.hellojsf.controller;

import com.supinfo.hellojsf.entity.ClientEntity;
import com.supinfo.hellojsf.entity.EmployeeEntity;
import com.supinfo.hellojsf.entity.WorkingTimeEntity;
import com.supinfo.hellojsf.service.ClientService;
import com.supinfo.hellojsf.service.WorkingTimeService;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.faces.model.ArrayDataModel;
import javax.faces.model.DataModel;
import java.io.IOException;
import java.util.List;

/**
 * Created by Alexandre NGUYEN on 14/10/2014.
 */

@ManagedBean
public class WorkingTimeController {

    @EJB
    private WorkingTimeService workingTimeService;

    @EJB
    private ClientService clientService;

    private WorkingTimeEntity workingTimeToAdd = new WorkingTimeEntity();

    private DataModel<WorkingTimeEntity> workingTimeEntityDataModel;

    private long selectedClientId = 0;

    @PostConstruct
    public void init() {

        List<WorkingTimeEntity> workingTimeEntityList = workingTimeService.getAllWorkingTimes();
        WorkingTimeEntity[] workingTimeEntitiesArray = new WorkingTimeEntity[workingTimeEntityList.size()];
        workingTimeEntityList.toArray(workingTimeEntitiesArray);

        workingTimeEntityDataModel = new ArrayDataModel<WorkingTimeEntity>(workingTimeEntitiesArray);
    }

    public void addWorkingTime() {

        ExternalContext eC = FacesContext.getCurrentInstance().getExternalContext();

        ClientEntity c = clientService.getClient(selectedClientId);

        workingTimeToAdd.setClient(c);

        workingTimeService.addWorkingTime(workingTimeToAdd);

        redirectAfterLogin(eC, "employee_home.xhtml");
    }

    private void redirectAfterLogin(ExternalContext eC, String page) {
        try {
            eC.redirect(eC.getRequestContextPath() + "/" + page);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public WorkingTimeEntity getWorkingTimeToAdd() {
        return workingTimeToAdd;
    }

    public void setWorkingTimeToAdd(WorkingTimeEntity workingTimeToAdd) {
        this.workingTimeToAdd = workingTimeToAdd;
    }

    public DataModel<WorkingTimeEntity> getWorkingTimeEntityDataModel() {
        return workingTimeEntityDataModel;
    }

    public void setWorkingTimeEntityDataModel(DataModel<WorkingTimeEntity> workingTimeEntityDataModel) {
        this.workingTimeEntityDataModel = workingTimeEntityDataModel;
    }

    public long getSelectedClientId() {
        return selectedClientId;
    }

    public void setSelectedClientId(long selectedClientId) {
        this.selectedClientId = selectedClientId;
    }
}
