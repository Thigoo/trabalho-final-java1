package util;

import java.text.DecimalFormat;

public class FormatadorCasasDecimais {

	public static String formatarCasasDecimais(Double num, int casasDecimais) {
		DecimalFormat df = new DecimalFormat("0");
        df.setMaximumFractionDigits(casasDecimais);
        return df.format(num);
	}
	
}
