package conta;

import java.util.Date;

import conta.ETipoMovimentacao;

public class Movimentacao {
	
	private ETipoMovimentacao tipo;
    private Date dataHora;
    private double valor;
    
	public Movimentacao(ETipoMovimentacao tipo, Date dataHora, double valor ) {
		this.tipo = tipo;
		this.dataHora = dataHora;
		this.valor = valor;
	}

	public ETipoMovimentacao getTipo() {
		return tipo;
	}

	public Date getDataHora() {
		return dataHora;
	}

	public double getValor() {
		return valor;
	}
}
