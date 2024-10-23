package ufu;

import java.util.Scanner;

public class Main {
	private static Sistema sistema = new Sistema();
	private static Scanner scanner = new Scanner(System.in);
	

	public static void main(String[] args) {	
		autoCliente();
		autoPrestador();
		autoImovel();
		autoOrcamento();
		
		int opcao = 0;
		do {
			menu();
			opcao = lerInt();
			int opcaoMenu = 0;
			switch (opcao) {
			case 1:
				System.out.println("1 - Cadastrar Cliente Pessoa Fisica");
				System.out.println("1 - Cadastrar Cliente Pessoa Juridica");
				System.out.println("3 - Lista Clientes");
				System.out.println("0 - Voltar");
				opcaoMenu = lerInt();
				switch (opcaoMenu) {
				case 1:
					cadastraClienteFisica();
					break;
				case 2:
					cadastraClienteJuridico();
					break;
				case 3:
					sistema.listarClientes();
					break;
				case 0:
					System.out.println("Voltando ao menu");
					break;
				default:
					System.out.println("Valor incorreto!");
					break;
				}
				break;
			case 2:
				System.out.println("1 - Cadastrar Imoveis");
				System.out.println("2 - Listar Imoveis");
				System.out.println("0 - Voltar");
				opcaoMenu = lerInt();
				switch (opcaoMenu) {
				case 1:
					cadastraImovel();
					break;
				case 2:
					sistema.listarImovel();
					break;
				case 0:
					System.out.println("Voltando ao menu");
					break;
				default:
					System.out.println("Valor incorreto!");
					break;
				}
				break;
			case 3:
				System.out.println("1 - Cadastrar Prestador");
				System.out.println("2 - Listar Prestadores");
				System.out.println("0 - Voltar");
				opcaoMenu = lerInt();
				switch (opcaoMenu) {
				case 1:
					cadastraPrestador();
					break;
				case 2:
					sistema.listarPrestador();
					break;
				case 0:
					System.out.println("Voltando ao menu");
					break;
				default:
					System.out.println("Valor incorreto!");
					break;
				}
				break;
			case 4:
				System.out.println("1 - Fazer Orçamento");
				System.out.println("2 - Listar Orçamento");
				System.out.println("3 - Listar Orçamento Detalhado");
				System.out.println("4 - Continua Orçamento");
				System.out.println("5 - Aprovar Orçamento");
				System.out.println("0 - Voltar");
				opcaoMenu = lerInt();
				switch (opcaoMenu) {
				case 1:
					fazerOrcamento();
					break;
				case 2:
					sistema.listaOrcamento();
					break;
				case 3:
					orcamentoDetalhado();
					break;
				case 4:
					continuarOrcamento();
					break;
				case 5:
					aprovaOrcamento();
					break;
				case 0:
					System.out.println("Voltando ao menu");
					break;
				default:
					System.out.println("Valor incorreto!");
					break;
				}
				break;
			case 5:
				System.out.println("1 - Listar Orcamentos Aprovados");
				System.out.println("0 - Voltar");
				opcaoMenu = lerInt();
				switch (opcaoMenu) {
				case 1:
					sistema.listarFinancas();
					break;
				case 0:
					System.out.println("Voltando ao menu");
					break;
				default:
					System.out.println("Valor incorreto!");
					break;
				}
				break;
			case 0:
				System.out.println("Encerrando!");
				break;
			default:
				System.out.println("Opcao invalida!");
				break;
			}	
		} while (opcao != 0);
		scanner.close();
	}
	
	public static void aprovaOrcamento() {
		System.out.println("*** Lista de Orcamentos para auxiliar***");
		sistema.listaOrcamento();
		System.out.println("Digite o ID do orcamento a ser aprovado abaixo");
		int idOrcamento = lerInt();
		
		sistema.aprovarOrcamento(idOrcamento, true);
	}
	
	public static void orcamentoDetalhado() {
		System.out.println("*** Lista de Orcamentos para auxiliar***");
		sistema.listaOrcamento();
		System.out.println("Digite o ID do orcamento a ser detalhado abaixo");
		int idOrcamento = lerInt();
		
		sistema.listaOrcamentoDetalhado(idOrcamento);
	}
	
