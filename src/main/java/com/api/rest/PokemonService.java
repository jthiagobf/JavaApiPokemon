package com.api.rest;

import java.util.List;

import com.api.dao.PokemonDAO;
import com.api.entidade.Pokemon;

import jakarta.annotation.PostConstruct;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

@Path("/pokemons")
public class PokemonService {
	
	private PokemonDAO pokemonDAO;
	
	@PostConstruct
	private void init() {
		pokemonDAO = new PokemonDAO();
	}
	
	@GET
	@Path("/list")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Pokemon> listarPokemons() {
		List<Pokemon> lista = null;
		try {
			lista = pokemonDAO.listarPokemons();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return lista;
	}
}
