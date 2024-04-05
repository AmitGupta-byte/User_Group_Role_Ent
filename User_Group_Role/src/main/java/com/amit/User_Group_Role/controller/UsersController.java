package com.amit.User_Group_Role.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.amit.User_Group_Role.Model.UsersModel;
import com.amit.User_Group_Role.Repositories.UserRepository;
import com.amit.User_Group_Role.services.UserServices;

@RestController

public class UsersController {

	@Autowired
	UserRepository userRepository;

	@Autowired
	UserServices userServices;

	@PostMapping("/addUser")
	public ResponseEntity<?> addUser(@RequestBody UsersModel user) {

		String ResponseMessage = null;

		if (userRepository.existsByUserId(user.getUserId())) {
			return ResponseEntity.badRequest().body("Error: Username is already taken/ not Found.!");
		}

		ResponseMessage = userServices.addUser(user);

		return ResponseEntity.ok(ResponseMessage);
	}

	@GetMapping("/getUsers")
	public ResponseEntity<?> getUsersList() {

		String ResponseMessage = userServices.getUsers();

		return ResponseEntity.ok(ResponseMessage);

	}

	@PostMapping("/updateUser")
	public ResponseEntity<?> updateUser(@RequestBody UsersModel user) {
		String ResponseMeaage = userServices.updateUser(user);

		return ResponseEntity.ok(ResponseMeaage);

	}

	
	@DeleteMapping("/deleteUser")
	public ResponseEntity<?> deleteUser(@RequestBody UsersModel user) {

		String ResponseMessage = userServices.deleteUser(user);

		return ResponseEntity.ok(ResponseMessage);
	}
}
