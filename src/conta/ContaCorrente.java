package conta;

import java.util.Date;

import ConversorData.ConverteData;
import enums.TipoAgenciaEnum;
import enums.TipoContaEnum;
import pessoa.Pessoa;

public class ContaCorrente extends Conta {
	
	public ContaCorrente(TipoContaEnum tipoConta, Pessoa cpf, String numero, double saldoAbertura,  TipoAgenciaEnum idAgencia) {
		super(tipoConta, cpf, numero, saldoAbertura, idAgencia);
	}

	@Override
	public void imprimirExtrato() {
		System.out.println("**************************************************");
        System.out.println("**************** Extrato Bancário ****************");
        System.out.println("****************  Conta Corrente  ****************");
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
