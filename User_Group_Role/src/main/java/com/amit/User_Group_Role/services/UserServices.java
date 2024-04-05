package com.amit.User_Group_Role.services;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.amit.User_Group_Role.Model.UsersModel;
import com.amit.User_Group_Role.Repositories.UserRepository;
import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

@Service
public class UserServices {

	@Autowired
	UserRepository userRepository;

	public String addUser(UsersModel user) {

		String responseJson = "";
		String ResponseCode = "";
		String ResponseMessage = "";
		String password = "";
		UsersModel dbUser = null;

		try {
			if (user.getUserId() == null || user.getUserId().isEmpty() == true) {
				ResponseCode = "-1";
				ResponseMessage = "Invalid Or Empty email";
				throw new Exception(ResponseMessage + "(" + ResponseCode + ") ");

			}

			if (user.getPassword() == null || user.getPassword().isEmpty() == true) {
				ResponseCode = "-2";
				ResponseMessage = "Invalid Or Empty password";
				throw new Exception(ResponseMessage + "(" + ResponseCode + ") ");
			}

			if (user.getName() == null || user.getName().isEmpty() == true) {
				ResponseCode = "-3";
				ResponseMessage = "Invalid Or Empty name";
				throw new Exception(ResponseMessage + "(" + ResponseCode + ") ");
			}

			if (user.getMobileNumber() == null || user.getMobileNumber().isEmpty() == true) {
				ResponseCode = "-3";
				ResponseMessage = "Invalid Or Empty MobileNumber";
				throw new Exception(ResponseMessage + "(" + ResponseCode + ") ");
			}

			if (!user.getPassword().equalsIgnoreCase(user.getPassword())) {
				ResponseCode = "-5";
				ResponseMessage = "Confirm password not matched.!!!";
				throw new Exception(ResponseMessage + "(" + ResponseCode + ") ");
			}

			password = user.getPassword();

			Map<String, Object> condition = new HashMap<String, Object>();
			condition.put("UserId", user.getUserId());
			UsersModel dbCustomer = userRepository.findByUserId(user.getUserId());

			if (dbCustomer != null) {
				ResponseCode = "-6";
				ResponseMessage = "User already Exists.!!!";
				throw new Exception(ResponseMessage + "(" + ResponseCode + ") ");
			}

			user.setAtDate(new Date());
			user.setLastConnectionDate(new Date());
			// user.setCustomerId(user.getCustomerId());
			user.setEmailId(user.getEmailId());
			user.setEncPwd("dsvgbfdh");
			user.setName(user.getName());
			user.setLastName(user.getLastName());
			user.setMobileNumber(user.getMobileNumber());
			user.setPassword(password);
			user.setUserId(user.getUserId());
			user.setUserStatus(user.getUserStatus());

			user = userRepository.save(user);

			if (user.getId() <= 0) {
				ResponseCode = "-7";
				ResponseMessage = "Issue in adding User.!!!";
				throw new Exception(ResponseMessage + "(" + ResponseCode + ") ");
			}

			String customerIdNew = "cus100" + user.getId();
			dbUser = userRepository.getReferenceById(user.getId());
			dbUser.setCustomerId(customerIdNew);
			userRepository.save(dbUser);

		} catch (Exception e) {

			ResponseCode = "-10";
			ResponseMessage = e.getMessage();

		}

		finally {
			Gson mgson = new Gson();

			JsonObject JsonObj = new JsonObject();

			JsonObj.addProperty("ResponseCode", ResponseCode);
			JsonObj.addProperty("ResponseMessage", ResponseMessage);

			JsonElement resultlist_JsonElement = mgson.toJsonTree(user);
			JsonObj.add("User", resultlist_JsonElement);
			responseJson = mgson.toJson(JsonObj);
		}

		return responseJson;
	}

