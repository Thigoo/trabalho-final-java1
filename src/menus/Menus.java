package menus;

import java.util.Scanner;

import conta.Conta;
import pessoa.Pessoa;

public class Menus {

	private int opcao;
	private String cpf;
	private String senha;
	private double valorSaque;
	private double valorDeposito;
	private double valorTransferencia = 0.0;
	private Scanner leitor;
	private Conta conta;

	public Menus() {
		super();
	}

	public Menus(Conta conta, Scanner leitor) {
		super();
		this.conta = conta;
		this.leitor = leitor;
	}

	public void logar(Pessoa pessoa) {

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
		System.out.println("****************************************************\n");

		System.out.println("******************* ACESSO À CONTA *****************\n");
		System.out.print("Por favor, digite seu cpf: ");
		this.cpf = this.leitor.nextLine();

		System.out.print("Digite sua senha: ");
		this.senha = this.leitor.nextLine();

		if (this.cpf.equals(pessoa.getCpf()) && this.senha.equals(pessoa.getSenha())) {

			System.out.println("\nLogin efetuado com sucesso!\n");
			imprimirMenuCliente();

		} else {

			System.out.println("Acesso negado!\n");
		}
	}

	public void imprimirMenuCliente() {

		System.out.println("************************ MENU **********************\n");
		System.out.println("[1] - Movimentações na conta");
		System.out.println("[2] - Relatórios");
		System.out.println("[3] - Sair");
		
		System.out.print("Resposta: ");
		this.opcao = this.leitor.nextInt();
		
		do {
			switch (this.opcao) {
	
				case 1: // Movimentações na conta
					movConta(conta);
					break;
	
				case 2: // Relatórios
					System.out.println("\n******************* RELATÓRIOS *********************");
					System.out.println("\n[1] - Mostrar saldo");
					System.out.println("[2] - Relatório de tributação da conta corrente");
					System.out.println("[3] - Relatório de rendimento da poupança");
					System.out.println("[4] - Contratar seguro de vida");
					System.out.println("[5] - Sair");
					System.out.print("Resposta: ");
					this.opcao = this.leitor.nextInt();
					
// PRECISAMOS DE UM DO WHILE PARA REPETIR ESSA PARTE DO MENU
						switch (this.opcao) { 
							case 1: // Mostrar saldo
								System.out.println("\n*********************** SALDO **********************\n");
								System.out.println("Saldo atual: R$" + conta.getSaldo());
								break;
			
							case 2: // Relatório de tributação da conta corrente
								System.out.println("\n*********** TRIBUTAÇÃO DA CONTA CORRENTE ***********\n");
								System.out.println("Total gastos: " + conta.obterTotalGasto());
								break;
			
							case 3: // Relatório de rendimento da poupança
								// FALTA FAZER
								System.out.println("\n*********** RENDIMENTO DA CONTA POUPANÇA ***********\n");
								System.out.println("Rendimento poupança");
								break;
								
							case 4: // Contratar seguro de vida
								// FALTA FAZER
								System.out.println("\n************* CONTRATAR SEGURO DE VIDA *************\n");
								System.out.println("Seguro de vida");
								break;
						}
					
				case 3: // Sair
					System.out.println("\nObrigado por utilizar o nosso sistema!");
					/*
					 * SE A PESSOA DIGITAR 3 NO SEGUNDO SWITCH O PROGRAMA ACABA!!!!
					 * ERRO!!!!
					 * CONSERTAR
					 * 
					 * */
					break;
			}
		} while(this.opcao != 3);

	}

	public void movConta(Conta conta) {
		
		do {
			System.out.println("\n\n************** MOVIMENTACOES NA CONTA ***************");
			System.out.println("\n[1] - Saque");
			System.out.println("[2] - Deposito");
			System.out.println("[3] - Transferência");
			System.out.println("[4] - Sair");
			System.out.print("Resposta: ");
			this.opcao = leitor.nextInt();
			
			switch (this.opcao) {

			case 1:
				System.out.print("\n************************* SAQUE ************************\n");
				System.out.print("VALOR DO SAQUE: R$");
				valorSaque = leitor.nextDouble();
				conta.sacar(valorSaque);
				System.out.print("Saldo efetuado com sucesso! \nSeu saldo é: R$" + conta.getSaldo());
				break;

			case 2:
				System.out.print("\n*********************** DEPOSITO ***********************\n");
				System.out.print("VALOR DO DEPOSITO: R$");
				valorDeposito = leitor.nextDouble();
				conta.depositar(valorDeposito);
				System.out.print("Depósito efetuado com sucesso! \nSeu saldo é: R$" + conta.getSaldo());
				break;

			case 3:
				System.out.print("\n********************* TRANSFERÊNCIA ********************\n");
				// Faltando conclusãO
				System.out.print("VALOR DA TRANSFERÊNCIA: R$");
				valorTransferencia = leitor.nextDouble();
				System.out.print("Insira o cpf da conta destino: ");
				break;

			default:
				System.out.println("Opção inválida!");
				break;
			}
		} while (this.opcao != 4);
	}
}
