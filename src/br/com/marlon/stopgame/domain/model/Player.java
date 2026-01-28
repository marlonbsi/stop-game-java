package br.com.marlon.stopgame.domain.model;

import java.util.UUID;

public class Player {
	
	private UUID id;
	private String name;
	private int totalScore;
	
	public Player(UUID id, String name) {
		this.id = id;
		this.name = name;
		this.totalScore = 0;
	}
	
	//Getters
	public UUID getId() {
		return id;
	}
	public String getName() {
		return name;
	}
	public int getTotalScore() {
		return totalScore;
	}
	
	//Behavior
	public void updateScore(int score) {
		this.totalScore += score;
	}

	@Override
	public String toString() {
		return "Player [id=" + id + ", name=" + name + ", totalScore=" + totalScore + "]";
	}

}