package br.com.marlon.stopgame.domain.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.UUID;

public class Round {
	
	private UUID id;
	private char letter;
	private RoundStatus status;
	private List<AnswerSheet> answerSheets = new ArrayList<>();
	
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
	public List<AnswerSheet> getAnswerSheets() {
		return Collections.unmodifiableList(this.answerSheets);
	}
	
	// Behavior
	public void submitAnswer(Player player, Category category, String value) {
		if(status != RoundStatus.RUNNING) {
			throw new IllegalArgumentException("Round is closed");
		}
		
		AnswerSheet sheet = getOrCreateSheet(player);
		sheet.submitAnswer(category, value);
	}
	
	private AnswerSheet getOrCreateSheet(Player player) {
		return answerSheets.stream()
				.filter(s -> s.getPlayer().equals(player))
				.findFirst()
				.orElseGet(() -> {
					AnswerSheet sheet = new AnswerSheet(player);
					answerSheets.add(sheet);
					return sheet;
				});
	}

	
	@Override
	public String toString() {
		return "Round [id=" + id + ", letter=" + letter + ", status=" + status + ", answers=" + answerSheets + "]";
	}

}
