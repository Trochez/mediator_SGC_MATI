/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.swagger.swagger.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 *
 * @author JuanDiego
 */

@ApiModel("Model Patient")
@Entity
public class patient {
    
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @ApiModelProperty(value = "the patient's id", required = false)
    private Long id;
    @ApiModelProperty(value = "the patient's NoDocument", required = true)
    private Long noDocument;
    @ApiModelProperty(value = "the patient's TypeDoc", required = true)
    private String typeDoc;
    @ApiModelProperty(value = "the patient's name", required = true)
    private String name;
    @ApiModelProperty(value = "the patient's lastname", required = true)
    private String lastname;
    @ApiModelProperty(value = "the patient's birth", required = true)
    private String birth;
    @ApiModelProperty(value = "the patient's city", required = true)
    private String city;
    @ApiModelProperty(value = "the patient's address", required = true)
    private String address;
    @ApiModelProperty(value = "the patient's tel", required = true)
    private String tel;
    @ApiModelProperty(value = "the patient's genre", required = true)
    private String genre;
    @ApiModelProperty(value = "the patient's mail", required = true)
    private String mail;
    @ApiModelProperty(value = "the patient's nameEmergency", required = true)
    private String nameEmergency;
    @ApiModelProperty(value = "the patient's telEmergency", required = true)
    private String telEmergency;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getNoDocument() {
        return noDocument;
    }

    public void setNoDocument(Long noDocument) {
        this.noDocument = noDocument;
    }

    public String getTypeDoc() {
        return typeDoc;
    }

    public void setTypeDoc(String typeDoc) {
        this.typeDoc = typeDoc;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getBirth() {
        return birth;
    }

    public void setBirth(String birth) {
        this.birth = birth;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getNameEmergency() {
        return nameEmergency;
    }

    public void setNameEmergency(String nameEmergency) {
        this.nameEmergency = nameEmergency;
    }

    public String getTelEmergency() {
        return telEmergency;
    }

    public void setTelEmergency(String telEmergency) {
        this.telEmergency = telEmergency;
    }
    
    public void setPatient(patient p){
        this.address = p.getAddress();
        this.birth = p.getBirth();
        this.city = p.getCity();
        this.genre = p.getGenre();
        this.id = p.getId();
        this.lastname= p.getLastname();
        this.mail = p.getMail();
        this.name = p.getName();
        this.nameEmergency = p.getNameEmergency();
        this.noDocument = p.getNoDocument();
        this.tel = p.getTel();
        this.telEmergency = p.getTelEmergency();
        this.typeDoc = p.getTypeDoc();
        
    }
    
    
    
}
