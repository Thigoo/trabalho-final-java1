package pessoa;

import conta.SeguroVida;
import enums.TipoAcessoEnum;
import enums.TipoAgenciaEnum;

public class Cliente extends Pessoa {	
	
	// CONSTRUCTOR
	public Cliente() {
		
	}	

	public Cliente(enums.TipoAcessoEnum acesso, String cpf, String senha, String nome, String email, String telefone,
			String idAgencia) {
		super(acesso, cpf, senha, nome, email, telefone, idAgencia);
	}
	
	// DESAFIO SEGURO DE VIDA
	private SeguroVida seguroVida = new SeguroVida();
	
	// GETS E SETS
	public SeguroVida getSeguroVida() {
		return seguroVida;
	}

	public void setSeguroVida(SeguroVida seguroVida) {
		this.seguroVida = seguroVida;
	}

	@Override
	public void add(Pessoa cliente) {
	
	}

	@Override
	public String toString() {
		return "\nCliente [cpf=" + cpf + ", email=" + email + ", nome=" + nome + ", telefone=" + telefone + "]";
	}
}
