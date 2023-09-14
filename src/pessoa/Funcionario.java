package pessoa;

import enums.TipoAcessoEnum;
import enums.TipoAgenciaEnum;

public abstract class Funcionario extends Pessoa {

	
	
	public Funcionario(String nome, String cpf, String email, String telefone, TipoAcessoEnum acesso,
			TipoAgenciaEnum idAgencia) {
		super(nome, cpf, email, telefone, acesso, idAgencia);
	}
}
