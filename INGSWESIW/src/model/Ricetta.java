package model;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import model.media.ImmagineRicetta;
import model.media.VideoRicetta;

public class Ricetta {
	
	private Long id;
	private Timestamp dataPubblicazione; /* se la ricetta non è stata ancora pubblicata (è in bozza), sarà null, altrimenti gli viene assegnato nel jdbc in save */
	private Timestamp dataUltimaModifica; /* fino a quando la ricetta non sarà modificata, sarà null, altrimenti gli viene assegnato nel jdbc in update */
	private String titolo;
	private Categoria categoria;
	private Difficolta difficolta;
	private String tempoPreparazione;
	private ImmagineRicetta immaginePrincipale;
	private String ingredienti; 
	private String descrizione;
	private String preparazione;
	private List<ImmagineRicetta> immaginiPreparazione = new ArrayList<ImmagineRicetta>(); 
	private List<VideoRicetta> videoPreparazione = new ArrayList<VideoRicetta>(); 
	
	private List<Commento> commenti = new ArrayList<Commento>();
	private List<Voto> voti = new ArrayList<Voto>();
	
	private Utente utente;
		
	public Ricetta() { }

	public Long getId() {
		return id;
	}
	
	public Timestamp getDataPubblicazione() {
		return dataPubblicazione;
	}
	
	public Timestamp getDataUltimaModifica() {
		return dataUltimaModifica;
	}

	public String getTitolo() {
		return titolo;
	}

	public Categoria getCategoria() {
		return categoria;
	}
	
	public Difficolta getDifficolta() {
		return difficolta;
	}

	public ImmagineRicetta getImmaginePrincipale() {
		return immaginePrincipale;
	}

	public String getTempoPreparazione() {
		return tempoPreparazione;
	}

	public String getIngredienti() {
		return ingredienti;
	}

	public String getDescrizione() {
		return descrizione;
	}

	public String getPreparazione() {
		return preparazione;
	}

	public List<ImmagineRicetta> getImmaginiPreparazione() {
		return immaginiPreparazione;
	}

	public List<VideoRicetta> getVideoPreparazione() {
		return videoPreparazione;
	}
	
	public List<Commento> getCommenti() {
		return commenti;
	}

	public List<Voto> getVoti() {
		return voti;
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
	
	public void setTitolo(String titolo) {
		this.titolo = titolo;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}
	
	public void setDifficolta(Difficolta difficolta) {
		this.difficolta = difficolta;
	}

	public void setImmaginePrincipale(ImmagineRicetta immagine) {
		this.immaginePrincipale = immagine;
	}

	public void setTempoPreparazione(String tempoPreparazione) {
		this.tempoPreparazione = tempoPreparazione;
	}

	public void setIngredienti(String ingredienti) {
		this.ingredienti = ingredienti;
	}

	public void setDescrizione(String descrizione) {
		this.descrizione = descrizione;
	}

	public void setPreparazione(String preparazione) {
		this.preparazione = preparazione;
	}

	public void setImmaginiPreparazione(List<ImmagineRicetta> immaginiPreparazione) {
		this.immaginiPreparazione = immaginiPreparazione;
	}

	public void setVideoPreparazione(List<VideoRicetta> videoPreparazione) {
		this.videoPreparazione = videoPreparazione;
	}

	public void setCommenti(List<Commento> commenti) {
		this.commenti = commenti;
	}
	
	public void setVoti(List<Voto> voti) {
		this.voti = voti;
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
		return "Ricetta [id = " + id + ", titolo = " + titolo + ", categoria = " + categoria.toString() + ", difficolta = " + difficolta.toString() + ", username.id = " + utente.getUsername() + "]";
	}
		
	///////////////////////////////////////////////////////////////////////
	///////////////////////////////////////////////////////////////////////
	///////////////////////////////////////////////////////////////////////

	public boolean aggiungiImmaginePreparazione(ImmagineRicetta immagine) {
		return immaginiPreparazione.add(immagine);
	}
	
	public boolean rimuoviImmaginePrepazione(ImmagineRicetta immagine) {
		return immaginiPreparazione.remove(immagine);
	}
	
	public boolean aggiungiVideoPreparazione(VideoRicetta video) {
		return videoPreparazione.add(video);
	}
	
	public boolean rimuoviVideoPrepazione(VideoRicetta video) {
		return videoPreparazione.remove(video);
	}

	public boolean aggiungiCommento(Commento commento) {
		return commenti.add(commento);
	}
	
	public boolean rimuoviCommento(Commento commento) {
		return commenti.remove(commento);
	}
	
	public boolean aggiungiVoto(Voto voto) {
		return voti.add(voto);
	}
	
	public boolean rimuoviVoto(Voto voto) {
		return voti.add(voto);
	}
	
	public Long getVotoComplessivo() {
		Long votoComplessivo = new Long(0);
		for (Voto voto : voti) {
			votoComplessivo += voto.getValore();
		}
		return (votoComplessivo / voti.size());
	} 

}
