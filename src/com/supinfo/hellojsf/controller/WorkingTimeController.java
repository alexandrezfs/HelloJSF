package com.supinfo.hellojsf.controller;

import com.supinfo.hellojsf.entity.EmployeeEntity;
import com.supinfo.hellojsf.entity.WorkingTimeEntity;
import com.supinfo.hellojsf.service.WorkingTimeService;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.model.ArrayDataModel;
import javax.faces.model.DataModel;
import java.util.List;

/**
 * Created by Alexandre NGUYEN on 14/10/2014.
 */

@ManagedBean
public class WorkingTimeController {

    @EJB
    private WorkingTimeService workingTimeService;

    private WorkingTimeEntity workingTimeToAdd;

    private DataModel<WorkingTimeEntity> workingTimeEntityDataModel;

    public void addWorkingTime() {

        workingTimeService.addWorkingTime(workingTimeToAdd);

    }

    @PostConstruct
    public void init() {

        List<WorkingTimeEntity> workingTimeEntityList = workingTimeService.getAllWorkingTimes();
        WorkingTimeEntity[] workingTimeEntitiesArray = new WorkingTimeEntity[workingTimeEntityList.size()];
        workingTimeEntityList.toArray(workingTimeEntitiesArray);

        workingTimeEntityDataModel = new ArrayDataModel<WorkingTimeEntity>(workingTimeEntitiesArray);
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
}
