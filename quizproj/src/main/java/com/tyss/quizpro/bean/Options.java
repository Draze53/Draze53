package com.tyss.quizpro.bean;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;
@Data
@Entity
@Table(name="option_info")
public class Options implements Serializable{
	@Id
	@Column
	private int option_id;
	@Column
	private String options;
	@Column
	private int question_id;
	public int getOption_id() {
		return option_id;
	}
	public void setOption_id(int option_id) {
		this.option_id = option_id;
	}
	public String getOptions() {
		return options;
	}
	public void setOptions(String options) {
		this.options = options;
	}
	public int getQuestion_id() {
		return question_id;
	}
	public void setQuestion_id(int question_id) {
		this.question_id = question_id;
	}
	//method
	@Override
	public String toString() {
		return "Options [option_id=" + option_id + ", options=" + options + ", question_id=" + question_id + "]";
	}
	
}
