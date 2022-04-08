package br.com.alura.jdbc;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import br.com.alura.jdbc.factory.ConnectionFactory;

public class TestaListagem {

	public static void main(String[] args) throws SQLException {

		ConnectionFactory connectionFactory = new ConnectionFactory();
		Connection conn = connectionFactory.recuperarConexao();

//		Statement stm = conn.createStatement();
//		stm.execute("select id, nome, descricao from produto");

		PreparedStatement stm = conn.prepareStatement("select id, nome, descricao from produto");
		stm.execute();

		ResultSet rst = stm.getResultSet();

		while (rst.next()) {

			Integer id = rst.getInt("ID");
			System.out.println(id);

			String nome = rst.getString("NOME");
			System.out.println(nome);

			String descricao = rst.getString("DESCRICAO");
			System.out.println(descricao);

		}

		System.out.println("Fechando Conexão!!");
		conn.close();

	}

}
