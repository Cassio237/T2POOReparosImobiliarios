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

public class Orcamento implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Imovel imovel;
	protected ArrayList<Servico> servicos = new ArrayList<Servico>();
	private Cliente cliente;
	private Double valorOrcamento;
	private boolean aprovado;
	protected int id;

	private String arquivoServico = "Serviço";

	public Orcamento() {
	} // Contrutor so para chame um metodo q inicia dados

	public Orcamento(Imovel imovel, Cliente cliente) {
		this.imovel = imovel;
		this.cliente = cliente;
		this.aprovado = false;
	}

	@Override
	public String toString() {
		try {
			String aprovado = "NÃO";
			if (this.aprovado) {
				aprovado = "SIM";
			}
			return String.format("Nº: %d - Cliente Responsavel: %s - Valor: R$ %.2f - Aprovado? %s", this.id,
					getCliente().getNome(), this.valorOrcamento, aprovado);
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "toString Orcamento" + e);
		}
		return null;
	}

	public void iniciaDadosServico() { // inicializador que carrega dados existentes
		ArrayList<Servico> servicosLidos = ler(arquivoServico);
		if (servicosLidos != null) {
			servicos = servicosLidos;
		}
	}

	public ArrayList<Servico> getServicos() {
		return servicos;
	}

	public <E> ArrayList<E> ler(String caminho) { // uso o tipo generic <E> para todos arrays, vou reutilizar o metodo
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
			JOptionPane.showMessageDialog(null,
					"Sistema.ler erro de leitura, arquivo de " + caminho + " não encontrado" + e);
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

	public <E> void escreve(String caminho, ArrayList<E> lista) { // Declaro tipo generico <E>
		FileOutputStream escritor = null;
		ObjectOutputStream object = null;
		try {
			escritor = new FileOutputStream(caminho);
			object = new ObjectOutputStream(escritor);

			object.writeObject(lista);
		} catch (FileNotFoundException e) { // uso do NotFoundException
			JOptionPane.showMessageDialog(null,
					"Sistema.escreve Arquivo não encontrador \n Dados não serao salvos" + e);
		} catch (IOException e) { // uso do IOException
			JOptionPane.showMessageDialog(null,
					"Sistema.escreve Erro de entrada de dados \n Dados não serao salvos" + e);
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

	public Servico criarServico(Prestador prestador, Double valor, String tipo) {
		try {
			if (prestador == null || valor == null || tipo == null) {
				throw new IllegalArgumentException("Prestador, valor ou tipo de serviço errado, Tente Novamente!");
			}
			Servico servico = new Servico(prestador, valor, tipo);
			servicos.add(servico);
			if (valorOrcamento == null) {
				valorOrcamento = valor;
			} else {
				valorOrcamento = valorOrcamento + valor;
			}
			escreve(arquivoServico, servicos);
			return servico;
		} catch (Exception e) {
			System.out.println("orcamento.criarServico" + e);
			return null;
		}
		
	}

	public Servico pegaServico(String tipo) {
		try {
			for (Servico servico : servicos) {
				if (servico.getTipo().equals(tipo)) {
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
			servico.temMateriais(servico.isTemMateriais());
			servico.addMateriais(nome, quantidade, valor);
			if (valorOrcamento == null) {
				valorOrcamento = valor * quantidade;
			} else {
				valorOrcamento = valorOrcamento + valor * quantidade;
			}
		} catch (Exception e) {
			System.out.println("orcamento.addMateriasServico" + e);
		}
	}

	public String listaServicoDetalhado() {
	    StringBuilder detalhes2 = new StringBuilder();
	    try {
	        detalhes2.append("=========== Serviços ===========\n");
	        for (Servico servico : servicos) {
	            detalhes2.append(String.format("Serviço: %s - Prestador: %s - Valor: R$ %.2f\n",
	                    servico.getTipo(), servico.getPrestador().getNome(), servico.getValorServico()));
	            if (servico.isTemMateriais()) {
	                detalhes2.append("****** Lista de Materiais para este Serviço ******\n");
	                detalhes2.append(servico.listaMateriaisDetalhado());
	            }
	        }
	    } catch (Exception e) {
	        e.printStackTrace();
	        return "Erro ao listar serviços.";
	    }
	    return detalhes2.toString();
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

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
}
