package persistence;

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
import persistence.dao.UtenteDao;

public class UtenteDaoJDBC implements UtenteDao{
	
	private DataSource dataSource;
	
	public UtenteDaoJDBC(DataSource dataSource) {
		this.dataSource=dataSource;
	}

	@Override
	public void save(Utente utente) {
		Connection connection = this.dataSource.getConnection();
		try {
			Long id = IdBroker.getId(connection);
			utente.setId(id);
			String insert = "insert into utente(id,name,username,email) values (?,?,?,?)";
			PreparedStatement statement = connection.prepareStatement(insert);

			statement.setLong(1, utente.getId());
			statement.setString(2, utente.getName());
			statement.setString(3, utente.getUsername());
			statement.setString(4, utente.getEmail());
			
			statement.executeUpdate();
			
			//this.updateRecipes(utente,connection);
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

	private void updateRecipes(Utente utente, Connection connection)throws SQLException {
		RicettaDao recipeDao=new RicettaDaoJDBC(dataSource);
		for (Ricetta recipe : utente.getRecipes()) {
			if(recipeDao.findByPrimaryKey(recipe.getId())==null) {
				recipeDao.save(recipe);
			}
			String update = "update ricetta SET utente_id = ? WHERE id = ?";
			
				PreparedStatement statement = connection.prepareStatement(update);
				statement.setLong(1, utente.getId());
				statement.setLong(2, recipe.getId());
				statement.executeUpdate();
			

		}
	}

	@Override
	public Utente findByPrimaryKey(Long id) {
		
		Connection connection = this.dataSource.getConnection();
		Utente utente = null;
		try {
			PreparedStatement statement;
			String query = "select * from utente where id = ?";
			statement = connection.prepareStatement(query);
			statement.setLong(1, id);
			ResultSet result = statement.executeQuery();
			if (result.next()) {
				utente = new Utente();
				utente.setId(result.getLong("id"));
				utente.setName(result.getString("name"));
				utente.setUsername(result.getString("username"));
				utente.setEmail(result.getString("email"));				
				
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
		return utente;

	}

	@Override
	public List<Utente> findAll() {
		
		Connection connection = this.dataSource.getConnection();
		List<Utente> utenti = new LinkedList<>();
		try {
			Utente utente;
			PreparedStatement statement;
			String query = "select * from utente";
			statement = connection.prepareStatement(query);
			ResultSet result = statement.executeQuery();
			while (result.next()) {
				utente = new Utente();
				utente.setId(result.getLong("id"));
				utente.setName(result.getString("name"));
				utente.setUsername(result.getString("username"));
				utente.setEmail(result.getString("email"));		
				
				utenti.add(utente);
			}
		} catch (SQLException e) {
			throw new PersistenceException(e.getMessage());
		}	 finally {
			try {
				connection.close();
			} catch (SQLException e) {
				throw new PersistenceException(e.getMessage());
			}
		}
		return utenti;
	}

	@Override
	public void update(Utente utente) {
		Connection connection = this.dataSource.getConnection();
		try {
			String update = "update utente SET name = ?, email = ? WHERE username=?";

			PreparedStatement statement = connection.prepareStatement(update);
			statement.setString(1, utente.getName());
			statement.setString(2, utente.getEmail());
			
			statement.executeUpdate();
			//this.updateComments(utente,connection);
			this.updateRecipes(utente,connection);
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
	public void delete(Utente utente) {
		Connection connection = this.dataSource.getConnection();
		try {
			String delete = "delete FROM utente WHERE id = ? ";
			PreparedStatement statement = connection.prepareStatement(delete);
			statement.setLong(1, utente.getId());
			
			connection.setAutoCommit(false);
			connection.setTransactionIsolation(Connection.TRANSACTION_SERIALIZABLE);			
			this.removeForeignKeyFromRecipe(utente, connection);
			this.removeForeignKeyFromComment(utente, connection);     			

			/* 
			 * ora rimuoviamo il utente
			 * 
			 * */
			statement.executeUpdate();
			connection.commit();
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
	
	private void removeForeignKeyFromComment(Utente utente, Connection connection) throws SQLException {
		for (Commento comment : utente.getComments()) {
			String update = "update commento SET utente_id = NULL WHERE id = ?";
			PreparedStatement statement = connection.prepareStatement(update);
			statement.setLong(1, comment.getId());
			statement.executeUpdate();
		}
	}

	private void removeForeignKeyFromRecipe(Utente utente, Connection connection) throws SQLException {
		for (Ricetta recipe : utente.getRecipes()) {
			String update = "update ricetta SET utente_id = NULL WHERE id = ?";
			PreparedStatement statement = connection.prepareStatement(update);
			statement.setLong(1, recipe.getId());
			statement.executeUpdate();
		}	
	}

	@Override
	public void setPassword(Utente utente, String password) {
		Connection connection = this.dataSource.getConnection();
		try {
			String update = "update utente SET password = ? WHERE username=?";
			PreparedStatement statement = connection.prepareStatement(update);
			statement.setString(1, password);
			statement.setString(2, utente.getUsername());
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
	public boolean checkLogin(String username, String password) {
		boolean status=false;
	
		Connection connection = this.dataSource.getConnection();
		//Utente utente = null;
		try {
			PreparedStatement statement;
			String query = "select * from utente where username = ? and password = ?";
			statement = connection.prepareStatement(query);
			statement.setString(1, username);
			statement.setString(2, password);
			ResultSet result = statement.executeQuery();
			status= result.next();
			}catch (SQLException e) {
				throw new PersistenceException(e.getMessage());
			}
		return status;
			

	}

	@Override
	public UtenteCredenziali findByPrimaryKeyCredential(Long id) {
		Utente utente = findByPrimaryKey(id);
		UtenteCredenziali utenteCredenziali = null;
		if (utente != null){
			utenteCredenziali = new UtenteCredenziali(dataSource);
			utenteCredenziali.setName(utente.getName());
			utenteCredenziali.setUsername(utente.getUsername());
			utenteCredenziali.setEmail(utente.getEmail());
		}
		return utenteCredenziali;
	}


	@Override
	public void setFollower(Utente follower, Utente following) {
		Connection connection = this.dataSource.getConnection();
		try {
			String update = "update follow SET follower = ? WHERE username=?";
			PreparedStatement statement = connection.prepareStatement(update);
			statement.setObject(1, follower);
			statement.setString(2, following.getUsername());
			
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
	public void setFollowing(Utente utente, Utente utente2) {
		
		
	}

	@Override
	public Utente findByPrimaryKeyJoinRecipe(Long id) {
		Connection connection = this.dataSource.getConnection();
		Utente utente=null;
		try {
			PreparedStatement statement;
			String query = "select u.id as u_id u.name as u_name, u.username as u_username,u.email as u_email, "
					+ "r.id as r_id, r.title as title,r.category as category,r.image as image, "
					+ "r.difficulty as difficulty, r.preparationTime as preparationTime, r.ingredient as ingredient, "
					+ "r.description as description, r.preparation as preparation "
					+ "from utente u left outer join ricetta r on u.id=r.utente_id "
					+ "where u.username = ?";
			statement = connection.prepareStatement(query);
			statement.setLong(1, id);
			ResultSet result = statement.executeQuery();
			boolean primaRiga = true;
			while (result.next()) {
				if (primaRiga) {
					utente = new Utente();
					utente.setId(result.getLong("u_id"));				
					utente.setName(result.getString("u_name"));
					utente.setUsername(result.getString("u_username"));
					utente.setEmail(result.getString("u_email"));

					primaRiga = false;
				}
				Long r_id=result.getLong("r_id");
				if(r_id != null){
					Ricetta ricetta = new Ricetta();
					ricetta.setId(result.getLong("r_id"));
					ricetta.setTitle(result.getString("title"));
					ricetta.setCategory(result.getString("category"));
					//ricetta.setImage(result.getString("image"));
					ricetta.setDifficulty(result.getString("difficulty"));
					ricetta.setPreparationTime(result.getString("preparationTime"));
					ricetta.setIngredient(result.getString("ingredient"));
					ricetta.setDescription(result.getString("description"));
					ricetta.setPreparation(result.getString("preparation"));

					utente.addRecipe(ricetta);
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
		return utente;
	}

	@Override
	public Utente findByPrimaryKeyJoinComment(Long id) {
		Connection connection = this.dataSource.getConnection();
		Utente utente=null;
		try {
			PreparedStatement statement;
			String query = "select u.id as u_id u.name as u_name, u.username as u_username,u.email as u_email, "
					+ "c.id as c_id, c.text as text "
					+ "from utente u left outer join commento c on u.id=c.utente_id "
					+ "where u.username = ?";
			statement = connection.prepareStatement(query);
			statement.setLong(1, id);
			ResultSet result = statement.executeQuery();
			boolean primaRiga = true;
			while (result.next()) {
				if (primaRiga) {
					utente = new Utente();
					utente.setId(result.getLong("u_id"));				
					utente.setName(result.getString("u_name"));
					utente.setUsername(result.getString("u_username"));
					utente.setEmail(result.getString("u_email"));

					primaRiga = false;
				}
				
				Long c_id=result.getLong("c_id");
				if(c_id != null){
					Commento commento = new Commento();
					commento.setId(result.getLong("c_id"));
					commento.setText(result.getString("text"));
					
					utente.addComment(commento);
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
		return utente;
	}

	@Override
	public Utente findByPrimaryKeyJoinVote(Long id) {
		Connection connection = this.dataSource.getConnection();
		Utente utente=null;
		try {
			PreparedStatement statement;
			String query = "select u.id as u_id u.name as u_name, u.username as u_username,u.email as u_email, "
					+ "v.id as v_id, v.voto as v_voto "
					+ "from utente u left outer join voto v on u.id=v.utente_id "
					+ "where u.username = ?";
			statement = connection.prepareStatement(query);
			statement.setLong(1, id);
			ResultSet result = statement.executeQuery();
			boolean primaRiga = true;
			while (result.next()) {
				if (primaRiga) {
					utente = new Utente();
					utente.setId(result.getLong("u_id"));				
					utente.setName(result.getString("u_name"));
					utente.setUsername(result.getString("u_username"));
					utente.setEmail(result.getString("u_email"));

					primaRiga = false;
				}
				
				Long v_id=result.getLong("v_id");
				if(v_id != null){
					Voto voto=new Voto();
					voto.setId(result.getLong("v_id"));
					voto.setVoto(result.getLong("v_voto"));
					utente.addvote(voto);
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
		return utente;
	}

	

}
