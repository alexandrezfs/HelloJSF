package com.supinfo.hellojsf.dao.jpa;

import com.supinfo.hellojsf.dao.UserDao;
import com.supinfo.hellojsf.entity.EmployeeEntity;
import com.supinfo.hellojsf.entity.UserEntity;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.Date;
import java.util.List;

/**
 * Created by Alexandre NGUYEN on 14/10/2014.
 */

@Stateless
public class UserDaoJpa implements UserDao {

    @PersistenceContext
    private EntityManager em;

    @Override
    public void addUser(UserEntity userEntity) {
        em.persist(userEntity);
    }

    @Override
    public UserEntity getUserById(int id) {
        return em.find(UserEntity.class, id);
    }

    @Override
    public Object getUserByUsernamePassword(String username, String password) {

        Query query = em.createQuery("SELECT u FROM UserEntity u WHERE u.username = :username AND u.password = :password");
        query.setParameter("username", username);
        query.setParameter("password", password);
        query.setMaxResults(1);

        try {
            Object obj = query.getSingleResult();
            System.out.println(obj.getClass().toString() + "TATATATA");
            return obj;
        }
        catch (NoResultException exception) {
            exception.printStackTrace();
            return null;
        }

    }

    @Override
    public List<EmployeeEntity> getAllEmployees() {

        Query query = em.createQuery("SELECT e FROM EmployeeEntity e ORDER BY e.id DESC");

        List<EmployeeEntity> employeeEntities = query.getResultList();

        return employeeEntities;
    }
}
