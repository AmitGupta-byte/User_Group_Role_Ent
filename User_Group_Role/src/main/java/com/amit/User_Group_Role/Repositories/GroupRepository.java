package com.amit.User_Group_Role.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.amit.User_Group_Role.Model.GroupModel;

@Repository
public interface GroupRepository  extends JpaRepository<GroupModel, Long>{

    public GroupModel findByGroupId(String id);
    public GroupModel findByGroupNameAndCreatedBy(String name, String createdBy);

    public boolean existsByGroupNameAndCreatedBy(String name, String createdBy);
}
