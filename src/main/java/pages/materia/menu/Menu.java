package pages.materia.menu;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import br.com.infoglobo.pages.AceitacaoAbstractTest;
import br.com.infoglobo.pages.Navegador;

public class Menu extends AceitacaoAbstractTest {
	
	public Menu() throws Exception {
		super();
	}
	
	public Menu(Navegador navegador) throws Exception {
		super(navegador);
	}

	public WebElement getBoxDeTopicos() {
		return getDriver().findElement(By.className("artigo-topicos"));
	}

	public String exibiuOTituloDeTopicos() {
		return getDriver().findElement(By.xpath(".//*[@id='menu-editoria']/div[2]/div/div/div/ul/li[1]")).getAttribute("innerHTML");
		//return getBoxDeTopicos().findElement(By.tagName("ul")).findElements(By.tagName("li")).get(0).getText().contains("TÓPICOS");
	}
	
	public List<WebElement> listaComTodosOsTopicos() {
		return getBoxDeTopicos().findElement(By.tagName("ul")).findElements(By.tagName("li"));
	}
	
	public boolean aListaDeTopicosEstaAparecendo() {
		return listaComTodosOsTopicos().size() > 0;
	}

	public boolean osItensDaListaDeTopicosEstaoAparecendoONomeDoTopico() {
		for(int i=1; i <listaComTodosOsTopicos().size()-1; i++){
			if(listaComTodosOsTopicos().get(i).findElement(By.tagName("a")).getAttribute("innerHTML").isEmpty()){
				return false; 
			}
		}
		return true;
	}

	public boolean osItensDaListaDeTopicosPossuemUmaURL() {
		for(int i=1; i <listaComTodosOsTopicos().size()-1; i++){
			if(!listaComTodosOsTopicos().get(i).findElement(By.tagName("a")).isDisplayed()){
				return false; 
			}
		}
		return true;
	}

	public boolean asUrlDosItensDaListaDeTopicosEhValida() {
		for(int i=1; i <listaComTodosOsTopicos().size()-1; i++){
			if(listaComTodosOsTopicos().get(i).findElement(By.tagName("a")).getAttribute("href").isEmpty()){
				return false; 
			}
		}
		return true;
	}
	
	public WebElement getBotao() {
		return getDriver().findElement(By.id("bt-editoria"));
	}

	public boolean getEditoria() {
		return !getBotao().findElement(By.tagName("a")).getText().isEmpty();
	}

	public boolean getEditoriaLink() {
		return getBotao().findElement(By.tagName("a")).isDisplayed();
	}

	public boolean getEditoriaLinkValido() {
		return !getBotao().findElement(By.tagName("a")).getAttribute("href").isEmpty();
	}

	public WebElement getSecoes() {
		return getDriver().findElement(By.className("secoes"));
	}

	public List<WebElement> getSecoesLista() {
		return getSecoes().findElement(By.tagName("h3")).findElements(By.tagName("a"));
	}
	
	public void habilitarMenuEditoria() throws InterruptedException {
		Actions acao = new Actions(getDriver());
		acao.moveToElement(getBotao());
		acao.perform();
	}

	public boolean getEditoriaMenuEsquerdo() {
		return !getDriver().findElement(By.xpath("//*[@id='menu-editoria']/div[1]/div/div/div[1]/h3/a[1]/span")).getAttribute("innerHTML").isEmpty();
	}

	public boolean getEditoriaMenuEsquerdoLink() {
		return getSecoesLista().get(0).isDisplayed();
	}

	public boolean getEditoriaMenuEsquerdoLinkValido() {
		return !getSecoesLista().get(0).getAttribute("href").isEmpty();
	}

	public boolean getEditoriaMenuEsquerdoCompara() {
		String resultadoMenuPrincipal = getBotao().findElement(By.tagName("a")).getText();
		String resultadoSubMenu = getSecoesLista().get(0).getAttribute("title");

		return (resultadoMenuPrincipal.equals(resultadoSubMenu));
	}

	public boolean getTextoIrPagina() {
		return getSecoesLista().get(1).getText().equals("Ir para a página");
	}

	public boolean getTextoIrPaginaURL() {
		return getSecoesLista().get(1).isDisplayed();
	}

	public boolean getTextoIrPaginaURLValido() {
		return !getSecoesLista().get(1).getAttribute("href").isEmpty();
	}

	public boolean getIrPaginaComparaLinkEditoria() {
		String resultadoMenuPrincipal = getSecoesLista().get(0).getAttribute("href");
		String resultadoSubMenu = getSecoesLista().get(1).getAttribute("href");

		return (resultadoMenuPrincipal.equals(resultadoSubMenu));
	}

	public List<WebElement> listaDeSubeditorias() {
		return getSecoes().findElement(By.tagName("ul")).findElements(By.tagName("li"));
	}

	public boolean getListaSub() {
		return listaDeSubeditorias().size() > 0;
	}

	public boolean exibiuNomeSubEditorias() {
		for(int i=0; i<listaDeSubeditorias().size() - 1; i++) {
			if (listaDeSubeditorias().get(i).findElement(By.tagName("a")).getText().isEmpty()) {
				return false;
			}
		}
		return true;

	}

	public boolean getListaSubNomeLink() {
		for(int i=0; i<listaDeSubeditorias().size(); i++) {
			if (!listaDeSubeditorias().get(i).findElement(By.tagName("a")).isDisplayed()) {
				return false;
			}
		}
		return true;
	}

	public boolean getListaSubNomeLinkValido() {
		for (int i = 0; i < listaDeSubeditorias().size(); i++) {
			if (listaDeSubeditorias().get(i).findElement(By.tagName("a")).getAttribute("href").isEmpty()) {
				return false;
			}
		}
		return true;
	}
}
