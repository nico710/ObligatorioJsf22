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
    
    @Inject
    private UserController userSession;
    
    private User selectedUser;    
    
    private User user = new User();
    
    private List<User> usersSystem;
    
    private long operation;//add=1 - edit=2 - delete=3
    
    //private UploadedFile file;
             
    private boolean skip;
    
    @PostConstruct
    public void init() {
       System.out.println("1----DENTRO 5555 UserWizardController.init()..."); 
       usersSystem = updateUsersSystem();
       skip = false;
       operation = 1;
       
    }
    // Geters and Setters ------------------------------------------------------

    public long getOperation() {
        return operation;
    }

    public void setOperation(long operation) {
        this.operation = operation;
    }
    
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
        System.out.println("Usuario.rol(): "+userSession.getUserView().getRol());
        
        //Si el usuario logeado tiene rol Admin, cargo todos, sino cargo solo el uruario logeado
        if(userSession.getUserView().getRol().equalsIgnoreCase("ADMINISTRADOR")){
            Map<String, User> userOnline = manager.getUsers();
            Iterator it = userOnline.keySet().iterator();
        
            while(it.hasNext()){
                String key = (String) it.next();
                list.add(userOnline.get(key));
            }        
        }else{
            list.add(userSession.getUserView());
        }
        
        
        return list;
    }
    
    public void add(){
        System.out.println("add()...");
        operation = 1;
        user = new User();
    }
    
    public void update(){        
        System.out.println("update()...");
        System.out.println("update()..." + selectedUser.getNickName());
        operation = 2;
        usersSystem = updateUsersSystem();
        
        user = selectedUser;
    }
    
     public void delete(){
        System.out.println("delete()...");
        System.out.println("delete()..." + selectedUser);
        operation = 1;//3
        manager.removeUserToSystem(selectedUser.getNickName());
        manager.removeUserOnline(selectedUser.getNickName());        
        usersSystem = updateUsersSystem();
    }
     
      public void save() {  
        if(operation == 1){//add
            manager.addUserToSystem(user);
            
        }else if(operation == 2){//edit
            manager.replaceUser(user);
        }  
        usersSystem = updateUsersSystem();  
        FacesMessage msg = new FacesMessage("Successful", " : " + user.getName());
        FacesContext.getCurrentInstance().addMessage(null, msg);
    }
      
    public boolean allowEditPassword(){
        if(operation == 1){
            return false;
        }
        return !userSession.getUserView().getNickName().equalsIgnoreCase(selectedUser.getNickName()) || !selectedUser.getRol().equalsIgnoreCase("ADMINISTRADOR");
    }
}
