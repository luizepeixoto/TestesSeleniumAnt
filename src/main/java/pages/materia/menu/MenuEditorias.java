package pages.materia.menu;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import br.com.infoglobo.pages.AceitacaoAbstractTest;
import br.com.infoglobo.pages.Navegador;

public class MenuEditorias extends AceitacaoAbstractTest {

	public MenuEditorias() throws Exception {
		super();
	}

	public MenuEditorias(Navegador navegador) throws Exception {
		super(navegador);
	}

	// public String oNomeHomeEstaSendoExibido() {
	// return
	// getDriver().findElement(By.xpath("(//a[contains(text(),'Home')])[2]")).getText();
	// }

	public WebElement oMenuEstaSendoExibido() {
		return getDriver().findElement(By.className("menu-container"));
	}

	public String oNomeHomeEstaSendoExibido() throws InterruptedException {
		getDriver().manage().deleteAllCookies();

		// getDriver().manage().window().maximize();

		// WebElement menu =
		// getDriver().findElement(By.cssSelector("#bt-editoria > a"));

		WebElement menu = getDriver().findElement(By.cssSelector("#sticker > div > div > div > div > div > div > a"));
		Actions mouseOver = new Actions(getDriver());
		mouseOver.moveToElement(menu).perform();
		Thread.sleep(3000);

		return getDriver().findElement(By.cssSelector("#sticker > div > div > div > div > div > div > a")).getText();
	}

	public List<WebElement> listaComTodasAsEditorias() {
		return oMenuEstaSendoExibido().findElement(By.className("menu")).findElements(By.tagName("li"));
	}

	public boolean aListaDeEditoriasEstaSendoExibida() {
		return listaComTodasAsEditorias().size() > 0;
	}

	public boolean osNomeDasEditoriasEstaoSendoExibidos() throws InterruptedException {

		WebElement menu = getDriver().findElement(By.cssSelector("#sticker > div > div > div > div > div > div > a"));
		Actions mouseOver = new Actions(getDriver());
		mouseOver.moveToElement(menu).perform();
		Thread.sleep(2000);

		for (int i = 0; i < listaComTodasAsEditorias().size(); i++) {
			// mouseOver.moveToElement(menu).perform();
			// Thread.sleep(500);
			if (listaComTodasAsEditorias().get(i).findElement(By.tagName("a")).getText() == "") {
				return false;
			}
		}
		return true;
	}

	public boolean osNomeDasEditoriasPossuemUmLink() throws InterruptedException {

		WebElement menu = getDriver().findElement(By.cssSelector("#sticker > div > div > div > div > div > div > a"));
		Actions mouseOver = new Actions(getDriver());
		mouseOver.moveToElement(menu).perform();
		Thread.sleep(2000);

		for (int i = 0; i < listaComTodasAsEditorias().size(); i++) {
			if (!listaComTodasAsEditorias().get(i).findElement(By.tagName("a")).isDisplayed()) {
					return false;
			}else{
				if(listaComTodasAsEditorias().get(i).getText().contains("Mais +")){
					return true;
				}
			}	
		}	
		return true;
	}

	public boolean osLinkNosItensDasEditoriasSaoValidos() throws InterruptedException {
		WebElement menu = getDriver().findElement(By.cssSelector("#sticker > div > div > div > div > div > div > a"));
		Actions mouseOver = new Actions(getDriver());
		mouseOver.moveToElement(menu).perform();
		Thread.sleep(2000);

		for (int i = 0; i < listaComTodasAsEditorias().size(); i++) {
			if (listaComTodasAsEditorias().get(i).findElement(By.tagName("a")).getAttribute("href") == "") {
				return false;
			}
		}
		return true;
	}

	public WebElement oCompartilharDoFacebookEstaSendoExibido() throws InterruptedException {
		WebElement menu = getDriver().findElement(By.cssSelector("#sticker > div > div > div > div > div > div > a"));
		Actions mouseOver = new Actions(getDriver());
		mouseOver.moveToElement(menu).perform();
		Thread.sleep(2000);

		return getDriver().findElement(By.cssSelector("#sticker > div > div > div > div > nav > div > ul.redes-sociais.clearfix > li:nth-child(1) > a"));
	}

