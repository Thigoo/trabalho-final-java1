package conta;

public class SeguroVida {

	// ATRIBUTOS
	private boolean isActive = false;
	private Double valorContratado = 0.0;
	private Double tributoSeguro = 0.0;

	// CONTRUTOR
	public SeguroVida() {
	}

	// METODOS
	public boolean contratarSeguroDeVida(Double valorSegurado) {
		this.valorContratado = valorSegurado * 0.8; // VALOR Q VAI RETORNAR
		this.tributoSeguro = valorSegurado * 0.2; // VALOR DA TAXA
		this.isActive = true;
		return this.isActive;
	}

	// GETS E SETS
	public boolean isActive() {
		return isActive;
	}

	public void setActive(boolean isActive) { // SE A PESSOA QUER OU NAO
		this.isActive = isActive;
	}

	public Double getValorContratado() {
		return valorContratado;
	}

	public void setValorContratado(Double valorContratado) {
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
