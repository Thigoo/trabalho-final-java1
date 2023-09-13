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

import conta.Conta;
import conta.SeguroVida;
import enums.TipoAcessoEnum;
import enums.TipoAgenciaEnum;
import enums.TipoContaEnum;
import menus.Menus;
import pessoa.Cliente;
import pessoa.Pessoa;

public class App {

	public static void main(String[] args) {

		Scanner leitor = new Scanner(System.in);

		// ler o arquivo aqui
		//String nome, String cpf, String email, String telefone, TipoAcessoEnum acesso,
		//TipoAgenciaEnum idAgencia, SeguroVida seguroVida
		Pessoa pessoa = new Cliente("fulano", "1", "@email", "22442244", TipoAcessoEnum.CLIENTE, TipoAgenciaEnum.AGENCIA_BANCURSINHO_BINGEN);
		
		

		System.out.println("Li o arquivo aqui!");

		Menus menu = new Menus(conta, leitor);
		menu.logar(conta2);

		// escrever o arquivo aqui
		System.out.println("Escrevi o arquivo aqui!");

		leitor.close();
		
		
	}

}
