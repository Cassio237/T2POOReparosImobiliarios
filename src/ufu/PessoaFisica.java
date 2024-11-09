package ufu;


import java.util.ArrayList;

public class PessoaFisica extends Cliente{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String cpf;
	private static ArrayList<String> CPFs = new ArrayList<String>(); // para usar no validador, static
	
	public PessoaFisica(String nome, String endereco, String telefone, String cpf) throws Exception {
		super(nome, endereco, telefone);
		if (validar(cpf)) {
			throw new Exception("CPF já registrado!"); // Joga exception para parar o processo
		}
		this.cpf = cpf;
		CPFs.add(cpf);
	}
	
	public String getDado() {
		return "CPF: " + cpf;
	}
	
	// Aqui eu valido verificando se nao ha o mesmo cpf (poderia colocar o famoso validador de cpf mas seria complicar o uso). *seria melhor na classe sistema
	@Override
	boolean validar(String cpf) {
		return CPFs.contains(cpf);
	}
}
