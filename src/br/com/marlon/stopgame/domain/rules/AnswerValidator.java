package br.com.marlon.stopgame.domain.rules;

import br.com.marlon.stopgame.domain.model.AnswerStatus;

public interface AnswerValidator {
	
	AnswerStatus validate(char letter, String answer);

}
