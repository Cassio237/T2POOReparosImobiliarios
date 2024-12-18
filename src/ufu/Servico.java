package ufu;

import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;

import javax.swing.JOptionPane;

public class Servico implements Material, Reparo, Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Prestador prestador;
	private Double valorServico, valorMateriais, valorTotal;
	private String tipo;
	private boolean concluido, temMateriais, comproMateriais;
	private ArrayList<Materiais> listaMateriais = new ArrayList<Materiais>();
	
	private String arquivoMaterial = "Materiais";
	
	public Servico() {} //Contrutor so para chame um metodo q inicia dados
	
	public Servico(Prestador prestador, Double valor, String tipo) {
		this.prestador = prestador;
		this.valorServico = valor;
		this.tipo = tipo;
		concluido = false;
		temMateriais = false;
		comproMateriais = false;
		this.valorTotal = this.valorServico;
	}
	
	public void iniciaDadosMaterias() { //inicializador que carrega dados existentes
	    ArrayList<Materiais> materiasLidos = ler(arquivoMaterial);
	    if (materiasLidos != null) {
	    	listaMateriais = materiasLidos;
	    }
	}
	
	public ArrayList<Materiais> getListaMateriais() {
		return listaMateriais;
	}

	public <E> ArrayList<E> ler(String caminho) {
		File arquivo = new File(caminho);
		if (!arquivo.exists() || arquivo.length() == 0) {
			return new ArrayList<E>();
		}
		
		FileInputStream leitor = null;
		ObjectInputStream object = null;

		try {
			leitor = new FileInputStream(caminho);
			object = new ObjectInputStream(leitor);

			@SuppressWarnings("unchecked")
			ArrayList<E> lista = (ArrayList<E>) object.readObject();
			return lista;
		} catch (EOFException e) { // uso do EOFException
			try {
				leitor.close();
				JOptionPane.showMessageDialog(null, "Sistema.ler impossivel ler arquivo, dados incompletos" + e);
			} catch (IOException e2) { // uso do IOException
				JOptionPane.showConfirmDialog(null, "Sistema.ler impossivel ler arquivo, dados incompletos" + e2);
			}
		} catch (FileNotFoundException e) {
		    JOptionPane.showMessageDialog(null, "Sistema.ler erro de leitura, arquivo de " + caminho + " não encontrado" + e);
		} catch (Exception e2) {
			JOptionPane.showMessageDialog(null, "Sistema.ler erro de leitura, consulte o suporte" + e2);
		} finally {
			try {
				if (leitor != null)
					leitor.close();
			} catch (Exception e) {
				JOptionPane.showMessageDialog(null, "Sistema.ler Erro ao limpar buffer, consulte o suporte" + e);
			}
		}
		return null;
	}
	
	public <E> void escreve(String caminho, ArrayList<E> lista) { //Declaro tipo generico <E>
		FileOutputStream escritor = null;
		ObjectOutputStream object = null;
		try {
			escritor = new FileOutputStream(caminho);
			object = new ObjectOutputStream(escritor);
			
			object.writeObject(lista);
		} catch (FileNotFoundException e) { //uso do NotFoundException
			JOptionPane.showMessageDialog(null, "Sistema.escreve Arquivo não encontrador \n Dados não serao salvos" + e);
		} catch (IOException e){ // uso do IOException
			JOptionPane.showMessageDialog(null, "Sistema.escreve Erro de entrada de dados \n Dados não serao salvos" + e);
		} finally {
			try {
				if (escritor != null) {
					escritor.close();
				}
			} catch (Exception e2) {
				JOptionPane.showMessageDialog(null, "Sistema.escreve Erro ao limpar buffer, consulte o suporte" + e2);
			}
		}
	}
	
	public void addMateriais(String nome, int quantidade, Double valor) {
		Materiais materiais = new Materiais(nome, quantidade, valor);
		listaMateriais.add(materiais);
		escreve(arquivoMaterial, listaMateriais);
		valorMateriais = materiais.getValorTotal();
		valorTotal = valorTotal + valorMateriais;
	}
	
	public String listaMateriaisDetalhado() {
	    StringBuilder detalhes3 = new StringBuilder();
	    for (Materiais material : listaMateriais) {
	        detalhes3.append(String.format("Nome: %s - Quantidade: %d - Preço Unitário: R$ %.2f - Preço Total: R$ %.2f\n",
	                material.getNome(), material.getQuantidade(),
	                material.getValor(), material.getValorTotal()));
	        System.out.println(listaMateriais.size());
	    }
	    return detalhes3.toString();
	}

	
	@Override
	public boolean concluirReparos() {
		if (concluido == false) {
			return true;
		}
		return false;
	}

	@Override
	public boolean temMateriais(boolean temMaterial) {
		return temMateriais = true;
	}

	@Override
	public boolean comproMateriais() {
		if(comproMateriais == false) {
			return true;
		}
		return false;
	}

	public Prestador getPrestador() {
		return prestador;
	}

	public void setPrestador(Prestador prestador) {
		this.prestador = prestador;
	}

	public Double getValorServico() {
		return valorServico;
	}

	public void setValorServico(Double valor) {
		this.valorServico = valor;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public boolean isConcluido() {
		return concluido;
	}

	public boolean isTemMateriais() {
		return temMateriais;
	}

	public boolean isComproMateriais() {
		return comproMateriais;
	}
	
	public void setComproMateriais(boolean comproMateriais) {
		this.comproMateriais = comproMateriais;
	}

	public Double getValorMateriais() {
		return valorMateriais;
	}

	public Double getValorTotal() {
		return valorTotal;
	}

}
