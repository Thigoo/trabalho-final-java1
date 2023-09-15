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
import enums.TipoAgenciaEnum;
import enums.TipoCargoEnum;
import enums.TipoContaEnum;
import pessoa.Cliente;
import pessoa.Diretor;
import pessoa.Gerente;
import pessoa.Pessoa;
import pessoa.Presidente;

public class LeitorArquivo {

	private List<ContaPoupanca> contaPoupancaList = new ArrayList<ContaPoupanca>();
	private List<ContaCorrente> contaCorrenteList = new ArrayList<ContaCorrente>();
	private List<Conta> contaList = new ArrayList<Conta>(); // lista geral de conta
	private List<Cliente> clienteList = new ArrayList<Cliente>();
	private List<Gerente> gerenteList = new ArrayList<Gerente>();
	private List<Diretor> diretorList = new ArrayList<Diretor>();
	private List<Presidente> presidenteList = new ArrayList<Presidente>();
	private List<Pessoa> pessoaList = new ArrayList<Pessoa>(); // lista geral de pessoa

	// LEITURA DE DADOS
	public static List<Conta> lerContas() {
		List<Conta> contas = new ArrayList<Conta>();

		try {
			BufferedReader br = new BufferedReader(new FileReader("dados.txt"));
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
			BufferedReader br = new BufferedReader(new FileReader("dados.txt"));
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

	public void carregarDados() {
		try {
			BufferedReader br = new BufferedReader(new FileReader("dados.txt"));
			while (br.ready()) {
				String linha = br.readLine();
				String[] dados = linha.split(";");
				if (linha != null && !linha.isEmpty()) {
					// CRIAÇÃO DOS OBJETOS POR VETOR
					if (dados[0].contains("CONTA") && dados[0].equals(TipoContaEnum.CONTA_CORRENTE.toString())) {
						ContaCorrente cc = new ContaCorrente(TipoContaEnum.valueOf(dados[0]), dados[1], dados[2],
								Double.parseDouble(dados[3]), TipoAgenciaEnum.fromValue(Integer.parseInt(dados[4])));
						contaCorrenteList.add(cc);
						contaList.add(cc);
					} else if (dados[0].contains("CONTA") && dados[0].equals(TipoContaEnum.CONTA_POUPANCA.toString())) {
						ContaPoupanca cp = new ContaPoupanca(TipoContaEnum.valueOf(dados[0]), dados[1], dados[2],
								Double.parseDouble(dados[3]), TipoAgenciaEnum.fromValue(Integer.parseInt(dados[4])));
						contaPoupancaList.add(cp);
						contaList.add(cp);
					} else if (!dados[0].contains("CONTA") && dados[0].equals("CLIENTE")) {
						Cliente c = new Cliente();
						c.setCpf(dados[1]);
						c.setNome(dados[2]);
						c.setEmail(dados[3]);
						c.setTelefone(dados[4]);
						c.setSenha(dados[5]);
						clienteList.add(c);
						pessoaList.add(c);
					} else if (!dados[0].contains("CONTA") && dados[0].equals(TipoCargoEnum.GERENTE.toString())) {
						Gerente g = new Gerente(TipoAgenciaEnum.fromValue(Integer.parseInt(dados[6])),
								TipoCargoEnum.valueOf(dados[0]), dados[1], dados[5], dados[2], dados[3], dados[4]);
						gerenteList.add(g);
						pessoaList.add(g);
					} else if (!dados[0].contains("CONTA") && dados[0].equals(TipoCargoEnum.DIRETOR.toString())) {
						Diretor d = new Diretor(TipoAgenciaEnum.fromValue(Integer.parseInt(dados[6])),
								TipoCargoEnum.valueOf(dados[0]), dados[1], dados[5], dados[2], dados[3], dados[4]);
						diretorList.add(d);
						pessoaList.add(d);
					} else if (!dados[0].contains("CONTA") && dados[0].equals(TipoCargoEnum.PRESIDENTE.toString())) {
						Presidente p = new Presidente(TipoAgenciaEnum.fromValue(Integer.parseInt(dados[6])),
								TipoCargoEnum.valueOf(dados[0]), dados[1], dados[5], dados[2], dados[3], dados[4]);
						presidenteList.add(p);
						pessoaList.add(p);
					}
				}
			}
			br.close();
		} catch (IOException e) {
			System.out.println("Erro ao acessar arquivo!");
		}
	}

	// SAIDA DE DADOS
	public static void escritor() {
		try {
			BufferedWriter out = new BufferedWriter(new FileWriter("movimentacaoSaque.txt"));

			out.append("\n************************* SAQUE ************************\n");
			out.append("VALOR DO SAQUE: R$");
//		  				valorSaque = leitor.nextDouble();
//		  				conta.sacar(valorSaque);
//		  out.append("Saldo efetuado com sucesso! \nSeu saldo é: R$" + conta.getSaldo());

			out.append("abcsss");
			out.close();
		} catch (IOException e) {
			System.out.println("Erro ao acessar o arquivo");
		}
	}

	public List<ContaPoupanca> getContaPoupancaList() {
		return contaPoupancaList;
	}

	public List<ContaCorrente> getContaCorrenteList() {
		return contaCorrenteList;
	}

	public List<Conta> getContaList() {
		return contaList;
	}

	public List<Cliente> getClienteList() {
		return clienteList;
	}

	public List<Gerente> getGerenteList() {
		return gerenteList;
	}

	public List<Diretor> getDiretorList() {
		return diretorList;
	}

	public List<Presidente> getPresidenteList() {
		return presidenteList;
	}

	public List<Pessoa> getPessoaList() {
		return pessoaList;
	}

}
