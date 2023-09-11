package sistemaInterno;

import cliente.Cliente;

public class App {

	public static void main(String[] args) {
		
		// System.out.println(calcularRendimentoPoupanca(1000.0, 36500));
		
		Cliente c = new Cliente();
		c.getSeguroVida().contratarSeguroDeVida(100000.0);
		
		System.out.println(c.getSeguroVida().isActive());
		System.out.println(c.getSeguroVida().getValorContratado());
		System.out.println(c.getSeguroVida().getTributoSeguro());
		
	}
	
	public static Double calcularRendimentoPoupanca(Double valorDinheiro, Integer numDias) {
		Double taxaJurosDia = 0.00034;
		for (int i=0; i<numDias; i++) {
			valorDinheiro = valorDinheiro * (1 + taxaJurosDia);
		}
		return valorDinheiro;
	}

}
