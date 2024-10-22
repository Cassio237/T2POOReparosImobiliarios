package ufu;

public interface Material {

	public Double valorMateriais(); // Metodo que obriga o valor ser calculado
	
	public boolean temMateriais(boolean temMaterial); // Verifica se ha necessidade de materiais
	
	public boolean comproMateriais(); // Metodo pra explicitar se materiais foram comprados

}
