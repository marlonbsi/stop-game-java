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
		
		long duplicates = sameCategoryAnswers.stream()
				.filter(a -> a.getValue().equalsIgnoreCase(answer.getValue()))
				.count();
		
		return duplicates > 0 ? 5 : 10;
	}

}
