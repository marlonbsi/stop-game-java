package br.com.marlon.stopgame.domain.model;

public class Answer {
	
	private Category category;
	private String value;
	private AnswerStatus status;
	private int score;
	
	//Getters and setters
	public Category getCategory() {
		return category;
	}
	public void setCategory(Category category) {
		this.category = category;
	}
	public String getValue() {
		return value;
	}
	public void setValue(String value) {
		this.value = value;
	}
	public AnswerStatus getStatus() {
		return status;
	}
	public void setStatus(AnswerStatus status) {
		this.status = status;
	}
	public int getScore() {
		return score;
	}
	public void setScore(int score) {
		this.score = score;
	}
	
	@Override
	public String toString() {
		return "Answer [category=" + category + ", value=" + value + ", status=" + status + ", score=" + score + "]";
	}

}
