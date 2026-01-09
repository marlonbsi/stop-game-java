package br.com.marlon.stopgame.domain.model;

import java.util.UUID;

public class Category {
	
	private UUID id;
	private String name;
	
	public Category(UUID id, String name) {
		this.id = id;
		this.name = name;
	}
	
	//Getters
	public UUID getId() {
		return id;
	}
	public String getName() {
		return name;
	}

	@Override
	public String toString() {
		return "Category [id=" + id + ", name=" + name + "]";
	}
	
}
