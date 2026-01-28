package br.com.marlon.stopgame.domain.rules.impl;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.jupiter.api.Test;

import br.com.marlon.stopgame.domain.factory.CategoryFactory;
import br.com.marlon.stopgame.domain.model.Answer;
import br.com.marlon.stopgame.domain.model.AnswerStatus;
import br.com.marlon.stopgame.domain.model.Category;

class ClassicScoringStrategyTest {
	
	ClassicScoringStrategy strategy = new ClassicScoringStrategy();
	CategoryFactory categoryFactory = new CategoryFactory();
	Category category = categoryFactory.createNewCategory("CatName");
	Answer answer = new Answer(category, "Cap", AnswerStatus.PENDING);
	

	@Test
	void shouldScore0PointWhenInvalidAnswer() {
		List<Answer> sameCategoryAnswers = List.of(
				new Answer(category, "Cup", AnswerStatus.PENDING)
				);
		Answer answer = new Answer(category, "Pen", AnswerStatus.PENDING);
		answer.markAsInvalid();
		assertEquals(0, strategy.score(answer, sameCategoryAnswers));
	}
	
	@Test
	void shouldScore5PointWhenDuplicateAnswer() {
		List<Answer> sameCategoryAnswers = List.of(
				new Answer(category, "Cup", AnswerStatus.PENDING),
				new Answer(category, "Cap", AnswerStatus.PENDING)
				);
		answer.markAsValid();
		assertEquals(5, strategy.score(answer, sameCategoryAnswers));
	}
	
	@Test
	void shouldScore10PointWhenUniqueAnswer() {
		List<Answer> sameCategoryAnswers = List.of(
				new Answer(category, "Cup", AnswerStatus.PENDING)
				);
		answer.markAsValid();
		assertEquals(10, strategy.score(answer, sameCategoryAnswers));
	}

}
