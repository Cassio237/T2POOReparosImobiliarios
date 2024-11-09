package ufu;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;

import javax.swing.JOptionPane;

public class Orcamento implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static int contador = 500;
	private int id;
	private Imovel imovel;
	private ArrayList<Servico> servicos = new ArrayList<Servico>();
	private Cliente cliente;
	private Double valorOrcamento;
	private boolean aprovado;
	
	private String arquivoServico = System.getProperty("user.dir") + File.separator + "Files" + File.separator + "Serviço";
	
	public Orcamento(Imovel imovel, Cliente cliente) {
		this.imovel = imovel;
		this.cliente = cliente;
		this.valorOrcamento = 0.0;
		this.id = contador++;
		this.aprovado = false;
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
	
	public void criarServico(Prestador prestador, Double valor, String tipo) {
		try {
			if (prestador == null || valor == null || tipo == null) {
				throw new IllegalArgumentException("Prestador, valor ou tipo de serviço errado, Tente Novamente!");
			}
			servicos.add(new Servico(prestador, valor, tipo));
			escreve(arquivoServico, servicos);
			valorOrcamento = valorOrcamento + valor;
		} catch (Exception e) {
			System.out.println("orcamento.criarServico" + e);
		}	
	}
	
	public Servico pegaServico(String tipo) {
		try {
			for(Servico servico : servicos) {
				if(servico.getTipo().equals(tipo)) {
					return servico;
				}
			}
		} catch (Exception e) {
			System.out.println("orcamento.pegaServico" + e);
		}
		return null;
	}
	
	public void addMateriaisServico(String tipo, String nome, int quantidade, Double valor) {
		try {
			Servico servico = pegaServico(tipo);
			if(servico == null) {
				System.out.println("Serviço nao iniciado, para adicionar materiais inicie um serviço!!");
				return;
			}
			servico.temMateriais(servico.isTemMateriais());
			servico.addMateriais(nome, quantidade, valor);
			valorOrcamento = valorOrcamento + valor * quantidade;
		} catch (Exception e) {
			System.out.println("orcamento.addMateriasServico" + e);
		}
	}
	
	public void listaMateriais() {
		try {
			for(Servico servico : servicos) {
				servico.listaMateriais();
				}
		} catch (Exception e) {
			System.out.println("orcamento.listaMateriais" + e);
		}
	}
		
	public void listaServico() {
		try {
			for(Servico servico : servicos) {
				System.out.println("===========Serviços===========");
				System.out.printf("ID: %d Seviço: %s - Prestador: %s - Valor: R$ %.2f\n",servico.getId(), servico.getTipo(), servico.getPrestador().getNome(),
						servico.getValorServico());
				if(servico.isTemMateriais()) {
					System.out.println("******Lista de Materiais para esse Serviço*****");
					servico.listaMateriais();
				}
				System.out.printf("Valor total do Orçamento: %.2f\n", valorOrcamento);
			}
		} catch (Exception e) {
			System.out.println("orcamento.listaServico" + e);
		}
	}

	public Imovel getImovel() {
		return imovel;
	}

	public void setImovel(Imovel imovel) {
		this.imovel = imovel;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public int getId() {
		return id;
	}

	public Double getValorOrcamento() {
		return valorOrcamento;
	}

	public void setValorOrcamento(Double valorOrcamento) {
		this.valorOrcamento = valorOrcamento;
	}

	public boolean isAprovado() {
		return aprovado;
	}

	public void setAprovado(boolean aprovado) {
		this.aprovado = aprovado;
	}

	public Servico getServicos(String tipo) {
		return pegaServico(tipo);
	}


}
