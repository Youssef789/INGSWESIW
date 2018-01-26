package persistence.dao.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

import model.Ricetta;
import model.Utente;
import model.Voto;
import persistence.DataSource;
import persistence.IdBroker;
import persistence.PersistenceException;
import persistence.dao.RicettaDao;
import persistence.dao.UtenteDao;
import persistence.dao.VotoDao;

public class VotoDaoJDBC implements VotoDao {

	private DataSource dataSource;

	public VotoDaoJDBC(DataSource dataSource) {
		this.dataSource = dataSource;
	}

	@Override
	public void save(Voto voto) {
		Connection connection = this.dataSource.getConnection();
		try {
			Long id = IdBroker.getId(connection);
			voto.setId(id);
			String insert = "insert into voto (id, valore, ricetta_id, utente_username) values (?, ?, ?, ?)";
			PreparedStatement statement = connection.prepareStatement(insert);
			statement.setLong(1, voto.getId());
			statement.setLong(2, voto.getValore());
			statement.setLong(3, voto.getRicetta().getId());
			statement.setString(4, voto.getUtente().getUsername());
			statement.executeUpdate();
		} catch (SQLException e1) {
			if (connection != null) {
				try {
					connection.rollback();
				} catch(SQLException e2) {
					throw new PersistenceException(e2.getMessage());
				}
			} 
		} finally {
			try {
				connection.close();
			} catch (SQLException e) {
				throw new PersistenceException(e.getMessage());
			}
		}
	}

	@Override
	public Voto findByPrimaryKey(Long id) {
		Connection connection = this.dataSource.getConnection();
		Voto voto = null;
		try {
			PreparedStatement statement;
			String query = "select * from voto where id = ?";
			statement = connection.prepareStatement(query);
			statement.setLong(1, id);
			ResultSet result = statement.executeQuery();
			if (result.next()) {
				voto = new Voto();
				voto.setId(result.getLong("id"));
				voto.setValore(result.getInt("valore"));
				RicettaDao ricettaDao = new RicettaDaoJDBC(dataSource);
				Ricetta ricetta = ricettaDao.findByPrimaryKey(result.getLong("ricetta_id"));
				voto.setRicetta(ricetta);
				UtenteDao utenteDao = new UtenteDaoJDBC(dataSource);
				Utente utente = utenteDao.findByPrimaryKey(result.getString("utente_username"));
				voto.setUtente(utente);
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
		return voto;
	}

	@Override
	public List<Voto> findAll() {
		Connection connection = this.dataSource.getConnection();
		List<Voto> voti = new LinkedList<Voto>();
		try {
			Voto voto = null;
			PreparedStatement statement;
			String query = "select * from voto";
			statement = connection.prepareStatement(query);
			ResultSet result = statement.executeQuery();
			while (result.next()) {
				voto = new Voto();
				voto = new Voto();
				voto.setId(result.getLong("id"));
				voto.setValore(result.getInt("valore"));
				RicettaDao ricettaDao = new RicettaDaoJDBC(dataSource);
				Ricetta ricetta = ricettaDao.findByPrimaryKey(result.getLong("ricetta_id"));
				voto.setRicetta(ricetta);
				UtenteDao utenteDao = new UtenteDaoJDBC(dataSource);
				Utente utente = utenteDao.findByPrimaryKey(result.getString("utente_username"));
				voto.setUtente(utente);
				voti.add(voto);
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
		return voti;
	}

	@Override
	public void update(Voto voto) {
		Connection connection = this.dataSource.getConnection();
		try {
			String update = "update voto set valore = ? where id = ?";
			PreparedStatement statement = connection.prepareStatement(update);
			statement.setInt(1, voto.getValore());
			statement.setLong(2, voto.getId());
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
	public void delete(Voto voto) {
		Connection connection = this.dataSource.getConnection();
		try {
			String delete = "delete from voto where id = ?";
			PreparedStatement statement = connection.prepareStatement(delete);
			statement.setLong(1, voto.getId());
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

