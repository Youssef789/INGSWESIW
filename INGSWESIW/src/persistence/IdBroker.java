package persistence;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import model.Commento;
import model.Ricetta;
import model.Voto;

public class IdBroker {

		
private static Map<String, String> queries_nextval;
	
	static {
		queries_nextval = new HashMap<String, String>();
		queries_nextval.put(Ricetta.class.getSimpleName(), "select nextval('sequenza_id_ricetta') as id");
		queries_nextval.put(Commento.class.getSimpleName(), "select nextval('sequenza_id_commento') as id");
		queries_nextval.put(Voto.class.getSimpleName(), "select nextval('sequenza_id_voto') as id");
	}

	public static Long getId(Connection connection, Object object) {
		Long id = null;
		try {
			String current_query_nextval = queries_nextval.get(object.getClass().getSimpleName());
			PreparedStatement statement = connection.prepareStatement(current_query_nextval);
			ResultSet result = statement.executeQuery();
			result.next();
			id = result.getLong("id");
		} catch (SQLException e) {
			throw new PersistenceException(e.getMessage());
		}
		return id;
	}
}
