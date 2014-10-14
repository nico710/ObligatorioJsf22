package com.npe.jsf.controller;

import com.npe.jsf.dataType.User;
import java.io.PrintStream;
import java.io.Serializable;
import java.util.*;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

// Referenced classes of package com.npe.jsf.controller:
//            ManagerController

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
        Map users = manager.getUsers();
        Map userOnline = manager.getUserOnline();
        String key;
        for(Iterator it = userOnline.keySet().iterator(); it.hasNext(); System.out.println((new StringBuilder()).append("Clave-: ").append(key).append(" -> Valor-: ").append(userOnline.get(key)).toString()))
        {
            key = (String)it.next();
        }

        System.out.println((new StringBuilder()).append("username-: ").append(username).toString());
        System.out.println((new StringBuilder()).append("paswword_: ").append(password).toString());
        System.out.println((new StringBuilder()).append("users: ").append(users).toString());
        System.out.println((new StringBuilder()).append("userOnline: ").append(userOnline).toString());
        if(users == null)
        {
            FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error al cargar Usuarios del sistema", "1");
            FacesContext.getCurrentInstance().addMessage(null, msg);
            return "";
        }
        User user = (User)users.get(username);
        System.out.println((new StringBuilder()).append("user: ").append(user).toString());
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
        System.out.println((new StringBuilder()).append("session.logout()-: ").append(userView.getCI()).toString());
        manager.removeUserOnline(userView.getCI());
    }
}
