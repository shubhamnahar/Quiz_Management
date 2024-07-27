package com.no_one.demo.model;

import jakarta.persistence.*;
//import jakarta.persistence.GeneratedValue;
//import jakarta.persistence.GenerationType;
//import jakarta.persistence.Id;
import lombok.Data;


@Entity
//@Table(name = "question")
public class question {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
//	@Column(name = "question_title")
	private String question_Title;
    private String option1;
    private String option2;
    private String option3;
    private String option4;
    private String right_Answer;
    private String difficulty_Level;
    private String category ; 

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getQuestionTitle() {
		return question_Title;
	}

	public void setQuestionTitle(String question_Title) {
		this.question_Title = question_Title;
	}

	public String getOption1() {
		return option1;
	}

	public void setOption1(String option1) {
		this.option1 = option1;
	}

	public String getOption2() {
		return option2;
	}

	public void setOption2(String option2) {
		this.option2 = option2;
	}

	public String getOption3() {
		return option3;
	}

	public void setOption3(String option3) {
		this.option3 = option3;
	}

	public String getOption4() {
		return option4;
	}

	public void setOption4(String option4) {
		this.option4 = option4;
	}

	public String getRightAnswer() {
		return right_Answer;
	}

	public void setRightAnswer(String rightAnswer) {
		this.right_Answer = rightAnswer;
	}

	public String getDifficultyLevel() {
		return difficulty_Level;
	}

	public void setDifficultyLevel(String difficulty_Level) {
		this.difficulty_Level = difficulty_Level;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	@Override
	public String toString() {
		return "question [id=" + id + ", question_Title=" + question_Title + ", option1=" + option1 + ", option2="
				+ option2 + ", option3=" + option3 + ", option4=" + option4 + ", right_Answer=" + right_Answer
				+ ", difficulty_Level=" + difficulty_Level + ", category=" + category + "]";
	}

	
	
}
