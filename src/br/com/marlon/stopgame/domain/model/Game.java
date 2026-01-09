package br.com.marlon.stopgame.domain.model;

import java.util.List;
import java.util.UUID;

public class Game {
	
	private UUID id;
	private List<Player> players;
	private List<Category> categories;
	private List<Round> rounds;
	private GameStatus gameStatus;
	
	//Getters and setters
	public UUID getId() {
		return id;
	}
	public List<Player> getPlayers() {
		return players;
	}
	public void setPlayers(List<Player> players) {
		this.players = players;
	}
	public List<Category> getCategories() {
		return categories;
	}
	public void setCategories(List<Category> categories) {
		this.categories = categories;
	}
	public List<Round> getRounds() {
		return rounds;
	}
	public void setRounds(List<Round> rounds) {
		this.rounds = rounds;
	}
	public GameStatus getGameStatus() {
		return gameStatus;
	}
	public void setGameStatus(GameStatus gameStatus) {
		this.gameStatus = gameStatus;
	}
	
	@Override
	public String toString() {
		return "Game [id=" + id + ", players=" + players + ", categories=" + categories + ", rounds=" + rounds
				+ ", gameStatus=" + gameStatus + "]";
	}

}
