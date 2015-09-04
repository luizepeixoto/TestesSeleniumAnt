package pages.capa.meio;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import crops.CropsCapaColunaDoMeio;

import br.com.infoglobo.pages.AceitacaoAbstractTest;

public class BoxHumor extends AceitacaoAbstractTest {
	
	public BoxHumor() throws Exception {
		super();
	}
	
	public WebElement exibiuBoxDeHumor() {
		return getDriver().findElement(By.className("humor"));
	}

	public String exibiuOTituloHumor() {
		return exibiuBoxDeHumor().findElement(By.className("editoria")).getText();
	}

	public boolean exibiuFoto() {
		return exibiuBoxDeHumor().findElement(By.tagName("img")).isDisplayed();
	}
	
	public boolean exibiuCropCorretoParaAFoto() {
		String urlDaFotoAtual = exibiuBoxDeHumor().findElement(By.tagName("img")).getAttribute("src");
		return urlDaFotoAtual.contains(CropsCapaColunaDoMeio.boxHumor.cropProporcional());
	}
	
	public String getWidthDaFoto() {
		return exibiuBoxDeHumor().findElement(By.tagName("img")).getAttribute("width");
	}

	public String getHeightDaFoto() {
		return exibiuBoxDeHumor().findElement(By.tagName("img")).getAttribute("height");
	}

	public boolean exibiuLinkNaFoto() {
		return exibiuBoxDeHumor().findElement(By.tagName("a")).isDisplayed();
	}

	public boolean exibiuLinkvalidoNaFoto() {
		return !exibiuBoxDeHumor().findElement(By.tagName("a")).getAttribute("href").isEmpty();
	}
}