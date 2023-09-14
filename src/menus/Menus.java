package menus;

import java.io.IOException;
import java.util.Scanner;

import conta.Conta;
import conta.ContaPoupanca;
import conta.SeguroVida;
import enums.TipoAcessoEnum;
import io.InputOutput;
import pessoa.Pessoa;

public class Menus {

	// ATRUBUTOS
	private int opcao;
	private String cpf;
	private String senha;
	private double valorSaque;
	private double valorDeposito;
	private double valorTransferencia = 0.0;
	private Scanner leitor;
	private Conta conta;
	private ContaPoupanca cp;
	private SeguroVida sg;
	private InputOutput io;
	private Pessoa pessoa;
	Double valorContratado = 0.0;

	// CONSTRUTOR
	public Menus() {
		super();
	}

//	public Menus(Conta conta, Scanner leitor) {
//		super();
//		this.conta = conta;
//		this.leitor = leitor;
//	}

	// MENU LOGAR - APARECE PARA TODAS AS PESSOAS CADASTRADAS
	public void logar() {

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

			// CONFERE SE O CPF E SENHA ESTÃO CERTOS
			if (this.cpf.equals(pessoa.getCpf()) && this.senha.equals(pessoa.getSenha())) {
				
				System.out.println("\nLogin efetuado com sucesso!\n");
				imprimirMenuCliente();

// FALTA PROCURAR SE A PESSOA EXISTE NO NOSSO ARQUIVO E FAZER O IF COM O TIPO DE ACESSO DELA
					try {
						if (io.leitor().equals(TipoAcessoEnum.CLIENTE)) {
							imprimirMenuCliente();
						} else  if (io.leitor().equals(TipoAcessoEnum.GERENTE)) {
							imprimirMenuGerente();
						} else if (io.leitor().equals(TipoAcessoEnum.DIRETOR)) {
							imprimirMenuDiretor();
						} else if (io.leitor().equals(TipoAcessoEnum.PRESIDENTE)) {
							imprimirMenuPresidente();
						}
					} catch (Exception e) {
						System.out.println("Erro logar pessoa!" + e.getMessage());
					}
			} else {
				System.out.println("Acesso negado!\n");
			}

		} while (!this.cpf.equals(pessoa.getCpf()) || !this.senha.equals(pessoa.getSenha()));
	}

	// MENU QUE TODOS TEM ACESSO
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
					double valorInvest;
					int numDias;
					System.out.println("\n*********** RENDIMENTO DA CONTA POUPANÇA ***********\n");
					System.out.println("\n********************* SIMULAÇÃO ********************\n");
					System.out.println("Quanto você deseja investir? ");
					valorInvest = leitor.nextDouble();
					System.out.println("Por quanto tempo? (EM DIAS)");
					numDias = leitor.nextInt();
					cp.calcularRendimentoPoupanca(valorInvest, numDias);
					break;

				case 4: // Contratar seguro de vida
					double valorSeguro;
					System.out.println("\n************* CONTRATAR SEGURO DE VIDA *************\n");
					System.out.println("Qual valor você deseja assegurar?");
					valorSeguro = leitor.nextDouble();
					// Verificar função statica
					System.out.println(sg.toString());
					break;
				}

			case 3: // Sair
				System.out.println("\nObrigado por utilizar o nosso sistema!");
				// SE A PESSOA DIGITAR 3 NO SEGUNDO SWITCH O PROGRAMA ACABA!!!!
				// ERRO!!!!
				// CONSERTAR!!!!!!!!!!!!!!!!!!!!!!!!!!!!
				break;
			}
			
		} while (this.opcao != 3); // 3 PARA SAIR
	}

	// MENU QUE SOMENTE O CLIENTE TEM ACESSO
	public void imprimirMenuCliente() {

		System.out.print("******************* MENU   CLIENTE *******************");
		menuGeral();

		double valorSeguro;
		System.out.println("\n************* CONTRATAR SEGURO DE VIDA *************\n");
		System.out.println("Conheça nosso seguro de vida");
		System.out.println("Gostaria de contratar nosso seguro?");
		
		System.out.println("[1] - Sim \n[2] - Não");
		opcao = leitor.nextInt();
		
		// SE O CLIENTE DESEJAR EFETUAR O SEGURO DE VIDA
		if (opcao == 1) {
			System.out.println("Qual valor você deseja assegurar?");
			valorSeguro = leitor.nextDouble();
			// FALTA FAZER !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
		}
	}

	public void imprimirMenuGerente() {

		System.out.print("******************* MENU   GERENTE *******************");
		menuGeral();

		// aguardando arraylist e arquivo
	}

	public void imprimirMenuDiretor() {
		
		System.out.print("******************* MENU   DIRETOR *******************");
		menuGeral();
	}

	public void imprimirMenuPresidente() {
		System.out.print("******************* MENU PRESIDENTE *******************");
		menuGeral();
		
		/* FALTA FAZER DESAFIO PRESIDENTE
		 * public static void valorTotalArmazenadoNoBanco(List<Conta> listaContas) {//
		 * (List<Conta> = tipo de varial da lista, // nome da varial List = ListaContas
		 * double valorTotalArmazenada = 0.0; for (int i = 0; i < listaContas.size();
		 * i++) { valorTotalArmazenada = valorTotalArmazenada +
		 * listaContas.get(i).getSaldo();
		 * 
		 * System.out.println( i + 1 + "- CPF: " + listaContas.get(i).getCpf() +
		 * "Saldo: " + listaContas.get(i).getSaldo()); }
		 * System.out.println("Valor Total armazenado: "+ valorTotalArmazenada); }
		 */
	}

	// MOVIMENTAÇÕES QUE A CONTA PODE FAZER (SAQUE/DEPOSITO/TRANSFERENCIA)
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
				InputOutput.escritor();
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
				// FALTA PASSAR O DINHEIRO PARA A CONTA DE DESTINO
				// !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
				System.out.print("VALOR DA TRANSFERÊNCIA: R$");
				setValorTransferencia(leitor.nextDouble());
				
				System.out.print("Insira o cpf da conta destino: ");
				break;

			default:
				System.out.println("Opção inválida!");
				break;
			}
			
		} while (this.opcao != 4); // 4 PARA SAIR
	}

	// GETS E SETS
	public int getOpcao() {
		return opcao;
	}

	public void setOpcao(int opcao) {
		this.opcao = opcao;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public double getValorSaque() {
		return valorSaque;
	}

	public void setValorSaque(double valorSaque) {
		this.valorSaque = valorSaque;
	}

	public double getValorDeposito() {
		return valorDeposito;
	}

	public void setValorDeposito(double valorDeposito) {
		this.valorDeposito = valorDeposito;
	}

	public double getValorTransferencia() {
		return valorTransferencia;
	}

	public void setValorTransferencia(double valorTransferencia) {
		this.valorTransferencia = valorTransferencia;
	}

	public Scanner getLeitor() {
		return leitor;
	}

	public void setLeitor(Scanner leitor) {
		this.leitor = leitor;
	}

	public Conta getConta() {
		return conta;
	}

	public void setConta(Conta conta) {
		this.conta = conta;
	}

	public ContaPoupanca getCp() {
		return cp;
	}

	public void setCp(ContaPoupanca cp) {
		this.cp = cp;
	}

	public SeguroVida getSg() {
		return sg;
	}

	public void setSg(SeguroVida sg) {
		this.sg = sg;
	}

	public Double getValorContratado() {
		return valorContratado;
	}

	public void setValorContratado(Double valorContratado) {
		this.valorContratado = valorContratado;
	}
}
