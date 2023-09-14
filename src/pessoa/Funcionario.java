package pessoa;

import enums.TipoAcessoEnum;
import enums.TipoAgenciaEnum;

public abstract class Funcionario extends Pessoa {
	public Funcionario() {
		
	}
	
	public Funcionario(TipoAcessoEnum acesso,String cpf, String senha, String nome, String email, String telefone,
			String idAgencia) {
		super(acesso, cpf, senha, nome, email, telefone, idAgencia);
	}
}
