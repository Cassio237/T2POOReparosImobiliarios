package ufu;

import java.util.ArrayList;

public class Servico implements Material, Reparo{
	private static int contador = 1;
	private int id;
	private Prestador prestador;
	private Double valorServico, valorMateriais;
	private String tipo;
	private boolean concluido, temMateriais, comproMateriais;
	private ArrayList<Materiais> listaMateriais = new ArrayList<Materiais>();
	
	public Servico(Prestador prestador, Double valor, String tipo) {
		this.prestador = prestador;
		this.valorServico = valor;
		this.tipo = tipo;
		concluido = false;
		temMateriais = false;
		comproMateriais = false;
		this.id = contador++;
	}
	
	public void addMateriais(String nome, int quantidade, Double valor) {
		Materiais materiais = new Materiais(nome, quantidade, valor);
		listaMateriais.add(materiais);
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
