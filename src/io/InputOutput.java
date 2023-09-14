package io;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import conta.Conta;
import conta.ContaCorrente;
import conta.ContaPoupanca;
import enums.TipoAcessoEnum;
import enums.TipoContaEnum;
import pessoa.Cliente;
import pessoa.Diretor;
import pessoa.Gerente;
import pessoa.Pessoa;
import pessoa.Presidente;

public class InputOutput {

	private FileInputStream arquivo;
	private Scanner leitor;
	
	// LEITURA DE DADOS
	@SuppressWarnings("unlikely-arg-type")
	public FileInputStream leitor() throws FileNotFoundException {

		this.arquivo = new FileInputStream(new File("\\src\\arquivos\\pessoas.txt"));

		this.leitor = new Scanner(arquivo, "UTF-8");
		
		Map<String, Pessoa> clientes = new HashMap<>();
		Map<String, Conta> contascorrente = new HashMap<>();
		Map<String, Conta> contaspoupanca = new HashMap<>();
		Map<String, Pessoa> gerentes = new HashMap<>();
		Map<String, Pessoa> presidentes = new HashMap<>();
		Map<String, Pessoa> diretores = new HashMap<>();

		while (this.leitor.hasNext()) {
			
			String linha = this.leitor.nextLine();
			
			if (linha != null && !linha.isEmpty()) {
				String[] dados = linha.split(";");

				// CRIAÇÃO DOS OBJETOS POR VETOR
				for (int i = 1; i < dados.length; i++) {
					
					if (dados[0].equals(TipoAcessoEnum.CLIENTE)) {

						Pessoa[] cliente = new Cliente[100];
						cliente[i].setCpf(dados[1]);
						cliente[i].setSenha(dados[2]);
						cliente[i].setNome(dados[3]);
						cliente[i].setEmail(dados[4]);
						cliente[i].setTelefone(dados[5]);
						cliente[i].setIdAgencia(dados[6]);
						clientes.put(dados[i], cliente[i]);
						
					} else if (dados[0].equals(TipoAcessoEnum.GERENTE)) {

						Pessoa[] gerente = new Gerente[100];
						gerente[i].setCpf(dados[1]);
						gerente[i].setSenha(dados[2]);
						gerente[i].setNome(dados[3]);
						gerente[i].setEmail(dados[4]);
						gerente[i].setTelefone(dados[5]);
						gerente[i].setIdAgencia(dados[6]);
						gerentes.put(dados[i], gerente[i]);
						
					} else if (dados[0].equals(TipoAcessoEnum.DIRETOR)) {

						Pessoa[] diretor = new Diretor[100];
						diretor[i].setCpf(dados[1]);
						diretor[i].setSenha(dados[2]);
						diretor[i].setNome(dados[3]);
						diretor[i].setEmail(dados[4]);
						diretor[i].setTelefone(dados[5]);
						diretor[i].setIdAgencia(dados[6]);
						diretores.put(dados[i], diretor[i]);

					} else if (dados[0].equals(TipoAcessoEnum.PRESIDENTE)) {

						Pessoa[] presidente = new Presidente[100];
						presidente[i].setCpf(dados[1]);
						presidente[i].setSenha(dados[2]);
						presidente[i].setNome(dados[3]);
						presidente[i].setEmail(dados[4]);
						presidente[i].setTelefone(dados[5]);
						presidente[i].setIdAgencia(dados[6]);
						presidentes.put(dados[i], presidente[i]);
						
					} else if (dados[0].equals(TipoContaEnum.CONTA_CORRENTE)) {
						
						Conta[] cc = new ContaCorrente[100];
						cc[i].setCpf(dados[1]);
						cc[i].setNumero(dados[2]);
						cc[i].setSaldo(Double.parseDouble(dados[3]));
						cc[i].setIdAgencia(dados[4]);
						contascorrente.put(dados[i], cc[i]);

					} else if (dados[0].equals(TipoContaEnum.CONTA_POUPANCA)) {
						
						Conta[] cp = new ContaPoupanca[100];
						cp[i].setCpf(dados[1]);
						cp[i].setNumero(dados[2]);
						cp[i].setSaldo(Double.parseDouble(dados[3]));
						cp[i].setIdAgencia(dados[4]);
						contaspoupanca.put(dados[i], cp[i]);
					}
				}
			}
		}
		
		return this.arquivo;
	}

	// SAIDA DE DADOS
	public static void escritor() {
		try {
          BufferedWriter out = new BufferedWriter( new FileWriter("movimentacaoSaque.txt"));
          
          out.append("\n************************* SAQUE ************************\n");
		  out.append("VALOR DO SAQUE: R$");
//		  				valorSaque = leitor.nextDouble();
//		  				conta.sacar(valorSaque);
//		  out.append("Saldo efetuado com sucesso! \nSeu saldo é: R$" + conta.getSaldo());
          
          out.append("abcsss");
          out.close();
          }catch (IOException e) {
              System.out.println("Erro ao acessar o arquivo");
      }
	}
}
