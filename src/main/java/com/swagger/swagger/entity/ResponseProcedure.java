/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.swagger.swagger.entity;

/**
 *
 * @author root
 */
public class ResponseProcedure {
    
    String response;
    String id_source;
    
    public ResponseProcedure(String response,String id_source){
        this.response = response;
        this.id_source = id_source;
    }

    public String getResponse() {
        return response;
    }

    public void setResponse(String response) {
        this.response = response;
    }

    public String getId_source() {
        return id_source;
    }

    public void setId_source(String id_source) {
        this.id_source = id_source;
    }
    
    
    
    
    
}
