package pages.materia;

import br.com.infoglobo.pages.AceitacaoAbstractTest;

public class MateriaMetadado extends AceitacaoAbstractTest {
	
	public MateriaMetadado() throws Exception {
		super();
	}
	
	public String exibiuCodigoFonteDaPagina(){
		return getDriver().getPageSource();
	}
	
}
