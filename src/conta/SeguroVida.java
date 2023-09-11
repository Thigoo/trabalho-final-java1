package conta;

public class SeguroVida {

	private boolean isActive = false;
	private Double valorContratado = 0.0;
	private Double tributoSeguro = 0.0;

	public SeguroVida() {
	}

	public void contratarSeguroDeVida(Double valorSegurado) {
		this.valorContratado = valorSegurado * 0.8;
		this.tributoSeguro = valorSegurado * 0.2;
		this.isActive = true;
	}

	public boolean isActive() {
		return isActive;
	}

	public Double getValorContratado() {
		return valorContratado;
	}

	public Double getTributoSeguro() {
		return tributoSeguro;
	}

}
