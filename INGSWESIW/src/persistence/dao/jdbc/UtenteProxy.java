package persistence.dao.jdbc;

import java.util.List;

import model.Commento;
import model.Utente;
import model.Voto;
import persistence.DataSource;

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
	
//	@Override
//	public List<Commento> getCommentiPubblicati() { 
//		Connection connection = this.dataSource.getConnection();
//		List<Commento> commenti = new LinkedList<Commento>();
//		try {
//			Commento commento = null;
//			PreparedStatement statement;
//			String query = "select * from commento where utente_username = ?";
//			statement = connection.prepareStatement(query);
//			statement.setString(1, this.getUsername());
//			ResultSet result = statement.executeQuery();
//			while (result.next()) {
//				commento = new Commento();
//				commento.setId(result.getLong("id"));
//				commento.setDataPubblicazione(result.getTimestamp("dataPubblicazione"));
//				commento.setDataUltimaModifica(result.getTimestamp("dataUltimaModifica"));
//				commento.setContenuto(result.getString("contenuto"));
//				commento.setRicetta(new RicettaDaoJDBC(dataSource).findByPrimaryKey(result.getLong("ricetta_id")));
//				commento.setUtente(new UtenteDaoJDBC(dataSource).findByPrimaryKey(result.getString("utente_username")));
//				commenti.add(commento);
//			}
//		} catch (SQLException e) {
//			throw new PersistenceException(e.getMessage());
//		} finally {
//			try {
//				connection.close();
//			} catch (SQLException e) {
//				throw new PersistenceException(e.getMessage());
//			}
//		}
//		this.setCommentiPubblicati(commenti);
//		return super.getCommentiPubblicati(); 
//	}
	
//	@Override
//	public List<Voto> getVotiEspressi() { 
//		Connection connection = this.dataSource.getConnection();
//		List<Voto> voti = new LinkedList<Voto>();
//		try {
//			Voto voto = null;
//			PreparedStatement statement;
//			String query = "select * from voto where utente_username = ?";
//			statement = connection.prepareStatement(query);
//			statement.setString(1, this.getUsername());
//			ResultSet result = statement.executeQuery();
//			while (result.next()) {
//				voto = new Voto();
//				voto.setId(result.getLong("id"));
//				voto.setValore(result.getInt("valore"));
//				voto.setRicetta(new RicettaDaoJDBC(dataSource).findByPrimaryKey(result.getLong("ricetta_id")));
//				voto.setUtente( new UtenteDaoJDBC(dataSource).findByPrimaryKey(result.getString("utente_username")));	
//				voti.add(voto);
//			}
//		} catch (SQLException e) {
//			throw new PersistenceException(e.getMessage());
//		} finally {
//			try {
//				connection.close();
//			} catch (SQLException e) {
//				throw new PersistenceException(e.getMessage());
//			}
//		}
//		this.setVotiEspressi(voti);
//		return super.getVotiEspressi(); 
//	}

}
