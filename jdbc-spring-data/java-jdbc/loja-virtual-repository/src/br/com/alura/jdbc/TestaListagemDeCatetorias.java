package br.com.alura.jdbc;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import br.com.alura.jdbc.dao.CategoriaDAO;
import br.com.alura.jdbc.dao.ProdutoDAO;
import br.com.alura.jdbc.factory.ConnectionFactory;
import br.com.alura.jdbc.modelo.Categoria;
import br.com.alura.jdbc.modelo.Produto;

public class TestaListagemDeCatetorias {

	public static void main(String[] args) throws SQLException {

		try (Connection connection = new ConnectionFactory().recuperarConexao()) {

			CategoriaDAO categoriaDAO = new CategoriaDAO(connection);

			List<Categoria> listaDeCategorias = categoriaDAO.listar();
			// listaDeCategorias.stream().forEach(lc -> System.out.println(lc.getNome()));
			listaDeCategorias.stream().forEach(lc -> {
				System.out.println(lc.getNome());

				try {
					for (Produto produto : new ProdutoDAO(connection).buscar(lc)) {
						System.out.println(lc.getNome() + " - " + produto.getNome());
					}
				} catch (SQLException e) {
					e.printStackTrace();
				}
			});
		}
	}

}
