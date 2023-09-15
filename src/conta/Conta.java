package conta;

import java.util.ArrayList;
import java.util.Date;
import java.util.InputMismatchException;
import java.util.List;

import enums.TipoAgenciaEnum;
import enums.TipoContaEnum;
import enums.TipoMovimentacaoEnum;

public abstract class Conta {

	// ATRIBUTOS
	protected String numero;
	protected String cpf;
	protected TipoAgenciaEnum tipoAgencia;
	protected double totalGastosDeposito = 0.0;
	protected double totalGastosSaque = 0.0;
	protected double totalGastosTransferencia = 0.0;
	protected double saldo;
	protected TipoContaEnum TipoConta;
	protected Date dataCadastro;
	private final double TAXA_SAQUE = 0.1;
	private final double TAXA_DEPOSITO = 0.1;
	private final double TAXA_TRANSFERENCIA = 0.2;
	private final double TAXA = 0.1;
	protected List<Movimentacao> movimentacoes;

	// CONSTRUTOR
	public Conta(TipoContaEnum tipoConta, String cpf, String numero, double saldoAbertura,
			TipoAgenciaEnum tipoAgencia) {
		this.cpf = cpf;
		this.numero = numero;
		this.tipoAgencia = tipoAgencia;
		this.saldo = saldoAbertura;
		this.dataCadastro = new Date();
		this.TipoConta = tipoConta;

		movimentacoes = new ArrayList<Movimentacao>();
		Movimentacao movimentacao = new Movimentacao(TipoMovimentacaoEnum.SALDO_ABERTURA, new Date(), saldoAbertura);
		movimentacoes.add(movimentacao);
	}

	// METODOS
	public void sacar(double valor, boolean isTransferencia) {

		if ((valor + TAXA_SAQUE) > this.saldo) {
			throw new InputMismatchException("Saldo insuficiente, Saldo: R$" + this.saldo);
		}

		this.saldo -= (valor + TAXA_SAQUE);
		if (!isTransferencia) {
			totalGastosSaque += TAXA_SAQUE;			
		}

		Movimentacao movimentacao = new Movimentacao(TipoMovimentacaoEnum.SAIDA, new Date(), valor);
		movimentacoes.add(movimentacao);
	}

	public void depositar(double valor, boolean isTransferencia) {

		if (TAXA_DEPOSITO > valor) {
			throw new InputMismatchException(
					"O valor mínimo para realizar o deposito tem que ser maior que o valor da taxa R$ 0.10.");
		}

		this.saldo += (valor - TAXA_DEPOSITO);
		if (!isTransferencia) {
			totalGastosDeposito += TAXA_DEPOSITO;
		}
		
		Movimentacao movimentacao = new Movimentacao(TipoMovimentacaoEnum.ENTRADA, new Date(), valor);
		movimentacoes.add(movimentacao);
	}

	public void transferir(double valor, Conta contaDestino) {

		sacar(valor + TAXA, true);// PQ no metodo sacar já possui uma debitação de 0.1.
		contaDestino.depositar(valor + TAXA, true);
		totalGastosTransferencia += TAXA_TRANSFERENCIA;
		System.out.println(totalGastosTransferencia);
	}

	public double obterTotalGastoOperacoes() {
		return totalGastosDeposito + totalGastosSaque + totalGastosTransferencia;
	}

	public double obterSaldo() {
		return this.saldo;
	}

	public abstract void imprimirExtrato();

	// SETS E GETS
	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public TipoAgenciaEnum getTipoAgencia() {
		return tipoAgencia;
	}

	public void setTipoAgencia(TipoAgenciaEnum tipoAgencia) {
		this.tipoAgencia = tipoAgencia;
	}

	public double getTotalGastosDeposito() {
		return totalGastosDeposito;
	}

	public void setTotalGastosDeposito(double totalGastosDeposito) {
		this.totalGastosDeposito = totalGastosDeposito;
	}

	public double getTotalGastosSaque() {
		return totalGastosSaque;
	}

	public void setTotalGastosSaque(double totalGastosSaque) {
		this.totalGastosSaque = totalGastosSaque;
	}

	public double getTotalGastosTransferencia() {
		return totalGastosTransferencia;
	}

	public void setTotalGastosTransferencia(double totalGastosTransferencia) {
		this.totalGastosTransferencia = totalGastosTransferencia;
	}

	public double getSaldo() {
		return saldo;
	}

	public void setSaldo(double saldo) {
		this.saldo = saldo;
	}

	public TipoContaEnum getTipoConta() {
		return TipoConta;
	}

	public void setTipoConta(TipoContaEnum tipoConta) {
		TipoConta = tipoConta;
	}

	public Date getDataCadastro() {
		return dataCadastro;
	}

	public void setDataCadastro(Date dataCadastro) {
		this.dataCadastro = dataCadastro;
	}

	public List<Movimentacao> getMovimentacoes() {
		return movimentacoes;
	}

	public void setMovimentacoes(List<Movimentacao> movimentacoes) {
		this.movimentacoes = movimentacoes;
	}

	public double getTAXA_SAQUE() {
		return TAXA_SAQUE;
	}

	public double getTAXA_DEPOSITO() {
		return TAXA_DEPOSITO;
	}

	public double getTAXA_TRANSFERENCIA() {
		return TAXA_TRANSFERENCIA;
	}

	public double getTAXA() {
		return TAXA;
	}

	@Override
	public String toString() {
		return "Conta [numero=" + numero + ", cpf=" + cpf + ", tipoAgencia=" + tipoAgencia + ", totalGastosDeposito="
				+ totalGastosDeposito + ", totalGastosSaque=" + totalGastosSaque + ", totalGastosTransferencia="
				+ totalGastosTransferencia + ", saldo=" + saldo + ", TipoConta="
				+ TipoConta + ", dataCadastro=" + dataCadastro + "]";
	}

}
