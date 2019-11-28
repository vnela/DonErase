package ohjelmistoprojekti.kyselysovellus.domain;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Answer {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long aid;
	private String input;
	private Long qid;

	@OneToMany(cascade = CascadeType.ALL, mappedBy = "answer")
	private List<Question> questions;

	public Answer() {
		super();
		this.aid = null;
		this.input = null;
		this.qid = null;
	}

	public Answer(String input) {
		super();
		this.input = input;
	}

	public Answer(Long qid, String input) {
		super();
		this.qid = qid;
		this.input = input;
	}
	
	public Answer(Long aid, String input, Long qid) {
		super();
		this.aid = aid;
		this.input = input;
		this.qid = qid;
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
	
	public Long getQid() {
		return qid;
	}

	public void setQid(Long qid) {
		this.qid = qid;
	}

	@Override
	public String toString() {
		return "Answer [aid=" + aid + ", input=" + input + "]";
	}

}
