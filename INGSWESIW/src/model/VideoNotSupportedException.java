package model;

public class VideoNotSupportedException extends IllegalArgumentException {

	private static final long serialVersionUID = -2387140864059595421L;
	
	public VideoNotSupportedException() {
		super();
	}
	
	public VideoNotSupportedException(String string) {
		super(string);
	}

}
