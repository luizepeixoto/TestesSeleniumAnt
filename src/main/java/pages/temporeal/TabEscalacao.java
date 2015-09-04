package pages.temporeal;

import org.openqa.selenium.By;

import br.com.infoglobo.pages.AceitacaoAbstractTest;
import br.com.infoglobo.pages.Navegador;

public class TabEscalacao extends AceitacaoAbstractTest {
	
	public TabEscalacao(Navegador navegador) throws Exception{
		super(navegador);
	}

	public void clicarNaAbaDeEscalacao(){
		getDriver().findElement(By.id("infog-3")).click();;
	}
	
	public boolean exibiuTituloValido() {
		return !getDriver().findElement(By.id("infog-3")).findElement(By.tagName("a")).getText().isEmpty();
	}
	
	public boolean exibiuUmLinkNoTitulo() {
		return getDriver().findElement(By.id("infog-3")).findElement(By.tagName("a")).isDisplayed();
	}
	
	public boolean exibiuImagem() {
		return getDriver().findElement(By.className("conteudo-infografico")).findElement(By.className("infog-3")).findElement(By.tagName("img")).isDisplayed();
	}

	public boolean exibiuWidth() {
		String widthAtual = getDriver().findElement(By.className("conteudo-infografico")).findElement(By.className("infog-3")).findElement(By.tagName("img")).getAttribute("width");
		return  Integer.parseInt(widthAtual) <= 630;
	}	
	
	public boolean exibiuHeight() {
		String heightAtual = getDriver().findElement(By.className("conteudo-infografico")).findElement(By.className("infog-3")).findElement(By.tagName("img")).getAttribute("height");
		return  Integer.parseInt(heightAtual) <= 500;
	}
}
