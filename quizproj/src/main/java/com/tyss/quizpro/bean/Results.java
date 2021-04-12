package com.tyss.quizpro.bean;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Data;
@Data
@Entity
public class Results implements Serializable{
	@Id
	@Column
	private int result_Id;
	@Column
	private int user_Id;
	@Column
	private int score;
	@Column
	private String questionLanguage;
	public int getResult_Id() {
		return result_Id;
	}
	public void setResult_Id(int result_Id) {
		this.result_Id = result_Id;
	}
	public int getUser_Id() {
		return user_Id;
	}
	public void setUser_Id(int user_Id) {
		this.user_Id = user_Id;
	}
	public int getScore() {
		return score;
	}
	public void setScore(int score) {
		this.score = score;
	}
	public String getQuestionLanguage() {
		return questionLanguage;
	}
	public void setQuestionLanguage(String questionLanguage) {
		this.questionLanguage = questionLanguage;
	}
	@Override
	public String toString() {
		return "Results [result_Id=" + result_Id + ", user_Id=" + user_Id + ", score=" + score + ", questionLanguage="
				+ questionLanguage + "]";
	}
	
}
