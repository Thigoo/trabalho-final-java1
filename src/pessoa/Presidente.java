package pessoa;

import enums.TipoAcessoEnum;
import enums.TipoAgenciaEnum;

public class Presidente extends Funcionario {

	public Presidente(String nome, String cpf, String senha, String email, String telefone, TipoAcessoEnum acesso,
			TipoAgenciaEnum idAgencia) {
		super(nome, cpf, senha, email, telefone, acesso, idAgencia);
	}
}
