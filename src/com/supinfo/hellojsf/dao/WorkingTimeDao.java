package com.supinfo.hellojsf.dao;

import com.supinfo.hellojsf.entity.WorkingTimeEntity;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

/**
 * Created by Alexandre NGUYEN on 14/10/2014.
 */
public interface WorkingTimeDao {

    public void addWorkingTime(WorkingTimeEntity workingTimeEntity);
    public List<WorkingTimeEntity> getAllWorkingTimes();
}
