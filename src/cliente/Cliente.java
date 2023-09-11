package cliente;

import agencia.ETipoAgencia;
import conta.SeguroVida;
import pessoa.ETipoAcesso;
import pessoa.Pessoa;

public class Cliente extends Pessoa {
	

	public Cliente(String nome, String cpf, String senha, String email, String telefone, ETipoAcesso acesso,
			ETipoAgencia idAgencia) {
		super(nome, cpf, senha, email, telefone, acesso, idAgencia);
	}

	private SeguroVida seguroVida = new SeguroVida();
	
	public SeguroVida getSeguroVida() {
		return seguroVida;
	}
}
