package pages.capa.esquerda;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import br.com.infoglobo.pages.AceitacaoAbstractTest;

public class BoxDeMaisMaterias extends AceitacaoAbstractTest {
	
	public BoxDeMaisMaterias() throws Exception {
		super();
	}
	
	//Chamada de últimas matérias - início
	public List<WebElement> listaTotalDeUltimasChamadas(){
		return getDriver().findElement(By.className("col-left")).findElements(By.className("ultimas"));
	}
	
	public WebElement getBoxDeUltimasChamadas() {
		return listaTotalDeUltimasChamadas().get(0);
	}

	public boolean oTituloEstaSendoExibido() {
		return !getBoxDeUltimasChamadas().getText().isEmpty();
	}

	public boolean oTituloEstaSendoExibidoEmMaiusculo() {
		return !getBoxDeUltimasChamadas().findElement(By.tagName("h2")).findElement(By.tagName("i")).getText().isEmpty();
	}
	
	public List<WebElement> listaTotalDeMateriasDaUltimaChamada(){
		return listaTotalDeUltimasChamadas().get(0).findElements(By.tagName("li"));
	}
	
	public boolean aListaDeMateriasEhMaiorQueZero() {
		return listaTotalDeMateriasDaUltimaChamada().size() > 0;
	}

	public boolean osItensDaListaDeMateriasPossuemUmTitulo() {
		for(int i=0; i<listaTotalDeMateriasDaUltimaChamada().size()-1; i++){
			if(listaTotalDeMateriasDaUltimaChamada().get(i).findElement(By.tagName("h3")).getText().isEmpty()){
				return false;
			}
		}
		return true;
	}

	public boolean osItensDaListaDeMateriasPossuemUmLinkNoTitulo() {
		for(int i=0; i<listaTotalDeMateriasDaUltimaChamada().size()-1; i++){
			if(!listaTotalDeMateriasDaUltimaChamada().get(i).findElement(By.tagName("h3")).findElement(By.tagName("a")).isDisplayed()){
				return false;
			}
		}
		return true;
	}

	public boolean osLinksDaListaDeMateriasSaoValidos() {
		for(int i=0; i<listaTotalDeMateriasDaUltimaChamada().size()-1; i++){
			if(listaTotalDeMateriasDaUltimaChamada().get(i).findElement(By.tagName("h3")).findElement(By.tagName("a")).getAttribute("href").isEmpty()){
				return false;
			}
		}
		return true;
	}
	//Chamada de últimas matérias - Fim

	//Chamada de últimas matérias Com tarja - início
	public WebElement getBoxDeUltimasChamadasComTarja() {
		return listaTotalDeUltimasChamadas().get(1);
	}

	public boolean oTituloDoBoxComTarjaEstaSendoExibido() {
		return !getBoxDeUltimasChamadasComTarja().getText().isEmpty();
	}

	public boolean oTituloDaEditoriaDoBoxComTarjaEstaSendoExibidoEmMaiusculo() {
		return !getBoxDeUltimasChamadasComTarja().findElement(By.tagName("h2")).findElement(By.tagName("i")).getText().isEmpty();
	}
	
	public List<WebElement> listaTotalDeMateriasDaUltimaChamadaDoBoxComTarja(){
		return getBoxDeUltimasChamadasComTarja().findElements(By.tagName("li"));
	}
	
	public boolean aListaDeMateriasDoBoxComTarjaEhMaiorQueZero() {
		return listaTotalDeMateriasDaUltimaChamadaDoBoxComTarja().size() > 0;
	}
	
	public boolean osItensDaListaDeMateriasDoBoxComTarjaPossuemUmaTarja() {
		for(int i=0; i<listaTotalDeMateriasDaUltimaChamadaDoBoxComTarja().size()-1; i++){
			if(listaTotalDeMateriasDaUltimaChamadaDoBoxComTarja().get(i).findElement(By.className("retranca")).getText().isEmpty()){
				return false;
			}
		}
		return true;
	}
	
	public boolean osItensDaListaDeMateriasDoBoxComTarjaPossuemUmTitulo() {
		for(int i=0; i<listaTotalDeMateriasDaUltimaChamadaDoBoxComTarja().size()-1; i++){
			if(listaTotalDeMateriasDaUltimaChamadaDoBoxComTarja().get(i).findElement(By.tagName("h3")).getText().isEmpty()){
				return false;
			}
		}
		return true;
	}

	public boolean osItensDaListaDeMateriasDoBoxComTarjaPossuemUmLinkNoTitulo() {
		for(int i=0; i<listaTotalDeMateriasDaUltimaChamadaDoBoxComTarja().size()-1; i++){
			if(!listaTotalDeMateriasDaUltimaChamadaDoBoxComTarja().get(i).findElement(By.tagName("h3")).findElement(By.tagName("a")).isDisplayed()){
				return false;
			}
		}
		return true;
	}

	public boolean osLinksDaListaDeMateriasDoBoxComTarjaSaoValidos() {
		for(int i=0; i<listaTotalDeMateriasDaUltimaChamadaDoBoxComTarja().size()-1; i++){
			if(listaTotalDeMateriasDaUltimaChamadaDoBoxComTarja().get(i).findElement(By.tagName("h3")).findElement(By.tagName("a")).getAttribute("href").isEmpty()){
				return false;
			}
		}
		return true;
	}
	//Chamada de últimas matérias Com tarja - Fim
}
