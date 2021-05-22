/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.swagger.swagger.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.data.redis.core.RedisHash;

/**
 *
 * @author JuanDiego
 */

@ApiModel("Model Patient")
@RedisHash("translater")

public class translator {
    
    @ApiModelProperty(value = "the translater's id", required = false)
    private String id;
    
    @ApiModelProperty(value = "the translater's name", required = true)
    private String name ;
    
    @ApiModelProperty(value = "the translater's type", required = true)
    private String type;
    
    @ApiModelProperty(value = "the translater's url", required = true)
    private String url;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
    
    
    public void setPatient(translator t){
        this.id = t.getId();
        this.name = t.getName();
        this.type = t.getType();
        this.url = t.getUrl();
    }
    
    
    
}
