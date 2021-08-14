package aula10;

import java.util.Date;

public class ContaPoupanca extends Conta{
	private Date dataDeposito;
	private Date dataSaque;
	
	public ContaPoupanca(String responsavel, String numero) {
		super(responsavel, numero);
	}
	
	public Date getDataDeposito() {
		return dataDeposito;
	}

	public void setDataDeposito(Date dataDeposito) {
		this.dataDeposito = dataDeposito;
	}

	public Date getDataSaque() {
		return dataSaque;
	}

	public void setDataSaque(Date dataSaque) {
		this.dataSaque = dataSaque;
	}

	@Override
	public void sacar(double valorSacado) {
		
		long dt = (this.dataSaque.getTime() - this.dataDeposito.getTime()) + 3600000;      
        long dias = (dt / 86400000L);  
         
        if (dias < 10) {
        	 System.out.println("Você só poderá sacar apartir de 10 dias após  deposito");
        	 return;
        }
         
		if (valorSacado <= 0) {
			System.out.println("Deve ser informado o valor superior a 0(zero) para saque!");
			return;
		}
		
		if(valorSacado > getSaldo()) {
			System.out.println("Você não têm saldo suficiente!! Seu saldo atual é R$: " + getSaldo());
			return;
		}
		
		setSaldo( getSaldo() - valorSacado);
		System.out.println("Efetuado o saque de R$: " + valorSacado);
		System.out.println("Saldo Atual R$: " + getSaldo());
	}
}
