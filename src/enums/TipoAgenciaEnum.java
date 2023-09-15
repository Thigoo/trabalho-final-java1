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
	
	public static TipoAgenciaEnum fromValue(int value) {
		TipoAgenciaEnum tipoAgenciaEnum;
		switch (value) {
		case 13:
			tipoAgenciaEnum = TipoAgenciaEnum.AGENCIA_BANCURSINHO_CENTRO;
			break;
		case 14:
			tipoAgenciaEnum = TipoAgenciaEnum.AGENCIA_BANCURSINHO_ITAIPAVA;
			break;
		case 15:
			tipoAgenciaEnum = TipoAgenciaEnum.AGENCIA_BANCURSINHO_QUITANDINHA;
			break;
		case 16:
			tipoAgenciaEnum = TipoAgenciaEnum.AGENCIA_BANCURSINHO_BINGEN;
			break;
		default:
			tipoAgenciaEnum = null;
			break;
		}
		return tipoAgenciaEnum;
	}
}
