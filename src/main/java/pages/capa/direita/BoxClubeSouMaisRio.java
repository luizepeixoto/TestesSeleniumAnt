package pages.capa.direita;

import org.openqa.selenium.By;

import br.com.infoglobo.pages.AceitacaoAbstractTest;

public class BoxClubeSouMaisRio extends AceitacaoAbstractTest{
	private String urlDaPagina;
	private String urlAposClicar;
	
	public BoxClubeSouMaisRio() throws Exception{
		super();
		this.urlDaPagina = getDriver().getCurrentUrl();
	}

	public boolean exibiuBoxClubeSouMaisRio() {
		return getDriver().findElement(By.xpath("//div[@class='clearfix soumaisrio']")).isDisplayed();
	}

	public void clicouNaImagem() {
		getDriver().findElement(By.xpath("//div[@class='clearfix soumaisrio']/a")).click();	
	}

	public boolean redirecionouParaPaginaClubeSouMaisRio() {
		return this.urlDaPagina != this.urlAposClicar;
	}
}