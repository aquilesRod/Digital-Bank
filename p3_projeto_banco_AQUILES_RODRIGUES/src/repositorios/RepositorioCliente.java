package repositorios;

import java.util.ArrayList;
import java.util.List;

import entities.Cliente;

public class RepositorioCliente implements IRepositorioCliente{
	
	private static RepositorioCliente self;
    private List<Cliente> clientes;

    private RepositorioCliente(){
        clientes = new ArrayList<Cliente>();
//        Cliente cliente1 = new Cliente("joao", "212", "2312", "assk", "ask");
//        clientes.add(cliente1);
    }

    public static IRepositorioCliente getInstance() {
        if (self == null){
            self = new RepositorioCliente();
        }
        return self;
    }

	@Override
	public boolean buscarCliente(String cpf) {
		boolean encontrado = false;
        for (Cliente cliente : clientes) {
        	String otherCpf = cliente.getCpf();
        	if (otherCpf != null) {
        		if (cpf.equals(otherCpf)){
                    encontrado = true;
                }
        	}
        }
        return encontrado;
	}

	@Override
	public void criarCliente(String nome, String cpf, String celular, String email,
			String endereco) {
		Cliente novoCliente = new Cliente(nome, cpf, celular, email, endereco);
		clientes.add(novoCliente);
	}
	
}
