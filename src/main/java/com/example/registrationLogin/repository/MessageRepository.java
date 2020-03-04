/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.registrationLogin.repository;

import com.example.registrationLogin.model.Message;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author sonia
 */
@Repository
public interface MessageRepository extends JpaRepository<Message,Long>{
    
}
