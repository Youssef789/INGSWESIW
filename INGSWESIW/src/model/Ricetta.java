package model;

import java.io.File;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.sql.Timestamp;
import java.util.LinkedHashSet;
import java.util.Set;

public class Ricetta { 
	
	private static final String[] imageFileExtensionsAccepted = { "png", "jpg", "jpeg" }; /* estensioni immagini accettati */
	private static final String[] videoFileExtensionsAccepted = { "avi", "mp4" }; /* estensioni video accettati */
	
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
	private Set<File> immaginiPreparazione = new LinkedHashSet<File>(); /* immagini a supporto alla spiegazione sulla preparazione della ricetta */
	private Set<File> videoPreparazione = new LinkedHashSet<File>(); /* video a supporto alla spiegazione sulla preparazione della ricetta */
	
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
	
	public String getTempoPreparazione() {
		return tempoPreparazione;
	}

	public File getImmaginePrincipale() {
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

	public Set<File> getImmaginiPreparazione() {
		return immaginiPreparazione;
	}

	public Set<File> getVideoPreparazione() {
		return videoPreparazione;
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
	
	public void setTempoPreparazione(String tempoPreparazione) {
		this.tempoPreparazione = tempoPreparazione;
	}

	public void setImmaginePrincipale(File immagine) {
		String fileExtension = getFileExtension(immagine);
		System.out.println(fileExtension);
		for (int i = 0; i < imageFileExtensionsAccepted.length; i++) {
			fileExtension = fileExtension.toLowerCase();
			if (fileExtension.equals(imageFileExtensionsAccepted[i])) {
				this.immaginePrincipale = immagine;
				return;
			}
		}
		throw new ImageNotSupportedException();
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

	public void setImmaginiPreparazione(Set<File> immaginiPreparazione) {
		this.immaginiPreparazione = immaginiPreparazione;
	}

	public void setVideoPreparazione(Set<File> videoPreparazione) {
		this.videoPreparazione = videoPreparazione;
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
		return "Ricetta [id = " + id + ", titolo = " + titolo + ", categoria = " + categoria.toString() + ", difficolta = " + difficolta.toString() + ", username.id = " + utente.getUsername() + "]";
	}
		
	////////////////////////////////////////////////////////////
	////////////////////////////////////////////////////////////
	////////////////////////////////////////////////////////////

	public boolean aggiungiImmaginePreparazione(File immagine) {
		String fileExtension = getFileExtension(immagine);
		for (int i = 0; i < imageFileExtensionsAccepted.length; i++) {
			fileExtension = fileExtension.toLowerCase();
			if (fileExtension.equals(imageFileExtensionsAccepted[i])) {
				return immaginiPreparazione.add(immagine);
			}
		}
		throw new ImageNotSupportedException("Formato immagine non supportato!");
	}
	
	public boolean rimuoviImmaginePrepazione(File immagine) {
		return immaginiPreparazione.remove(immagine);
	}
	
	public boolean aggiungiVideoPreparazione(File video) {
		String fileExtension = getFileExtension(video);
		for (int i = 0; i < videoFileExtensionsAccepted.length; i++) {
			fileExtension = fileExtension.toLowerCase();
			if (fileExtension.equals(videoFileExtensionsAccepted[i])) {
				return immaginiPreparazione.add(video);
			}
		}
		throw new VideoNotSupportedException("Formato video non supportato!");
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
	
	///////////////////////////////////////////////////
	///////////////////////////////////////////////////
	///////////////////////////////////////////////////
	
    private static String getFileExtension(File file) {
        String fileName = file.getName();
        if (fileName.lastIndexOf(".") != -1 && fileName.lastIndexOf(".") != 0)
        	return fileName.substring(fileName.lastIndexOf(".") + 1);
        else return "";
    }

}
