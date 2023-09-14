package funcionario;

import agencia.ETipoAgencia;
import pessoa.ETipoAcesso;

public class Presidente extends Funcionario {

	public Presidente(String nome, String cpf, String senha, String email, String telefone, ETipoAcesso acesso,
			ETipoAgencia idAgencia) {
		super(nome, cpf, senha, email, telefone, acesso, idAgencia);
	}
}
