package sistemaInterno;

import java.io.FileNotFoundException;
import java.util.List;
import java.util.Scanner;

import conta.Conta;
import io.LeitorArquivo;
import menus.Menus;
import pessoa.Pessoa;

public class App {

	public static void main(String[] args) throws FileNotFoundException{
		Scanner leitor = new Scanner(System.in);
		
//		LeitorArquivo leitorArquivo = new LeitorArquivo();
//		leitorArquivo.carregarDados();
		
		List<Pessoa> pessoas = LeitorArquivo.lerPessoas();
		List<Conta> contas = LeitorArquivo.lerContas();
		//Gerente pessoa = (Gerente) lerPessoas.get(0);
		//pessoa.getTipoCargo();

		Menus menu = new Menus(leitor, pessoas, contas);
		menu.logar();
		
		leitor.close();
	}
}
