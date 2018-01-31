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
			String create = "create sequence sequenza_id_ricetta;" +
		                    "create sequence sequenza_id_commento;" +
					        "create sequence sequenza_id_voto;" + 
		                    "create type categoria_type as enum ('ANTIPASTI', 'PRIMI_PIATTI', 'SECONDI_PIATTI', 'PIATTI_UNICI', 'CONTORNI', 'DOLCI', 'LIEVITATI', 'SALSE_E_SUGHI', 'MARMELLATE_E_CONSERVE', 'BEVANDE', 'ALTRO');" +
					        "create type difficolta_type as enum ('FACILE', 'MEDIA', 'DIFFICILE');" +
					        "create table utente (username VARCHAR(255) primary key not null, email VARCHAR(255) not null unique, password VARCHAR(255) not null, immagineProfilo VARCHAR(255));" +
			                "create table ricetta (id BIGINT primary key not null, dataPubblicazione date, dataUltimaModifica date, titolo VARCHAR(255), categoria categoria_type, difficolta difficolta_type, tempoPreparazione VARCHAR(255), pathImmaginePrincipale VARCHAR(255), ingredienti VARCHAR(255), descrizione VARCHAR(255), preparazione VARCHAR(255), utente_username VARCHAR(255) references utente (username) on delete cascade not null );" +
					        "create table ricetta_preferita (ricetta_id BIGINT references ricetta (id) on delete restrict not null, utente_username VARCHAR(255) references utente (username) on delete restrict not null, primary key (ricetta_id, utente_username));" +
			                "create table commento (id BIGINT primary key not null, dataPubblicazione timestamp not null, dataUltimaModifica timestamp, contenuto VARCHAR(255) not null, ricetta_id BIGINT references ricetta (id) on delete cascade not null, utente_username VARCHAR(255) references utente (username) on delete cascade not null);" + 
			                "create table voto (id BIGINT primary key not null, valore SMALLINT not null, ricetta_id BIGINT references ricetta (id) on delete restrict not null, utente_username VARCHAR(255) references utente (username) on delete cascade not null);";
			PreparedStatement statement = connection.prepareStatement(create);
			statement.executeUpdate();
			System.out.println("Executed create database...");
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
			String drop = "drop sequence if exists sequenza_id_ricetta;" +
	  				      "drop sequence if exists sequenza_id_commento;" +
 	  				      "drop sequence if exists sequenza_id_voto;" +
  	  				      "drop table if exists utente cascade;" +
    	  				  "drop table if exists ricetta cascade;" +
     	  				  "drop table if exists ricetta_preferita cascade;" +
					      "drop table if exists commento cascade;" +
					      "drop table if exists voto cascade;" +	              
			              "drop type if exists categoria_type;" +
			              "drop type if exists difficolta_type;";
			PreparedStatement statement = connection.prepareStatement(drop);
			statement.executeUpdate();
			System.out.println("Executed drop database...");
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
