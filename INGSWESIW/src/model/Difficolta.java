package model;

public enum Difficolta { /* Difficoltà della ricetta */
	
	FACILE, 
	MEDIA, 
	DIFFICILE;
	
	///////////////////////////////////
	///////////////////////////////////
	///////////////////////////////////
	
	public String toStringFormatted() { // (es.) DIFFICILE ---> Difficile
		String stringFormatted = super.toString();
		stringFormatted = stringFormatted.substring(0, 1).toUpperCase() + stringFormatted.substring(1).toLowerCase();
		stringFormatted = stringFormatted.replace('_', ' ');
		return stringFormatted;
	}
	
}
