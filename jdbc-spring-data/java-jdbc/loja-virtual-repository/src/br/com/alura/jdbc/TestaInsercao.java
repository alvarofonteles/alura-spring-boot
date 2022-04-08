package br.com.alura.jdbc;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import br.com.alura.jdbc.factory.ConnectionFactory;

public class TestaInsercao {

	public static void main(String[] args) throws SQLException {

		ConnectionFactory connectionFactory = new ConnectionFactory();
		Connection connection = connectionFactory.recuperarConexao();

//		Statement stm = connection.createStatement();
//		stm.execute("insert into produto (nome, descricao) values ('SMARTTV','SMARTTV LG')",
//				Statement.RETURN_GENERATED_KEYS);

		PreparedStatement stm = connection.prepareStatement(
				"insert into produto (nome, descricao) values ('SMARTTV','SMARTTV SAMSUNG 55\"')",
				Statement.RETURN_GENERATED_KEYS);
		stm.execute();

		ResultSet rst = stm.getGeneratedKeys();
		while (rst.next()) {
			Integer id = rst.getInt(1);
			System.out.println("O id criado foi: " + id);
		}
		
		stm.close();
		connection.close();
	}

}
