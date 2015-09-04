package pages.capa.direita;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import br.com.infoglobo.pages.AceitacaoAbstractTest;
import br.com.infoglobo.pages.Navegador;

public class BoxEdicaoDigital  extends AceitacaoAbstractTest{
	
	private String urlDaPagina;
	private String urlAposClicar;
	
	public BoxEdicaoDigital (Navegador navegador) throws Exception {
		super(navegador);
		this.urlDaPagina = getDriver().getCurrentUrl();
	}

	public WebElement exibiuClasseEdicaoDigital(){
		return getDriver().findElement(By.className("edicao-digital"));
	}
	
	public boolean exibiuBoxEdicaoDigital() throws InterruptedException{
		esperaCarregar(3);
		executarScroll(exibiuClasseEdicaoDigital().getLocation().toString());
		esperaCarregar(2);
		return exibiuClasseEdicaoDigital().isDisplayed();
	}
	
	public String tituloEdicaoDigital() {
		return exibiuClasseEdicaoDigital().findElement(By.tagName("p")).getText();
	}
	
	public boolean exibiuLinkNoTituloDeEdicaoDigital() {
		return exibiuClasseEdicaoDigital().findElement(By.tagName("p")).findElement(By.tagName("a")).isDisplayed();
	}
	
	public boolean exibiuLinkValidoNoTituloDeEdicaoDigital() {
		return !exibiuClasseEdicaoDigital().findElement(By.tagName("p")).findElement(By.tagName("a")).getAttribute("href").isEmpty();
	}
	
	public String tituloAutoCritica() {
		return exibiuClasseEdicaoDigital().findElement(By.className("clearfix")).findElement(By.tagName("p")).getText().toLowerCase();
	}

	public boolean descricaoDigital() {
		return !exibiuClasseEdicaoDigital().findElement(By.className("clearfix")).findElement(By.tagName("a")).findElement(By.tagName("span")).getText().isEmpty();
	}

	public boolean exibiuBotaoParaVersaoWeb() {
		return exibiuClasseEdicaoDigital().findElement(By.className("clearfix")).findElement(By.className("web")).isDisplayed();
	}

	public boolean exibiuLinkNoBotaoDaVersaoWeb() {
		return exibiuClasseEdicaoDigital().findElement(By.className("clearfix")).findElement(By.className("web")).findElement(By.tagName("a")).isDisplayed();
	}
	
	public boolean exibiuLinkValidoNoBotaoDaVersaoWeb() {
		return !exibiuClasseEdicaoDigital().findElement(By.className("clearfix")).findElement(By.className("web")).findElement(By.tagName("a")).getAttribute("href").isEmpty();
	}
	
	public boolean botaoAssine() {
		return exibiuClasseEdicaoDigital().findElement(By.className("clearfix")).findElement(By.className("assine")).isDisplayed();
	}

	public boolean botaoVersaoCelular() {
		return exibiuClasseEdicaoDigital().findElement(By.className("clearfix")).findElement(By.className("browser")).isDisplayed();
	}
	
	public boolean exibiuLinkNoBotaoDaVersaoCelular() {
		return exibiuClasseEdicaoDigital().findElement(By.className("clearfix")).findElement(By.className("browser")).findElement(By.tagName("a")).isDisplayed();
	}
	
	public boolean exibiuLinkValidoNoBotaoDaVersaoCelular() {
		return !exibiuClasseEdicaoDigital().findElement(By.className("clearfix")).findElement(By.className("browser")).findElement(By.tagName("a")).getAttribute("href").isEmpty();
	}
	
	public void clicouNoBotaoParaAcessarAEdicaoDigital() {
		exibiuClasseEdicaoDigital().findElement(By.className("clearfix")).findElement(By.className("web")).click();
	}
	
	public String getUrlAtual() {
		return getDriver().getCurrentUrl();
	}

	public boolean redirecionouParaAEdicaoDigital() {
		return this.urlDaPagina != this.urlAposClicar;
	}

	public void clicouNoBotaoAssine() {
		exibiuClasseEdicaoDigital().findElement(By.className("clearfix")).findElement(By.className("assine")).click();
	}

	public boolean redirecionouParaAssinar() {
		return this.urlDaPagina != this.urlAposClicar;
	}

	public void clicouNoBotaoParaVersaoCelular() {
		exibiuClasseEdicaoDigital().findElement(By.className("clearfix")).findElement(By.className("browser")).click();
		
	}

	public boolean redirecionouParaVersaoCelular() {
		return this.urlDaPagina != this.urlAposClicar;
	}

	public void clicouNoTituloEdicaoDigital() {
		getDriver().findElement(By.xpath("//div[@class='edicao-digital clearfix']/p/a")).click();
		
	}

	public boolean redirecionouParaOGloboDigital() {
		return this.urlDaPagina != this.urlAposClicar;
	}

	public void clicouNaCapinha() {
		getDriver().findElement(By.xpath("//div[@class='edicao-digital clearfix']/a/img")).click();
	}
}