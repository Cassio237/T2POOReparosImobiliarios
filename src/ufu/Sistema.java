package ufu;

import java.util.ArrayList;

public class Sistema {
	ArrayList<Cliente> clientes = new ArrayList<>();
	ArrayList<Prestador> prestadores = new ArrayList<>();
	ArrayList<Imovel> imoveis = new ArrayList<>();
	ArrayList<Orcamento> orcamentos = new ArrayList<>();
	ArrayList<Financeiro> financas = new ArrayList<>();
	
	public Orcamento ultiOrcamento;

	public void criarClienteFisica(String nome, String endereco, String telefone, String cpf) {
		try {
			clientes.add(new PessoaFisica(nome, endereco, telefone, cpf));
			System.out.println("Adicionado!");
		} catch (Exception e) {
			System.out.println("Sistema.CLienteFisica" + e);
		}
	}

	public void criarClienteJuridica(String nome, String endereco, String telefone, String cnpj) {
		try {
			clientes.add(new PessoaJuridica(nome, endereco, telefone, cnpj));
			System.out.println("Adicionado!");
		} catch (Exception e) {
			System.out.println("Sistema.CLienteJuridica" + e);
		}
	}

	public void listarClientes() {
		try {
			for (Cliente cliente : clientes) {
				System.out.println("ID: " + cliente.getId() + "Nome: " + cliente.getNome() + " " + cliente.getDado()
						+ " Endereco: " + cliente.getEndereco() + " Telefone: " + cliente.getTelefone());
			}
		} catch (Exception e) {
			System.out.println("Sistema.ListarCliente" + e);
		}
	}

	public void criarPrestador(String nome, String funcao) {
		try {
			prestadores.add(new Prestador(nome, funcao));
			System.out.println("Adicionado!");
		} catch (Exception e) {
			System.out.println("sistema.criarPrestador" + e);
		}
	}
	
	public void listarPrestador() {
		try {
			for(Prestador prestador : prestadores) {
				System.out.println("ID: " + prestador.getId() + " Nome: " + prestador.getNome() + " Função principal: " + prestador.getFuncao());
			}
		} catch (Exception e) {
			System.out.println("sistema.listarPrestador" + e);
		}
	}
	
	public Prestador pegaPrestador(int id) {
		try {
			for(Prestador prestador : prestadores) {
				if(prestador.getId() == id) {
					return prestador;
				}
			}
		} catch (Exception e) {
			System.out.println("sistema.pegaPrestador" + e);
		}
		return null;
	}
	
	public Cliente pegaCliente(String nome) {
		try {
			for(Cliente cliente : clientes) {
				if (cliente.getNome().equalsIgnoreCase(nome)) {
					return cliente;
				}
			}
		} catch (Exception e) {
			System.out.println("Sitema.pegaCliente" + e);
		}
		return null;
	}
	
	public void criarImovel(String endereco, String nome) {
		try {
			Cliente cliente = pegaCliente(nome);
			if(cliente == null) {
				System.out.println("Cliente nao encontrado!");
				return;
			}
			imoveis.add(new Imovel(endereco, cliente));
			System.out.println("Adicionado!");
		} catch (Exception e) {
			System.out.println("sistema.criarImovel" + e);
		}
	}
	
	public void listarImovel() {
		try {
			for(Imovel imovel : imoveis) {
				System.out.println("ID: " + imovel.getId() + " Endereço: " + imovel.getEndereco() + " Proprietário ID: " 
						+ imovel.getCliente().getId() + " Nome: " + imovel.getCliente().getNome());
			}
		} catch (Exception e) {
			System.out.println("sistema.listarImovel" + e);
		}
	}
	
	public Imovel pegaImovel(int id) {
		try {
			for(Imovel imovel : imoveis) {
				if(imovel.getId() == id) {
					return imovel;
				}
			}
		} catch (Exception e) {
			System.out.println("sistema.pegaImovel" + e);
		}
		return null;
	}
	
	public void iniciarOrcamento(int idImovel, String clienteNome) {
		try {
			Imovel imovel = pegaImovel(idImovel);
			Cliente cliente = pegaCliente(clienteNome);
			ultiOrcamento = new Orcamento(imovel, cliente); //crio uma "copia" do orcamento que esta sendo feito
			orcamentos.add(ultiOrcamento);
		} catch (Exception e) {
			System.out.println("sistema.iniciarOrcamento" + e);
		}
	}
	
