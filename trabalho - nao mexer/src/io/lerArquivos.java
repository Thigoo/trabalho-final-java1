package src.io;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import banco.Agencia;
import banco.Banco;
import contas.Conta;
import contas.ContaCorrente;
import contas.ContaPoupanca;
import pessoas.Cliente;
import pessoas.Pessoa;
import pessoas.funcionarios.Diretor;
import pessoas.funcionarios.Funcionario;
import pessoas.funcionarios.Gerente;
import pessoas.funcionarios.Presidente;

public class lerArquivos {

	public static void lerPessoas() throws IOException {
		
		String path = ".//Relatorios//ListaClientes.txt";
		BufferedReader leitor = new BufferedReader(new FileReader(path));
		String linha = "";
		while (true) {
			linha = leitor.readLine();
			if (linha != null) {
				String[] fields = linha.split(",");
				String tipoConta = fields[0];
				int numeroConta = Integer.parseInt(fields[1]);
				String nome = fields[2];
				String cpf = fields[3];
				int senha = Integer.parseInt(fields[4]);
				int numAgencia = Integer.parseInt(fields[5]);
				double saldo = Double.parseDouble(fields[6]);
				
				Pessoa pessoa = new Cliente(nome, cpf, senha);
				Agencia agencia = Banco.getListaAgencias().get(numAgencia);
						
				switch (tipoConta) {
					case "ContaCorrente":
						ContaCorrente CC = new ContaCorrente(numeroConta, pessoa, saldo, agencia);
						Banco.getListaCliente().put(cpf, CC);
						agencia.addNovaConta(CC);
					break;
					
					case "ContaPoupanca":
						ContaPoupanca CP = new ContaPoupanca(numeroConta, pessoa, saldo, agencia);
						Banco.getListaCliente().put(cpf, CP);
						agencia.addNovaConta(CP);
					break;	
	
					default:
						System.out.println("Não foi possível criar a conta.");
					break;
				}
			}
			else {
				break;
			}
		}
		leitor.close();
	}

	public static void lerFuncionarios() throws IOException {
		
		String path = ".//Relatorios//ListaFuncionarios.txt";
		BufferedReader leitor = new BufferedReader(new FileReader(path));
		String linha = "";
		while (true) {
			linha = leitor.readLine();
			if (linha != null) {
				String[] fields = linha.split(",");
				String cargo = fields[0];
				String nome = fields[1];
				String cpf = fields[2];
				int senha = Integer.parseInt(fields[3]);
				Agencia agencia = null;
						
				switch (cargo) {
					case "Gerente":
						agencia = new Agencia(new Gerente("Elson", "1", 1, 0));
						Banco.addNovaAgencia(agencia);
					break;
					case "Diretor":
					break;
					case "Presidente":
					break;	
					default:
						System.out.println("Não foi possível criar o funcionário.");
					break;
				}
			}
			else {
				break;
			}
		}
		leitor.close();
	}

	public static void lerAgencias() throws IOException {
		String path = ".//Relatorios//Agencias.txt";
		BufferedReader leitor = new BufferedReader(new FileReader(path));
		String linha = "";
		while (true) {
			linha = leitor.readLine();
			if (linha != null) {
				String[] fields = linha.split(",");
				String Agencia = fields[0];
				int numAgencia = Integer.parseInt(fields[1]);
				String cargo = fields[2];
				String nome = fields[3];
				String cpf = fields[4];
				int senha = Integer.parseInt(fields[5]);
				
				Agencia agencia = new Agencia(numAgencia, new Gerente(nome, cpf, senha));
				Banco.getListaAgencias().put(numAgencia, agencia);
			}
			else {
				break;
			}
		}
		leitor.close();
	}
	
	public static void atualizarSaldos() throws IOException {
		
		
		String path = ".//Relatorios//ListaClientes.txt";
		BufferedReader leitor = new BufferedReader(new FileReader(path));
		String linha = "";
		
		while (true) {
			linha = leitor.readLine();
			if (linha != null) {
				String[] fields = linha.split(",");
				String cpf = fields[3];
				int numAgencia = Integer.parseInt(fields[5]);
				double saldo = Double.parseDouble(fields[6]);
				
				 for(Conta conta : Banco.getListaAgencias().get(numAgencia).getContas()) {
					  if((conta.getTitular().getCpf()).equals(cpf)) {
						  conta.setSaldo(saldo);
					  }
				  }
			}
			else {
				break;
			}
		}
		leitor.close();
				  
	}

}