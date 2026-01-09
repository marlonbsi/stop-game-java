package br.com.marlon.stopgame.domain.rules.impl;

import java.util.Random;

import br.com.marlon.stopgame.domain.rules.LetterGenerator;

public class RandomLetterGenerator implements LetterGenerator{

	@Override
	public char generate() {
		return (char) ('A' + new Random().nextInt(26));
	}

}
