package pages.json.aplicativos;

import br.com.infoglobo.pages.AceitacaoAbstractTest;

public class JsonHome extends AceitacaoAbstractTest {
	
	public JsonHome() throws Exception {
		super();
	}
	
	public boolean retornaConteudoDoJson(){
		String codigoFonte = getDriver().getPageSource();
		return !codigoFonte.isEmpty();
	}
}