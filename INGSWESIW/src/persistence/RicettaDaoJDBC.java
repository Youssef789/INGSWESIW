package persistence;

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

import model.Commento;
import model.Ricetta;
import model.Utente;
import model.Voto;
import persistence.dao.CommentoDao;
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
			Long id = IdBroker.getId(connection,ricetta);
			ricetta.setId(id);
			String insert = "insert into ricetta(id,title,category,imageName,imagePath,difficulty,preparationTime,ingredient,description,preparation) values (?,?,?,?,?,?,?,?,?,?)";
			PreparedStatement statement = connection.prepareStatement(insert);
			statement.setLong(1, ricetta.getId());
			statement.setString(2, ricetta.getTitle());
			statement.setString(3, ricetta.getCategory());
			statement.setString(4, ricetta.getImageName());
			statement.setString(5, ricetta.getImagePath());
			statement.setString(6, ricetta.getDifficulty());
			statement.setString(7, ricetta.getPreparationTime());
			statement.setString(8, ricetta.getIngredient());
			statement.setString(9, ricetta.getDescription());
			statement.setString(10, ricetta.getPreparation());
			//statement.setLong(11,ricetta.getUtente().getId());
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

	private void updateComments(Ricetta ricetta, Connection connection)throws SQLException {
		CommentoDao commentDao=new CommentoDaoJDBC(dataSource);
		for (Commento comment : ricetta.getComments()) {
			if(commentDao.findByPrimaryKey(comment.getId())==null) {
				commentDao.save(comment);
			}
			
			String update = "update commento SET commento_id = ? WHERE id = ?";
			PreparedStatement statement = connection.prepareStatement(update);
			statement.setLong(1, ricetta.getId());
			statement.setLong(2, comment.getId());
			statement.executeUpdate();
		}
	}

	@Override
	public Ricetta findByPrimaryKey(Long id) {
		Connection connection = this.dataSource.getConnection();
		Ricetta ricetta=null;
		try {
			PreparedStatement statement;
			String query="select * from ricetta where id = ?";
			statement = connection.prepareStatement(query);
			statement.setLong(1,id);
			ResultSet result=statement.executeQuery();
			while (result.next())
			{
				
				ricetta=new Ricetta();
				ricetta.setId(result.getLong("id"));
				ricetta.setTitle(result.getString("title"));
				ricetta.setCategory(result.getString("category"));
				ricetta.setImageName(result.getString("imageName"));
				ricetta.setImagePath(result.getString("imagePath"));
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
			String query="select * from ricetta";
			statement = connection.prepareStatement(query);
			ResultSet result=statement.executeQuery();
			while (result.next())
			{
				ricetta=new Ricetta();
				ricetta.setId(result.getLong("id"));
				ricetta.setTitle(result.getString("title"));
				ricetta.setCategory(result.getString("category"));
				ricetta.setImageName(result.getString("imageName"));
				ricetta.setImagePath(result.getString("imagePath"));
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
			String update = "update ricetta SET title =?,category =?,imageName =?,imagePath =?,difficulty=?,preparationTime=?,ingredient=?,description=?,preparation=? WHERE id=?";
			PreparedStatement statement = connection.prepareStatement(update);
			statement.setString(2, ricetta.getTitle());
			statement.setString(3, ricetta.getCategory());
			statement.setString(4, ricetta.getImageName());
			statement.setString(5, ricetta.getImagePath());
			statement.setString(6, ricetta.getDifficulty());
			statement.setString(7, ricetta.getPreparationTime());
			statement.setString(8, ricetta.getIngredient());
			statement.setString(9, ricetta.getDescription());
			statement.setString(10, ricetta.getPreparation());
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
			statement.setString(1,category);
			ResultSet result=statement.executeQuery();
			while (result.next())
			{
				ricetta=new Ricetta();
				ricetta.setId(result.getLong("id"));
				ricetta.setTitle(result.getString("title"));
				ricetta.setCategory(result.getString("category"));
				ricetta.setImageName(result.getString("imageName"));
				ricetta.setImagePath(result.getString("imagePath"));
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
	public Ricetta findByPrimaryKeyJoinComment(Long id) {
		Connection connection = this.dataSource.getConnection();
		Ricetta ricetta=null;
		try {
			PreparedStatement statement;
			String query = "select r.id as r_id, r.title as title,r.category as category,r.image as image, "
					+ "r.difficulty as difficulty, r.preparationTime as preparationTime, r.ingredient as ingredient,"
					+ "r.description as description, r.preparation as preparation,"
					+ "c.id as c_id, c.text as c_text "
					+ "from ricetta r left outer join commento c on r.id=c.ricetta_id "
					+ "where r.title = ?";
			statement = connection.prepareStatement(query);
			statement.setLong(1, id);
			ResultSet result = statement.executeQuery();
			boolean primaRiga = true;
			while (result.next()) {
				if (primaRiga) {
					ricetta = new Ricetta();
					ricetta.setId(result.getLong("r_id"));				
					ricetta.setTitle(result.getString("title"));
					ricetta.setCategory(result.getString("category"));
					ricetta.setImageName(result.getString("imageName"));
					ricetta.setImagePath(result.getString("imagePath"));
					ricetta.setDifficulty(result.getString("difficulty"));
					ricetta.setPreparationTime(result.getString("preparationTime"));				
					ricetta.setIngredient(result.getString("ingredient"));
					ricetta.setDescription(result.getString("description"));
					ricetta.setPreparation(result.getString("preparation"));

					primaRiga = false;
				}
				Long c_id=result.getLong("c_id");
				if(c_id != null){
					Commento comment =new Commento();
					comment.setId(result.getLong("c_id"));
					comment.setContenuto(result.getString("c_text"));

					ricetta.addComment(comment);
				}
			}	
					
		}catch(SQLException e) {
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
	public Ricetta findByPrimaryKeyJoinVote(Long id) {
		Connection connection = this.dataSource.getConnection();
		Ricetta ricetta=null;
		try {
			PreparedStatement statement;
			String query = "select r.id as r_id, r.title as title,r.category as category,r.image as image, "
					+ "r.difficulty as difficulty, r.preparationTime as preparationTime, r.ingredient as ingredient,"
					+ "r.description as description, r.preparation as preparation,"
					+ "v.id as v_id, v.voto as v_voto "
					+ "from ricetta r left outer join commento v on r.id=v.ricetta_id "
					+ "where r.title = ?";
			statement = connection.prepareStatement(query);
			statement.setLong(1, id);
			ResultSet result = statement.executeQuery();
			boolean primaRiga = true;
			while (result.next()) {
				if (primaRiga) {
					ricetta = new Ricetta();
					ricetta.setId(result.getLong("r_id"));				
					ricetta.setTitle(result.getString("title"));
					ricetta.setCategory(result.getString("category"));
					ricetta.setImageName(result.getString("imageName"));
					ricetta.setImagePath(result.getString("imagePath"));
					ricetta.setDifficulty(result.getString("difficulty"));
					ricetta.setPreparationTime(result.getString("preparationTime"));				
					ricetta.setIngredient(result.getString("ingredient"));
					ricetta.setDescription(result.getString("description"));
					ricetta.setPreparation(result.getString("preparation"));

					primaRiga = false;
				}
				Long v_id=result.getLong("v_id");
				if(v_id != null){
					Voto voto=new Voto();
					voto.setId(result.getLong("v_id"));
					voto.setValore(result.getInt("v_voto"));
					ricetta.addvote(voto);
				}
			}	
					
		}catch(SQLException e) {
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

}
