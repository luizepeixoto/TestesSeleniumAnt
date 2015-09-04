package pages.capa.meio;

import org.openqa.selenium.By;

import br.com.infoglobo.pages.AceitacaoAbstractTest;

public class CapaMeioMancheteDuasColunasDuasManchetesComVideo extends AceitacaoAbstractTest {
	
	public CapaMeioMancheteDuasColunasDuasManchetesComVideo() throws Exception{
		super();
	}

	public boolean exibiuVideoComoDestaqueEmMancheteDuasColunasDuasManchetes() {
		return getDriver().findElement(By.xpath("//div[@class='duas-colunas-duas-manchetes lista-materias clearfix']/div/ul/li/div/div/div")).isDisplayed();
	}
	
	

}
