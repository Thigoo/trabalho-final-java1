package conta;

import java.util.Date;

import conversorData.ConverteData;
import enums.TipoAgenciaEnum;
import enums.TipoContaEnum;

public class ContaPoupanca extends Conta {

	// CONSTRUTOR
	public ContaPoupanca(TipoContaEnum tipoConta, String cpf, String numero, double saldoAbertura, TipoAgenciaEnum tipoAgencia) {
		super(tipoConta, cpf, numero, saldoAbertura, tipoAgencia);
	}

	// METODOS
	public void calcularRendimentoPoupanca(double valorDinheiro, int numDias) {

		Double valorInicial = Double.valueOf(valorDinheiro); // CLONA O VALODR DINHEIRO
		double taxaJurosDia = 0.00034; // TAXA SELIC 13% / 12  ANO/ 30 DIA

		for (int i = 0; i < numDias; i++) {

			valorDinheiro *= (1 + taxaJurosDia);
		}

		System.out.println("*********************************************");
		System.out.println();
		System.out.println("**** Relatorio de Rendimento da Poupança ****");
		System.out.println();
		System.out.println("*********************************************");
		System.out.println("Data e hora: " + ConverteData.converteDataParaDataHora(new Date()));
		System.out.println("CPF do Titular " + this.getCpf());
		System.out.println();
		System.out.println("Quantidade de dias que o dinheiro sera investido " + numDias);
		System.out.println("Taxa de juros por dia " + taxaJurosDia);
		System.out.println("Valor investido " + valorInicial);
		System.out.println("Valor final " + valorDinheiro);
		System.out.println();
		System.out.println("*********************************************");
	}

	@Override
	public void imprimirExtrato() {
		System.out.println("**************************************************");
		System.out.println("**************** Extrato Bancário ****************");
		System.out.println("****************  Conta Poupança  ****************");
		System.out.println("**************************************************");
		System.out.println("Data e hora: " + ConverteData.converteDataParaDataHora(new Date()));
		System.out.println("CPF do Titular " + this.getCpf());
		System.out.println("**************************************************");

		movimentacoes.forEach(movimentacao -> {
			
			String data = ConverteData.converteDataParaDataHora(movimentacao.getDataHora());
			System.out.println(data + " - " + movimentacao.getTipo() + " - R$" + movimentacao.getValor());
		});
		
		System.out.println();
		System.out.println("Saldo R$ " + this.saldo);
		System.out.println();
		System.out.println("**************************************************");
	}
}
