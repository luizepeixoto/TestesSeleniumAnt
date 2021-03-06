package pages.capa.direita;

import org.openqa.selenium.By;

import br.com.infoglobo.pages.AceitacaoAbstractTest;
import br.com.infoglobo.pages.Navegador;

public class BoxEuReporter extends AceitacaoAbstractTest {
	
	private String urlDaPagina;
	private String urlAposClicar;

	public BoxEuReporter(Navegador navegador) throws Exception{
		super(navegador);
		this.urlDaPagina = getDriver().getCurrentUrl();
	}

	public String exibiuTituloEuReporter() {
		return getDriver().findElement(By.xpath("//div[@class='eu-reporter']/p/a")).getText();
	}

	public boolean exibiuTituloDaChamada() {
		return !getDriver().findElement(By.xpath("//div[@class='eu-reporter']/div/div/span/a")).getText().isEmpty();
	}

	public void clicouNoTituloEuReporter() {
		getDriver().findElement(By.xpath("//div[@class='eu-reporter']/p/a")).click();	
	}

	public boolean redirecionouParaAPaginaDoEuReporter() {
		return this.urlDaPagina != this.urlAposClicar;
	}

	public boolean exibiuBoxEuReporter() {
		return getDriver().findElement(By.className("eu-reporter")).isDisplayed();
	}

	public void clicouNoTituloDaChamada() {
		getDriver().findElement(By.xpath("//div[@class='eu-reporter']/div/div/span/a")).click();
		
	}

	public boolean redirecionouParaOConteudoDaChamada() {
		return this.urlDaPagina != this.urlAposClicar;
	}

	public boolean exibiuConteudoBoxEuReporter() {
		return getDriver().findElement(By.xpath("//div[@class='eu-reporter']/div")).isDisplayed();
	}
}
