package com.amit.User_Group_Role.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.amit.User_Group_Role.Model.RolePojo;
import com.amit.User_Group_Role.Repositories.RoleRepository;

@Service
public class RoleServices {
	
	@Autowired
	RoleRepository roleRepository;
	
	public String addRole(RolePojo role){
		String responseMessage= "";
		String responseCode = "";
		String responseJson ="";
		
		try {
			if(role.getRoleName() == null || role.getRoleName().isEmpty()) {
				 responseMessage= "Provide the role name";
				 responseCode = "-1";
				 throw new Exception(responseMessage + responseCode);
			}
			
			if(role.getPermissions() == null || role.getPermissions().isEmpty()) {
				 responseMessage= "Provide the Permissions";
				 responseCode = "-2";
				 throw new Exception(responseMessage + responseCode);
			}
			
			role.setRoleName(role.getRoleName());
			role.setPermissions(role.getPermissions());
			
			role = roleRepository.save(role);
			
		}catch(Exception e){
			 responseMessage= e.getMessage();
			 responseCode = "-10";
			
		}
		
		
		
		return "";
	}

}
