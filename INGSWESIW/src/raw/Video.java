package raw;

public class Video extends File {
	
	public Video(String nome, String path) {
		super(nome, path);
	}
	
	@Override
	public String toString() {
		return "Video [nome = " + nome + ", path = " + path + "]";
	}

}