	public static void continuarOrcamento() {
		System.out.println("*** Lista de Orcamentos para auxiliar***");
		sistema.listaOrcamento();
		int opcaoOrcamento = 0;
		System.out.println("Deseja adicionar serviços e/ou produtos ao orçamento?");
		System.out.println("1 - Adicionar Serviços");
		System.out.println("2 - Adicionar Produtos ao Serviços");
		opcaoOrcamento = lerInt();
		switch (opcaoOrcamento) {
		case 1:
			System.out.println("Digite o ID do orcamento a ter serviço adicionado");
			int idOrcamento = lerInt();
			System.out.println("***Lista de Prestadores para auxiliar***");
			sistema.listarPrestador();
			System.out.println("Digite o id do prestador abaixo (Precisa ser um id valido!)");
			int idPrestador = lerInt();
			System.out.println("Digite o valor do serviço abaixo");
			Double valorServico = lerDouble();
			System.out.println("Digite o tipo de serviço abaixo");
			String tipoServico = lerString();
			
			sistema.addServicoOrcamento(idOrcamento, idPrestador, valorServico, tipoServico);
			
			int opcaoMaterial = 0;
			System.out.println("Deseja adicionar materiais a esse serviço?");
			System.out.println("Digite 1 para SIM ou outro valor para NÃO");
			opcaoMaterial = lerInt();
			while (opcaoMaterial == 1) {
				System.out.println("Digite o nome do produto abaixo");
				String nomeMaterial = lerString();
				System.out.println("Digite a quantidade de produtos abaixo");
				int quantidadeMaterial = lerInt();
				System.out.println("Digite o valor unitario abaixo");
				Double valorMaterial = lerDouble();
				
				sistema.addItensOrcamento(idOrcamento, tipoServico, nomeMaterial, quantidadeMaterial, valorMaterial);
				
				System.out.println("Adicionar mais materiais ao serviços?");
				System.out.println("Digite 1 para SIM ou outro valor para NÃO");
				opcaoMaterial = lerInt();
			}
			System.out.println("Servico adicionado!");
			break;
		case 2:
			System.out.println("Digite o ID do orcamento a ter serviço adicionado");
			int idOrcamentoMaterial = lerInt();
			System.out.println("Lista de Servicos para auxiliar");
			sistema.listaMaterial(idOrcamentoMaterial);
			System.out.println("Digite o serviço que tra material adicionado abaixo (Precisa já existir serviço)");
			String tipoServicoMaterial = lerString();
			System.out.println("Digite o nome do material abaixo");
			String nomeMaterial = lerString();
			System.out.println("Digite a quantidade abaixo:");
			int quantMaterial = lerInt();
			System.out.println("Digite o valor unitario abaixo");
			Double valorTMaterial = lerDouble();
			
			sistema.addItensOrcamento(idOrcamentoMaterial, tipoServicoMaterial, nomeMaterial, quantMaterial, valorTMaterial);

		default:
			System.out.println("Valor incorreto, nada feito!");
			break;
		}
	}
	
	public static void fazerOrcamento() {
		System.out.println("***Lista de imoveis para auxiliar***");
		sistema.listarImovel();
		System.out.println("Digite o ID do imovel abaixo");
		int idImovel = lerInt();
		System.out.println("***Lista de nome dos cliente para auxiliar***");
		sistema.listarClientes();
		System.out.println("Digite o nome do responsavel pelo orcamento (Precisa já estar cadastrado)");
		String clienteNome = lerString();
		
		sistema.iniciarOrcamento(idImovel, clienteNome);
		
		int opcaoServico = 0;
		System.out.println("Deseja adicionar serviços ao orçamento?");
		System.out.println("Digite 1 para SIM ou outro valor para NÃO");
		opcaoServico = lerInt();
		while (opcaoServico == 1) {
			System.out.println("***Lista de Prestadores para auxiliar***");
			sistema.listarPrestador();
			System.out.println("Digite o id do prestador abaixo (Precisa ser um id valido!)");
			int idPrestador = lerInt();
			System.out.println("Digite o valor do serviço abaixo");
			Double valorServico = lerDouble();
			System.out.println("Digite o tipo de serviço abaixo");
			String tipoServico = lerString();
			
			sistema.addServicoOrcamento(idPrestador, valorServico, tipoServico);
			
			int opcaoMaterial = 0;
			System.out.println("Deseja adicionar materiais a esse serviço?");
			System.out.println("Digite 1 para SIM ou outro valor para NÃO");
			opcaoMaterial = lerInt();
			while (opcaoMaterial == 1) {
				System.out.println("Digite o nome do produto abaixo");
				String nomeMaterial = lerString();
				System.out.println("Digite a quantidade de produtos abaixo");
				int quantidadeMaterial = lerInt();
				System.out.println("Digite o valor unitario abaixo");
				Double valorMaterial = lerDouble();
				
				sistema.addItensOrcamento(tipoServico, nomeMaterial, quantidadeMaterial, valorMaterial);
				
				System.out.println("Adicionar mais materiais ao serviços?");
				System.out.println("Digite 1 para SIM ou outro valor para NÃO");
				opcaoMaterial = lerInt();
			}
			
			System.out.println("Adicionar mais serviços?");
			System.out.println("Digite 1 para SIM ou outro valor para NÃO");
			opcaoServico = lerInt();
		}
		System.out.println("Cliente deseja aprovar orcamento?");
		System.out.println("Digite 1 para SIM ou outro valor para NÃO");
		int aprova = lerInt();
		if(aprova == 1) {
			sistema.aprovarOrcamento(true);
		}
	}
	
