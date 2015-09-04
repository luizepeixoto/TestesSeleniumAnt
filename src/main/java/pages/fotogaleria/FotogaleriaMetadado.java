package pages.fotogaleria;

import br.com.infoglobo.pages.AceitacaoAbstractTest;

public class FotogaleriaMetadado extends AceitacaoAbstractTest {
	
	public FotogaleriaMetadado() throws Exception {
		super();
	}

	public String exibiuCodigoFonteDaPagina(){
		return getDriver().getPageSource();
	}
}
