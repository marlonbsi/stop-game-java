package br.com.marlon.stopgame.domain.factory;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;

import org.junit.jupiter.api.Test;

import br.com.marlon.stopgame.domain.model.Game;
import br.com.marlon.stopgame.domain.model.GameStatus;
import br.com.marlon.stopgame.domain.model.Player;

class GameFactoryTest {
	
	PlayerFactory playerFactory = new PlayerFactory();
	GameFactory factory = new GameFactory();
	
	List<Player> players = List.of(
			playerFactory.createNewPlayer("Myself"),
			playerFactory.createNewPlayer("Yourself")
			);
	
	@Test
	void shouldReturnACreatedGame() {
		Game game = factory.createNewGame(players);
		assertTrue(GameStatus.CREATED == game.getGameStatus());
	}
	
	@Test
	void shouldReturnAGameMatchingPlayers() {
		Game game = factory.createNewGame(players);
		assertTrue(players == game.getPlayers());
	}
	
	@Test
	void shouldCreateAGameUUID() {
		Game game = factory.createNewGame(players);
		assertFalse(game.getId().equals(null));
	}

}