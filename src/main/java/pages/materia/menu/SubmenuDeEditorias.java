package pages.materia.menu;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import br.com.infoglobo.pages.AceitacaoAbstractTest;
import br.com.infoglobo.pages.Navegador;

public class SubmenuDeEditorias extends AceitacaoAbstractTest {
	
	public SubmenuDeEditorias(Navegador navegador) throws Exception{
		super(navegador);
	}
	
	private WebElement obterMenu() {
		return getDriver().findElement(By.className("navegacao-container"));
	}
	
	private WebElement obterOpcaoEconomiaNoMenu() {
		return obterMenu().findElement(By.className("navegacao-lateral")).findElement(By.className("menu-container")).findElement(By.className("menu")).findElements(By.className("mais-editorias")).get(4);
	}
	
	private WebElement obterSubmenuDeEconomia() {
		return obterOpcaoEconomiaNoMenu().findElement(By.className("submenu-container")).findElement(By.className("submenu"));
	}

	public boolean exibiuSubMenuDeEconomia() throws InterruptedException {
		executarMouseOver(obterMenu());
		Thread.sleep(1000);
		executarMouseOver(obterOpcaoEconomiaNoMenu());
		Thread.sleep(1000);
		return obterSubmenuDeEconomia().isDisplayed();
	}

	public boolean NãoExibiuSubMenuDeEducacao() {	
		WebElement menu = getDriver().findElement(By.xpath("//*[@id='sticker']/div/div/div/div/nav/div/ul[1]/li[7]"));
		
		try {
			menu.findElement(By.className("submenu-container")).isDisplayed();
			return false;
		} catch (Exception e) {
			return true;
		}		
	}

	public int exibiuQuantidadeMaximaDe8ItensNoSubMenu() {
		
		List<WebElement> submenu = getDriver().findElements(By.xpath("//*[@id='sticker']/div/div/div/div/nav/div/ul[1]/li[14]/div/ul/li"));
		return submenu.size();
		
		
		
	}

}
