 
package ohjelmistoprojekti.kyselysovellus.domain;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Answer {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long aid;
	private String answerInput;
	
	@ManyToOne
	@JoinColumn(name = "qid")
	private Question question;

	public Answer() {
		super();
		
	}

	public Answer(String answerInput, Question question) {
		super();
		this.answerInput = answerInput;
		this.question = question;
		
	}

	public Long getAid() {
		return aid;
	}

	public void setAid(Long aid) {
		this.aid = aid;
	}
	

	public String getInput() {
		return answerInput;
	}

	public void setInput(String answerInput) {
		this.answerInput = answerInput;
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

	public Question getQuestion() {
		return question;
	}

	public void setQuestion(Question question) {
		this.question = question;
	}
}

	