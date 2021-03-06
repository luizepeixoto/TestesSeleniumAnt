package pages.materia.capitulo;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import pages.materia.widget.generico.BoxGenericoPadrao;

import br.com.infoglobo.pages.Navegador;

public class MenuLateralElementosEmbedGenerico extends BoxGenericoPadrao {
	
	public MenuLateralElementosEmbedGenerico(Navegador navegador) throws Exception {
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
		esperaCarregar(1);
		executarScroll(listaComTodosOsCapitulos().get(capituloDesejado).getLocation());
	}
	
	public WebElement acessaOCapituloDesejado(int capituloDesejado){
		return listaComTodosOsCapitulos().get(capituloDesejado).findElement(By.className("embed-social"));
	}
	
	public WebElement acessaOCapituloComVideoDesejado(int capituloDesejado){
		return listaComTodosOsCapitulos().get(capituloDesejado).findElement(By.className("artigo-video"));
	}
}