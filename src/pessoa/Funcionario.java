package pessoa;

import enums.TipoAcessoEnum;
import enums.TipoAgenciaEnum;

public abstract class Funcionario extends Pessoa {

	
	
	public Funcionario(String nome, String cpf, String senha, String email, String telefone, TipoAcessoEnum acesso,
			TipoAgenciaEnum idAgencia) {
		super(nome, cpf, senha, email, telefone, acesso, idAgencia);
	}
}
