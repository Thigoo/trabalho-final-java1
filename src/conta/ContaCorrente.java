package conta;

import java.util.Date;

import conversorData.ConverteData;
import enums.TipoAgenciaEnum;
import enums.TipoContaEnum;

public class ContaCorrente extends Conta {

	// CONSTRUTOR
	public ContaCorrente(TipoContaEnum tipoConta, String cpf, String numero, double saldoAbertura, TipoAgenciaEnum tipoAgencia) {
		super(tipoConta, cpf, numero, saldoAbertura, tipoAgencia);
	}

	// METODOS
	@Override
	public void imprimirExtrato() {
		// SO OCORRE SE FOR NA CONTA CORRENTE
		System.out.println("**************************************************");
        System.out.println("**************** Extrato Bancário ****************");
        System.out.println("****************  Conta Corrente  ****************");
        System.out.println("**************************************************");
        System.out.println("Data e hora: "+ ConverteData.converteDataParaDataHora(new Date())); // CONVERTE A DATA PARA O FORMATO BR
		System.out.println("CPF do Titular "+ this.getCpf());
		System.out.println("**************************************************");
		
		movimentacoes.forEach(movimentacao -> { //CADA MOVIMENTACAO ELE EXECUTA ALGO NOVO

			String data = ConverteData.converteDataParaDataHora(movimentacao.getDataHora());
			System.out.println(data + " - " + movimentacao.getTipo() + " - R$" + movimentacao.getValor());
		});
		
		System.out.println();
		System.out.println("Saldo R$ " + this.saldo);
		System.out.println();
		System.out.println("**************************************************");
	}
}
