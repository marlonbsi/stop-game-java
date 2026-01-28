package br.com.marlon.stopgame.domain.factory;

import java.util.List;
import java.util.UUID;

import br.com.marlon.stopgame.domain.model.Category;
import br.com.marlon.stopgame.domain.model.Round;

public class RoundFactory {
	
	public Round createRound(char letter, List<Category> categories) {
		
		if(!Character.isLetter(letter)) {
			throw new IllegalArgumentException("Invalid letter!");
		}
		
		return new Round(
				UUID.randomUUID(),
				letter,
				categories
				);
	}

}
