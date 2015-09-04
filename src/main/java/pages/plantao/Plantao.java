package pages.plantao;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import br.com.infoglobo.pages.AceitacaoAbstractTest;

public class Plantao extends AceitacaoAbstractTest {

	public Plantao() throws Exception{
		super();
	}
	
	public WebElement exibiuClasseTexteira() {
		return getDriver().findElement(By.className("texteira"));
	}
	
	public boolean exibiuData() {
		return !getDriver().findElement(By.className("data-cadastro")).getText().isEmpty();
	}

	public boolean exibiuEditoria() {
		return !exibiuClasseTexteira().findElement(By.tagName("h2")).getText().isEmpty();
	}

	public boolean exibiuTitulo() {
		return !exibiuClasseTexteira().findElement(By.tagName("h1")).getText().isEmpty();
	}

	public boolean exibiuFoto() {
		List<WebElement> exibiuFoto = exibiuClasseTexteira().findElements(By.tagName("img"));
		if(exibiuFoto.size()>0){
			return exibiuClasseTexteira().findElement(By.tagName("img")).isDisplayed();
		}
		return true;
	}

	public boolean exibiuWidth() {
		List<WebElement> exibiuFoto = exibiuClasseTexteira().findElements(By.tagName("img"));
		if(exibiuFoto.size()>0){
			return exibiuClasseTexteira().findElement(By.tagName("img")).getAttribute("width").equals("300");
		}
		return true;
	}

	public boolean exibiuHeight() {
		List<WebElement> exibiuFoto = exibiuClasseTexteira().findElements(By.tagName("img"));
		if(exibiuFoto.size()>0){
			return exibiuClasseTexteira().findElement(By.tagName("img")).getAttribute("height").equals("180");
		}
		return true;
	}

	public boolean exibiuTextoDoPlantao() {
		return !exibiuClasseTexteira().findElement(By.tagName("p")).getText().isEmpty();
	}
	
	public WebElement exibiuBoxDaArroba() {
		return getDriver().findElement(By.className("arroba"));
	}

	public String exibiuOTituloDePublicidade() {
		return getDriver().findElement(By.className("arroba")).findElement(By.tagName("p")).getText();
	}

	public WebElement exibiuBoxDeLinkPatrocinado() {
		return getDriver().findElement(By.className("publicidade-materia"));
	}
	
	public String exibiuCodigoFonteDaPagina(){
		return getDriver().getPageSource();
	}
}
