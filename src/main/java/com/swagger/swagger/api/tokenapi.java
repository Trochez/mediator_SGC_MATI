/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.swagger.swagger.api;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author JuanDiego
 */
@RestController
@RequestMapping("/")
@Api(value = "token microservice")
public class tokenapi {
    
    /**
     *
     * @return
     */
    @GetMapping("/loaderio-8703846326135f1902b511cad078c994/")
    @ApiOperation(value = "loader.io token", notes = "get loader.io token")
    public String gettoken(){
        System.out.println("in gettoken");
        return "loaderio-8703846326135f1902b511cad078c994";
    }
    
}
