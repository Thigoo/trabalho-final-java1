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

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import agencia.ETipoAgencia;
import conta.Conta;
import conta.ContaCorrente;
import conta.ETipoConta;
import cliente.Cliente;
import conta.Conta;
import funcionario.Funcionario;
import funcionario.Gerente;
import pessoa.ETipoAcesso;
import pessoa.Pessoa;

public class App {

	public static void main(String[] args) {
		Gerente gerente = new Gerente("Fulano", "12345678910", "123", "fulano@email.com", "22442244",
				ETipoAcesso.GERENTE, ETipoAgencia.AGENCIA_BANCURSINHO_CENTRO);
		// Cliente c = new Cliente();
		//logar(gerente);
		logar(gerente);

	}


	
	public static void logar(Pessoa pessoa) {		
		
		Scanner leitor = new Scanner(System.in);
		int opcao;

		System.out.println("****************************************************");
		System.out.println("******** Bem vindo(a) ao banco Bancursinho *********");
		System.out.println("****************************************************");
		System.out.println("                   ▄▄      ▄▄▄▄                     ");
		System.out.println("                 ▐▀▀▄█▀▀▀▀▀▒▄▒▀▌                    ");
		System.out.println("                 ▐▒█▀▒▒▒▒▒▒▒▒▀█                     ");
		System.out.println("                  █▒▒▒▒▒▒▒▒▒▒▒▀▌                    ");
		System.out.println("                  ▌▒██▒▒▒▒██▒▒▒▐                    ");
		System.out.println("                  ▌▒▒▄▒██▒▄▄▒▒▒▐                    ");
		System.out.println("                 ▐▒▒▒▀▄█▀█▄▀▒▒▒▒█▄                  ");
		System.out.println("                 ▀█▄▒▒▐▐▄▌▌▒▒▄▐▄▐                   ");
		System.out.println("                ▄▀▒▒▄▒▒▀▀▀▒▒▒▒▀▒▀▄                  ");
		System.out.println("                █▒▀█▀▌▒▒▒▒▒▄▄▄▐▒▒▐                  ");
		System.out.println("                 ▀▄▄▌▌▒▒▒▒▐▒▒▒▀▒▒▐                  ");
		System.out.println("                     ▐▌▒▒▒▒▀▄▄▄▄▄▀                  ");
		System.out.println("                      ▐▄▒▒▒▒▒▒▒▒▐                   ");
		System.out.println("                      ▌▒▒▒▒▄▄▒▒▒▐                   ");
		System.out.println("****************************************************");

		String cpf, senha;

		System.out.println("Por favor, digite seu cpf:");
		cpf = leitor.nextLine();
		System.out.println("Digite sua senha: ");
		senha = leitor.nextLine();

		if (cpf.equals(pessoa.getCpf()) && senha.equals(pessoa.getSenha())) {



			System.out.println("\nLogin efetuado com sucesso!");
			imprimirMenuCliente();


		} else {

			System.out.println("Os dados não conferem, tente novamente.");
		}

	} 

	//		while (opcao >= 1 && opcao < 3) {
	//
	//			switch (opcao) {
	//
	//			case 1:
	//				
	//				Scanner leitor2 = new Scanner(System.in);
	//				System.out.println("Por favor, digite seu cpf:");
	//				cpf = leitor2.nextLine();
	//				System.out.println("Digite sua senha: ");
	//				senha = leitor2.nextLine();
	//
	//				if (cpf.equals(pessoa.getCpf()) && senha.equals(pessoa.getSenha())) {
	//					if(pessoa.getAcesso().equals(leitor))
	//					System.out.println("\nLogin efetuado com sucesso!");
	//					imprimirMenuCliente();
	//				} else {
	//					System.out.println("Os dados não conferem, tente novamente.");
	//				}
	//
	//				break;
	//
	//			case 2:

	//				System.out.println("\n********** Menu cliente **********\n");
	//				System.out.println("1 - Movimentações \n2 - Relatórios");
	//				opcao = leitor.nextInt();
	//				if (opcao == 1) {
	//					System.out.println("1 - Saque \n2 - Depósito \n3 - Transferência");
	//				}
	//
	//				s = leitor.nextLine();
	//				System.out.println("Confirme sua senha: ");
	//				senha = leitor.nextLine();
	//				if (s != senha) {
	//					System.out.println("As senhas não conferem, tente novamente.");
	//				} else {
	//					System.out.println("Conta criada com sucesso! Bem vindo(a) ao banco Bancursinho");
	//				}
	//				break;
	//			case 3:
	//				leitor.close();
	//				break;
	//
	//			default:
	//				System.out.println("Opção inválida!");
	//				break;
	//
	//			}
	//		}
	//		System.out.println("Obrigado por utilizar nosso sistema");
	//		
	//		leitor.close();
	//	}

	//	
	//		Scanner leitor2 = new Scanner(System.in);
	//		String cpf, senha;
	//		System.out.println("Por favor, digite seu cpf:");
	//		cpf = leitor2.nextLine();
	//		System.out.println("Digite sua senha: ");
	//		senha = leitor2.nextLine();
	//
	//		if (cpf.equals(pessoa.getCpf()) && senha.equals(pessoa.getSenha())) {
	//			System.out.println("\nLogin efetuado com sucesso!");
	//			imprimirMenuCliente();
	//		} else {
	//			System.out.println("Os dados não conferem, tente novamente.");
	//		}
	//	}
	//	
	public static void imprimirMenuCliente() {

		Conta cliente = new ContaCorrente("12345678910", "123", 2000, ETipoConta.CONTA_CORRENTE, ETipoAgencia.AGENCIA_BANCURSINHO_CENTRO);
		Conta cliente2 = new ContaCorrente("12345678910", "321", 5000, ETipoConta.CONTA_CORRENTE, ETipoAgencia.AGENCIA_BANCURSINHO_CENTRO);

		
		
		Scanner leitor = new Scanner(System.in);
		int opcaoMenu, opcaoMov;
		double valorSaque, valorDeposito, valorTransferencia;
		Conta conta;
		

		System.out.println("\n****************  Menu  *****************\n");
		System.out.println("1 - Movimentações na conta \n2 - Relatórios \n");
		System.out.print("Escolha: ");
		opcaoMenu = leitor.nextInt();

		switch (opcaoMenu) {

		case 1:

			System.out.println("1 - Saque \n2 - Depósito \n3 - Transferência");
			opcaoMov = leitor.nextInt();

			switch (opcaoMov) {

			case 1:
				
				System.out.println("Valor do saque: ");
				valorSaque = leitor.nextDouble();
				cliente.sacar(valorSaque);
				System.out.println(cliente.getSaldo());
				break;

			case 2:
				
				System.out.println("Valor depósito.");
				valorDeposito = leitor.nextDouble();
				cliente.depositar(valorDeposito);
				System.out.println(cliente.getSaldo());									
				break;

			case 3:
				
				System.out.println("Fazer transferência.");
				valorTransferencia = leitor.nextDouble();
				System.out.println("Conta destino");
				cliente.transferir(valorTransferencia, cliente2);
				System.out.println(cliente.getSaldo());
				System.out.println(cliente2.getSaldo());
				
			}

		default:
			break;

		case 2:

			System.out.println("1 - Saldo \n");

		}
		leitor.close();
	}

}
