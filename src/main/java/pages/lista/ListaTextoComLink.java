package pages.lista;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import br.com.infoglobo.pages.AceitacaoAbstractTest;
import br.com.infoglobo.pages.Navegador;

public class ListaTextoComLink extends AceitacaoAbstractTest {
	private String urlDaPagina;
	private String urlAposClicar;
	
	public ListaTextoComLink() throws Exception {
		super();
	}
	
	public ListaTextoComLink(Navegador navegador) throws Exception {
		super(navegador);
		this.urlDaPagina = getDriver().getCurrentUrl();
	}
	
	public WebElement exibiuTextoNoFato() {
		return getDriver().findElement(By.className("itens-container")).findElement(By.className("itens-lista")).findElement(By.className("item"));
	}
	
	public boolean exibiuLinkNoTexto() {
		return exibiuTextoNoFato().findElement(By.className("subtitulo-foto")).findElement(By.tagName("a")).isDisplayed();
	}
	
	public boolean exibiuLinkValidoNoTexto() {
		return !exibiuTextoNoFato().findElement(By.className("subtitulo-foto")).findElement(By.tagName("a")).getAttribute("href").isEmpty();
	}

	public boolean exibiuMaximoDeCaracteresComUmLinkTexto() {
		String textoDaListaComLink = exibiuTextoNoFato().findElement(By.className("subtitulo-foto")).getText();
		return textoDaListaComLink.replaceAll("<a\\b[^>]*>", "").replaceAll("</a>", "").length() < 1300;
	}

	public void clicouNoLink() {
		getDriver().findElement(By.xpath("//div[@class='dez-mais-lista']/div/div/div/ul/li[1]/div/div/a")).click();	
	}

	public boolean abriuEmUmaNovaJanela() {
		return this.urlDaPagina == this.urlAposClicar;
	}
}
