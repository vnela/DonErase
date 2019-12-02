package ohjelmistoprojekti.kyselysovellus.domain;

public class AnswerChoiceLink {
	private String value;
	private Long qId;
	
	public AnswerChoiceLink() {
		super();
	
	}

	public AnswerChoiceLink(Long qId) {
		super();
		this.qId = qId;
	}

	public AnswerChoiceLink(String value, Long qId) {
		super();
		this.value = value;
		this.qId = qId;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public Long getqId() {
		return qId;
	}

	public void setqId(Long qId) {
		this.qId = qId;
	}

	@Override
	public String toString() {
		return "AnswerChoiceLink [value=" + value + ", qId=" + qId + "]";
	}
}
