package enums;

public enum TipoAgenciaEnum {
	AGENCIA_BANCURSINHO_CENTRO(13), 
	AGENCIA_BANCURSINHO_ITAIPAVA(14),
	AGENCIA_BANCURSINHO_QUITANDINHA(15),
	AGENCIA_BANCURSINHO_BINGEN(16);
	
	private final int idAgencia;
	
	private TipoAgenciaEnum(int idAgencia) {
		
		this.idAgencia = idAgencia;
	}

	public int getIdAgencia() {
		return idAgencia;
	}
	
	
}
