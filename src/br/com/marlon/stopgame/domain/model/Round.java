package br.com.marlon.stopgame.domain.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.UUID;

public class Round {
	
	private UUID id;
	private char letter;
	private RoundStatus status;
	private final List<Category> categories;
	private List<AnswerSheet> answerSheets = new ArrayList<>();
	
	//Constructor
	public Round(UUID id, char letter, List<Category> categories) {
		if(id == null) {
			throw new IllegalArgumentException("Round id cannot be null!");
		}
		if(!Character.isLetter(letter)) {
			throw new IllegalArgumentException("Invalid value for letter!");
		}
		if(categories == null || categories.isEmpty()) {
			throw new IllegalArgumentException("Categories list cannot be null or empty!");
		}
		this.id = id;
		this.letter = letter;
		this.categories = List.copyOf(categories);
		this.status = RoundStatus.NOT_STARTED;
	}
	
	// Getters
	public UUID getId() {
		return id;
	}
	public char getLetter() {
		return letter;
	}
	public RoundStatus getStatus() {
		return status;
	}
	public List<Category> getCategories(){
		return Collections.unmodifiableList(this.categories);
	}
	public List<AnswerSheet> getAnswerSheets() {
		return Collections.unmodifiableList(this.answerSheets);
	}
	
	// Behavior
	public void submitAnswer(Player player, Category category, String value) {
		if(category == null) {
			throw new IllegalArgumentException("Category cannot be null!");
		}
		if(player == null) {
			throw new IllegalArgumentException("Player cannot be null!");
		}
		if(status != RoundStatus.RUNNING) {
			throw new IllegalArgumentException("Round is closed");
		}
		if(!categories.contains(category)) {
			throw new IllegalArgumentException("Invalid category for this round!");
		}
		if(!value.isBlank() && 
				Character.toUpperCase(value.charAt(0)) != Character.toUpperCase(letter)) {
			throw new IllegalArgumentException("Answer does not match the round letter!");
		}
		
		AnswerSheet sheet = getOrCreateSheet(player);
		sheet.submitAnswer(category, value);
	}
	
	private AnswerSheet getOrCreateSheet(Player player) {
	    return answerSheets.stream()
	        .filter(s -> s.getPlayer().equals(player))
	        .findFirst()
	        .orElseGet(() -> {
	            AnswerSheet sheet = new AnswerSheet(player, categories);
	            answerSheets.add(sheet);
	            return sheet;
	        });
	}

	
	public void start() {
		if(status != RoundStatus.NOT_STARTED) {
			throw new IllegalArgumentException("Round is already started!");
		}
		this.status = RoundStatus.RUNNING;
	}

	public void finish() {
		if(status != RoundStatus.RUNNING) {
			throw new IllegalArgumentException("Round not running!");
		}
		this.status = RoundStatus.FINISHED;
	}
	
	@Override
	public String toString() {
		return "Round [id=" + id + ", letter=" + letter + ", status=" + status + ", answers=" + answerSheets + "]";
	}

}
