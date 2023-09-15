package conversorData;

import java.text.SimpleDateFormat;
import java.util.Date;

public class ConverteData {
	
	public static String converteDataParaDataHora(Date data) {
		SimpleDateFormat formatador = new SimpleDateFormat("dd/MM/YYYY HH:mm:ss");
		return formatador.format(data);
	}
	
	public static String converteDataParaRelatorio(Date data) {
		SimpleDateFormat formatador = new SimpleDateFormat("YYYY-MM-dd_HH-mm");
		return formatador.format(data);
	}
}
