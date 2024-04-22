package com.amit.User_Group_Role.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.amit.User_Group_Role.Model.RolePojo;
import com.amit.User_Group_Role.Repositories.RoleRepository;
import com.amit.User_Group_Role.Repositories.UserRepository;
import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

@Service
public class RoleServices {

	@Autowired
	RoleRepository roleRepository;

	@Autowired
	UserRepository userRepository;

	public String addRole(RolePojo role) {
		String responseMessage = "";
		String responseCode = "";
		String responseJson = "";
		RolePojo dbRole = null;

		try {
			if (role.getRoleName() == null || role.getRoleName().isEmpty()) {
				responseMessage = "Provide the role name";
				responseCode = "-1";
				throw new Exception(responseMessage + responseCode);
			}

			if (role.getPermissions() == null || role.getPermissions().isEmpty()) {
				responseMessage = "Provide the Permissions";
				responseCode = "-2";
				throw new Exception(responseMessage + responseCode);
			}

			if (role.getCreatedBy() == null || role.getCreatedBy().isEmpty()) {
				responseMessage = "Provide the CreatedBy";
				responseCode = "-3";
				throw new Exception(responseMessage + responseCode);
			}

			if (!userRepository.existsByCustomerId(role.getCreatedBy())){
				responseMessage = "No Such User Found";
				responseCode = "-4";
				throw new Exception(responseMessage + responseCode);
			}

			role.setRoleName(role.getRoleName());
			role.setPermissions(role.getPermissions());
			role.setCreatedBy(role.getCreatedBy());;

			role = roleRepository.save(role);

			if(role.getId() <=0){
				responseMessage = "Error While Adding the Role";
				responseCode = "-5";
				throw new Exception(responseMessage + responseCode);
			}

			String NewRoleId ="Role"+role.getId();
			dbRole = roleRepository.getReferenceById(role.getId());
			dbRole.setRoleId(NewRoleId);
			roleRepository.save(dbRole);



		} catch (Exception e) {
			responseMessage = e.getMessage();
			responseCode = "-10";

		} finally {
			Gson agson = new Gson();
			JsonObject obj = new JsonObject();
			obj.addProperty("responseCode", responseCode);
			obj.addProperty("responseMessage", responseMessage);

			JsonElement body = agson.toJsonTree(role);

			obj.add("role", body);

			responseJson = agson.toJson(obj);

		}

		return responseJson;
	}

}
