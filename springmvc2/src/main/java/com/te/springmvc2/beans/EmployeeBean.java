package com.te.springmvc2.beans;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "employeeinfo")
public class EmployeeBean implements Serializable{

	@Id
	@Column(name="User_Id")
	private int id;
	
	@Column(name="Username")
	private String name;
	
	@Column(name = "dob")
	private Date birtDate;
	
	@Column(name="Password")
	private String password;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getBirtDate() {
		return birtDate;
	}

	public void setBirtDate(Date birtDate) {
		this.birtDate = birtDate;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "EmployeeBean [id=" + id + ", name=" + name + ", birtDate=" + birtDate + ", password=" + password + "]";
	}
	
}
