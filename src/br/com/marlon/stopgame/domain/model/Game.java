package br.com.marlon.stopgame.domain.model;

import java.util.List;
import java.util.UUID;

public class Game {
	
	private UUID id;
	private List<Player> players;
	private List<Category> categories;
	private List<Round> rounds;
	private GameStatus gameStatus;
	
	public Game(UUID id, List<Player> players) {
		if(id == null) {
			throw new IllegalArgumentException("Game id cannot be null");
        }
        if (players == null || players.isEmpty()) {
            throw new IllegalArgumentException("Game must have players");
        }
        
		this.id = id;
		this.players = players;
		this.gameStatus = GameStatus.CREATED;
	}
	
	//Getters
	public UUID getId() {
		return id;
	}
	public List<Player> getPlayers() {
		return players;
	}
	public List<Category> getCategories() {
		return categories;
	}
	public List<Round> getRounds() {
		return rounds;
	}
	public GameStatus getGameStatus() {
		return gameStatus;
	}
	
	//Behavior
	public void markAsInProgress() {
		this.gameStatus = GameStatus.IN_PROGRESS;
	}
	public void markAsFinished() {
		this.gameStatus = GameStatus.FINISHED;
	}
	
	@Override
	public String toString() {
		return "Game [id=" + id + ", players=" + players + ", categories=" + categories + ", rounds=" + rounds
				+ ", gameStatus=" + gameStatus + "]";
	}

}
