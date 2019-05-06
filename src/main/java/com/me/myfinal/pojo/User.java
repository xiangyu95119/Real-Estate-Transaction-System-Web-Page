package com.me.myfinal.pojo;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.Table;

@Entity
@Table(name = "user_table")
public class User {
    
    @Id 
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id", unique = true, nullable = false)
    private long id;
    
    @Column(name="userName")
    private String userName;
    
    @Column(name="userRole")
    private String userRole;
    
    @Column(name = "userEmail")
    private String userEmail;

    @Column(name = "password")
    private String password;
    
    @Column(name="status")
    private int status;
    
    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "user_apt", 
    joinColumns = { @JoinColumn(name = "id") }, 
    inverseJoinColumns = { @JoinColumn(name = "aptid") })
    Set<Apt> apt = new HashSet<Apt>();//0

    
    public User() {
    
    }

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getUserRole() {
		return userRole;
	}

	public void setUserRole(String userRole) {
		this.userRole = userRole;
	}

	public String getUserEmail() {
		return userEmail;
	}

	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public Set<Apt> getApt() {
		return apt;
	}

	public void setApt(Set<Apt> apt) {
		this.apt = apt;
	}

	
	
	
    
}

