package model;

public class Voto {
	
	private static final int MIN_VOTO = 1;
	private static final int MAX_VOTO = 5;
	
	private Long id;
	private int valore;
	
	private Ricetta ricetta;
	private Utente utente;
	
	public Voto() { }
	
	public Voto(Long id, int valore, Ricetta ricetta, Utente utente) {
		this.id = id;
		this.valore = valore;
		this.ricetta = ricetta;
		this.utente = utente;
		checkValore();
	}

	public Long getId() {
		return id;
	}
	
	public int getValore() {
		return valore;
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
	
	public void setValore(int valore) {
		this.valore = valore;
		checkValore();
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
		Voto other = (Voto) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
	@Override
	public String toString() {
		return "Voto [id = " + id + ", valore = " + valore + ", ricetta.id = " + ricetta.getId() + ", utente.username = " + utente.getUsername() + "]";
	}
	
	//////////////////////////
	//////////////////////////
	//////////////////////////
	
	private void checkValore() {
		if ( (valore < MIN_VOTO) || (valore > MAX_VOTO) ) {
			throw new IllegalArgumentException("Valore del voto non valido!");
		}
	}
	
}
