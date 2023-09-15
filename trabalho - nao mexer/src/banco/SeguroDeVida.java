package banco;

import java.util.Scanner;

import contas.Conta;
import contas.ContaCorrente;

public abstract class SeguroDeVida {

	public static void contratarSeguro(Conta conta) {

		Scanner leitor = new Scanner(System.in);

		System.out.println("\n****************** CONTRATAR SEGURO ****************");
		System.out.print("\nValor a ser segurado: R$ ");
		double valor = leitor.nextDouble();

		double entrada = valor * 0.2;

		if (conta.getSaldo() > entrada) {

			conta.setSaldo(conta.getSaldo() - entrada);
			((ContaCorrente) (conta)).setPossuiSeguro(true);
			((ContaCorrente) (conta)).setValorSeguro(valor);
			System.out.println("Seguro no valor de R$" + valor + " contratado com sucesso!\n");
		
		} else {
			System.out.println("Saldo insuficiente para contratar o seguro!\n");
		}
	}
}
