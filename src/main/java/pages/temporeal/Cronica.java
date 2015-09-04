package pages.temporeal;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import br.com.infoglobo.pages.AceitacaoAbstractTest;
import br.com.infoglobo.pages.Navegador;

public class Cronica extends AceitacaoAbstractTest {
	
	public Cronica(Navegador navegador) throws Exception{
		super(navegador);
	}
	
	public WebElement exibiuBoxDeCronica() {
		return getDriver().findElement(By.className("cronica-tempo-real"));
	}

	public boolean exibiuEditoriaCronica() {
		return !exibiuBoxDeCronica().findElement(By.tagName("h1")).getText().isEmpty();
	}

	public boolean exibiuAncoraNoTopoDaPagina() {
		return exibiuBoxDeCronica().findElement(By.tagName("header")).findElement(By.tagName("a")).isDisplayed();
	}

	public boolean exibiuTextoCorretoNaAncora() {
		return exibiuBoxDeCronica().findElement(By.tagName("header")).findElement(By.className("ancora-timeline")).getText().contains("Ver lance a lance");
	}

	public boolean exibiuLinkValidoNaAncora() {
		return !exibiuBoxDeCronica().findElement(By.tagName("header")).findElement(By.className("ancora-timeline")).getAttribute("href").isEmpty();
	}

	public boolean exibiuTitulo() {
		return !exibiuBoxDeCronica().findElement(By.tagName("header")).findElement(By.tagName("p")).getText().isEmpty();
	}

	public boolean exibiuAutor() {
		return !exibiuBoxDeCronica().findElement(By.className("autor-cronica")).getText().isEmpty();
	}
	
	public boolean exibiuTexto() {
		return !exibiuBoxDeCronica().findElement(By.tagName("p")).getText().isEmpty();
	}
	
	public boolean exibiuImagem() {
		List<WebElement> possuiFoto = exibiuBoxDeCronica().findElements(By.tagName("figure"));
		if(possuiFoto.size() > 0){
			if(!exibiuBoxDeCronica().findElement(By.tagName("figure")).findElement(By.tagName("img")).isDisplayed()){
				return false;
			}
		}
		return true;
	}

	public boolean getWidth() {
		List<WebElement> possuiFoto = exibiuBoxDeCronica().findElements(By.className("foto"));
		if(possuiFoto.size() > 0){
			if(exibiuBoxDeCronica().findElement(By.className("foto")).findElement(By.tagName("img")).getAttribute("width").isEmpty()){
				return false;
			}
		}
		return true;
	}

	public boolean getHeight() {
		List<WebElement> possuiFoto = exibiuBoxDeCronica().findElements(By.className("foto"));
		if(possuiFoto.size() > 0){
			if(exibiuBoxDeCronica().findElement(By.className("foto")).findElement(By.tagName("img")).getAttribute("height").isEmpty()){
				return false;
			}
		}
		return true;
	}

	public boolean exibiuLegenda() {
		List<WebElement> possuiFoto = exibiuBoxDeCronica().findElements(By.tagName("figure"));
		if(possuiFoto.size() > 0){
			if(exibiuBoxDeCronica().findElement(By.tagName("figure")).findElement(By.tagName("figcaption")).getText().isEmpty()){
				return false;
			}
		}
		return true;
	}
	
	public boolean exibiuAutoNaLegenda() {
		List<WebElement> possuiFoto = exibiuBoxDeCronica().findElements(By.tagName("figure"));
		if(possuiFoto.size() > 0){
			if(exibiuBoxDeCronica().findElement(By.tagName("figure")).findElement(By.tagName("figcaption")).findElement(By.tagName("b")).getText().isEmpty()){
				return false;
			}
		}
		return true;
	}
}
