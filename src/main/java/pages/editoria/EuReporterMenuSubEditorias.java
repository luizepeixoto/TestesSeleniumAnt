package pages.editoria;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import br.com.infoglobo.pages.AceitacaoAbstractTest;
import br.com.infoglobo.pages.Navegador;

public class EuReporterMenuSubEditorias extends AceitacaoAbstractTest {

	public EuReporterMenuSubEditorias() throws Exception {
		super();
	}

	public EuReporterMenuSubEditorias(Navegador navegador) throws Exception {
		super(navegador);
	}

	public WebElement getBoxCompartilhar() {
		return getDriver().findElement(By.id("compartilhar"));
	}

	public String getTituloCompartilhar() {
		return getBoxCompartilhar().getText();
	}

	public List<WebElement> listaTotalDeCompartilhamento() {
		return getBoxCompartilhar().findElement(By.tagName("ul")).findElements(By.tagName("li"));
	}

	public boolean listaDeCompartilhamentoEhIgualATres() {
		return listaTotalDeCompartilhamento().size() == 3;
	}

	public boolean OCompartilharPeloFacebookEstaNaLista() {
		return listaTotalDeCompartilhamento().get(0).getAttribute("id").equals("recomendar");
	}

	public boolean OTextoRecomendarEstaNaLista() {
		return !listaTotalDeCompartilhamento().get(0).findElement(By.tagName("a")).getText().isEmpty();
	}

	public boolean OCompartilharPeloFacebookPossuiLink() {
		return listaTotalDeCompartilhamento().get(0).findElement(By.tagName("a")).isDisplayed();
	}

	public boolean OCompartilharPeloFacebookPossuiUmLinkValido() {
		return listaTotalDeCompartilhamento().get(0).findElement(By.tagName("a")).getAttribute("href").contains("http://www.facebook.com/sharer/sharer.php");
	}

	public boolean OCompartilharPeloTwitterEstaNaLista() {
		return listaTotalDeCompartilhamento().get(1).getAttribute("id").equals("twitter");
	}

	public boolean OTextoTweetEstaNaLista() {
		return !listaTotalDeCompartilhamento().get(1).findElement(By.tagName("a")).getText().isEmpty();
	}

	public boolean OCompartilharPeloTwitterPossuiLink() {
		return listaTotalDeCompartilhamento().get(1).findElement(By.tagName("a")).isDisplayed();
	}

	public boolean OCompartilharPeloTwitterPossuiUmLinkValido() {
		return listaTotalDeCompartilhamento().get(1).findElement(By.tagName("a")).getAttribute("href").contains("https://twitter.com/intent/tweet");
	}

	public boolean OCompartilharPeloGooglePlusEstaNaLista() {
		return listaTotalDeCompartilhamento().get(2).getAttribute("id").equals("googlePlus");
	}

	public boolean OTextoGooglePlusEstaNaLista() {
		return !listaTotalDeCompartilhamento().get(2).findElement(By.tagName("a")).getText().isEmpty();
	}

	public boolean OCompartilharPeloGooglePlusPossuiLink() {
		return listaTotalDeCompartilhamento().get(2).findElement(By.tagName("a")).isDisplayed();
	}

	public boolean OCompartilharPeloGooglePlusPossuiUmLinkValido() {
		return listaTotalDeCompartilhamento().get(2).findElement(By.tagName("a")).getAttribute("href").contains("https://plus.google.com/share");
	}

	public WebElement getBoxDeTopicos() {
		return getDriver().findElement(By.className("artigo-topicos"));
	}

	public boolean oTituloDeTopicosEstaAparecendo() {
		return !getBoxDeTopicos().findElement(By.tagName("ul")).findElements(By.tagName("li")).get(1).getText().isEmpty();
	}

	public List<WebElement> listaComTodosOsTopicos() {
		return getBoxDeTopicos().findElement(By.tagName("ul")).findElements(By.tagName("li"));
	}

	public boolean aListaDeTopicosEstaAparecendo() {
		return listaComTodosOsTopicos().size() > 0;
	}

	public boolean osItensDaListaDeTopicosEstaoAparecendoONomeDoTopico() {
		for (int i = 1; i < listaComTodosOsTopicos().size() - 1; i++) {
			if (!listaComTodosOsTopicos().get(i).findElement(By.tagName("a")).getText().isEmpty()) {
				return false;
			}
		}
		return true;
	}

	public boolean osItensDaListaDeTopicosPossuemUmaURL() {
		for (int i = 1; i < listaComTodosOsTopicos().size() - 1; i++) {
			if (!listaComTodosOsTopicos().get(i).findElement(By.tagName("a")).isDisplayed()) {
				return false;
			}
		}
		return true;
	}

	public boolean asUrlDosItensDaListaDeTopicosEhValida() {
		for (int i = 1; i < listaComTodosOsTopicos().size() - 1; i++) {
			if (listaComTodosOsTopicos().get(i).findElement(By.tagName("a")).getAttribute("href").isEmpty()) {
				return false;
			}
		}
		return true;
	}

