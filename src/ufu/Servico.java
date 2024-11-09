package ufu;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;

import javax.swing.JOptionPane;

public class Servico implements Material, Reparo, Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static int contador = 1;
	private int id;
	private Prestador prestador;
	private Double valorServico, valorMateriais;
	private String tipo;
	private boolean concluido, temMateriais, comproMateriais;
	private ArrayList<Materiais> listaMateriais = new ArrayList<Materiais>();
	
	private String arquivoMaterial = System.getProperty("user.dir") + File.separator + "Files" + File.separator + "Materiais";
	
	public Servico(Prestador prestador, Double valor, String tipo) {
		this.prestador = prestador;
		this.valorServico = valor;
		this.tipo = tipo;
		concluido = false;
		temMateriais = false;
		comproMateriais = false;
		this.id = contador++;
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
	}
	
	public void listaMateriais() {
		for(Materiais materiais : listaMateriais) {
			System.out.printf("Nome: %s - Quantidade: %d - Preço Unitario: R$ %.2f - Preço Total: R$ %.2f\n", materiais.getNome(), materiais.getQuantidade(),
					materiais.getValor(), materiais.getValorTotal());
		}
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

	public int getId() {
		return id;
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

}
