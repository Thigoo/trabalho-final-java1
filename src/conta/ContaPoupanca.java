package conta;

import java.util.Date;

import ConversorData.ConverteData;
import enums.TipoAgenciaEnum;
import enums.TipoContaEnum;

public class ContaPoupanca extends Conta {

	public ContaPoupanca(String cpf, String senha, double saldoAbertura, TipoContaEnum tipoConta, TipoAgenciaEnum idAgencia) {
		super(cpf, senha, saldoAbertura, tipoConta, idAgencia);
	}

	public void calcularRendimentoPoupanca(Double valorDinheiro, Integer numDias) {
		Double valorInicial = Double.valueOf(valorDinheiro);
		double taxaJurosDia = 0.00034;
		for (int i=0; i<numDias; i++) {
			valorDinheiro = valorDinheiro * (1 + taxaJurosDia);
		}
		System.out.println("*********************************************");
		System.out.println();
		System.out.println("**** Relatorio de Rendimento da Poupança ****");
		System.out.println();
		System.out.println("*********************************************");
		System.out.println("Data e hora: "+ ConverteData.converteDataParaDataHora(new Date()));
		System.out.println("CPF do Titular "+ this.getCpf());
		System.out.println();
		System.out.println("Quantidade de dias que o dinheiro sera investido "+numDias);
		System.out.println("Taxa de juros por dia "+taxaJurosDia);
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
        System.out.println("Data e hora: "+ ConverteData.converteDataParaDataHora(new Date()));
		System.out.println("CPF do Titular "+ this.getCpf());
		System.out.println("**************************************************");
		
		movimentacoes.forEach(movimentacao ->{
			String data = ConverteData.converteDataParaDataHora(movimentacao.getDataHora());
			System.out.println(data + " - " + movimentacao.getTipo() + " - R$" + movimentacao.getValor());
		});
		System.out.println();
		System.out.println("Saldo R$ " + this.saldo);
		System.out.println();
		System.out.println("**************************************************");

	}

}
