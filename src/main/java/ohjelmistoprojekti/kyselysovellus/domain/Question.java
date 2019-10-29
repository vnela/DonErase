package ohjelmistoprojekti.kyselysovellus.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity

public class Question {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	private String title;
	private String answer;
	
	public Question(String title, String answer) {
		super();
		this.title = title;
		this.answer = answer;
	}
	public Question(Long id, String title, String answer) {
		super();
		this.id = id;
		this.title = title;
		this.answer = answer;
	}
	
	public Question() {
		super();
		this.id = null;
		this.title = null;
		this.answer = null;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getAnswer() {
		return answer;
	}

	public void setAnswer(String answer) {
		this.answer = answer;
	}

	@Override
	public String toString() {
		return "Question [id=" + id + ", title=" + title + ", answer=" + answer + "]";
	}

	

}