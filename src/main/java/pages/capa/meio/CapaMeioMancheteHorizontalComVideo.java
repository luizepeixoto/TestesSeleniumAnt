package pages.capa.meio;

import org.openqa.selenium.By;

import br.com.infoglobo.pages.AceitacaoAbstractTest;

public class CapaMeioMancheteHorizontalComVideo extends AceitacaoAbstractTest{
	
	public CapaMeioMancheteHorizontalComVideo() throws Exception{
		super();
	}

	public boolean exibiuVideoComoDestaqueMancheteHorizontal() {
		return getDriver().findElement(By.xpath("//div[@class='manchete-horizontal lista-materias clearfix']/div/div/div/div/div")).isDisplayed();
	}

}