	public String getUsers() {

		String responseJson = "";
		String responseMessage = "";
		String responseCode = "";
		List<UsersModel> user = null;

		try {
			user = userRepository.findAll();

			if (user.isEmpty()) {
				responseCode = "-1";
				responseMessage = "No User Available";
				throw new Exception(responseMessage + "(" + responseCode + ") ");
			}

			responseCode = "1";
			responseMessage = "Successful";

		} catch (Exception e) {

			System.out.println(e.getMessage());

		} finally {
			Gson agson = new Gson();
			JsonObject jsonObj = new JsonObject();
			jsonObj.addProperty("responseMessage", responseMessage);
			jsonObj.addProperty("responseCode", responseCode);

			JsonElement responseList = agson.toJsonTree(user);
			jsonObj.add("Users", responseList);

			responseJson = agson.toJson(jsonObj);

		}

		return responseJson;

	}

	public String updateUser(UsersModel user) {
		String responseJson = "";
		String responseMessage = "";
		String responseCode = "";

		try {
			if (user.getCustomerId() == null || user.getCustomerId().isEmpty()) {
				responseMessage = "please provide the customerId";
				responseCode = "-1";
				throw new Exception(responseMessage + "(" + responseCode + ") ");
			}

			UsersModel dbUser = userRepository.findByCustomerId(user.getCustomerId());

			if (dbUser == null) {
				responseMessage = "No User Available for given customerId";
				responseCode = "-2";
				throw new Exception(responseMessage + "(" + responseCode + ") ");
			}

			user.setId(dbUser.getId());
			user.setCustomerId(dbUser.getCustomerId());
			user.setAtDate(new Date());

			user = userRepository.save(user);

			if (user.getId() <= 0) {
				responseCode = "-5";
				responseMessage = "User not update.!!!";
				throw new Exception(responseMessage + "(" + responseCode + ") ");
			}

			responseCode = "1";
			responseMessage = "User Updated Successfully";

		} catch (Exception e) {

			System.out.println(e.getMessage());

		} finally {
			Gson agson = new Gson();

			JsonObject obj = new JsonObject();
			obj.addProperty("responseMessage", responseMessage);
			obj.addProperty("responseCode", responseCode);
			JsonElement resultUser = agson.toJsonTree(user);
			obj.add("User", resultUser);

			responseJson = agson.toJson(obj);

		}

		return responseJson;
	}

	public String deleteUser(UsersModel user) {

		String responseJson = "";
		String responseCode = "";
		String responseMessage = "";
		UsersModel dbUser = null;

		try {
			if (user.getCustomerId() == null || user.getCustomerId().isEmpty()) {
				responseMessage = "provide the customerId";
				responseCode = "-1";
				throw new Exception(responseMessage + "(" + responseCode + ")");
			}

			if (user.getUserId() == null || user.getUserId().isEmpty()) {
				responseMessage = "provide the UserId";
				responseCode = "-2";
				throw new Exception(responseMessage + "(" + responseCode + ")");
			}
			if (user.getPassword() == null || user.getPassword().isEmpty()) {
				responseMessage = "provide the Password";
				responseCode = "-3";
				throw new Exception(responseMessage + "(" + responseCode + ")");
			}
			
			dbUser = userRepository.findByCustomerId(user.getCustomerId());
			
			
			if(dbUser == null) {
				responseMessage = "User Not Found";
				responseCode = "-7";
				throw new Exception(responseMessage + "(" + responseCode + ")");
			}

			if (!dbUser.getPassword().equalsIgnoreCase(user.getPassword())) {
				responseMessage = "Password not matched";
				responseCode = "-4";
				System.out.println(user.getPassword());
				throw new Exception(responseMessage + "(" + responseCode + ")");
			}
			
			userRepository.deleteById(dbUser.getId());
			
			if (dbUser.getId() <= 0) {
				responseCode = "-5";
				responseMessage = "User not deleted.!!!";
				throw new Exception(responseMessage + "(" + responseCode + ") ");
			}
			
			responseCode = "1";
			responseMessage = "Successfully User deleted.";
		} catch (Exception e) {
			System.out.println(e.getMessage());
			responseMessage = e.getMessage();
			responseCode = "-6";
		} finally {
			Gson agson = new Gson();
			JsonObject jsonObj = new JsonObject();
			jsonObj.addProperty("responseMessage", responseMessage);
			jsonObj.addProperty("responseCode", responseCode);

			responseJson = agson.toJson(jsonObj);
			

		}
		return responseJson;
	}

}
