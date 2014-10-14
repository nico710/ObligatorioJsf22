/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.npe.jsf.controller;

import com.npe.jsf.dataType.User;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import javax.annotation.PostConstruct;
import javax.inject.Named;

/**
 *
 * @author NicolasP1
 */
@Named("managerController")
@javax.faces.bean.ApplicationScoped
public class ManagerController implements Serializable {
    
    Map<String,User> userOnline;
    Map<String,User> users;

    @PostConstruct
    public void init()
    {
        userOnline = new HashMap<String,User>();
        users = new HashMap<String,User>();
        
        User user = new User();
        user.setCI("1234");
        user.setPassword("admin");
        
        User user2 = new User();
        user2.setCI("5678");
        user2.setPassword("admin");
        
        User user3 = new User();
        user3.setCI("admin");
        user3.setPassword("admin");
        
        users.put(user.getCI(), user);    
        users.put(user2.getCI(), user2);
        users.put(user3.getCI(), user3);
        
        userOnline.put(user3.getCI(), user3);
    }

    public Map<String, User> getUserOnline() {
        return userOnline;
    }

    public void setUserOnline(Map<String, User> userOnline) {
        this.userOnline = userOnline;
    }

    public Map<String, User> getUsers() {
        return users;
    }

    public void setUsers(Map<String, User> users) {
        this.users = users;
    }
    
    public void addUserOnline(User user){
        userOnline.put(user.getCI(), user);
    }
    
    public void addUserToSystem(User user)
    {
        users.put(user.getCI(), user);
    }
    
    public void removeUserOnline(String user)
    {
        Iterator it = userOnline.keySet().iterator();
        while(it.hasNext()){
            String key = (String) it.next();
            System.out.println("Clave: " + key + " -> Valor: " + userOnline.get(key));
        }
        
        userOnline.remove(user);
    }
    
     public void removeUserToSystem(String user)
    {
        users.remove(user);
    }
    
    
}
