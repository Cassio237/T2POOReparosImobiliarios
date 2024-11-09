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

public class Sistema {
	ArrayList<Cliente> clientes = new ArrayList<>();
	ArrayList<Prestador> prestadores = new ArrayList<>();
	ArrayList<Imovel> imoveis = new ArrayList<>();
	ArrayList<Orcamento> orcamentos = new ArrayList<>();
	ArrayList<Financeiro> financas = new ArrayList<>();
	
	String arquivoCliente = System.getProperty("user.dir") + File.separator + "Files" + File.separator + "Cliente";
	String arquivoPrestador = System.getProperty("user.dir") + File.separator + "Files" + File.separator + "Prestador";
	String arquivoImovel = System.getProperty("user.dir") + File.separator + "Files" + File.separator + "Imovel";
	String arquivoOrcamento = System.getProperty("user.dir") + File.separator + "Files" + File.separator + "Orcamento";
	String arquivoFinanca = System.getProperty("user.dir") + File.separator + "Files" + File.separator + "Financa";
	
	public Orcamento ultiOrcamento;
	
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
				JOptionPane.showMessageDialog(null, "Sistema.ler impossivel ler arquivo, dados incompletos" + e);
			} catch (IOException e2) { // uso do IOException
				JOptionPane.showConfirmDialog(null, "Sistema.ler impossivel ler arquivo, dados incompletos" + e2);
			}
		} catch (FileNotFoundException e) {
		    JOptionPane.showMessageDialog(null, "Sistema.ler erro de leitura, arquivo de " + caminho + " não encontrado" + e);
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
		} catch (Exception e) {
			System.out.println("Sistema.CLienteFisica" + e);
		}
	}

	public void criarClienteJuridica(String nome, String endereco, String telefone, String cnpj) {
		try {
			clientes.add(new PessoaJuridica(nome, endereco, telefone, cnpj));
			escreve(arquivoCliente, clientes);
			System.out.println("Adicionado!");
		} catch (Exception e) {
			System.out.println("Sistema.CLienteJuridica" + e);
		}
	}

	public void listarClientes() {
		try {
			for (Cliente cliente : clientes) {
				System.out.println("ID: " + cliente.getId() + " Nome: " + cliente.getNome() + " " + cliente.getDado()
						+ " Endereco: " + cliente.getEndereco() + " Telefone: " + cliente.getTelefone());
			}
		} catch (Exception e) {
			System.out.println("Sistema.ListarCliente" + e);
		}
	}

	public void criarPrestador(String nome, String funcao) {
		try {
			prestadores.add(new Prestador(nome, funcao));
			escreve(arquivoPrestador, prestadores);;
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
			escreve(arquivoImovel, imoveis);
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
		}
		
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
			System.out.println("Adicionado!! Listando itens orçamento:");
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
			System.out.println("Adicionado!! Listando itens orcamento:");
			orcamento.listaServico();
		} catch (Exception e) {
			System.out.println("sistema.addItensOrcamento por ID " + e);
		}
	}
	
	public void listaMaterial(int idOrcamento) {
		try {
			Orcamento orcamento = pegaOrcamento(idOrcamento);
			orcamento.listaServico();
		} catch (Exception e) {
			System.out.println("sistema.listaMaterial " + e);
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
