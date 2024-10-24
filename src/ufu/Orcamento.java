package ufu;

import java.util.ArrayList;

public class Orcamento {
	private static int contador = 500;
	private int id;
	private Imovel imovel;
	private ArrayList<Servico> servicos = new ArrayList<Servico>();
	private Cliente cliente;
	private Double valorOrcamento;
	private boolean aprovado;
	
	public Orcamento(Imovel imovel, Cliente cliente) {
		this.imovel = imovel;
		this.cliente = cliente;
		this.valorOrcamento = 0.0;
		this.id = contador++;
		this.aprovado = false;
	}
	
	public void criarServico(Prestador prestador, Double valor, String tipo) {
		try {
			if (prestador == null || valor == null || tipo == null) {
				throw new IllegalArgumentException("Prestador, valor ou tipo de serviço errado, Tente Novamente!");
			}
			servicos.add(new Servico(prestador, valor, tipo));
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
