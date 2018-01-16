package raw;

public class Immagine extends File {
	
	public Immagine(String nome, String path) {
		super(nome, path);
	}
	
	@Override
	public String toString() {
		return "Immagine [nome = " + nome + ", path = " + path + "]";
	}

}
