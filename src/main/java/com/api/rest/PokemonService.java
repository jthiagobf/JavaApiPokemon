package com.api.rest;

import java.util.List;

import com.api.dao.PokemonDAO;
import com.api.entidade.Pokemon;

import jakarta.annotation.PostConstruct;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
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
	
	@GET
	@Path("/get/{id}")
	@Consumes(MediaType.TEXT_PLAIN)
	@Produces(MediaType.APPLICATION_JSON)
	public Pokemon listarPorId(@PathParam("id") int idPokemon) {
		Pokemon pokemon = null;
		
		try {
			pokemon = pokemonDAO.listarPokemonPorId(idPokemon);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return pokemon;
	}
	
	
	@POST
	@Path("/novo/{id}")
	@Consumes(MediaType.TEXT_PLAIN)
	@Produces(MediaType.APPLICATION_JSON)
	public String addNovoPokemon(Pokemon pokemon, @PathParam("id") int idPokemon) {
		String msg = "";
		
		System.out.println(pokemon.getName());
		
		try {
			pokemonDAO.addPokemon(pokemon);
		} catch (Exception e) {
			msg = "Erro ao editar pokemon";
			e.printStackTrace();
		}
		
		return msg;
	}
	
	
	@PUT
	@Path("/edit/{id}")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.TEXT_PLAIN)
	public String editarPokemon(Pokemon pokemon, @PathParam("id") int idPokemon) {
		String msg = "";
		
		System.out.println(pokemon.getName());
		
		try {
			pokemonDAO.editarPokemon(pokemon, idPokemon);
		} catch (Exception e) {
			msg = "Erro ao editar pokemon";
			e.printStackTrace();
		}
		
		return msg;
	}
	
	
	
	
	
	
	@DELETE
	@Path("/delete/{id}")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.TEXT_PLAIN)
	public String deletarNota(@PathParam("id") int idPokemon) {
		String msg = "";
		
		try {
			pokemonDAO.removerPokemon(idPokemon);
			
			msg = "Pokemon removido com sucesso";
			} catch (Exception e) {
				msg = "Erro ao remover pokemon";
				e.printStackTrace();
			}
		
		return msg;
	}
	
}
