package persistence.dao.jdbc;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
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
	public File getImmagineProfilo() {
		Connection connection = this.dataSource.getConnection();
		File immagineProfilo = null;
		try {
			PreparedStatement statement;
			String query = "select * from immagine_profilo where utente_username = ?";
			statement = connection.prepareStatement(query);
			statement.setString(1, this.getUsername());
			ResultSet result = statement.executeQuery();
			if (result.next()) {
				immagineProfilo = new File(result.getString("immagine_nome"));
				byte[] immagine = result.getBytes("immagine");
			    FileOutputStream fos = new FileOutputStream(immagineProfilo);
			    fos.write(immagine);
			    fos.close();
			}
		} catch (SQLException e) {
			throw new PersistenceException(e.getMessage());
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				connection.close();
			} catch (SQLException e) {
				throw new PersistenceException(e.getMessage());
			}
		}
		this.setImmagineProfilo(immagineProfilo);
		return super.getImmagineProfilo();
	}
	
	@Override
	public Set<Commento> getCommentiPubblicati() { 
		Set<Commento> commenti = new LinkedHashSet<Commento>(new CommentoDaoJDBC(dataSource).findByUtente(this));
		this.setCommentiPubblicati(commenti);
		return super.getCommentiPubblicati(); 
	}
	
	@Override
	public Set<Voto> getVotiEspressi() {
		Set<Voto> voti = new LinkedHashSet<Voto>(new VotoDaoJDBC(dataSource).findByUtente(this));
		this.setVotiEspressi(voti);
		return super.getVotiEspressi(); 
	}
	
	@Override
	public Set<Ricetta> getRicetteInBozza() {
		Set<Ricetta> ricette = new LinkedHashSet<Ricetta>(new RicettaDaoJDBC(dataSource).findAllBozzeByUtente(this));
		this.setRicetteInBozza(ricette);
		return super.getRicetteInBozza(); 
	}
	
	@Override
	public Set<Ricetta> getRicettePubblicate() {
		Set<Ricetta> ricette = new LinkedHashSet<Ricetta>(new RicettaDaoJDBC(dataSource).findAllPubblicateByUtente(this));
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
				ricetta.setTempoPreparazione(result.getString("tempoPreparazione"));
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
