package aula10;

public class Conta {
	
	private String responsavel;
	private String numero;
	private double saldo;
	
	public Conta(String responsavel, String numero) {
		this.responsavel = responsavel;
		this.numero = numero;
		
	}
	
	public double getSaldo() {
		return saldo;
	}

	public void setSaldo(double saldo) {
		this.saldo = saldo;
	}

	public void sacar(double valorSacado) {
		if (valorSacado <= 0) {
			System.out.println("Deve ser informado o valor superior a 0(zero) para saque!");
			return;
		}
		
		if(valorSacado > this.saldo) {
			System.out.println("Você não têm saldo suficiente!! Seu saldo atual é R$: " + this.saldo);
			return;
		}
		
		this.saldo = this.saldo - valorSacado;
		System.out.println("Efetuado o saque de R$: " + valorSacado);
		System.out.println("Saldo Atual R$: " + this.saldo);
	}
	
	public void depositar(double valorDeposito) {
		if (valorDeposito <= 0) {
			System.out.println("Deve ser informado o valor superior a 0(zero) para depósito!");
			return;
		}
		this.saldo = this.saldo + valorDeposito;
		System.out.println("Efetuado depósito de R$: " + valorDeposito);
		System.out.println("Saldo Atual R$:  " + this.saldo);
	}

	@Override
	public String toString() {
		return "responsavel = " + this.responsavel + " Nº Conta: " + this.numero + " Saldo R$: " + this.saldo;
	}
}