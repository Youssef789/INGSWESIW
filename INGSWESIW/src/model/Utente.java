package model;

import java.util.LinkedHashSet;
import java.util.Set;

public class Utente {
	
	private String username; /* username dell'utente */
	private String email; /* email dell'utente */
	private String immagineProfilo; /* immagine profilo dell'utente */
	
	private Boolean admin; /* permessi di admin (true o false) */
	
	private Set<Ricetta> ricetteInBozza = new LinkedHashSet<Ricetta>(); /* elenco delle ricette in bozza dell'utente */
	private Set<Ricetta> ricettePubblicate = new LinkedHashSet<Ricetta>(); /* elenco delle ricette pubblicate dall'utente */
	private Set<Ricetta> ricettePreferite = new LinkedHashSet<Ricetta>(); /* elenco delle ricette preferite dall'utente */
		  
	private Set<Commento> commentiPubblicati = new LinkedHashSet<Commento>(); /* elenco dei commenti pubblicati dall'utente */
	private Set<Voto> votiEspressi = new LinkedHashSet<Voto>(); /* elenco dei voti espressi dall'utente */
	
	private Set<Utente> followings = new LinkedHashSet<Utente>(); /* elenco dei followings dell'utente (chi seguono l'utente) */
	private Set<Utente> followers = new LinkedHashSet<Utente>(); /* elenco dei followers dell'utente (chi segue l'utente) */
	
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

	public Boolean getAdmin() {
		return admin;
	}

	public Set<Ricetta> getRicetteInBozza() {
		return ricetteInBozza;
	}
	
	public Set<Ricetta> getRicettePubblicate() {
		return ricettePubblicate;
	}
	
	public Set<Ricetta> getRicettePreferite() {
		return ricettePreferite;
	}
	
	public Set<Commento> getCommentiPubblicati() {
		return commentiPubblicati;
	}

	public Set<Voto> getVotiEspressi() {
		return votiEspressi;
	}
	
	public Set<Utente> getFollowings() {
		return followings;
	}

	public Set<Utente> getFollowers() {
		return followers;
	}

	public void setUsername(String username) {
		this.username = username;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	public void setImmagineProfilo(String immagineProfilo) {
		this.immagineProfilo = immagineProfilo;
	}
	
	public void setAdmin(Boolean bool) {
		this.admin = bool;
	}

	public void setRicetteInBozza(Set<Ricetta> ricetteInBozza) {
		this.ricetteInBozza = ricetteInBozza;
	}

	public void setRicettePubblicate(Set<Ricetta> ricettePubblicate) {
		this.ricettePubblicate = ricettePubblicate;
	}

	public void setRicettePreferite(Set<Ricetta> ricettePreferite) {
		this.ricettePreferite = ricettePreferite;
	}

	public void setCommentiPubblicati(Set<Commento> commentiPubblicati) {
		this.commentiPubblicati = commentiPubblicati;
	}

	public void setVotiEspressi(Set<Voto> votiEspressi) {
		this.votiEspressi = votiEspressi;
	}
	
	public void setFollowings(Set<Utente> followings) {
		this.followings = followings;
	}

	public void setFollowers(Set<Utente> followers) {
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
		return "Utente [username = " + username + ", email = " + email + ", immagineProfilo = " + immagineProfilo + ", admin = " + admin + "]";
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
