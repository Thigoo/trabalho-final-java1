package exception;

public class SaldoNegativo extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public SaldoNegativo(String message) {
		super(message);
	}
	
}
