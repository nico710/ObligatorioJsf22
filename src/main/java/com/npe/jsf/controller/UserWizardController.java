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
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
import org.apache.deltaspike.core.api.scope.ViewAccessScoped;
import org.primefaces.event.FileUploadEvent;
import org.primefaces.event.FlowEvent;


/**
 *
 * @author NicolasP1
 */
@Named("userWizardController")
@ViewAccessScoped
public class UserWizardController implements Serializable{
    
    @Inject
    private ManagerController manager;
    
    private User selectedUser;    
    
    private User user = new User();
    
    private List<User> usersSystem;
    
    //private UploadedFile file;
             
    private boolean skip;
    
    @PostConstruct
    public void init() {
       System.out.println("1----DENTRO 5555 UserWizardController.init()..."); 
       usersSystem = updateUsersSystem();
       skip = false;
       
    }
    // Geters and Setters ------------------------------------------------------
    
    public User getSelectedUser() {
        return selectedUser;
    }

    public void setSelectedUser(User selectedUser) {
        this.selectedUser = selectedUser;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
   
    public boolean isSkip() {
        return skip;
    }
 
    public void setSkip(boolean skip) {
        this.skip = skip;
    }

    public List<User> getUsersSystem() {
        return usersSystem;
    }

    public void setUsersSystem(List<User> usersSystem) {
        this.usersSystem = usersSystem;
    }
    
    
    // Actions -----------------------------------------------------------------
    
    public void save() {        
        FacesMessage msg = new FacesMessage("Successful", "Welcome :" + user.getName());
        FacesContext.getCurrentInstance().addMessage(null, msg);
    }
     
    public String onFlowProcess(FlowEvent event) {
     /*   if(skip) {
            skip = false;   //reset in case user goes back
            return "confirm";
        }
        else {
            return event.getNewStep();
        }*/
        
        return event.getNewStep();
    }
    
    public void handleFileUpload(FileUploadEvent event) {
        
        System.out.println("FileName(): "+event.getFile().getFileName()); 
        /*event.getFile().getFileName();
        FacesMessage message = new FacesMessage("Succesful", event.getFile().getFileName() + " is uploaded.");
        FacesContext.getCurrentInstance().addMessage(null, message);*/
    }
    
    
    public List<User> updateUsersSystem(){
        List<User> list = new ArrayList<User>();
        Map<String, User> userOnline = manager.getUsers();
        Iterator it = userOnline.keySet().iterator();
        
        while(it.hasNext()){
            String key = (String) it.next();
            list.add(userOnline.get(key));
        }        
        return list;
    }
    
    public void update(){
        System.out.println("update()...");
        System.out.println("update()..." + selectedUser);
        usersSystem = updateUsersSystem();
    }
    
     public void delete(){
        System.out.println("delete()...");
        System.out.println("delete()..." + selectedUser);
        manager.removeUserToSystem(selectedUser.getCI());
        manager.removeUserOnline(selectedUser.getCI());        
        usersSystem = updateUsersSystem();
    }
    
}
