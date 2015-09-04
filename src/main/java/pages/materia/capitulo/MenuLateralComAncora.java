package pages.materia.capitulo;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import br.com.infoglobo.pages.AceitacaoAbstractTest;
import br.com.infoglobo.pages.Navegador;

public class MenuLateralComAncora extends AceitacaoAbstractTest {
	
	public MenuLateralComAncora(Navegador navegador) throws Exception {
		super(navegador);
	}
	
	public WebElement exibiuMenuLateral() {
		return getDriver().findElement(By.id("fixaMenu"));
	}
	
	public List<WebElement> listaDeCapitulosDoMenu() {
		return exibiuMenuLateral().findElement(By.id("summary")).findElements(By.tagName("li"));
	}
	
	public boolean  exibiuAClasseDaAncoraComoAtiva() {
		return listaDeCapitulosDoMenu().get(2).findElement(By.className("active")).isDisplayed();
	}
}