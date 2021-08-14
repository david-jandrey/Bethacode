package aula10;

import java.util.Scanner;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ContasFactory {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		System.out.println("Bem vindo ao Banco BethaCode");
		System.out.println("Que tipo de conta você deseja criar ? Poupança 1 / Corrente 2 ");
		int tipo = sc.nextInt();
		
		if (tipo == 1 ) {
						
			System.out.print("Informe o seu nome: ");
			String nomePessoa = sc.next();
			System.out.print("Número da Conta: ");
			String numeroConta = sc.next();
			ContaPoupanca contaPoupanca = new ContaPoupanca(nomePessoa, numeroConta);
			
			int opcao;
			
			do {
				System.out.println("Menu de Opções do Banco BethaCode");
				System.out.println("1 - Sacar");
				System.out.println("2 - Depositar");
				System.out.println("3 - Dados da Conta");
				System.out.println("0 - Encerrar Programa");
				System.out.print("Informa a sua opção: ");
				opcao = sc.nextInt();
				
				if (opcao == 1) {					
					System.out.print("Informe o valor a ser sacado R$: ");
					double saque = sc.nextDouble();
					
					System.out.print("Informe a data do saque: ");
					String data = sc.next();
					
					try {
					    SimpleDateFormat f = new SimpleDateFormat("dd/MM/yyyy");
					    Date format = f.parse(data);
					    contaPoupanca.setDataSaque(format);
						contaPoupanca.sacar(saque);
					} catch ( ParseException exc ) {
					    System.out.println( "data informada em formato errado!" );
					}
				}else if (opcao == 2) {
					System.out.print("Informe o valor a ser depositado R$: ");
					double deposito = sc.nextDouble();
					
					System.out.print("Informe a data do saque: ");
					String data = sc.next();
					
					try {
					    SimpleDateFormat f = new SimpleDateFormat("dd/MM/yyyy");
					    Date format = f.parse(data);
					    contaPoupanca.setDataDeposito(format);
						contaPoupanca.depositar(deposito);
					} catch ( ParseException exc ) {
						System.out.println( "data informada em formato errado!" );
					}
				}else if (opcao == 3) {
					System.out.println(contaPoupanca);
				}else if (opcao == 0) {
					System.out.println("Finalizando BethaCode");
					
				}else {
					System.out.println("Opção Inválida!! Tente novamente!!!");
				}
				
			}while(opcao != 0);	
			
		}else if (tipo == 2 ) {
			
			System.out.print("Informe o seu nome: ");
			String nomePessoa = sc.next();
			System.out.print("Número da Conta: ");
			String numeroConta = sc.next();
			ContaCorrente contaCorrente = new ContaCorrente(nomePessoa, numeroConta);
			
			int opcao;
			
			
			do {
				System.out.println("Menu de Opções do Banco BethaCode");
				System.out.println("1 - Sacar");
				System.out.println("2 - Depositar");
				System.out.println("3 - Dados da Conta");
				System.out.println("0 - Encerrar Programa");
				System.out.print("Informa a sua opção: ");
				opcao = sc.nextInt();
				
				if (opcao == 1) {
					System.out.print("Informe o valor a ser sacado R$: ");
					double saque = sc.nextDouble();
					contaCorrente.sacar(saque);
				}else if (opcao == 2) {
					System.out.print("Informe o valor a ser depositado R$: ");
					double deposito = sc.nextDouble();
					contaCorrente.depositar(deposito);
				}else if (opcao == 3) {
					System.out.println(contaCorrente);
				}else if (opcao == 0) {
					System.out.println("Finalizando BethaCode");
					
				}else {
					System.out.println("Opção Inválida!! Tente novamente!!!");
				}
				
				
			}while(opcao != 0);	
			
		}else {
			System.out.println("Opção Inválida!");
		}		
	}
}