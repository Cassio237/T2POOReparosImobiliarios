package ufu;

import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import MinhasExcecoes.OrcamentoException;

public class Sistema {
	ArrayList<Cliente> clientes = new ArrayList<>();
	ArrayList<Prestador> prestadores = new ArrayList<>();
	ArrayList<Imovel> imoveis = new ArrayList<>();
	ArrayList<Orcamento> orcamentos = new ArrayList<>();
	ArrayList<Financeiro> financas = new ArrayList<>();
	
	public ArrayList<Cliente> getClientes() {
		return clientes;
	}

	public ArrayList<Prestador> getPrestadores() {
		return prestadores;
	}

	public ArrayList<Imovel> getImoveis() {
		return imoveis;
	}

	public ArrayList<Orcamento> getOrcamentos() {
		return orcamentos;
	}

	public ArrayList<Financeiro> getFinancas() {
		return financas;
	}

	String arquivoCliente = System.getProperty("user.dir") + File.separator + "Files" + File.separator + "Cliente";
	String arquivoPrestador = System.getProperty("user.dir") + File.separator + "Files" + File.separator + "Prestador";
	String arquivoImovel = System.getProperty("user.dir") + File.separator + "Files" + File.separator + "Imovel";
	String arquivoOrcamento = System.getProperty("user.dir") + File.separator + "Files" + File.separator + "Orcamento";
	String arquivoFinanca = System.getProperty("user.dir") + File.separator + "Files" + File.separator + "Financa";
	
	public Orcamento ultiOrcamento;
	
	public void iniciaDados(){ //inicializador que carrega dados existentes
		try {
			ArrayList<Cliente> clientesLidos = ler(arquivoCliente);
		    if (clientesLidos != null) {
		        clientes = clientesLidos;
		    }

		    ArrayList<Prestador> prestadoresLidos = ler(arquivoPrestador);
		    if (prestadoresLidos != null) {
		        prestadores = prestadoresLidos;
		    }

		    ArrayList<Imovel> imoveisLidos = ler(arquivoImovel);
		    if (imoveisLidos != null) {
		        imoveis = imoveisLidos;
		    }

		    ArrayList<Orcamento> orcamentosLidos = ler(arquivoOrcamento);
		    if (orcamentosLidos != null) {
		        orcamentos = orcamentosLidos;
		    }
		    
		    Orcamento orcamento = new Orcamento();
		    orcamento.iniciaDadosServico();
		    Servico servico = new Servico();
		    servico.iniciaDadosMaterias();
		    
		    ArrayList<Financeiro> financasLidas = ler(arquivoFinanca);
		    if (financasLidas != null) {
		        financas = financasLidas;
		    }
		} catch (Exception e2) {
			System.exit(-1); //fecha se nao carregar os dados
			System.out.println("sistema.iniciaDados " + e2);
			JOptionPane.showMessageDialog(null, "sistema.iniciaDados Dados nao carregados! Reinicie a aplicação" + e2);
		}
	}
	
