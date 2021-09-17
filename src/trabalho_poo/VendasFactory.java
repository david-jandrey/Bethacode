package trabalho_poo;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class VendasFactory {

	public static void main(String[] args) {

		List<Produtos> listaDeProdutos = new ArrayList<>();
		List<Vendas>   listaDeVendas  = new ArrayList<>();
		Scanner sc = new Scanner(System.in);
		
		int opcao;
		do {
			System.out.println("----Controle de Vendas----");
			System.out.println("1 - Cadastrar produtos");
			System.out.println("2 - Excluir   Produtos");
			System.out.println("3 - Mostrar   produtos");
			System.out.println("4 - Vender    produtos");
			System.out.println("5 - Lista de  Faturamento ");
			System.out.println("0 - Encerrar Programa");
			System.out.print("Informe sua opção: ");
			opcao = sc.nextInt();
			
			if (opcao == 1) {
				System.out.print("Informe o código do produto:");
				int codProduto = sc.nextInt();
				
				System.out.print("Informe a descrião do produto");
				String descricaoProduto = sc.next();
				
				System.out.print("Informe o Valor unitário do Produto");				
				Double  valorProduto = sc.nextDouble();
				
				System.out.print("Informe a quantidade do produto");				
				Double  quantidadeProduto = sc.nextDouble();
								
				Produtos novoProduto = new Produtos(codProduto, descricaoProduto, valorProduto, quantidadeProduto);
				listaDeProdutos.add(novoProduto);
				
			}else if(opcao == 2) {
				System.out.print("Informe o código do Produto para exclusão:");
				int codASerExcluido = sc.nextInt();
				listaDeProdutos.removeIf(produto -> produto.getCodigo() == codASerExcluido);
			}else if(opcao == 3) {
				for (Produtos produto : listaDeProdutos) {
					System.out.println(produto.getList());
				}
			}else if(opcao == 4) {
				System.out.print("Informe o código do produto que será vendido:");
				int codProduto = sc.nextInt();
								
				System.out.print("Informe o Valor unitário do Produto");				
				Double  valorProduto = sc.nextDouble();
				
				System.out.print("Informe a quantidade do produto");				
				Double  quantidadeProduto = sc.nextDouble();
				
				System.out.print("Informe a data do Faturamento: ");
				String data = sc.next();
				
				Date dataFormat;
				
				try {
				    SimpleDateFormat f = new SimpleDateFormat("dd/MM/yyyy");
				    dataFormat = f.parse(data);
				} catch ( ParseException exc ) {
					System.out.println( "data informada em formato errado!" );
					return;
				}
								
				Vendas novoVenda = new Vendas(codProduto, valorProduto, quantidadeProduto, dataFormat);
				listaDeVendas.add(novoVenda);
				
			}else if(opcao == 5) {
				for (Vendas venda : listaDeVendas) {
					
					int codigoProduto = venda.getCodigo();
					
					List<Produtos> fatProduto = listaDeProdutos.stream().filter(produto -> produto.getCodigo() == codigoProduto).collect(Collectors. toList());
					
					if ((fatProduto.isEmpty())) {
						System.out.println("Erro contate o suporte");					
					}else {
						System.out.println("|Produto "+fatProduto+""+venda);
					}
					
				}
								
			}else if(opcao == 0) {
				System.out.println("Encerrando Sistema de Controle de Vendas");
			}else {
				System.out.println("Opção Inválida para o Sistema de Controle de Vendas");
			}
			
		}while(opcao != 0);
		
		sc.close();
	}

}
