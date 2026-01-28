package br.com.marlon.stopgame.domain.service;

import br.com.marlon.stopgame.domain.factory.RoundFactory;
import br.com.marlon.stopgame.domain.rules.AnswerValidator;
import br.com.marlon.stopgame.domain.rules.LetterGenerator;
import br.com.marlon.stopgame.domain.rules.ScoringStrategy;

public class RoundService {
	
	private final RoundFactory roundFactory;
	private final LetterGenerator letterGenerator;
	private final AnswerValidator answerValidator;
	private final ScoringStrategy scoringStrategy;
	
	public RoundService(
			RoundFactory roundFactory,
			LetterGenerator letterGenerator,
			AnswerValidator answerValidator,
			ScoringStrategy scoringStrategy
			) {
		this.roundFactory = roundFactory;
		this.letterGenerator = letterGenerator;
		this.answerValidator = answerValidator;
		this.scoringStrategy = scoringStrategy;
	}
	
	

}
