package pessoa;

import enums.TipoAcessoEnum;
import enums.TipoAgenciaEnum;

public class Gerente extends Funcionario {	

	public Gerente(String nome, String cpf, String senha, String email, String telefone, TipoAcessoEnum acesso,
			TipoAgenciaEnum idAgencia) {
		super(nome, cpf, senha, email, telefone, acesso, idAgencia);
	}
	
	
}
