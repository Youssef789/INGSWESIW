package persistence;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class UtilDao {
	
	private DataSource dataSource;

	public UtilDao(DataSource dataSource) {
			this.dataSource=dataSource;
		}

	public void dropDatabase(){
		
		Connection connection = dataSource.getConnection();
		try {
			String delete = "drop SEQUENCE if EXISTS sequenza_id;"
					+ "drop table if exists commento;"
					+ "drop table if exists voto;"
					+ "drop table if exists ricetta;"
					+ "drop table if exists utente;"
					;
			PreparedStatement statement = connection.prepareStatement(delete);
			
			statement.executeUpdate();
			System.out.println("Executed drop database");
			
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

	public void createDatabase(){
		
		Connection connection = dataSource.getConnection();
		try {
			
			String create = "create SEQUENCE sequenza_id;"
					+ "create table utente(\"id\" bigint primary key,"				
					+ "name VARCHAR(255),username VARCHAR(255),"
					+ "email VARCHAR(255),password VARCHAR(255));"
					+ "create table ricetta(\"id\" bigint primary key,"
					+ "title VARCHAR(255),category VARCHAR(255),"
					+ "difficulty VARCHAR(255),preparationTime VARCHAR(255),"
					+ "imageName VARCHAR(255),imagePath VARCHAR(255),ingredient VARCHAR(1000),"
					+ "description VARCHAR(5000),preparation VARCHAR(9000),utente_id bigint REFERENCES utente(\"id\"));"
					+ "create table commento(\"id\" bigint primary key,text VARCHAR(255),"				
					+ "utente_id bigint REFERENCES utente(\"id\"),ricetta_id bigint REFERENCES utente(\"id\"));"
					+ "create table voto(\"id\" bigint primary key,voto bigint,"				
					+ "utente_id bigint REFERENCES utente(\"id\"),ricetta_id bigint REFERENCES utente(\"id\"));"
					;
			
			PreparedStatement statement = connection.prepareStatement(create);
			
			statement.executeUpdate();
			System.out.println("Executed create database");
			
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


	public  void resetDatabase() {
			
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
