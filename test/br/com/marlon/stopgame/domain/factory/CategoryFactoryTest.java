package br.com.marlon.stopgame.domain.factory;

import static org.junit.jupiter.api.Assertions.assertFalse;

import org.junit.jupiter.api.Test;

import br.com.marlon.stopgame.domain.model.Category;

class CategoryFactoryTest {
	
	CategoryFactory factory = new CategoryFactory();

	@Test
	void shouldCreateACategoryUUID() {
		Category category = factory.createNewCategory("CatName");
		assertFalse(category.getId().equals(null));
	}

}
