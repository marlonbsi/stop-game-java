package br.com.marlon.stopgame.domain.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import br.com.marlon.stopgame.domain.factory.CategoryFactory;
import br.com.marlon.stopgame.domain.factory.PlayerFactory;
import br.com.marlon.stopgame.domain.factory.RoundFactory;

class RoundTest {
	
	private Round round;
	private Category category;
	private Player player;
	private RoundFactory factory = new RoundFactory();
	private PlayerFactory playerFactory = new PlayerFactory();
	private CategoryFactory categoryFactory = new CategoryFactory();
	
	@BeforeEach
	void setup() {
		this.player = playerFactory.createNewPlayer("Myself");
		this.category = categoryFactory.createNewCategory("Animal");
		this.round = factory.createRound('T', List.of(category));
	}

	@Test
	void shouldCreateRoundwithValidData() {
		assertEquals(RoundStatus.NOT_STARTED, round.getStatus());
		assertEquals('T', round.getLetter());
	}
	
	@Test
	void shoudThrowExceptionWhenSubmittingBeforeStart() {
		assertThrows(IllegalArgumentException.class, () -> round.submitAnswer(player, category, "T-Rex"));
	}
	
	@Test
	void shouldStartRound() {
		round.start();
		assertEquals(RoundStatus.RUNNING, round.getStatus());
	}
	
	@Test
	void shouldNotStartRoundTwice() {
		round.start();
		assertThrows(IllegalArgumentException.class, round::start);
	}
	
	@Test
	void shuouldAcceptAnswerWhileRunning() {
		round.start();
		round.submitAnswer(player, category, "T-Rex");
		assertEquals(1, round.getAnswerSheets().size());
	}
	
	@Test
	void shouldRejectInvalidCategory() {
		round.start();
		Category invalid = categoryFactory.createNewCategory("City");
		assertThrows(IllegalArgumentException.class, () -> 
			round.submitAnswer(player, invalid, "Toronto")
		);
	}
	
	@Test
	void shouldNotAcceptAnswersAfterFinished() {
		round.start();
		round.finish();
		
		assertThrows(IllegalArgumentException.class, () ->
			round.submitAnswer(player, category, "Turin")
		);
	}

}
