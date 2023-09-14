package ConversorData;

import java.text.SimpleDateFormat;
import java.util.Date;

public class ConverteData {
	
	public static String converteDataParaDataHora(Date data) {
		
		SimpleDateFormat formatador = new SimpleDateFormat("dd/MM/YYYY HH:mm:ss");
		return formatador.format(data);
	}
}
