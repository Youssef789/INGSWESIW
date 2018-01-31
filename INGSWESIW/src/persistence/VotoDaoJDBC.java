package persistence;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

import model.Ricetta;
import model.Utente;
import model.Voto;
import persistence.dao.VotoDao;

public class VotoDaoJDBC implements VotoDao{
	
	private DataSource dataSource;

	public VotoDaoJDBC(DataSource dataSource) {
		this.dataSource = dataSource;
	}

	@Override
	public void save(Voto voto) {
		Connection connection = this.dataSource.getConnection();
		try {
			Long id = IdBroker.getId(connection, voto); /* assegnamento tramite idbroker per voto */
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
				voto.setRicetta(new RicettaDaoJDBC(dataSource).findByPrimaryKey(result.getLong("ricetta_id")));
				voto.setUtente( new UtenteDaoJDBC(dataSource).findByPrimaryKey(result.getString("utente_username")));				
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
				voto.setId(result.getLong("id"));
				voto.setValore(result.getInt("valore"));
				voto.setRicetta(new RicettaDaoJDBC(dataSource).findByPrimaryKey(result.getLong("ricetta_id")));
				voto.setUtente( new UtenteDaoJDBC(dataSource).findByPrimaryKey(result.getString("utente_username")));	
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
	
	//////////////////////////////////////////////////
	//////////////////////////////////////////////////
	//////////////////////////////////////////////////

	@Override
	public List<Voto> findByRicetta(Ricetta ricetta) {
		Connection connection = this.dataSource.getConnection();
		List<Voto> voti = new LinkedList<Voto>();
		try {
			Voto voto = null;
			PreparedStatement statement;
			String query = "select * from voto where ricetta_id = ?";
			statement = connection.prepareStatement(query);
			statement.setLong(1, ricetta.getId());
			ResultSet result = statement.executeQuery();
			while (result.next()) {
				voto = new Voto();
				voto.setId(result.getLong("id"));
				voto.setValore(result.getInt("valore"));
				voto.setRicetta(new RicettaDaoJDBC(dataSource).findByPrimaryKey(result.getLong("ricetta_id")));
				voto.setUtente( new UtenteDaoJDBC(dataSource).findByPrimaryKey(result.getString("utente_username")));	
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
	public List<Voto> findByUtente(Utente utente) {
		Connection connection = this.dataSource.getConnection();
		List<Voto> voti = new LinkedList<Voto>();
		try {
			Voto voto = null;
			PreparedStatement statement;
			String query = "select * from voto where utente_username = ?";
			statement = connection.prepareStatement(query);
			statement.setString(1, utente.getUsername());
			ResultSet result = statement.executeQuery();
			while (result.next()) {
				voto = new Voto();
				voto.setId(result.getLong("id"));
				voto.setValore(result.getInt("valore"));
				voto.setRicetta(new RicettaDaoJDBC(dataSource).findByPrimaryKey(result.getLong("ricetta_id")));
				voto.setUtente( new UtenteDaoJDBC(dataSource).findByPrimaryKey(result.getString("utente_username")));	
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
}
