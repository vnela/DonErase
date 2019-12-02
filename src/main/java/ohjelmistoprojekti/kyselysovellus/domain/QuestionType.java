package ohjelmistoprojekti.kyselysovellus.domain;

public class QuestionType {
	private String questionValue;
	private String type;
	
	public QuestionType() {
		super();
	}

	public QuestionType(String questionValue, String type) {
		super();
		this.questionValue = questionValue;
		this.type = type;
	}

	@Override
	public String toString() {
		return "QuestionType [questionValue=" + questionValue + ", type=" + type + "]";
	}

	public String getQuestionValue() {
		return questionValue;
	}

	public void setQuestionValue(String questionValue) {
		this.questionValue = questionValue;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
	
}
