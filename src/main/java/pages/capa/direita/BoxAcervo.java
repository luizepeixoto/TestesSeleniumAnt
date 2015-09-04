package pages.capa.direita;

import org.openqa.selenium.By;

import br.com.infoglobo.pages.AceitacaoAbstractTest;

public class BoxAcervo extends AceitacaoAbstractTest {
	
	private String urlDaPagina;
	private String urlAposClicar;

	public BoxAcervo() throws Exception{
		super();
		this.urlDaPagina = getDriver().getCurrentUrl();
	}

	public boolean exibiuBoxAcervo() {
		return getDriver().findElement(By.className("acervo")).isDisplayed();
	}

	public String exibiuTituloAcervo() {
		return getDriver().findElement(By.xpath("//div[@class='acervo']/p/a")).getText();
	}

	public boolean exibiuTituloDaChamada() {
		return !getDriver().findElement(By.xpath("//div[@class='acervo']/div/div/span/a")).getText().isEmpty();
	}

	public boolean exibiuEditoriaDaChamada() {
		return !getDriver().findElement(By.xpath("//div[@class='acervo']/div/div/p")).getText().isEmpty(); 
	}

	public void clicounoTituloAcervo() throws InterruptedException {
		getDriver().findElement(By.xpath("//div[@class='acervo']/p/a")).click();
		esperaCarregar(2);
	}

	public boolean redirecionouParaAPaginaDoAcervo() {
		return this.urlDaPagina != this.urlAposClicar;
	}

	public void clicouNoTituloDaChamada() throws InterruptedException {
		getDriver().findElement(By.xpath("//div[@class='acervo']/div/div/span/a")).click();
		esperaCarregar(2);
	}

	public boolean redirecionouParaOConteudoDaChamada() {
		return this.urlDaPagina != this.urlAposClicar;
	}
}