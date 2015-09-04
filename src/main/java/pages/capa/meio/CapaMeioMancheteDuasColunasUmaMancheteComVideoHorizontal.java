package pages.capa.meio;

import org.openqa.selenium.By;

import br.com.infoglobo.pages.AceitacaoAbstractTest;

public class CapaMeioMancheteDuasColunasUmaMancheteComVideoHorizontal extends AceitacaoAbstractTest {
	
	public CapaMeioMancheteDuasColunasUmaMancheteComVideoHorizontal() throws Exception{
		super();
	}

	public boolean exibiuVideoHorizontalComoDestaqueEmMancheteDuasColunasUmaManchete() {
		return getDriver().findElement(By.xpath("//div[@class='duas-colunas-uma-manchete lista-materias clearfix']/div/div/div/div/div")).isDisplayed();
	}

}
