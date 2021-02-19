/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.swagger.swagger.repository;

import com.swagger.swagger.entity.patient;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author root
 */
public interface patientRepository extends JpaRepository<patient,Long>{
    
    Optional<patient> findByNoDocument(Long nodocument);
    
}
