package com.amit.User_Group_Role.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.amit.User_Group_Role.Model.GroupModel;
import com.amit.User_Group_Role.services.GroupServices;

@RestController
@RequestMapping("/group")
public class GroupController {

    @Autowired
    GroupServices groupServices;
    

    @PostMapping("/addGroup")
    public ResponseEntity<?> addGroup(@RequestBody GroupModel group)
    {
        String response = groupServices.addGroup(group);


        return ResponseEntity.ok(response);
    }
}
