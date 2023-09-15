package io;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import banco.Banco;
import contas.Conta;
import contas.ContaCorrente;
import pessoas.funcionarios.Diretor;

public class escreverDados {

	private static DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd-MM-yy HH-mm-ss");
	private static LocalDateTime data;

	public static void escreverClientes() throws IOException {

		String path = ".//Relatorios//ListaClientes.txt";
		BufferedWriter escritor = new BufferedWriter(new FileWriter(path));

		for (String conta : Banco.getListaCliente().keySet()) {

			escritor.write(Banco.getListaCliente().get(conta).toString());
			escritor.newLine();
		}

		escritor.close();
	}

	public static void escreverFuncionarios() throws IOException {

		String path = ".//Relatorios//ListaFuncionarios.txt";
		BufferedWriter escritor = new BufferedWriter(new FileWriter(path));

		for (String func : Banco.getListaFuncionarios().keySet()) {

			escritor.write(Banco.getListaFuncionarios().get(func).toString());
			escritor.newLine();
		}

		escritor.close();
	}

	public static void escreverAgencias() throws IOException {

		String path = ".//Relatorios//Agencias.txt";
		BufferedWriter escritor = new BufferedWriter(new FileWriter(path));

		for (int numAgencia : Banco.getListaAgencias().keySet()) {

			escritor.write(Banco.getListaAgencias().get(numAgencia).toString());
			escritor.newLine();
		}

		escritor.close();
	}

	public static void listaTransacoes(Conta contaLogada) throws IOException {

		String path = ".//Relatorios//Extratos/Extrato_" + contaLogada.getTitular().getNome() + "_"
				+ dtf.format(LocalDateTime.now()) + ".txt";
		BufferedWriter escritor = new BufferedWriter(new FileWriter(path));
		escritor.write(contaLogada.tirarExtratoArquivo());
		escritor.newLine();
		escritor.close();

	}

	public static void gerarRelatorioTaxas(Conta contaLogada) throws IOException {

		String path = ".//Relatorios//Taxas/Taxa_" + contaLogada.getTitular().getNome() + "_"
				+ dtf.format(LocalDateTime.now()) + ".txt";

		BufferedWriter escritor = new BufferedWriter(new FileWriter(path));

		escritor.write(((ContaCorrente) (contaLogada)).tirarRelatorioTaxasArquivo());
		escritor.newLine();
		escritor.close();
	}

	public static void gerarRelatorioClientesDiretor() throws IOException {

		String path = ".//Relatorios//" + dtf.format(LocalDateTime.now()) + " RelatorioContasDiretor.txt";
		BufferedWriter escritor = new BufferedWriter(new FileWriter(path));
		escritor.write(Diretor.gerarRelatorioInfoClientesArquivo());
		escritor.newLine();
		escritor.close();
	}
}
