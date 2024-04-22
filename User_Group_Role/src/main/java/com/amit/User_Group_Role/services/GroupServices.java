package com.amit.User_Group_Role.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.amit.User_Group_Role.Model.GroupModel;
import com.amit.User_Group_Role.Repositories.GroupRepository;
import com.amit.User_Group_Role.Repositories.UserRepository;
import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

@Service
public class GroupServices {


    @Autowired
    GroupRepository groupRepository;

    @Autowired
	UserRepository userRepository;

    public String addGroup(GroupModel group){

        String responseCode = null;
        String responseMessage = null;
        String responseJson = null;
        GroupModel dbGroup = null;

        try{
            

            if(group.getGroupName() == null || group.getGroupName().isEmpty()){
                responseCode="-2";
                responseMessage = "please provide the Group name";
                throw new Exception(responseCode+responseMessage);
            }

            if(group.getDescription() == null || group.getDescription().isEmpty()){
                responseCode="-3";
                responseMessage = "please provide the Group Description";
                throw new Exception(responseCode+responseMessage);
            }

            if (!userRepository.existsByCustomerId(group.getCreatedBy())){
				responseMessage = "No Such User Found";
				responseCode = "-4";
				throw new Exception(responseMessage + responseCode);
			}

            if(groupRepository.existsByGroupNameAndCreatedBy(group.getGroupName(), group.getCreatedBy())){
                responseMessage = "Group Already Exists";
				responseCode = "-5";
				throw new Exception(responseMessage + responseCode);
            }

            group.setCreatedBy(group.getCreatedBy());
            group.setDescription(group.getDescription());
            group.setGroupName(group.getGroupName());


            group = groupRepository.save(group);

            if (group.getId() <= 0) {
				responseCode = "-7";
				responseMessage = "Issue in adding User.!!!";
				throw new Exception(responseMessage + "(" + responseCode + ") ");
			}


            String newGroupID =  "Grp"+group.getId();
            dbGroup = groupRepository.getReferenceById(group.getId());
            dbGroup.setGroupId(newGroupID);
            groupRepository.save(dbGroup);

        }catch(Exception e){
            responseCode = "-10";
            responseMessage = e.getMessage();

        }finally{
            Gson agson = new Gson();
            JsonObject obj = new JsonObject();
            obj.addProperty("responseCode", responseCode);
            obj.addProperty("responseMessage", responseMessage);
            JsonElement body = agson.toJsonTree(group);
            obj.add("Group" , body);
            responseJson = agson.toJson(obj);

        }

       

        return responseJson;
    }
    
}
