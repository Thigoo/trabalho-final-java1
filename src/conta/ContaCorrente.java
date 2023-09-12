package conta;

import java.util.Date;

import ConversorData.ConverteData;
import agencia.ETipoAgencia;

public class ContaCorrente extends Conta {
	
	public ContaCorrente(String cpf, String senha, double saldoAbertura, ETipoConta tipoConta, ETipoAgencia idAgencia) {
		super(cpf, senha, saldoAbertura, tipoConta, idAgencia);
		// TODO Auto-generated constructor stub
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
