package io;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import conta.ContaCorrente;
import conta.ContaPoupanca;
import enums.TipoAcessoEnum;
import pessoa.Cliente;
import pessoa.Diretor;
import pessoa.Gerente;
import pessoa.Pessoa;
import pessoa.Presidente;

public class InputOutput {
	
	private FileInputStream arquivo;
	private Scanner leitor;

	public FileInputStream leitor() throws FileNotFoundException {
		
		this.arquivo = new FileInputStream(new File("pessoas.txt"));
		
		this.leitor = new Scanner(arquivo,"UTF-8");
		Map<String, Cliente> clientes = new HashMap<>();
		Map<String, ContaCorrente> contasCorrente = new HashMap<>();
		Map<String, ContaPoupanca> contasPoupanca = new HashMap<>();
		Map<String, Gerente> gerentes = new HashMap<>();
		Map<String, Presidente> presidentes = new HashMap<>();
		Map<String, Diretor> diretores = new HashMap<>();
		
		while(this.leitor.hasNext()) {
			String linha = this.leitor.nextLine();
			if (linha != null && !linha.isEmpty()) {
				String[] dados = linha.split(";");
				
			
				
			for(int i = 0; i < dados.length; i++) {
				if(dados[0].equals(TipoAcessoEnum.CLIENTE)) {					
					
					Pessoa cliente = new Cliente();
					cliente.setCpf(dados[1]);
					cliente.setSenha(dados[2]);
					cliente.setNome(dados[3]);
					cliente.setEmail(dados[4]);
					cliente.setTelefone(dados[5]);
					cliente.setIdAgencia(dados[6]);		
					
				} else if(dados[0].equals(TipoAcessoEnum.GERENTE)) {					
					
					Pessoa gerente = new Gerente();
					gerente.setCpf(dados[1]);
					gerente.setSenha(dados[2]);
					gerente.setNome(dados[3]);
					gerente.setEmail(dados[4]);
					gerente.setTelefone(dados[5]);
					gerente.setIdAgencia(dados[6]);
					
				} else if(dados[0].equals(TipoAcessoEnum.DIRETOR)) {					
					
					Pessoa diretor = new Diretor();
					diretor.setCpf(dados[1]);
					diretor.setSenha(dados[2]);
					diretor.setNome(dados[3]);
					diretor.setEmail(dados[4]);
					diretor.setTelefone(dados[5]);
					diretor.setIdAgencia(dados[6]);	
					
				} else if(dados[0].equals(TipoAcessoEnum.PRESIDENTE)) {					
					
					Presidente presidente = new Presidente();
					presidente.setCpf(dados[1]);
					presidente.setSenha(dados[2]);
					presidente.setNome(dados[3]);
					presidente.setEmail(dados[4]);
					presidente.setTelefone(dados[5]);
					presidente.setIdAgencia(dados[6]);				
				} 
			}
			}
			
		}
		return this.arquivo;
	}

	
	
}
