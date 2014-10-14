package com.supinfo.hellojsf.dao.jpa;

import com.supinfo.hellojsf.dao.ClientDao;
import com.supinfo.hellojsf.entity.ClientEntity;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

/**
 * Created by Alexandre NGUYEN on 14/10/2014.
 */

@Stateless
public class ClientDaoJpa implements ClientDao {

    @PersistenceContext
    private EntityManager em;

    @Override
    public void addClient(ClientEntity clientEntity) {
        em.persist(clientEntity);
    }

    @Override
    public List<ClientEntity> getAllClients() {

        Query query = em.createQuery("SELECT c FROM ClientEntity c ORDER BY c.id DESC");

        List<ClientEntity> clientEntities = query.getResultList();

        return clientEntities;
    }
}
