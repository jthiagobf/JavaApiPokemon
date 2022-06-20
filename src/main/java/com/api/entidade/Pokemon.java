package com.api.entidade;

public class Pokemon {
	private int id;
	
	private String name;
	
	private String type_pokemon;
	
	private String pre_evolution;
	
	private String next_evolution;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getType_pokemon() {
		return type_pokemon;
	}

	public void setType_pokemon(String type_pokemon) {
		this.type_pokemon = type_pokemon;
	}

	public String getPre_evolution() {
		return pre_evolution;
	}

	public void setPre_evolution(String pre_evolution) {
		this.pre_evolution = pre_evolution;
	}

	public String getNext_evolution() {
		return next_evolution;
	}

	public void setNext_evolution(String next_evolution) {
		this.next_evolution = next_evolution;
	}
	
	
}
