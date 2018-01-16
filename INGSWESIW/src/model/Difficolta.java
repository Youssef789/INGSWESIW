package model;

public enum Difficolta {
	
	FACILE ("Facile"), 
	MEDIA ("Media"), 
	DIFFICILE ("Difficile");
	
	////////////////////////////
	////////////////////////////
	////////////////////////////
	
	private final String string;
	
    private Difficolta(String string) {
        this.string = string;
    }
    
    public boolean equals(String otherString) {
        return string.equals(otherString);
    }

    @Override
    public String toString() {
       return this.string;
    }

}
