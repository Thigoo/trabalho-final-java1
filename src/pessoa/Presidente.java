package pessoa;

import enums.TipoAgenciaEnum;
import enums.TipoCargoEnum;

public class Presidente extends Funcionario {

	public Presidente(TipoAgenciaEnum tipoAgencia, TipoCargoEnum tipoCargoEnum, String cpf, String senha, String nome,
			String email, String telefone) {
		super(tipoAgencia, tipoCargoEnum, cpf, senha, nome, email, telefone);
		// TODO Auto-generated constructor stub
	}

}
