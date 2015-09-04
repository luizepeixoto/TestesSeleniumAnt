package pages.capa.esquerda;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import br.com.infoglobo.pages.AceitacaoAbstractTest;

public class ChamadaComWebChamadasComTarjas extends AceitacaoAbstractTest {
	
		//Chamada de matéria Nenhum contendo:
		//	- Titulo, Autor, descricao e total de comentários
		//	- Lista de WebChamadas com tarja (Video, fotogaleria, infográfico) contendo apenas o link.
			
	public ChamadaComWebChamadasComTarjas() throws Exception {
		super();
	}
	
	public List<WebElement> listaEditorias(){
		return getDriver().findElement(By.className("col-left")).findElements(By.className("editorias"));
	}
	
	public WebElement exibiuBoxDeWebChamdasComTarjas(){
		return listaEditorias().get(5);
	}
	
	public boolean exibiuEditoria() {
		return !exibiuBoxDeWebChamdasComTarjas().findElement(By.tagName("h2")).getText().isEmpty();
	}
	
	public boolean exibiuEditoriaComLink() {
		return exibiuBoxDeWebChamdasComTarjas().findElement(By.tagName("h2")).findElement(By.tagName("a")).isDisplayed();
	}
	
	public boolean exibiuEditoriaComLinkValido() {
		return !exibiuBoxDeWebChamdasComTarjas().findElement(By.tagName("h2")).findElement(By.tagName("a")).getAttribute("href").isEmpty();
	}

	public boolean exibiuTituloDaMateria() {
		return !exibiuBoxDeWebChamdasComTarjas().findElement(By.tagName("h3")).getText().isEmpty();
	}

	public boolean exibiuTituloDaMateriaComLink() {
		return exibiuBoxDeWebChamdasComTarjas().findElement(By.tagName("h3")).findElement(By.tagName("a")).isDisplayed();
	}

	public boolean exibiuUmLinkValidoNoTituloDaMateria() {
		return !exibiuBoxDeWebChamdasComTarjas().findElement(By.tagName("h3")).findElement(By.tagName("a")).getAttribute("href").isEmpty();
	}

	public boolean exibiuAutor() {
		return !exibiuBoxDeWebChamdasComTarjas().findElement(By.tagName("span")).findElement(By.tagName("b")).getText().isEmpty();
	}

	public boolean exibiuDescricao() {
		return !exibiuBoxDeWebChamdasComTarjas().findElement(By.tagName("span")).getText().isEmpty();
	}

	public boolean exibiuTotalDeComentarios() {
		List<WebElement> exibiuComentarios = exibiuBoxDeWebChamdasComTarjas().findElement(By.tagName("span")).findElements(By.className("comments"));
		if(exibiuComentarios.size()>0){
			if(exibiuComentarios.get(0).getText().isEmpty()){
				return false;
			}
		}
			return true;
	}
	
	public List<WebElement> listaLinksTarja(){
		return exibiuBoxDeWebChamdasComTarjas().findElement(By.tagName("ul")).findElements(By.tagName("li"));
	}
	
	public boolean exibiuUmaListaDeWebChamadas() {
		return listaLinksTarja().size()>0;
	}
	
	public boolean exibiuTarjaNosLinks() {
		for(int i=0;i<listaLinksTarja().size();i++){
			if(listaLinksTarja().get(i).findElement(By.tagName("a")).findElement(By.className("retranca")).getText().isEmpty()){
				return false;
			}
		}
		return true;
	}
	
	public boolean exibiuLinkComTitulo() {
		for(int i=0;i<listaLinksTarja().size();i++){
			if(listaLinksTarja().get(i).findElement(By.tagName("a")).getText().isEmpty()){
				return false;
			}
		}
		return true;
	}

	public boolean getBoxChamadaSecundariaLinkComTarjaListaTarja() {
		for(int i=0;i<listaLinksTarja().size();i++){
			if(listaLinksTarja().get(i).findElement(By.tagName("a")).findElement(By.className("retranca")).getText().isEmpty()){
				return false;
			}
		}
		return true;
	}
	
	public boolean exibiuTituloComLink() {
		for(int i=0;i<listaLinksTarja().size();i++){
			if(!listaLinksTarja().get(i).findElement(By.tagName("a")).isDisplayed()){
				return false;
			}
		}
		return true;
	}

	public boolean exibiuLinkValidoNoTituloDosLinks() {
		for(int i=0;i<listaLinksTarja().size();i++){
			if(listaLinksTarja().get(i).findElement(By.tagName("a")).getAttribute("href").isEmpty()){
				return false;
			}
		}
		return true;
	}
}