	public <E> ArrayList<E> ler(String caminho) { // uso o tipo generic <E> para todos arrays, vou reutilizar o metodo
		FileInputStream leitor = null;
		ObjectInputStream object = null;

		try {
			leitor = new FileInputStream(caminho);
			object = new ObjectInputStream(leitor);

			@SuppressWarnings("unchecked") // sei lá a IDE avisava aqui abaixo, isso faz um Casting Seguro **
			ArrayList<E> lista = (ArrayList<E>) object.readObject();
			return lista;
		} catch (EOFException e) { // uso do EOFException
			try {
				leitor.close();
				JOptionPane.showMessageDialog(null, "Sistema.ler impossivel ler arquivo, dados incompletos" + e.getMessage());
			} catch (IOException e2) { // uso do IOException
				JOptionPane.showConfirmDialog(null, "Sistema.ler impossivel ler arquivo, dados incompletos" + e2.getMessage());
			}
		} catch (FileNotFoundException e) {
		    JOptionPane.showMessageDialog(null, "Sistema.ler erro de leitura, arquivo de " + caminho + " não encontrado" + e.getMessage());
		} catch (Exception e2) {
			JOptionPane.showMessageDialog(null, "Sistema.ler erro de leitura, consulte o suporte" + e2.getMessage());
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

	public void criarClienteFisica(String nome, String endereco, String telefone, String cpf) {
		try {
			clientes.add(new PessoaFisica(nome, endereco, telefone, cpf));
			escreve(arquivoCliente, clientes);
			System.out.println("Adicionado!");
			JOptionPane.showMessageDialog(null, "Adicionado!");
		} catch (Exception e) {
			System.out.println("Sistema.CLienteFisica" + e);
			JOptionPane.showMessageDialog(null, "Sistema.ClienteFisica " + e);
		}
	}

	public void criarClienteJuridica(String nome, String endereco, String telefone, String cnpj) {
		try {
			clientes.add(new PessoaJuridica(nome, endereco, telefone, cnpj));
			escreve(arquivoCliente, clientes);
			System.out.println("Adicionado!");
			JOptionPane.showMessageDialog(null, "Adicionado!");
		} catch (Exception e) {
			System.out.println("Sistema.CLienteJuridica" + e);
			JOptionPane.showMessageDialog(null, "Sistema.CLienteJuridica " + e);
		}
	}

	public void listarClientes() {
		try {
			for (Cliente cliente : clientes) {
				System.out.println("Nome: " + cliente.getNome() + " " + cliente.getDado()
						+ " Endereco: " + cliente.getEndereco() + " Telefone: " + cliente.getTelefone());
			}
		} catch (Exception e) {
			System.out.println("Sistema.ListarCliente" + e);
			JOptionPane.showMessageDialog(null, "sistema.ListarCliente" + e);
		}
	}

	public void criarPrestador(String nome, String funcao) {
		try {
			prestadores.add(new Prestador(nome, funcao));
			escreve(arquivoPrestador, prestadores);;
			System.out.println("Adicionado!");
			JOptionPane.showMessageDialog(null, "Adicionado!");
		} catch (Exception e) {
			System.out.println("sistema.criarPrestador" + e);
			JOptionPane.showMessageDialog(null, "sistema.criarPrestador" + e);
		}
	}
	
	public void listarPrestador() {
		try {
			for(Prestador prestador : prestadores) {
				System.out.println("Nome: " + prestador.getNome() + " Função principal: " + prestador.getFuncao());
			}
		} catch (Exception e) {
			System.out.println("sistema.listarPrestador" + e);
			JOptionPane.showMessageDialog(null, "sistema.listarPrestador" + e);
		}
	}
	
	public Prestador pegaPrestador(String nome) {
		try {
			for(Prestador prestador : prestadores) {
				if(prestador.getNome().equalsIgnoreCase(nome)) {
					return prestador;
				}
			}
		} catch (Exception e) {
			System.out.println("sistema.pegaPrestador" + e);
			JOptionPane.showMessageDialog(null, "sistema.pegaPrestador" + e);
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
			JOptionPane.showMessageDialog(null, "Sitema.pegaCliente" + e);
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
			escreve(arquivoImovel, imoveis);
			System.out.println("Adicionado!");
			JOptionPane.showMessageDialog(null, "Adicionado!");
		} catch (Exception e) {
			System.out.println("sistema.criarImovel" + e);
			JOptionPane.showMessageDialog(null, "sistema.criarImovel" + e);
		}
	}
	
	public void listarImovel() {
		try {
			for(Imovel imovel : imoveis) {
				System.out.println("Endereço: " + imovel.getEndereco() + " Proprietário Nome: " + imovel.getCliente().getNome());
			}
		} catch (Exception e) {
			System.out.println("sistema.listarImovel" + e);
			JOptionPane.showMessageDialog(null, "sistema.listarImovel" + e);
		}
	}
	
	public Imovel pegaImovel(String endereco) {
		try {
			for(Imovel imovel : imoveis) {
				if(imovel.getEndereco().equalsIgnoreCase(endereco)) {
					return imovel;
				}
			}
		} catch (Exception e) {
			System.out.println("sistema.pegaImovel" + e);
			JOptionPane.showMessageDialog(null, "sistema.pegaImovel" + e);
		}
		return null;
	}
	
	public void iniciarOrcamento(String endereco, String clienteNome) {
		try {
			Imovel imovel = pegaImovel(endereco);
			Cliente cliente = pegaCliente(clienteNome);
			ultiOrcamento = new Orcamento(imovel, cliente); //crio uma "copia" do orcamento que esta sendo feito
			orcamentos.add(ultiOrcamento);
			escreve(arquivoOrcamento, orcamentos);
		} catch (Exception e) {
			System.out.println("sistema.iniciarOrcamento" + e);
			JOptionPane.showMessageDialog(null, "sistema.iniciarOrcamento" + e);
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
			JOptionPane.showMessageDialog(null, "sistema.listarOrcamento" + e);
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
			JOptionPane.showMessageDialog(null, "sistema.pegaOrcamento" + e);
		}
		return null;
	}
	
	public void listaOrcamentoDetalhado(int idOrcamento) {
		try {
			for(Orcamento orcamento : orcamentos) {
				if(orcamento.getId() == idOrcamento) {
					System.out.printf("ID: %d - Cliente: %s - Endereço Imovel: %s - Valor: R$ %.2f - Aprovado: %s\n", orcamento.getId(),
							orcamento.getCliente().getNome(), orcamento.getImovel().getEndereco(), orcamento.getValorOrcamento(), orcamento.isAprovado());
					orcamento.listaServico();
				}
			}
		} catch (Exception e) {
			System.out.println("sistema.listarOrcamento" + e);
			JOptionPane.showMessageDialog(null, "sistema.listarOrcamento" + e);
		}
		
	}
	
	public void addServicoOrcamento(String nome, Double valor, String tipoServico) {
		try {
			Prestador prestador = pegaPrestador(nome);
			ultiOrcamento.criarServico(prestador, valor, tipoServico);
			System.out.println("Adicionado!");
			JOptionPane.showMessageDialog(null, "Adicionado!");
		} catch (Exception e) {
			System.out.println("sistema.addServicoOrcamento - ultimo" + e);
			JOptionPane.showMessageDialog(null, "sistema.addServicoOrcamento - ultimo" + e);
		}
	}
	
	public void addServicoOrcamento(int idOrcamento, String nome, Double valor, String tipoServico) {
		try {
			Orcamento orcamento = pegaOrcamento(idOrcamento);
			Prestador prestador = pegaPrestador(nome);
			orcamento.criarServico(prestador, valor, tipoServico);
			System.out.println("Adicionado!");
			JOptionPane.showMessageDialog(null, "Adicionado!");
		} catch (Exception e) {
			System.out.println("sistema.addServicoOrcamento - por ID " + e);
			JOptionPane.showMessageDialog(null, "sistema.addServicoOrcamento - por ID " + e);
		}
	}
	
	public void addItensOrcamento(String tipoServico, String nome, int quantidade, Double valor) {
		try {
			ultiOrcamento.addMateriaisServico(tipoServico, nome, quantidade, valor);
			System.out.println("Adicionado!! Listando itens orçamento:");
			ultiOrcamento.listaServico();
			System.out.println("Adicionado!");
			JOptionPane.showMessageDialog(null, "Adicionado!");
		} catch (Exception e) {
			System.out.println("sistema.addItensOrcamento ultimo " + e);
			JOptionPane.showMessageDialog(null, "sistema.addItensOrcamento ultimo " + e);
		}
	}
	
	public void addItensOrcamento(int idOrcamento, String tipoServico, String nome, Integer quantidade, Double valor) { //sobrecarga para continuar um outro orcamento
		try {
			Orcamento orcamento = pegaOrcamento(idOrcamento);
			orcamento.addMateriaisServico(tipoServico, nome, quantidade, valor);
			System.out.println("Adicionado!! Listando itens orcamento:");
			JOptionPane.showMessageDialog(null, "Adicionado!");
			orcamento.listaServico();
		} catch (Exception e) {
			System.out.println("sistema.addItensOrcamento por ID " + e);
			JOptionPane.showMessageDialog(null, "sistema.addItensOrcamento por ID " + e);
		}
	}
	
	public void listaMaterial(int idOrcamento) {
		try {
			Orcamento orcamento = pegaOrcamento(idOrcamento);
			orcamento.listaServico();
		} catch (Exception e) {
			System.out.println("sistema.listaMaterial " + e);
			JOptionPane.showMessageDialog(null, "sistema.listaMaterial " + e);
		}
	}
	
	public void aprovarOrcamento(boolean pago) { // finalizar e aprovar ultimo orcamento
		try {
			if(ultiOrcamento.servicos == null || ultiOrcamento.servicos.isEmpty()) {
				throw new OrcamentoException("Nao tem serviços nesse orçamento, impossivel aprovar");
			}
			financas.add(new Financeiro(ultiOrcamento, pago, ultiOrcamento.getCliente(), ultiOrcamento.getValorOrcamento()));
			escreve(arquivoFinanca, financas);
			JOptionPane.showMessageDialog(null, "Aprovado!");
		} catch (OrcamentoException oe){
			System.out.println("sistema.aprovarOrcamento ultimo" + oe);
			JOptionPane.showMessageDialog(null, "sistema.aprovarOrcamento ultimo" + oe);
		} catch (Exception e) {
			System.out.println("sistema.aprovarOrcamento ultimo" + e);
			JOptionPane.showMessageDialog(null, "sistema.aprovarOrcamento ultimo" + e);
		}
	}
	
	public void aprovarOrcamento(int idOrcamento, boolean pago) { // com sobrecarga buscar e aprovar outro orcamento
		try {
			Orcamento orcamento = pegaOrcamento(idOrcamento);
			if(orcamento.servicos == null || orcamento.servicos.isEmpty()) {
				throw new OrcamentoException("Nao tem serviços nesse orçamento, impossivel aprovar");
			}
			financas.add(new Financeiro(orcamento, pago, orcamento.getCliente(), orcamento.getValorOrcamento()));
			escreve(arquivoFinanca, financas);
			JOptionPane.showMessageDialog(null, "Aprovado!");
		} catch (OrcamentoException oe) {
			System.out.println("sistema.aprovarOrcamento ID" + oe);
			JOptionPane.showMessageDialog(null, "sistema.aprovarOrcamento ID" + oe);
		} catch (Exception e) {
			System.out.println("sistema.aprovarOrcamento ID" + e);
			JOptionPane.showMessageDialog(null, "sistema.aprovarOrcamento ID" + e);
		}	
	}
	
	public void listarFinancas() {
		try {
			for(Financeiro financa : financas) {
				
				System.out.printf("Cliente: %s - Endereco: %s - Valor: RS %.2f Data: %s - Pago: %s\n", 
						financa.getResponsavel().getNome(),financa.getOrcamento().getImovel().getEndereco(), financa.getValor(), 
						financa.getData(), financa.getPago());
			}
		} catch (Exception e) {
			System.out.println("sistema.listaFinancas" + e);
			JOptionPane.showMessageDialog(null, "sistema.listaFinancas " + e);
		}
	}
	
}
