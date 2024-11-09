package ufu;

import java.io.Serializable;

public class Prestador implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int id;
	private static int contador = 300;
	private String nome, funcao;
	
	public Prestador(String nome, String funcao) {
		this.id = contador++;
		this.nome = nome;
		this.funcao = funcao;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getFuncao() {
		return funcao;
	}

	public void setFuncao(String funcao) {
		this.funcao = funcao;
	}

	public int getId() {
		return id;
	}

}
