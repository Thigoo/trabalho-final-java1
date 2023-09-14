package pessoa;

import enums.TipoAcessoEnum;

public class Diretor extends Funcionario {
	
	// CONSTRUTOR
	public Diretor() {
		
	}

	public Diretor(TipoAcessoEnum acesso, String cpf, String senha, String nome, String email, String telefone,
			String idAgencia) {
		super(acesso, cpf, senha, nome, email, telefone, idAgencia);
	}

	// CLASSE ABSTRATA PESSOA
	@Override
	public void add(Pessoa cliente) {
			
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
