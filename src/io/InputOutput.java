package io;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
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
	private BufferedReader br;
	private Scanner leitor;
	List<Cliente> clientes;
	List<Gerente> gerentes;
	List<Diretor> diretores;
	List<Presidente> presidentes;
	List<ContaCorrente> contasCorrente;
	List<ContaPoupanca> contasPoupanca;
		
	// LEITURA DE DADOS
	@SuppressWarnings("unlikely-arg-type")
	public FileInputStream leitor(){
		System.out.println("Leitor de arquivos");
//		this.arquivo = new FileInputStream(new File("clientes.txt"));
//
//		this.leitor = new Scanner(arquivo, "UTF-8");
		try {
            this.br = new BufferedReader( new FileReader("clientes.txt"));
            while(br.ready()){
                System.out.println(br.readLine());
            }
            br.close();
        }catch(IOException e) {
            System.out.println("Erro ao acessar arquivo!");
        }
		
		clientes = new ArrayList<Cliente>();
		gerentes = new ArrayList<Gerente>();
		presidentes = new ArrayList<Presidente>();
		diretores = new ArrayList<Diretor>();
		contasCorrente = new ArrayList<ContaCorrente>();
		contasPoupanca = new ArrayList<ContaPoupanca>();
		
		
		
		while (this.leitor.hasNext())throw new NullPointerException(); {
			
			String linha = this.leitor.nextLine();
			
			if (linha != null && !linha.isEmpty()) {
				String[] dados = linha.split(";");

				// CRIAÇÃO DOS OBJETOS POR VETOR
				for (int i = 1; i < dados.length; i++) {
					
					if (dados[0].equals(TipoAcessoEnum.CLIENTE)) {
//TipoAcessoEnum acesso, String cpf, String senha, String nome, String email, String telefone,
						//String idAgencia
						Pessoa[] cliente = new Cliente[100];
						cliente[i].setCpf(dados[1]);
						cliente[i].setSenha(dados[2]);
						cliente[i].setNome(dados[3]);
						cliente[i].setEmail(dados[4]);
						cliente[i].setTelefone(dados[5]);
						cliente[i].setIdAgencia(dados[6]);
						clientes.add((Cliente) cliente[i]);
						
					} else if (dados[0].equals(TipoAcessoEnum.GERENTE)) {

						Pessoa[] gerente = new Gerente[100];
						gerente[i].setCpf(dados[1]);
						gerente[i].setSenha(dados[2]);
						gerente[i].setNome(dados[3]);
						gerente[i].setEmail(dados[4]);
						gerente[i].setTelefone(dados[5]);
						gerente[i].setIdAgencia(dados[6]);
						gerentes.add((Gerente) gerente[i]);
						
					} else if (dados[0].equals(TipoAcessoEnum.DIRETOR)) {

						Pessoa[] diretor = new Diretor[100];
						diretor[i].setCpf(dados[1]);
						diretor[i].setSenha(dados[2]);
						diretor[i].setNome(dados[3]);
						diretor[i].setEmail(dados[4]);
						diretor[i].setTelefone(dados[5]);
						diretor[i].setIdAgencia(dados[6]);
						diretores.add((Diretor) diretor[i]);

					} else if (dados[0].equals(TipoAcessoEnum.PRESIDENTE)) {

						Pessoa[] presidente = new Presidente[100];
						presidente[i].setCpf(dados[1]);
						presidente[i].setSenha(dados[2]);
						presidente[i].setNome(dados[3]);
						presidente[i].setEmail(dados[4]);
						presidente[i].setTelefone(dados[5]);
						presidente[i].setIdAgencia(dados[6]);
						presidentes.add((Presidente) presidente[i]);
						
					} else if (dados[0].equals(TipoContaEnum.CONTA_CORRENTE)) {
						
						Conta[] cc = new ContaCorrente[100];
						cc[i].setCpf(dados[1]);
						cc[i].setNumero(dados[2]);
						cc[i].setSaldo(Double.parseDouble(dados[3]));
						cc[i].setIdAgencia(dados[4]);
						contasCorrente.add((ContaCorrente) cc[i]);

					} else if (dados[0].equals(TipoContaEnum.CONTA_POUPANCA)) {
						
						Conta[] cp = new ContaPoupanca[100];
						cp[i].setCpf(dados[1]);
						cp[i].setNumero(dados[2]);
						cp[i].setSaldo(Double.parseDouble(dados[3]));
						cp[i].setIdAgencia(dados[4]);
						contasPoupanca.add((ContaPoupanca) cp[i]);
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

	public List<Cliente> getClientes() {
		return clientes;
	}

	public void setClientes(List<Cliente> clientes) {
		this.clientes = clientes;
	}

	public List<Gerente> getGerentes() {
		return gerentes;
	}

	public void setGerentes(List<Gerente> gerentes) {
		this.gerentes = gerentes;
	}

	public List<Diretor> getDiretores() {
		return diretores;
	}

	public void setDiretores(List<Diretor> diretores) {
		this.diretores = diretores;
	}

	public List<Presidente> getPresidentes() {
		return presidentes;
	}

	public void setPresidentes(List<Presidente> presidentes) {
		this.presidentes = presidentes;
	}

	public List<ContaCorrente> getContasCorrente() {
		return contasCorrente;
	}

	public void setContasCorrente(List<ContaCorrente> contasCorrente) {
		this.contasCorrente = contasCorrente;
	}

	public List<ContaPoupanca> getContasPoupanca() {
		return contasPoupanca;
	}

	public void setContasPoupanca(List<ContaPoupanca> contasPoupanca) {
		this.contasPoupanca = contasPoupanca;
	}

	
	
}