	public WebElement getBotao() {
		return getDriver().findElement(By.id("bt-editoria"));
	}

	public String getEditoria() {
		return getBotao().findElement(By.tagName("a")).getText();
	}

	public boolean getEditoriaLink() {
		return getBotao().findElement(By.tagName("a")).isDisplayed();
	}

	public boolean getEditoriaLinkValido() {
		return getBotao().findElement(By.tagName("a")).getAttribute("href").contains(getUrlPaginaAtual());
	}

	public WebElement getSecoes() {
		return getDriver().findElement(By.className("secoes"));
	}

	public List<WebElement> getSecoesLista() {
		return getSecoes().findElement(By.tagName("h3")).findElements(By.tagName("a"));
	}

	public void mouseOver() throws InterruptedException {
		getDriver().manage().deleteAllCookies();
		WebElement menu = getDriver().findElement(By.id("bt-editoria"));
		Actions mouseOver = new Actions(getDriver());
		mouseOver.moveToElement(menu).perform();
		Thread.sleep(500);
	}

	public void mouseOver2() throws InterruptedException {
		getDriver().manage().deleteAllCookies();
		WebElement menu = getDriver().findElement(By.id("bt-editoria"));
		Actions mouseOver = new Actions(getDriver());
		mouseOver.moveToElement(menu).perform();
		Thread.sleep(1000);
	}

	public String getEditoriaMenuEsquerdo() throws InterruptedException {
		mouseOver();
		return getSecoesLista().get(0).getText();
	}

	public boolean getEditoriaMenuEsquerdoLink() throws InterruptedException {
		mouseOver();
		return getSecoesLista().get(0).isDisplayed();
	}

	public boolean getEditoriaMenuEsquerdoLinkValido() throws InterruptedException {
		mouseOver();
		return getSecoesLista().get(0).getAttribute("href").contains(getUrlPaginaAtual());
	}

	public boolean getEditoriaMenuEsquerdoCompara() throws InterruptedException {
		mouseOver();
		String resultadoMenuPrincipal = getBotao().findElement(By.tagName("a")).getText();
		String resultadoSubMenu = getSecoesLista().get(0).getAttribute("title");
		return resultadoMenuPrincipal.toLowerCase().equals(resultadoSubMenu.toLowerCase());
	}

	public String getTextoIrPagina() throws InterruptedException {
		mouseOver2();
		return getSecoesLista().get(1).findElement(By.tagName("span")).getText();
	}

	public boolean getTextoIrPaginaURL() throws InterruptedException {
		mouseOver2();
		return getSecoesLista().get(1).isDisplayed();
	}

	public boolean getTextoIrPaginaURLValido() throws InterruptedException {
		mouseOver2();
		return getSecoesLista().get(1).getAttribute("href").contains(getUrlPaginaAtual());
	}

	public boolean getIrPaginaComparaLinkEditoria() {
		String resultadoMenuPrincipal = getSecoesLista().get(0).getAttribute("href");
		String resultadoSubMenu = getSecoesLista().get(1).getAttribute("href");
		return resultadoMenuPrincipal.equals(resultadoSubMenu);
	}

	public boolean getListaSub() throws InterruptedException {
		mouseOver2();
		List<WebElement> listaDeSub = getSecoes().findElements(By.tagName("li"));
		if (listaDeSub.size() > 0) {
			return true;
		}
		return true;
	}

	public boolean exibiuNomeSubEditorias() throws InterruptedException {
		mouseOver2();
		List<WebElement> listaDeSub = getSecoes().findElements(By.tagName("li"));
		if (listaDeSub.size() > 0) {
			for (int i = 0; i<listaDeSub.size(); i++) {
				if (listaDeSub.get(i).findElement(By.tagName("a")).getText().isEmpty()) {
					return false;
				}
			}
		}
		return true;

	}

	public boolean getListaSubNomeLink() throws InterruptedException {
		mouseOver2();
		List<WebElement> listaDeSub = getSecoes().findElements(By.tagName("li"));
		if (listaDeSub.size() > 0) {
			for (int i = 0; i < listaDeSub.size(); i++) {
				if (!listaDeSub.get(i).findElement(By.tagName("a")).isDisplayed()) {
					return false;
				}
			}
		}
		return true;
	}

	public boolean getListaSubNomeLinkValido() throws InterruptedException {
		mouseOver2();
		List<WebElement> listaDeSub = getSecoes().findElements(By.tagName("li"));
		if (listaDeSub.size() > 0) {
			for (int i = 0; i < listaDeSub.size(); i++) {
				if (listaDeSub.get(i).findElement(By.tagName("a")).getAttribute("href").isEmpty()) {
					return false;
				}
			}
		}
		return true;
	}
}
