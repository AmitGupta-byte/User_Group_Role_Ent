package com.amit.User_Group_Role.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.amit.User_Group_Role.Model.RolePojo;
import com.amit.User_Group_Role.services.RoleServices;

@RestController
@RequestMapping("/role")
public class RoleController {
    @Autowired
    RoleServices roleservice;


@PostMapping("/addRole")
    public ResponseEntity<?> addRole(@RequestBody RolePojo role)
    {
        String response = roleservice.addRole(role);
        return ResponseEntity.ok(response);


    }


}
