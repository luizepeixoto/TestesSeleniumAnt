package pages.capa.esquerda;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import br.com.infoglobo.pages.AceitacaoAbstractTest;

public class ChamadaComFoto extends AceitacaoAbstractTest {
	
	public ChamadaComFoto() throws Exception {
		super();
	}
	
	public List<WebElement> listaEditorias(){
		return getDriver().findElement(By.className("col-left")).findElements(By.className("editorias"));
	}
	
	public WebElement exibiuBoxDeChamadaComFoto(){
		return listaEditorias().get(3);
	}
	
	public boolean exibiuImagem() {
		List<WebElement> exibiuFoto = exibiuBoxDeChamadaComFoto().findElements(By.tagName("img"));
		if(exibiuFoto.size()>0){
			if(!exibiuBoxDeChamadaComFoto().findElement(By.tagName("img")).isDisplayed()){
				return false;
			}
		}
		return true;
	}
	
	public boolean exibiuImagemComClasseLinkAnimado() {
		List<WebElement> exibiuFoto = exibiuBoxDeChamadaComFoto().findElements(By.tagName("img"));
		if(exibiuFoto.size()>0){
			List<WebElement> exibiuFotoAnimada = exibiuBoxDeChamadaComFoto().findElements(By.className("animado-scale"));
			if(exibiuFotoAnimada.size()>0){
				return true;
			}
			return false;
		}
		return true;
	}
	
	public boolean getFotoImagemWidth() {
		List<WebElement> exibiuFoto = exibiuBoxDeChamadaComFoto().findElements(By.tagName("img"));
		if(exibiuFoto.size()>0){
			if(!exibiuBoxDeChamadaComFoto().findElement(By.tagName("img")).getAttribute("width").equals("460")){
				return false;
			}
		}
		return true;
	}
	
	public boolean getFotoImagemHeight() {
		List<WebElement> exibiuFoto = exibiuBoxDeChamadaComFoto().findElements(By.tagName("img"));
		if(exibiuFoto.size()>0){
			if(!exibiuBoxDeChamadaComFoto().findElement(By.tagName("img")).getAttribute("height").equals("200")){
				return false;
			}
		}
		return true;
	}
	
	public boolean getBoxChamadaSecundariaComFotoEditoria() {
		if(exibiuBoxDeChamadaComFoto().findElement(By.tagName("h2")).getText().isEmpty()){
			return false;
		}
		return true;
	}
	
	public boolean getBoxChamadaSecundariaComFotoEditoriaLink() {
		return exibiuBoxDeChamadaComFoto().findElement(By.tagName("h2")).findElement(By.tagName("a")).isDisplayed();
	}
	
	public boolean getBoxChamadaSecundariaComFotoLinkValido() {
		return !exibiuBoxDeChamadaComFoto().findElement(By.tagName("h2")).findElement(By.tagName("a")).getAttribute("href").isEmpty();
	}

	public boolean getBoxChamadaSecundariaComFotoTitulo() {
		return !exibiuBoxDeChamadaComFoto().findElement(By.tagName("h3")).getText().isEmpty();
	}

	public boolean getBoxChamadaSecundariaComFotoTituloLink() {
		if(exibiuBoxDeChamadaComFoto().findElement(By.tagName("h3")).findElement(By.tagName("a")).isDisplayed()){
			return true;
		}
		return false;
	}

	public boolean getBoxChamadaSecundariaComFotoTituloLinkValido() {
		if(exibiuBoxDeChamadaComFoto().findElement(By.tagName("h3")).findElement(By.tagName("a")).getAttribute("href").isEmpty()){
			return false;
		}
		return true;
	}

	public boolean getBoxChamadaSecundariaComFotoAutor() {
		List<WebElement> exibiuAutor = exibiuBoxDeChamadaComFoto().findElement(By.tagName("span")).findElements(By.tagName("b"));
		if(exibiuAutor.size()>0){
			if(exibiuAutor.get(0).getText().isEmpty()){
				return false;
			}
		}
		return true;
	}

	public boolean getBoxChamadaSecundariaComFotoDescricao() {
		if(exibiuBoxDeChamadaComFoto().findElement(By.tagName("span")).getText().isEmpty()){
			return false;
		}
		return true;
	}

	public boolean getBoxChamadaSecundariaComFotoComentarios() {
		List<WebElement> exibiuComentarios = exibiuBoxDeChamadaComFoto().findElement(By.tagName("span")).findElements(By.className("comments"));
		if(exibiuComentarios.size()>0){
			if(exibiuComentarios.get(0).getText().isEmpty()){
				return false;
			}
		}
			return true;
	}
}
