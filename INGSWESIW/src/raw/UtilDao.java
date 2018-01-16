package raw;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import persistence.DataSource;
import persistence.PersistenceException;

public class UtilDao {
	
	private DataSource dataSource;

	public UtilDao(DataSource dataSource) {
		this.dataSource = dataSource;
	}
	
	public void createDatabase() {
		Connection connection = dataSource.getConnection();
		try {
			String create = "create SEQUENCE sequenza_id;"
					       + "create table utente"
					       + "(id CHARACTER(255) primary key," 
					       + "name VARCHAR(255),username VARCHAR(255),"
					       + "email VARCHAR(255),password VARCHAR(255));"
					+ "create table ricetta(id CHARACTER(255) primary key,"
					+ "title VARCHAR(255),category VARCHAR(255),"
					+ "difficulty VARCHAR(255),preparationTime VARCHAR(255),"
					+ "image bytea,ingredient VARCHAR(1000),"
					+ "description VARCHAR(5000),preparation VARCHAR(9000));"
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


	public void dropDatabase() {
		
		Connection connection = dataSource.getConnection();
		try {
			String delete = "drop SEQUENCE if EXISTS sequenza_id;"
					+ "drop table if exists utente;"
					+ "drop table if exists ricetta;"
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



	public void resetDatabase() {
			
			Connection connection = dataSource.getConnection();
			try {
				String delete = "delete FROM utente";
				PreparedStatement statement = connection.prepareStatement(delete);
				statement.executeUpdate();
				
				delete = "delete FROM ricetta";
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
