package com.api.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.api.config.BDConfig;
import com.api.entidade.Pokemon;

public class PokemonDAO {
	
	public List<Pokemon> listaPokemons() throws Exception {
		List<Pokemon> lista = new ArrayList<>();
	
	
	Connection conexao = BDConfig.getConnection();
	
	String sql = "SELECT * FROM Pokemon";
	
	PreparedStatement statement = conexao.prepareStatement(sql);
	ResultSet rs = statement.executeQuery();
	
	while (rs.next()) {
		Pokemon pokemon = new Pokemon();
		pokemon.setId(rs.getInt("id"));
		pokemon.setName(rs.getString("name"));
		pokemon.setType_pokemon(rs.getString("type_pokemon"));
		pokemon.setPre_evolution(rs.getString("pre_evolution"));
		pokemon.setNext_evolution(rs.getString("next_evolution"));
		
		lista.add(pokemon);
		
	}
	
	return lista;
	}

	
	public Pokemon listarPokemonPorId(int idPokemon) throws Exception {
		
		Pokemon pokemon = null;
		
		
		Connection conexao = BDConfig.getConnection();
		
		String sql = "SELECT * FROM Pokemon WHERE id = ?";
		
		PreparedStatement statement = conexao.prepareStatement(sql);
		statement.setInt(1, idPokemon);
		ResultSet rs = statement.executeQuery();
		
		while (rs.next()) {
			pokemon = new Pokemon();
			pokemon.setId(rs.getInt("id"));
			pokemon.setName(rs.getString("name"));
			pokemon.setType_pokemon(rs.getString("type_pokemon"));
			pokemon.setPre_evolution(rs.getString("pre_evolution"));
			pokemon.setNext_evolution(rs.getString("next_evolution"));
			
			
		}
		
		return pokemon;
	}
		
		
		
	public void addPokemon (Pokemon pokemon) throws Exception {
		
		Connection conexao = BDConfig.getConnection();
		
		String sql = "INSERT INTO Pokemon(name, type_pokemon, pre_evolution, next_evolution) VALUES(?, ?)";
		
		PreparedStatement statement = conexao.prepareStatement(sql);
		statement.setString(1, pokemon.getName());
		statement.setString(2, pokemon.getType_pokemon());
		statement.setString(3, pokemon.getPre_evolution());
		statement.setString(4,  pokemon.getNext_evolution());
		statement.execute();
		
			
	}
	
	
	
	public void editarPokemon (Pokemon pokemon) throws Exception {
			
			Connection conexao = BDConfig.getConnection();
			
			String sql = "UPDATE Pokemon SET name = ?, type_pokemon = ?, pre_evolution = ?, next_evolution = ? WHERE id = ? ";
			
			PreparedStatement statement = conexao.prepareStatement(sql);
			statement.setString(1, pokemon.getName());
			statement.setString(2, pokemon.getType_pokemon());
			statement.setString(3, pokemon.getPre_evolution());
			statement.setString(4,  pokemon.getNext_evolution());
			statement.setInt(4,  pokemon.getId());
			statement.execute();
	
			
				
		}

	public void removerPokemon (int idPokemon) throws Exception {
		
		Connection conexao = BDConfig.getConnection();
		
		String sql = "DELETE FROM Pokemon WHERE id = ?";
		
		PreparedStatement statement = conexao.prepareStatement(sql);
		statement.setInt(1,  idPokemon);
		statement.execute();
		
	}
	
}
