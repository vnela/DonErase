package ohjelmistoprojekti.kyselysovellus.domain;

public class AnswerValuetoQuestion {
	

	private String answerValue;
	private Long qId;
	
	public AnswerValuetoQuestion() {
		super();
		
	}

	public AnswerValuetoQuestion(String answerValue, Long qId) {
		super();
		this.answerValue = answerValue;
		this.qId = qId;
	}

	public String getAnswerValue() {
		return answerValue;
	}

	public void setAnswerValue(String answerValue) {
		this.answerValue = answerValue;
	}

	public Long getqId() {
		return qId;
	}

	public void setqId(Long qId) {
		this.qId = qId;
	}
	@Override
	public String toString() {
		return "AnswerValuetoQuestion [answerValue=" + answerValue + ", qId=" + qId + "]";
	}
}
