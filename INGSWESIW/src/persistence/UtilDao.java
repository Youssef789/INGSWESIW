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
					        "create table utente(username VARCHAR(255) primary key, email VARCHAR(255), password VARCHAR(255));" +
					        "create table ricetta(id BIGINT primary key), " +
					        "create table commento(id BIGINT primary key)," +
					        "create table voto(id BIGINT primary key, voto INT, ricetta_id BIGINT REFERENCES ricetta, utente_username VARCHAR(255) REFERENCES utente)";
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
					      "drop table if exists utente;" +
				          "drop table if exists ricetta;" + 
			              "drop table if exists commmento" +
				          "drop table if exists voto";
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

	public void deleteDatabase() {
		Connection connection = dataSource.getConnection();
		try {
			String delete = "delete FROM utente";
			PreparedStatement statement = connection.prepareStatement(delete);
			statement.executeUpdate();
			delete = "delete FROM ricetta";
			statement = connection.prepareStatement(delete);
			statement.executeUpdate();
			delete = "delete FROM commento";
			statement = connection.prepareStatement(delete);
			statement.executeUpdate();
			delete = "delete FROM voto";
			statement = connection.prepareStatement(delete);
			statement.executeUpdate();
			System.out.println("Executed delete database.");
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
