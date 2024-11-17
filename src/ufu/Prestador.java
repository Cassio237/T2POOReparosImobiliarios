package ufu;

import java.io.Serializable;

import javax.swing.JOptionPane;

public class Prestador implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String nome, funcao;
	
	public Prestador(String nome, String funcao) {
		this.nome = nome;
		this.funcao = funcao;
	}
	
	@Override
	public String toString() {
		try {
			return String.format("Nome: " + getNome() + " - Função: " + getFuncao());
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "toString Orcamento" + e);
		}
		return null;
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
}
