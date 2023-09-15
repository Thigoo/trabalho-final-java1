package pessoa;

import enums.TipoAgenciaEnum;
import enums.TipoCargoEnum;

public class Gerente extends Funcionario {

	public Gerente(TipoAgenciaEnum tipoAgencia, TipoCargoEnum tipoCargoEnum, String cpf, String senha, String nome,
			String email, String telefone) {
		super(tipoAgencia, tipoCargoEnum, cpf, senha, nome, email, telefone);
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
