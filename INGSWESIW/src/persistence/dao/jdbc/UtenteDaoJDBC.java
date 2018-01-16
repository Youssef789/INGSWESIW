package persistence.dao.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

import model.Utente;
import persistence.DataSource;
import persistence.IdBroker;
import persistence.PersistenceException;
import persistence.dao.UtenteDao;

public class UtenteDaoJDBC implements UtenteDao{
	
	private DataSource dataSource;
	
	public UtenteDaoJDBC(DataSource dataSource) {
		this.dataSource=dataSource;
	}

	@Override
	public void save(Utente utente) {
		Connection connection = this.dataSource.getConnection();
		try {
			Long id = IdBroker.getId(connection);
			utente.setId(id);
			String insert = "insert into utente(id,name,username,email) values (?,?,?,?)";
			PreparedStatement statement = connection.prepareStatement(insert);

			statement.setLong(1, utente.getId());
			statement.setString(2, utente.getName());
			statement.setString(3, utente.getUsername());
			statement.setString(4, utente.getEmail());
			
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
	public Utente findByPrimaryKey(String email) {
		
		Connection connection = this.dataSource.getConnection();
		Utente utente = null;
		try {
			PreparedStatement statement;
			String query = "select * from utente where email = ?";
			statement = connection.prepareStatement(query);
			statement.setString(1, email);
			ResultSet result = statement.executeQuery();
			if (result.next()) {
				utente = new Utente();
				utente.setName(result.getString("name"));
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
			Utente utente;
			PreparedStatement statement;
			String query = "select * from utente";
			statement = connection.prepareStatement(query);
			ResultSet result = statement.executeQuery();
			while (result.next()) {
				utente = new Utente();
				utente.setName(result.getString("name"));
				utente.setUsername(result.getString("username"));
				utente.setEmail(result.getString("email"));		
				
				utenti.add(utente);
			}
		} catch (SQLException e) {
			throw new PersistenceException(e.getMessage());
		}	 finally {
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
			String update = "update utente SET name = ?, username = ? WHERE email=?";

			PreparedStatement statement = connection.prepareStatement(update);
			statement.setString(1, utente.getName());
			statement.setString(2, utente.getUsername());
			statement.setString(3, utente.getEmail());
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
			String delete = "delete FROM utente WHERE email = ? ";
			PreparedStatement statement = connection.prepareStatement(delete);
			statement.setString(1, utente.getEmail());
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
	public void setPassword(Utente utente, String password) {
		Connection connection = this.dataSource.getConnection();
		try {
			String update = "update utente SET password = ? WHERE email=?";
			PreparedStatement statement = connection.prepareStatement(update);
			statement.setString(1, password);
			statement.setString(2, utente.getEmail());
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
	public boolean checkLogin(String email, String password) {
		boolean status=false;
	
		Connection connection = this.dataSource.getConnection();
		//Utente utente = null;
		try {
			PreparedStatement statement;
			String query = "select * from utente where email = ? and password = ?";
			statement = connection.prepareStatement(query);
			statement.setString(1, email);
			statement.setString(2, password);
			ResultSet result = statement.executeQuery();
			status= result.next();
			}catch (SQLException e) {
				throw new PersistenceException(e.getMessage());
			}
		return status;
			

	}

	@Override
	public UtenteConPassword findByPrimaryKeyCredential(String email) {
		Utente utente = findByPrimaryKey(email);
		UtenteConPassword utenteCredenziali = null;
		if (utente != null){
			utenteCredenziali = new UtenteConPassword(dataSource);
			utenteCredenziali.setName(utente.getName());
			utenteCredenziali.setUsername(utente.getUsername());
			utenteCredenziali.setEmail(utente.getEmail());
		}
		return utenteCredenziali;
	}

	

}
