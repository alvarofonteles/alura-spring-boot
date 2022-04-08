package br.com.alura.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import br.com.alura.jdbc.factory.ConnectionFactory;
import br.com.alura.jdbc.modelo.Produto;

public class TestaInsercaoComProduto {

	public static void main(String[] args) throws SQLException {

		Produto produto = new Produto("Cômoda", "Verticalizada");

		try (Connection connection = new ConnectionFactory().recuperarConexao()) {

			connection.setAutoCommit(false);

			String sql = "insert into produto (nome, descricao) values (?,?)";

			try (PreparedStatement stm = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {

				adicionarVariavel(produto, stm);

				connection.commit();
			} catch (Exception e) {
				e.printStackTrace();
				System.out.println("Rollback executado!");
				connection.rollback();
			}
		}

	}

	private static void adicionarVariavel(Produto produto, PreparedStatement stm) throws SQLException {
		stm.setString(1, produto.getNome());
		stm.setString(2, produto.getDescricao());
		stm.execute();

		try (ResultSet rst = stm.getGeneratedKeys()) {
			while (rst.next()) {
				produto.setId(rst.getInt(1));
			}
		}
		System.out.println(produto);
	}
}
