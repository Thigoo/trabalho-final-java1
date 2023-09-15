package app;

import java.io.IOException;
import java.util.Scanner;
import banco.Banco;
import banco.SeguroDeVida;
import banco.TipoContaEnum;
import contas.Conta;
import contas.ContaCorrente;
import contas.ContaPoupanca;
import io.escreverDados;
//import io.leitorDados;
import pessoas.funcionarios.Diretor;
import pessoas.funcionarios.Funcionario;
import pessoas.funcionarios.Gerente;
import pessoas.funcionarios.Presidente;
//import src.io.lerArquivos;

public class Menu {

	public static Scanner leitor = new Scanner(System.in);

	public static void Logar() {
		int escolha = 0;
		do {
//			try {
//				lerArquivos.lerFuncionarios();
//
//			} catch (Exception erro) {
//				System.out.println("!!ERRO ARQUIVO FUNCIONARIO!!");
//			}
//
//			try {
//				lerArquivos.lerAgencias();
//
//			} catch (Exception erro) {
//				System.out.println("!!ERRO ARQUIVO AGENCIAS!!");
//			}
//
//			try {
//				leitorDados.lerPessoas();
//
//			} catch (Exception erro) {
//				System.out.println("!!ERRO ARQUIVO PESSOAS!!");
//			}
//
//			try {
//				leitorDados.atualizarSaldos();
//
//			} catch (Exception erro) {
//				System.out.println("!!ERRO ARQUIVO PESSOAS!!");
//			}

			System.out.println("\n****************************************************");
			System.out.println("\nComo você deseja logar?");
			System.out.println("[1] - ENTRAR COMO CLIENTE");
			System.out.println("[2] - ENTRAR COMO FUNCIONÁRIO");
			System.out.println("[3] - SAIR");
			System.out.print("Escolha: ");
			escolha = leitor.nextInt();

			switch (escolha) {

			case 1:
				fazerLoginCliente();
				break;

			case 2:
				fazerLoginFuncionarios();
				break;

			default:
				System.out.println("Obrigado por utilizar o nosso sistema! :)");
				break;
			}

//			try {
//				escreverDados.escreverClientes();
//				escreverDados.escreverFuncionarios();
//
//			} catch (Exception erro) {
//				System.out.println("ERRO!");
//				erro.printStackTrace();
//			}
		} while (escolha != 3);
	}

	public static void fazerLoginCliente() {

		System.out.println("\n******************** LOGIN CLIENTE *****************");
		System.out.print("CPF: ");
		String cpf = leitor.next();
		System.out.print("Senha: ");

		if (leitor.hasNextInt()) {

			int senha = leitor.nextInt();

			if (Banco.getListaCliente().containsKey(cpf)) {

				if (Banco.getListaCliente().get(cpf).getTitular().getSenha() == senha) {

					mostrarOpcoesClientes(Banco.getListaCliente().get(cpf));

				} else {
					System.out.println("\nERRO! Dados incorretos!"); // caso a senha esteja errada
				}

			} else {
				System.out.println("\nERRO! Dados incorretos!"); // caso o cpf esteja errada
			}
		}
//		} else {
//			System.out.println("Digite um valor válido!");
//			System.out.println("CPF e SENHA devem ser numéricos ");
//			leitor.next();
//		}
	}

	public static void fazerLoginFuncionarios() {
		System.out.println("\n***************** LOGIN FUNCIONARIO ****************");
		System.out.print("CPF: ");
		String cpf = leitor.next();
		System.out.print("Senha: ");

		if (leitor.hasNextInt()) {

			int senha = leitor.nextInt();

			if (Banco.getListaFuncionarios().containsKey(cpf)) {

				if (Banco.getListaFuncionarios().get(cpf).getSenha() == senha) {

					mostrarOpcoesFuncionarios(Banco.getListaFuncionarios().get(cpf));
				} else {

					System.out.println("\nERRO! Dados incorretos!"); // erro na senha funcionario
				}

			} else {
				System.out.println("\nERRO! Dados incorretos!"); // erro no cpf funcionario
			}
		}
//		} else {
//			System.out.println("Digite um valor válido!");
//			System.out.println("CPF e SENHA deve ser numéricos ");
//			leitor.next();
//		}
	}

