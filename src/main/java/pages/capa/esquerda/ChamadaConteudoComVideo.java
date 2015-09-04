package pages.capa.esquerda;

import org.openqa.selenium.By;

import br.com.infoglobo.pages.AceitacaoAbstractTest;

public class ChamadaConteudoComVideo extends AceitacaoAbstractTest{
	
	public ChamadaConteudoComVideo() throws Exception{
		super();
	}

	public boolean exibiuVideoComoDestaque() {
		return getDriver().findElement(By.xpath("//div[@class='play-box coluna-esquerda']/div")).isDisplayed();
	}
}