/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.registrationLogin.service;

import com.example.registrationLogin.model.User;
import java.util.List;

/**
 *
 * @author sonia
 */
public interface UserService {
    
    void save(User user);

    User findByUsername(String username); 
    
    List<User> getAllUsers();
    
    User getUser(long id) ;
     
    void deleteUser(long id) ;
    
}
