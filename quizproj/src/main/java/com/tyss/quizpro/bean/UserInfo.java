package com.tyss.quizpro.bean;


import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@Entity
@Table(name="user_info")
public class UserInfo implements Serializable{
	
	@Id
	@Column
	private int user_id;
	@Column
	private String name;
	@Column
	private int age;
	@Column
	private String email;
	@Column
	private String password;
	public int getUser_id() {
		return user_id;
	}
	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	@Override
	public String toString() {
		return "UserInfo [user_id=" + user_id + ", name=" + name + ", age=" + age + ", email=" + email + ", password="
				+ password + "]";
	}
	
	
}
