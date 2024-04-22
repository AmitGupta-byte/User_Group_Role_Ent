package com.amit.User_Group_Role.Model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "Roles")
public class RolePojo {
	@Id
	@GeneratedValue(strategy =GenerationType.IDENTITY)
	@Column(name= "Id", nullable = false)
	private long Id;
	
	@Column(name= "RoleId", nullable = true)
	private String roleId;
	
	@Column(name= "RoleName", nullable = false)
	private String roleName;
	
	@Column(columnDefinition = "TEXT")
	private String permissions;

	@Column(name = "CreatedBy", nullable = false)
    private String createdBy;



	public long getId() {
		return Id;
	}

	public void setId(long id) {
		Id = id;
	}

	public String getRoleId() {
		return roleId;
	}

	public void setRoleId(String roleId) {
		this.roleId = roleId;
	}

	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	public String getPermissions() {
		return permissions;
	}

	public void setPermissions(String permissions) {
		this.permissions = permissions;
	}

	public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	@Override
	public String toString() {
		return "RolePojo [Id=" + Id + ", roleId=" + roleId + ", roleName=" + roleName + ", permissions=" + permissions
				+ ", createdBy=" + createdBy + "]";
	}



	
	
	
}