	public boolean oCompartilhamentoDoFacebookPossuiUmLink() throws InterruptedException {
		WebElement menu = getDriver().findElement(By.cssSelector("#sticker > div > div > div > div > div > div > a"));
		Actions mouseOver = new Actions(getDriver());
		mouseOver.moveToElement(menu).perform();
		Thread.sleep(2000);

		if (getDriver().findElement(By.cssSelector("#sticker > div > div > div > div > nav > div > ul.redes-sociais.clearfix > li:nth-child(1) > a")).getAttribute("href").isEmpty()) {
			return false;
		} else {
			return true;
		}
	}

	public boolean oLinkDeCompartilharDoFacebookEhValido() throws InterruptedException {
		WebElement menu = getDriver().findElement(By.cssSelector("#sticker > div > div > div > div > div > div > a"));
		Actions mouseOver = new Actions(getDriver());
		mouseOver.moveToElement(menu).perform();
		Thread.sleep(2000);

		if (getDriver().findElement(By.cssSelector("#sticker > div > div > div > div > nav > div > ul.redes-sociais.clearfix > li:nth-child(1) > a")).getAttribute("href")
				.contains("http://facebook.com/JornalOGlobo")) {
			return true;
		} else {
			return false;
		}
	}

	public WebElement oCompartilharDoTwitterEstaSendoExibido() throws InterruptedException {
		WebElement menu = getDriver().findElement(By.cssSelector("#sticker > div > div > div > div > div > div > a"));
		Actions mouseOver = new Actions(getDriver());
		mouseOver.moveToElement(menu).perform();
		Thread.sleep(2000);

		return getDriver().findElement(By.cssSelector("#sticker > div > div > div > div > nav > div > ul.redes-sociais.clearfix > li:nth-child(2) > a"));
	}

	public boolean oCompartilhamentoDoTwitterPossuiUmLink() throws InterruptedException {
		WebElement menu = getDriver().findElement(By.cssSelector("#sticker > div > div > div > div > div > div > a"));
		Actions mouseOver = new Actions(getDriver());
		mouseOver.moveToElement(menu).perform();
		Thread.sleep(2000);

		if (getDriver().findElement(By.cssSelector("#sticker > div > div > div > div > nav > div > ul.redes-sociais.clearfix > li:nth-child(2) > a")).getAttribute("href").isEmpty()) {
			return false;
		} else {
			return true;
		}
	}

	public boolean oLinkDeCompartilharDoTwitterEhValido() throws InterruptedException {
		WebElement menu = getDriver().findElement(By.cssSelector("#sticker > div > div > div > div > div > div > a"));
		Actions mouseOver = new Actions(getDriver());
		mouseOver.moveToElement(menu).perform();
		Thread.sleep(2000);

		if (getDriver().findElement(By.cssSelector("#sticker > div > div > div > div > nav > div > ul.redes-sociais.clearfix > li:nth-child(2) > a")).getAttribute("href")
				.contains("https://twitter.com/JornalOGlobo")) {
			return true;
		} else {
			return false;
		}
	}

	public WebElement oCompartilharDoGooglePlusEstaSendoExibido() throws InterruptedException {
		WebElement menu = getDriver().findElement(By.cssSelector("#sticker > div > div > div > div > div > div > a"));
		Actions mouseOver = new Actions(getDriver());
		mouseOver.moveToElement(menu).perform();
		Thread.sleep(2000);

		return getDriver().findElement(By.cssSelector("#sticker > div > div > div > div > nav > div > ul.redes-sociais.clearfix > li:nth-child(3) > a"));
	}

	public boolean oCompartilhamentoDoGooglePlusPossuiUmLink() throws InterruptedException {
		WebElement menu = getDriver().findElement(By.cssSelector("#sticker > div > div > div > div > div > div > a"));
		Actions mouseOver = new Actions(getDriver());
		mouseOver.moveToElement(menu).perform();
		Thread.sleep(2000);

		if (getDriver().findElement(By.cssSelector("#sticker > div > div > div > div > nav > div > ul.redes-sociais.clearfix > li:nth-child(3) > a")).getAttribute("href").isEmpty()) {
			return false;
		} else {
			return true;
		}

	}

