package com.example.registrationLogin.service;

import com.example.registrationLogin.model.Role;
import com.example.registrationLogin.repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author sonia
 */
@Service
public class RoleServiceImp implements RoleInterface{
    @Autowired
    private RoleRepository roleRepository;
    @Override
    public void save(Role role) {
    roleRepository.save(role);
    }
    
}
