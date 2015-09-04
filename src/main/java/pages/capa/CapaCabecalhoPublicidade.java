package pages.capa;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import br.com.infoglobo.pages.AceitacaoAbstractTest;
import br.com.infoglobo.pages.Navegador;

public class CapaCabecalhoPublicidade extends AceitacaoAbstractTest {
	
	public CapaCabecalhoPublicidade() throws Exception {
		super();
	}
	
	public CapaCabecalhoPublicidade(Navegador navegador) throws Exception {
		super(navegador);
	}
	
	public WebElement exibiuClasseSuper(){
		return getDriver().findElement(By.className("super-leaderboard"));
	}
	
	public boolean exibiuBannerSuperLeaderboard() {
		return exibiuClasseSuper().isDisplayed();
	}

	public String exibiuTituloPropaganda() {
		return exibiuClasseSuper().findElement(By.tagName("p")).getText();
	}

	public boolean exibiuTituloPropagandaComUmlink() {
		return exibiuClasseSuper().findElement(By.tagName("p")).findElement(By.tagName("a")).isDisplayed();
	}

	public boolean exibiuUmLinkValidoNoTituloPropaganda() {
		return !exibiuClasseSuper().findElement(By.tagName("p")).findElement(By.tagName("a")).getAttribute("href").isEmpty();
	}
	
	public boolean exibiuOLinkDoTituloPropagandaNumaNovaJanela() {
		return exibiuClasseSuper().findElement(By.tagName("p")).findElement(By.tagName("a")).getAttribute("target").equals("_blank");
	}
}