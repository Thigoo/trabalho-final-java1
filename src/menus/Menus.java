package menus;

import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

import conta.Conta;
import enums.TipoAgenciaEnum;
import enums.TipoCargoEnum;
import exception.SaldoNegativo;
import exception.TaxaMinimaException;
import exception.ValorNegativoException;
import io.LeitorArquivo;
import pessoa.Cliente;
import pessoa.Gerente;
import pessoa.Pessoa;
import util.FormatadorCasasDecimais;
import util.GeradorRelatorio;

public class Menus {

	// ATRUBUTOS
	private Scanner leitor;
	private String cpfLogin;
	private String senhaLogin;
	private boolean usuarioLogado = false; // MUDA PRA TRUE QUANDO O USUARIO LOGA
	private List<Pessoa> pessoasList;
	private List<Conta> contasList;
	Pessoa pessoaLogada; // OBJETO PESSOA
	private Conta contaPessoaLogada; // PESSOA DEPOIS DE TER FEITO O LOGIN
	private String opcao;

	private double valorSaque = 0.0;
	private double valorDeposito = 0.0;
	private double valorTransferencia = 0.0;
	private String numeroContaTransferencia = "";

	// CONSTRUTOR
	public Menus(Scanner leitor, List<Pessoa> pessoas, List<Conta> contas) {
		this.leitor = leitor; // LER O ARQUIVO DE PESSOAS
		this.pessoasList = pessoas; // LOGIN COM OS DADOS DE PESSOA + CONTA
		this.contasList = contas;
	}

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

		System.out.println("******************* ACESSO À CONTA *****************\n");

		while (!usuarioLogado) { // ENQUANTO NÃO TIVER UM USUARIO LOGADO

			System.out.print("Por favor, digite seu CPF: ");
			this.cpfLogin = leitor.next();

			System.out.print("Digite sua Senha: ");
			this.senhaLogin = leitor.next();

			// Varrendo a minha lista de pessoas para achar quem tem o CPF e senha iguais
			// para realizar o login

			for (int i = 0; i < this.pessoasList.size(); i++) { // VARRE A LISTA PROCURANDO O CPF CORRETO

				if (this.pessoasList.get(i).getCpf().equals(this.cpfLogin)
						&& this.pessoasList.get(i).getSenha().equals(this.senhaLogin)) { // COMPARA SE O CPF E SENHA
																							// ESTAO CORRETOS

					this.pessoaLogada = this.pessoasList.get(i);
					this.usuarioLogado = true; // USUARIO LOGADO = TRUE
				}
			}

			if (!this.usuarioLogado) {

				System.out.println("CPF ou Senha invalido(s)"); // SE OS DADOS NAO BATEREM
			}
		}

		carregarContasUsuarioLogado(); // ENCONTRA A CONTA APARTIR DO CPF CORRETO

