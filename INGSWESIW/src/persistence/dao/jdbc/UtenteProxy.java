package persistence.dao.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedHashSet;
import java.util.Set;

import model.Categoria;
import model.Commento;
import model.Difficolta;
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
	public Set<Commento> getCommentiPubblicati() { 
		Set<Commento> commenti = new CommentoDaoJDBC(dataSource).findByUtente(this);
		this.setCommentiPubblicati(commenti);
		return super.getCommentiPubblicati(); 
	}
	
	@Override
	public Set<Voto> getVotiEspressi() {
		Set<Voto> voti = new VotoDaoJDBC(dataSource).findByUtente(this);
		this.setVotiEspressi(voti);
		return super.getVotiEspressi(); 
	}
		
	@Override
	public Set<Ricetta> getRicetteInBozza() {
		Set<Ricetta> ricette = new RicettaDaoJDBC(dataSource).findAllBozzeByUtente(this);
		this.setRicetteInBozza(ricette);
		return super.getRicetteInBozza(); 
	}
	
	@Override
	public Set<Ricetta> getRicettePubblicate() {
		Set<Ricetta> ricette = new RicettaDaoJDBC(dataSource).findAllPubblicateByUtente(this);
		this.setRicetteInBozza(ricette);
		return super.getRicettePubblicate(); 
	}
		

	@Override
	public Set<Ricetta> getRicettePreferite() {
		Connection connection = this.dataSource.getConnection();
		Set<Ricetta> ricette = new LinkedHashSet<Ricetta>();
		try {
			Ricetta ricetta = null;
			PreparedStatement statement;
			String query = "select * from ricetta_preferita where utente_id = ?;";
			statement = connection.prepareStatement(query);
			statement.setString(1, this.getUsername());
			ResultSet result = statement.executeQuery();
			while (result.next()) {
				ricetta = new RicettaProxy(dataSource);
				ricetta.setId(result.getLong("id"));
				ricetta.setDataPubblicazione(result.getTimestamp("dataPubblicazione"));
				ricetta.setDataUltimaModifica(result.getTimestamp("dataUltimaModifica"));
				ricetta.setTitolo(result.getString("titolo"));
				ricetta.setCategoria(Categoria.valueOf(result.getString("categoria")));
				ricetta.setDifficolta(Difficolta.valueOf(result.getString("difficolta")));
				ricetta.setTempo(result.getString("tempo"));
				ricetta.setDosi(result.getString("dosi"));
				ricetta.setImmaginePrincipale(result.getString("immaginePrincipale"));
				ricetta.setIngredienti(result.getString("ingredienti"));
				ricetta.setDescrizione((result.getString("descrizione")));
				ricetta.setPreparazione(result.getString("preparazione"));
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
	public Set<Utente> getFollowings() {
		Connection connection = this.dataSource.getConnection();
		Set<Utente> utenti = new LinkedHashSet<Utente>();
		try {
			Utente utente = null;
			PreparedStatement statement;
			String query = "select * from following where utente_id = ?;";
			statement = connection.prepareStatement(query);
			statement.setString(1, this.getUsername());
			ResultSet result = statement.executeQuery();
			while (result.next()) {
				utente = new UtenteProxy(dataSource);
				utente.setUsername(result.getString("username"));
				utente.setEmail(result.getString("email"));
				utente.setImmagineProfilo(result.getString("immagineProfilo"));
				utente.setAdmin(result.getBoolean("admin"));
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
	public Set<Utente> getFollowers() {
		Connection connection = this.dataSource.getConnection();
		Set<Utente> utenti = new LinkedHashSet<Utente>();
		try {
			Utente utente = null;
			PreparedStatement statement;
			String query = "select * from followers where utente_id = ?;";
			statement = connection.prepareStatement(query);
			statement.setString(1, this.getUsername());
			ResultSet result = statement.executeQuery();
			while (result.next()) {
				utente = new UtenteProxy(dataSource);
				utente.setUsername(result.getString("username"));
				utente.setEmail(result.getString("email"));
				utente.setImmagineProfilo(result.getString("immagineProfilo"));
				utente.setAdmin(result.getBoolean("admin"));
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
