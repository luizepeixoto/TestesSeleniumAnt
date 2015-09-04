package pages.capa.esquerda;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import br.com.infoglobo.pages.AceitacaoAbstractTest;

public class ChamadaSemEditoria extends AceitacaoAbstractTest {
	
	//Chamada na terceira posição da coluna da esquerda. Contendo:
	//	- Editoria preenchida em branco
	//	- Titulo da matéria, descrição, autor e comentários totais
		
	public ChamadaSemEditoria() throws Exception {
		super();
	}
	
	public List<WebElement> listaEditorias(){
		return getDriver().findElement(By.className("col-left")).findElements(By.className("editorias"));
	}
	
	public WebElement exibiuOBoxDaEditoriaEmBranco(){
		return listaEditorias().get(2);
	}
	
	public boolean exibiuEditoriaEmBranco() {
		List<WebElement> resultadoEsperado = exibiuOBoxDaEditoriaEmBranco().findElements(By.tagName("h2"));
		return resultadoEsperado.size()==0;
	}
					
	public boolean exibiuTitulo() {
		return !exibiuOBoxDaEditoriaEmBranco().findElement(By.tagName("h3")).getText().isEmpty();
	}

	public boolean exibiuTituloComLink() {
		return exibiuOBoxDaEditoriaEmBranco().findElement(By.tagName("h3")).findElement(By.tagName("a")).isDisplayed();
	}

	public boolean exibiuTituloComLinkValido() {
		return !exibiuOBoxDaEditoriaEmBranco().findElement(By.tagName("h3")).findElement(By.tagName("a")).getAttribute("href").isEmpty();
	}

	public boolean exibiuOAutor() {
		List<WebElement> exibiuAutor = exibiuOBoxDaEditoriaEmBranco().findElement(By.tagName("span")).findElements(By.tagName("b"));
		if(exibiuAutor.size()>0){
			if(exibiuAutor.get(0).getText().isEmpty()){
				return false;
			}
		}
		return true;
	}

	public boolean exibiuDescricaoDaMateria() {
		return !exibiuOBoxDaEditoriaEmBranco().findElement(By.tagName("span")).getText().isEmpty();
	}

	public boolean exibiuTotalDeComentarios() {
		List<WebElement> exibiuComentarios = exibiuOBoxDaEditoriaEmBranco().findElement(By.tagName("span")).findElements(By.className("comments"));
		if(exibiuComentarios.get(0).getText().isEmpty()){
			return false;
		}
		return true;
	}
	
	public boolean exibiuLinkEmComentarios() {
		List<WebElement> exibiuComentarios = exibiuOBoxDaEditoriaEmBranco().findElement(By.tagName("span")).findElements(By.className("comments"));
		if(exibiuComentarios.size() > 0){
			if(!exibiuOBoxDaEditoriaEmBranco().findElement(By.tagName("span")).findElement(By.tagName("a")).isDisplayed()){
				return false;
			}
		}
		return true;
	}
	
	public boolean exibiuLinkValidoEmComentarios() {
		List<WebElement> exibiuComentarios = exibiuOBoxDaEditoriaEmBranco().findElement(By.tagName("span")).findElements(By.className("comments"));
		if(exibiuComentarios.size() > 0){
			if(exibiuOBoxDaEditoriaEmBranco().findElement(By.tagName("span")).findElement(By.tagName("a")).getAttribute("href").isEmpty()){
				return false;
			}
		}
		return true;
	}
}
