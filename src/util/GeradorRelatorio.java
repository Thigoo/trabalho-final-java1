package util;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Set;

import conta.Conta;
import conta.SeguroVida;
import conversorData.ConverteData;
import enums.TipoAgenciaEnum;
import pessoa.Cliente;

public class GeradorRelatorio {
	
	private final static String diretorio = ".\\src\\relatorios\\";
	
	public static String tributacaoContaCorrente(Conta conta, SeguroVida seguroVida) { // GERRA O EXTRATO DE TRIBUTACAO CONTA CORRENTE
		
		String nomeArquivo = ""; // ARQUIVO COMEÇA VAZIO
		
		try {
			
			String data = ConverteData.converteDataParaRelatorio(new Date()); // IMPRIME A DATA NO RELATORIO
			nomeArquivo = data + "_RelTribCC" + ".txt"; // NOME DO ARQUIVO QUE VAI SER GERADO
			
			BufferedWriter out = new BufferedWriter(new FileWriter(diretorio + nomeArquivo)); //ESCRITOR - CRIA O ARQUIVO

			// OUT.APPEND PARA GERAR NO ARQUIVO
			out.append("\n************************* Relatório de tributação da conta corrente ************************\n");
			out.append("\nGastos com Operações de Depósito: R$" + conta.getTotalGastosDeposito());
			out.append("\nGastos com Operações de Saque: R$" + conta.getTotalGastosSaque());
			out.append("\nGastos com Operações de Transferência: R$" + conta.getTotalGastosTransferencia());
			out.append("\nGastos totais com as  Operações: R$" + conta.obterTotalGastoOperacoes());
			out.append("\n\n");
			out.append("Taxas cobradas pelo banco por tipo de operação:\n");
			out.append("Saque - R$0.10 (dez centavos)\n");
			out.append("Depósito - R$0.10 (dez centavos)\n");
			out.append("Transferência - R$0.20 (dez centavos)\n");

			// SE A PESSOA QUISER O SEGURO DE VIDA 
			if (seguroVida != null && seguroVida.isActive()) { // SE ESTIVER ATIVO E FOR VERDADEIRO
				// 20% DE TAXA E 80% DE RETORNO
				out.append("\nValor Contratado do Seguro de Vida: R$ " + FormatadorCasasDecimais.formatarCasasDecimais(seguroVida.getValorContratado(), 2));
				out.append("\nValor dos Tributos do Seguro de Vida: R$ " + FormatadorCasasDecimais.formatarCasasDecimais(seguroVida.getTributoSeguro(), 2));
			}
			
			out.close(); // FECHA O ESCRITOR
			
		} catch (IOException e) { // TRATAMENTO DE ERRO AO GERAR O RELATORIO
			
			System.out.println("Erro ao gerar relatório");
			
		}
		
		return nomeArquivo;
	}
	
	public static String rendimentoPoupanca(double valorInvestir, int numDias) { // GERA OS RENDIMENTOS DA POUPANCA
		
		String nomeArquivo = ""; // ARQUIVO COMEÇA VAZIA
		
		try { // TRATAMENTO DE ERRO
			
			Double valorFinal = Double.valueOf(valorInvestir); 
			Double taxaJurosDia = 0.00034; // TAXA SELIC
			
			for (int i = 0; i < numDias; i++) {
				valorFinal *= (1 + taxaJurosDia);
			}
			
			String data = ConverteData.converteDataParaRelatorio(new Date()); // DATA QUE VAI APARECER NO ARQUIVO
			nomeArquivo = data + "_RelSimulacaoCP" + ".txt"; // NOME DO ARQUIVO
			
			BufferedWriter out = new BufferedWriter(new FileWriter(diretorio + nomeArquivo)); // ESCRITOR GERA O ARQUIVO
			
			out.append("\n*********** RENDIMENTO DA CONTA POUPANÇA ***********\n");
			out.append("\n********************* SIMULAÇÃO ********************\n");
			out.append("\nData e hora da Simulação: " + ConverteData.converteDataParaDataHora(new Date())); // CONVERTE A DATA PRA BR
			out.append("\nQuantidade de dias que o dinheiro sera investido " + numDias);
			out.append("\nTaxa de juros por dia " + FormatadorCasasDecimais.formatarCasasDecimais(taxaJurosDia, 5)); // 5 CASAS DECIMAIS
			out.append("\nValor investido " + valorInvestir);
			out.append("\nValor final " + FormatadorCasasDecimais.formatarCasasDecimais(valorFinal, 2)); // 2 CASAS DECIMAIS
			out.append("\n****************************************************");
			out.close();
			
		} catch (IOException e) {
			
			System.out.println("Erro ao gerar relatório"); // TRATAMENTO DE ERRO
		}
		
		return nomeArquivo; // RETORNA O ARQUIVO COM O RELATORIO
	}
												// LISTA QUE ARMAZENA TODAS AS CONTAS E AGENCIAS
	public static String numeroContasPorAguencia(List<Conta> contas, TipoAgenciaEnum tipoAgencia) { // NUMERO DE CONTAS POR AGENCIA P GERENTE
		
		String nomeArquivo = ""; // INICIA VAZIA
		
		try { // PARA FAZER O TRATAMENTO DE ERRO
			
			List<Conta> contasComMesmaAgencia = new ArrayList<Conta>(); // LISTA DAS CONTAS COM MESMA AGENCIA
			
			for (int i = 0; i < contas.size(); i++) {
				
				if (contas.get(i).getTipoAgencia().equals(tipoAgencia)) { //COMPARA OS TIPOS DE AGENCIA E ADD NA LISTA
					
					contasComMesmaAgencia.add(contas.get(i)); // ADICIONA A CONTA COM A MESMA AGENCIA
				}
			}
			
			String data = ConverteData.converteDataParaRelatorio(new Date()); // DATA BR
			
			nomeArquivo = data + "_RelNumAgPorTipo" + ".txt"; // NOME DO ARQUIVO
			
			BufferedWriter out = new BufferedWriter(new FileWriter(diretorio + nomeArquivo));

			out.append("\n**************** Relatório do Número contas na Agência ****************\n");
			
			out.append("Número da Agência: " + tipoAgencia.getIdAgencia()); // PEGA O NUMERO DA AGENCIA PELO ID
			out.append("\nQuantidade de contas:" + contasComMesmaAgencia.size());
			out.append("\n\nInformações das contas:");
			
			for (int i = 0; i < contasComMesmaAgencia.size(); i++) { // GERA O RELATORIO DAS CONTAS COM MESMA AGENCIA.TAMANHO DA LISTA
				
				out.append("\n");
				out.append("CPF do titular: " + contasComMesmaAgencia.get(i).getCpf() + 
						" / Num. Conta: " + contasComMesmaAgencia.get(i).getNumero() +
						" / Tipo da Conta: " + contasComMesmaAgencia.get(i).getTipoConta());
				out.append("\n");
			}
			
			out.close();
			
		} catch (IOException e) {
			
			System.out.println("Erro ao gerar relatório");
		}
		
		return nomeArquivo;
	}

