package ohjelmistoprojekti.kyselysovellus.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity

public class Question {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long qid;
	private String title;
	private String type;
	
	@ManyToOne
	@JoinColumn(name = "aid")
	private Answer answer;
	
	public Question() {
		super();
		this.qid = null;
		this.title = null;
		this.type = null;
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
	

	public Question(String title, String type, Answer answer) {
		super();
		this.title = title;
		this.type = type;
		this.answer = answer;
	}


	public Long getQid() {
		return qid;
	}

	public void setQid(Long qid) {
		this.qid = qid;
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

	public Answer getAnswer() {
		return answer;
	}

	public void setAnswer(Answer answer) {
		this.answer = answer;
	}

	@Override
	public String toString() {
		return "Question [qid=" + qid + ", title=" + title + ", type=" + type + ", answer=" + answer + "]";
	}


}
