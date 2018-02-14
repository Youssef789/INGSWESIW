package persistence.dao.jdbc;

import java.util.Set;

import model.Commento;
import model.Ricetta;
import model.Voto;
import persistence.DataSource;

public class RicettaProxy extends Ricetta {
	
	private DataSource dataSource;

	public RicettaProxy(DataSource dataSource) {
		this.dataSource = dataSource;
	}
	
	@Override
	public Set<Commento> getCommenti() { 
		Set<Commento> commenti = new CommentoDaoJDBC(dataSource).findByRicetta(this);
		this.setCommenti(commenti);
		return super.getCommenti(); 
	}
	
	@Override
	public Set<Voto> getVoti() {
		Set<Voto> voti = new VotoDaoJDBC(dataSource).findByRicetta(this);
		this.setVoti(voti);
		return super.getVoti(); 
	}
	
}
