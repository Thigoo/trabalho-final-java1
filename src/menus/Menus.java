package menus;

import java.util.Scanner;

import conta.Conta;
import conta.ContaPoupanca;
import conta.SeguroVida;
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
	Double valorContratado = 0.0; // VALOR DO SEGURO CLIENTE

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
		
		do {
			System.out.println("******************* ACESSO À CONTA *****************\n");
			System.out.print("Por favor, digite seu cpf: ");
			this.cpf = this.leitor.nextLine();

			System.out.print("Digite sua senha: ");
			this.senha = this.leitor.nextLine();

			if (this.cpf.equals(pessoa.getCpf()) && this.senha.equals(pessoa.getSenha())) {

				System.out.println("\nLogin efetuado com sucesso!\n");
				imprimirMenuCliente();
				
				// tipos de acesso
//					if (pessoa == cliente) {
//						imprimirMenuCliente();
//					} else  if (pessoa == gerente) {
//						imprimirMenuGerente();
//					} else if (pessoa == diretor) {
//						imprimirMenuDiretor();
//					} else {
//						imprimirMenuPresidente();
//					}
				

			} else {

				System.out.println("Acesso negado!\n");
			}
			
			
		} while(!this.cpf.equals(pessoa.getCpf()) || !this.senha.equals(pessoa.getSenha()));		
		
	}

	public void menuGeral() {

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
								System.out.println("Taxa de saque: R$" + conta.getTAXA_SAQUE());
								System.out.println("Taxa de depósito: R$" + conta.getTAXA_DEPOSITO());
								System.out.println("Taxa de transferência: R$" + conta.getTAXA_TRANSFERENCIA());
								break;
			
							case 3: // Relatório de rendimento da poupança
								// FALTA FAZER
								double valorInvest;
								int numDias;
								System.out.println("\n*********** RENDIMENTO DA CONTA POUPANÇA ***********\n");
								System.out.println("\n********************* SIMULAÇÃO ********************\n");
								System.out.println("Quanto você deseja investir? ");
								valorInvest = leitor.nextDouble();
								System.out.println("Por quanto tempo? (EM DIAS)");
								numDias = leitor.nextInt();
								//Aguardando resolução no getCpf
								ContaPoupanca.calcularRendimentoPoupanca(valorInvest, numDias);
								break;
								
//							case 4: // Contratar seguro de vida
//								// FALTA FAZER
//								double valorSeguro;
//								System.out.println("\n************* CONTRATAR SEGURO DE VIDA *************\n");
//								System.out.println("Qual valor você deseja assegurar?");
//								valorSeguro = leitor.nextDouble();
//								//Verificar função statica 
//								System.out.println(SeguroVida.toString());
//								break;
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

	public void imprimirMenuCliente() {
		System.out.print("******************* MENU   CLIENTE *******************");
		menuGeral();
		// Contratar seguro de vida
		// FALTA FAZER
		double valorSeguro;
		System.out.println("\n************* CONTRATAR SEGURO DE VIDA *************\n");
		System.out.println("Conheça nosso seguro de vida");
		System.out.println("Gostaria de contratar nosso seguro?");
		System.out.println("[1] - Sim \n[2] - Não");
		opcao = leitor.nextInt();
		if(opcao == 1) {
			System.out.println("Qual valor você deseja assegurar?");
			valorSeguro = leitor.nextDouble();
			//Verificar função statica 
			//System.out.println(SeguroVida.contratarSeguroDeVida(valorSeguro));
		} else {
			
			System.out.println("Obrigdo por utilizar nosso sistema!");		
			
		}
		
		
	}
	
	public void imprimirMenuGerente() {
		System.out.print("******************* MENU   GERENTE *******************");
		menuGeral();
		
		//aguardando arraylist e arquivo
		 
	}
	
	
	
	public void imprimirMenuDiretor() {
		System.out.print("******************* MENU   DIRETOR *******************");
		menuGeral();
	}
	
	/*
	 * */
	
	public void imprimirMenuPresidente() {
		System.out.print("******************* MENU PRESIDENTE *******************");
		menuGeral();
	}
	
	/*
	 * public static void valorTotalArmazenadoNoBanco(List<Conta> listaContas) {// (List<Conta> = tipo de varial da lista,
																				// nome da varial List = ListaContas
		double valorTotalArmazenada = 0.0;
		for (int i = 0; i < listaContas.size(); i++) {
			valorTotalArmazenada = valorTotalArmazenada + listaContas.get(i).getSaldo();

			System.out.println(
					i + 1 + "- CPF: " + listaContas.get(i).getCpf() + "Saldo: " + listaContas.get(i).getSaldo());
		}
		System.out.println("Valor Total armazenado: "+ valorTotalArmazenada);
	}
	 * */
	
	public void movConta(Conta conta) {
		
		do {
			System.out.println("\n************** MOVIMENTACOES NA CONTA ***************");
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
