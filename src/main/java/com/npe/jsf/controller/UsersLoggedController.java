/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.npe.jsf.controller;

import com.npe.jsf.dataType.User;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import javax.annotation.PostConstruct;
import javax.inject.Inject;
import javax.inject.Named;
import org.apache.deltaspike.core.api.scope.ViewAccessScoped;

/**
 *
 * @author NicolasP1
 */
@Named("usersLoggedController")
@ViewAccessScoped
public class UsersLoggedController implements Serializable{
    
    @Inject
    private ManagerController manager;
    
    private List<User> usersLogged;
    
    private User selectedUser;

    @PostConstruct
    public void init() {
        System.out.println("1----DENTRO DEL usersLoggedController.init()...");
        
        usersLogged = updateUsersLogged();
       
    }

    public List<User> getUsersLogged() {
        return usersLogged;
    }

    public void setUsersLogged(List<User> usersLogged) {
        this.usersLogged = usersLogged;
    }
    
    public User getSelectedUser() {
        return selectedUser;
    }

    public void setSelectedUser(User selectedUser) {
        this.selectedUser = selectedUser;
    }
    
    public List<User> updateUsersLogged(){
        List<User> list = new ArrayList<User>();
        Map<String, User> userOnline = manager.getUserOnline();
        Iterator it = userOnline.keySet().iterator();
        
        while(it.hasNext()){
            String key = (String) it.next();
            System.out.println("Clave: " + key + " -> Valor: " + userOnline.get(key));
            
            list.add(userOnline.get(key));
        }        
        return list;
    }
    
    
}
