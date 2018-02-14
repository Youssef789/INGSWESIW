package model;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.sql.Timestamp;
import java.util.LinkedHashSet;
import java.util.Set;

public class Ricetta { 
	
	private Long id; /* id della ricetta */
	private Timestamp dataPubblicazione; /* data di pubblicazione della ricetta (se la ricetta non è stata ancora pubblicata, ovvero è in bozza, sarà null, altrimenti gli viene assegnato nel jdbc quando la ricetta verrà pubblicata) */
	private Timestamp dataUltimaModifica; /* data di ultima modifica della ricetta (fino a quando la ricetta pubblicata non sarà modificata sarà null, altrimenti gli viene assegnato nel jdbc dopo che la ricetta viene modificata) */
	private String titolo; /* titolo della ricetta */
	private Categoria categoria; /* categoria della ricetta */
	private Difficolta difficolta; /* difficoltà della ricetta */
	private String tempo; /* tempo della ricetta */
	private String dosi; /* dosi della ricetta (es. 4 persone) */
	private String immaginePrincipale; /* immagine principale della ricetta */
	private String ingredienti; /* ingredienti e quantità della ricetta */
	private String descrizione; /* descrizione della ricetta */
	private String preparazione; /* preparazione della ricetta */
		
	private Set<Commento> commenti = new LinkedHashSet<Commento>(); /* elenco dei commenti effettuati sulla ricetta */
	private Set<Voto> voti = new LinkedHashSet<Voto>(); /* elenco dei voti espressi sulla ricetta */
	
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
	
	public String getTempo() {
		return tempo;
	}
	
	public String getDosi() {
		return dosi;
	}
	
	public String getImmaginePrincipale() {
		return immaginePrincipale;
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
	
	public Set<Commento> getCommenti() {
		return commenti;
	}

	public Set<Voto> getVoti() {
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
	
	public void setTempo(String tempo) {
		this.tempo = tempo;
	}
	
	public void setDosi(String dosi) {
		this.dosi = dosi;
	}
	
	public void setImmaginePrincipale(String immaginePrincipale) {
		this.immaginePrincipale = immaginePrincipale;
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

	public void setCommenti(Set<Commento> commenti) {
		this.commenti = commenti;
	}
	
	public void setVoti(Set<Voto> voti) {
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
		return "Ricetta [id = " + id + ", dataPubblicazione = " + dataPubblicazione + ", dataUltimaModifica = " + dataUltimaModifica + ", titolo = " + titolo + ", categoria = " + categoria + ", difficolta = " + difficolta + ", tempo = " + tempo + ", dosi = " + dosi + ", immaginePrincipale = " + immaginePrincipale + ", ingredienti = " + ingredienti + ", descrizione = " + descrizione + ", preparazione = " + preparazione + ", utente=" + utente.getUsername() + "]";
	}
		
	////////////////////////////////////////////////////
	////////////////////////////////////////////////////
	////////////////////////////////////////////////////

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
	
	////////////////////////////////////
	////////////////////////////////////
	////////////////////////////////////
	
	public Double getVotoComplessivo() {
		Double votoComplessivo = new Double(0.0);
		for (Voto voto : voti) {
			votoComplessivo += voto.getValore();
		}
		votoComplessivo /= voti.size();
		return new BigDecimal(votoComplessivo).setScale(2, RoundingMode.HALF_UP).doubleValue(); /* arrotondamento double ad una cifra decimale */
	}
	
	////////////////////////////////
	////////////////////////////////
	////////////////////////////////
	
	public int getNumeroCommenti() {
		return commenti.size();
	}
	
	public int getNumeroVoti() {
		return voti.size();
	}
	
}
