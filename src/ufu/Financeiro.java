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
	
	@Override
	public String toString() {
		String pagoString = "NÃO";
		if (pago) {
			pagoString = "SIM";
		}
		return String.format("Orcamento ID: %d - Cliente: %s - Valor: R$ %.2f - Data: %s - Pago: %s", orcamento.getId(), orcamento.getCliente().getNome(),
				valor, data, pagoString);
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
	
	public String toStringPago() {
		if (this.pago) {
			return "SIM";
		}
		return "NÃO";
	}

	public void mudaPago() {
		this.pago = !this.pago;
	}

}
