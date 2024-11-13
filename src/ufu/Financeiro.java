package ufu;

import java.io.Serializable;
import java.time.LocalDate;

public class Financeiro implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Orcamento orcamento;
	private LocalDate data;
	private Boolean pago;
	private Cliente responsavel;
	private Double valor;
	
	public Financeiro(Orcamento orcamento, Boolean pago, Cliente responsavel, Double valor) {
		this.orcamento = orcamento;
		this.data = LocalDate.now();
		this.pago = pago;
		this.responsavel = responsavel;
		this.valor = valor;
		orcamento.setAprovado(true);
	}
	
	public Orcamento getOrcamento() {
		return orcamento;
	}

	public void setOrcamento(Orcamento orcamento) {
		this.orcamento = orcamento;
	}

	public LocalDate getData() {
		return data;
	}

	public void setData(LocalDate data) {
		this.data = data;
	}

	public Boolean getPago() {
		return pago;
	}

	public void setPago(Boolean pago) {
		this.pago = pago;
	}

	public Cliente getResponsavel() {
		return responsavel;
	}

	public void setResponsavel(Cliente responsavel) {
		this.responsavel = responsavel;
	}

	public Double getValor() {
		return valor;
	}

	public void setValor(Double valor) {
		this.valor = valor;
	}
}
