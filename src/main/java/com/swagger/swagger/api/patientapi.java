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
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.swagger.swagger.repository.patientRepository;


/**
 *
 * @author root
 */
@RestController
@RequestMapping("/patient")
@Api(value = "Patient microservice")
public class patientapi {
    
    @Autowired
    patientRepository pr;   
    
    /**
     *
     * @return
     */
    @GetMapping("/getpatients")
    @ApiOperation(value = "Get all patients", notes = "Get all patients in db")
    public List<patient> getpatients(){
        //System.out.println("in getpatients");
        return pr.findAll();
    }
    
    /**
     *
     * @param nodocument
     * @return
     */
    @PostMapping("/getpatient")
    @ApiOperation(value = "Get an patient", notes = "Get an patient by nodocument")
    public patient getpatient(@RequestParam(value="nodocument") Long nodocument){
        System.out.println("in getpatient");
        return pr.findByNoDocument(nodocument).get();
    }
    
    /**
     *
     * @param patient
     * @return
     */
    @PostMapping("/insertpatient")
    @ApiOperation(value = "Insert an patient", notes = "Insert an patient to db")
    public patient inserobject(@RequestBody patient patient){
        System.out.println("in inserobject");
        pr.save(patient);
        return patient;
    }
    
    /**
     *
     * @param patient
     * @return
     */
    @PutMapping("/updateobject")
    @ApiOperation(value = "Update an patient", notes = "Update an patient with nodocument")
    public patient updateobject(@RequestBody patient patient){
        System.out.println("in updateobject");
        pr.findByNoDocument(patient.getNoDocument()).map(ptn->{
            ptn.setPatient(patient);
            pr.save(ptn);
            return patient;
        });
        return patient;
    }
    
    /**
     *
     * @param nodocument
     * @return
     *
    @DeleteMapping("/deleteobject")
    @ApiOperation(value = "Delete an object", notes = "Delete an object by id")
    public String deleteobject(@RequestParam(value="id") Long id){
        System.out.println("in deleteobject");
        or.deleteById(id);
        return "Object with id "+id+" was remove";
    }*/
    
    
}
