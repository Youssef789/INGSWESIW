package model;

import java.io.File;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.sql.Timestamp;
import java.util.LinkedList;
import java.util.List;

public class Ricetta {
	
	private Long id; /* id della ricetta */
	private Timestamp dataPubblicazione; /* se la ricetta non è stata ancora pubblicata (è in bozza), sarà null, altrimenti gli viene assegnato nel jdbc in save */
	private Timestamp dataUltimaModifica; /* fino a quando la ricetta non sarà modificata, sarà null, altrimenti gli viene assegnato nel jdbc in update */
	private String titolo; /* titolo della ricetta */
	private Categoria categoria; /* categoria della ricetta */
	private Difficolta difficolta; /* difficoltà della ricetta */
	private String tempoPreparazione; /* tempo di preparazione della ricetta */
	private File immaginePrincipale; /* immagine principale della ricetta */
	private String ingredienti; /* ingredienti e quantità della ricetta */
	private String descrizione; /* descrizione della ricetta */
	private String preparazione; /* spiegazione sulla preparazione della ricetta */
	private List<File> immaginiPreparazione = new LinkedList<File>(); /* immagini a supporto alla spiegazione sulla preparazione della ricetta */
	private List<File> videoPreparazione = new LinkedList<File>(); /* video a supporto alla spiegazione sulla preparazione della ricetta */
	
	private List<Commento> commenti = new LinkedList<Commento>(); /* elenco dei commenti effettuati sulla ricetta */
	private List<Voto> voti = new LinkedList<Voto>(); /* elenco dei voti espressi sulla ricetta */
	
	private Utente utente; /* utente proprietario della ricetta */
		
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

	public File getImmaginePrincipale() {
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

	public List<File> getImmaginiPreparazione() {
		return immaginiPreparazione;
	}

	public List<File> getVideoPreparazione() {
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

	public void setPathImmaginePrincipale(File immagine) {
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

	public void setImmaginiPreparazione(List<File> immaginiPreparazione) {
		this.immaginiPreparazione = immaginiPreparazione;
	}

	public void setVideoPreparazione(List<File> videoPreparazione) {
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
		
	////////////////////////////////////////////////////////////
	////////////////////////////////////////////////////////////
	////////////////////////////////////////////////////////////

	public boolean aggiungiImmaginePreparazione(File immagine) {
		return immaginiPreparazione.add(immagine);
	}
	
	public boolean rimuoviImmaginePrepazione(File immagine) {
		return immaginiPreparazione.remove(immagine);
	}
	
	public boolean aggiungiVideoPreparazione(File video) {
		return videoPreparazione.add(video);
	}
	
	public boolean rimuoviVideoPrepazione(File video) {
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
	
	//////////////////////////////////
	//////////////////////////////////
	//////////////////////////////////
	
	public Double getVotoComplessivo() {
		Double votoComplessivo = new Double(0.0);
		for (Voto voto : voti) {
			votoComplessivo += voto.getValore();
		}
		votoComplessivo /= voti.size();
		return new BigDecimal(votoComplessivo).setScale(2, RoundingMode.HALF_UP).doubleValue(); /* arrotondamento double ad una cifra decimale */
	} 

}
