package entities;

import ui.util.exceptions.SaldoInsuficienteException;

public abstract class Conta {
	
	private int numeroConta;
	private int numAgencia;
	private float saldo;
	private String cpfDono, senhaDeAcesso;
	
	public Conta(int numConta, String cpfDono, String senhaDeAcesso, int numAgencia) {
		this.numeroConta = numConta;
		this.saldo = 0;
		this.cpfDono = cpfDono;
		this.senhaDeAcesso = senhaDeAcesso;
		this.numAgencia = numAgencia;
	}
	
	public void transferir(float quantia) throws SaldoInsuficienteException{
		if (this.saldo > quantia){
            this.saldo = this.saldo - quantia;
        } else {
            throw new SaldoInsuficienteException();
        }
	}
	
	public void depositar(float quantia) {
		this.saldo = this.saldo + quantia;
	}
	
	public void sacar(float quantia) throws SaldoInsuficienteException{
		if (this.saldo > quantia){
            this.saldo = this.saldo - quantia;
        } else {
            throw new SaldoInsuficienteException();
        }
	}

	public int getNumeroConta() {
		return this.numeroConta;
	}

	public int getNumeroAgencia() {
		return this.numAgencia;
	}

	public float getSaldo() {
		return this.saldo;
	}

	protected void setSaldo(float saldo) {
		this.saldo = saldo;
	}

	public String getCpfDono() {
		return cpfDono;
	}
	
	public String getSenhaDeAcesso() {
		return senhaDeAcesso;
	}

	public void setSenhaDeAcesso(String senhaDeAcesso) {
		this.senhaDeAcesso = senhaDeAcesso;
	}
	
}
