package sistemaInterno;

import java.io.FileNotFoundException;
import java.util.Scanner;

import io.InputOutput;

public class App {

	public static void main(String[] args) throws FileNotFoundException{

		Scanner leitor = new Scanner(System.in);

		// ler o arquivo aqui!!!!!!!!!!!!!!!!!!!!!!!
		
		InputOutput io = new InputOutput();
		
		io.leitor();

		// escrever o arquivo aqui!!!!!!!!!!!!!!!!!!

		leitor.close();
	}
}
