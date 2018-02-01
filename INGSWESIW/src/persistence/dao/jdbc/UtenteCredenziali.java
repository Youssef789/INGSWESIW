package persistence.dao.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import model.Utente;
import persistence.DataSource;
import persistence.PersistenceException;

public class UtenteCredenziali extends Utente {
	
	private DataSource dataSource;
	
	public UtenteCredenziali(DataSource dataSource) {
		this.dataSource = dataSource;
	}

	public String getPassword() {						
		Connection connection = this.dataSource.getConnection();
		try {
			PreparedStatement statement;
			String query = "select password from utente where username = ?";
			statement = connection.prepareStatement(query);
			statement.setString(1, getUsername());
			ResultSet result = statement.executeQuery();
			if (result.next()) {
				return result.getString("password");
			}
		} catch (SQLException e) {
			throw new PersistenceException(e.getMessage());
		} finally {
			try {
				connection.close();
			} catch (SQLException e) {
				throw new PersistenceException(e.getMessage());
			}
		}	
		return null;
	}
	
	@Override
	public String toString() {
		return "UtenteCredenziali [username = " + this.getUsername() + ", password = " + this.getPassword() + "]";
	}

}
