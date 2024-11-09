package ufu;

import java.io.Serializable;

public abstract class Cliente implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String nome, endereco, telefone;
	private int id;
	private static int contador = 100;
	
	public Cliente(String nome, String endereco, String telefone) {
		super();
		this.nome = nome;
		this.endereco = endereco;
		this.telefone = telefone;
		this.id = contador++;
	}

	public int getId() {
		return id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	
	abstract boolean validar(String valor); 
	
	abstract String getDado(); //Metodo abstrato nao para obrigar e sim para facilitar o acesso a um atributo da classe filha

}
