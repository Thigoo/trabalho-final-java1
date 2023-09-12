package funcionario;

import agencia.ETipoAgencia;
import pessoa.ETipoAcesso;
import pessoa.Pessoa;

public  class Funcionario extends Pessoa {

	
	
	public Funcionario(String nome, String cpf, String senha, String email, String telefone, ETipoAcesso acesso,
			ETipoAgencia idAgencia) {
		super(nome, cpf, senha, email, telefone, acesso, idAgencia);
	}
}
