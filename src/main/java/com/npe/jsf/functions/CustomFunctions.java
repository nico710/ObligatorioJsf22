/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.npe.jsf.functions;

/**
 *
 * @author NicolasP1
 */
public class CustomFunctions {
    
        private CustomFunctions() {
        // Hide constructor.
    }

    public static boolean isAdmin(String rol) {
        System.out.println("User Rol: " + rol);
        return "ADMINISTRADOR".equalsIgnoreCase(rol.trim());
    }
    
}
