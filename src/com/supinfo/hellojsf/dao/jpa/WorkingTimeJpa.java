package com.supinfo.hellojsf.dao.jpa;

import com.supinfo.hellojsf.dao.WorkingTimeDao;
import com.supinfo.hellojsf.entity.ClientEntity;
import com.supinfo.hellojsf.entity.WorkingTimeEntity;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

/**
 * Created by Alexandre NGUYEN on 14/10/2014.
 */

@Stateless
public class WorkingTimeJpa implements WorkingTimeDao {

    @PersistenceContext
    private EntityManager em;

    @Override
    public void addWorkingTime(WorkingTimeEntity workingTimeEntity) {
        em.persist(workingTimeEntity);
    }

    @Override
    public List<WorkingTimeEntity> getAllWorkingTimes() {
        Query query = em.createQuery("SELECT w FROM WorkingTimeEntity w ORDER BY w.id DESC");

        return query.getResultList();
    }

    @Override
    public void removeWorkingTime(int id) {
        int deletedCount = em.createQuery("DELETE FROM WorkingTimeEntity w WHERE id = " + id).executeUpdate();
    }
}