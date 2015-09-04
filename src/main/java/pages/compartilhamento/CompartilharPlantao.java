package pages.compartilhamento;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import br.com.infoglobo.pages.AceitacaoAbstractTest;
import br.com.infoglobo.pages.Navegador;

public class CompartilharPlantao extends AceitacaoAbstractTest {
	
	public CompartilharPlantao() throws Exception {
		super();
	}
	
	public CompartilharPlantao(Navegador navegador) throws Exception {
		super(navegador);
	}

	public void mouseOver() throws InterruptedException{
		WebElement menu = getDriver().findElement(By.cssSelector("#compartilhar > a"));
		Actions mouseOver = new Actions(getDriver());
		mouseOver.moveToElement(menu).perform();
		esperaCarregar(1);
	}
	
	public void clicarNoCompartilhar() throws InterruptedException{
		esperaCarregar(1);
		getDriver().findElement(By.cssSelector("a.compartilhar")).click();
	}
	
	public WebElement getBoxCompartilhar() {
		return getDriver().findElement(By.id("compartilhar"));
	}

	public String getTituloCompartilhar() throws InterruptedException {
		return getBoxCompartilhar().findElement(By.tagName("a")).getText();
	}

	public List<WebElement> listaTotalDeCompartilhamento() throws InterruptedException {
		return getBoxCompartilhar().findElement(By.tagName("ul")).findElements(By.tagName("li"));
	}
	
	public boolean listaDeCompartilhamentoEhIgualATres() throws InterruptedException {
		return listaTotalDeCompartilhamento().size() ==3;
	}
	
	public boolean OCompartilharPeloFacebookEstaNaLista() throws InterruptedException {
		clicarNoCompartilhar();
		return getBoxCompartilhar().findElement(By.id("recomendar")).isDisplayed();
	}

	public String OTextoRecomendarEstaNaLista() throws InterruptedException {
		return getBoxCompartilhar().findElement(By.id("recomendar")).findElement(By.tagName("a")).getText();
	}
	
	public boolean OCompartilharPeloFacebookPossuiLink() throws InterruptedException {
		return getBoxCompartilhar().findElement(By.id("recomendar")).findElement(By.tagName("a")).isDisplayed();
	}
	
	public boolean OCompartilharPeloFacebookPossuiUmLinkValido() throws InterruptedException {
		return getBoxCompartilhar().findElement(By.id("recomendar")).findElement(By.tagName("a")).getAttribute("href").contains("https://www.facebook.com/dialog/feed?app_id=");
	}

	public WebElement exibiuTotalDeCompartilhamentosDoFacebook() throws InterruptedException {
		return getBoxCompartilhar().findElement(By.id("recomendar")).findElement(By.className("count"));
	}
	
	public boolean OCompartilharPeloTwitterEstaNaLista() throws InterruptedException {
		return getBoxCompartilhar().findElement(By.id("twitter")).isDisplayed();
	}

	public String OTextoTweetEstaNaLista() throws InterruptedException {
		return getBoxCompartilhar().findElement(By.id("twitter")).findElement(By.tagName("a")).getText();
	}

	public boolean OCompartilharPeloTwitterPossuiLink() throws InterruptedException {
		return getBoxCompartilhar().findElement(By.id("twitter")).findElement(By.tagName("a")).isDisplayed();
	}

	public boolean OCompartilharPeloTwitterPossuiUmLinkValido() throws InterruptedException {
		return getBoxCompartilhar().findElement(By.id("twitter")).findElement(By.tagName("a")).getAttribute("href").contains("https://twitter.com/");
	}
	
	public WebElement exibiuTotalDeCompartilhamentosDoTwitter() throws InterruptedException {
		return getBoxCompartilhar().findElement(By.id("twitter")).findElement(By.className("count"));
	}
	
	public boolean OCompartilharPeloGooglePlusEstaNaLista() throws InterruptedException {
		return getBoxCompartilhar().findElement(By.id("googlePlus")).isDisplayed();
	}

	public String OTextoGooglePlusEstaNaLista() throws InterruptedException {
		return getBoxCompartilhar().findElement(By.id("googlePlus")).findElement(By.tagName("span")).getText();
	}

	public boolean OCompartilharPeloGooglePlusPossuiLink() throws InterruptedException {
		return getBoxCompartilhar().findElement(By.id("googlePlus")).findElement(By.tagName("div")).isDisplayed();
	}
}
