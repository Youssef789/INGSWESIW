package persistence.dao.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

import model.Commento;
import model.Ricetta;
import model.Utente;
import persistence.DataSource;
import persistence.IdBroker;
import persistence.PersistenceException;
import persistence.dao.CommentoDao;

public class CommentoDaoJDBC implements CommentoDao {

	private DataSource dataSource;
	
	public CommentoDaoJDBC(DataSource dataSource) {
		this.dataSource = dataSource;
	}
	
	@Override
	public void save(Commento commento) {
		Connection connection = this.dataSource.getConnection();
		try {
			Long id = IdBroker.getId(connection, commento); /* assegnamento tramite idbroker per commento */
			commento.setId(id);
			String insert = "insert into commento (id, dataPubblicazione, contenuto, ricetta_id, utente_username) values (?, ?, ?, ?, ?)";
			PreparedStatement statement = connection.prepareStatement(insert);
			statement.setLong(1, commento.getId());
			statement.setTimestamp(2, new java.sql.Timestamp(System.currentTimeMillis())); /* assegnamento dataPubblicazione */
			statement.setString(3, commento.getContenuto());
			statement.setLong(4,commento.getRicetta().getId());
			statement.setString(5,commento.getUtente().getUsername());
			statement.executeUpdate();
		} catch (SQLException e1) {
			if (connection != null) {
				try {
					connection.rollback();
				} catch (SQLException e2) {
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
	public Commento findByPrimaryKey(Long id) {
		Connection connection = this.dataSource.getConnection();
		Commento commento = null;
		try {
			PreparedStatement statement;
			String query = "select * from commento where id = ?";
			statement = connection.prepareStatement(query);
			statement.setLong(1, id);
			ResultSet result = statement.executeQuery();
			while (result.next()) {
				commento = new Commento();
				commento.setId(result.getLong("id"));
				commento.setDataPubblicazione(result.getTimestamp("dataPubblicazione"));
				commento.setDataUltimaModifica(result.getTimestamp("dataUltimaModifica"));
				commento.setContenuto(result.getString("contenuto"));
				commento.setRicetta(new RicettaDaoJDBC(dataSource).findByPrimaryKey(result.getLong("ricetta_id")));
				commento.setUtente(new UtenteDaoJDBC(dataSource).findByPrimaryKey(result.getString("utente_username")));
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
		return commento;
	}

	@Override
	public List<Commento> findAll() {
		Connection connection = this.dataSource.getConnection();
		List<Commento> commenti = new LinkedList<Commento>();
		try {
			Commento commento = null;
			PreparedStatement statement;
			String query = "select * from commento";
			statement = connection.prepareStatement(query);
			ResultSet result = statement.executeQuery();
			while (result.next()) {
				commento = new Commento();
				commento.setId(result.getLong("id"));
				commento.setDataPubblicazione(result.getTimestamp("dataPubblicazione"));
				commento.setDataUltimaModifica(result.getTimestamp("dataUltimaModifica"));
				commento.setContenuto(result.getString("contenuto"));
				commento.setRicetta(new RicettaDaoJDBC(dataSource).findByPrimaryKey(result.getLong("ricetta_id")));
				commento.setUtente(new UtenteDaoJDBC(dataSource).findByPrimaryKey(result.getString("utente_username")));
				commenti.add(commento);
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
		return commenti;
	}

	@Override
	public void update(Commento commento) {
		Connection connection = this.dataSource.getConnection();
		try {
			String update = "update commento set dataUltimaModifica = ?, testo = ? where id = ?";
			PreparedStatement statement = connection.prepareStatement(update);
			statement.setTimestamp(1, new java.sql.Timestamp(System.currentTimeMillis())); /* assegnamento dataUltimaModifica */
			statement.setString(2, commento.getContenuto());
			statement.setLong(3, commento.getId());
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
	public void delete(Commento commento) {
		Connection connection = this.dataSource.getConnection();
		try {
			String delete = "delete from commento where id = ?";
			PreparedStatement statement = connection.prepareStatement(delete);
			statement.setLong(1, commento.getId());
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
	
	//////////////////////////////////////////////////////
	//////////////////////////////////////////////////////
	//////////////////////////////////////////////////////
	
	@Override
	public List<Commento> findByRicetta(Ricetta ricetta) {
		Connection connection = this.dataSource.getConnection();
		List<Commento> commenti = new LinkedList<Commento>();
		try {
			Commento commento = null;
			PreparedStatement statement;
			String query = "select * from commento where ricetta_id = ?";
			statement = connection.prepareStatement(query);
			statement.setLong(1, ricetta.getId());
			ResultSet result = statement.executeQuery();
			while (result.next()) {
				commento = new Commento();
				commento.setId(result.getLong("id"));
				commento.setDataPubblicazione(result.getTimestamp("dataPubblicazione"));
				commento.setDataUltimaModifica(result.getTimestamp("dataUltimaModifica"));
				commento.setContenuto(result.getString("contenuto"));
				commento.setRicetta(new RicettaDaoJDBC(dataSource).findByPrimaryKey(result.getLong("ricetta_id")));
				commento.setUtente(new UtenteDaoJDBC(dataSource).findByPrimaryKey(result.getString("utente_username")));
				commenti.add(commento);
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
		return commenti;
	}

	@Override
	public List<Commento> findByUtente(Utente utente) {
		Connection connection = this.dataSource.getConnection();
		List<Commento> commenti = new LinkedList<Commento>();
		try {
			Commento commento = null;
			PreparedStatement statement;
			String query = "select * from commento where utente_username = ?";
			statement = connection.prepareStatement(query);
			statement.setString(1, utente.getUsername());
			ResultSet result = statement.executeQuery();
			while (result.next()) {
				commento = new Commento();
				commento.setId(result.getLong("id"));
				commento.setDataPubblicazione(result.getTimestamp("dataPubblicazione"));
				commento.setDataUltimaModifica(result.getTimestamp("dataUltimaModifica"));
				commento.setContenuto(result.getString("contenuto"));
				commento.setRicetta(new RicettaDaoJDBC(dataSource).findByPrimaryKey(result.getLong("ricetta_id")));
				commento.setUtente(new UtenteDaoJDBC(dataSource).findByPrimaryKey(result.getString("utente_username")));
				commenti.add(commento);
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
		return commenti;
	}

}