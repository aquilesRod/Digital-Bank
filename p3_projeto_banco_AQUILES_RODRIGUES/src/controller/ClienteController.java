package controller;

import repositorios.IRepositorioCliente;
import repositorios.RepositorioCliente;

public class ClienteController {
	
	private IRepositorioCliente rep = RepositorioCliente.getInstance();
	
	public boolean buscarCliente(String cpf) {
		return rep.buscarCliente(cpf);
	}

	public void criarCliente(String nome, String cpf, String celular, String email,
			String endereco) {
		rep.criarCliente(nome, cpf, celular, email, endereco);
	}
	
}
