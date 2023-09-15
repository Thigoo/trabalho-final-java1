package exception;

public class SaldoNegativo extends RuntimeException { // CRIA AUTOMATICAMENTE

	private static final long serialVersionUID = 1L; // TRATAMENTO DE ERRO SALDO NEGATIVO

	public SaldoNegativo(String message) {
		super(message);
	}
	
}
