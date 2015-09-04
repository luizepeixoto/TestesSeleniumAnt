package pages.temporeal;

import org.openqa.selenium.By;

import br.com.infoglobo.pages.AceitacaoAbstractTest;
import br.com.infoglobo.pages.Navegador;

public class TabSobreOJogo extends AceitacaoAbstractTest {
	
	public TabSobreOJogo(Navegador navegador) throws Exception{
		super(navegador);
	}

	public void clicouNaAbaSobreOJogo() throws InterruptedException {
		Thread.sleep(2000);
		getDriver().findElement(By.id("infog-2")).click();
		
	}
	
	public boolean exibiuConteudoSobreOJogo() {
		return getDriver().findElement(By.xpath("//div[@class='infog-2 small-16 medium-16 large-16 column']/img")).isDisplayed();
	}
	

}
