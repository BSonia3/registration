/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.registrationLogin.service;

import com.example.registrationLogin.model.Message;
import com.example.registrationLogin.repository.MessageRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author sonia
 */
@Service
@Transactional
public class MessageService  {
    
 @Autowired
 MessageRepository repository;
 
 public List<Message> getAllMessages()
    {
       return repository.findAll();
   
    }

    public void saveMessage(Message m) {
       repository.save(m);
    }
    
    public Message getMessage(long id) {
        return repository.findById(id).get();
    }
     
    public void deleteMessage(long id) {
        repository.deleteById(id);
    }
 
    
}
