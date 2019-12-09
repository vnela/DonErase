package ohjelmistoprojekti.kyselysovellus.domain;

public class AnswerChoiceLink {
	private String value;
	private Long qid;
	
	public AnswerChoiceLink() {
		super();
	
	}

	public AnswerChoiceLink(Long qid) {
		super();
		this.qid = qid;
	}

	public AnswerChoiceLink(String value, Long qid) {
		super();
		this.value = value;
		this.qid = qid;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public Long getqId() {
		return qid;
	}

	public void setqId(Long qId) {
		this.qid = qId;
	}

	@Override
	public String toString() {
		return "AnswerChoiceLink [value=" + value + ", qid=" + qid + "]";
	}
}