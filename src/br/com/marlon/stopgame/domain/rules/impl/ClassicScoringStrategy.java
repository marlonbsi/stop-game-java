package br.com.marlon.stopgame.domain.rules.impl;

import java.util.List;

import br.com.marlon.stopgame.domain.model.Answer;
import br.com.marlon.stopgame.domain.model.AnswerStatus;
import br.com.marlon.stopgame.domain.rules.ScoringStrategy;

public class ClassicScoringStrategy implements ScoringStrategy{

	@Override
	public int score(Answer answer, List<Answer> sameCategoryAnswers) {
		if(answer.getStatus() != AnswerStatus.VALID) {
			return 0;
		}
		
		boolean duplicated = sameCategoryAnswers.stream()
				.anyMatch(a -> a != answer && a.getValue().equalsIgnoreCase(answer.getValue()));
		
		return duplicated ? 5 : 10;
	}

}
