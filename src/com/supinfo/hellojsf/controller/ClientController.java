package com.supinfo.hellojsf.controller;

import com.supinfo.hellojsf.entity.ClientEntity;
import com.supinfo.hellojsf.service.ClientService;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.faces.model.ArrayDataModel;
import javax.faces.model.DataModel;
import java.io.IOException;
import java.io.Serializable;
import java.util.List;

/**
 * Created by Alexandre NGUYEN on 14/10/2014.
 */

@ManagedBean
public class ClientController implements Serializable {

    @EJB
    private ClientService clientService;

    private ClientEntity clientToAdd = new ClientEntity();

    private DataModel<ClientEntity> clientEntityDataModel;

    @PostConstruct
    public void init() {

        List<ClientEntity> clientEntitiesList = clientService.getAllClients();
        ClientEntity[] clientEntitiesArray = new ClientEntity[clientEntitiesList.size()];
        clientEntitiesList.toArray(clientEntitiesArray);

        clientEntityDataModel = new ArrayDataModel<ClientEntity>(clientEntitiesArray);
    }

    public void addClient() {

        ExternalContext eC = FacesContext.getCurrentInstance().getExternalContext();

        clientService.addClient(clientToAdd);

        redirectAfterAdding(eC, "manager_home.xhtml");
    }

    private void redirectAfterAdding(ExternalContext eC, String page) {
        try {
            eC.redirect(eC.getRequestContextPath() + "/" + page);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public DataModel<ClientEntity> getClientEntityDataModel() {
        return clientEntityDataModel;
    }

    public void setClientEntityDataModel(DataModel<ClientEntity> clientEntityDataModel) {
        this.clientEntityDataModel = clientEntityDataModel;
    }

    public ClientEntity getClientToAdd() {
        return clientToAdd;
    }

    public void setClientToAdd(ClientEntity clientToAdd) {
        this.clientToAdd = clientToAdd;
    }


}
