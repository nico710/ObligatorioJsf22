/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.npe.jsf.controller;

import com.npe.jsf.dataType.User;
import java.io.Serializable;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
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
        DateFormat df = new SimpleDateFormat("yyyyMMdd");
        
        try {
            User user = new User();
        user.setCI("1234");
        user.setPassword("admin");
        user.setCountry("Uruguay");
        user.setBirthday(df.parse(String.valueOf(19760317)));
        user.setSurname("Recoba");
        user.setName("Alvaro");
        user.setMail("alvaro@gmail.com");
        
        User user2 = new User();
        user2.setCI("5678");
        user2.setPassword("admin");
        user2.setCountry("EE.UU");
        user2.setBirthday(df.parse(String.valueOf(19750518)));
        user2.setSurname("Jack");
        user2.setName("Johnson");
        user2.setMail("jonhson@hotmail.com");
        
        User user3 = new User();
        user3.setCI("admin");
        user3.setPassword("admin");
        user3.setCountry("Inglaterra");
        user3.setBirthday(df.parse(String.valueOf(19450330)));
        user3.setSurname("Clapton");
        user3.setName("Eric");
        user3.setMail("clapton@yahoo.com");
        
        users.put(user.getCI(), user);    
        users.put(user2.getCI(), user2);
        users.put(user3.getCI(), user3);
        
        userOnline.put(user3.getCI(), user3);
        } catch (Exception e) {
        }
        
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
