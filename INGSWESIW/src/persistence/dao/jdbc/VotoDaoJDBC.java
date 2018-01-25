package persistence.dao.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import model.Utente;
import model.Voto;
import persistence.DataSource;
import persistence.DipartimentoDaoJDBC;
import persistence.IdBroker;
import persistence.PersistenceException;
import persistence.dao.RicettaDao;
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
				Ricetta ricetta = 
				voto.setPassword(result.getString("password"));	
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
	public List<Voto> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void update(Voto voto) {
		Connection connection = this.dataSource.getConnection();
		try {
			String update = "update voto set valore = ?, ricetta_id = ?, utente_username = ? where id = ?";
			PreparedStatement statement = connection.prepareStatement(update);
			statement.setInt(1, voto.getValore());
			statement.setLong(2, voto.getRicetta().getId());
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

