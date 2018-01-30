package persistence.dao.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

import model.Utente;
import persistence.DataSource;
import persistence.PersistenceException;
import persistence.dao.UtenteDao;

public class UtenteDaoJDBC implements UtenteDao {
	
	private DataSource dataSource;
	
	public UtenteDaoJDBC(DataSource dataSource) {
		this.dataSource = dataSource;
	}

	@Override
	public void save(Utente utente, String password) {
		Connection connection = this.dataSource.getConnection();
		try {
			String insert = "insert into utente (username, email, password) values (?, ?, ?)";
			PreparedStatement statement = connection.prepareStatement(insert);
			statement.setString(1, utente.getUsername());
			statement.setString(2, utente.getEmail());
			statement.setString(3, password);
			statement.executeUpdate();
		} catch (SQLException e) {
			throw new PersistenceException(e.getMessage());
		} finally {
			try {
				connection.close();
			} catch (SQLException e) {
				throw new PersistenceException(e.getMessage());
			}
		}
	}
	
	@Override
	public Utente findByPrimaryKey(String username) {
		Connection connection = this.dataSource.getConnection();
		Utente utente = null;
		try {
			PreparedStatement statement;
			String query = "select * from utente where username = ?";
			statement = connection.prepareStatement(query);
			statement.setString(1, username);
			ResultSet result = statement.executeQuery();
			if (result.next()) {
				utente = new UtenteProxy(dataSource);
				utente.setUsername(result.getString("username"));
				utente.setEmail(result.getString("email"));		
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
		return utente;
	}

	@Override
	public List<Utente> findAll() {		
		Connection connection = this.dataSource.getConnection();
		List<Utente> utenti = new LinkedList<>();
		try {
			Utente utente = null;
			PreparedStatement statement;
			String query = "select * from utente";
			statement = connection.prepareStatement(query);
			ResultSet result = statement.executeQuery();
			while (result.next()) {
				utente = new UtenteProxy(dataSource);
				utente.setUsername(result.getString("username"));
				utente.setEmail(result.getString("email"));		
				utenti.add(utente);
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
		return utenti;
	}

	@Override
	public void update(Utente utente) {
		Connection connection = this.dataSource.getConnection();
		try {
			String update = "update utente set email = ? where username = ?";
			PreparedStatement statement = connection.prepareStatement(update);
			statement.setString(1, utente.getEmail());
			statement.setString(2, utente.getUsername());
			statement.executeUpdate();
			
		} catch (SQLException e) {
			throw new PersistenceException(e.getMessage());
		} finally {
			try {
				connection.close();
			} catch (SQLException e) {
				throw new PersistenceException(e.getMessage());
			}
		}
	}

	@Override
	public void delete(Utente utente) {
		Connection connection = this.dataSource.getConnection();
		try {
			String delete = "delete from utente where username = ?";
			PreparedStatement statement = connection.prepareStatement(delete);
			statement.setString(1, utente.getUsername());
			statement.executeUpdate();
		} catch (SQLException e) {
			throw new PersistenceException(e.getMessage());
		} finally {
			try {
				connection.close();
			} catch (SQLException e) {
				throw new PersistenceException(e.getMessage());
			}
		}
	}

	@Override
	public UtenteCredenziali findByPrimaryKeyCredential(String username) {
		Utente utente = findByPrimaryKey(username);
		UtenteCredenziali utenteCredenziali = null;
		if (utente != null) {
			utenteCredenziali = new UtenteCredenziali(dataSource);
			utenteCredenziali.setUsername(utente.getUsername());
		}
		return utenteCredenziali;
	}
			
	@Override
	public void setPassword(Utente utente, String password) {
		Connection connection = this.dataSource.getConnection();
		try {
			String update = "update utente set password = ? where username = ?";
			PreparedStatement statement = connection.prepareStatement(update);
			statement.setString(1, password);
			statement.executeUpdate();
		} catch (SQLException e) {
			throw new PersistenceException(e.getMessage());
		} finally {
			try {
				connection.close();
			} catch (SQLException e) {
				throw new PersistenceException(e.getMessage());
			}
		}
	}
	
}
