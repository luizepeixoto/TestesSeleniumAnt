package pages.materia.widget;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import br.com.infoglobo.pages.AceitacaoAbstractTest;

public class BoxVejaTambemDefeitoSemLinks extends AceitacaoAbstractTest {
	
	public BoxVejaTambemDefeitoSemLinks() throws Exception {
		super();
	}
	
	public WebElement getBoxMateriaInline(){
		return getDriver().findElement(By.className("corpo"));
	}
	
	public WebElement exibiuBoxVejaMais(){
		return getBoxMateriaInline().findElement(By.className("box-vejaTambem"));
	}
	
	public String getBoxTitulo(){
		return exibiuBoxVejaMais().findElement(By.tagName("h6")).getText();
	}
	
	public List<WebElement> getBoxLista(){
		return exibiuBoxVejaMais().findElement(By.tagName("ul")).findElements(By.tagName("li"));
	}
	
	public boolean exibiuListaDeMaterias() {
		return getBoxLista().size() > 0;
	}

	public boolean exibiuTituloParaAsMaterias() {
		for(int i=0;i<getBoxLista().size();i++){
			if(getBoxLista().get(i).findElement(By.tagName("a")).getText().isEmpty()){
				return false;
			}
		}
		return true;
	}

	public boolean exibiuUmLinkParaCadaUmaDasMaterias() {
		for(int i=0;i<getBoxLista().size();i++){
			if(!getBoxLista().get(i).findElement(By.tagName("a")).isDisplayed()){
				return false;
			}
		}
		return true;
	}

	public boolean exibiuUmLinkValidoParaCadaUmaDasMaterias() {
		for(int i=0;i<getBoxLista().size();i++){
			if(getBoxLista().get(i).findElement(By.tagName("a")).getAttribute("href").isEmpty()){
				return false;
			}
		}
		return true;
	}
}
