package pages.capa.meio;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import br.com.infoglobo.pages.AceitacaoAbstractTest;

public class BoxOpiniao extends AceitacaoAbstractTest {
	
	public BoxOpiniao() throws Exception {
		super();
	}
	
	public WebElement exibiuOBoxDeOpiniaoDoGlobo() {
		return getDriver().findElement(By.className("main-home")).findElement(By.className("opiniao"));
	}

	public boolean exibiuOTituloOpiniaoDoGlobo() {
		return !exibiuOBoxDeOpiniaoDoGlobo().findElement(By.tagName("p")).getText().isEmpty();
	}

	public boolean exibiuUmLinkParaOTituloDeOpinioes() {
		return exibiuOBoxDeOpiniaoDoGlobo().findElement(By.tagName("a")).isDisplayed();
	}

	public boolean oLinkNoTituloDeOpinioesEstaCorreto() {
		return !exibiuOBoxDeOpiniaoDoGlobo().findElement(By.tagName("a")).getAttribute("href").isEmpty();
	}
	
	public List<WebElement> listaDeOpinioes() {
		return exibiuOBoxDeOpiniaoDoGlobo().findElements(By.tagName("li"));
	}
	
	public boolean exibiuAsOpinioes() {
		if(listaDeOpinioes().size() == 3){
			return true;
		}
		return false;
	}

	public boolean exibiuOLinkNasOpinioes() {
		for(int i=0;i<listaDeOpinioes().size();i++){
			if(!listaDeOpinioes().get(i).findElement(By.className("texto")).findElement(By.tagName("a")).isDisplayed()){
				return false;
			}
		}
		return true;
	}
	
	public boolean oLinkDaOpiniaoEhValido() {
		for(int i=0;i<listaDeOpinioes().size();i++){
			if(listaDeOpinioes().get(i).findElement(By.className("texto")).findElement(By.tagName("a")).getAttribute("href").isEmpty()){
				return false;
			}
		}
		return true;
	}

	public boolean exibiuOsAntititulosDasOpinioes() {
		for(int i=0;i<listaDeOpinioes().size();i++){
			List<WebElement> possuiAutorNaPosicaoDesejada = listaDeOpinioes().get(i).findElements(By.className("titulo"));
			if(possuiAutorNaPosicaoDesejada.size()>0){
				if(listaDeOpinioes().get(i).findElement(By.className("titulo")).getText().isEmpty()){
					return false;
				}
			}
		}
		return true;
	}

	public boolean exibiuOsTextoDasOpinioes() {
		for(int i=0;i<listaDeOpinioes().size();i++){
			List<WebElement> possuiAutorNaPosicaoDesejada = listaDeOpinioes().get(i).findElements(By.className("texto"));
			if(possuiAutorNaPosicaoDesejada.size()>0){
				if(listaDeOpinioes().get(i).findElement(By.className("texto")).getText().isEmpty()){
					return false;
				}
			}
		}
		return true;
	}

	public boolean exibiuOsAutoresDasOpinioes() {
		for(int i=0;i<listaDeOpinioes().size();i++){
			List<WebElement> possuiAutorNaPosicaoDesejada = listaDeOpinioes().get(i).findElements(By.className("autor"));
			if(possuiAutorNaPosicaoDesejada.size()>0){
				if(listaDeOpinioes().get(i).findElement(By.className("autor")).getText().isEmpty()){
					return false;
				}
			}
		}
		return true;
	}

	public boolean exibiuLinkParaOsAntititulos() {
		List<WebElement> resultadoEsperado = exibiuOBoxDeOpiniaoDoGlobo().findElement(By.className("titulo")).findElements(By.tagName("a"));
		if(resultadoEsperado.size()>0){
			return false;
		}
		return true;
	}
}
