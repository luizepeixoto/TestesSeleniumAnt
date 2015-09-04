package pages.materia.widget;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import br.com.infoglobo.pages.AceitacaoAbstractTest;
import br.com.infoglobo.pages.Navegador;

public class BoxMaisLidas extends AceitacaoAbstractTest {
	
	public BoxMaisLidas(Navegador navegador) throws Exception {
		super(navegador);
	}

	public WebElement obterBoxDeMaisLidas(){
		return getDriver().findElement(By.className("mais-lidas"));
	}
	
	public boolean exibiuBoxDeMaisLidas() {
		return obterBoxDeMaisLidas().isDisplayed();
	}

	public String oTituloMaisLidasEstaSendoExibida() {
		return obterBoxDeMaisLidas().findElement(By.tagName("p")).getText();
	}
	
	public List<WebElement> itensDaListaDeMaterias() {
		return  obterBoxDeMaisLidas().findElement(By.tagName("ol")).findElements(By.tagName("li"));
	}
	
	public boolean estaSendoExibidoUmaListaDeMaterias() {
		return itensDaListaDeMaterias().size() > 0;
	}

	public boolean aListaDeMateriasEhNumeradas() {
		return obterBoxDeMaisLidas().findElement(By.tagName("ol")).isDisplayed();
	}

	public boolean osItensDaListaDeMateriasPossuemUmTitulo() {
		for(int i=0; i < itensDaListaDeMaterias().size()-1; i++){
			if(itensDaListaDeMaterias().get(i).findElement(By.tagName("p")).getText().isEmpty()){
				return false;
			}
		}
		return true;
	}

	public boolean osItensDaListaDeMateriasPossuemUmaURL() {
		for(int i=0; i < itensDaListaDeMaterias().size()-1; i++){
			if(!itensDaListaDeMaterias().get(i).findElement(By.tagName("a")).isDisplayed()){
				return false;
			}
		}
		return true;
	}

	public boolean osItensDaListaDeMateriasPossuemUmaURLValida() {
		for(int i=0; i < itensDaListaDeMaterias().size()-1; i++){
			if(itensDaListaDeMaterias().get(i).findElement(By.tagName("a")).getAttribute("href").isEmpty()){
				return false;
			}
		}
		return true;
	}
}
