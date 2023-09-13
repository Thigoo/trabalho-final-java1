package agencia;

import java.util.Scanner;

import conta.Conta;
import conta.ContaCorrente;
import enums.TipoContaEnum;
import pessoa.Pessoa;

public class Menus {
	
	private int opcao;
	private String cpf;
	private String senha;
	private double valorSaque, valorDeposito, valorTransferencia;
	private Scanner leitor;
	private Conta conta;
	
	
	public Menus() {
		super();	}


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
		System.out.println("****************************************************");

		

		System.out.println("Por favor, digite seu cpf:");
		this.cpf = this.leitor.nextLine();
		System.out.println("Digite sua senha: ");
		this.senha = this.leitor.nextLine();

		if (this.cpf.equals(pessoa.getCpf()) && this.senha.equals(pessoa.getSenha())) {
			
			
			System.out.println("\nLogin efetuado com sucesso!");
			imprimirMenuCliente();

		} else {

			System.out.println("Os dados não conferem, tente novamente.");
		}

	}

	
	public void imprimirMenuCliente() {
	
		do {		
		System.out.println("\n****************  Menu  *****************\n");
		System.out.println("1 - Movimentações na conta \n2 - Relatórios \n3 - Sair");
		System.out.print("Escolha: ");
		this.opcao = this.leitor.nextInt();

		switch (this.opcao) {

		case 1:
				
			movConta(conta);
			
			break;
			
		case 2:
			
		

			System.out.println("1 - Mostrar saldo \n2 - Relatório de tributação da conta corrente \n"
					+ "3 - Relatório de rendimento da poupança \n4 - Contratar seguro de vida");
			this.opcao = this.leitor.nextInt();
			
			switch (this.opcao) {
			case 1:
				
				System.out.println("Saldo atual: " + conta.getSaldo());
				
				break;
				
			case 2:
//				I. O relatório de tributação deverá apresentar o total gasto nas operações até o momento do 
//					relatório.
//				II. Adicionalmente deverão ser informados os valores que o banco cobra por cada operação 
//					bancária;
//				III. Para cada saque será cobrado o valor de R$0.10 (dez centavos);
//				IV. Para cada depósito será cobrado o valor de R$0.10 (dez centavos);
//				V. Para cada transferência será cobrado o valor de R$0.20 (dez centavos) que deverá ser cobrado 
//					apenas do remetente;
				
				System.out.println("Total gastos: " + conta.obterTotalGasto());
				System.out.println("Valor taxa: " + conta.toString());
				
				break;
				
			default:
				break;
			}
			
			break;

		}
		}
		while(this.opcao != 3);
	}
	
	public void movConta(Conta conta) {

		do {

			System.out.println("1 - Saque \n2 - Depósito \n3 - Transferência \n4 - Sair");
		
			System.out.println("5 - Saque \n6 - Depósito \n7 - Transferência \n8 - Sair");
			this.opcao = leitor.nextInt();

			switch (this.opcao) {

			case 1:

				System.out.println("Valor do saque: ");
				valorSaque = leitor.nextDouble();
				conta.sacar(valorSaque);
				System.out.println(conta.getSaldo());

				break;

			case 2:

				System.out.println("Valor depósito.");
				valorDeposito = leitor.nextDouble();
				conta.depositar(valorDeposito);
				System.out.println(conta.getSaldo());
				break;

			case 3:
				// **********************************************
				// Faltando conclusão
				System.out.println("Fazer transferência.");
				valorTransferencia = leitor.nextDouble();
				System.out.println("Insira o cpf da conta destino");

				break;	
			

			default:
				System.out.println("Opção inválida!");

				break;

			}

		}
		while (this.opcao != 4);
	}
}
