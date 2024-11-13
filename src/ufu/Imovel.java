package ufu;

import java.io.Serializable;

public class Imovel implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String endereco;
	private Cliente cliente; //Relaciona um cliente ao imovel
	
	public Imovel(String endereco, Cliente cliente) {
		this.endereco = endereco;
		this.cliente = cliente;
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
