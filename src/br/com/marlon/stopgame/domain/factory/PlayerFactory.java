package br.com.marlon.stopgame.domain.factory;

import java.util.UUID;

import br.com.marlon.stopgame.domain.model.Player;

public class PlayerFactory {
	
	public Player createNewPlayer(String name) {	
		return new Player(UUID.randomUUID(), name);
	}

}
