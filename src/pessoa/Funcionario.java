package pessoa;

import enums.TipoAgenciaEnum;
import enums.TipoCargoEnum;

public abstract class Funcionario extends Pessoa {
	
	protected TipoAgenciaEnum tipoAgencia;
	
	// CONSTRUTOR
	public Funcionario(TipoAgenciaEnum tipoAgencia, TipoCargoEnum tipoCargoEnum, String cpf, String senha, String nome, String email, String telefone) {
		super(cpf, senha, nome, email, telefone, tipoCargoEnum);
		this.tipoCargo = tipoCargoEnum;
		this.tipoAgencia = tipoAgencia;
	}

	public TipoAgenciaEnum getTipoAgencia() {
		return tipoAgencia;
	}

	public void setTipoAgencia(TipoAgenciaEnum tipoAgencia) {
		this.tipoAgencia = tipoAgencia;
	}

	@Override
	public String toString() {
		return "Funcionario [tipoCargo=" + tipoCargo + ", tipoAgencia=" + tipoAgencia + ", nome=" + nome + ", senha="
				+ senha + ", cpf=" + cpf + ", email=" + email + ", telefone=" + telefone + ", dataCadastro="
				+ dataCadastro + "]";
	}
	
}
