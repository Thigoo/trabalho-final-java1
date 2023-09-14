package conta;

import java.util.Date;

import enums.TipoMovimentacaoEnum;

public class Movimentacao {
	
	private TipoMovimentacaoEnum tipo;
    private Date dataHora;
    private double valor;
    
	public Movimentacao(TipoMovimentacaoEnum tipo, Date dataHora, double valor ) {
		this.tipo = tipo;
		this.dataHora = dataHora;
		this.valor = valor;
	}

	public TipoMovimentacaoEnum getTipo() {
		return tipo;
	}

	public Date getDataHora() {
		return dataHora;
	}

	public double getValor() {
		return valor;
	}
}
