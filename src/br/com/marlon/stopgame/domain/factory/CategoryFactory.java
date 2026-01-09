package br.com.marlon.stopgame.domain.factory;

import java.util.UUID;

import br.com.marlon.stopgame.domain.model.Category;

public class CategoryFactory {
	
	public Category createNewCategory(String name) {
		return new Category(UUID.randomUUID(), name);
	}

}
