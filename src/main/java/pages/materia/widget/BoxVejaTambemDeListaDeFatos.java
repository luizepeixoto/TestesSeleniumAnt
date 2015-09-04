package pages.materia.widget;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import br.com.infoglobo.pages.AceitacaoAbstractTest;
import br.com.infoglobo.pages.Navegador;

public class BoxVejaTambemDeListaDeFatos extends AceitacaoAbstractTest {
	
	public BoxVejaTambemDeListaDeFatos(Navegador navegador) throws Exception {
		super(navegador);
	}
	
	public WebElement getBoxMateriaInline(){
		return getDriver().findElement(By.className("corpo"));
	}
	
	public WebElement getBoxVeja(){
		return getBoxMateriaInline().findElement(By.className("box-vejaTambem"));
	}
	
	public String getBoxTitulo(){
		return getBoxVeja().findElement(By.tagName("h6")).getText();
	}
	
	public List<WebElement> getBoxLista(){
		return getBoxVeja().findElement(By.tagName("ul")).findElements(By.tagName("li"));
	}
	
	public boolean getBoxListaTamanho() {
		return getBoxLista().size() > 0;
	}

	public boolean getBoxListaTitulos() {
		for(int i=0;i<getBoxLista().size();i++){
			if(getBoxLista().get(i).findElement(By.tagName("a")).getText().isEmpty()){
				return false;
			}
		}
		return true;
	}

	public boolean getBoxLinks() {
		for(int i=0;i<getBoxLista().size();i++){
			if(!getBoxLista().get(i).findElement(By.tagName("a")).isDisplayed()){
				return false;
			}
		}
		return true;
	}

	public boolean getBoxLinksValidos() {
		for(int i=0;i<getBoxLista().size();i++){
			if(getBoxLista().get(i).findElement(By.tagName("a")).getAttribute("href").isEmpty()){
				return false;
			}
		}
		return true;
	}
}
