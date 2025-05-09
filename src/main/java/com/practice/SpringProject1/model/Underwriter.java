package com.practice.SpringProject1.model;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;


@Entity
@Table(name = "Underwriter")
public class Underwriter {
	@Id
    @Column(name = "UnderwriterId") // Map to the actual column name in DB
    private int underwriterId;
    
    @Column(name = "Name")
    private String name;
    
    @Column(name = "DOB")
    private Date dob;
    
    @Column(name = "JoiningDate")
    private Date joiningDate;
    
    @Column(name = "Password")
    private String password;
    
    public Underwriter() {
    		
    }

    public Underwriter(int underwriterId, String name, Date dob, Date joiningDate, String password) {

        this.underwriterId = underwriterId;
        this.name = name;
        this.dob = dob;
        this.joiningDate = joiningDate;
        this.password = password;

    }
    
    public Underwriter(int underwriterId, String password) {
		super();
		this.underwriterId = underwriterId;
		this.password = password;
	}
    // getters and setter for UnderWriter

	public int getUnderwriterId() {
        return underwriterId;
    }

    public String getName() {
        return name;
    }

    public Date getDob() {
        return dob;
    }

    public Date getJoiningDate() {
        return joiningDate;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

	@Override
	public String toString() {
		return "UnderWriter [underwriterId=" + underwriterId + ", name=" + name + ", dob=" + dob + ", joiningDate="
				+ joiningDate +"]";
	}
    

}

