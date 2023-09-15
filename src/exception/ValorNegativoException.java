package exception;

public class ValorNegativoException extends RuntimeException {

	private static final long serialVersionUID = 1L;
	
	// TRATAMENTO DE ERRO PERSONALIZADO
	
	public ValorNegativoException(String message) {
		super(message);
	}
	
}
