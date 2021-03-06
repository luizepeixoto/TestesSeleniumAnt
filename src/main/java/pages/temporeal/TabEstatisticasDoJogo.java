package pages.temporeal;

import org.openqa.selenium.By;

import br.com.infoglobo.pages.AceitacaoAbstractTest;
import br.com.infoglobo.pages.Navegador;

public class TabEstatisticasDoJogo extends AceitacaoAbstractTest {
	
	public TabEstatisticasDoJogo(Navegador navegador) throws Exception{
		super(navegador);
	}
	
	public void clicouNaAbaEstatisticasDoJogo() throws InterruptedException {
		Thread.sleep(3000);
		getDriver().findElement(By.id("infog-4")).click();
	}

	public boolean exibiuImagem() throws InterruptedException {
		Thread.sleep(500);
		return getDriver().findElement(By.className("conteudo-infografico")).findElement(By.className("infog-4")).findElement(By.tagName("img")).isDisplayed();
	}

	public boolean exibiuWidth() throws InterruptedException {
		String widthAtual = getDriver().findElement(By.className("conteudo-infografico")).findElement(By.className("infog-3")).findElement(By.tagName("img")).getAttribute("width");
		Thread.sleep(500);
		return  Integer.parseInt(widthAtual) <= 630;
	}	
	
	public boolean exibiuHeight() throws InterruptedException {
		String heightAtual = getDriver().findElement(By.className("conteudo-infografico")).findElement(By.className("infog-3")).findElement(By.tagName("img")).getAttribute("height");
		Thread.sleep(500);
		return  Integer.parseInt(heightAtual) <= 500;
	}
	
}
