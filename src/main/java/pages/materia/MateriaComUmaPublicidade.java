package pages.materia;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import br.com.infoglobo.pages.AceitacaoAbstractTest;

public class MateriaComUmaPublicidade extends AceitacaoAbstractTest {
	
	public MateriaComUmaPublicidade() throws Exception {
		super();
	}
	
	public List<WebElement> listaDePropagandas(){
		return getDriver().findElement(By.className("corpo")).findElements(By.className("arroba"));
	}

	public boolean exibiuApenasUmaPublicidade() {
		return listaDePropagandas().size() == Integer.parseInt("1");
	}
	
	public List<WebElement> listaDeTagsP(){
		return getDriver().findElement(By.className("corpo")).findElements(By.tagName("p"));
	}
	
	public boolean exibiuOTituloPublicidade(){
		for(int i=0; i<listaDePropagandas().size();i++){
			if(!listaDePropagandas().get(i).findElement(By.className("publicidade-container")).findElement(By.tagName("p")).getText().contains("Publicidade"))
				return false;
		}
		return true;
	}
	
	public boolean exibiuOTituloPublicidadePossuiUmLink(){
		for(int i=0; i<listaDePropagandas().size();i++){
			if(!listaDePropagandas().get(i).findElement(By.className("publicidade-container")).findElement(By.tagName("p")).findElement(By.tagName("a")).isDisplayed())
				return false;
		}
		return true;
	}
	
	public boolean exibiuOTituloPublicidadePossuiUmLinkValido(){
		for(int i=0; i<listaDePropagandas().size();i++){
			if(listaDePropagandas().get(i).findElement(By.className("publicidade-container")).findElement(By.tagName("p")).findElement(By.tagName("a")).getAttribute("href").isEmpty())
				return false;
		}
		return true;
	}
	
	public boolean exibiuOLinkNoTituloPublicidadeComTargetBlank(){
		for(int i=0; i<listaDePropagandas().size();i++){
			if(!listaDePropagandas().get(i).findElement(By.className("publicidade-container")).findElement(By.tagName("p")).findElement(By.tagName("a")).getAttribute("target").equals("_blank"))
				return false;
		}
		return true;
	}
	
	public boolean getBoxScriptPublicidade() {
		for(int i=0; i<listaDePropagandas().size();i++){
			if(!listaDePropagandas().get(i).findElement(By.className("publicidade-container")).findElement(By.tagName("script")).isDisplayed())
				return false;
		}
		return true;
	}
}