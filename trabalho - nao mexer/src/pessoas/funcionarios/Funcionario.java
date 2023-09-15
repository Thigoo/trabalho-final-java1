package pessoas.funcionarios;

import banco.Banco;
import pessoas.Pessoa;

public abstract class Funcionario extends Pessoa{

	protected Funcionario(String nome, String cpf, int senha) {
		super(nome, cpf, senha);
	}

	@Override
	public String toString() {
		return "Funcionario," + nome + "," + cpf + "," + senha + ",";
	}

}
	
	
