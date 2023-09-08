package sistemaInterno;

import java.util.Scanner;

public class App {

	public static void main(String[] args) {
		logar();
	}

	public static void logar() {

		Scanner leitor = new Scanner(System.in);
		int opcao;
		long cpf;
		String senha, s;

		System.out.println("****************************************************");
		System.out.println("******** Bem vindo(a) ao banco Bancursinho *********");
		System.out.println("****************************************************");
		System.out.println("                   ▄▄      ▄▄▄▄                     ");
		System.out.println("                 ▐▀▀▄█▀▀▀▀▀▒▄▒▀▌                    ");
		System.out.println("                 ▐▒█▀▒▒▒▒▒▒▒▒▀█                     ");
		System.out.println("                  █▒▒▒▒▒▒▒▒▒▒▒▀▌                    ");
		System.out.println("                  ▌▒██▒▒▒▒██▒▒▒▐                    ");
		System.out.println("                  ▌▒▒▄▒██▒▄▄▒▒▒▐                    ");
		System.out.println("                 ▐▒▒▒▀▄█▀█▄▀▒▒▒▒█▄                  ");
		System.out.println("                 ▀█▄▒▒▐▐▄▌▌▒▒▄▐▄▐                   ");
		System.out.println("                ▄▀▒▒▄▒▒▀▀▀▒▒▒▒▀▒▀▄                  ");
		System.out.println("                █▒▀█▀▌▒▒▒▒▒▄▄▄▐▒▒▐                  ");
		System.out.println("                 ▀▄▄▌▌▒▒▒▒▐▒▒▒▀▒▒▐                  ");
		System.out.println("                     ▐▌▒▒▒▒▀▄▄▄▄▄▀                  ");
		System.out.println("                      ▐▄▒▒▒▒▒▒▒▒▐                   ");
		System.out.println("                      ▌▒▒▒▒▄▄▒▒▒▐                   ");
		System.out.println("****************************************************");

		System.out.println("O que deseja fazer?");
		System.out.println("1 - Logar \n2 - Abertura de conta");

		System.out.print("Escolha: ");
		opcao = leitor.nextInt();

		switch (opcao) {

		case 1:
			System.out.print("\nPor favor, digite seu cpf: ");
			cpf = leitor.nextLong();

			System.out.print("Digite sua senha: ");
			senha = leitor.next();

			if (cpf != 0 && senha != "") {
				System.out.println("\nLogin efetuado com sucesso!");
			} else {
				System.out.println("Os dados não conferem, tente novamente.");
			}

			imprimirMenu();

			break;

		case 2:

			System.out.println("\nOk, preencha os dados para abrir sua conta.");
			System.out.print("Qual o seu cpf? ");
			cpf = leitor.nextLong();

			System.out.print("Crie uma senha: ");
			s = leitor.nextLine();

			System.out.print("Confirme sua senha: ");
			senha = leitor.nextLine();

			if (s != senha) {
				System.out.println("As senhas não conferem, tente novamente.");
			} else {
				System.out.println("Conta criada com sucesso! Bem vindo(a) ao banco Bancursinho");
			}

			imprimirMenu();

			break;

		default:
			System.out.println("Opção inválida. Tente novamente!");

			break;

		}
		leitor.close();
	}

	public static void imprimirMenu() {

		Scanner leitor = new Scanner(System.in);
		int opcaoMenu, opcaoMov;

		System.out.println("\n****************  Menu  *****************\n");
		System.out.println("1 - Movimentações na conta \n2 - Relatórios");

		System.out.print("Escolha: ");
		opcaoMenu = leitor.nextInt();

		switch (opcaoMenu) {

		case 1:

			System.out.println("\n1 - Saldo \n2 - Depósito \n3 - Transferência para outra conta");
			System.out.print("Escolha: ");
			opcaoMov = leitor.nextInt();

			switch (opcaoMov) {

			case 1:
				System.out.println("Mostrar saldo.");
				break;

			case 2:
				System.out.println("Mostrar depósito.");
				break;

			case 3:
				System.out.println("Fazer transferência.");
			}

		default:
			System.out.println("Opção inválida!");
			break;
		}

		leitor.close();
	}
}
