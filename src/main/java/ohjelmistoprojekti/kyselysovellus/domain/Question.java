package ohjelmistoprojekti.kyselysovellus.domain;

import java.util.ArrayList;
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

@Entity
@Table(name = "questions")
public class Question {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long qid;
	private String title;
	private String type;
	
	/*
	@ManyToOne
	@JoinColumn(name = "aid") 
	//private List<Answer> answers;
	private Answer answer;*/
	
	/*
	 @OneToMany(cascade=CascadeType.ALL, mappedBy = "question")
	 @JoinColumn(name="aid")
	 private List<Answer> answers;*/
	
	@OneToMany(cascade = CascadeType.ALL,
            fetch = FetchType.LAZY,
            mappedBy = "question")
	private List<Answer> answers;
	

	
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
	
	/*
	public Question(Long qid, String title, String type) {
		super();
		this.qid = qid;
		this.title = title;
		this.type = type;
	}*/
	


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
	
	
	/*
	public void setAnswers(List<Answer> newAnswers) {
		this.answers = newAnswers;
	}

	
	public List<Answer> getAnswers() {
		return answers;
	}*/


	@Override
	public String toString() {
		return "Question [qid=" + qid + ", title=" + title + ", type=" + type+"]";
	}


}
