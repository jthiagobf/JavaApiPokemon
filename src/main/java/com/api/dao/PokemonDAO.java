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
}
