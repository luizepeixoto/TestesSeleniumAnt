package pages.capa.direita;

import org.openqa.selenium.By;

import br.com.infoglobo.pages.AceitacaoAbstractTest;

public class BoxMemoria extends AceitacaoAbstractTest {
	
	private String urlDaPagina;
	private String urlAposClicar;
	
	public BoxMemoria() throws Exception{
		super();
		this.urlDaPagina = getDriver().getCurrentUrl();
	}

	public boolean exibiuBoxMemoria() {
		return getDriver().findElement(By.className("memoria")).isDisplayed();
	}

	public String exibiuTituloMemoria() {
		return getDriver().findElement(By.xpath("//div[@class='memoria']/p/a")).getText();
	}

	public boolean exibiuTituloDaChamada() {
		return !getDriver().findElement(By.xpath("//div[@class='memoria']/div/div/span/a")).getText().isEmpty();
	}

	public boolean exibiuEditoriaDaChamada() {
		return !getDriver().findElement(By.xpath("//div[@class='memoria']/div/div/p")).getText().isEmpty();
	}

	public void clicounoTituloMemoria() throws InterruptedException {
		getDriver().findElement(By.xpath("//div[@class='memoria']/p/a")).click();
		esperaCarregar(1);
	}

	public boolean redirecionouParaAPaginaDoMemoria() {
		return this.urlDaPagina != this.urlAposClicar;
	}

	public void clicouNoTituloDaChamada() throws InterruptedException {
		getDriver().findElement(By.xpath("//div[@class='memoria']/div/div/span/a")).click();
		esperaCarregar(1);
	}

	public boolean redirecionouParaOConteudoDaChamada() {
		return this.urlDaPagina != this.urlAposClicar;
	}
}