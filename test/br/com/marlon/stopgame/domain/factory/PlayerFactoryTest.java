package br.com.marlon.stopgame.domain.factory;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

import org.junit.jupiter.api.Test;

import br.com.marlon.stopgame.domain.model.Player;

class PlayerFactoryTest {
	
	PlayerFactory factory = new PlayerFactory();

	@Test
	void shouldReturnAPlayerWith0Score() {
		Player player = factory.createNewPlayer("Myself");
		assertEquals(0, player.getTotalScore());
	}
	
	@Test
	void shouldCreatePlayerUUID() {
		Player player = factory.createNewPlayer("Myself");
		assertFalse(player.getId().equals(null));
	}

}