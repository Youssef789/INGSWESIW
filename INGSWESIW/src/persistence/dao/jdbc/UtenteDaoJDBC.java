package persistence.dao.jdbc;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

import model.Ricetta;
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
			File immagineProfilo = utente.getImmagineProfilo(); 
			if (immagineProfilo == null) {
				immagineProfilo = new File("WebContent/images/default-profile-picture.jpg"); /* path dell'immagine di default del profilo utente */
			} 			
			FileInputStream fis = new FileInputStream(immagineProfilo);
			insert = "insert into immagine_profilo (immagine_nome, immagine, utente_username) values (?, ?, ?)";
			statement = connection.prepareStatement(insert);
			statement.setString(1, immagineProfilo.getName());
			statement.setBinaryStream(2, fis, immagineProfilo.length());
			statement.setString(3, utente.getUsername());
			statement.executeUpdate();
			fis.close();
		} catch (SQLException e) {
			throw new PersistenceException(e.getMessage());
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
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
	public Utente findByEmail(String email) {
		Connection connection = this.dataSource.getConnection();
		Utente utente = null;
		try {
			PreparedStatement statement;
			String query = "select * from utente where email = ?";
			statement = connection.prepareStatement(query);
			statement.setString(1, email);
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
	
	public void insertRicettaPreferita(Ricetta ricetta, Utente utente) {
		Connection connection = this.dataSource.getConnection();
		try {
			PreparedStatement statement;
			String query = "select * from ricetta_preferita where ricetta_id = ? and utente_username = ?";
			statement = connection.prepareStatement(query);
			statement.setLong(1, ricetta.getId());
			statement.setString(2, utente.getUsername());
			ResultSet result = statement.executeQuery();
			if (!result.next()) {
				String insert = "insert into ricetta_preferita (ricetta_id, utente_username) values (?, ?)";
				statement = connection.prepareStatement(insert);
				statement.setLong(1, ricetta.getId());
				statement.setString(2, utente.getUsername());
				statement.executeUpdate();
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
	}
	
	public void deleteRicettaPreferita(Ricetta ricetta, Utente utente) {
		Connection connection = this.dataSource.getConnection();
		try {
			PreparedStatement statement;
			String query = "select * from ricetta_preferita where ricetta_id = ? and utente_username = ?";
			statement = connection.prepareStatement(query);
			statement.setLong(1, ricetta.getId());
			statement.setString(2, utente.getUsername());
			ResultSet result = statement.executeQuery();
			if (result.next()) {
				String delete = "delete from ricetta_preferita where ricetta_id = ? and utente_username = ?";
				statement = connection.prepareStatement(delete);
				statement.setLong(1, ricetta.getId());
				statement.setString(2, utente.getUsername());
				statement.executeUpdate();
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
	}

}
