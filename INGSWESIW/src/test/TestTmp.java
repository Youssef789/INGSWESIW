package test;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DecimalFormat;

import model.Categoria;

public class TestTmp {
	
	public static void main(String[] args) {
		
		Categoria categoria = Categoria.PRIMI_PIATTI;
		
		System.out.println(categoria.toStringFormatted());
		
		Double d = new Double(356455);
		
		d = d / 52;
	
		
		// d = new BigDecimal(d).setScale(2, RoundingMode.HALF_UP).doubleValue();
		
		
		System.out.println(d);
				

		
	}

}
