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

public class App {

	
	public static void main(String[] args) {
		
		Scanner leitor = new Scanner(System.in);
		int opcao;
		long cpf;
		String senha, s;
		
		System.out.println("****************************************************");
		System.out.println("******** Bem vindo(a) ao banco Bancursinho *********");
		System.out.println("****************************************************");
		System.out.println();
		
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

		
		System.out.println("1 - Logar \n2 - Abertura de conta");
		System.out.print("Escolha: ");
		opcao = leitor.nextInt();
		
		switch (opcao) {
		
		case 1:
			System.out.println("Por favor, digite seu cpf: ");
			cpf = leitor.nextLong();
			System.out.println("Digite sua senha: ");
			senha = leitor.next();
			
			if(cpf != 0 && senha != "") {
				System.out.println("\nLogin efetuado com sucesso!");
			} else {
				System.out.println("Os dados não conferem, tente novamente.");
			}			
			imprimirMenu();
			
			break;
			
		case 2:
			
			System.out.println("Ok, preencha os dados para abrir sua conta.");
			System.out.println("Qual o seu cpf? ");
			cpf = leitor.nextLong();
			System.out.println("Crie uma senha: ");
			s = leitor.nextLine();
			System.out.println("Confirme sua senha: ");
			senha = leitor.nextLine();
			if(s != senha ) {
				System.out.println("As senhas não conferem, tente novamente.");
			} else {
				System.out.println("Conta criada com sucesso! Bem vindo(a) ao banco Bancursinho");
			}
			
			imprimirMenu();
			
		default: 
			break;
			
		}
		leitor.close();
	}
	
	public static void imprimirMenu() {
		
		Scanner leitor = new Scanner(System.in);
		int opcaoMenu, opcaoMov;
		
		System.out.println("\n****************  Menu  *****************\n");
		System.out.println("1 - Movimentações na conta \n2 - Relatórios \n");
		opcaoMenu = leitor.nextInt();
		
		switch (opcaoMenu) {		
		
		case 1:
			
			System.out.println("1 - Saque \n2 - Depósito \n 3 - Transferência para outra conta");
			opcaoMov = leitor.nextInt();
			
			switch (opcaoMov) {
			
			case 1:
				System.out.println("Fazer saldo.");
				break;
				
			case 2:
				System.out.println("Fazer depósito.");			
				break;
				
			case 3:
				System.out.println("Fazer transferência.");
			}			

			default:
				break;
			
		case 2:
			
			System.out.println("1 - Saldo \n");
			
		}
		leitor.close();
	}







































}
