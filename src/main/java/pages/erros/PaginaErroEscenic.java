package pages.erros;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import br.com.infoglobo.pages.AceitacaoAbstractTest;

public class PaginaErroEscenic extends AceitacaoAbstractTest {
	
	public PaginaErroEscenic() throws Exception {
		super();
	}
	
	public String exibiuOTituloNaPagina() {
		return getDriver().findElement(By.className("e")).getText();
	}

	public boolean exibiuOTituloOGlobo() {
		return getDriver().findElement(By.className("s")).findElement(By.tagName("b")).getText().equals("O Globo");
	}

	public boolean exibiuAData() {
		return !getDriver().findElement(By.className("s")).findElement(By.tagName("span")).getText().isEmpty();
	}

	public boolean exibiuAPrimeiraMateriaComoDestaque() {
		return getDriver().findElement(By.className("inner-container")).findElements(By.tagName("p")).get(1).isDisplayed();
	}
	
	public boolean exibiuTituloDaPrimeiraMateriaComoDestaque() {
		return !getDriver().findElement(By.className("inner-container")).findElements(By.tagName("p")).get(1).findElement(By.tagName("strong")).getText().isEmpty();
	}
	
	public boolean exibiuDescricaoDaPrimeiraMateriaComoDestaque() {
		return !getDriver().findElement(By.className("inner-container")).findElements(By.tagName("p")).get(1).getText().isEmpty();
	}
	
	public List<WebElement> listaDeMaterias() {
		return getDriver().findElement(By.className("inner-container")).findElements(By.tagName("div"));
	}
	
	public boolean exibiuTituloParaAsMaterias() {
		for(int i=0;i<listaDeMaterias().size();i++){
			if(listaDeMaterias().get(i).findElement(By.tagName("strong")).getText().isEmpty()){
				return false;
			}
		}
		return true;
	}

	public boolean exibiuDescricaoParaAsMaterias() {
		for(int i=0;i<listaDeMaterias().size();i++){
			if(listaDeMaterias().get(i).findElement(By.tagName("p")).getText().isEmpty()){
				return false;
			}
		}
		return true;
	}

	public String exibiuRodape() {
		return getDriver().findElement(By.className("c")).getText();
	}
}
