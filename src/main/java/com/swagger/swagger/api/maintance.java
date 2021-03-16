/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.swagger.swagger.api;

import com.swagger.swagger.entity.patient;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import java.util.List;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author trocha
 */

@RestController
@RequestMapping("/maintenance")
@Api(value = "Patient microservice")
public class maintance implements ApplicationContextAware {
    
    private ApplicationContext context;
    
    @GetMapping("")
    @ApiOperation(value = "maintenance patients application", notes = "maintenance patients application")
    public String shutdown(){
        
        ((ConfigurableApplicationContext) context).close();
        return "Closing application, bye";
        //System.out.println("in getpatients");
    }
    
    @Override
    public void setApplicationContext(ApplicationContext ctx) throws BeansException {
        this.context = ctx;
        
    }
}