	public static void mostrarOpcoesClientes(Conta contaLogada) {

		int opcao = 0;
		boolean sair = false;

		do {
			System.out.println("****************************************************");
			System.out.println("\nBem-vindo(a), " + contaLogada.getTitular().getNome() + "! O que deseja fazer?\n");
			System.out.println("[1] Movimentações na conta");
			System.out.println("[2] Relatórios");

			if (contaLogada.getTipo() == TipoContaEnum.CONTA_CORRENTE) {

				System.out.println("[3] Contratar Seguro de Vida");
				System.out.println("[4] Sair");
			}

			else {
				System.out.println("[3] Sair");
			}

			System.out.print("Escolha: ");

			if (leitor.hasNextInt()) {

				opcao = leitor.nextInt();

				switch (opcao) {

				case 1:
					movimentacoesContaCliente(contaLogada);
					break;

				case 2:
					relatoriosContaCliente(contaLogada);
					break;

				case 3:
					if (contaLogada.getTipo() == TipoContaEnum.CONTA_CORRENTE) {
						SeguroDeVida.contratarSeguro(contaLogada);
						break;
					}

					else {
						sair = true;
						break;
					}

				case 4:
					if (contaLogada.getTipo() == TipoContaEnum.CONTA_CORRENTE) {
						sair = true;
						break;
					} else {
						System.out.println("ERRO! Tente novamente!");
						break;
					}

				default:
					System.out.println("ERRO! Tente novamente!");
					break;
				}
			} else {
				System.out.println("ERRO! Tente novamente!");
				leitor.next();
				continue;
			}

		} while (sair != true);
	}

	public static void movimentacoesContaCliente(Conta contaLogada) {

		int opcao = 0;

		do {
			System.out.println("\n*************** MOVIMENTAÇÕES NA CONTA *************\n");
			System.out.println("Seu saldo: R$" + String.format("%.2f", contaLogada.getSaldo()));
			System.out.println("\n[1] - Saque");
			System.out.println("[2] - Depósito");
			System.out.println("[3] - Transferência");
			System.out.println("[4] - Extrato");
			System.out.println("[5] - Voltar");
			System.out.print("Escolha: ");
			opcao = leitor.nextInt();

			switch (opcao) {
			case 1:
				System.out.println("\n********************** SAQUE ***********************\n");
				System.out.print("valor do saque: R$");
				double valorSaque = leitor.nextDouble();
				contaLogada.sacar(valorSaque);
				break;

			case 2:
				System.out.println("\n********************** DEPOSITO ********************\n");
				System.out.print("Valor do depósito: R$");
				double valorDeposito = leitor.nextDouble();
				contaLogada.depositar(valorDeposito);
				break;

			case 3:
				System.out.println("\n******************* TRANSFERÊNCIA ******************\n");
				System.out.print("CPF destinátario: ");
				String CPF = leitor.next();

				if (Banco.getListaCliente().containsKey(CPF) && !CPF.equals(contaLogada.getTitular().getCpf())) {

					System.out.print("Valor: R$");

					double valorTransferencia = leitor.nextDouble();
					contaLogada.transferir(Banco.getListaCliente().get(CPF), valorTransferencia);

				} else {
					System.out.println("ERRO! Dados inválidos.");
				}

				break;

			case 4:
				contaLogada.tirarExtrato();

				System.out.println("Deseja salvar extrato?");
				System.out.println("[1] - Sim");
				System.out.println("[2] - Não");
				System.out.print("Sua escolha: ");
				int escolha = leitor.nextInt();

				switch (escolha) {
				case 1:
					try {
						escreverDados.listaTransacoes(contaLogada);
						System.out.println("Eba! Salvo com sucesso :)");

					} catch (IOException erro) {
						erro.printStackTrace();
					}
					break;

				case 2:
					break;
				}
				break;

			case 5:
				break;

			default:
				System.out.println("ERRO! tente novamente!");
				break;
			}

		} while (opcao != 5);
	}

	public static void relatoriosContaCliente(Conta contaLogada) {

		int escolha = 0;

		do {
			System.out.println("\n***************** RELATÓRIOS CLIENTE ***************\n");
			System.out.println("[1] - Saldo");

			if (contaLogada.getTipo() == TipoContaEnum.CONTA_CORRENTE) {
				System.out.println("[2] - Relatório de Tributações");

			} else {
				System.out.println("[2] - Relatório de Rendimentos");
			}

			System.out.println("[3] - Voltar ");
			System.out.print("Escolha: ");
			escolha = leitor.nextInt();

			switch (escolha) {
			case 1:
				System.out.println("\n********************** SALDO ***********************\n");
				System.out.println("Saldo: R$" + String.format("%.2f", contaLogada.getSaldo()));
				System.out.println("Agência: " + contaLogada.getAgencia().getNumero());
				System.out.println("Número Conta: " + contaLogada.getNumero());
				break;

			case 2:

				if (contaLogada.getTipo() == TipoContaEnum.CONTA_CORRENTE) {
					System.out.println("\n************* RELATÓRIO DE TRIBUTAÇÕES *************\n");
					((ContaCorrente) (contaLogada)).tirarRelatorioTaxa();

					System.out.println("\nDeseja salvar relatório(s/n)? ");
					System.out.print("Escolha: ");
					String escolhaRelatorioTributacao = leitor.next();

					if (escolhaRelatorioTributacao.equalsIgnoreCase("s")) {

						try {
							escreverDados.gerarRelatorioTaxas(contaLogada);
							System.out.println("Eba! Salvo com sucesso :)");
						} catch (IOException erro) {
							System.out.println("Algo aconteceu! Não consegui salvar :(");
							System.out.println("Erro:" + erro.getMessage());
						}
					}

				} else {

					System.out.print("Valor: R$ ");
					double valor = leitor.nextDouble();

					System.out.print("Quantos dias: ");
					int dias = leitor.nextInt();

					((ContaPoupanca) (contaLogada)).simularRendimento(valor, dias);
				}
				break;

			case 3:
				break;

			default:
				System.out.println("Opção Inválida, tente novamente!");
				break;
			}

		} while (escolha != 3);
	}

