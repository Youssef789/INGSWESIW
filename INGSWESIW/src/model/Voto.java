package model;

public class Voto {
	
	private long id;
	private Long voto;
	private Utente utente;
	private Ricetta ricetta;
	
	public Voto() {
	}
	
	public Voto(long id,Long voto,Utente utente) {
		this.id=id;
		this.voto=voto;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Long getVoto() {
		return voto;
	}

	public void setVoto(Long voto) {
		this.voto = voto;
	}

	public Utente getUtente() {
		return utente;
	}

	public void setUtente(Utente utente) {
		this.utente = utente;
	}

	public Ricetta getRicetta() {
		return ricetta;
	}

	public void setRicetta(Ricetta ricetta) {
		this.ricetta = ricetta;
	}
	
	

}