	public void listaOrcamento() {
		try {
			for(Orcamento orcamento : orcamentos) {
				System.out.printf("ID: %d - Cliente: %s - Endereço Imovel: %s - Valor: R$ %.2f - Aprovado: %s\n", orcamento.getId(),
						orcamento.getCliente().getNome(), orcamento.getImovel().getEndereco(), orcamento.getValorOrcamento(), orcamento.isAprovado());
			}
		} catch (Exception e) {
			System.out.println("sistema.listarOrcamento" + e);
		}
		
	}
	
	public Orcamento pegaOrcamento(int id) {
		try {
			for(Orcamento orcamento : orcamentos) {
				if(orcamento.getId() == id) {
					return orcamento;
				}
			}
		} catch (Exception e) {
			System.out.println("sistema.pegaOrcamento" + e);
		}
		return null;
	}
	
	public void addServicoOrcamento(int idPrestador, Double valor, String tipoServico) {
		try {
			Prestador prestador = pegaPrestador(idPrestador);
			ultiOrcamento.criarServico(prestador, valor, tipoServico);
			System.out.println("Adicionado!");
		} catch (Exception e) {
			System.out.println("sistema.addServicoOrcamento - ultimo" + e);
		}
	}
	
	public void addServicoOrcamento(int idOrcamento, int idPrestador, Double valor, String tipoServico) {
		try {
			Orcamento orcamento = pegaOrcamento(idOrcamento);
			Prestador prestador = pegaPrestador(idPrestador);
			orcamento.criarServico(prestador, valor, tipoServico);
			System.out.println("Adicionado!");
		} catch (Exception e) {
			System.out.println("sistema.addServicoOrcamento - por ID " + e);
		}
	}
	
	public void addItensOrcamento(String tipoServico, String nome, int quantidade, Double valor) {
		try {
			ultiOrcamento.addMateriaisServico(tipoServico, nome, quantidade, valor);
			System.out.println("Adicionado!! Listando intens orçamento:");
			ultiOrcamento.listaServico();
			System.out.println("Adicionado!");
		} catch (Exception e) {
			System.out.println("sistema.addItensOrcamento ultimo " + e);
		}
	}
	
	public void addItensOrcamento(int idOrcamento, String tipoServico, String nome, Integer quantidade, Double valor) { //sobrecarga para continuar um outro orcamento
		try {
			Orcamento orcamento = pegaOrcamento(idOrcamento);
			orcamento.addMateriaisServico(tipoServico, nome, quantidade, valor);
			System.out.println("Adicionado!! Listando intens orcamento:");
			orcamento.listaServico();
		} catch (Exception e) {
			System.out.println("sistema.addItensOrcamento por ID " + e);
		}
	}
	
	public void aprovarOrcamento(boolean pago) { // finalizar e aprovar ultimo orcamento
		try {
			financas.add(new Financeiro(ultiOrcamento, pago, ultiOrcamento.getCliente(), ultiOrcamento.getValorOrcamento()));
		} catch (Exception e) {
			System.out.println("sistema.aprovarOrcamento ultimo" + e);
		}
	}
	
	public void aprovarOrcamento(int idOrcamento, boolean pago) { // com sobrecarga buscar e aprovar outro orcamento
		try {
			Orcamento orcamento = pegaOrcamento(idOrcamento);
			financas.add(new Financeiro(orcamento, pago, orcamento.getCliente(), orcamento.getValorOrcamento()));
		} catch (Exception e) {
			System.out.println("sistema.aprovarOrcamento ID" + e);
		}	
	}
	
	public void listarFinancas() {
		try {
			for(Financeiro financa : financas) {
				System.out.printf("ID: %d - Cliente: %s - Endereco: %s - Valor: RS %.2f Data: %s - Pago: %s\n", financa.getId(), financa.getResponsavel().getNome(),
						financa.getOrcamento().getImovel().getEndereco(), financa.getValor(), financa.getData(), financa.getPago());
			}
		} catch (Exception e) {
			System.out.println("sistema.listaFinancas" + e);
		}

	}

}
