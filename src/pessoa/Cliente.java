package pessoa;

import conta.SeguroVida;
import enums.TipoAcessoEnum;
import enums.TipoAgenciaEnum;

public class Cliente extends Pessoa {	

	public Cliente() {
		super();
	}

	

	public Cliente(String nome, String cpf, String email, String telefone, TipoAcessoEnum acesso,
			TipoAgenciaEnum idAgencia) {
		super(nome, cpf, email, telefone, acesso, idAgencia);
		this.seguroVida = seguroVida;
	}



	private SeguroVida seguroVida = new SeguroVida();
	
	public SeguroVida getSeguroVida() {
		return seguroVida;
	}
}
