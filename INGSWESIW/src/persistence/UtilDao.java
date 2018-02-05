package persistence;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class UtilDao {
	
	private DataSource dataSource;

	public UtilDao(DataSource dataSource) {
		this.dataSource = dataSource;
	}

	public void createDatabase() {
		Connection connection = dataSource.getConnection();
		try {
			String create = /* sequences */
					        "create SEQUENCE sequenza_id_ricetta;" +
		                    "create SEQUENCE sequenza_id_commento;" +
					        "create SEQUENCE sequenza_id_voto;" +
		                    /* enums */
		                    "create TYPE categoria_type as enum ('ANTIPASTI', 'PRIMI_PIATTI', 'SECONDI_PIATTI', 'PIATTI_UNICI', 'CONTORNI', 'DOLCI', 'LIEVITATI', 'SALSE_E_SUGHI', 'MARMELLATE_E_CONSERVE', 'BEVANDE', 'ALTRO');" +
					        "create TYPE difficolta_type as enum ('FACILE', 'MEDIA', 'DIFFICILE');" +
		                    /* tables (enties) */
					        "create TABLE utente (username VARCHAR(255) primary key not null, email VARCHAR(255) not null unique, password VARCHAR(255) not null);" +
			                "create TABLE ricetta (id BIGSERIAL primary key not null, dataPubblicazione TIMESTAMP, dataUltimaModifica TIMESTAMP, titolo VARCHAR(255), categoria categoria_type, difficolta difficolta_type, tempoPreparazione VARCHAR(255), ingredienti TEXT, descrizione TEXT, preparazione TEXT, votoComplessivo REAL, utente_username VARCHAR(255) references utente (username) on delete cascade not null);" +  
					        "create TABLE ricetta_preferita (ricetta_id BIGINT references ricetta (id) on delete restrict not null, utente_username VARCHAR(255) references utente (username) on delete restrict not null, primary key (ricetta_id, utente_username));" +
			                "create TABLE commento (id BIGINT primary key not null, dataPubblicazione TIMESTAMP not null, dataUltimaModifica TIMESTAMP, contenuto VARCHAR(255) not null, ricetta_id BIGINT references ricetta (id) on delete cascade not null, utente_username VARCHAR(255) references utente (username) on delete cascade not null);" + 
			                "create TABLE voto (id BIGINT primary key not null, valore SMALLINT not null, ricetta_id BIGINT references ricetta (id) on delete restrict not null, utente_username VARCHAR(255) references utente (username) on delete cascade not null);" +
            				/* tables (images and videos) */
	        			    "create TABLE immagine_profilo (immagine_nome TEXT not null, immagine BYTEA not null, utente_username VARCHAR(255) references utente (username) on delete cascade not null, primary key (immagine_nome, utente_username));" +
						    "create TABLE immagine_preparazione (immagine_nome TEXT not null, immagine BYTEA not null, ricetta_id BIGINT references ricetta (id) on delete cascade not null, primary key (immagine_nome, ricetta_id));" + 
			                "create TABLE video_preparazione (video_nome TEXT not null, video BYTEA not null, ricetta_id BIGINT references ricetta (id) on delete cascade not null, primary key (video_nome, ricetta_id));";
			PreparedStatement statement = connection.prepareStatement(create);
			statement.executeUpdate();
			System.out.println("Executed create database: OK!");
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

	public void dropDatabase() {		
		Connection connection = dataSource.getConnection();
		try {
			String drop = "drop SEQUENCE if exists sequenza_id_ricetta;" +
	  				      "drop SEQUENCE if exists sequenza_id_commento;" +
 	  				      "drop SEQUENCE if exists sequenza_id_voto;" +
 	  				      "drop TABLE if exists utente cascade;" +
 	  				      "drop TABLE if exists ricetta cascade;" +
 	  				      "drop TABLE if exists ricetta_preferita cascade;" +
 	  				      "drop TABLE if exists commento cascade;" +
  	  				      "drop TABLE if exists voto cascade;" +
   	  				      "drop TABLE if exists immagine_profilo;" +
					      "drop TABLE if exists immagine_preparazione;" +
					      "drop TABLE if exists video_preparazione;" +
			              "drop TYPE if exists categoria_type;" +
			              "drop TYPE if exists difficolta_type;";
			PreparedStatement statement = connection.prepareStatement(drop);
			statement.executeUpdate();
			System.out.println("Executed drop database: OK!");
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
