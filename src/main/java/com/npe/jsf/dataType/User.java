/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.npe.jsf.dataType;

import java.util.Date;

/**
 *
 * @author NicolasP1
 */
public class User {
    
    private String nickName;
    private String rol;
    private String name;
    private String password;
    private String surname;
    private String CI;
    private Date birthday;
    private String mail;
    private String country;
    private String pathPhoto;
    private String status;
    
    private String fatherName;
    private String motherName;
    private String fatherSurname;
    private String motherSurname;
    private Date fatherBirthday;
    private Date motherBirthday;
    
    private String companyName;
    private String addresCompany;
    private Date dateEntryCompany;
    
    private String previousCompanyName;
    private String previousAddresCompany;
    private Date previusDateEntry;

    public User() {
        this.rol = "OPERADOR";
        this.status = "ACTIVO";
    }

    public String getRol() {
        return rol;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getCI() {
        return CI;
    }

    public void setCI(String CI) {
        this.CI = CI;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getPathPhoto() {
        return pathPhoto;
    }

    public void setPathPhoto(String pathPhoto) {
        this.pathPhoto = pathPhoto;
    }

    public String getFatherName() {
        return fatherName;
    }

    public void setFatherName(String fatherName) {
        this.fatherName = fatherName;
    }

    public String getMotherName() {
        return motherName;
    }

    public void setMotherName(String motherName) {
        this.motherName = motherName;
    }

    public String getFatherSurname() {
        return fatherSurname;
    }

    public void setFatherSurname(String fatherSurname) {
        this.fatherSurname = fatherSurname;
    }

    public String getMotherSurname() {
        return motherSurname;
    }

    public void setMotherSurname(String motherSurname) {
        this.motherSurname = motherSurname;
    }

    public Date getFatherBirthday() {
        return fatherBirthday;
    }

    public void setFatherBirthday(Date fatherBirthday) {
        this.fatherBirthday = fatherBirthday;
    }

    public Date getMotherBirthday() {
        return motherBirthday;
    }

    public void setMotherBirthday(Date motherBirthday) {
        this.motherBirthday = motherBirthday;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getAddresCompany() {
        return addresCompany;
    }

    public void setAddresCompany(String addresCompany) {
        this.addresCompany = addresCompany;
    }

    public Date getDateEntryCompany() {
        return dateEntryCompany;
    }

    public void setDateEntryCompany(Date dateEntryCompany) {
        this.dateEntryCompany = dateEntryCompany;
    }

    public String getPreviousCompanyName() {
        return previousCompanyName;
    }

    public void setPreviousCompanyName(String previousCompanyName) {
        this.previousCompanyName = previousCompanyName;
    }

    public String getPreviousAddresCompany() {
        return previousAddresCompany;
    }

    public void setPreviousAddresCompany(String previousAddresCompany) {
        this.previousAddresCompany = previousAddresCompany;
    }

    public Date getPreviusDateEntry() {
        return previusDateEntry;
    }

    public void setPreviusDateEntry(Date previusDateEntry) {
        this.previusDateEntry = previusDateEntry;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

}
