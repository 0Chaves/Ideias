package Ideias_DAO;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {
	
	public static Connection getConnection(){
		//Estabelecer conexão com o banco de dados
		String login = "postgres";
		String senha = "postgres";
		String urlcon = "jdbc:postgresql://localhost:5432/banco";
		try {
			return DriverManager.getConnection(urlcon, login, senha);
		}
		catch(SQLException e) {
			throw new RuntimeException(e);
		}			 
	}
}
