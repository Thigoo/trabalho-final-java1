package pessoa;

import conta.SeguroVida;

public class Cliente extends Pessoa implements Comparable<Cliente> {	
	
	// CONSTRUCTOR
	public Cliente() {
		super();		
	}	

	// DESAFIO SEGURO DE VIDA
	private SeguroVida seguroVida = new SeguroVida();
	
	// GETS E SETS
	public SeguroVida getSeguroVida() {
		return seguroVida;
	}

	@Override
	public String toString() {
		return "\nCliente [cpf=" + cpf + ", email=" + email + ", nome=" + nome + ", telefone=" + telefone + "]";
	}

	@Override
	public int compareTo(Cliente c) {
		return this.nome.compareTo(c.getNome());
	}
}
