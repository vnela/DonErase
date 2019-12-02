package ohjelmistoprojekti.kyselysovellus.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class AnswerChoice {
	@Id
	@GeneratedValue(strategy= GenerationType.AUTO)
	private Long achoiceId;
	private String value;
	
	@ManyToOne
	@JoinColumn(name = "qId")
	public Question question;

	public AnswerChoice() {
		
	}

	public AnswerChoice(String value, Question question) {
		super();
		this.value = value;
		this.question = question;
	}

	public Long getAchoiceId() {
		return achoiceId;
	}

	public void setAchoiceId(Long achoiceId) {
		this.achoiceId = achoiceId;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public Question getQuestion() {
		return question;
	}

	public void setQuestion(Question question) {
		this.question = question;
	}

	@Override
	public String toString() {
		return "AnswerChoice [achoiceId=" + achoiceId + ", value=" + value + ", question=" + question + "]";
	}

}