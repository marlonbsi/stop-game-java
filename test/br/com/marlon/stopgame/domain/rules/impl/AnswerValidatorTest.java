package br.com.marlon.stopgame.domain.rules.impl;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import br.com.marlon.stopgame.domain.model.AnswerStatus;
import br.com.marlon.stopgame.domain.rules.AnswerValidator;

class AnswerValidatorTest {

	AnswerValidator validator = new SimpleAnswerValidator();
	
    @Test
    void shouldAcceptAnswerStartingWithLetter() {
        assertTrue(AnswerStatus.VALID == validator.validate('C', "cap"));
    }
    
    @Test
    void shouldRejectAnswerWithWrongLetter() {
        assertFalse(AnswerStatus.VALID == validator.validate('A', "Pen"));
    }
    
    @Test
    void shouldReturnInvalidAnswerWithWrongLetter() {
    	assertTrue(AnswerStatus.INVALID == validator.validate('D', "keyboard"));
    }
    
    @Test
    void shouldReturnEmptyWithEmptyAnswer() {
    	String emptyString = null;
    	assertTrue(AnswerStatus.EMPTY == validator.validate('F', emptyString));
    	
    }
    
}
