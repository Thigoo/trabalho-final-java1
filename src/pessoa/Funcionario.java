package pessoa;

import enums.TipoAcessoEnum;

public abstract class Funcionario extends Pessoa {
	
	// CONSTRUTOR
	public Funcionario() {
		
	}
	
	public Funcionario(TipoAcessoEnum acesso,String cpf, String senha, String nome, String email, String telefone,
			String idAgencia) {
		super(acesso, cpf, senha, nome, email, telefone, idAgencia);
	}
}
