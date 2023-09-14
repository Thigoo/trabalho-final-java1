package pessoa;

import enums.TipoAcessoEnum;
import enums.TipoAgenciaEnum;

public class Diretor extends Funcionario {

	public Diretor(String nome, String cpf, String email, String telefone, TipoAcessoEnum acesso,
			TipoAgenciaEnum idAgencia) {
		super(nome, cpf, email, telefone, acesso, idAgencia);
	}
}
