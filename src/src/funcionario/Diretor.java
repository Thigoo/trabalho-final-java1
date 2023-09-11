package funcionario;

import agencia.ETipoAgencia;
import pessoa.ETipoAcesso;

public class Diretor extends Funcionario {

	public Diretor(String nome, String cpf, String senha, String email, String telefone, ETipoAcesso acesso,
			ETipoAgencia idAgencia) {
		super(nome, cpf, senha, email, telefone, acesso, idAgencia);
	}
}
