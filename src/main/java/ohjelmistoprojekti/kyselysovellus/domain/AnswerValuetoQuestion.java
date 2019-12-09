package ohjelmistoprojekti.kyselysovellus.domain;

public class AnswerValuetoQuestion {
	

	private String answerInput;
	private Long qid;
	
	public AnswerValuetoQuestion() {
		super();
		
	}

	public AnswerValuetoQuestion(String answerInput, Long qId) {
		super();
		this.answerInput = answerInput;
		this.qid = qId;
	}

	public String getAnswerInput() {
		return answerInput;
	}

	public void setAnswerInput(String answerInput) {
		this.answerInput = answerInput;
	}

	public Long getQid() {
		return qid;
	}

	public void setQd(Long qid) {
		this.qid = qid;
	}
	@Override
	public String toString() {
		return "AnswerValuetoQuestion [answerInput=" + answerInput + ", qid=" + qid + "]";
	}
}
