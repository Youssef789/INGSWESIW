package model;

public class Commento {
	
	private Long id;
	private String text;
	private Utente utente;
	
	public Commento(Long id, String text) {
		this.id=id;
		this.text=text;
	}
	
	public Commento() {
	}
	
	public Utente getUtente() {
		return utente;
	}

	public void setUtente(Utente utente) {
		this.utente = utente;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}
	

}
