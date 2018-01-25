package model;

import java.util.HashSet;
import java.util.Set;

import raw.Immagine;

public class Utente {
	
	private String username;
	private String email;
	private String password;
	private Immagine immagineProfilo;
	
	private Set<Ricetta> ricettePubblicate = new HashSet<Ricetta>();
	private Set<Ricetta> ricettePreferite = new HashSet<Ricetta>();
	 
	private Set<Commento> commentiPubblicati = new HashSet<Commento>();

	private Set<Voto> votiEspressi = new HashSet<Voto>();

	private Set<Utente> followings = new HashSet<Utente>();
	private Set<Utente> followers = new HashSet<Utente>();
	
	/* Da implementare: notifiche ricevute */
	/* Da implementare: segnalazioni effettuate */
	
	public Utente() { }
	
	public String getUsername() {
		return username;
	}

	public String getEmail() {
		return email;
	}
	
	public String getPassword() {
		return password;
	}
	
	public Immagine getImmagineProfilo() {
		return immagineProfilo;
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
	
	public void setPassword(String password) {
		this.password = password;
	}
	
	public void setImmagineProfilo(Immagine immagine) {
		this.immagineProfilo = immagine;
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
		return "Utente [username = " + username + ", email = " + email + ", password = " + password + ", immagineProfilo = " + immagineProfilo.getPath() + "]";
	}
	
	///////////////////////////////////////////////////////////
	///////////////////////////////////////////////////////////
	///////////////////////////////////////////////////////////
	
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
	
	public boolean aggiungiFollowing(Utente following) {
		return followings.add(following);
	}
	
	public boolean rimuoviFollowing(Utente following) {
		return followings.remove(following);
	}
	
	public boolean aggiungiFollower(Utente follower) {
		return followers.add(follower);
	}
	
	public boolean rimuoviFollower(Utente follower) {
		return followers.remove(follower);
	}

}
