package pages.ultimas;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import br.com.infoglobo.pages.AceitacaoAbstractTest;

public class UltimasNoticiasComInformePublicitario extends AceitacaoAbstractTest {
	
	public UltimasNoticiasComInformePublicitario() throws Exception {
		super();
	}
	
	public List<WebElement> totalDeChamadasDeInformePublicitario() {
		return getDriver().findElement(By.id("ultimasNoticias")).findElement(By.tagName("ul")).findElements(By.className("especial-publicitario"));
	}
	
	public boolean exibiuChamadaDeInformePublicitario() {
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
	
	public boolean exibiuEditoriaNaChamadaDoInformePublicitario() {
		if(exibiuChamadaDeInformePublicitario()){
			return exibiuChamadaDeInformeNaLista().findElement(By.className("editoria")).isDisplayed();
		}
		return false;
	}
	
	public boolean exibiuTituloEmItalicoNaChamadaDoInformePublicitario() {
		if(exibiuChamadaDeInformePublicitario()){
			return !exibiuChamadaDeInformeNaLista().findElement(By.tagName("h2")).getText().isEmpty();
		}
		return false;
	}
}
