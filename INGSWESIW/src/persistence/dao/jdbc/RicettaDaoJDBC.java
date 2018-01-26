package persistence.dao.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

import model.Categoria;
import model.Difficolta;
import model.Ricetta;
import persistence.DataSource;
import persistence.IdBroker;
import persistence.PersistenceException;
import persistence.dao.RicettaDao;

public class RicettaDaoJDBC implements RicettaDao {
	
	private DataSource dataSource;
	
	public RicettaDaoJDBC(DataSource dataSource) {
		this.dataSource = dataSource;
	}
	
	@Override
	public void save(Ricetta ricetta) {
		Connection connection = this.dataSource.getConnection();
		try {
			Long id = IdBroker.getId(connection);
			ricetta.setId(id);
			String insert = "insert into ricetta (id, titolo, categoria, difficolta) values (?, ?, cast(? as categoria_type), cast(? as difficolta_type))";
			PreparedStatement statement = connection.prepareStatement(insert);
			statement.setLong(1, ricetta.getId());
			statement.setString(2, ricetta.getTitolo());
			statement.setString(3, ricetta.getCategoria().toString());
			statement.setString(4, ricetta.getDifficolta().toString());
			statement.executeUpdate();
		} catch (SQLException e1) {
			if (connection != null) {
				try {
					connection.rollback();
				} catch(SQLException e2) {
					throw new PersistenceException(e1.getMessage());
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
	public Ricetta findByPrimaryKey(Long id) {
		Connection connection = this.dataSource.getConnection();
		Ricetta ricetta = null;
		try {
			PreparedStatement statement;
			String query = "select * from ricetta where id = ?";
			statement = connection.prepareStatement(query);
			statement.setLong(1, id);
			ResultSet result = statement.executeQuery();
			while (result.next()) {
				ricetta = new Ricetta();
				ricetta.setId(result.getLong("id"));
				ricetta.setTitolo(result.getString("titolo"));
				ricetta.setCategoria(Categoria.valueOf(result.getString("categoria")));
				ricetta.setDifficolta(Difficolta.valueOf(result.getString("difficolta")));
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
		return ricetta;
	}

	@Override
	public List<Ricetta> findAll() {
		Connection connection = this.dataSource.getConnection();
		List<Ricetta> ricette=new LinkedList<Ricetta>();
		try {
			Ricetta ricetta = null;
			PreparedStatement statement;
			String query = "select * from ricetta";
			statement = connection.prepareStatement(query);
			ResultSet result = statement.executeQuery();
			while (result.next()) {
				ricetta = new Ricetta();
				ricetta.setId(result.getLong("id"));
				ricetta.setTitolo(result.getString("titolo"));
				ricetta.setCategoria(Categoria.valueOf(result.getString("categoria")));
				ricetta.setDifficolta(Difficolta.valueOf(result.getString("difficolta")));
				ricette.add(ricetta);
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
		return ricette;
	}

	@Override
	public void update(Ricetta ricetta) {
		Connection connection = this.dataSource.getConnection();
		try {
			String update = "update ricetta set titolo = ?, categoria = cast(? as categoria_type), difficolta = cast(? as difficolta_type) where id = ?";
			PreparedStatement statement = connection.prepareStatement(update);
			statement.setString(1, ricetta.getTitolo());
			statement.setString(2, ricetta.getCategoria().toString());
			statement.setString(3, ricetta.getDifficolta().toString());
			statement.setLong(4, ricetta.getId());
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
	public void delete(Ricetta ricetta) {
		Connection connection = this.dataSource.getConnection();
		try {
			String delete = "delete from ricetta where id = ?";
			PreparedStatement statement = connection.prepareStatement(delete);
			statement.setLong(1, ricetta.getId());
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
	public List<Ricetta> findByTitolo(String titolo) {
		// TODO Auto-generated method stub
		return null;
	}

}
