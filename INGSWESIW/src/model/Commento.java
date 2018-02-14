package model;

import java.sql.Timestamp;

public class Commento {
	
	private Long id; /* id del commento */
	private Timestamp dataPubblicazione; /* data di pubblicazione del commento (gli viene assegnato nel jdbc quando il commento verrà salvato) */
	private Timestamp dataUltimaModifica; /* data di ultima modifica del commento (fino a quando il commento non sarà modificato sarà null, altrimenti gli viene assegnato nel jdbc dopo che il commento viene modificato) */
	private String contenuto; /* contenuto del commento */
	
	private Ricetta ricetta; /* ricetta associata al commento */
	private Utente utente; /* utente proprietario del commento */ 
	
	public Commento() { }

	public Long getId() {
		return id;
	}

	public Timestamp getDataPubblicazione() {
		return dataPubblicazione;
	}
	
	public Timestamp getDataUltimaModifica() {
		return dataUltimaModifica;
	}

	public String getContenuto() {
		return contenuto;
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

	public void setDataPubblicazione(Timestamp dataPubblicazione) {
		this.dataPubblicazione = dataPubblicazione;
	}
	
	public void setDataUltimaModifica(Timestamp dataUltimaModifica) {
		this.dataUltimaModifica = dataUltimaModifica;
	}

	public void setContenuto(String contenuto) {
		this.contenuto = contenuto;
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
		return "Commento [id = " + id + ", dataPubblicazione = " + dataPubblicazione + ", dataUltimaModifica = " + dataUltimaModifica + ", contenuto = " + contenuto + ", ricetta.id = " + ricetta.getId() + ", utente.username = " + utente.getUsername() + "]";
	}
	
}
