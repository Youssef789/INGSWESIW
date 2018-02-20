package model;

import java.util.LinkedList;
import java.util.List;

public class Utente {
	
	private String username; /* username dell'utente */
	private String email; /* email dell'utente */
	private String immagineProfilo; /* immagine profilo dell'utente */
	
	private List<Ricetta> ricetteInBozza = new LinkedList<Ricetta>(); /* elenco delle ricette in bozza dell'utente */
	private List<Ricetta> ricettePubblicate = new LinkedList<Ricetta>(); /* elenco delle ricette pubblicate dall'utente  */
	private List<Ricetta> ricettePreferite = new LinkedList<Ricetta>(); /* elenco delle ricette preferite dall'utente  */
	  
	private List<Commento> commentiPubblicati = new LinkedList<Commento>(); /* elenco dei commenti pubblicati dall'utente */
	private List<Voto> votiEspressi = new LinkedList<Voto>(); /* elenco dei voti espressi dall'utente */

	private List<Utente> followings = new LinkedList<Utente>(); /* elenco dei followings dell'utente (chi seguono l'utente) */
	private List<Utente> followers = new LinkedList<Utente>(); /* elenco dei followers dell'utente (chi segue l'utente) */
	
	public Utente() { }
	
	public String getUsername() {
		return username;
	}

	public String getEmail() {
		return email;
	}
	
	public String getImmagineProfilo() {
		return immagineProfilo;
	}
	
	public List<Ricetta> getRicetteInBozza() {
		return ricetteInBozza;
	}
	
	public List<Ricetta> getRicettePubblicate() {
		return ricettePubblicate;
	}
	
	public List<Ricetta> getRicettePreferite() {
		return ricettePreferite;
	}
	
	public List<Commento> getCommentiPubblicati() {
		return commentiPubblicati;
	}

	public List<Voto> getVotiEspressi() {
		return votiEspressi;
	}
	
	public List<Utente> getFollowings() {
		return followings;
	}

	public List<Utente> getFollowers() {
		return followers;
	}
	
	public void setUsername(String username) {
		this.username = username;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	public void setImmagineProfilo(String pathImmagineProfilo) {
		this.immagineProfilo = pathImmagineProfilo;
	}
		
	public void setRicetteInBozza(List<Ricetta> ricetteInBozza) {
		this.ricetteInBozza = ricetteInBozza;
	}

	public void setRicettePubblicate(List<Ricetta> ricettePubblicate) {
		this.ricettePubblicate = ricettePubblicate;
	}

	public void setRicettePreferite(List<Ricetta> ricettePreferite) {
		this.ricettePreferite = ricettePreferite;
	}

	public void setCommentiPubblicati(List<Commento> commentiPubblicati) {
		this.commentiPubblicati = commentiPubblicati;
	}

	public void setVotiEspressi(List<Voto> votiEspressi) {
		this.votiEspressi = votiEspressi;
	}
	
	public void setFollowings(List<Utente> followings) {
		this.followings = followings;
	}

	public void setFollowers(List<Utente> followers) {
		this.followers = followers;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((username == null) ? 0 : username.hashCode());
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
		Utente other = (Utente) obj;
		if (username == null) {
			if (other.username != null)
				return false;
		} else if (!username.equals(other.username))
			return false;
		return true;
	}
	
	@Override
	public String toString() {
		return "Utente [username = " + username + ", email = " + email + ", immagineProfilo = " + immagineProfilo + "]";
	}
	
	////////////////////////////////////////////////////////
	////////////////////////////////////////////////////////
	////////////////////////////////////////////////////////
	
	public boolean aggiungiRicettaInBozza(Ricetta ricetta) {
		return ricetteInBozza.add(ricetta);
	}
	
	public boolean rimuoviRicettaInBozza(Ricetta ricetta) {
		return ricetteInBozza.remove(ricetta);
	}
	
	public boolean aggiungiRicettaPubblicata(Ricetta ricetta) {
		return ricettePubblicate.add(ricetta);
	}
	
	public boolean rimuoviRicettaPubblicata(Ricetta ricetta) {
		return ricettePubblicate.remove(ricetta);
	}
	
	public boolean aggiungiRicettaPreferita(Ricetta ricetta) {
		return ricettePreferite.add(ricetta);
	}
	
	public boolean rimuoviRicettaPreferita(Ricetta ricetta) {
		return ricettePreferite.remove(ricetta);
	}
	
	public boolean aggiungiCommentoPubblicato(Commento commento) {
		return commentiPubblicati.add(commento);
	}
	
	public boolean rimuoviCommentoPubblicato(Commento commento) {
		return commentiPubblicati.remove(commento);
	}
	
	public boolean aggiungiVotoEspresso(Voto voto) {
		return votiEspressi.add(voto);
	}
	
	public boolean rimuoviVotoEspresso(Voto voto) {
		return votiEspressi.remove(voto);
	}
	
	public boolean aggiungiFollowing(Utente utente) {
		return followings.add(utente);
	}
	
	public boolean rimuoviFollowing(Utente utente) {
		return followings.remove(utente);
	}
	
	public boolean aggiungiFollower(Utente utente) {
		return followings.add(utente);
	}
	
	public boolean rimuoviFollower(Utente utente) {
		return followings.remove(utente);
	}
	
	//////////////////////////////////////
	//////////////////////////////////////
	//////////////////////////////////////
	
	public int getNumeroRicetteInBozza() {
		return ricetteInBozza.size();
	}
	
	public int getNumeroRicettePubblicate() {
		return ricettePubblicate.size();
	}
	
	public int getNumeroRicettePreferite() {
		return ricettePreferite.size();
	}
	
	public int getNumeroCommentiPubblicati() {
		return commentiPubblicati.size();
	}
	
	public int getNumeroVotiEspressi() {
		return votiEspressi.size();
	}
	
	public int getNumeroFollowings() {
		return followings.size();
	}
	
	public int getNumeroFollowers() {
		return followers.size();
	}

}
