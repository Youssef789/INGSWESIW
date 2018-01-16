package model;

import java.util.HashSet;
import java.util.Set;

import raw.Immagine;
import raw.Ingrediente;
import raw.Video;

public class Ricetta {
	
	private Long id;	
	private String titolo;
	private Categoria categoria;
	private Immagine immaginePrincipale;
	private Difficolta difficolta;
	private String tempoPreparazione;
	private Set<Ingrediente> ingredienti = new HashSet<Ingrediente>(); 
	private String descrizione;
	private String preparazione;
	private Set<Immagine> immaginiPreparazione = new HashSet<Immagine>(); 
	private Set<Video> videoPreparazione = new HashSet<Video>(); 
	
	private Utente utente;
	
	private Set<Commento> commenti = new HashSet<Commento>();
	private Set<Voto> voti = new HashSet<Voto>();
	
	public Ricetta() { }

	public Long getId() {
		return id;
	}

	public String getTitolo() {
		return titolo;
	}

	public Categoria getCategoria() {
		return categoria;
	}

	public Immagine getImmaginePrincipale() {
		return immaginePrincipale;
	}

	public Difficolta getDifficolta() {
		return difficolta;
	}

	public String getTempoPreparazione() {
		return tempoPreparazione;
	}

	public Set<Ingrediente> getIngredienti() {
		return ingredienti;
	}

	public String getDescrizione() {
		return descrizione;
	}

	public String getPreparazione() {
		return preparazione;
	}

	public Set<Immagine> getImmaginiPreparazione() {
		return immaginiPreparazione;
	}

	public Set<Video> getVideoPreparazione() {
		return videoPreparazione;
	}
	
	public Utente getUtente() {
		return utente;
	}

	public Set<Commento> getCommenti() {
		return commenti;
	}

	public Set<Voto> getVoti() {
		return voti;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setTitolo(String titolo) {
		this.titolo = titolo;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}

	public void setImmaginePrincipale(Immagine immagine) {
		this.immaginePrincipale = immagine;
	}

	public void setDifficolta(Difficolta difficolta) {
		this.difficolta = difficolta;
	}

	public void setTempoPreparazione(String tempoPreparazione) {
		this.tempoPreparazione = tempoPreparazione;
	}

	public void setIngredienti(Set<Ingrediente> ingredienti) {
		this.ingredienti = ingredienti;
	}

	public void setDescrizione(String descrizione) {
		this.descrizione = descrizione;
	}

	public void setPreparazione(String preparazione) {
		this.preparazione = preparazione;
	}

	public void setImmaginiPreparazione(Set<Immagine> immaginiPreparazione) {
		this.immaginiPreparazione = immaginiPreparazione;
	}

	public void setVideoPreparazione(Set<Video> videoPreparazione) {
		this.videoPreparazione = videoPreparazione;
	}

	public void setCommenti(Set<Commento> commenti) {
		this.commenti = commenti;
	}
	
	public void setUtente(Utente utente) {
		this.utente = utente;
	}

	public void setVoti(Set<Voto> voti) {
		this.voti = voti;
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
		Ricetta other = (Ricetta) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
	@Override
	public String toString() {
		return "Ricetta [id = " + id + ", titolo = " + titolo + ", utente.username = " + utente.getUsername() + "]";
	}
		
	////////////////////////////////////////////////////////////////////////////
	////////////////////////////////////////////////////////////////////////////
	////////////////////////////////////////////////////////////////////////////

	public boolean aggiungiImmaginePreparazione(Immagine immagine) {
		return immaginiPreparazione.add(immagine);
	}
	
	public boolean rimuoviImmaginePrepazione(Immagine immagine) {
		return immaginiPreparazione.remove(immagine);
	}
	
	public boolean aggiungiVideoPreparazione(Video video) {
		return videoPreparazione.add(video);
	}
	
	public boolean rimuoviVideoPrepazione(Video video) {
		return videoPreparazione.remove(video);
	}

	public boolean aggiungiCommento(Commento commento) {
		return commenti.add(commento);
	}
	
	public boolean rimuoviCommento(Commento commento) {
		return commenti.remove(commento);
	}
	
	public Long calcolaVotoComplessivo() {
		Long votoComplessivo = new Long(0);
		for (Voto voto : voti) {
			votoComplessivo += voto.getValore();
		}
		return (votoComplessivo / voti.size());
	} 

}
