package br.com.marlon.stopgame.domain.model;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AnswerSheet {
	
	private Player player;
	private Map<Category, Answer> answers;
	
	//Constructor
	public AnswerSheet(Player player, List<Category> categories) {
		if(player == null) {
			throw new IllegalArgumentException("Player cannot be null");
		}
		
		this.player = player;
		this.answers = new HashMap<>();
		
		for(Category category: categories) {
			this.answers.put(category, Answer.empty(category));
		}
	}

	// Getters
	public Player getPlayer() {
		return player;
	}
	public Map<Category, Answer> getAnswer() {
		return Collections.unmodifiableMap(answers);
	}
	
	// Behavior
	public void submitAnswer(Category category, String value) {
		if(category == null) {
			throw new IllegalArgumentException("Category cannot be null");
		}
		
		Answer answer = answers.get(category);
		
		if(answer == null) {
			throw new IllegalArgumentException("Invalid category");
		}
		
		answer.fill(value);
	}
	
	@Override
	public String toString() {
		return "AnswerSheet [player=" + player + ", answers=" + answers + "]";
	}
	
}
