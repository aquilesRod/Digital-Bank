package fachada;

import controller.*;
import ui.util.exceptions.*;

public class Fachada implements IFachada{
	
	ContaCorrenteController correnteC;
	ContaPoupancaController poupancaC;
	ClienteController clienteC;
	AgenciaController agenciaC;
	
	public Fachada() {
		correnteC = new ContaCorrenteController();
		poupancaC = new ContaPoupancaController();
		clienteC = new ClienteController();
		agenciaC = new AgenciaController();
	}
	
	@Override
	public boolean buscarContaCorrente(int numConta) {
		return correnteC.buscar(numConta);
	}
	@Override
	public boolean buscarContaPoupanca(int numConta) {
		return poupancaC.buscar(numConta);
	}
	@Override
	public void transferirContaCorrente(int numConta, int numContaDest, float quantia) throws SaldoInsuficienteException {
		correnteC.transferir(numConta, numContaDest, quantia);
	}
	@Override
	public void transferirContaPoupanca(int numConta, int numContaDest, float quantia) throws SaldoInsuficienteException {
		poupancaC.transferir(numConta, numContaDest, quantia);
	}
	@Override
	public void depositarContaCorrente(int numConta, float quantia) {
		correnteC.depositar(numConta, quantia);
	}
	@Override
	public void depositarContaPoupanca(int numConta, float quantia) {
		poupancaC.depositar(numConta, quantia);
	}
	@Override
	public void sacarContaCorrente(int numConta, float quantia) 
			throws SaldoInsuficienteException {
		correnteC.sacar(numConta, quantia);
	}
	@Override
	public void sacarContaPoupanca(int numConta, float quantia)
			throws SaldoInsuficienteException {
		poupancaC.sacar(numConta, quantia);
	}
	@Override
	public float saldoContaCorrente(int numConta) {
		return correnteC.getSaldo(numConta);
	}
	@Override
	public float saldoContaPoupanca(int numConta) {
		return poupancaC.getSaldo(numConta);
	}
	@Override
	public boolean buscarChavePixContaCorrente(String chavePix) {
		return correnteC.buscarChavePix(chavePix);
	}
	@Override
	public boolean buscarChavePixContaPoupanca(String chavePix) {
		return poupancaC.buscarChavePix(chavePix);
	}
	@Override
	public void transferenciaPixContaCorrente(int numConta, String chavePix, float quantia) throws SaldoInsuficienteException {
		correnteC.transferenciaPix(numConta, chavePix, quantia);
	}
	@Override
	public void transferenciaPixContaPoupanca(int numConta, String chavePix, float quantia) throws SaldoInsuficienteException {
		poupancaC.transferenciaPix(numConta, chavePix, quantia);
	}
	@Override
	public void cadastrarChavePixContaCorrente(int numConta, String chavePix) {
		correnteC.cadastrarChavePix(numConta, chavePix);
	}
	@Override
	public void cadastrarChavePixContaPoupanca(int numConta, String chavePix) {
		poupancaC.cadastrarChavePix(numConta, chavePix);
	}
	@Override
	public void removerChavePixContaCorrente(int numConta, String chavePix) {
		correnteC.removerChavePix(numConta, chavePix);
	}
	@Override
	public void removerChavePixContaPoupanca(int numConta, String chavePix) {
		poupancaC.removerChavePix(numConta, chavePix);
	}
	@Override
	public String getChavePixContaCorrente(int numConta) {
		return correnteC.getChavePix(numConta);
	}
	@Override
	public String getChavePixContaPoupanca(int numConta) {
		return poupancaC.getChavePix(numConta);
	}
	@Override
	public int criarContaCorrente(String cpf, String senha, int numAgencia) {
		return correnteC.criarConta(cpf, senha, numAgencia);
	}
	@Override
	public int criarContaPoupanca(String cpf, String senha, int numAgencia) {
		return poupancaC.criarConta(cpf, senha, numAgencia);
	}
	
	
	//ClienteController
	
	@Override
	public boolean buscarCliente(String cpf) {
		return clienteC.buscarCliente(cpf);
	}
	@Override
	public void criarCliente(String nome, String cpf, String celular, String email,
			String endereco) {
		clienteC.criarCliente(nome, cpf, celular, email, endereco);
	}
	@Override
	public boolean verificarSenhaContaCorrente(int numConta, String senha) {
		return correnteC.verificarSenha(numConta, senha);
	}
	@Override
	public boolean verificarSenhaContaPoupanca(int numConta, String senha) {
		return poupancaC.verificarSenha(numConta, senha);
	}
	
	//AgenciaController
	
	@Override
	public boolean buscarAgencia(int numAgencia) {
		return agenciaC.buscarAgencia(numAgencia);
	}
	@Override
	public void criarAgencia(int numAgencia, String endereco) {
		agenciaC.criarAgencia(numAgencia, endereco);
	}
	
}
