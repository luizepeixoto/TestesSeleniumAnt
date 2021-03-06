package pages.capa.esquerda;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import br.com.infoglobo.pages.AceitacaoAbstractTest;

public class ChamadaComChamadaSecundariaComTarja extends AceitacaoAbstractTest {
	
//	Chamada na 6 posição, contendo:
//		- Editoria, título, autor, descrição e total de comentários
//		- 3 ou mais chamadas secundárias de infograficos, videos ou fotogalerias, contendo:
//			- Titulo, autor e descrição
	
	public ChamadaComChamadaSecundariaComTarja() throws Exception {
		super();
	}
	
	public List<WebElement> listaEditorias(){
		return getDriver().findElement(By.className("col-left")).findElements(By.className("editorias"));
	}
	
	public WebElement exibiuBoxChamadaSecundariaComTarja(){
		return listaEditorias().get(4);
	}
	
	public boolean exibiuEditoriaDaMateria() {
		return !exibiuBoxChamadaSecundariaComTarja().findElement(By.tagName("h2")).getText().isEmpty();
	}
	
	public boolean exibiuUmLinkNaEditoria() {
		return exibiuBoxChamadaSecundariaComTarja().findElement(By.tagName("h2")).findElement(By.tagName("a")).isDisplayed();
	}
	
	public boolean exibiuUmLinkValidoNaEditoria() {
		return !exibiuBoxChamadaSecundariaComTarja().findElement(By.tagName("h2")).findElement(By.tagName("a")).getAttribute("href").isEmpty();
	}

	public boolean exibiuTitulo() {
		return !exibiuBoxChamadaSecundariaComTarja().findElement(By.tagName("h3")).getText().isEmpty();
	}

	public boolean exibiuTituloComLink() {
		return exibiuBoxChamadaSecundariaComTarja().findElement(By.tagName("h3")).findElement(By.tagName("a")).isDisplayed();
	}

	public boolean exibiuTituloComLinkValido() {
		return !exibiuBoxChamadaSecundariaComTarja().findElement(By.tagName("h3")).findElement(By.tagName("a")).getAttribute("href").isEmpty();
	}

	public boolean exibiuAutorDaMateria() {
		return !exibiuBoxChamadaSecundariaComTarja().findElement(By.tagName("span")).findElement(By.tagName("b")).getText().isEmpty();
	}

	public boolean exibiuDescricaoDaMateria() {
		return !exibiuBoxChamadaSecundariaComTarja().findElement(By.tagName("span")).getText().isEmpty();
	}

	public boolean exibiuTotalDeComentariosDaMateria() {
		return !exibiuBoxChamadaSecundariaComTarja().findElement(By.tagName("span")).findElement(By.className("comments")).getText().isEmpty();
	}
	
	public WebElement exibiuBoxDeChamadasSecundarias() {
		return exibiuBoxChamadaSecundariaComTarja().findElement(By.className("materia-relacionada"));
	}
	
	
	public List<WebElement> listaDeChamadasSecundarias() {
		return exibiuBoxChamadaSecundariaComTarja().findElements(By.className("materia-relacionada"));
	}
	
	public boolean exibiuListaDeMateriasSecundarias(){
		return listaDeChamadasSecundarias().size() > 0;
	}
	
	public boolean exibiuTarjaNoTitulo() {
		for(int i=0; i<listaDeChamadasSecundarias().size(); i++){
			if(listaDeChamadasSecundarias().get(i).findElement(By.className("retranca")).getText().isEmpty()){
				return false;
			}
		}
		return true;
	}
	
	public boolean exibiuTituloNasMateriasSecundarias() {
		for(int i=0; i<listaDeChamadasSecundarias().size(); i++){
			if(listaDeChamadasSecundarias().get(i).findElement(By.tagName("h3")).getText().isEmpty()){
				return false;
			}
		}
		return true;
	}
	
	public boolean exibiuLinkNosTitulosDasMateriasSecundarias() {
		for(int i=0; i<listaDeChamadasSecundarias().size(); i++){
			if(!listaDeChamadasSecundarias().get(i).findElement(By.className("clearfix")).findElement(By.tagName("h3")).findElement(By.tagName("a")).isDisplayed()){
				return false;
			}
		}
		return true;
	}

	public boolean exibiuLinkValidoNoTituloDasMateriasSecundarias() {
		for(int i=0; i<listaDeChamadasSecundarias().size(); i++){
			if(listaDeChamadasSecundarias().get(i).findElement(By.tagName("h3")).findElement(By.tagName("a")).getAttribute("href").isEmpty()){
				return false;
			}
		}
		return true;
	}

	public boolean exibiuAutorNasMateriasSecundarias() {
		for(int i=0; i<listaDeChamadasSecundarias().size(); i++){
			if(listaDeChamadasSecundarias().get(i).findElement(By.tagName("span")).findElement(By.tagName("b")).getText().isEmpty()){
				return false;
			}
		}
		return true;
	}

	public boolean exibiuDescricaoDasMateriasSecundarias() {
		for(int i=0; i<listaDeChamadasSecundarias().size(); i++){
			if(!listaDeChamadasSecundarias().get(i).findElement(By.className("clearfix")).findElement(By.tagName("span")).isDisplayed()){
				return false;
			}
		}
		return true;
	}
}
