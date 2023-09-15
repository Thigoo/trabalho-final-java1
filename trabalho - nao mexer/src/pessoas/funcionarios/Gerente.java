package pessoas.funcionarios;

import java.util.Scanner;

import banco.Banco;

public class Gerente extends Funcionario {
	
	Scanner sc = new Scanner(System.in);
	
	private int numeroAgencia;

	public Gerente(String nome, String cpf, int senha, int numeroAgencia) {
		super(nome, cpf, senha);
		this.numeroAgencia = numeroAgencia;
		this.tipo = Cargo.GERENTE;
	}

	public Gerente(String nome, String cpf, int senha) {
		super(nome, cpf, senha);
		this.tipo = Cargo.GERENTE;
	}

	public void gerarRelatorioNumeroContas() {
		
		System.out.println("\nAgencia: " + this.numeroAgencia);
		System.out.println("Total de contas: " + Banco.getListaAgencias().get(numeroAgencia).getNumContas() + "\n");
	}

	public int getNumeroAgencia() {
		return numeroAgencia;
	}

	public void setNumeroAgencia(int numeroAgencia) {
		this.numeroAgencia = numeroAgencia;
	}

	@Override
	public String toString() {
		return "Gerente," + nome + "," + cpf + "," + senha;
	}

}
