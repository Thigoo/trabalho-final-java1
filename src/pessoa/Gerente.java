package pessoa;

import conta.Conta;
import enums.TipoAcessoEnum;
import enums.TipoAgenciaEnum;
//import menus.ArrayList;
//import menus.ETipoAgencia;
//import menus.List;

public class Gerente extends Funcionario {	

	public Gerente(String nome, String cpf, String email, String telefone, TipoAcessoEnum acesso,
			TipoAgenciaEnum idAgencia) {
		super(nome, cpf, email, telefone, acesso, idAgencia);
	}
// PESQUISAR ARRAYLIST E ARQUIVO	
//	public static List<Conta> totalContas(List<Conta> contas, ETipoAgencia tipoAgencia) {
//		List<Conta> listaContas = new ArrayList<Conta>();
//		for (int i = 0; i < contas.size(); i++) {
//			if (contas.get(i).getIdAgencia().getIdAgencia() == tipoAgencia.getIdAgencia()) {
//				listaContas.add(contas.get(i));
//			}
//		}
//		return listaContas;
}
