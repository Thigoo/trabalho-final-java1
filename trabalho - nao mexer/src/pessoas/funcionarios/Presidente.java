package pessoas.funcionarios;

import banco.Agencia;
import banco.Banco;
import contas.Conta;

public class Presidente extends Diretor {
	
	public Presidente(String nome, String cpf, int senha, Agencia agencia) {
		super(nome, cpf, senha, agencia);
		this.getNumeroAgencia();
		this.tipo = Cargo.PRESIDENTE;
	}
	
	public void gerarRelatorioCapitalTotal() {
		
		double saldoTotal = 0;
		
		for (Integer i : Banco.getListaAgencias().keySet()) {
			
			for (Conta j : Banco.getListaAgencias().get(i).getContas()) {
				
				saldoTotal += j.getSaldo();
			}
		}
		
		Banco.setSaldoTotal(saldoTotal);
		System.out.println("| O saldo total do banco é: R$" + String.format("%.2f", saldoTotal));
	}

	@Override
	public String toString() {
		return "Presidente," + nome + "," + cpf + "," + senha;
	}
	
	
	
	
	
	

}


