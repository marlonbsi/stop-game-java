package br.com.marlon.stopgame.domain.model;

import java.util.UUID;

public class Player {
	
	private UUID id;
	private String name;
	private int totalScore;
	
	public Player(String name) {
		super();
		this.id = UUID.randomUUID();
		this.name = name;
		this.totalScore = 0;
	}
	
	public UUID getId() {
		return id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getTotalScore() {
		return totalScore;
	}
	public void setTotalScore(int totalScore) {
		this.totalScore = totalScore;
	}

	@Override
	public String toString() {
		return "Player [id=" + id + ", name=" + name + ", totalScore=" + totalScore + "]";
	}

}
