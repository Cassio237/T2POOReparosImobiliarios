package ufu;

public class Materiais {
	private String nome;
	private int quantidade;
	private Double valor,  valorTotal;
	
	public Materiais(String nome, int quantidade, Double valor) {
		this.nome = nome;
		this.quantidade = quantidade;
		this.valor = valor;
		this.valorTotal = quantidade * valor;
	}
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public Integer getQuantidade() {
		return quantidade;
	}
	public void setQuantidade(Integer quantidade) {
		this.quantidade = quantidade;
	}
	public Double getValor() {
		return valor;
	}
	public void setValor(Double valor) {
		this.valor = valor;
	}

	public Double getValorTotal() {
		return valorTotal;
	}

}
