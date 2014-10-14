/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.npe.jsf.controller;

import com.npe.jsf.dataType.User;
import java.io.Serializable;
import java.util.Map;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
import org.apache.deltaspike.core.api.scope.ViewAccessScoped;

/**
 *
 * @author NicolasP1
 */
@Named("userController")
@ViewAccessScoped
public class UserController implements Serializable {

    private static final long serialVersionUID = 1L;

    @Inject
    private ManagerController manager;

    private String username;

    private String password;

    private User userView;

    @PostConstruct
    public void init() {
        System.out.println("DENTRO DEL init()...");
        username = "";
        password = "";
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

    public User getUserView() {
        return userView;
    }

    public void setUserView(User userView) {
        this.userView = userView;
    }

    public String loginUser() {        
        Map<String, User> users = manager.getUsers();
        Map<String, User> userOnline = manager.getUserOnline();

        if (users == null) {
            FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error al cargar Usuarios del sistema", "1");
            FacesContext.getCurrentInstance().addMessage(null, msg);
            return "";
        }
        User user = users.get(username);
        System.out.println("user: "+user);
        System.out.println("user: "+user.getCI());

        if (user != null && user.getPassword().trim().equalsIgnoreCase(password.trim())) {
            if (userOnline.get(username) == null) {
                userView = user;
                manager.addUserOnline(user);
                return "views/menu?faces-redirect=true";
            } else {
                FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Usuario ya logueado en el Sistema", "1");
                FacesContext.getCurrentInstance().addMessage(null, msg);
                return "";
            }
        } else {
            FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error en Usuario o Password", "1");
            FacesContext.getCurrentInstance().addMessage(null, msg);
            return "";
        }
    }

    public void logout() {
        System.out.println("userView::: " + userView);
        manager.removeUserOnline(userView.getCI());
    }
}
