package com.me.myfinal.pojo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "apt_table")
public class Apt {

	@Id 
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="aptid", unique = true, nullable = false)
    private long aptid;
    
    @Column(name="aptName")
    private String aptName;
    
    @Column(name="location")
    private String location;
    
    
    @Column(name="price")
    private String price;
    
    public Apt() {
    	
    }

	public long getAptid() {
		return aptid;
	}




	public void setAptid(long aptid) {
		this.aptid = aptid;
	}




	public String getAptName() {
		return aptName;
	}


	public void setAptName(String aptName) {
		this.aptName = aptName;
	}


	public String getLocation() {
		return location;
	}


	public void setLocation(String location) {
		this.location = location;
	}


	public String getPrice() {
		return price;
	}


	public void setPrice(String price) {
		this.price = price;
	}
    
    
    
    
}
