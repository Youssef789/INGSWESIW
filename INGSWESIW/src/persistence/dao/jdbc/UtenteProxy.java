package persistence.dao.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

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
	public List<Commento> getCommentiPubblicati() { 
		List<Commento> commenti = new CommentoDaoJDBC(dataSource).findByUser(this);
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
				ricetta.setTempoPreparazione(result.getString("tempoPreparazione"));
				ricetta.setPathImmaginePrincipale(result.getString("pathImmaginePrincipale"));
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
		this.setRicettePreferite(ricette);
		return super.getRicettePreferite();
	}
	
}
