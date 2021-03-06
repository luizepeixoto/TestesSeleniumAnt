package pages.capa.direita;

import org.openqa.selenium.By;

import br.com.infoglobo.pages.AceitacaoAbstractTest;

public class BoxVaiRio extends AceitacaoAbstractTest {
	private String urlDaPagina;
	private String urlAposClicar;

	public BoxVaiRio() throws Exception{
		super();
		this.urlDaPagina = getDriver().getCurrentUrl();
	}

	public boolean exibiuBoxVaiRio() {
		return getDriver().findElement(By.xpath("//div[@class='vairio clearfix']")).isDisplayed();
	}

	public boolean exibiuImagemVaiRio() {
		return getDriver().findElement(By.xpath("//div[@class='vairio clearfix']/a/span")).isDisplayed();
	}

	public boolean exibiuTempoDaNoticia() {
		return getDriver().findElement(By.xpath("//div[@class='vairio clearfix']/div/span")).isDisplayed();
	}

	public boolean exibiuChamadaDaNoticia() {
		return getDriver().findElement(By.xpath("//div[@class='vairio clearfix']/div/a/span")).isDisplayed();
	}

	public void clicouNoLogoVaiRio() {
		getDriver().findElement(By.xpath("//div[@class='vairio clearfix']/p/a")).click();		
	}

	public boolean redirecionouParaPaginaDoVaiRio() {
		return this.urlDaPagina != this.urlAposClicar;
	}

	public String exibiuTituloVaiRio() {
		return getDriver().findElement(By.xpath("//div[@class='vairio clearfix']/p/a")).getText();
	}
}