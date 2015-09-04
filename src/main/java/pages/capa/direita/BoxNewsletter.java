package pages.capa.direita;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import pages.newsletter.BoxNewsletterPaginaPadrao;

import br.com.infoglobo.pages.Navegador;

public class BoxNewsletter extends BoxNewsletterPaginaPadrao {
	
	public BoxNewsletter(Navegador navegador) throws Exception{
		super(navegador);
	}
	
	private WebElement obterFraseInformativaDoBoxDeNewsletter() {
		return obterBoxDeNewsletter().findElement(By.tagName("span"));
	}

	public boolean exibiuAFraseInformativaDoBoxDeNewsletter() {
		if (! obterFraseInformativaDoBoxDeNewsletter().isDisplayed()) {
			System.out.println("O elemento frase informativa não está sendo exibido.");
			return false;
		}
		String fraseEsperada = "As principais notícias do dia no seu e-mail.";
		if (! obterFraseInformativaDoBoxDeNewsletter().getText().equals(fraseEsperada)) {
			System.out.println("O valor do elemento frase informativa não está sendo exibido conforme esperado.");
			return false;
		}
		return true;
	}
}