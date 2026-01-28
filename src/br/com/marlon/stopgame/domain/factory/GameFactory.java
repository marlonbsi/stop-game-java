package br.com.marlon.stopgame.domain.factory;

import java.util.List;
import java.util.UUID;

import br.com.marlon.stopgame.domain.model.Game;
import br.com.marlon.stopgame.domain.model.Player;

public class GameFactory {
	
	public Game createNewGame(List<Player> players) {
		return new Game(UUID.randomUUID(), players);
	}

}