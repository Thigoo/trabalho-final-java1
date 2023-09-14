package io;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import pessoa.Cliente;
import pessoa.Pessoa;

public class InputOutput {
	
	private FileInputStream arquivo;
	private Scanner leitor;

	public FileInputStream leitor() throws FileNotFoundException {
		
		this.arquivo = new FileInputStream(new File("src\\arquivos\\pessoas.txt"));
		
		this.leitor = new Scanner(arquivo,"UTF-8");
		List<Cliente> clientes = new ArrayList<Cliente>();
		
		while(this.leitor.hasNext()) {
			String linha = this.leitor.nextLine();
			if (linha != null && !linha.isEmpty()) {
				String[] dados = linha.split(";");
				
				Pessoa cliente1 = new Cliente();
				cliente1.setCpf(dados[0]);
				cliente1.setEmail(dados[1]);
				cliente1.setNome(dados[2]);
				cliente1.setTelefone(dados[3]);
				clientes.add((Cliente) cliente1);
			}
			
		}
		return this.arquivo;
	}
	
}
