package pages.capa.direita;

import org.openqa.selenium.By;

import br.com.infoglobo.pages.AceitacaoAbstractTest;

public class BoxHoroscopo extends AceitacaoAbstractTest {
	
	private Object urlDaPagina;
	private Object urlAposClicar;

	public BoxHoroscopo() throws Exception{
		super();
		this.urlDaPagina = getDriver().getCurrentUrl();
	}

	public boolean exibiuBoxHoroscopo() {
		return getDriver().findElement(By.xpath("//div[@class='horoscopo clearfix']")).isDisplayed();
	}

	public boolean exibiuTituloHoroscopo() {
		return getDriver().findElement(By.xpath("//div[@class='horoscopo clearfix']/p/a")).isDisplayed();
	}

	public boolean exibiuImagemDoSigno() {
		return getDriver().findElement(By.xpath("//div[@class='horoscopo clearfix']/a")).isDisplayed();
	}

	public boolean exibiuNomeDoSigno() {
		return getDriver().findElement(By.xpath("//div[@class='horoscopo clearfix']/div/p/a/span[1]")).isDisplayed();
	}

	public boolean exibiuIntervaloDeDatasDoSigno() {
		return getDriver().findElement(By.xpath("//div[@class='horoscopo clearfix']/div/p/a/span[2]")).isDisplayed();
	}

	public boolean exibiutextoDoSigno() {
		return getDriver().findElement(By.xpath("//div[@class='horoscopo clearfix']/div/span/a")).isDisplayed();
	}

	public boolean exibiuLinkLeiaMais() {
		return getDriver().findElement(By.xpath("//div[@class='horoscopo clearfix']/div/span/a/span")).isDisplayed();
	}
	
	public int exibiuDozeImagensDosSignos() {
		return getDriver().findElements(By.xpath("//div[@class='horoscopo clearfix']/ul/li")).size();
	}

	public void clicouNoTituloHoroscopo() {
		getDriver().findElement(By.xpath("//div[@class='horoscopo clearfix']/p/a")).click();	
	}

	public boolean redirecionouParaAPaginaDoHoroscopo() {
		return this.urlDaPagina != this.urlAposClicar;
	}

	public void clicouNoTextoDoSigno() {
		getDriver().findElement(By.xpath("//div[@class='horoscopo clearfix']/div/span/a")).click();	
	}
	
	public void clicouNoLinkLeiaMais() {
		getDriver().findElement(By.xpath("//div[@class='horoscopo clearfix']/div/span/a/span")).click();	
	}

	public void clicouEmUmSignoDaListagem() {
		getDriver().findElement(By.xpath("//div[@class='horoscopo clearfix']/ul/li[11]/a")).click();
	}
}