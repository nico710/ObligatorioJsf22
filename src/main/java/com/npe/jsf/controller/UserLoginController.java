package com.npe.jsf.controller;

import com.npe.jsf.dataType.User;
import java.io.Serializable;
import java.util.Map;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import org.apache.deltaspike.core.api.scope.ViewAccessScoped;

/**
 *
 * @author NicolasP1
 */

@Named("viewAccessControllerDS")
@ViewAccessScoped
public class UserLoginController
    implements Serializable
{

    private ManagerController manager;
    private static final long serialVersionUID = 1L;
    private String username;
    private String password;
    private User userView;

    public UserLoginController()
    {
    }

    public void init()
    {
        System.out.println("DENTRO DEL init()...");
        username = "";
        password = "";
    }

    public String getUsername()
    {
        return username;
    }

    public String getPassword()
    {
        return password;
    }

    public void setUsername(String username)
    {
        this.username = username;
    }

    public void setPassword(String password)
    {
        this.password = password;
    }

    public User getUserView()
    {
        return userView;
    }

    public void setUserView(User userView)
    {
        this.userView = userView;
    }

    public String loginUser()
    {
        System.out.println("verifico usuario: ");
        Map<String, User> users = manager.getUsers();
        Map<String, User> userOnline = manager.getUserOnline();
       
        if(users == null)
        {
            FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error al cargar Usuarios del sistema", "1");
            FacesContext.getCurrentInstance().addMessage(null, msg);
            return "";
        }
        User user = users.get(username);
        
        if(user != null && user.getPassword().trim().equalsIgnoreCase(password.trim()))
        {
            if(userOnline.get(username) == null)
            {
                manager.addUserOnline(user);
                userView = user;
                return "views/menu?faces-redirect=true";
            } else
            {
                FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Usuario ya logueado en el Sistema", "1");
                FacesContext.getCurrentInstance().addMessage(null, msg);
                return "";
            }
        } else
        {
            FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error en Usuario o Password", "1");
            FacesContext.getCurrentInstance().addMessage(null, msg);
            return "";
        }
    }

    public void logout()
    {
        manager.removeUserOnline(userView.getCI());
    }
}