	public boolean oLinkDeCompartilharDoGooglePlusEhValido() throws InterruptedException {
		WebElement menu = getDriver().findElement(By.cssSelector("#sticker > div > div > div > div > div > div > a"));
		Actions mouseOver = new Actions(getDriver());
		mouseOver.moveToElement(menu).perform();
		Thread.sleep(2000);

		if (getDriver().findElement(By.cssSelector("#sticker > div > div > div > div > nav > div > ul.redes-sociais.clearfix > li:nth-child(3) > a")).getAttribute("href")
				.equals("https://plus.google.com/u/0/+JornalOGlobo/posts")) {
			return true;
		} else {
			return false;
		}
	}

	public WebElement oMemoriaEstaSendoExibido() throws InterruptedException {
		WebElement menu = getDriver().findElement(By.cssSelector("#sticker > div > div > div > div > div > div > a"));
		Actions mouseOver = new Actions(getDriver());
		mouseOver.moveToElement(menu).perform();
		Thread.sleep(2000);

		return getDriver().findElement(By.cssSelector("#sticker > div > div > div > div > nav > div > ul.produtos.clearfix > li.memoria > a"));
	} 													

	public boolean oTituloMemoriaEstaNoMenu() throws InterruptedException {
		WebElement menu = getDriver().findElement(By.cssSelector("#sticker > div > div > div > div > div > div > a"));
		Actions mouseOver = new Actions(getDriver());
		mouseOver.moveToElement(menu).perform();
		Thread.sleep(2000);

		return !getDriver().findElement(By.cssSelector("#sticker > div > div > div > div > nav > div > ul.produtos.clearfix > li.memoria > a")).getText().isEmpty();
	}

	public boolean oTituloMemoriaPossuiUmLink() throws InterruptedException {
		WebElement menu = getDriver().findElement(By.cssSelector("#sticker > div > div > div > div > div > div > a"));
		Actions mouseOver = new Actions(getDriver());
		mouseOver.moveToElement(menu).perform();
		Thread.sleep(2000);

		if (getDriver().findElement(By.cssSelector("#sticker > div > div > div > div > nav > div > ul.produtos.clearfix > li.memoria > a")).getAttribute("href").isEmpty()) {
			return false;
		} else {
			return true;
		}
	}

	public boolean oLinkDoMemoriaPossuiEstaCorreto() throws InterruptedException {
		WebElement menu = getDriver().findElement(By.cssSelector("#sticker > div > div > div > div > div > div > a"));
		Actions mouseOver = new Actions(getDriver());
		mouseOver.moveToElement(menu).perform();
		Thread.sleep(2000);

		if (getDriver().findElement(By.cssSelector("#sticker > div > div > div > div > nav > div > ul.produtos.clearfix > li.memoria > a")).getAttribute("href")
				.equals("http://memoria.oglobo.globo.com/")) {
			return true;
		} else {
			return false;
		}
	}

	public WebElement oAcervoEstaSendoExibido() throws InterruptedException {
		WebElement menu = getDriver().findElement(By.cssSelector("#sticker > div > div > div > div > div > div > a"));
		Actions mouseOver = new Actions(getDriver());
		mouseOver.moveToElement(menu).perform();
		Thread.sleep(2000);

		return getDriver().findElement(By.cssSelector("#sticker > div > div > div > div > nav > div > ul.produtos.clearfix > li.acervo > a"));
	}

	public boolean oTituloAcervoEstaNoMenu() throws InterruptedException {
		WebElement menu = getDriver().findElement(By.cssSelector("#sticker > div > div > div > div > div > div > a"));
		Actions mouseOver = new Actions(getDriver());
		mouseOver.moveToElement(menu).perform();
		Thread.sleep(2000);

		return getDriver().findElement(By.cssSelector("#sticker > div > div > div > div > nav > div > ul.produtos.clearfix > li.acervo > a")).getText().equals("Acervo");
	}

	public boolean oTituloAcervoPossuiUmLink() throws InterruptedException {
		WebElement menu = getDriver().findElement(By.cssSelector("#sticker > div > div > div > div > div > div > a"));
		Actions mouseOver = new Actions(getDriver());
		mouseOver.moveToElement(menu).perform();
		Thread.sleep(2000);

		if (getDriver().findElement(By.cssSelector("#sticker > div > div > div > div > nav > div > ul.produtos.clearfix > li.acervo > a")).getAttribute("href").isEmpty()) {
			return false;
		} else {
			return true;
		}
	}

