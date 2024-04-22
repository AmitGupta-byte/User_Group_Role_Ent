package com.amit.User_Group_Role.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.amit.User_Group_Role.Model.RolePojo;

public interface RoleRepository extends JpaRepository<RolePojo, Long> {

    public RolePojo findByRoleNameAndCreatedBy(String name, String createdBy);

    public boolean existsByRoleNameAndCreatedBy(String name, String createdBy);

}
