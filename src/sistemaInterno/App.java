//package sistemaInterno;
//
//import cliente.Cliente;
//
//public class App {
//
//	public static void main(String[] args) {
//		
////		// System.out.println(calcularRendimentoPoupanca(1000.0, 36500));
////		
////		Cliente c = new Cliente();
////		c.getSeguroVida().contratarSeguroDeVida(100000.0);
////		
////		System.out.println(c.getSeguroVida().isActive());
////		System.out.println(c.getSeguroVida().getValorContratado());
////		System.out.println(c.getSeguroVida().getTributoSeguro());
////		
//	}
//	
////	public static Double calcularRendimentoPoupanca(Double valorDinheiro, Integer numDias) {
////		Double taxaJurosDia = 0.00034;
////		for (int i=0; i<numDias; i++) {
////			valorDinheiro = valorDinheiro * (1 + taxaJurosDia);
////		}
////		return valorDinheiro;
////	}

package sistemaInterno;

import java.util.Scanner;

import agencia.Menus;
import conta.Conta;
import conta.ContaCorrente;
import enums.TipoAcessoEnum;
import enums.TipoAgenciaEnum;
import enums.TipoContaEnum;
import pessoa.Gerente;

public class App {

	public static void main(String[] args) {
		
		Scanner leitor = new Scanner(System.in);
		
		//ler o arquivo aqui		
		Gerente gerente = new Gerente("Fulano", "12345678910", "123", "fulano@email.com", "22442244",
				TipoAcessoEnum.GERENTE, TipoAgenciaEnum.AGENCIA_BANCURSINHO_CENTRO);

		Conta conta = new ContaCorrente("12345678910", "123", 2000, TipoContaEnum.CONTA_CORRENTE,
				TipoAgenciaEnum.AGENCIA_BANCURSINHO_CENTRO);
		Conta conta2 = new ContaCorrente("12345678910", "321", 5000, TipoContaEnum.CONTA_CORRENTE,
				TipoAgenciaEnum.AGENCIA_BANCURSINHO_CENTRO);
		
		System.out.println("Li o arquivo aqui!");
		
		Menus menu = new Menus(conta, leitor);
		menu.logar(gerente);
		
		//escrever o arquivo aqui
		System.out.println("Escrevi o arquivo aqui!");
		
		leitor.close();
	}
	
}