	public static String clientesNoBanco(HashMap<Cliente, TipoAgenciaEnum> clientesMap) {
		// DIRETOR
		String nomeArquivo = "";
		
		try {
			
			String data = ConverteData.converteDataParaRelatorio(new Date());
			nomeArquivo = data + "_RelClientes" + ".txt";
			
			Set<Cliente> keySet = clientesMap.keySet(); // COMPARA UMA LISTA COM UM ARRAY LIST
			
			ArrayList<Cliente> clientesList = new ArrayList<Cliente>(keySet);
			Collections.sort(clientesList);
			
			BufferedWriter out = new BufferedWriter(new FileWriter(diretorio + nomeArquivo)); // ESCRITOR

			out.append("\n**************** Relatório de Clientes em Ordem Alfabética ****************\n");
			
			for (int i = 0; i < clientesList.size(); i++) {
				
				out.append("\nNome: " + clientesList.get(i).getNome());
				out.append("\nCPF: " + clientesList.get(i).getCpf());
				// pegando o hashmap especifico através da chave que é o meu objeto cliente, obtendo assim o TipoAgencia dele
				out.append("\nNum. Agência: " + clientesMap.get(clientesList.get(i)).getIdAgencia());
				out.append("\n-----------------------------------------------------");
			}
			
			out.close();
			
		} catch (IOException e) {
			
			System.out.println("Erro ao gerar relatório");
		}
		return nomeArquivo;
	}
	
	public static String capitalTotalArmazenado(List<Conta> contas) { // TODO DINHEIORO QUE O BANCO TEM
		// PRESIDENTE
		
		String nomeArquivo = "";
		
		try {
			String data = ConverteData.converteDataParaRelatorio(new Date());
			nomeArquivo = data + "_RelCapitalTotalArmazenado" + ".txt";
			
			BufferedWriter out = new BufferedWriter(new FileWriter(diretorio + nomeArquivo));

			out.append("\n************************* Relatório Total do Capital Armazenado no Banco. ************************\n");
			
			Double total = 0.0;
			
			for (int i = 0; i < contas.size(); i++) { // MENOR QUE O NUMERO TOTAL DE CONTAS
				
				out.append("CPF do titular: " + contas.get(i).getCpf() + 
						" / Num. Conta: " + contas.get(i).getNumero() +
						" / Tipo da Conta: " + contas.get(i).getTipoConta() +
						" / Saldo R$ " + contas.get(i).getSaldo());
				out.append("\n");
				
				total += contas.get(i).getSaldo(); // SOMA TODOS O SALDOS USANDO O +=
			}
			
			out.append("\n-----------------------------------------------------");
			out.append("\n\n CAPITAL TOTAL ARMAZENADO: R$ " + FormatadorCasasDecimais.formatarCasasDecimais(total, 2));
			out.close();
			
		} catch (IOException e) {
			
			System.out.println("Erro ao gerar relatório");
		}
		
		return nomeArquivo;
	}
}
