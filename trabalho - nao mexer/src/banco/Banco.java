package banco;

import java.util.HashMap;
import contas.Conta;
import pessoas.funcionarios.Funcionario;
import pessoas.funcionarios.Presidente;

public abstract class Banco {
	private static String nome;
	private static Presidente presidente;
	private static HashMap<String, Conta> listaCliente = new HashMap<>();
	private static HashMap<String, Funcionario> listaFuncionarios = new HashMap<>();
	private static HashMap<Integer, Agencia> listaAgencias = new HashMap<>();
	private static double saldoTotal;
	private static int contadorAgencia = 0;

//	public static void addNovaAgencia(Agencia agencia) {
//		
//		listaAgencias.put(agencia.getNumero(), agencia);
//		contadorAgencia++;
//	}

	public static String getNome() {
		return nome;
	}

	public static void setNome(String nome) {
		Banco.nome = nome;
	}

	public static Presidente getPresidente() {
		return presidente;
	}

	public static void setPresidente(Presidente presidente) {
		Banco.presidente = presidente;
	}

	public static HashMap<Integer, Agencia> getListaAgencias() {
		return listaAgencias;
	}

	public static void setListaAgencias(HashMap<Integer, Agencia> listaAgencias) {
		Banco.listaAgencias = listaAgencias;
	}

	public static double getSaldoTotal() {
		return saldoTotal;
	}

	public static void setSaldoTotal(double saldoTotal) {
		Banco.saldoTotal = saldoTotal;
	}

	public static int getContadorAgencia() {
		return contadorAgencia;
	}

	public static void setContadorAgencia(int numeroAgencias) {
		Banco.contadorAgencia = numeroAgencias;
	}

	public static HashMap<String, Conta> getListaCliente() {
		return listaCliente;
	}

	public static void setListaCliente(HashMap<String, Conta> listaCliente) {
		Banco.listaCliente = listaCliente;
	}

	public static HashMap<String, Funcionario> getListaFuncionarios() {
		return listaFuncionarios;
	}

	public static void setListaFuncionarios(HashMap<String, Funcionario> listaFuncionarios) {
		Banco.listaFuncionarios = listaFuncionarios;
	}

	@Override
	public String toString() {
		return "Banco [getClass()=" + getClass() + ", hashCode()=" + hashCode() + ", toString()=" + super.toString()
				+ "]";
	}

	public static void addNovaAgencia(Agencia agencia) {
		// TODO Auto-generated method stub
		
	}
}
