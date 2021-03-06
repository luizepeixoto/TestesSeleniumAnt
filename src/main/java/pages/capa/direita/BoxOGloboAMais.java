package pages.capa.direita;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import br.com.infoglobo.pages.AceitacaoAbstractTest;

public class BoxOGloboAMais extends AceitacaoAbstractTest {
	
	private String urlDaPagina;
	private String urlAposClicar;
	
	public BoxOGloboAMais() throws Exception{
		super();
		this.urlDaPagina = getDriver().getCurrentUrl();
	}
	
	public WebElement boxOGloboAMais(){
		return getDriver().findElement(By.className("ogloboamais"));
	}

	public boolean exibiuBoxOGloboAMais() {
		return boxOGloboAMais().isDisplayed();
	}

	public boolean exibiuTituloOGloboAMais() {
		return !boxOGloboAMais().findElement(By.className("titulo")).getText().isEmpty();
	}

	public boolean exibiuAntetituloDoConteudo() {
		return !boxOGloboAMais().findElement(By.className("materia")).findElement(By.tagName("em")).getText().isEmpty();
	}

	public boolean exibiuTituloDoConteudo() {
		return !boxOGloboAMais().findElement(By.className("materia")).findElement(By.tagName("a")).getText().isEmpty();
	}

	public boolean exibiuImagemDoConteudo() {
		return boxOGloboAMais().findElement(By.tagName("a")).findElement(By.tagName("img")).isDisplayed();
	}

	public void clicouNoTituloDoConteudo() throws InterruptedException {
		esperaCarregar(1);
		getDriver().findElement(By.xpath("//div[@class='ogloboamais']/div/div/a")).click();
	}

	public boolean redirecionouParaAPaginaDoConteudo() throws InterruptedException {
		esperaCarregar(2);
		return this.urlDaPagina != this.urlAposClicar;
	}

	public void clicouNaImagemDoConteudo() throws InterruptedException {
		esperaCarregar(1);
		getDriver().findElement(By.xpath("//div[@class='ogloboamais']/a/img")).click();
	}
}