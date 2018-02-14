package raw;

import model.Ricetta;

public class Ingrediente {
	
	private String nome;
	private String quantita;
	
	private Ricetta ricetta;
	
	public Ingrediente() { }

	public String getNome() {
		return nome;
	}

	public String getQuantita() {
		return quantita;
	}

	public Ricetta getRicetta() {
		return ricetta;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public void setQuantita(String quantita) {
		this.quantita = quantita;
	}

	public void setRicetta(Ricetta ricetta) {
		this.ricetta = ricetta;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
		result = prime * result + ((ricetta == null) ? 0 : ricetta.hashCode());
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
		Ingrediente other = (Ingrediente) obj;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		if (ricetta == null) {
			if (other.ricetta != null)
				return false;
		} else if (!ricetta.equals(other.ricetta))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Ingrediente [nome = " + nome + ", quantita = " + quantita + ", ricetta = " + ricetta.getId() + "]";
	}
	
}