	public boolean oLinkDoAcervoEstaCorreto() throws InterruptedException {
		WebElement menu = getDriver().findElement(By.cssSelector("#sticker > div > div > div > div > div > div > a"));
		Actions mouseOver = new Actions(getDriver());
		mouseOver.moveToElement(menu).perform();
		Thread.sleep(2000);

		if (getDriver().findElement(By.cssSelector("#sticker > div > div > div > div > nav > div > ul.produtos.clearfix > li.acervo > a")).getAttribute("href")
				.equals("http://acervo.oglobo.globo.com/")) {
			return true;
		} else {
			return false;
		}
	}

	public WebElement oElaEstaSendoExibido() throws InterruptedException {
		WebElement menu = getDriver().findElement(By.cssSelector("#sticker > div > div > div > div > div > div > a"));
		Actions mouseOver = new Actions(getDriver());
		mouseOver.moveToElement(menu).perform();
		Thread.sleep(2000);

		return getDriver().findElement(By.cssSelector("#sticker > div > div > div > div > nav > div > ul.produtos.clearfix > li.ela > a"));
	}

	public boolean oTituloElaEstaNoMenu() throws InterruptedException {
		WebElement menu = getDriver().findElement(By.cssSelector("#sticker > div > div > div > div > div > div > a"));
		Actions mouseOver = new Actions(getDriver());
		mouseOver.moveToElement(menu).perform();
		Thread.sleep(2000);

		return getDriver().findElement(By.cssSelector("#sticker > div > div > div > div > nav > div > ul.produtos.clearfix > li.ela > a")).getText().equals("Ela");
	}

	public boolean oTituloElaPossuiUmLink() throws InterruptedException {
		WebElement menu = getDriver().findElement(By.cssSelector("#sticker > div > div > div > div > div > div > a"));
		Actions mouseOver = new Actions(getDriver());
		mouseOver.moveToElement(menu).perform();
		Thread.sleep(2000);

		if (getDriver().findElement(By.cssSelector("#sticker > div > div > div > div > nav > div > ul.produtos.clearfix > li.ela > a")).getAttribute("href").isEmpty()) {
			return false;
		} else {
			return true;
		}
	}

	public boolean oLinkDoElaEstaCorreto() throws InterruptedException {
		WebElement menu = getDriver().findElement(By.cssSelector("#sticker > div > div > div > div > div > div > a"));
		Actions mouseOver = new Actions(getDriver());
		mouseOver.moveToElement(menu).perform();
		Thread.sleep(2000);

		if (getDriver().findElement(By.cssSelector("#sticker > div > div > div > div > nav > div > ul.produtos.clearfix > li.ela > a")).getAttribute("href").equals("http://ela.oglobo.globo.com/")) {
			return true;
		} else {
			return false;
		}
	}

	public WebElement oPatriciaKogutEstaSendoExibido() throws InterruptedException {
		WebElement menu = getDriver().findElement(By.cssSelector("#sticker > div > div > div > div > div > div > a"));
		Actions mouseOver = new Actions(getDriver());
		mouseOver.moveToElement(menu).perform();
		Thread.sleep(2000);

		return getDriver().findElement(By.cssSelector("#sticker > div > div > div > div > nav > div > ul.produtos.clearfix > li.kogut > a"));
	}

	public boolean oTituloPatriciaKogutEstaNoMenu() throws InterruptedException {
		WebElement menu = getDriver().findElement(By.cssSelector("#sticker > div > div > div > div > div > div > a"));
		Actions mouseOver = new Actions(getDriver());
		mouseOver.moveToElement(menu).perform();
		Thread.sleep(2000);

		return getDriver().findElement(By.cssSelector("#sticker > div > div > div > div > nav > div > ul.produtos.clearfix > li.kogut > a")).getText().equals("Patrícia Kogut");
	}

	public boolean oTituloPatriciaKogutPossuiUmLink() throws InterruptedException {
		WebElement menu = getDriver().findElement(By.cssSelector("#sticker > div > div > div > div > div > div > a"));
		Actions mouseOver = new Actions(getDriver());
		mouseOver.moveToElement(menu).perform();
		Thread.sleep(2000);

		if (getDriver().findElement(By.cssSelector("#sticker > div > div > div > div > nav > div > ul.produtos.clearfix > li.kogut > a")).getAttribute("href").isEmpty()) {
			return false;
		} else {
			return true;
		}
	}

