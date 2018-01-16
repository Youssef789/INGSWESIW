package model;

import java.util.Date;

public class Commento {
	
	private Long id;
	private Date data;
	private String testo;
	
	private Ricetta ricetta;
	private Utente utente;
	
	public Commento() { }

	public Long getId() {
		return id;
	}

	public Date getData() {
		return data;
	}

	public String getTesto() {
		return testo;
	}

	public Ricetta getRicetta() {
		return ricetta;
	}

	public Utente getUtente() {
		return utente;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setData(Date data) {
		this.data = data;
	}

	public void setTesto(String testo) {
		this.testo = testo;
	}

	public void setRicetta(Ricetta ricetta) {
		this.ricetta = ricetta;
	}

	public void setUtente(Utente utente) {
		this.utente = utente;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Commento other = (Commento) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Commento [id = " + id + ", data = " + data + ", testo = " + testo + ", ricetta.id = " + ricetta.getId() + ", utente.username = " + utente.getUsername() + "]";
	}
	
}