	public static void mostrarOpcoesFuncionarios(Funcionario funcionarioLogado) {

		int escolha = 0;
		boolean sair = false;
		
		String mensagem = ("\nBem-vindo(a), " + funcionarioLogado.getNome() + "! O que deseja fazer?");
		do {
			switch (funcionarioLogado.getTipo()) {

			case GERENTE:
				System.out.print("\n******************** LOGIN GERENTE *****************");
				System.out.println(mensagem);
				System.out.println("\n[1] Relatório Contas da Agencia");
				System.out.println("[2] Sair");

				System.out.print("Digite uma opção: ");
				escolha = leitor.nextInt();

				switch (escolha) {

				case 1:
					System.out.println("\n************* RELATÓRIO TOTAL DE CONTAS ************\n");
					((Gerente) (funcionarioLogado)).gerarRelatorioNumeroContas();
					break;

				default:
					break;
				}

				break;

			case DIRETOR:
				System.out.print("\n******************** LOGIN DIRETOR *****************");
				System.out.println(mensagem);
				System.out.println("\n[1] - Relatório Contas da Agencia");
				System.out.println("[2] - Relatório Geral de Contas");
				System.out.println("[3] - Sair");
				System.out.print("Digite uma opção: ");
				escolha = leitor.nextInt();

				switch (escolha) {
				case 1:
					System.out.println("\n************* RELATÓRIO TOTAL DE CONTAS ************\n");
					// System.out.println("\nNum. Agencia: " + Banco.getListaAgencias().keySet());
					System.out.print("Agencia N° ");

					int numAgencia = leitor.nextInt();

					((Gerente) (funcionarioLogado)).setNumeroAgencia(numAgencia);
					((Gerente) (funcionarioLogado)).gerarRelatorioNumeroContas();
					break;

				case 2:
					System.out.println("\n************ RELATÓRIO GERAL DAS CONTAS ************\n");
					((Diretor) (funcionarioLogado)).gerarRelatorioInfoClientes();

					System.out.println("Deseja salvar esse extrato? (y/n) ");
					System.out.print("Sua escolha: ");
					String escolha2 = leitor.next();

					if (escolha2.equalsIgnoreCase("y")) {

						try {
							escreverDados.gerarRelatorioClientesDiretor();
							System.out.println("Arquivo gerado com sucesso! ");

						} catch (IOException e) {
							System.out.println("Não foi possivel gerar o arquivo.");
							System.out.println("Erro:" + e.getMessage());
							e.printStackTrace();
						}
					}
					break;

				case 3:
					sair = true;
					break;

				default:
					System.out.println("Opção Inválida, Tente novamente!");
					break;
				}

				break;

			case PRESIDENTE:
				System.out.println("\n****************** LOGIN PRESIDENTE ****************");
				System.out.println(mensagem);
				System.out.println("[1]- Relatório Contas da Agencia");
				System.out.println("[2]- Relatório Geral de Contas");
				System.out.println("[3]- Relatório Saldo Total do Banco");
				System.out.println("[4]- Cadastrar Nova Agencia.");
				System.out.println("[5]- Sair");

				System.out.print("Digite uma opção: ");
				escolha = leitor.nextInt();

				switch (escolha) {
				case 1:
					System.out.println("Escolha o número da agencia");
					System.out.println("Num. Agencias: " + Banco.getListaAgencias().keySet());
					System.out.print("Digite o número de uma agencia: ");
					int numAgencia = leitor.nextInt();

					((Gerente) (funcionarioLogado)).setNumeroAgencia(numAgencia);
					((Gerente) (funcionarioLogado)).gerarRelatorioNumeroContas();
					break;

				case 2:
					((Diretor) (funcionarioLogado)).gerarRelatorioInfoClientes();
					System.out.println("Deseja salvar esse extrato? (y/n) ");
					System.out.print("Sua escolha: ");
					String escolha2 = leitor.next();

					if (escolha2.equalsIgnoreCase("y")) {

						try {
							escreverDados.gerarRelatorioClientesDiretor();
							System.out.println("Arquivo gerado com sucesso! ");
						} catch (IOException e) {

							System.out.println("Não foi possivel gerar o arquivo.");
							System.out.println("Erro:" + e.getMessage());
							e.printStackTrace();
						}
					}
					break;

				case 3:
					((Presidente) (funcionarioLogado)).gerarRelatorioCapitalTotal();
					break;

				case 4:
					((Presidente) (funcionarioLogado)).cadastrarAgencia();
					break;

				case 5:
					sair = true;
					break;

				default:
					break;
				}

				break;

			default:
				break;
			}

		} while (sair != true);
	}
}
