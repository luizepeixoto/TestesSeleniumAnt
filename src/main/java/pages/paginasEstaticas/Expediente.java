package pages.paginasEstaticas;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import br.com.infoglobo.pages.AceitacaoAbstractTest;
import br.com.infoglobo.pages.Navegador;

public class Expediente extends AceitacaoAbstractTest{

	public Expediente() throws Exception {
		super();
	}
	
	public Expediente(Navegador navegador) throws Exception {
		super(navegador);
	}
	
	public WebElement exibiuPublicidade() {
		return getDriver().findElement(By.className("publicidade"));
	}
	
	public boolean exibiuBannerDeAssinatura() {
		return getDriver().findElements(By.className("subscriptionFooter")).size()==0;
	}

	public boolean exibiuBoxDeExpediente() {
		return getDriver().findElement(By.id("exp")).isDisplayed();
	}

	
}

