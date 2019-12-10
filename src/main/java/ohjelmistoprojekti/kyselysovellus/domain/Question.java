package ohjelmistoprojekti.kyselysovellus.domain;


import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;



@Entity

public class Question {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long qid;
	private  String title;
	private  String type;
	

	@OneToMany(cascade = CascadeType.ALL, mappedBy = "question")
	//@JsonIgnoreProperties("questions")
	@JsonIgnore
	private  List<AnswerChoice> answerChoices;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "question")
	@JsonIgnore
	private  List<Answer> answers;

	public Question() {
		super();
		
	}

	public Question(String title, String type) {
		this.title = title;
		this.type = type;
	}
	
	public Question(Long qid, String title, String type) {
		super();
		this.qid = qid;
		this.title = title;
		this.type = type;
	}


	public Long getQid() {
		return qid;
	}

	public void setQid(Long id) {
		this.qid = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public List<AnswerChoice> getAnswerChoices() {
		return answerChoices;
	}

	public void setAnswerChoices(List<AnswerChoice> answerChoices) {
		this.answerChoices = answerChoices;
	}

	public List<Answer> getAnswers() {
		return answers;
	}

	public void setAnswers(List<Answer> answers) {
		this.answers = answers;
	}

	@Override
	public String toString() {
		return "Question [qid=" + qid + ", title=" + title + ", type=" + type + ", answerChoices=" + answerChoices
				+ ", answers=" + answers + "]";
	}
	
	
}