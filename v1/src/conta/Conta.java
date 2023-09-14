package conta;

import java.util.ArrayList;
import java.util.Date;
import java.util.InputMismatchException;
import java.util.List;

import agencia.ETipoAgencia;
import conta.Movimentacao;
import conta.ETipoMovimentacao;

public abstract class Conta {
	protected int cpf;
	protected int senha;
	protected ETipoAgencia IdAgencia;
	protected double totalGastosDeposito = 0.0;
	protected double totalGastosSaque = 0.0;
	protected double totalGastosTransferencia = 0.0;
	protected double saldo;
	protected ETipoConta TipoConta;
	protected Date dataCadastro;
	private final double TAXA_SAQUE = 0.1;
	private final double TAXA_DEPOSITO = 0.1;
	private final double TAXA_TRANSFERENCIA = 0.2;
	private final double TAXA = 0.1;
	
	protected List<Movimentacao> movimentacoes;
	
	public Conta(int cpf, int senha, double saldoAbertura, ETipoConta tipoConta, ETipoAgencia idAgencia) {
		this.cpf = cpf;
		this.senha = senha;
		this.IdAgencia = idAgencia;
		this.saldo = saldoAbertura;
		this.dataCadastro = new Date();
		
		this.TipoConta = tipoConta;
		
		movimentacoes = new ArrayList<Movimentacao>();
		
		Movimentacao movimentacao = new Movimentacao(ETipoMovimentacao.SALDO_ABERTURA, new Date(), saldoAbertura);

        movimentacoes.add(movimentacao);
	}

	public int getCpf() {
		return cpf;
	}

	public void setCpf(int cpf) {
		this.cpf = cpf;
	}

	public int getSenha() {
		return senha;
	}

	public void setSenha(int senha) {
		this.senha = senha;
	}


	public ETipoConta getTipoConta() {
		return TipoConta;
	}

	public ETipoAgencia getIdAgencia() {
		return IdAgencia;
	}

	public double getSaldo() {
		return saldo;
	}

	public Date getDataCadastro() {
		return dataCadastro;
	}
	
	public double getTotalGastosDeposito() {
		return totalGastosDeposito;
	}

	public double getTotalGastosSaque() {
		return totalGastosSaque;
	}

	public double getTotalGastosTransferencia() {
		return totalGastosTransferencia;
	}

	public void sacar(double valor) {
		if((valor+TAXA_SAQUE) > this.saldo){
            throw new InputMismatchException("Saldo insuficiente, Saldo: R$" + this.saldo);            
        }

        this.saldo -= (valor + TAXA_SAQUE);
        
		totalGastosSaque = totalGastosSaque + TAXA_SAQUE;
		Movimentacao movimentacao = new Movimentacao(ETipoMovimentacao.SAIDA, new Date(), valor);
        movimentacoes.add(movimentacao);
	}
	public void depositar (double valor) {
		if (TAXA_DEPOSITO > valor) {
			throw new InputMismatchException("O valor mínimo para realizar o deposito tem que ser maior que o valor da taxa R$ 0.10.");
		}
		this.saldo += (valor-TAXA_DEPOSITO);
		totalGastosDeposito = totalGastosDeposito + TAXA_DEPOSITO;
		Movimentacao movimentacao = new Movimentacao (ETipoMovimentacao.ENTRADA, new Date(), valor);
		movimentacoes.add(movimentacao);
	}
	public void transferir (double valor, Conta contaDestino) {
		sacar(valor + TAXA);//PQ no metodo sacar já possui uma debitação de 0.1.
	    contaDestino.depositar(valor + TAXA);
	    totalGastosTransferencia = totalGastosTransferencia + TAXA_TRANSFERENCIA;
	}
	public double obterSaldo(){
        return this.saldo;
    }
	 public abstract void imprimirExtrato();
}
