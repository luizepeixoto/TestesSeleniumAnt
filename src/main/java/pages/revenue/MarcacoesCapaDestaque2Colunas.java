package pages.revenue;

import br.com.infoglobo.pages.AceitacaoAbstractTest;

public class MarcacoesCapaDestaque2Colunas extends AceitacaoAbstractTest {
	
	public MarcacoesCapaDestaque2Colunas() throws Exception {
		super();
	}

	public String exibiuCodigoFonteDaPagina() {
		getDriver().manage().deleteAllCookies();
		return getDriver().getPageSource();
	}

	
}
