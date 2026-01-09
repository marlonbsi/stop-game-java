package br.com.marlon.stopgame.domain.model;

import java.util.Map;

public class AnswerSheet {
	
	private Player player;
	private Map<Category, Answer> answers;
	
	public Player getPlayer() {
		return player;
	}
	public void setPlayer(Player player) {
		this.player = player;
	}
	public Map<Category, Answer> getAnswers() {
		return answers;
	}
	public void setAnswers(Map<Category, Answer> answers) {
		this.answers = answers;
	}
	
	@Override
	public String toString() {
		return "AnswerSheet [player=" + player + ", answers=" + answers + "]";
	}
	
}
