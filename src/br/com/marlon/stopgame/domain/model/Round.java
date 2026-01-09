package br.com.marlon.stopgame.domain.model;

import java.util.Map;
import java.util.UUID;

public class Round {
	
	private UUID id;
	private char letter;
	private RoundStatus status;
	private Map<Player, AnswerSheet> answers;
	
	//Getters and setters:
	public UUID getId() {
		return id;
	}
	public char getLetter() {
		return letter;
	}
	public void setLetter(char letter) {
		this.letter = letter;
	}
	public RoundStatus getStatus() {
		return status;
	}
	public void setStatus(RoundStatus status) {
		this.status = status;
	}
	public Map<Player, AnswerSheet> getAnswers() {
		return answers;
	}
	public void setAnswers(Map<Player, AnswerSheet> answers) {
		this.answers = answers;
	}
	
	@Override
	public String toString() {
		return "Round [id=" + id + ", letter=" + letter + ", status=" + status + ", answers=" + answers + "]";
	}

}
