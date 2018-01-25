package persistence.dao.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import model.Utente;
import model.Voto;
import persistence.DataSource;
import persistence.IdBroker;
import persistence.PersistenceException;
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
			String insert = "insert into voto (id, valore, ricetta_id, utente_id) values (?, ?, ?, ?)";
			PreparedStatement statement = connection.prepareStatement(insert);
			statement.setLong(1, voto.getId());
			statement.setLong(2, voto.getValore());
			statement.setLong(4,voto.getRicetta().getId());
			statement.setLong(3,voto.getUtente().getId());
			statement.executeUpdate();
		}catch (SQLException  e) {
			if (connection != null) {
				try {
					connection.rollback();
				} catch(SQLException excep) {
					throw new PersistenceException(e.getMessage());
				}
			} 
		}finally {
			try {
				connection.close();
			} catch (SQLException e) {
				throw new PersistenceException(e.getMessage());
			}
		}

	}

	@Override
	public Voto findByPrimaryKey(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Voto> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void update(Voto voto) {
		// TODO Auto-generated method stub

	}

	@Override
	public void delete(Voto voto) {
		// TODO Auto-generated method stub

	}

}

