package trabalho_poo;

public class Produtos {

	private int codigo;
	private String descricao;
	private Double valor;
	private Double quantidade;
	
	public Produtos(int codigo, String descricao, Double valor, Double quantidade) {
		this.codigo		= codigo;
		this.descricao  = descricao;
		this.valor  	= valor;
		this.quantidade = quantidade;
	} 
	
	public int getCodigo() {
		return this.codigo;
	}
		
	public String getList() {
		return  " Produto: "+this.descricao+"( "+this.codigo+" ) quantidade em estoque: "+this.quantidade+" valor unitario: "+this.valor;
	}

	@Override
    public String toString() {
    	return   " |Produto: "+descricao+"( "+codigo+" ) |";
    }	
}
