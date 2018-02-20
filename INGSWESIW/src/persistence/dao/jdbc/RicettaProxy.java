package persistence.dao.jdbc;

import java.util.List;

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
	public List<Commento> getCommenti() { 
		List<Commento> commenti = new CommentoDaoJDBC(dataSource).findByRicetta(this);
		this.setCommenti(commenti);
		return super.getCommenti(); 
	}
	
	@Override
	public List<Voto> getVoti() {
		List<Voto> voti = new VotoDaoJDBC(dataSource).findByRicetta(this);
		this.setVoti(voti);
		return super.getVoti(); 
	}
	
	@Override
	public Double getVotoComplessivo() {
		List<Voto> voti = new VotoDaoJDBC(dataSource).findByRicetta(this);
		Double votoComplessivo = new Double(0);
		for (Voto voto : voti) {
			votoComplessivo += voto.getValore();
		}
		return (votoComplessivo / voti.size());
	}

}