	public boolean oLinkDoPatriciaKogutEstaCorreto() throws InterruptedException {
		WebElement menu = getDriver().findElement(By.cssSelector("#sticker > div > div > div > div > div > div > a"));
		Actions mouseOver = new Actions(getDriver());
		mouseOver.moveToElement(menu).perform();
		Thread.sleep(2000);

		if (getDriver().findElement(By.cssSelector("#sticker > div > div > div > div > nav > div > ul.produtos.clearfix > li.kogut > a")).getAttribute("href").equals("http://kogut.oglobo.globo.com/")) {
			return true;
		} else {
			return false;
		}
	}

	public WebElement oRioShowEstaSendoExibido() throws InterruptedException {
		WebElement menu = getDriver().findElement(By.cssSelector("#sticker > div > div > div > div > div > div > a"));
		Actions mouseOver = new Actions(getDriver());
		mouseOver.moveToElement(menu).perform();
		Thread.sleep(2000);

		return getDriver().findElement(By.cssSelector("#sticker > div > div > div > div > nav > div > ul.produtos.clearfix > li.rioshow > a"));
	}

	public boolean oTituloRioShowEstaNoMenu() throws InterruptedException {
		WebElement menu = getDriver().findElement(By.cssSelector("#sticker > div > div > div > div > div > div > a"));
		Actions mouseOver = new Actions(getDriver());
		mouseOver.moveToElement(menu).perform();
		Thread.sleep(2000);

		return getDriver().findElement(By.cssSelector("#sticker > div > div > div > div > nav > div > ul.produtos.clearfix > li.rioshow > a")).getText().equals("Rio Show");
	}

	public boolean oTituloRioShowPossuiUmLink() throws InterruptedException {
		WebElement menu = getDriver().findElement(By.cssSelector("#sticker > div > div > div > div > div > div > a"));
		Actions mouseOver = new Actions(getDriver());
		mouseOver.moveToElement(menu).perform();
		Thread.sleep(2000);

		if (getDriver().findElement(By.cssSelector("#sticker > div > div > div > div > nav > div > ul.produtos.clearfix > li.rioshow > a")).getAttribute("href").isEmpty()) {
			return false;
		} else {
			return true;
		}
	}

	public boolean oLinkDoRioShowEstaCorreto() throws InterruptedException {
		WebElement menu = getDriver().findElement(By.cssSelector("#sticker > div > div > div > div > div > div > a"));
		Actions mouseOver = new Actions(getDriver());
		mouseOver.moveToElement(menu).perform();
		Thread.sleep(2000);

		if (!getDriver().findElement(By.cssSelector("#sticker > div > div > div > div > nav > div > ul.produtos.clearfix > li.rioshow > a")).getAttribute("href").isEmpty()) {
			return true;
		} 
		return false;
	}

	public WebElement oExtraEstaSendoExibido() throws InterruptedException {
		WebElement menu = getDriver().findElement(By.cssSelector("#sticker > div > div > div > div > div > div > a"));
		Actions mouseOver = new Actions(getDriver());
		mouseOver.moveToElement(menu).perform();
		Thread.sleep(2000);

		return getDriver().findElement(By.cssSelector("#sticker > div > div > div > div > nav > div > ul.produtos.clearfix > li.extra > a"));
	}

	public boolean oTituloExtraEstaNoMenu() throws InterruptedException {
		WebElement menu = getDriver().findElement(By.cssSelector("#sticker > div > div > div > div > div > div > a"));
		Actions mouseOver = new Actions(getDriver());
		mouseOver.moveToElement(menu).perform();
		Thread.sleep(2000);

		return getDriver().findElement(By.cssSelector("#sticker > div > div > div > div > nav > div > ul.produtos.clearfix > li.extra > a")).getText().equals("Extra");
	}

	public boolean oTituloExtraPossuiUmLink() throws InterruptedException {
		WebElement menu = getDriver().findElement(By.cssSelector("#sticker > div > div > div > div > div > div > a"));
		Actions mouseOver = new Actions(getDriver());
		mouseOver.moveToElement(menu).perform();
		Thread.sleep(2000);

		if (getDriver().findElement(By.cssSelector("#sticker > div > div > div > div > nav > div > ul.produtos.clearfix > li.extra > a")).getAttribute("href").isEmpty()) {
			return false;
		} else {
			return true;
		}
	}

