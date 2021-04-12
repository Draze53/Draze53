package com.tyss.quizpro.bean;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
@Data
@Entity
@Table(name="question_info")
public class Questions implements Serializable{
	@Id
	@Column
	private int question_id;
	@Column
	private String question;
	@Column
	private String answer;
	@Column
	private int exam_id;
	public int getQuestion_id() {
		return question_id;
	}
	public void setQuestion_id(int question_id) {
		this.question_id = question_id;
	}
	public String getQuestion() {
		return question;
	}
	public void setQuestion(String question) {
		this.question = question;
	}
	public String getAnswer() {
		return answer;
	}
	public void setAnswer(String answer) {
		this.answer = answer;
	}
	public int getExam_id() {
		return exam_id;
	}
	public void setExam_id(int exam_id) {
		this.exam_id = exam_id;
	}
	@Override
	public String toString() {
		return "Questions [question_id=" + question_id + ", question=" + question + ", answer=" + answer + ", exam_id="
				+ exam_id + "]";
	}
	
}
