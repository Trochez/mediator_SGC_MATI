/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.swagger.swagger.api;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.swagger.swagger.entity.eventReport;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PathVariable;
import com.swagger.swagger.repository.translatorRepository;
import com.swagger.swagger.entity.translator;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import java.util.stream.Collectors;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.ws.client.core.support.WebServiceGatewaySupport;
import org.apache.http.HttpResponse;
import org.apache.http.impl.client.HttpClientBuilder;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;





/**
 *
 * @author root
 */
@RestController
@RequestMapping("/translator")
@Api(value = "translator microservice")
public class mediatorController extends WebServiceGatewaySupport {
    
    @Autowired
    translatorRepository tr;   
    
    /**
     *
     * @return
     */
    @GetMapping("/all")
    @ApiOperation(value = "Get all translators", notes = "Get all translators in db")
    public List<translator> gettranslators(){
        //System.out.println("in getpatients");
        return (List<translator>) tr.findAll();
    }
    
    /**
     *
     * @param idtranslator
     * @return
     */
    @GetMapping("/{idtranslator}")
    @ApiOperation(value = "Get an translator", notes = "Get an translator by idtranslator")
    public translator gettranslator(@PathVariable(value="idtranslator") String idtranslator){
        System.out.println("in gettranslator  ");
        return tr.findById(idtranslator).get();
    }
    
    /**
     *
     * @param translator
     * @return
     */
    @PostMapping("/")
    @ApiOperation(value = "Insert an translator", notes = "Insert an translator to db")
    public translator insertranslater(@RequestBody translator translator){
        System.out.println("in insertranslator");
        tr.save(translator);
        return translator;
    }
    
    
    
    /**
     *
     * @param idtranslator
     * @return
     */
    @DeleteMapping("/deletetranslator")
    @ApiOperation(value = "Delete an translator", notes = "Delete an translator by id")
    public String deletetranslator(@RequestParam(value="idtranslator") String idtranslator){
        System.out.println("in deletetranslator");
        tr.deleteById(idtranslator);
        return "translator with id "+idtranslator+" was remove";
    }
    
    
    
    @PostMapping(path="/receive",consumes = MediaType.ALL_VALUE)
    public eventReport saveData(@RequestHeader("id_source") String idsource,@RequestHeader("Content-Type") String contenttype,
            HttpServletRequest req, HttpServletResponse resp) {
        
        
        
        ObjectMapper mapper = new ObjectMapper();

        CloseableHttpClient client = HttpClientBuilder.create().build();
        
        
        
        try {
            HttpPost request = new HttpPost(gettranslator(idsource).getUrl());
            
            request.setHeader("Content-Type", contenttype);
            request.setEntity(new StringEntity(req.getReader().lines().collect(Collectors.joining(System.lineSeparator()))));
            HttpResponse response =  client.execute(request);
            
            
            BufferedReader bufReader = new BufferedReader(new InputStreamReader(
                response.getEntity().getContent()));

            StringBuilder builder = new StringBuilder();

            String line;

            while ((line = bufReader.readLine()) != null) {

                builder.append(line);
                builder.append(System.lineSeparator());
            }
                        
            return mapper.readValue(builder.toString(), eventReport.class);
            
        } catch (IOException ex) {
            System.err.println("ERROR  "+ ex.getMessage());
            throw new ResponseStatusException(
            HttpStatus.NOT_FOUND, "Error, source not recognizable", ex);
        }




    }
    
    @PostMapping(path="/receiveTest",consumes = MediaType.ALL_VALUE)
    public String saveDataTest(@RequestHeader("id_source") String idsource,@RequestHeader("Content-Type") String contenttype,
            HttpServletRequest req, HttpServletResponse resp) {
        
        
        return "test to get url adaptor      "+gettranslator(idsource).getUrl();

    }
    
    
    @PostMapping(path="/receivedummie")
    public String saveDataDummie(@RequestHeader("id_source") String idsource) {
        
        
        return "hello dummie      "+idsource;

    }
    
    
}
