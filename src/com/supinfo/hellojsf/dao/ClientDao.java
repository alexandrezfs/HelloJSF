package com.supinfo.hellojsf.dao;

import com.supinfo.hellojsf.entity.ClientEntity;

import javax.ejb.Local;
import java.util.List;

/**
 * Created by Alexandre NGUYEN on 14/10/2014.
 */

@Local
public interface ClientDao {

    public void addClient(ClientEntity clientEntity);
    public List<ClientEntity> getAllClients();
    public ClientEntity getClientById(long ig);
}
