package com.npe.jsf.controller;

import java.io.Serializable;
import javax.annotation.PostConstruct;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import org.apache.deltaspike.core.api.scope.ViewAccessScoped;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author NicolasP1
 */
@Named("userLoginController")
@ViewAccessScoped
public class userLoginController implements Serializable{
    
    private String username;
    private String password;

    
@PostConstruct
public void init()
{
    username ="";
    password ="";
}
    
    

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    
    public String loginUser(){        
        return "index?faces-redirect=true";
    }
            
    
    
}
