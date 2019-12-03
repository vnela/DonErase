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
import javax.persistence.Table;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "answers")
public class Answer {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long aid;
	private String input;
	//private Long qid;

	/*
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "answer")
	private List<Question> questions;*/
	
	@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "qid", nullable = false)
    private Question question;

	public Answer() {
		super();
		this.aid = null;
		this.input = null;
		//this.qid = null;
	}

	public Answer(String input) {
		super();
		this.input = input;
	}

	public Answer(String input, Long qid) {
		super();
		this.input = input;
		//this.qid = qid;
	}
	
	
	public Answer(String input, Long qid, Long aid) {
		super();
		this.input = input;
		//this.qid = qid;
		this.aid = aid;
	}

	public Long getAid() {
		return aid;
	}

	public void setAid(Long aid) {
		this.aid = aid;
	}
	

	public String getInput() {
		return input;
	}

	public void setInput(String input) {
		this.input = input;
	}
	
	/*
	public Long getQid() {
		return qid;
	}

	public void setQid(Long qid) {
		this.qid = qid;
	}*/
	
	
	public Question getQuestion() {
		return question;
	}

	public void setQuestion(Question question) {
		this.question = question;
	}

	@Override
	public String toString() {
		return "Answer [aid=" + aid + ", input=" + input + "]";
	}

}
