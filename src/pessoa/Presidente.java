package pessoa;

import enums.TipoAcessoEnum;
import enums.TipoAgenciaEnum;

public class Presidente extends Funcionario {
	
	// CONSTRUCTOR
	public Presidente() {
		
	}

	public Presidente(TipoAcessoEnum acesso,String cpf,  String senha, String nome, String email, String telefone,
			String idAgencia) {
		super(acesso, cpf, senha, nome, email, telefone, idAgencia);
	}

	// CLASSE ABSTRATA PESSOA
	@Override
	public void add(Pessoa cliente) {
		// TODO Auto-generated method stub
		
	}
}
