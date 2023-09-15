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
	private boolean usuarioLogado = false;
	private List<Pessoa> pessoasList;
	private List<Conta> contasList;
	Pessoa pessoaLogada;
	private Conta contaPessoaLogada;
	private int opcao;

	private double valorSaque = 0.0;
	private double valorDeposito = 0.0;
	private double valorTransferencia = 0.0;
	private String numeroContaTransferencia = "";
//	private LeitorArquivo leitorArquivo;
//	private ContaPoupanca cp;
//	private SeguroVida sg;
//	private Pessoa pessoa;
//	Double valorContratado = 0.0;

	// CONSTRUTOR
	public Menus(Scanner leitor, List<Pessoa> pessoas, List<Conta> contas) {
		this.leitor = leitor;
		this.pessoasList = pessoas;
		this.contasList = contas;
	}

//	public Menus(Conta conta, Scanner leitor) {
//		super();
//		this.conta = conta;
//		this.leitor = leitor;
//	}

	// MENU LOGAR - APARECE PARA TODAS AS PESSOAS CADASTRADAS
	public void logar() {
//		pessoaLogada = new Gerente(null, null, cpfLogin, senhaLogin, cpfLogin, senhaLogin, cpfLogin);
//		((Gerente) (pessoaLogada)).getTipoCargo();

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

		while (!usuarioLogado) {
			System.out.print("Por favor, digite seu CPF: ");
			this.cpfLogin = leitor.next();

			System.out.print("Digite sua Senha: ");
			this.senhaLogin = leitor.next();

			// Varrendo a minha lista de pessoas para achar quem tem o CPF e senha iguais
			// para realizar o login
			for (int i = 0; i < this.pessoasList.size(); i++) {
				if (this.pessoasList.get(i).getCpf().equals(this.cpfLogin)
						&& this.pessoasList.get(i).getSenha().equals(this.senhaLogin)) {
					this.pessoaLogada = this.pessoasList.get(i);
					this.usuarioLogado = true;
				}
			}
			if (!this.usuarioLogado) {
				System.out.println("CPF ou Senha invalido(s)");
			}
		}

		carregarContasUsuarioLogado();

		carregarMenu();

//		this.leitorArquivo.getPessoaList().stream().filter(el -> {
//			el.getCpf() == this.cpfLogin && el.getSenha() == this.senha)
//		});

		/*
		 * do {
		 * 
		 * 
		 * // CONFERE SE O CPF E SENHA ESTÃO CERTOS if (this.cpf.equals(pessoa.getCpf())
		 * && this.senha.equals(pessoa.getSenha())) {
		 * 
		 * System.out.println("\nLogin efetuado com sucesso!\n"); imprimirMenuCliente();
		 * 
		 * // FALTA PROCURAR SE A PESSOA EXISTE NO NOSSO ARQUIVO E FAZER O IF COM O TIPO
		 * DE ACESSO DELA try { if
		 * (leitorArquivo.leitor().equals(TipoAcessoEnum.CLIENTE)) {
		 * imprimirMenuCliente(); } else if
		 * (leitorArquivo.leitor().equals(TipoAcessoEnum.GERENTE)) {
		 * imprimirMenuGerente(); } else if
		 * (leitorArquivo.leitor().equals(TipoAcessoEnum.DIRETOR)) {
		 * imprimirMenuDiretor(); } else if
		 * (leitorArquivo.leitor().equals(TipoAcessoEnum.PRESIDENTE)) {
		 * imprimirMenuPresidente(); } } catch (Exception e) {
		 * System.out.println("Erro logar pessoa!" + e.getMessage()); } } else {
		 * System.out.println("Acesso negado!\n"); }
		 * 
		 * } while (!this.cpf.equals(pessoa.getCpf()) ||
		 * !this.senha.equals(pessoa.getSenha()));
		 */
	}

	private void carregarMenu() {
		switch (pessoaLogada.getTipoCargo()) {
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

	private void carregarContasUsuarioLogado() {
		for (int i = 0; i < contasList.size(); i++) {
			if (contasList.get(i).getCpf().equals(pessoaLogada.getCpf())) {
				this.contaPessoaLogada = contasList.get(i);
			}
		}
	}

	// MENU QUE TODOS TEM ACESSO
	public void menuGeral() {

		System.out.println("\n************************ MENU **********************\n");

		do {
			System.out.println("[1] - Movimentações na conta");
			System.out.println("[2] - Relatórios");
			if (TipoCargoEnum.CLIENTE.equals(pessoaLogada.getTipoCargo())) {
				System.out.println("[3] - Contratar Seguro de Vida");
			}
			System.out.println("[9] - Sair");

			System.out.print("Resposta: ");
			this.opcao = this.leitor.nextInt();

			switch (this.opcao) {
				case 1: // Movimentações na conta
					movConta();
					break;
				case 2: // Relatórios
					relatoriosConta();
					break;
				case 3: // Movimentações na conta
					if (!TipoCargoEnum.CLIENTE.equals(pessoaLogada.getTipoCargo())) {
						System.out.println("Opção inválida!");
						break;
					}
					System.out.println("\n************* CONTRATAR SEGURO DE VIDA *************\n");
					System.out.println("Gostaria de contratar nosso seguro?");
					System.out.println("\n[1] - Sim \n[2] - Não");
					opcao = leitor.nextInt();

					// SE O CLIENTE DESEJAR EFETUAR O SEGURO DE VIDA
					if (opcao == 1) {
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
				case 9: // Sair
					System.out.println("\nObrigado por utilizar o nosso sistema!");
					break;
				default:
					System.out.println("Opção inválida!");
					break;
			}

		} while (this.opcao != 9); // 3 PARA SAIR
		if (this.opcao == 9) {
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
			this.opcao = leitor.nextInt();

			switch (this.opcao) {

			case 1:
				System.out.print("\n************************* SAQUE ************************\n");
				System.out.print("VALOR DO SAQUE: R$");
				valorSaque = leitor.nextDouble();
				try {
					contaPessoaLogada.sacar(valorSaque, false);
					System.out.print("Saldo efetuado com sucesso! \nSeu saldo é: R$" + FormatadorCasasDecimais.formatarCasasDecimais(contaPessoaLogada.getSaldo(), 2));
					LeitorArquivo.salvarDados(pessoasList, contasList);					
				} catch (ValorNegativoException vn) {
					System.out.println(vn.getMessage()+"\n");
				} catch (SaldoNegativo sn) {
					System.out.println(sn.getMessage()+"\n");
				} catch (Exception e) {
					System.out.println("Erro inesperado do sistema.");
				}
				break;

			case 2:
				System.out.print("\n*********************** DEPOSITO ***********************\n");
				System.out.print("VALOR DO DEPOSITO: R$");
				valorDeposito = leitor.nextDouble();
				
				try {					
					contaPessoaLogada.depositar(valorDeposito, false);
					System.out.print("Depósito efetuado com sucesso! \nSeu saldo é: R$" + FormatadorCasasDecimais.formatarCasasDecimais(contaPessoaLogada.getSaldo(), 2));
					LeitorArquivo.salvarDados(pessoasList, contasList);
				} catch (ValorNegativoException vn) {
					System.out.println(vn.getMessage()+"\n");
				} catch (TaxaMinimaException tm) {
					System.out.println(tm.getMessage()+"\n");
				} catch (Exception e) {
					System.out.println("Erro inesperado do sistema.");
				}
				break;

			case 3:
				System.out.print("\n********************* TRANSFERÊNCIA ********************\n");
				System.out.print("VALOR DA TRANSFERÊNCIA: R$");
				valorTransferencia = leitor.nextDouble();

				boolean contaEncontrada = false;
				Conta contaDestino = null;
				do {
					System.out.print("Insira o Numero da Conta de destino: ");
					numeroContaTransferencia = leitor.next();
					// para cada conta dentro de conta lista irei verificar se a conta bate com o numero informado
					for (int i = 0; i < contasList.size(); i++) {
						if (contasList.get(i).getNumero().equals(numeroContaTransferencia)) {
							contaEncontrada = true;
							contaDestino = contasList.get(i);
						}
					}
					if (!contaEncontrada) {
						System.out.print("Conta não encontrada.\n");						
					}
				} while (!contaEncontrada);
				
				try {
					contaPessoaLogada.transferir(valorTransferencia, contaDestino);
					System.out.print("Transferencia efetuado com sucesso! \nSeu saldo é: R$" + FormatadorCasasDecimais.formatarCasasDecimais(contaPessoaLogada.getSaldo(), 2));
					LeitorArquivo.salvarDados(pessoasList, contasList);					
				} catch (ValorNegativoException vn) {
					System.out.println(vn.getMessage()+"\n");
				} catch (TaxaMinimaException tm) {
					System.out.println(tm.getMessage()+"\n");
				} catch (SaldoNegativo sn) {
					System.out.println(sn.getMessage()+"\n");
				} catch (Exception e) {
					// TODO: handle exception
				}
				break;
			case 4: // voltar
				break;
			default:
				System.out.println("Opção inválida!");
				break;
			}

		} while (this.opcao != 4); // 4 PARA VOLTAR
		
		if (this.opcao == 4) {
			menuGeral();
		}

	}

	private void relatoriosConta() {
		System.out.println("\n******************* RELATÓRIOS *********************");
		
		do {
			System.out.println("\n[1] - Mostrar saldo");
			System.out.println("[2] - Relatório de tributação da conta corrente");
			System.out.println("[3] - Relatório de rendimento da poupança");
			if (TipoCargoEnum.GERENTE.equals(pessoaLogada.getTipoCargo()) ||
					TipoCargoEnum.DIRETOR.equals(pessoaLogada.getTipoCargo()) ||
					TipoCargoEnum.PRESIDENTE.equals(pessoaLogada.getTipoCargo())) {
				System.out.println("[4] - Relatório do número de contas na Agência");
			}
			if (TipoCargoEnum.DIRETOR.equals(pessoaLogada.getTipoCargo()) ||
					TipoCargoEnum.PRESIDENTE.equals(pessoaLogada.getTipoCargo())) {
				System.out.println("[5] - Relatório com as informações de Nome, CPF e Agência de todos os clientes do sistema em ordem alfabética");
			}
			if (TipoCargoEnum.PRESIDENTE.equals(pessoaLogada.getTipoCargo())) {
				System.out.println("[6] - Relatório com o valor total do capital armazenado no banco.");
			}
			System.out.println("[9] - Voltar");
			
			System.out.print("Resposta: ");
			this.opcao = this.leitor.nextInt();
			
			String nomeArquivo = "";
			switch (this.opcao) {
				case 1: // Mostrar saldo
					System.out.println("\n*********************** SALDO **********************\n");
					System.out.println("Saldo atual: R$" + contaPessoaLogada.getSaldo());
					break;
	
				case 2: // Relatório de tributação da conta corrente
					if (TipoCargoEnum.CLIENTE.equals(pessoaLogada.getTipoCargo())) {
						nomeArquivo = GeradorRelatorio.tributacaoContaCorrente(contaPessoaLogada, ((Cliente) (pessoaLogada)).getSeguroVida());
					} else {
						nomeArquivo = GeradorRelatorio.tributacaoContaCorrente(contaPessoaLogada, null);
					}
					System.out.print("Relatório gerado com sucesso. Verifique o arquivo " + nomeArquivo + " para conferência.");
					break;
	
				case 3: // Relatório de rendimento da poupança
					System.out.println("Quanto você deseja investir? ");
					double valorInvest = leitor.nextDouble();
					System.out.println("Por quanto tempo? (EM DIAS)");
					int numDias = leitor.nextInt();
					
					nomeArquivo = GeradorRelatorio.rendimentoPoupanca(valorInvest, numDias);
					System.out.print("Relatório gerado com sucesso. Verifique o arquivo " + nomeArquivo + " para conferência.");
					break;
				case 4: // Relatório do número de contas na Agência
					if (TipoCargoEnum.CLIENTE.equals(pessoaLogada.getTipoCargo())) {
						System.out.println("Opção inválida!");
						break;
					}
					nomeArquivo = GeradorRelatorio.numeroContasPorAguencia(contasList, ((Gerente) (pessoaLogada)).getTipoAgencia()); // Realizando um cast da pessoa logada para um gerente para ter acesso as propriedades especificas
					System.out.print("Relatório gerado com sucesso. Verifique o arquivo " + nomeArquivo + " para conferência.");
					break;
				case 5: // Relatório com as informações de Nome, CPF e Agência de todos os clientes do sistema em ordem alfabética
					if (TipoCargoEnum.CLIENTE.equals(pessoaLogada.getTipoCargo()) ||
							TipoCargoEnum.GERENTE.equals(pessoaLogada.getTipoCargo())) {
						System.out.println("Opção inválida!");
						break;
					}
					HashMap<Cliente, TipoAgenciaEnum> clientes = new HashMap<Cliente, TipoAgenciaEnum>();
					for (int i = 0; i < pessoasList.size(); i++) {
						if (pessoasList.get(i).getTipoCargo().equals(TipoCargoEnum.CLIENTE)) {
							for (int j = 0; j < contasList.size(); j++) {
								if (contasList.get(j).getCpf().equals(pessoasList.get(i).getCpf())) {
									clientes.put((Cliente) pessoasList.get(i), contasList.get(j).getTipoAgencia()); // realizando cast de pessoa para cliente
								}
							}
						
						}
					}
					
					nomeArquivo = GeradorRelatorio.clientesNoBanco(clientes);
					System.out.print("Relatório gerado com sucesso. Verifique o arquivo " + nomeArquivo + " para conferência.");
					break;
				case 6: // Relatório com o valor total do capital armazenado no banco.
					if (!TipoCargoEnum.PRESIDENTE.equals(pessoaLogada.getTipoCargo())) {
						System.out.println("Opção inválida!");
						break;
					}
					nomeArquivo = GeradorRelatorio.capitalTotalArmazenado(contasList);
					System.out.print("Relatório gerado com sucesso. Verifique o arquivo " + nomeArquivo + " para conferência.");
					break;
				case 9: // Voltar
					break;
				default:
					System.out.println("Opção inválida!");
					break;
			}
		} while (this.opcao != 9); // 9 PARA VOLTAR
		if (this.opcao == 9) {
			menuGeral();
		}
	}
	
	// GETS E SETS
	public int getOpcao() {
		return opcao;
	}

	public void setOpcao(int opcao) {
		this.opcao = opcao;
	}

	public Scanner getLeitor() {
		return leitor;
	}

	public void setLeitor(Scanner leitor) {
		this.leitor = leitor;
	}

}
