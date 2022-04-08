package br.com.alura.jdbc.controller;

import java.sql.Connection;
import java.util.List;

import br.com.alura.jdbc.dao.CategoriaDAO;
import br.com.alura.jdbc.factory.ConnectionFactory;
import br.com.alura.jdbc.modelo.Categoria;

public class CategoriaController {

	private CategoriaDAO categoriaDAO;

	public CategoriaController() {
		try {
			Connection connection = new ConnectionFactory().recuperarConexao();
			this.categoriaDAO = new CategoriaDAO(connection);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
	
	public List<Categoria> listar() {		
		return this.categoriaDAO.listar();
	}

//	public List<Categoria> listar() {
//		List<Categoria> categorias = new ArrayList<Categoria>();
//		categorias.add(new Categoria(1, "Categoria de teste"));
//		return categorias;
//	}
}