		carregarMenu(); // CARREGA O MENU DA PESSOA CORRETA
	}

	private void carregarMenu() {

		switch (pessoaLogada.getTipoCargo()) { // QUAL MENU É CARREGADO APARTIR DO CARGO

		case CLIENTE:
			imprimirMenuCliente();
			break;

		case GERENTE:
			imprimirMenuGerente();
			break;

		case DIRETOR:
			imprimirMenuDiretor();
			break;

		case PRESIDENTE:
			imprimirMenuPresidente();
			break;

		default:
			break;
		}
	}

	private void carregarContasUsuarioLogado() { // PRA ACHAR A CONTA DO USUARIO LOGADO, VARRE UMA POR UMA

		for (int i = 0; i < contasList.size(); i++) {

			if (contasList.get(i).getCpf().equals(pessoaLogada.getCpf())) { // COMPARANDO PELO CPF

				this.contaPessoaLogada = contasList.get(i);
			}
		}
	}

	public void menuGeral() { // MENU QUE TODOS TEM ACESSO

		System.out.println("\n************************ MENU **********************\n");

		do {
			System.out.println("[1] - Movimentações na conta");
			System.out.println("[2] - Relatórios");

			if (TipoCargoEnum.CLIENTE.equals(pessoaLogada.getTipoCargo())) { // SE O CLIENTE ACEITAR O SEGURO DE VIDA

				System.out.println("[3] - Contratar Seguro de Vida");
			}

			System.out.println("[9] - Sair");

			System.out.print("Resposta: ");
			this.opcao = this.leitor.next();

			switch (this.opcao) {

			case "1": // Movimentações na conta
				movConta();
				break;

			case "2": // Relatórios
				relatoriosConta();
				break;

			case "3": // Movimentações na conta

				if (!TipoCargoEnum.CLIENTE.equals(pessoaLogada.getTipoCargo())) {

					System.out.println("Opção inválida!");
					break;
				}

				System.out.println("\n************* CONTRATAR SEGURO DE VIDA *************\n");
				System.out.println("Gostaria de contratar nosso seguro?");
				System.out.println("\n[1] - Sim \n[2] - Não");
				opcao = leitor.next();

				// SE O CLIENTE DESEJAR EFETUAR O SEGURO DE VIDA
				if (opcao.equals("1")) {

					if (((Cliente) (pessoaLogada)).getSeguroVida().isActive()) {
						System.out.println("\nVocê já possui um Seguro de Vida Contratado");

					} else {

						System.out.println("\nQual valor você deseja assegurar?");
						Double valorSeguro = leitor.nextDouble();
						((Cliente) (pessoaLogada)).getSeguroVida().contratarSeguroDeVida(valorSeguro);
						System.out.println("Seguro de Vida Contratado com Sucesso.");
					}
				}

				break;

			case "9": // Sair
				System.out.println("\nObrigado por utilizar o nosso sistema!");
				break;

			default:
				System.out.println("Opção inválida!");
				break;
			}

		} while (!this.opcao.equals("9")); // 3 PARA SAIR

		if (this.opcao.equals("9")) { // PARA SAIR, DESLOGA A PESSOA

			this.pessoaLogada = null;
			this.contaPessoaLogada = null;
			this.usuarioLogado = false;
			logar();
		}
	}

	// MENU QUE SOMENTE O CLIENTE TEM ACESSO
	public void imprimirMenuCliente() {

		System.out.print("******************* MENU CLIENTE *******************");
		menuGeral();
	}

	public void imprimirMenuGerente() {

		System.out.print("******************* MENU GERENTE *******************");
		menuGeral();
		// aguardando arraylist e arquivo
	}

	public void imprimirMenuDiretor() {

		System.out.print("******************* MENU DIRETOR *******************");
		menuGeral();
	}

	public void imprimirMenuPresidente() {

		System.out.print("******************* MENU PRESIDENTE *******************");
		menuGeral();
	}

	// MOVIMENTAÇÕES QUE A CONTA PODE FAZER (SAQUE/DEPOSITO/TRANSFERENCIA)
	public void movConta() {

		do {
			System.out.println("\n************** MOVIMENTACOES NA CONTA ***************");
			System.out.println("\n[1] - Saque");
			System.out.println("[2] - Deposito");
			System.out.println("[3] - Transferência");
			System.out.println("[4] - Voltar");

			System.out.print("Resposta: ");
			this.opcao = leitor.next();

			switch (this.opcao) {

			case "1":
				System.out.print("\n************************* SAQUE ************************\n");
				System.out.print("VALOR DO SAQUE: R$");
				valorSaque = leitor.nextDouble();

				try {
					contaPessoaLogada.sacar(valorSaque, false); // FALSE PQ NAO É UMA TRANSFERENCIA
					System.out.print("Saldo efetuado com sucesso! \nSeu saldo é: R$"
							+ FormatadorCasasDecimais.formatarCasasDecimais(contaPessoaLogada.getSaldo(), 2));
					LeitorArquivo.salvarDados(pessoasList, contasList);

				} catch (ValorNegativoException vn) {

					System.out.println(vn.getMessage() + "\n");

				} catch (SaldoNegativo sn) {

					System.out.println(sn.getMessage() + "\n");

				} catch (Exception e) {

					System.out.println("Erro inesperado do sistema.");
				}

				break;

			case "2":

				System.out.print("\n*********************** DEPOSITO ***********************\n");
				System.out.print("VALOR DO DEPOSITO: R$");
				valorDeposito = leitor.nextDouble();

				try {

					contaPessoaLogada.depositar(valorDeposito, false); // FALSE PQ NAO É UMA TRANFERENCIA
					System.out.print("Depósito efetuado com sucesso! \nSeu saldo é: R$"
							+ FormatadorCasasDecimais.formatarCasasDecimais(contaPessoaLogada.getSaldo(), 2));
					LeitorArquivo.salvarDados(pessoasList, contasList);

				} catch (ValorNegativoException vn) { // ERRO VALOR NEGATIVO

					System.out.println(vn.getMessage() + "\n");

				} catch (TaxaMinimaException tm) { // ERRO TAXA MINIMA

					System.out.println(tm.getMessage() + "\n");

				} catch (Exception e) {

					System.out.println("Erro inesperado do sistema.");
				}

				break;

			case "3":
				System.out.print("\n********************* TRANSFERÊNCIA ********************\n");
				System.out.print("VALOR DA TRANSFERÊNCIA: R$");
				valorTransferencia = leitor.nextDouble();

				boolean contaEncontrada = false; // SE ELE ACHAR A CONTA VIRA TRUE
				Conta contaDestino = null; // PARA ACHAR O QUE ESTA NO NOSSO ARQUIVO, INICIA VAZIO

				do {
					System.out.print("Insira o Numero da Conta de destino: ");
					numeroContaTransferencia = leitor.next();

					// para cada conta dentro de conta lista irei verificar se a conta bate com o
					// numero informado
					for (int i = 0; i < contasList.size(); i++) {

						if (contasList.get(i).getNumero().equals(numeroContaTransferencia)) {
							contaEncontrada = true;
							contaDestino = contasList.get(i);
						}
					}

					if (!contaEncontrada) {

						System.out.print("Conta não encontrada.\n");
					}

				} while (!contaEncontrada); // ENQUANTO A CONTA NAO FOR ENCONTRADA

				try {

					contaPessoaLogada.transferir(valorTransferencia, contaDestino); // OBJETO DO CONTA DESTINO
					System.out.print("Transferencia efetuado com sucesso! \nSeu saldo é: R$"
							+ FormatadorCasasDecimais.formatarCasasDecimais(contaPessoaLogada.getSaldo(), 2));
					LeitorArquivo.salvarDados(pessoasList, contasList);

				} catch (ValorNegativoException vn) { // ERRO VALOR NEGATIVO

					System.out.println(vn.getMessage() + "\n");

				} catch (TaxaMinimaException tm) { // ERRO TAXA MINIMA

					System.out.println(tm.getMessage() + "\n");

				} catch (SaldoNegativo sn) { // ERRO SALDO NEGATIVO

					System.out.println(sn.getMessage() + "\n");

				} catch (Exception e) {

				}
				break;

			case "4": // voltar
				break;

			default:
				System.out.println("Opção inválida!");
				break;
			}

		} while (!this.opcao.equals("4")); // 4 PARA VOLTAR

		if (this.opcao.equals("4")) {

			menuGeral(); // PARA REEMPRIMIR O MENU GERAL NOVAMENTE
		}

	}

	private void relatoriosConta() { // IMPRIME OS RELATORIOS

		System.out.println("\n******************* RELATÓRIOS *********************");

		do {

			System.out.println("\n[1] - Mostrar saldo");
			System.out.println("[2] - Relatório de tributação da conta corrente");
			System.out.println("[3] - Relatório de rendimento da poupança");

			if (TipoCargoEnum.GERENTE.equals(pessoaLogada.getTipoCargo())
					|| TipoCargoEnum.DIRETOR.equals(pessoaLogada.getTipoCargo())
					|| TipoCargoEnum.PRESIDENTE.equals(pessoaLogada.getTipoCargo())) { // COMPARA O CARGO PRA VER QUAL
																						// ELE TEM ACESSO

				System.out.println("[4] - Relatório do número de contas na Agência"); // TODOS PODEM ENTRAR
			}

			if (TipoCargoEnum.DIRETOR.equals(pessoaLogada.getTipoCargo())
					|| TipoCargoEnum.PRESIDENTE.equals(pessoaLogada.getTipoCargo())) {
				System.out.println(

						"[5] - Relatório com as informações de Nome, CPF e Agência de todos os clientes do sistema em ordem alfabética"); // PRESIDENTE
																																			// E
																																			// DIRETOR
																																			// PODEM
																																			// ENTRAR
			}

			if (TipoCargoEnum.PRESIDENTE.equals(pessoaLogada.getTipoCargo())) {

				System.out.println("[6] - Relatório com o valor total do capital armazenado no banco."); // SO O
																											// PRESIDENTE
																											// ENTRA
			}

			System.out.println("[9] - Voltar"); // REEMPRIME O MENU DO COMEÇO

			System.out.print("Resposta: ");
			this.opcao = this.leitor.next();

			String nomeArquivo = ""; // CRIA O ARQUIVO PARA AS MOVIMENTACOES

			switch (this.opcao) {

			case "1": // Mostrar saldo
				System.out.println("\n*********************** SALDO **********************\n");
				System.out.println("Saldo atual: R$" + contaPessoaLogada.getSaldo());
				break;

			case "2": // Relatório de tributação da conta corrente

				if (TipoCargoEnum.CLIENTE.equals(pessoaLogada.getTipoCargo())) {

					nomeArquivo = GeradorRelatorio.tributacaoContaCorrente(contaPessoaLogada,
							((Cliente) (pessoaLogada)).getSeguroVida()); // AFIRMA Q A PESSOA LOGADA É UM CLIENTE PQ SO
																			// CLIENTE PODE TER O SEGURO
				} else {

					nomeArquivo = GeradorRelatorio.tributacaoContaCorrente(contaPessoaLogada, null);
				}

				System.out.print(

						"Relatório gerado com sucesso. Verifique o arquivo " + nomeArquivo + " para conferência.");
				break;

			case "3": // Relatório de rendimento da poupança

				System.out.println("Quanto você deseja investir? ");
				double valorInvest = leitor.nextDouble();
				System.out.println("Por quanto tempo? (EM DIAS)");
				int numDias = leitor.nextInt();

				nomeArquivo = GeradorRelatorio.rendimentoPoupanca(valorInvest, numDias);

				System.out.print(
						"Relatório gerado com sucesso. Verifique o arquivo " + nomeArquivo + " para conferência.");
				break;

			case "4": // Relatório do número de contas na Agência

				if (TipoCargoEnum.CLIENTE.equals(pessoaLogada.getTipoCargo())) { // SE FOR CLIENTE, ELE NÃO TEM ACESSO

					System.out.println("Opção inválida!");
					break;
				}

				nomeArquivo = GeradorRelatorio.numeroContasPorAguencia(contasList,
						((Gerente) (pessoaLogada)).getTipoAgencia()); // Realizando um cast da pessoa logada para um
																		// gerente para ter acesso as propriedades
																		// especificas
				System.out.print(
						"Relatório gerado com sucesso. Verifique o arquivo " + nomeArquivo + " para conferência.");
				break;

			case "5": // Relatório com as informações de Nome, CPF e Agência de todos os clientes do
						// sistema em ordem alfabética

				if (TipoCargoEnum.CLIENTE.equals(pessoaLogada.getTipoCargo()) // BLOQUEIA CLIENTE E GERENTE
						|| TipoCargoEnum.GERENTE.equals(pessoaLogada.getTipoCargo())) {

					System.out.println("Opção inválida!");
					break;
				}

				HashMap<Cliente, TipoAgenciaEnum> clientes = new HashMap<Cliente, TipoAgenciaEnum>(); // QUAL AGENCIA É
																										// DE QUAL
																										// CLIENTE

				for (int i = 0; i < pessoasList.size(); i++) {

					if (pessoasList.get(i).getTipoCargo().equals(TipoCargoEnum.CLIENTE)) { // SE A LISTA DE PESSOA FOR
																							// CLIENTE

						for (int j = 0; j < contasList.size(); j++) { // PEGA A LISTA DAS CONTAS

							if (contasList.get(j).getCpf().equals(pessoasList.get(i).getCpf())) { // SE O CPF FOR IGUAL

								clientes.put((Cliente) pessoasList.get(i), contasList.get(j).getTipoAgencia()); // realizando
																												// cast
																												// de
																												// pessoa
																												// para
																												// cliente
							}
						}
					}
				}
				
				// A PARTIR DA AGENCIA PEGAMOS O CPF E JOGAMOS PARA O GERADOR DE RELATORIO
				nomeArquivo = GeradorRelatorio.clientesNoBanco(clientes);

				System.out.print(
						"Relatório gerado com sucesso. Verifique o arquivo " + nomeArquivo + " para conferência.");

				break;

			case "6": // Relatório com o valor total do capital armazenado no banco.

				if (!TipoCargoEnum.PRESIDENTE.equals(pessoaLogada.getTipoCargo())) { // SO ENTRA SE NAO FOR PRESIDENTE

					System.out.println("Opção inválida!");
					break;
				}

				nomeArquivo = GeradorRelatorio.capitalTotalArmazenado(contasList); // GERA O RELATORIO DE CAPITAL TOTAL DO BANCO
				System.out.print(
						"Relatório gerado com sucesso. Verifique o arquivo " + nomeArquivo + " para conferência.");
				break;

			case "9": // Voltar
				break;

			default:
				System.out.println("Opção inválida!");
				break;
			}

		} while (!this.opcao.equals("9")); // 9 PARA VOLTAR

		if (this.opcao.equals("9")) {

			menuGeral(); // IMPRIME O MENU GERAL NOVAMENTE
		}
	}

	// GETS E SETS
	public String getOpcao() {
		return opcao;
	}

	public void setOpcao(String opcao) {
		this.opcao = opcao;
	}

	public Scanner getLeitor() {
		return leitor;
	}

	public void setLeitor(Scanner leitor) {
		this.leitor = leitor;
	}

}
