package com.amit.User_Group_Role.Model;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;

@Entity
@Table(name = "Users")
public class UsersModel {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "Id", nullable = false)
	private Long Id;


	@Column(name = "Email", nullable = true)
	private String emailId;

	@Column(name = "Password", nullable = true)
	private String password;

	@Column(name = "Name", nullable = true)
	private String name;

	@Column(name = "UserId", nullable = true)
	private String userId;

	@Column(name = "LastName", nullable = true)
	private String lastName;

	@Column(name = "MobileNumber", nullable = true)
	private String mobileNumber;

	@Column(name = "UserStatus", nullable = true)
	private String userStatus;

	@Column(name = "CustomerId", nullable = true)
	private String customerId;

	@Column(name = "AtDate", nullable = true)
	@Temporal(jakarta.persistence.TemporalType.TIMESTAMP)
	private Date atDate;
	
	@Column(name = "LastConnectionDate", nullable = true)
	@Temporal(jakarta.persistence.TemporalType.TIMESTAMP)
	private Date LastConnectionDate;

	@Column(name = "encPwd")
	private String encPwd;
	
	
	
	
	

	public Long getId() {
		return Id;
	}

	public void setId(Long id) {
		Id = id;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getMobileNumber() {
		return mobileNumber;
	}

	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	public String getUserStatus() {
		return userStatus;
	}

	public void setUserStatus(String userStatus) {
		this.userStatus = userStatus;
	}

	public String getCustomerId() {
		return customerId;
	}

	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}

	public Date getAtDate() {
		return atDate;
	}

	public void setAtDate(Date atDate) {
		this.atDate = atDate;
	}

	public Date getLastConnectionDate() {
		return LastConnectionDate;
	}

	public void setLastConnectionDate(Date lastConnectionDate) {
		LastConnectionDate = lastConnectionDate;
	}

	public String getEncPwd() {
		return encPwd;
	}

	public void setEncPwd(String encPwd) {
		this.encPwd = encPwd;
	}

}
