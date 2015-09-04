package pages.materia;

public class MateriaComTresPublicidades extends MateriaComUmaPublicidade {
	
	public MateriaComTresPublicidades() throws Exception {
		super();
	}
	
	public boolean exibiuApenasTresPublicidades() {
		return listaDePropagandas().size() == Integer.parseInt("3");
	}
	
	public boolean exibiuNoMinimo10Paragrafos() {
		return listaDeTagsP().size() >= 10;
	}
}