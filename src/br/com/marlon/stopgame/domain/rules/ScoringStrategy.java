package br.com.marlon.stopgame.domain.rules;

import java.util.List;

import br.com.marlon.stopgame.domain.model.Answer;

public interface ScoringStrategy {
	
	int score(Answer answer, List<Answer> sameCategoryAnswers);

}
