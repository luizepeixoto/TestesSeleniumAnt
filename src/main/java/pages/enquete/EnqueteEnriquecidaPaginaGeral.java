package pages.enquete;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import br.com.infoglobo.pages.AceitacaoAbstractTest;
import br.com.infoglobo.pages.Navegador;

public class EnqueteEnriquecidaPaginaGeral extends AceitacaoAbstractTest {
	
	public EnqueteEnriquecidaPaginaGeral() throws Exception {
		super();
	}
	
	public EnqueteEnriquecidaPaginaGeral(Navegador navegador) throws Exception {
		super(navegador);
	}
	
	public WebElement exibiuClassePollHeader() {
		return getDriver().findElement(By.className("poll-header"));
	}
	
	public WebElement exibiuSuperLeaderboard() {
		return getDriver().findElement(By.className("super-leaderboard")).findElement(By.tagName("script"));
	}
	
	public boolean exibiuBusca() {
		return getDriver().findElement(By.xpath("//div[@class='poll-search']")).isDisplayed();
	}

	public boolean exibiuTituloDaEnquete() {
		return !getDriver().findElement(By.xpath("//div[@class='poll-header clearfix']/p")).getText().isEmpty();
	}
	
	public WebElement exibiuBannerArroba() {
		return getDriver().findElement(By.className("arroba")).findElement(By.tagName("script"));
	}
	
	public boolean exibiuSubtituloDaEnquete() {
		return !getDriver().findElement(By.className("enquete-angular")).findElement(By.tagName("h2")).getText().isEmpty();
	}
	
	public List<WebElement> listaDeOpcoesDeVotoDeCadaEnquete() {
		return getDriver().findElement(By.className("candidatos")).findElements(By.tagName("li"));
	}
	
	public boolean exibiuListaDeOpcoes() {
		return listaDeOpcoesDeVotoDeCadaEnquete().size() > 1;
	}

	public boolean exibiuAsOpcoesDeVotoComUmTitulo() {
		for(int i=0; i<listaDeOpcoesDeVotoDeCadaEnquete().size(); i++){
			if(listaDeOpcoesDeVotoDeCadaEnquete().get(i).findElement(By.className("inner")).findElement(By.tagName("h2")).getText().isEmpty()){
				return false;
			}
		}
		return true;
	}

	public boolean exibiuAsOpcoesDeVotoComUmSubtitulo() {
		for(int i=0; i<listaDeOpcoesDeVotoDeCadaEnquete().size(); i++){
			if(listaDeOpcoesDeVotoDeCadaEnquete().get(i).findElement(By.className("inner")).findElement(By.className("sub")).getText().isEmpty()){
				return false;
			}
		}
		return true;
	}

	public boolean exibiuOBotaoDeVotarEmCadaUmaDasOpcoes() {
		for(int i=0; i<listaDeOpcoesDeVotoDeCadaEnquete().size(); i++){
			if(!listaDeOpcoesDeVotoDeCadaEnquete().get(i).findElement(By.className("inner")).findElement(By.className("vote-btn")).isDisplayed()){
				return false;
			}
		}
		return true;
	}
	
	public boolean exibiuOBotaoDeVotarComUmLink() {
		for(int i=0; i<listaDeOpcoesDeVotoDeCadaEnquete().size(); i++){
			if(!listaDeOpcoesDeVotoDeCadaEnquete().get(i).findElement(By.className("inner")).findElement(By.className("vote-btn")).findElement(By.tagName("a")).isDisplayed()){
				return false;
			}
		}
		return true;
	}
	
	public boolean exibiuOTituloVotar() {
		for(int i=0; i<listaDeOpcoesDeVotoDeCadaEnquete().size(); i++){
			if(!listaDeOpcoesDeVotoDeCadaEnquete().get(i).findElement(By.className("inner")).findElement(By.className("vote-btn")).findElement(By.tagName("a")).getText().equals("VOTAR")){
				return false;
			}
		}
		return true;
	}

}
