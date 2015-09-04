package pages.erros;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import br.com.infoglobo.pages.AceitacaoAbstractTest;
import br.com.infoglobo.pages.Navegador;

public class Pagina404 extends AceitacaoAbstractTest {
	
	public Pagina404() throws Exception {
		super();
	}
	
	public Pagina404(Navegador navegador) throws Exception {
		super(navegador);
	}
	
	public void esperarPaginaCarregar() throws InterruptedException{
		Thread.sleep(6000);
	}
	
	public WebElement exibiuClasseErroContainer() {
		return getDriver().findElement(By.className("erro-container"));
	}
	
	public String exibiuOTituloNaPagina() {
		return exibiuClasseErroContainer().findElement(By.className("heading")).getText();
	}
	
	public String exibiuDescricaoNaPagina() {
		return exibiuClasseErroContainer().findElement(By.className("description")).findElement(By.tagName("p")).getText();
	}
	
	public String exibiuLinkDePaginaInicial() {
		return exibiuClasseErroContainer().findElement(By.className("description")).findElement(By.tagName("p")).findElement(By.tagName("a")).getText();
	}
	
	public boolean exibiuLinkValidoEmPaginaInicial() {
		return !exibiuClasseErroContainer().findElement(By.className("description")).findElement(By.tagName("p")).findElement(By.tagName("a")).getAttribute("href").isEmpty();
	}
	
	public String exibiuTituloDeBusca() {
		return exibiuClasseErroContainer().findElement(By.className("description")).findElements(By.tagName("p")).get(1).getText();
	}
	
	public WebElement exibiuBoxDeFormulario() {
		return getDriver().findElement(By.className("formulario-busca"));
	}
	
	public WebElement exibiuBusca() {
		return exibiuBoxDeFormulario().findElement(By.className("search-input"));
	}
	
	public boolean exibiuBotaoDeBusca() {
		return getDriver().findElement(By.id("search-submit-corpo")).isDisplayed();
	}
	
	public void executarScrollAteAPosicaoDeBusca() throws InterruptedException{
		Thread.sleep(500);
		executarScroll(getDriver().findElement(By.cssSelector("#formBuscaCorpo > div.input-container > #q")).getLocation().toString());
	}
	
	public boolean executarBusca404() throws InterruptedException {
		esperarPaginaCarregar();
		getDriver().findElement(By.cssSelector("#formBuscaCorpo > div.input-container > #q")).sendKeys("Novelas");
		exibiuBoxDeFormulario().findElement(By.xpath("//*[@id=\"search-submit-corpo\"]")).click();
		esperarPaginaCarregar();
		while (! getDriver().findElement(By.id("conteudo")).isDisplayed()) {
			if (getDriver().findElement(By.id("conteudo")).isDisplayed()) {
				break;
			}
		}
		List<WebElement> resultadoBusca = getDriver().findElements(By.id("conteudo"));
		return resultadoBusca.size() > Integer.parseInt("0");
	}
}
