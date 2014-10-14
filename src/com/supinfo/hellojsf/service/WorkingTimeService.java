package com.supinfo.hellojsf.service;

import com.supinfo.hellojsf.dao.WorkingTimeDao;
import com.supinfo.hellojsf.entity.WorkingTimeEntity;

import javax.ejb.EJB;
import java.util.List;

/**
 * Created by Alexandre NGUYEN on 14/10/2014.
 */
public class WorkingTimeService {

    @EJB
    private WorkingTimeDao workingTimeDao;

    public void addWorkingTime(WorkingTimeEntity workingTimeEntity) {
        workingTimeDao.addWorkingTime(workingTimeEntity);
    }

    public List<WorkingTimeEntity> getAllWorkingTimes() {
        return workingTimeDao.getAllWorkingTimes();
    }
}
