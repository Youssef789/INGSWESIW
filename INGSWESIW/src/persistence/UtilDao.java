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
			String create = "create sequence sequenza_id;" + 
		                    "create type categoria_type as enum ('ANTIPASTI', 'PRIMI_PIATTI', 'SECONDI_PIATTI', 'PIATTI_UNICI');" +
					        "create type difficolta_type as enum ('FACILE', 'MEDIA', 'DIFFICILE');" +
					        "create table utente (username VARCHAR(255) primary key not null, email VARCHAR(255) not null, password VARCHAR(255) not null);" +
			                "create table ricetta (id BIGINT primary key not null, titolo VARCHAR(255), categoria categoria_type, difficolta difficolta_type);" +
			                "create table commento (id BIGINT primary key not null, testo VARCHAR(255), data date, ricetta_id BIGINT references ricetta (id), utente_username VARCHAR(255) references utente (username));" + 
			                "create table voto (id BIGINT primary key not null, valore SMALLINT, ricetta_id BIGINT references ricetta (id), utente_username VARCHAR(255) references utente (username));"; 
			PreparedStatement statement = connection.prepareStatement(create);
			statement.executeUpdate();
			System.out.println("Executed create database.");
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
			String drop = "drop sequence if exists sequenza_id;" +
					      "drop table if exists commento;" +
					      "drop table if exists voto;" +
					      "drop table if exists utente;" +
			              "drop table if exists ricetta;" + 
			              "drop type if exists categoria_type;" +
			              "drop type if exists difficolta_type;";
			PreparedStatement statement = connection.prepareStatement(drop);
			statement.executeUpdate();
			System.out.println("Executed drop database.");
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
