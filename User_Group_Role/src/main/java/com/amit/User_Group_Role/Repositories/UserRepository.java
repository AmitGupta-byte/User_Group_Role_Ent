package com.amit.User_Group_Role.Repositories;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.amit.User_Group_Role.Model.UsersModel;

@Repository
public interface UserRepository extends JpaRepository<UsersModel, Long>{
	
public UsersModel findByUserId(String userId);
public boolean existsByUserId(String userId);
public UsersModel findByCustomerId(String customerId);

}
