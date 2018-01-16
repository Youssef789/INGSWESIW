package persistence.dao.jdbc;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

import model.Ricetta;
import persistence.DataSource;
import persistence.IdBroker;
import persistence.PersistenceException;
import persistence.dao.RicettaDao;

public class RicettaDaoJDBC implements RicettaDao{
	
	private DataSource dataSource;
	public RicettaDaoJDBC(DataSource dataSource) {
		this.dataSource=dataSource;
	}
	
	@Override
	public void save(Ricetta ricetta) {

		
		Connection connection = this.dataSource.getConnection();
		try {
			Long id = IdBroker.getId(connection);
			ricetta.setId(id);
			String insert = "insert into ricetta(id,title,category,image,difficulty,preparationTime,ingredient,description,preparation) values (?,?,?,?,?,?,?,?,?)";
			PreparedStatement statement = connection.prepareStatement(insert);
			statement.setLong(1, ricetta.getId());
			statement.setString(2, ricetta.getTitle());
			statement.setString(3, ricetta.getCategory());
			statement.setBinaryStream(4, ricetta.getImage());
			statement.setString(5, ricetta.getDifficulty());
			statement.setString(6, ricetta.getPreparationTime());
			statement.setString(7, ricetta.getIngredient());
			statement.setString(8, ricetta.getDescription());
			statement.setString(9, ricetta.getPreparation());
			
			statement.executeUpdate();
		}catch (SQLException  e) {
			if (connection != null) {
				try {
					connection.rollback();
				} catch(SQLException excep) {
					throw new PersistenceException(e.getMessage());
				}
			} 
		}finally {
			try {
				connection.close();
			} catch (SQLException e) {
				throw new PersistenceException(e.getMessage());
			}
		}
		
	}

	@Override
	public Ricetta findByPrimaryKey(Long id) {
		Connection connection = this.dataSource.getConnection();
		Ricetta ricetta=null;
		try {
			PreparedStatement statement;
			String query="select * from ricetta where id=?";
			statement = connection.prepareStatement(query);
			statement.setLong(1,id);
			ResultSet result=statement.executeQuery();
			while (result.next())
			{
				//byte[] imgBytes = result.getBytes(1);
				ricetta=new Ricetta();
				ricetta.setId(result.getLong("id"));
				ricetta.setTitle(result.getString("title"));
				ricetta.setCategory(result.getString("category"));
				ricetta.setImage(result.getBinaryStream("photo"));
				ricetta.setDifficulty(result.getString("difficulty"));
				ricetta.setPreparationTime(result.getString("preparationTime"));
				ricetta.setIngredient(result.getString("ingredient"));
				ricetta.setDescription(result.getString("description"));
				ricetta.setPreparation(result.getString("preparation"));
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
		return ricetta;
	}

	@Override
	public List<Ricetta> findAll() {
		
		Connection connection = this.dataSource.getConnection();
		List<Ricetta> ricette=new LinkedList<>();
		try {
			Ricetta ricetta;
			PreparedStatement statement;
			String query="SELECT * FROM ricetta";
			statement = connection.prepareStatement(query);
			ResultSet result=statement.executeQuery();
			while (result.next())
			{
				ricetta=new Ricetta();
				ricetta.setId(result.getLong("id"));
				ricetta.setTitle(result.getString("title"));
				ricetta.setCategory(result.getString("category"));
				ricetta.setImage(result.getBinaryStream("photo"));
				ricetta.setDifficulty(result.getString("difficulty"));
				ricetta.setPreparationTime(result.getString("preparationTime"));
				ricetta.setIngredient(result.getString("ingredient"));
				ricetta.setDescription(result.getString("description"));
				ricetta.setPreparation(result.getString("preparation"));
				
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
		return ricette;
	}

	@Override
	public void update(Ricetta ricetta) {
		Connection connection = this.dataSource.getConnection();
		try {
			String update = "update ricetta SET title =?,category =?,image =?,difficulty=?,preparationTime=?,ingredient=?,description=?,preparation=? WHERE id=?";
			PreparedStatement statement = connection.prepareStatement(update);
			//statement.setLong(1, ricetta.getId());
			statement.setString(2, ricetta.getTitle());
			statement.setString(3, ricetta.getCategory());
			statement.setBinaryStream(4,  ricetta.getImage());
			statement.setString(5, ricetta.getDifficulty());
			statement.setString(6, ricetta.getPreparationTime());
			statement.setString(7, ricetta.getIngredient());
			statement.setString(8, ricetta.getDescription());
			statement.setString(9, ricetta.getPreparation());
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

	@Override
	public void delete(Ricetta ricetta) {
		Connection connection = this.dataSource.getConnection();
		try {
			String delete = "delete FROM ricetta WHERE id = ? ";
			PreparedStatement statement = connection.prepareStatement(delete);
			statement.setLong(1, ricetta.getId());
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

	@Override
	public List<Ricetta> findByCategory(String category) {
		Connection connection = this.dataSource.getConnection();
		List<Ricetta> ricette=new LinkedList<>();
		try {
			Ricetta ricetta;
			PreparedStatement statement;
			String query="select * from ricetta where category=?";
			statement = connection.prepareStatement(query);
			ResultSet result=statement.executeQuery();
			while (result.next())
			{
				ricetta=new Ricetta();
				ricetta.setId(result.getLong("id"));
				ricetta.setTitle(result.getString("title"));
				ricetta.setCategory(result.getString("category"));
				ricetta.setImage(result.getBinaryStream("photo"));
				ricetta.setDifficulty(result.getString("difficulty"));
				ricetta.setPreparationTime(result.getString("preparationTime"));
				ricetta.setIngredient(result.getString("ingredient"));
				ricetta.setDescription(result.getString("description"));
				ricetta.setPreparation(result.getString("preparation"));
				
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
		return ricette;

	}

}
