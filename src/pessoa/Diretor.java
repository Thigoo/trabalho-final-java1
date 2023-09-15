package pessoa;

import enums.TipoAgenciaEnum;
import enums.TipoCargoEnum;

public class Diretor extends Funcionario { // ESTENDE DE FUNCIONARIO

	// CONSTRUTOR 
	public Diretor(TipoAgenciaEnum tipoAgencia, TipoCargoEnum tipoCargoEnum, String cpf, String senha, String nome,
			String email, String telefone) {
		super(tipoAgencia, tipoCargoEnum, cpf, senha, nome, email, telefone);
	
	}
}
