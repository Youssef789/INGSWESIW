package persistence;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Commento;
import persistence.dao.CommentoDao;

public class CommentoDaoJDBC implements CommentoDao {

	private DataSource dataSource;
	
	public CommentoDaoJDBC(DataSource dataSource) {
		this.dataSource=dataSource;
	}
	
	@Override
	public void save(Commento commento) {
		
		Connection connection = this.dataSource.getConnection();
		try {
			Long id = IdBroker.getId(connection);
			commento.setId(id);
			String insert = "insert into commento(id,text,utente_id,ricetta_id) values (?,?,?,?)";
			PreparedStatement statement = connection.prepareStatement(insert);
			statement.setLong(1, commento.getId());
			statement.setString(2, commento.getText());
			statement.setLong(3,commento.getUtente().getId());
			statement.setLong(4,commento.getRicetta().getId());


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
	public Commento findByPrimaryKey(Long id) {
		
		Connection connection = this.dataSource.getConnection();
		Commento commento=null;
		try {
			PreparedStatement statement;
			String query="select * from commento where id=?";
			statement = connection.prepareStatement(query);
			statement.setLong(1,id);
			ResultSet result=statement.executeQuery();
			while (result.next())
			{
				commento=new Commento();
				commento.setId(result.getInt("id"));
				commento.setText(result.getString("category"));
				
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
		return commento;
	}

	@Override
	public List<Commento> findAll() {
		
		Connection connection = this.dataSource.getConnection();
		List<Commento> commenti= new ArrayList<>();
		try {
			Commento commento;
			PreparedStatement statement;
			String query="select * from commento";
			statement = connection.prepareStatement(query);
			ResultSet result=statement.executeQuery();
			while (result.next())
			{
				commento=new Commento();
				commento.setId(result.getInt("id"));
				commento.setText(result.getString("category"));
				commenti.add(commento);
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
		return commenti;
	}

	@Override
	public void update(Commento commento) {
		Connection connection = this.dataSource.getConnection();
		try {
			String update = "update commento SET text =? WHERE id=?";
			PreparedStatement statement = connection.prepareStatement(update);
			//statement.setLong(1, ricetta.getId());
			statement.setString(2, commento.getText());
			
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
	public void delete(Commento commento) {
		Connection connection = this.dataSource.getConnection();
		try {
			String delete = "delete FROM commento WHERE id = ? ";
			PreparedStatement statement = connection.prepareStatement(delete);
			statement.setLong(1, commento.getId());
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
