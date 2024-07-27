package com.no_one.demo.model;

import java.util.HashSet;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.persistence.*;


@Entity
@Table(name = "usertable", uniqueConstraints = @UniqueConstraint(columnNames = "uName"))  // uniqueConstraints for making Unique Column 
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class UserTable {

	

	@Id    //Specify the primary key of the table
	@GeneratedValue(strategy = GenerationType.IDENTITY)  //Creates a sequence which auto increment while inserting in table
	private Integer id;
	
	@Column(unique = true) //for making Unique Column 
	private String uName;
	
	
	private String user_psw;
	
	@ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL) 
    @JoinTable(
        name = "user_roles",
        joinColumns = @JoinColumn(name = "user_id"),
        inverseJoinColumns = @JoinColumn(name = "role_id"))
	
	  //  When you have a ManyToMany relationship, both entities reference each other, causing the serialization to loop indefinitely.
	@JsonManagedReference  
    private Set<Role> roles;  ////By using @JsonManagedReference and @JsonBackReference, you can prevent infinite recursion during serialization of bidirectional relationships, resolving the StackOverflowError.
							
//	 private Set<Role> roles = new HashSet<>();

	
	public Integer getID() {
		return id;
	}
	public String getuName() {
		return uName;
	}
	public void setuName(String uName) {
		this.uName = uName;
	}
	public String getUser_psw() {
		return user_psw;
	}
	public void setUser_psw(String user_psw) {
		this.user_psw = user_psw;
	}
	public void setID(Integer iD) {
		id = iD;
	}

	
	
	public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }
    
    @Override
	public String toString() {
//    	return "UserTable [id=" + id + ", username=" + uName + ", password=" + user_psw + "]";
    	return "UserTable [id=" + id + ", uName=" + uName + ", userPsw=" + user_psw + ", roles=" + roles + "]";
    }
	
}
