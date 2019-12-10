package ohjelmistoprojekti.kyselysovellus.domain;

public class AnswerLink {
	private String answerInput;
	private Long qId;
	
	public AnswerLink() {
		super();
	
	}

	public AnswerLink(Long qId) {
		super();
		this.qId = qId;
	}

	public AnswerLink(String answerInput, Long qId) {
		super();
		this.answerInput = answerInput;
		this.qId = qId;
	}

	public String getValue() {
		return answerInput;
	}

	public void setValue(String answerInput) {
		this.answerInput = answerInput;
	}

	public Long getqId() {
		return qId;
	}

	public void setqId(Long qId) {
		this.qId = qId;
	}

	@Override
	public String toString() {
		return "AnswerLink [answerInput=" + answerInput + ", qId=" + qId + "]";
	}
}