	public boolean oLinkDoExtraEstaCorreto() throws InterruptedException {
		WebElement menu = getDriver().findElement(By.cssSelector("#sticker > div > div > div > div > div > div > a"));
		Actions mouseOver = new Actions(getDriver());
		mouseOver.moveToElement(menu).perform();
		Thread.sleep(2000);

		if (getDriver().findElement(By.cssSelector("#sticker > div > div > div > div > nav > div > ul.produtos.clearfix > li.extra > a")).getAttribute("href").equals("http://extra.globo.com/")) {
			return true;
		} else {
			return false;
		}
	}

	public WebElement oClassificadosDoRioEstaSendoExibido() throws InterruptedException {
		WebElement menu = getDriver().findElement(By.cssSelector("#sticker > div > div > div > div > div > div > a"));
		Actions mouseOver = new Actions(getDriver());
		mouseOver.moveToElement(menu).perform();
		Thread.sleep(2000);

		return getDriver().findElement(By.cssSelector("#sticker > div > div > div > div > nav > div > ul.produtos.clearfix > li.classificados > a"));
	}

	public boolean oTituloClassificadosDoRioEstaNoMenu() throws InterruptedException {
		WebElement menu = getDriver().findElement(By.cssSelector("#sticker > div > div > div > div > div > div > a"));
		Actions mouseOver = new Actions(getDriver());
		mouseOver.moveToElement(menu).perform();
		Thread.sleep(2000);

		return getDriver().findElement(By.cssSelector("#sticker > div > div > div > div > nav > div > ul.produtos.clearfix > li.classificados > a")).getText().equals("Classificados");
	}

	public boolean oTituloClassificadosDoRioPossuiUmLink() throws InterruptedException {
		WebElement menu = getDriver().findElement(By.cssSelector("#sticker > div > div > div > div > div > div > a"));
		Actions mouseOver = new Actions(getDriver());
		mouseOver.moveToElement(menu).perform();
		Thread.sleep(2000);

		return !getDriver().findElement(By.cssSelector("#sticker > div > div > div > div > nav > div > ul.produtos.clearfix > li.classificados > a")).getAttribute("href").isEmpty();
	}

	public boolean oLinkDoClassificadosDoRioEstaCorreto() throws InterruptedException {
		WebElement menu = getDriver().findElement(By.cssSelector("#sticker > div > div > div > div > div > div > a"));
		Actions mouseOver = new Actions(getDriver());
		mouseOver.moveToElement(menu).perform();
		Thread.sleep(2000);

		if (getDriver().findElement(By.cssSelector("#sticker > div > div > div > div > nav > div > ul.produtos.clearfix > li.classificados > a")).getAttribute("href")
				.equals("http://classificadosdorio.globo.com/")) {
			return true;
		} else {
			return false;
		}
	}

	public String oTituloClubeSouMaisRioEstaNoMenu() {
		WebElement menu = getDriver().findElement(By.cssSelector("#sticker > div > div > div > div > div > div > a"));
		executarMouseOver(menu);
		
		return getDriver().findElement(By.xpath("//*[@id='sticker']/div/div/div/div/nav/div/ul[3]/li[8]/a")).getText();
	}

	public boolean oTituloClubeSouMaisRioPossuiUmLink() {
		WebElement menu = getDriver().findElement(By.cssSelector("#sticker > div > div > div > div > div > div > a"));
		executarMouseOver(menu);
		
		return !getDriver().findElement(By.xpath("//*[@id='sticker']/div/div/div/div/nav/div/ul[3]/li[8]/a")).getAttribute("href").isEmpty();
	}

	public boolean oLinkDoClubeSouMaisRioEstaCorreto() {
		WebElement menu = getDriver().findElement(By.cssSelector("#sticker > div > div > div > div > div > div > a"));
		executarMouseOver(menu);
		
		if (getDriver().findElement(By.xpath("//*[@id='sticker']/div/div/div/div/nav/div/ul[3]/li[8]/a")).getAttribute("href")
				.equals("https://clubesoumaisrio.oglobo.globo.com/")) {
			return true;
		} else {
			return false;
		}
		
	}
}
