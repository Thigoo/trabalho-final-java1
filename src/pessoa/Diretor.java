package pessoa;

import enums.TipoAcessoEnum;
import enums.TipoAgenciaEnum;

public class Diretor extends Funcionario {
	
	public Diretor() {
		
	}

	public Diretor(TipoAcessoEnum acesso, String cpf, String senha, String nome, String email, String telefone,
			String idAgencia) {
		super(acesso, cpf, senha, nome, email, telefone, idAgencia);
	}

	
}
