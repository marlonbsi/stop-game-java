package br.com.marlon.stopgame.domain.model;

public class Answer {
	
	private final Category category;
	private final String value;
	private AnswerStatus status;
	private int score;
	
	public Answer(Category category, String value) {
		if(category == null) {
			throw new IllegalArgumentException("Category cannot be null");
		}
		if(value == null) {
			throw new IllegalArgumentException("Answer value cannot be null or blank");
		}
		
		this.category = category;
		this.value = value;
		this.status = AnswerStatus.PENDING;
		this.score = 0;
	}
	
	//Getters
	public Category getCategory() {
		return category;
	}
	public String getValue() {
		return value;
	}
	public AnswerStatus getStatus() {
		return status;
	}
	public int getScore() {
		return score;
	}
	
	//Behavior
	public void markAsValid() {
		this.status = AnswerStatus.VALID;
	}
	public void markAsInvalid() {
		this.status = AnswerStatus.INVALID;
	}
	public void applyScore(int score) {
		this.score = score;
	}
	
	@Override
	public String toString() {
		return "Answer [category=" + category + ", value=" + value + ", status=" + status + ", score=" + score + "]";
	}

}
