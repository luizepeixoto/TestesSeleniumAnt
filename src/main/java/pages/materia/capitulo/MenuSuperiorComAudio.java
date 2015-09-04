package pages.materia.capitulo;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import pages.materia.widget.BoxDeAudio;

import br.com.infoglobo.pages.Navegador;

public class MenuSuperiorComAudio extends BoxDeAudio {
	
	public MenuSuperiorComAudio(Navegador navegador) throws Exception{
		super(navegador);
	}
	
	public WebElement exibiuMateriaEmCapitulos() {
		return getDriver().findElement(By.className("materia-capitulos"));
	}
	
	public WebElement acessaPrimeiroCapitulo(){
		return getDriver().findElement(By.className("inicio"));
	}
	
	public List<WebElement> listaComTodosOsCapitulos(){
		return exibiuMateriaEmCapitulos().findElements(By.className("capituloPage"));
	}
	
	public void executaScrollAteOCapituloDesejado(int capituloDesejado) throws InterruptedException{
		esperaCarregar(2);
		executarScroll(listaComTodosOsCapitulos().get(capituloDesejado).getLocation());
	}
}