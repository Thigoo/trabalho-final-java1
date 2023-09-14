package pessoa;

import conta.SeguroVida;
import enums.TipoAcessoEnum;
import enums.TipoAgenciaEnum;

public class Cliente extends Pessoa {	
	
	public Cliente() {
		
	}	

	public Cliente(enums.TipoAcessoEnum acesso, String cpf, String senha, String nome, String email, String telefone,
			String idAgencia) {
		super(acesso, cpf, senha, nome, email, telefone, idAgencia);
	}



	private SeguroVida seguroVida = new SeguroVida();
	
	public SeguroVida getSeguroVida() {
		return seguroVida;
	}
		


	@Override
	public String toString() {
		return "\nCliente [cpf=" + cpf + ", email=" + email + ", nome=" + nome + ", telefone=" + telefone + "]";
	}

	public String TipoAcessoEnum(String string) {
		return null;
	}

	public String setSenha(String string) {
		// TODO Auto-generated method stub
		return null;
	}

}
