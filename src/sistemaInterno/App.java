package sistemaInterno;

import java.awt.Menu;
import java.io.FileNotFoundException;
import java.util.Scanner;

import io.InputOutput;
import menus.Menus;
import pessoa.Gerente;

public class App {

	public static void main(String[] args) throws FileNotFoundException{

		Scanner leitor = new Scanner(System.in);

		// ler o arquivo aqui!!!!!!!!!!!!!!!!!!!!!!!
		
		//InputOutput io = new InputOutput();
		
		//io.leitor();

		Menus menu = new Menus();
		menu.logar();
		
		System.out.println("Hello");

		// escrever o arquivo aqui!!!!!!!!!!!!!!!!!!

		leitor.close();
	}
}
