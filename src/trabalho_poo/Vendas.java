package trabalho_poo;

import java.util.Date;

public class Vendas {
	
	private int codigo;
	private Double valor;
	private Double quantidade;
	private Date dt_faturamento;
	
	public Vendas(int codigo, Double valor, Double quantidade, Date dt_faturamento) {
		this.codigo			= codigo;
		this.valor  		= valor;
		this.quantidade 	= quantidade;
		this.dt_faturamento = dt_faturamento;
	} 
	
	public int getCodigo() {
		return this.codigo;
	}
	
	@Override
    public String toString() {
    	return   "|Valor do faturamento R$"+valor*quantidade+" |Quantidade "+quantidade+" | Data de Faturamento "+dt_faturamento+"|";
    }	

}
