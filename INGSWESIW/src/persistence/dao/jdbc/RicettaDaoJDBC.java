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
import model.Utente;
import persistence.DataSource;
import persistence.IdBroker;
import persistence.PersistenceException;
import persistence.dao.RicettaDao;

public class RicettaDaoJDBC implements RicettaDao {
	
	private DataSource dataSource;
	
	public RicettaDaoJDBC(DataSource dataSource) {
		this.dataSource = dataSource;
	}
	
	//////////////////////////////////////////
	//////////////////////////////////////////
	//////////////////////////////////////////
	
	@Override
	public void saveAsBozza(Ricetta ricetta) {
		Connection connection = this.dataSource.getConnection();
		try {
			Long id = IdBroker.getId(connection, ricetta);
			ricetta.setId(id);
			String insert = "insert into ricetta (id, titolo, categoria, difficolta, tempoPreparazione, nameImmaginePrincipale, ingredienti, descrizione, preparazione, utente_username) values (?, ?, cast(? as categoria_type), cast(? as difficolta_type), ?, ?, ?, ?, ?, ?)";
			PreparedStatement statement = connection.prepareStatement(insert);
			statement.setLong(1, ricetta.getId());
			statement.setString(2, ricetta.getTitolo());
			statement.setString(3, ricetta.getCategoria().toString());
			statement.setString(4, ricetta.getDifficolta().toString());
			statement.setString(5, ricetta.getTempoPreparazione());
			statement.setString(6, ricetta.getNameImmaginePrincipale());
			statement.setString(7, ricetta.getIngredienti());
			statement.setString(8, ricetta.getDescrizione());
			statement.setString(9, ricetta.getPreparazione());
			statement.setString(10, ricetta.getUtente().getUsername());
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
	public void saveAsPubblicata(Ricetta ricetta) {
		Connection connection = this.dataSource.getConnection();
		try {
			Long id = IdBroker.getId(connection, ricetta);
			ricetta.setId(id);
			String insert = "insert into ricetta (id, dataPubblicazione, titolo, categoria, difficolta, tempoPreparazione, nameImmaginePrincipale, ingredienti, descrizione, preparazione, utente_username) values (?, ?, ?, cast(? as categoria_type), cast(? as difficolta_type), ?, ?, ?, ?, ?, ?)";
			PreparedStatement statement = connection.prepareStatement(insert);
			statement.setLong(1, ricetta.getId());
			statement.setTimestamp(2, new java.sql.Timestamp(System.currentTimeMillis())); /* assegnamento dataPubblicazione */
			statement.setString(3, ricetta.getTitolo());
			statement.setString(4, ricetta.getCategoria().toString());
			statement.setString(5, ricetta.getDifficolta().toString());
			statement.setString(6, ricetta.getTempoPreparazione());
			statement.setString(7, ricetta.getNameImmaginePrincipale());
			statement.setString(8, ricetta.getIngredienti());
			statement.setString(9, ricetta.getDescrizione());
			statement.setString(10, ricetta.getPreparazione());
			statement.setString(11, ricetta.getUtente().getUsername());
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
	
	//////////////////////////////////////////
	//////////////////////////////////////////
	//////////////////////////////////////////
	
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
				ricetta = new RicettaProxy(dataSource);
				ricetta.setId(result.getLong("id"));
				ricetta.setDataPubblicazione(result.getTimestamp("dataPubblicazione"));
				ricetta.setDataUltimaModifica(result.getTimestamp("dataUltimaModifica"));
				ricetta.setTitolo(result.getString("titolo"));
				ricetta.setCategoria(Categoria.valueOf(result.getString("categoria")));
				ricetta.setDifficolta(Difficolta.valueOf(result.getString("difficolta")));
				ricetta.setTempoPreparazione(result.getString("tempoPreparazione"));
				ricetta.setNameImmaginePrincipale(result.getString("nameImmaginePrincipale"));
				ricetta.setIngredienti(result.getString("ingredienti"));
				ricetta.setDescrizione((result.getString("descrizione")));
				ricetta.setPreparazione(result.getString("preparazione"));
				ricetta.setUtente(new UtenteDaoJDBC(dataSource).findByPrimaryKey(result.getString("utente_username")));				
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
	
	//////////////////////////////////////////
	//////////////////////////////////////////
	//////////////////////////////////////////
	
	@Override
	public List<Ricetta> findAllPubblicate() {
		Connection connection = this.dataSource.getConnection();
		List<Ricetta> ricette = new LinkedList<Ricetta>();
		try {
			Ricetta ricetta = null;
			PreparedStatement statement;
			String query = "select * from ricetta where dataPubblicazione is not null";
			statement = connection.prepareStatement(query);
			ResultSet result = statement.executeQuery();
			while (result.next()) {
				ricetta = new RicettaProxy(dataSource);
				ricetta.setId(result.getLong("id"));
				ricetta.setDataPubblicazione(result.getTimestamp("dataPubblicazione"));
				ricetta.setDataUltimaModifica(result.getTimestamp("dataUltimaModifica"));
				ricetta.setTitolo(result.getString("titolo"));
				ricetta.setCategoria(Categoria.valueOf(result.getString("categoria")));
				ricetta.setDifficolta(Difficolta.valueOf(result.getString("difficolta")));
				ricetta.setTempoPreparazione(result.getString("tempoPreparazione"));
				ricetta.setNameImmaginePrincipale(result.getString("nameImmaginePrincipale"));
				ricetta.setIngredienti(result.getString("ingredienti"));
				ricetta.setDescrizione((result.getString("descrizione")));
				ricetta.setPreparazione(result.getString("preparazione"));
				ricetta.setUtente(new UtenteDaoJDBC(dataSource).findByPrimaryKey(result.getString("utente_username")));	
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
	
	//////////////////////////////////////////////////////////
	//////////////////////////////////////////////////////////
	//////////////////////////////////////////////////////////
	
	@Override
	public List<Ricetta> findAllBozzeByUtente(Utente utente) {
		Connection connection = this.dataSource.getConnection();
		List<Ricetta> ricette = new LinkedList<Ricetta>();
		try {
			Ricetta ricetta = null;
			PreparedStatement statement;
			String query = "select * from ricetta where utente_username = ? and dataPubblicazione is null";
			statement = connection.prepareStatement(query);
			statement.setString(1, utente.getUsername());
			ResultSet result = statement.executeQuery();
			while (result.next()) {
				ricetta = new RicettaProxy(dataSource);
				ricetta.setId(result.getLong("id"));
				ricetta.setDataPubblicazione(result.getTimestamp("dataPubblicazione"));
				ricetta.setDataUltimaModifica(result.getTimestamp("dataUltimaModifica"));
				ricetta.setTitolo(result.getString("titolo"));
				ricetta.setCategoria(Categoria.valueOf(result.getString("categoria")));
				ricetta.setDifficolta(Difficolta.valueOf(result.getString("difficolta")));
				ricetta.setTempoPreparazione(result.getString("tempoPreparazione"));
				ricetta.setNameImmaginePrincipale(result.getString("nameImmaginePrincipale"));
				ricetta.setIngredienti(result.getString("ingredienti"));
				ricetta.setDescrizione((result.getString("descrizione")));
				ricetta.setPreparazione(result.getString("preparazione"));
				ricetta.setUtente(new UtenteDaoJDBC(dataSource).findByPrimaryKey(result.getString("utente_username")));	
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
	public List<Ricetta> findAllPubblicateByUtente(Utente utente) {
		Connection connection = this.dataSource.getConnection();
		List<Ricetta> ricette = new LinkedList<Ricetta>();
		try {
			Ricetta ricetta = null;
			PreparedStatement statement;
			String query = "select * from ricetta where utente_username = ? and dataPubblicazione is not null";
			statement = connection.prepareStatement(query);
			statement.setString(1, utente.getUsername());
			ResultSet result = statement.executeQuery();
			while (result.next()) {
				ricetta = new RicettaProxy(dataSource);
				ricetta.setId(result.getLong("id"));
				ricetta.setDataPubblicazione(result.getTimestamp("dataPubblicazione"));
				ricetta.setDataUltimaModifica(result.getTimestamp("dataUltimaModifica"));
				ricetta.setTitolo(result.getString("titolo"));
				ricetta.setCategoria(Categoria.valueOf(result.getString("categoria")));
				ricetta.setDifficolta(Difficolta.valueOf(result.getString("difficolta")));
				ricetta.setTempoPreparazione(result.getString("tempoPreparazione"));
				ricetta.setNameImmaginePrincipale(result.getString("nameImmaginePrincipale"));
				ricetta.setIngredienti(result.getString("ingredienti"));
				ricetta.setDescrizione((result.getString("descrizione")));
				ricetta.setPreparazione(result.getString("preparazione"));
				ricetta.setUtente(new UtenteDaoJDBC(dataSource).findByPrimaryKey(result.getString("utente_username")));	
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
	
	////////////////////////////////////////////////////////////////////////
	////////////////////////////////////////////////////////////////////////
	////////////////////////////////////////////////////////////////////////
	
	@Override
	public List<Ricetta> findAllPubblicateByCategoria(Categoria categoria) {
		Connection connection = this.dataSource.getConnection();
		List<Ricetta> ricette = new LinkedList<Ricetta>();
		try {
			Ricetta ricetta = null;
			PreparedStatement statement;
			String query = "select * from ricetta where categoria = cast(? as categoria_type) and dataPubblicazione is not null;";
			statement = connection.prepareStatement(query);
			statement.setString(1, categoria.toString());
			ResultSet result = statement.executeQuery();
			while (result.next()) {
				ricetta = new RicettaProxy(dataSource);
				ricetta.setId(result.getLong("id"));
				ricetta.setDataPubblicazione(result.getTimestamp("dataPubblicazione"));
				ricetta.setDataUltimaModifica(result.getTimestamp("dataUltimaModifica"));
				ricetta.setTitolo(result.getString("titolo"));
				ricetta.setCategoria(Categoria.valueOf(result.getString("categoria")));
				ricetta.setDifficolta(Difficolta.valueOf(result.getString("difficolta")));
				ricetta.setTempoPreparazione(result.getString("tempoPreparazione"));
				ricetta.setNameImmaginePrincipale(result.getString("nameImmaginePrincipale"));
				ricetta.setIngredienti(result.getString("ingredienti"));
				ricetta.setDescrizione((result.getString("descrizione")));
				ricetta.setPreparazione(result.getString("preparazione"));
				ricetta.setUtente(new UtenteDaoJDBC(dataSource).findByPrimaryKey(result.getString("utente_username")));	
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
	
	///////////////////////////////////////////////////////////////
	///////////////////////////////////////////////////////////////
	///////////////////////////////////////////////////////////////
	
	@Override
	public List<Ricetta> findAllPubblicateByTitolo(String titolo) {
		Connection connection = this.dataSource.getConnection();
		List<Ricetta> ricette = new LinkedList<Ricetta>();
		try {
			Ricetta ricetta = null;
			PreparedStatement statement;
			String query = "select * from ricetta where titolo ~* ?";
			statement = connection.prepareStatement(query);
			statement.setString(1, titolo);
			ResultSet result = statement.executeQuery();
			while (result.next()) {
				ricetta = new RicettaProxy(dataSource);
				ricetta.setId(result.getLong("id"));
				ricetta.setDataPubblicazione(result.getTimestamp("dataPubblicazione"));
				ricetta.setDataUltimaModifica(result.getTimestamp("dataUltimaModifica"));
				ricetta.setTitolo(result.getString("titolo"));
				ricetta.setCategoria(Categoria.valueOf(result.getString("categoria")));
				ricetta.setDifficolta(Difficolta.valueOf(result.getString("difficolta")));
				ricetta.setTempoPreparazione(result.getString("tempoPreparazione"));
				ricetta.setNameImmaginePrincipale(result.getString("nameImmaginePrincipale"));
				ricetta.setIngredienti(result.getString("ingredienti"));
				ricetta.setDescrizione((result.getString("descrizione")));
				ricetta.setPreparazione(result.getString("preparazione"));
				ricetta.setUtente(new UtenteDaoJDBC(dataSource).findByPrimaryKey(result.getString("utente_username")));	
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
	
	////////////////////////////////////////////
	////////////////////////////////////////////
	////////////////////////////////////////////
	
	@Override
	public void updateAsBozza(Ricetta ricetta) {
		Connection connection = this.dataSource.getConnection();
		try {
			String update = "update ricetta set titolo = ?, categoria = cast(? as categoria_type), difficolta = cast(? as difficolta_type), tempoPreparazione = ?, nameImmaginePrincipale = ?, ingredienti = ?, descrizione = ?, preparazione = ? where id = ?";
			PreparedStatement statement = connection.prepareStatement(update);
			statement.setString(1, ricetta.getTitolo());
			statement.setString(2, ricetta.getCategoria().toString());
			statement.setString(3, ricetta.getDifficolta().toString());
			statement.setString(4, ricetta.getTempoPreparazione());
			statement.setString(5, ricetta.getNameImmaginePrincipale());
			statement.setString(6, ricetta.getIngredienti());
			statement.setString(7, ricetta.getDescrizione());
			statement.setString(8, ricetta.getPreparazione());
			statement.setLong(9, ricetta.getId());
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
	public void updateAsPubblicata(Ricetta ricetta) {
		Connection connection = this.dataSource.getConnection();
		try {
			String update = "update ricetta set dataUltimaModifica = ?, titolo = ?, categoria = cast(? as categoria_type), difficolta = cast(? as difficolta_type), tempoPreparazione = ?, nameImmaginePrincipale = ?, ingredienti = ?, descrizione = ?, preparazione = ? where id = ?";
			PreparedStatement statement = connection.prepareStatement(update);
			statement.setTimestamp(1, new java.sql.Timestamp(System.currentTimeMillis()));
			statement.setString(2, ricetta.getTitolo());
			statement.setString(3, ricetta.getCategoria().toString());
			statement.setString(4, ricetta.getDifficolta().toString());
			statement.setString(5, ricetta.getTempoPreparazione());
			statement.setString(6, ricetta.getNameImmaginePrincipale());
			statement.setString(7, ricetta.getIngredienti());
			statement.setString(8, ricetta.getDescrizione());
			statement.setString(9, ricetta.getPreparazione());
			statement.setLong(10, ricetta.getId());
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
	
	/////////////////////////////////////
	/////////////////////////////////////
	/////////////////////////////////////
	
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
	
	//////////////////////////////////////////////////////////////////////////////////////
	//////////////////////////////////////////////////////////////////////////////////////
	//////////////////////////////////////////////////////////////////////////////////////
	


}
