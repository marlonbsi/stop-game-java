package br.com.marlon.stopgame.domain.rules.impl;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class RandomLetterGeneratorTest {

	@Test
	void shouldReturnAnUpperCaseChar() {
		RandomLetterGenerator generator = new RandomLetterGenerator();
		assertTrue(Character.isUpperCase(generator.generate()));
	}

}
