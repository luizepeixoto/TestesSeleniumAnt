package pages.opine;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import br.com.infoglobo.pages.AceitacaoAbstractTest;
import br.com.infoglobo.pages.Navegador;

public class Opine extends AceitacaoAbstractTest{

	public Opine(Navegador navegador) throws Exception {
		super(navegador);
	}

	public WebElement exibiuOBoxOpine() {
		getDriver().manage().deleteAllCookies();
		return getDriver().findElement(By.className("content"));
	}

	public boolean exibiuOTituloOpine() {
		return !exibiuOBoxOpine().findElement(By.id("content")).getText().isEmpty();
	}

	public boolean exibiuOTituloParaComentar() {
		return !getDriver().findElement(By.className("comentarios")).findElement(By.tagName("h3")).getText().isEmpty();
	}

	public String exibiuOTextoDeLogin() {
		return getDriver().findElement(By.xpath("/html/body/div[3]/div[5]/div[2]/div/div[1]/p[1]/strong")).getText();
	}
	
	public String exibiuOSegundoTexto() {
		return getDriver().findElement(By.xpath("/html/body/div[3]/div[5]/div[2]/div/div[1]/p[2]")).getText();
	}

	public String exibiuOTextoEntrarComMeuLogin() {
		return getDriver().findElement(By.xpath("/html/body/div[3]/div[5]/div[2]/div/div[1]/ul/li[2]/a")).getText();
	}

	public boolean exibiuUmLink() {
		return getDriver().findElement(By.xpath("/html/body/div[3]/div[5]/div[2]/div/div[1]/ul/li[2]/a")).isDisplayed();
	}

	public boolean exibiuUmLinkValido() {
		return !getDriver().findElement(By.xpath("/html/body/div[3]/div[5]/div[2]/div/div[1]/ul/li[2]/a")).getAttribute("href").isEmpty();
	}
}
