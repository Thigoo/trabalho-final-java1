package pessoa;

import enums.TipoAcessoEnum;

public class Gerente extends Funcionario {

	// CONSTRUTOR
	public Gerente() {

	}

	public Gerente(TipoAcessoEnum acesso, String cpf, String senha, String nome, String email, String telefone,
			String idAgencia) {
		super(acesso, cpf, senha, nome, email, telefone, idAgencia);
		// TODO Auto-generated constructor stub
	}

	// CLASSE ABSTRATA PESSOA
	@Override
	public void add(Pessoa cliente) {

	}
	
// DESAFIO GERENTE
//	public static List<Conta> totalContas(List<Conta> contas, 
//			ETipoAgencia tipoAgencia) {
//
//		List<Conta> listaContas = new ArrayList<Conta>();
//		
//		for (int i = 0; i < contas.size(); i++) {
//			
//			if (contas.get(i).getIdAgencia().getIdAgencia() == tipoAgencia.getIdAgencia()) {
//				listaContas.add(contas.get(i));
//			}
//		}
//		
//		return listaContas;
//	}
}
