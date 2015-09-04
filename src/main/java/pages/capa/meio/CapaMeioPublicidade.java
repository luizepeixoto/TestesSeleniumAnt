package pages.capa.meio;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import br.com.infoglobo.pages.AceitacaoAbstractTest;

public class CapaMeioPublicidade extends AceitacaoAbstractTest {
	
	public CapaMeioPublicidade() throws Exception {
		super();
	}
	
	public List<WebElement> listaDePublicidadesDaColunaDoMeio() {
		return getDriver().findElement(By.className("main-home")).findElements(By.className("publicidade"));
	}
	
	public boolean exibiuBoxDePublicidade() {
		for(int i=0 ; i<listaDePublicidadesDaColunaDoMeio().size() ; i++){
			if(!listaDePublicidadesDaColunaDoMeio().get(i).isDisplayed()){
				return false;
			}
		}
		return true;
	}
	
	public boolean oBoxDePublicidadeEstaExibidoUmaPublicidade() {
		for(int i=0 ; i<listaDePublicidadesDaColunaDoMeio().size() ; i++){
			if(!listaDePublicidadesDaColunaDoMeio().get(i).findElement(By.className("publicidade-container")).findElement(By.tagName("script")).isDisplayed()){
				return false;
			}
		}
		return true;
	}
	
	public boolean exibiuOTituloPublicidade() {
		for(int i=0 ; i<listaDePublicidadesDaColunaDoMeio().size() ; i++){
			if(!listaDePublicidadesDaColunaDoMeio().get(i).findElement(By.className("publicidade-container")).findElement(By.tagName("p")).getText().contains("Publicidade")){
				return false;
			}
		}
		return true;
	}
	
	public boolean exibiuOTituloPublicidadePossuiUmLink() {
		for(int i=0 ; i<listaDePublicidadesDaColunaDoMeio().size() ; i++){
			if(!listaDePublicidadesDaColunaDoMeio().get(i).findElement(By.className("publicidade-container")).findElement(By.tagName("p")).findElement(By.tagName("a")).isDisplayed()){
				return false;
			}
		}
		return true;
	}
	
	public boolean exibiuOTituloPublicidadePossuiUmLinkValido() {
		for(int i=0 ; i<listaDePublicidadesDaColunaDoMeio().size() ; i++){
			if(listaDePublicidadesDaColunaDoMeio().get(i).findElement(By.className("publicidade-container")).findElement(By.tagName("p")).findElement(By.tagName("a")).getAttribute("href").isEmpty()){
				return false;
			}
		}
		return true;
	}
	
	public boolean exibiuOLinkNoTituloPublicidadeComTargetBlank() {
		for(int i=0 ; i<listaDePublicidadesDaColunaDoMeio().size() ; i++){
			if(!listaDePublicidadesDaColunaDoMeio().get(i).findElement(By.className("publicidade-container")).findElement(By.tagName("p")).findElement(By.tagName("a")).getAttribute("target").equals("_blank")){
				return false;
			}
		}
		return true;
	}
}