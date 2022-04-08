package br.com.alura.jdbc;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

import br.com.alura.jdbc.factory.ConnectionFactory;

public class TestaRemocao {

	public static void main(String[] args) throws SQLException {
		ConnectionFactory connectionFactory = new ConnectionFactory();
		Connection connection = connectionFactory.recuperarConexao();

//		Statement stm = connection.createStatement();
//		stm.execute("delete from produto where id > 2", Statement.RETURN_GENERATED_KEYS);

		PreparedStatement stm = connection.prepareStatement("delete from produto where id > ?",
				Statement.RETURN_GENERATED_KEYS);
		stm.setInt(1, 2);
		stm.execute();

		Integer linhasModificadas = stm.getUpdateCount();
		System.out.println("Quantidade de linhas que foi modificada: " + linhasModificadas);

		stm.close();
		connection.close();
	}

}
