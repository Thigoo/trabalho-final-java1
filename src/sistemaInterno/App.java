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
		
		List<Pessoa> pessoas = LeitorArquivo.lerPessoas();
		List<Conta> contas = LeitorArquivo.lerContas();
		
		Menus menu = new Menus(leitor, pessoas, contas);
		menu.logar();
		
		leitor.close();
	}
}
