package br.com.marlon.stopgame.domain.model;

import java.util.Collection;
import java.util.Collections;
import java.util.Map;

public class AnswerSheet {
	
	private Player player;
	private Map<Category, Answer> answers;
	
	public AnswerSheet(Player player) {
		this.player = player;
	}

	// Getters
	public Player getPlayer() {
		return player;
	}
	public Collection<Answer> getAnswer() {
		return Collections.unmodifiableCollection(answers.values());
	}
	
	// Behavior
	public void submitAnswer(Category category, String value) {
		if(answers.containsKey(category)) {
			throw new IllegalArgumentException("Categpry already answered");
		}
		answers.put(category, new Answer(category, value));
	}
	
	@Override
	public String toString() {
		return "AnswerSheet [player=" + player + ", answers=" + answers + "]";
	}
	
}
