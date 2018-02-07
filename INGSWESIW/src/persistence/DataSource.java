package persistence;

import java.sql.*;

public class DataSource {
								
	final private String dbURI; // = "jdbc:postgresql://localhost/SoRecipes";
	
	final private String username; // = "postgres";
	final private String password; // = "postgres";

	public DataSource(String dbURI, String username, String password) {
		this.dbURI = dbURI;
		this.username = username;
		this.password = password;
	}

	public Connection getConnection() throws PersistenceException {
		Connection connection = null;
		try {
			connection = DriverManager.getConnection(dbURI, username, password);	
		} catch (SQLException e) {
			throw new PersistenceException(e.getMessage());
		}
		return connection;
	}
	
}
