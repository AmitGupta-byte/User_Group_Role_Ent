package com.amit.User_Group_Role.Model;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="Groups")
public class GroupModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name= "Id", nullable = false)
	private long Id;

    @Column(name= "GroupId", nullable = true)
	private String groupId;

    @Column(name= "GroupName", nullable = false)
	private String groupName;
	
	@Column(name = "Description", length = 50)
	private String description;

    @Column(name = "CreatedBy", nullable = false)
    private String createdBy;

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

   
    
	
	public long getId() {
        return Id;
    }

    public void setId(long id) {
        Id = id;
    }

    public String getGroupId() {
        return groupId;
    }

    public void setGroupId(String groupId) {
        this.groupId = groupId;
    }

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    public String getDescription() {
        return description;
    }

    

    @Override
    public String toString() {
        return "GroupModel [Id=" + Id + ", groupId=" + groupId + ", groupName=" + groupName + ", description="
                + description + ", createdBy=" + createdBy + "]";
    }

    public void setDescription(String description) {
        this.description = description;
    }

  




    
}
