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
@Table(name="exam_info")
public class ExamTopic implements Serializable{
	@Id
	@Column
	private int exam_id;
	@Column
	private String exam_name;
	public int getExam_id() {
		return exam_id;
	}
	public void setExam_id(int exam_id) {
		this.exam_id = exam_id;
	}
	public String getExam_name() {
		return exam_name;
	}
	public void setExam_name(String exam_name) {
		this.exam_name = exam_name;
	}
	//hello 
	@Override
	public String toString() {
		return "ExamTopic [exam_id=" + exam_id + ", exam_name=" + exam_name + "]";
	}
	
	
}
