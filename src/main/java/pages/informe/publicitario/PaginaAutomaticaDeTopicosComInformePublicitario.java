package pages.informe.publicitario;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import br.com.infoglobo.pages.AceitacaoAbstractTest;

public class PaginaAutomaticaDeTopicosComInformePublicitario extends AceitacaoAbstractTest {
	
	public PaginaAutomaticaDeTopicosComInformePublicitario() throws Exception {
		super();
	}
	
	public List<WebElement> totalDeChamadasDeInformePublicitario() {
		return getDriver().findElement(By.id("ultimasNoticias")).findElement(By.tagName("ul")).findElements(By.className("especial-publicitario"));
	}
	
	public boolean exibiuChamadaDeInformePublicitarioDentroDeEmTopico() {
		return totalDeChamadasDeInformePublicitario().size() > 0;
	}
	
	public WebElement exibiuChamadaDeInformeNaLista(){
		return getDriver().findElement(By.id("ultimasNoticias")).findElement(By.tagName("ul")).findElement(By.className("especial-publicitario"));
	}
	
	public List<WebElement> imagemNaChamadaDoEspecialPublicitario() {
		return exibiuChamadaDeInformeNaLista().findElement(By.tagName("a")).findElements(By.tagName("img"));
	}
	
	public WebElement possuiImagemNaChamadaDoEspecialPublicitario() {
		return exibiuChamadaDeInformeNaLista().findElement(By.tagName("a")).findElement(By.tagName("img"));
	}
	
	public boolean exibiuFotoNaChamadaDeInformePublicitario() {
		return imagemNaChamadaDoEspecialPublicitario().size() > 0;
	}
	
	public boolean exibiuFotoOuDescricaoNaChamadaDoInformePublicitario(){
		if(exibiuFotoNaChamadaDeInformePublicitario()){
			return possuiImagemNaChamadaDoEspecialPublicitario().isDisplayed();
		}
		return !exibiuChamadaDeInformeNaLista().findElement(By.tagName("h3")).getText().isEmpty();
	}
	
	public boolean exibiuTituloDeEspecialPublicitario() {
		for(int i=0; i< totalDeChamadasDeInformePublicitario().size(); i++){
			if(!totalDeChamadasDeInformePublicitario().get(i).findElement(By.className("editoria")).getText().equals("Especial publicitário")){
				return false;
			}
		}
		return true;
	}
	
	public boolean exibiuTituloEmItalicoNaChamadaDoEspecialPublicitario() {
		for(int i=0; i< totalDeChamadasDeInformePublicitario().size(); i++){
			if(totalDeChamadasDeInformePublicitario().get(i).findElement(By.tagName("h2")).getText().isEmpty()){
				return false;
			}
		}
		return true;
	}
}
