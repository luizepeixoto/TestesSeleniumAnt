package pages.materia;

public class MateriaComDuasPublicidades extends MateriaComUmaPublicidade {
	
	public MateriaComDuasPublicidades() throws Exception {
		super();
	}
	
	public boolean exibiuApenasDuasPublicidades() {
		return listaDePropagandas().size() == Integer.parseInt("2");
	}
}