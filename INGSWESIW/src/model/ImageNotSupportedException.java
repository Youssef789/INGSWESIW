package model;

public class ImageNotSupportedException extends IllegalArgumentException {

	private static final long serialVersionUID = 5809462148103220212L;
	
	public ImageNotSupportedException() {
		super();
	}
	
	public ImageNotSupportedException(String string) {
		super(string);
	}

}
