package pages.materia.capitulo;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import pages.materia.widget.BoxDeAudio;

import br.com.infoglobo.pages.Navegador;

public class MenuLateralComAudio extends BoxDeAudio {
	
	public MenuLateralComAudio(Navegador navegador) throws Exception{
		super(navegador);
	}
	
	public WebElement exibiuMateriaEmCapitulos() {
		return getDriver().findElement(By.className("v2"));
	}
	
	public WebElement acessaPrimeiroCapitulo(){
		return getDriver().findElement(By.id("fixaMenu"));
	}
	
	public List<WebElement> listaComTodosOsCapitulos(){
		return exibiuMateriaEmCapitulos().findElements(By.className("capituloPage"));
	}
	
	public void executaScrollAteOCapituloDesejado(int capituloDesejado) throws InterruptedException{
		esperaCarregar(2);
		executarScroll(listaComTodosOsCapitulos().get(capituloDesejado).getLocation());
	}
}