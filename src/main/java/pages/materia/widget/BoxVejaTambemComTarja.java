package pages.materia.widget;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import br.com.infoglobo.pages.AceitacaoAbstractTest;
import br.com.infoglobo.pages.Navegador;

public class BoxVejaTambemComTarja extends AceitacaoAbstractTest {
	
	public BoxVejaTambemComTarja(Navegador navegador) throws Exception {
		super(navegador);
	}
	
	public WebElement getBoxMateriaInline(){
		return getDriver().findElement(By.className("corpo"));
	}
	
	public WebElement getBoxVeja(){
		return getBoxMateriaInline().findElement(By.className("box-vejaTambem"));
	}
	
	public List<WebElement> getBoxLista(){
		return getBoxVeja().findElement(By.tagName("ul")).findElements(By.tagName("li"));
	}
	
	public boolean getTarja() {
		for(int i=0;i<getBoxLista().size();i++){
			List<WebElement> possuiTarjaNaPosição = getBoxLista().get(i).findElements(By.className("retranca"));
			if(possuiTarjaNaPosição.size()>0){
				if(!(getBoxLista().get(i).findElement(By.className("retranca")).getText().contains("VÍDEO") || 
						getBoxLista().get(i).findElement(By.className("retranca")).getText().contains("GALERIA") || 
						getBoxLista().get(i).findElement(By.className("retranca")).getText().contains("INFOGRÁFICO"))){
					return false;
				}
			}
		}
		return true;
	}
}