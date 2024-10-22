package ufu;

import java.time.LocalDate;
import java.util.Date;

public class Financeiro {
	private static int contador = 700;
	private int id;
	private Orcamento orcamento;
	private Date data;
	private Boolean pago;
	private Cliente responsavel;
	private Double valor;
	
	public Financeiro(Orcamento orcamento, Boolean pago, Cliente responsavel, Double valor) {
		this.id = contador++;
		this.orcamento = orcamento;
		this.data = new Date();
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

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
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

	public int getId() {
		return id;
	}

}
