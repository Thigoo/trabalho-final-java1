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

	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}

	public Double getValorContratado() {
		return valorContratado;
	}

	public static void void setValorContratado(Double valorContratado) {
		this.valorContratado = valorContratado;
	}

	public Double getTributoSeguro() {
		return tributoSeguro;
	}

	public void setTributoSeguro(Double tributoSeguro) {
		this.tributoSeguro = tributoSeguro;
	}

	@Override
	public String toString() {
		return "SeguroVida [isActive = " + isActive + ", valorContratado = " + valorContratado + ", tributoSeguro = "
				+ tributoSeguro + "]";
	}
	
}
