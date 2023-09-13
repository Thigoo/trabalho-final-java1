//package sistemaInterno;
//
//import cliente.Cliente;
//
//public class App {
//
//	public static void main(String[] args) {
//		
////		// System.out.println(calcularRendimentoPoupanca(1000.0, 36500));
////		
////		Cliente c = new Cliente();
////		c.getSeguroVida().contratarSeguroDeVida(100000.0);
////		
////		System.out.println(c.getSeguroVida().isActive());
////		System.out.println(c.getSeguroVida().getValorContratado());
////		System.out.println(c.getSeguroVida().getTributoSeguro());
////		
//	}
//	
////	public static Double calcularRendimentoPoupanca(Double valorDinheiro, Integer numDias) {
////		Double taxaJurosDia = 0.00034;
////		for (int i=0; i<numDias; i++) {
////			valorDinheiro = valorDinheiro * (1 + taxaJurosDia);
////		}
////		return valorDinheiro;
////	}

package sistemaInterno;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import conta.Conta;
import conta.SeguroVida;
import enums.TipoAcessoEnum;
import enums.TipoAgenciaEnum;
import enums.TipoContaEnum;
import menus.Menus;
import pessoa.Cliente;
import pessoa.Pessoa;

public class App {

	public static void main(String[] args) throws FileNotFoundException{

		//Scanner leitor = new Scanner(System.in);

		// ler o arquivo aqui
		FileInputStream arquivo = new FileInputStream(new File("C:\\Users\\alber\\Desktop\\Contas\\Pessoas.txt"));
		
				
		Scanner leitor = new Scanner(arquivo,"UTF-8");
		List<Cliente> clientes = new ArrayList<Cliente>();
		while(leitor.hasNext()) {
			String linha = leitor.nextLine();
			if (linha != null && !linha.isEmpty()) {
				String[] dados = linha.split("\\;");
				
				Pessoa cliente1 = new Cliente();
				cliente1.setCpf(dados[0]);
				cliente1.setEmail(dados[1]);
				cliente1.setNome(dados[2]);
				cliente1.setTelefone(dados[3]);
				clientes.add((Cliente) cliente1);
			}
		}

		//System.out.println("Li o arquivo aqui!");

		//Menus menu = new Menus(Fulano, leitor);
		//menu.logar(conta2);

		// escrever o arquivo aqui
		System.out.println(clientes);

		leitor.close();
		
		
	}

}
