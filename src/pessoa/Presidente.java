package pessoa;

import enums.TipoAgenciaEnum;
import enums.TipoCargoEnum;

public class Presidente extends Funcionario { // ESTENDE DE FUNCIONARIO

	// CONSTRUTOR 
	public Presidente(TipoAgenciaEnum tipoAgencia, TipoCargoEnum tipoCargoEnum, String cpf, String senha, String nome,
			String email, String telefone) {
		super(tipoAgencia, tipoCargoEnum, cpf, senha, nome, email, telefone);
		
	}

}
