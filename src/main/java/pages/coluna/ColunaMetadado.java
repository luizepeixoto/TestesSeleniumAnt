package pages.coluna;

import br.com.infoglobo.pages.AceitacaoAbstractTest;

public class ColunaMetadado extends AceitacaoAbstractTest {
	
	public ColunaMetadado() throws Exception {
		super();
	}

	public String exibiuCodigoFonteDaPagina(){
		return getDriver().getPageSource();
	}
}