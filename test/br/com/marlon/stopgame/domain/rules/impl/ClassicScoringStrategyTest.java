package br.com.marlon.stopgame.domain.rules.impl;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.jupiter.api.Test;

import br.com.marlon.stopgame.domain.factory.CategoryFactory;
import br.com.marlon.stopgame.domain.model.Answer;
import br.com.marlon.stopgame.domain.model.Category;

class ClassicScoringStrategyTest {
	
	ClassicScoringStrategy strategy = new ClassicScoringStrategy();
	CategoryFactory categoryFactory = new CategoryFactory();
	Category category = categoryFactory.createNewCategory("CatName");
	Answer answer = new Answer(category, "Cap");
	

	@Test
	void shouldScore0PointWhenInvalidAnswer() {
		List<Answer> sameCategoryAnswers = List.of(
				new Answer(category, "Cup")
				);
		Answer answer = new Answer(category, "Pen");
		answer.markAsInvalid();
		assertEquals(0, strategy.score(answer, sameCategoryAnswers));
	}
	
	@Test
	void shouldScore5PointWhenDuplicateAnswer() {
		List<Answer> sameCategoryAnswers = List.of(
				new Answer(category, "Cup"),
				new Answer(category, "Cap")
				);
		answer.markAsValid();
		assertEquals(5, strategy.score(answer, sameCategoryAnswers));
	}
	
	@Test
	void shouldScore10PointWhenUniqueAnswer() {
		List<Answer> sameCategoryAnswers = List.of(
				new Answer(category, "Cup")
				);
		answer.markAsValid();
		assertEquals(10, strategy.score(answer, sameCategoryAnswers));
	}

}
