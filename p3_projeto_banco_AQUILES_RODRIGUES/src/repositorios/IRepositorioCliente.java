package repositorios;

public interface IRepositorioCliente {

	boolean buscarCliente(String cpf);

	void criarCliente(String nome, String cpf, String celular, String email, 
			String endereco);

}