	public static void cadastraPrestador() {
		System.out.println("Digite o nome do prestador abaixo");
		String nome = lerString();
		System.out.println("Digite a funçao principal abaixo (Pintor, Encanador, etc");
		String funcao = lerString();
		
		sistema.criarPrestador(nome, funcao);
	}
	
	public static void cadastraImovel() {
		System.out.println("***Lista de nome dos cliente para auxiliar***");
		sistema.listarClientes();
		System.out.println("Digite o nome dono do imovel abaixo (Precisa já esta cadastrado)");
		String nome = lerString();
		System.out.println("Digite o endereco do imovel abaixo");
		String endereco = lerString();
		
		sistema.criarImovel(endereco, nome);
	}
	
	public static void cadastraClienteFisica() {
		System.out.println("Digite o nome abaixo");
		String nome = lerString();
		System.out.println("Digite o endereço abaixo");
		String endereço = lerString();
		System.out.println("Digite o telefone abaixo");
		String telefone = lerString();
		System.out.println("Digite o CPF abaixo");
		String cpf = lerString();
		
		sistema.criarClienteFisica(nome, endereço, telefone, cpf);
	}
	
	public static void cadastraClienteJuridico() {
		System.out.println("Digite o nome abaixo");
		String nome = lerString();
		System.out.println("Digite o endereço abaixo");
		String endereço = lerString();
		System.out.println("Digite o telefone abaixo");
		String telefone = lerString();
		System.out.println("Digite o CPF abaixo");
		String cnpj = lerString();
		
		sistema.criarClienteJuridica(nome, endereço, telefone, cnpj);
	}
	
	public static void menu() {
		System.out.println("\nEscolha uma opção abaixo:");
		System.out.println("1 - Clientes");
		System.out.println("2 - Imoveis");
		System.out.println("3 - Prestadores");
		System.out.println("4 - Orçamentos");
		System.out.println("5 - Financeiro");
		System.out.println("0 - Encerrar programa");
	}
	
	public static double lerDouble() {
	    double numero = 0.0;
	    boolean isValido = false;

	    while (!isValido) {
	        try {
	            System.out.print("Digite um número (Double): ");
	            numero = Double.parseDouble(scanner.nextLine());
	            isValido = true;
	        } catch (Exception e) {
	            System.out.println("Ler Double invalido! Por favor, insira um número decimal válido." + e);
	        }
	    }
	    return numero;
	}
	
	public static int lerInt() {
	    int numero = 0;
	    boolean isValido = false;

	    while (!isValido) {
	        try {
	            System.out.print("Digite um número (Inteiro): ");
	            numero = Integer.parseInt(scanner.nextLine());
	            isValido = true;
	        } catch (Exception e) {
	            System.out.println("Ler int invalido! Por favor, insira um número inteiro." + e);
	        }
	    }
	    return numero;
	}

	public static String lerString() {
	    String texto = "";
	    boolean isValido = false;

	    while (!isValido) {
	        try {
	            System.out.print("Digite um texto: ");
	            texto = scanner.nextLine();
	            isValido = true;
	        } catch (Exception e) {
	            System.out.println("Ler String invalido! Tente novamente.");
	        }
	    }
	    return texto;
	}
	
	public static void autoCliente() {
		sistema.criarClienteFisica("Jose Maria", "Joao Naves 3000" , "45784693677", "14785324489");
		sistema.criarClienteFisica("Tiao Sebas", "Rua dois 1", "48579641267", "117854662146");
		sistema.criarClienteJuridica("Imobiliaria do Zé", "Shopping Center Lj 40", "478448945000157", "34998571254");
		sistema.criarClienteJuridica("Pensionato Cabaré", "Rua Dr. Marcolino 874", "478512654000197", "3438130258");
		sistema.criarClienteFisica("Jose Maria", "Joao Naves 3000" , "45784693677", "14785324489");
		sistema.criarClienteJuridica("Pensionato Cabaré", "Rua Dr. Marcolino 874", "478512654000197", "3438130258");
	}
	
	public static void autoPrestador() {
		sistema.criarPrestador("Flavin Pintor", "Encanador");
		sistema.criarPrestador("Mario Brás", "Pintor");
	}
	
	public static void autoImovel() {
		sistema.criarImovel("Joao Naves 3000", "Jose Maria");
		sistema.criarImovel("Rua Floriano Peixoto 80", "Imobiliaria do Zé");
	}
	
	public static void autoOrcamento() {
		sistema.iniciarOrcamento(200, "Jose Maria");
		sistema.addServicoOrcamento(300, 200.0, "Limpeza");
		sistema.addItensOrcamento("Limpeza", "Torneira", 2, 20.0);
		
		sistema.iniciarOrcamento(201, "Imobiliaria do Zé");
		sistema.addServicoOrcamento(301, 300.0, "Limpeza");
		sistema.addItensOrcamento("Limpeza", "Tomada", 2, 10.0);
		sistema.aprovarOrcamento(true);
		
		sistema.addServicoOrcamento(500, 300, 300.0, "Pintura");
		sistema.aprovarOrcamento(500, false);
	}

}
