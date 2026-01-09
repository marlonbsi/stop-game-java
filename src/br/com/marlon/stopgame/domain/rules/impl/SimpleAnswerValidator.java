package br.com.marlon.stopgame.domain.rules.impl;

import br.com.marlon.stopgame.domain.model.AnswerStatus;
import br.com.marlon.stopgame.domain.rules.AnswerValidator;

public class SimpleAnswerValidator implements AnswerValidator{

	@Override
	public AnswerStatus validate(char letter, String answer) {
		if(answer == null || answer.isBlank()) {
			return AnswerStatus.EMPTY;
		}
		
		if(Character.toUpperCase(answer.charAt(0)) != Character.toUpperCase(letter)) {
			return AnswerStatus.INVALID;
		}
		
		return AnswerStatus.VALID;
	}

}
