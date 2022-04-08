package br.com.alura.jdbc;

import java.sql.Connection;
import java.sql.SQLException;

import br.com.alura.jdbc.dao.ProdutoDAO;
import br.com.alura.jdbc.factory.ConnectionFactory;
import br.com.alura.jdbc.modelo.Produto;

public class TestaInsercaoProdutoComPersistencia {

	public static void main(String[] args) throws SQLException {

		Produto produto = new Produto("Cômoda", "Verticalizada");

		try (Connection connection = new ConnectionFactory().recuperarConexao()) {
			ProdutoDAO produtoDAO = new ProdutoDAO(connection);
			produtoDAO.salvar(produto);
		}
		System.out.println(produto);
	}

}
