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
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
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

    private List<WorkingTimeEntity> workingTimeEntityList;

    private long selectedClientId = 0;

    private String beginDate = null;
    private String endDate = null;

    public void deleteWorkingTime(int selectedWorkingTimeId) {

        ExternalContext eC = FacesContext.getCurrentInstance().getExternalContext();

        workingTimeService.removeWorkingTime(selectedWorkingTimeId);

        redirectAfterLogin(eC, "employee_home.xhtml");
    }

    @PostConstruct
    public void init() {

        workingTimeEntityList = workingTimeService.getAllWorkingTimes();
        WorkingTimeEntity[] workingTimeEntitiesArray = new WorkingTimeEntity[workingTimeEntityList.size()];
        workingTimeEntityList.toArray(workingTimeEntitiesArray);

        workingTimeEntityDataModel = new ArrayDataModel<WorkingTimeEntity>(workingTimeEntitiesArray);
    }

    public void addWorkingTime() {

        ExternalContext eC = FacesContext.getCurrentInstance().getExternalContext();
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");

        try {

            if(beginDate != null && endDate != null) {

                Date bDate = formatter.parse(beginDate);
                Date eDate = formatter.parse(endDate);

                workingTimeToAdd.setBeginDate(bDate);
                workingTimeToAdd.setEndDate(eDate);
            }

            workingTimeToAdd.setClient(clientService.getClient(selectedClientId));
            workingTimeService.addWorkingTime(workingTimeToAdd);

            redirectAfterLogin(eC, "employee_home.xhtml");

        } catch (ParseException e) {
            e.printStackTrace();
        }
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

    public List<WorkingTimeEntity> getWorkingTimeEntityList() {
        return workingTimeEntityList;
    }

    public void setWorkingTimeEntityList(List<WorkingTimeEntity> workingTimeEntityList) {
        this.workingTimeEntityList = workingTimeEntityList;
    }

    public String getBeginDate() {
        return beginDate;
    }

    public void setBeginDate(String beginDate) {
        this.beginDate = beginDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }
}
