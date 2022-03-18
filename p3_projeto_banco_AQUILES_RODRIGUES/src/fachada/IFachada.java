package fachada;

import ui.util.exceptions.SaldoInsuficienteException;

public interface IFachada {
	
	//operacoes da conta (pix tambem)
	public boolean buscarContaCorrente(int numConta);

	public boolean buscarContaPoupanca(int numConta);

	public void transferirContaCorrente(int numConta, int numContaDestino, float quantia) throws SaldoInsuficienteException;

	public void transferirContaPoupanca(int numConta, int numContaDestino, float quantia) throws SaldoInsuficienteException;

	public void depositarContaCorrente(int numConta, float quantia);

	public void depositarContaPoupanca(int numConta, float quantia);

	public void sacarContaCorrente(int numConta, float quantia) throws SaldoInsuficienteException;

	public void sacarContaPoupanca(int numConta, float quantia) throws SaldoInsuficienteException;

	public float saldoContaCorrente(int numConta);

	public float saldoContaPoupanca(int numConta);
	
	public boolean buscarChavePixContaCorrente(String chavePix);
	
	public boolean buscarChavePixContaPoupanca(String chavePix);
	
	public void transferenciaPixContaCorrente(int numConta, String chavePix, float quantia) throws SaldoInsuficienteException;
	
	public void transferenciaPixContaPoupanca(int numConta, String chavePix, float quantia) throws SaldoInsuficienteException;
	
	public void cadastrarChavePixContaCorrente(int numConta, String chavePix);
	
	public void cadastrarChavePixContaPoupanca(int numConta, String chavePix);
	
	public void removerChavePixContaCorrente(int numConta, String chavePix);
	
	public void removerChavePixContaPoupanca(int numConta, String chavePix);
	
	public String getChavePixContaCorrente(int numConta);
	
	public String getChavePixContaPoupanca(int numConta);
	
	public boolean verificarSenhaContaCorrente(int numConta, String senha);

	public boolean verificarSenhaContaPoupanca(int numConta, String senha);
	
	//operacoes do cadastro
	public int criarContaCorrente(String cpf, String senha, int numConta);
	
	public int criarContaPoupanca(String cpf, String senha, int numConta);
	
	void criarCliente(String nome, String cpf, String celular, String email, String endereco);
	
	public boolean buscarCliente(String cpf);
	
	//operacoes da agencia
	public boolean buscarAgencia(int numAgencia);
    
    public void criarAgencia(int numAgencia, String endereco);

}
