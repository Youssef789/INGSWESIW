package raw;

public class Ingrediente {
	
	private String ingredienteNome;
	private String ingredienteQuantita;
	
	public Ingrediente() { }
	
	public Ingrediente(String ingredienteNome, String ingredienteQuantita) {
		this.ingredienteNome = ingredienteNome;
		this.ingredienteQuantita = ingredienteQuantita;
	}

	public String getIngredienteNome() {
		return ingredienteNome;
	}
	
	public String getIngredienteQuantita() {
		return ingredienteQuantita;
	}
	
	public void setIngredienteNome(String ingredienteNome) {
		this.ingredienteNome = ingredienteNome;
	}
	
	public void setIngredienteQuantita(String ingredienteQuantita) {
		this.ingredienteQuantita = ingredienteQuantita;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((ingredienteNome == null) ? 0 : ingredienteNome.hashCode());
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
		if (ingredienteNome == null) {
			if (other.ingredienteNome != null)
				return false;
		} else if (!ingredienteNome.equals(other.ingredienteNome))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Ingrediente [ingredienteNome = " + ingredienteNome + ", ingredienteQuantita = " + ingredienteQuantita + "]";
	}
	
}
