package br.com.marlon.stopgame.domain.rules.impl;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import br.com.marlon.stopgame.domain.model.AnswerStatus;
import br.com.marlon.stopgame.domain.rules.AnswerValidator;

class AnswerValidatorTest {

	
    @Test
    void shouldAcceptAnswerStartingWithLetter() {
        AnswerValidator validator = new SimpleAnswerValidator();

        assertTrue(AnswerStatus.VALID == validator.validate('C', "cap"));
    }
    
    @Test
    void shouldRejectAnswerWithWrongLetter() {
        AnswerValidator validator = new SimpleAnswerValidator();

        assertFalse(AnswerStatus.VALID == validator.validate('A', "Pen"));
    }
    
    @Test
    void shouldReturnInvalidAnswerWithWrongLetter() {
    	AnswerValidator validator = new SimpleAnswerValidator();
    	
    	assertTrue(AnswerStatus.INVALID == validator.validate('D', "keyboard"));
    }
    
}
