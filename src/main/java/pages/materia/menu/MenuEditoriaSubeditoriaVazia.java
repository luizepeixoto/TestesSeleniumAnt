package pages.materia.menu;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import br.com.infoglobo.pages.AceitacaoAbstractTest;
import br.com.infoglobo.pages.Navegador;

public class MenuEditoriaSubeditoriaVazia extends AceitacaoAbstractTest {
	
	public MenuEditoriaSubeditoriaVazia() throws Exception {
		super();
	}
	
	public MenuEditoriaSubeditoriaVazia(Navegador navegador) throws Exception {
		super(navegador);
	}
	
	void mouseOver() throws InterruptedException{
		WebElement menu = getDriver().findElement(By.cssSelector("#bt-editoria > a"));
		Actions mouseOver = new Actions(getDriver());
		mouseOver.moveToElement(menu).perform();
		Thread.sleep(2000);
	}

	public WebElement getBotao(){
		return getDriver().findElement(By.id("bt-editoria"));
	}
	
	public boolean exibiuEditoria() {
		return !getBotao().findElement(By.tagName("a")).getText().isEmpty();
	}

	public boolean exibiuLinkNaEditoria() {
		return getBotao().findElement(By.tagName("a")).isDisplayed();
	}

	public boolean exibiuUmLinkValidoNaEditoria() {
		return !getBotao().findElement(By.tagName("a")).getAttribute("href").isEmpty();
	}
	
	public WebElement getSecoes(){
		return getDriver().findElement(By.className("secoes"));
	}
	
	public List<WebElement> getSecoesLista(){
		return getSecoes().findElement(By.tagName("h3")).findElements(By.tagName("a"));
	}
	
	public boolean exibiuEditoriaDoLadoEsquerdoDoMenu() throws InterruptedException {
		mouseOver();
		return !getSecoes().findElement(By.className("inner-editoria")).findElement(By.tagName("span")).getText().isEmpty();
	}

	public boolean ExibiuUmLinkNaChamadaDaEditoriaNoladoEsquerdo() throws InterruptedException {
		mouseOver();
		return !getSecoes().findElement(By.className("inner-editoria")).getAttribute("href").isEmpty();
	}

	public boolean getEditoriaMenuEsquerdoLinkValido() {
		return !getSecoesLista().get(0).getAttribute("href").isEmpty();
	}

	public boolean getEditoriaMenuEsquerdoCompara() throws InterruptedException {
		mouseOver();
		String  resultadoMenuPrincipal = getBotao().findElement(By.tagName("a")).getText().toLowerCase();
		String  resultadoSubMenu = getSecoes().findElement(By.className("inner-editoria")).getText().toLowerCase();
		
		return (resultadoMenuPrincipal.equals(resultadoSubMenu));
	}

	public boolean getTextoIrPagina() {
		return getSecoesLista().get(1).getText().equals("Ir para a página");
	}

	public boolean getTextoIrPaginaURL() throws InterruptedException {
		mouseOver();
		return !getSecoesLista().get(1).getAttribute("href").isEmpty();
	}

	public boolean getTextoIrPaginaURLValido() throws InterruptedException {
		mouseOver();
		return !getSecoesLista().get(1).getAttribute("href").isEmpty();
	}

	public boolean getIrPaginaComparaLinkEditoria() {
		String  resultadoMenuPrincipal = getSecoesLista().get(0).getAttribute("href");
		String  resultadoSubMenu = getSecoesLista().get(1).getAttribute("href");
		
		return (resultadoMenuPrincipal.equals(resultadoSubMenu));
	}

	public boolean getListaSubVazia() {
		List<WebElement> resultadoEsperado = getSecoes().findElements(By.tagName("ul"));
		return resultadoEsperado.size() == Integer.parseInt("0");
	}
}
