package pages.capa.esquerda;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import br.com.infoglobo.pages.AceitacaoAbstractTest;

public class ChamadaComWebChamada extends AceitacaoAbstractTest {
	
	//Chamada Nenhum na segunda posição, contendo:
	//	- Editoria
	//	- Titulo, autor, descrição e link de comentários
	//	- Duas WebChamadas com titulo
		
	public ChamadaComWebChamada() throws Exception {
		super();
	}
	
	public List<WebElement> listaEditorias(){
		return getDriver().findElement(By.className("col-left")).findElements(By.className("editorias"));
	}
	
	public WebElement exibiuBoxDeChamadasComWebChamadas(){
		return listaEditorias().get(1);
	}
	
	public boolean exibiuEditoria() {
		return !exibiuBoxDeChamadasComWebChamadas().findElement(By.tagName("h2")).getText().isEmpty();
	}
	
	public boolean exibiuLinkNaEditoria() {
		return exibiuBoxDeChamadasComWebChamadas().findElement(By.tagName("h2")).findElement(By.tagName("a")).isDisplayed();
	}
	
	public boolean exibiuLinkValidoNaEditoria() {
		return !exibiuBoxDeChamadasComWebChamadas().findElement(By.tagName("h2")).findElement(By.tagName("a")).getAttribute("href").isEmpty();
	}

	public boolean exibiuTitulo() {
		return !exibiuBoxDeChamadasComWebChamadas().findElement(By.tagName("h3")).getText().isEmpty();
	}

	public boolean exibiuTituloComLink() {
		return exibiuBoxDeChamadasComWebChamadas().findElement(By.tagName("h3")).findElement(By.tagName("a")).isDisplayed();
	}

	public boolean exibiuTituloComLinkValido() {
		return !exibiuBoxDeChamadasComWebChamadas().findElement(By.tagName("h3")).findElement(By.tagName("a")).getAttribute("href").isEmpty();
	}

	public boolean exibiuAutor() {
		return !exibiuBoxDeChamadasComWebChamadas().findElement(By.tagName("span")).findElement(By.tagName("b")).getText().isEmpty();
	}

	public boolean exibiuDescricao() {
		return !exibiuBoxDeChamadasComWebChamadas().findElement(By.tagName("span")).getText().isEmpty();
	}

	public boolean exibiuTotalDeComentarios() {
		return !exibiuBoxDeChamadasComWebChamadas().findElement(By.tagName("span")).findElement(By.className("comments")).getText().isEmpty();
	}
	
	public List<WebElement> listaLinks(){
		return exibiuBoxDeChamadasComWebChamadas().findElement(By.tagName("ul")).findElements(By.tagName("li"));
	}
	
	public boolean exibiuListaDeWebChamadas() {
		return listaLinks().size()>0;
	}
	
	public boolean exibiuTituloDasDeWebChamadas() {
		for(int i=0;i<listaLinks().size();i++){
			if(listaLinks().get(i).findElement(By.tagName("a")).getText().isEmpty()){
				return false;
			}
		}
		return true;
	}

	public boolean exibiuTituloComLinkNasWebChamadas() {
		for(int i=0;i<listaLinks().size();i++){
			if(!listaLinks().get(i).findElement(By.tagName("a")).isDisplayed()){
				return false;
			}
		}
		return true;
	}

	public boolean exibiuLinkValidoNosTitulosDasWebChamadas() {
		for(int i=0;i<listaLinks().size();i++){
			if(listaLinks().get(i).findElement(By.tagName("a")).getAttribute("href").isEmpty()){
				return false;
			}
		}
		return true;
	}
}
