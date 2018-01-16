package model;

public enum Categoria {
		
	ANTIPASTI ("Antipasti"),           /* (es.) Sformatino di broccoli e salsiccia */
	PRIMI_PIATTI ("Primi piatti"),     /* (es.) Spaghetti alla carbonara */
	SECONDI_PIATTI ("Secondi piatti"), /* (es.) Scaloppine al limone */
	PIATTI_UNICI ("Piatti unici"),     /* (es.) Polenta con salsiccia e formaggio */
	CONTORNI ("Contorni"),             /* (es.) Insalata di arance */
	DOLCI ("Dolci"),                   /* (es.) Tortino di cioccolato con cuore fondente */
	
	LIEVITATI ("Lievitati"),                         /* (es.) Focaccia */
	SALSE_E_SUGHI ("Salse e sughi"),                 /* (es.) Maionese */
	MARMELLATE_E_CONSERVE ("Marmellate e conserve"), /* (es.) Marmellata di limoni */
	BEVANDE ("Bevande"),                             /* (es.) Limoncello */
	
	ALTRO ("Altro"); /* Varie ed eventuali */
	 
	////////////////////////////
	////////////////////////////
	////////////////////////////
	
	private final String string;
	
    private Categoria(String string) {
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
