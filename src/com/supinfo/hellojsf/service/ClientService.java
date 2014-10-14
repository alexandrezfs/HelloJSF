package com.supinfo.hellojsf.service;

import com.supinfo.hellojsf.dao.ClientDao;
import com.supinfo.hellojsf.entity.ClientEntity;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import java.util.List;

/**
 * Created by Alexandre NGUYEN on 14/10/2014.
 */

@Stateless
public class ClientService {

    @EJB
    private ClientDao clientDao;

    public void addClient(ClientEntity clientEntity) {
        clientDao.addClient(clientEntity);
    }

    public List<ClientEntity> getAllClients() {
        return clientDao.getAllClients();
    }
}
