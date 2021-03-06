package pages.newsletter;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import br.com.infoglobo.pages.AceitacaoAbstractTest;
import br.com.infoglobo.pages.Navegador;

public class NewsletterPaginaPadrao extends AceitacaoAbstractTest {
	
	public NewsletterPaginaPadrao(Navegador navegador) throws Exception {
		super(navegador);
	}
	
	protected WebElement obterCabecalho() {
		return getDriver().findElement(By.className("newsGlobo"));
	}

	protected WebElement obterHeader() {
		return getDriver().findElement(By.className("newsHeader"));
	}
	
	protected WebElement obterRodape() {
		return getDriver().findElement(By.className("newsFooter"));
	}
	
	protected boolean naoExibiuBordaNaImagem(WebElement imagem) {
		return imagem.getCssValue("border-top-width").equals("0px");
	}
}