package pages.materia.video;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import br.com.infoglobo.pages.AceitacaoAbstractTest;
import br.com.infoglobo.pages.Navegador;

public class MateriaComVideoVevo extends AceitacaoAbstractTest {
	
	public MateriaComVideoVevo(Navegador navegador) throws Exception {
		super(navegador);
	}

	public WebElement getClassCorpo(){
		return getDriver().findElement(By.className("corpo"));
	}
	
	public List<WebElement> getListaVideo(){
		return getClassCorpo().findElements(By.className("artigo-video"));
	}
	
	public boolean exibiuBoxDeVideoInline(){
		return getListaVideo().get(0).isDisplayed();
	}
	
	public boolean exibiuBoxDeVideoVevo(){
		return getListaVideo().get(0).findElement(By.tagName("div")).findElement(By.tagName("iframe")).getAttribute("src").contains("vevo");
	}
}