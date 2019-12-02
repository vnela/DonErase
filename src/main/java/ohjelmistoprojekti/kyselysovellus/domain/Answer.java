 
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
	@GeneratedValue(strategy = GenerationType.AUTO)
	public Long aid;
	public String answerValue;
	
	@ManyToOne
	@JoinColumn(name = "qId")
	public Question question;

	public Answer() {
		super();
		
	}

	public Answer(String answerValue, Question question) {
		super();
		this.answerValue = answerValue;
		this.question = question;
		
	}

	public Long getAid() {
		return aid;
	}

	public void setAid(Long aid) {
		this.aid = aid;
	}

	public String getAnswerValue() {
		return answerValue;
	}

	public void setAnswerValue(String answerValue) {
		this.answerValue = answerValue;
	}

	public Question getQuestion() {
		return question;
	}

	public void setQuestion(Question question) {
		this.question = question;
	}
}

	