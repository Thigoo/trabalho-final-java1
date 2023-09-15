package io;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import conta.Conta;
import conta.ContaCorrente;
import conta.ContaPoupanca;
import conversorData.ConverteData;
import enums.TipoAgenciaEnum;
import enums.TipoCargoEnum;
import enums.TipoContaEnum;
import pessoa.Cliente;
import pessoa.Diretor;
import pessoa.Funcionario;
import pessoa.Gerente;
import pessoa.Pessoa;
import pessoa.Presidente;
import util.FormatadorCasasDecimais;

public class LeitorArquivo {

	private static final String NOME_ARQUIVO_LEITURA = "dados.txt";
	
	// LEITURA DE DADOS
	public static List<Conta> lerContas() {
		
		List<Conta> contas = new ArrayList<Conta>();

		try {
			
			BufferedReader br = new BufferedReader(new FileReader(NOME_ARQUIVO_LEITURA));
			
			while (br.ready()) {
				
				String linha = br.readLine();
				String[] dados = linha.split(";");
				
				if (linha != null && !linha.isEmpty()) {
					
					// CRIAÇÃO DOS OBJETOS POR VETOR
					if (dados[0].contains("CONTA") && dados[0].equals(TipoContaEnum.CONTA_CORRENTE.toString())) {
						
						Conta cc = new ContaCorrente(TipoContaEnum.valueOf(dados[0]), dados[1], dados[2],
								Double.parseDouble(dados[3]), TipoAgenciaEnum.fromValue(Integer.parseInt(dados[4])));
						contas.add(cc);
						
					} else if (dados[0].contains("CONTA") && dados[0].equals(TipoContaEnum.CONTA_POUPANCA.toString())) {
						
						Conta cp = new ContaPoupanca(TipoContaEnum.valueOf(dados[0]), dados[1], dados[2],
								Double.parseDouble(dados[3]), TipoAgenciaEnum.fromValue(Integer.parseInt(dados[4])));
						contas.add(cp);
					}
				}
			}
			
			br.close();
			
		} catch (IOException e) {
			
			System.out.println("Erro ao acessar arquivo!");
		}

		return contas;
	}

	public static List<Pessoa> lerPessoas() {
		
		List<Pessoa> pessoas = new ArrayList<Pessoa>();

		try {
			
			BufferedReader br = new BufferedReader(new FileReader(NOME_ARQUIVO_LEITURA));
			
			while (br.ready()) {
				
				String linha = br.readLine();
				String[] dados = linha.split(";");
				
				if (linha != null && !linha.isEmpty()) {
					
					// CRIAÇÃO DOS OBJETOS POR VETOR
					if (!dados[0].contains("CONTA") && dados[0].equals("CLIENTE")) {
						
						Pessoa c = new Cliente();
						c.setCpf(dados[1]);
						c.setNome(dados[2]);
						c.setEmail(dados[3]);
						c.setTelefone(dados[4]);
						c.setSenha(dados[5]);
						c.setTipoCargo(TipoCargoEnum.valueOf(dados[0]));
						pessoas.add(c);
						
					} else if (!dados[0].contains("CONTA") && dados[0].equals(TipoCargoEnum.GERENTE.toString())) {
						
						Pessoa p = new Gerente(TipoAgenciaEnum.fromValue(Integer.parseInt(dados[6])),
								TipoCargoEnum.valueOf(dados[0]), dados[1], dados[5], dados[2], dados[3], dados[4]);
						pessoas.add(p);
						
					} else if (!dados[0].contains("CONTA") && dados[0].equals(TipoCargoEnum.DIRETOR.toString())) {
						
						Pessoa d = new Diretor(TipoAgenciaEnum.fromValue(Integer.parseInt(dados[6])),
								TipoCargoEnum.valueOf(dados[0]), dados[1], dados[5], dados[2], dados[3], dados[4]);
						pessoas.add(d);
						
					} else if (!dados[0].contains("CONTA") && dados[0].equals(TipoCargoEnum.PRESIDENTE.toString())) {
						
						Pessoa p = new Presidente(TipoAgenciaEnum.fromValue(Integer.parseInt(dados[6])),
								TipoCargoEnum.valueOf(dados[0]), dados[1], dados[5], dados[2], dados[3], dados[4]);
						pessoas.add(p);
					}
				}
			}
			
			br.close();
			
		} catch (IOException e) {
			
			System.out.println("Erro ao acessar arquivo!");
		}

		return pessoas;
	}

	// SAIDA DE DADOS
	public static void salvarDados(List<Pessoa> pessoas, List<Conta> contas) {
		
		try {
			
			BufferedWriter out = new BufferedWriter(new FileWriter(NOME_ARQUIVO_LEITURA));

			for (int i = 0; i < pessoas.size(); i++) {
				
				if (TipoCargoEnum.CLIENTE.equals(pessoas.get(i).getTipoCargo())) {
					
					out.append(
							pessoas.get(i).getTipoCargo()+";"+
							pessoas.get(i).getCpf()+";"+
							pessoas.get(i).getNome()+";"+
							pessoas.get(i).getEmail()+";"+
							pessoas.get(i).getTelefone()+";"+
							pessoas.get(i).getSenha()+";"
							);
					out.append("\n");
					
				} else {
					
					out.append(
							pessoas.get(i).getTipoCargo().toString()+";"+
							pessoas.get(i).getCpf()+";"+
							pessoas.get(i).getNome()+";"+
							pessoas.get(i).getEmail()+";"+
							pessoas.get(i).getTelefone()+";"+
							pessoas.get(i).getSenha()+";"+
							((Funcionario) pessoas.get(i)).getTipoAgencia().getIdAgencia()
							);
					
					out.append("\n");
				}
			}
			
			for (int i = 0; i < contas.size(); i++) {
				
				out.append(
						contas.get(i).getTipoConta()+";"+
						contas.get(i).getCpf()+";"+
						contas.get(i).getNumero()+";"+
						FormatadorCasasDecimais.formatarCasasDecimais(contas.get(i).getSaldo(), 2).replace(",", ".")+";"+
						contas.get(i).getTipoAgencia().getIdAgencia()+";"
						);
				
				out.append("\n");
			}
			
			out.close();
			
		} catch (IOException e) {
			
			System.out.println("Erro ao Salvar os Dados");
		}
		
		// Salvando os relatórios das movimentações do usuario Logado
		try {
			
			BufferedWriter out = new BufferedWriter(new FileWriter("Movimentacoes.txt"));

			for (int i = 0; i < contas.size(); i++) {
				
				if (contas.get(i).getMovimentacoes().size() > 0) {
					
					out.append("-------------------------------------------------\n");
					out.append("CPF do titular: " + contas.get(i).getCpf() + 
							" / Num. Conta: " + contas.get(i).getNumero() +
							" / Tipo da Conta: " + contas.get(i).getTipoConta());
					out.append("\n---Movimentações---\n");
					
					for (int j = 0; j < contas.get(i).getMovimentacoes().size(); j++) {
						
						 out.append("Data: " + ConverteData.converteDataParaDataHora(contas.get(i).getMovimentacoes().get(j).getDataHora()));
						 out.append("\nTipo: " + contas.get(i).getMovimentacoes().get(j).getTipo());
						 out.append("\nValor: " + contas.get(i).getMovimentacoes().get(j).getValor());
						 out.append("\n\n");
					}
					
					out.append("\n");
				}
			}
			
			out.close();
			
		} catch (IOException e) {
			
			System.out.println("Erro ao Salvar os Dados");
		}
	}

}
