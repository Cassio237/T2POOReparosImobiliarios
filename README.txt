Cássio Ramos 12411BSI328
Guilherme Aparecido de Assis Alves 14211BSI330    
Wellington dos Reis Ferreira 12111BSI286
(Linha 12)

-- Metodo Exception em MinhaExcessoes com nome de OrcamentoException
-- Metodos de leitura e escrita em Uufu na classe sistema com o nome de ler e escreve, os arquivos ficam em "Files"
-- Quase todas view compilam sozinhas, somente addServicoView e addMaterialView que nao

Nota: Tentei fazer todas compilarem de forma independente, instancio um Sistema para cada tela, fiz algumas mudanças como remover os ID e me arrependi pois dificulta deixar as cada tela independente.


**********
Arquivos estão dentro da pasta src/ufu.

O modelo foi escolhido pelo grupo e segue uma logica de criar orcamentos para reparo imobiliarios, serao feito orçamentos simples que poderao ter servicos e materiais, os Orcamento tem imoveis que tem proprietarios que podem ser ou nao responsaveis pelo orçameto

Classe total 12 sendo 7 para a logica do negocio

	Cliente
		Juridica
		Fisica
	Imovel
	Prestador
	Orcamento
	Servico <implements> Material, Reparo
	Materiais
	Financeiro

	Sistema (onde ficam maioria do metodos do sistema)
	Main (seria o app, na versao com front nao será ultilizado)

Classe abstratas 1:
	Classe Cliente é abstrata, nao iniciasse um cliente sem ser pessoa fisica ou juridica.

Classe Interface 2:
	Reparo
	Material

Metodos abstrato 4:
	Cliente.validar
	Reparo.concluirReparo
	Material.comproMateriais
	Material.temMateriais

Metodos com sobrecarga 3:
	Sistema.aprovarOrcamento
	Sistema.addItensOrcamento
	Sistema.addServicoOrcamento

Metodos sobrescritos 5:
	PessoaFisica.validar
	PessoaJuridica.validar
	Servico.concluirReparo
	Servico.comproMateriais
	Servico.temMateriais

Link do GitHub do projeto: https://github.com/Cassio237/T2POOReparosImobiliarios