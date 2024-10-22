package ufu;

public class Imovel {
	private int id;
	private static int contador = 200;
	private String endereco;
	private Cliente cliente; //Relaciona um cliente ao imovel
	
	public Imovel(String endereco, Cliente cliente) {
		this.id = contador++;
		this.endereco = endereco;
		this.cliente = cliente;
	}

	public int getId() {
		return id;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

}
