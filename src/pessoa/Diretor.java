package pessoa;

import enums.TipoAgenciaEnum;
import enums.TipoCargoEnum;

public class Diretor extends Funcionario {

	public Diretor(TipoAgenciaEnum tipoAgencia, TipoCargoEnum tipoCargoEnum, String cpf, String senha, String nome,
			String email, String telefone) {
		super(tipoAgencia, tipoCargoEnum, cpf, senha, nome, email, telefone);
	}

	
	
	/* 
	    DESAFIO DIRETOR
	    COLOCAR OS CLIENTES EM ORDEM ALFABETICA
	    List<Aluno> cloned_list = new ArrayList<Aluno>(alunos);
		Collections.sort(cloned_list);//se puder alterar a lista origal so alterar o clone_liste pelo nome da lista alunos
		System.out.println(alunos);
		System.out.println(cloned_list);
	 */
}
