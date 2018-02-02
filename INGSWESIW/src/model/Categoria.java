package model;

public enum Categoria { /* Categoria della ricetta */
		
	ANTIPASTI,      /* (es.) Sformatino di broccoli e salsiccia */
	PRIMI_PIATTI,   /* (es.) Spaghetti alla carbonara */
	SECONDI_PIATTI, /* (es.) Scaloppine al limone */
	PIATTI_UNICI,   /* (es.) Polenta con salsiccia e formaggio */
	CONTORNI,       /* (es.) Insalata di arance */
	DOLCI,          /* (es.) Tortino di cioccolato con cuore fondente */
	
	LIEVITATI,             /* (es.) Focaccia */
	SALSE_E_SUGHI,         /* (es.) Maionese */
	MARMELLATE_E_CONSERVE, /* (es.) Marmellata di limoni */
	BEVANDE,               /* (es.) Limoncello */
	
	ALTRO; /* Varie ed eventuali */
	
	///////////////////////////////////
	///////////////////////////////////
	///////////////////////////////////
	
	public String toStringFormatted() {
		String stringFormatted = super.toString();
		stringFormatted = stringFormatted.substring(0, 1).toUpperCase() + stringFormatted.substring(1).toLowerCase();
		stringFormatted = stringFormatted.replace('_', ' ');
		return stringFormatted;
	}
		
}
