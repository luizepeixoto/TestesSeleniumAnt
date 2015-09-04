package pages.newsletter.urgente;

import org.openqa.selenium.By;

import pages.newsletter.NewsletterRodapePaginaPadrao;

import br.com.infoglobo.pages.Navegador;

public class UrgenteRodape extends NewsletterRodapePaginaPadrao {
	
	public UrgenteRodape(Navegador navegador) throws Exception {
		super(navegador);
	}
	
	public boolean naoExibiuOBanner() {
		try {
			obterBanner().isDisplayed();
			return false;
		} catch (Exception e) {
			return true;
		}
	}

	public boolean exibiuABarraAntesDoFooterComACorEsperada() {
		String corEsperada = "rgba(0, 94, 151, 1)";
		return obterRodape().findElement(By.tagName("td")).getCssValue("background-color").equals(corEsperada);
	}
}