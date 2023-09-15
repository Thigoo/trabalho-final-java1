package conta;

import java.util.Date;

import enums.TipoMovimentacaoEnum;

public class Movimentacao { 

	// ATRIBUTOS
	private TipoMovimentacaoEnum tipo;
	private Date dataHora;
	private double valor;

	// CONSTRUTOR
	public Movimentacao(TipoMovimentacaoEnum tipo, Date dataHora, double valor) {
		this.tipo = tipo;
		this.dataHora = dataHora;
		this.valor = valor;
	}

	// GETS E SETS
	public TipoMovimentacaoEnum getTipo() {
		return tipo;
	}

	public void setTipo(TipoMovimentacaoEnum tipo) {
		this.tipo = tipo;
	}

	public Date getDataHora() {
		return dataHora;
	}

	public void setDataHora(Date dataHora) {
		this.dataHora = dataHora;
	}

	public double getValor() {
		return valor;
	}

	public void setValor(double valor) {
		this.valor = valor;
	}
}
