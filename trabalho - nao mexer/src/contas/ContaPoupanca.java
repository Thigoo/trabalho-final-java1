package contas;

import banco.Agencia;
import banco.TipoContaEnum;
import pessoas.Pessoa;

public class ContaPoupanca extends Conta {

	public ContaPoupanca(int numero, Pessoa titular, double saldo, Agencia agencia) {
		super(numero, titular, saldo, agencia);
		this.tipo = TipoContaEnum.CONTA_POUPANCA;
	}

	public static final double TAXA_RENDIMENTO = 0.001; // MUDAR PARA TAXA SELIC

	public void simularRendimento(double valorSimulado, int dias) {

		double montante = valorSimulado * Math.pow((1 + TAXA_RENDIMENTO), dias);
		System.out.println("\n************** RELATÓRIO DE RENDIMENTO *************\n");
		System.out.println("Após " + dias + " dias: R$" + String.format("%.2f", montante));
		System.out.println("Total juros: R$" + String.format("%.2f", (montante - valorSimulado)));
	}

//	@Override
//	public String toString() {
//		return "ContaPoupanca," + numero + "," + titular +"," + this.getAgencia().getNumero() +  "," + saldo;
//	}
//	
}
