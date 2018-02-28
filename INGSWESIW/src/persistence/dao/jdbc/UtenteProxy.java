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
import model.Voto;
import persistence.DataSource;
import persistence.PersistenceException;

public class UtenteProxy extends Utente {
	
	private DataSource dataSource;

	public UtenteProxy(DataSource dataSource) {
		this.dataSource = dataSource;
	}
	
	@Override
	public List<Commento> getCommentiPubblicati() { 
		List<Commento> commenti = new CommentoDaoJDBC(dataSource).findByUtente(this);
		this.setCommentiPubblicati(commenti);
		return super.getCommentiPubblicati(); 
	}
	
	@Override
	public List<Voto> getVotiEspressi() {
		List<Voto> voti = new VotoDaoJDBC(dataSource).findByUtente(this);
		this.setVotiEspressi(voti);
		return super.getVotiEspressi(); 
	}
		
	@Override
	public List<Ricetta> getRicetteInBozza() {
		List<Ricetta> ricette = new RicettaDaoJDBC(dataSource).findAllBozzeByUtente(this);
		this.setRicetteInBozza(ricette);
		return super.getRicetteInBozza(); 
	}
	
	@Override
	public List<Ricetta> getRicettePubblicate() {
		List<Ricetta> ricette = new RicettaDaoJDBC(dataSource).findAllPubblicateByUtente(this);
		this.setRicetteInBozza(ricette);
		return super.getRicettePubblicate(); 
	}
		
	@Override
	public List<Ricetta> getRicettePreferite() {
		Connection connection = this.dataSource.getConnection();
		List<Ricetta> ricette = new LinkedList<Ricetta>();
		try {
			Ricetta ricetta = null;
			PreparedStatement statement;
			String query = "select * from ricetta_preferita where utente_username = ?;";
			statement = connection.prepareStatement(query);
			statement.setString(1, this.getUsername());
			ResultSet result = statement.executeQuery();
			while (result.next()) {
				ricetta = new RicettaDaoJDBC(dataSource).findByPrimaryKey(result.getLong("ricetta_id"));
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
		this.setRicettePreferite(ricette);
		return super.getRicettePreferite();
	}
	
	@Override
	public List<Utente> getFollowings() {
		Connection connection = this.dataSource.getConnection();
		List<Utente> utenti = new LinkedList<Utente>();
		try {
			Utente utente = null;
			PreparedStatement statement;
			String query = "select * from following where utente_username = ?;";
			statement = connection.prepareStatement(query);
			statement.setString(1, this.getUsername());
			ResultSet result = statement.executeQuery();
			while (result.next()) {
				utente = new UtenteDaoJDBC(dataSource).findByPrimaryKey(result.getString("following_username"));
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
		this.setFollowings(utenti);
		return super.getFollowings();
	}
	
	@Override
	public List<Utente> getFollowers() {
		Connection connection = this.dataSource.getConnection();
		List<Utente> utenti = new LinkedList<Utente>();
		try {
			Utente utente = null;
			PreparedStatement statement;
			String query = "select * from follower where utente_username = ?;";
			statement = connection.prepareStatement(query);
			statement.setString(1, this.getUsername());
			ResultSet result = statement.executeQuery();
			while (result.next()) {
				utente = new UtenteDaoJDBC(dataSource).findByPrimaryKey(result.getString("follower_username"));
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
		this.setFollowers(utenti);
		return super.getFollowers();
	}
	
}
