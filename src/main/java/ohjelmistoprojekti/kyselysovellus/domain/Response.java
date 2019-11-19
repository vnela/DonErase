package ohjelmistoprojekti.kyselysovellus.domain;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

public class Response {
	/*@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long rid;*/
	private String title;
	private String type;
	
	@ManyToOne
	@JoinColumn(name = "qid")
	private Answer question;
	
	@ManyToOne
	@JoinColumn(name = "aid")
	private Answer answer;

}
