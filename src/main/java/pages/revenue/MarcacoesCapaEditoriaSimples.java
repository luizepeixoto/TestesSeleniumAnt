package pages.revenue;

import br.com.infoglobo.pages.AceitacaoAbstractTest;

public class MarcacoesCapaEditoriaSimples extends AceitacaoAbstractTest {
	
	public MarcacoesCapaEditoriaSimples() throws Exception {
		super();
	}

	public String exibiuCodigoFonteDaPagina() {
		getDriver().manage().deleteAllCookies();
		return getDriver().getPageSource();
	}

	
}
