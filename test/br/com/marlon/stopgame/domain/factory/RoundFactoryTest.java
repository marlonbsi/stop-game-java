package br.com.marlon.stopgame.domain.factory;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.List;

import org.junit.jupiter.api.Test;

import br.com.marlon.stopgame.domain.model.Category;
import br.com.marlon.stopgame.domain.model.Round;
import br.com.marlon.stopgame.domain.model.RoundStatus;

class RoundFactoryTest {
	
	RoundFactory factory = new RoundFactory();
	CategoryFactory categoryFactory = new CategoryFactory();
	List<Category> categories = List.of(
			categoryFactory.createNewCategory("Brand"),
			categoryFactory.createNewCategory("Name")
			);

	@Test
	void shouldReturnANotStartedRoundWhenCreated() {
		Round round = factory.createRound('A', categories);
		assertEquals(RoundStatus.NOT_STARTED, round.getStatus());
	}
	
	@Test
	void shouldThrowIllegalArgumentExceptionWhenNotALetter() {
		assertThrows(IllegalArgumentException.class, () -> {
			@SuppressWarnings("unused")
			Round round = factory.createRound('-', categories);
		});
	}
	
	@Test
	void shouldCreateRoundId() {
		Round round = factory.createRound('A', categories);
		assertFalse(round.getId().equals(null));
	}
	
	@Test
	void shouldCreateARoundWithCorrespondingLetter() {
		Round round = factory.createRound('A', categories);
		assertEquals('A', round.getLetter());
	}
	
	@Test
	void shouldThrowIllegalArgumentExceptionWhenEmptyCategories() {
		List<Category> blankCategories = List.of();
		assertThrows(IllegalArgumentException.class, () ->{
			@SuppressWarnings("unused")
			Round round = factory.createRound('A', blankCategories);
		});
	}

}
