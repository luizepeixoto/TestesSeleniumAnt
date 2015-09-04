package pages.enquete;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import br.com.infoglobo.pages.AceitacaoAbstractTest;
import br.com.infoglobo.pages.Navegador;

public class EnqueteSuperPaginaGeral extends AceitacaoAbstractTest {
	
	public EnqueteSuperPaginaGeral() throws Exception {
		super();
	}
	
	public EnqueteSuperPaginaGeral(Navegador navegador) throws Exception {
		super(navegador);
	}
	
	public WebElement exibiuClassePollHeader() {
		return getDriver().findElement(By.className("poll-header"));
	}
	
	public WebElement exibiuMenuDeEnquetesDisponiveis() {
		return exibiuClassePollHeader().findElement(By.tagName("nav"));
	}

	public List<WebElement> listaDeOpcaoDeEnquetes() {
		return exibiuMenuDeEnquetesDisponiveis().findElements(By.tagName("li"));
	}
	
	public boolean exibiuMaisDeUmaOpcaoParaAsEnquetes() {
		return listaDeOpcaoDeEnquetes().size() > 1;
	}

	public boolean exibiuUmTituloParaCadaUmaEnquetesDisponiveis() {
		for(int i=0; i<listaDeOpcaoDeEnquetes().size(); i++){
			if(listaDeOpcaoDeEnquetes().get(i).findElement(By.tagName("a")).getText().isEmpty()){
				return false;
			}
		}
		return true;
	}

	public boolean exibiuUmLinkEmCadaUmDosTituloDasEnquetesDisponiveis() {
		for(int i=0; i<listaDeOpcaoDeEnquetes().size(); i++){
			if(!listaDeOpcaoDeEnquetes().get(i).findElement(By.tagName("a")).isDisplayed()){
				return false;
			}
		}
		return true;
	}

	public boolean exibiuBusca() {
		return exibiuClassePollHeader().findElement(By.className("search")).isDisplayed();
	}

	public boolean exibiuTituloDaEnquete() {
		return !exibiuClassePollHeader().findElement(By.className("title")).getText().isEmpty();
	}
	
	public List<WebElement> listaDeOpcoesDeVotoDeCadaEnquete() {
		return getDriver().findElement(By.className("candidatos")).findElements(By.tagName("li"));
	}
	
	public boolean exibiuListaDeOpcoes() {
		return listaDeOpcoesDeVotoDeCadaEnquete().size() > 1;
	}

	public boolean exibiuAsOpcoesDeVotoComUmaImagem() {
		for(int i=0; i<listaDeOpcoesDeVotoDeCadaEnquete().size(); i++){
			if(!listaDeOpcoesDeVotoDeCadaEnquete().get(i).findElement(By.className("inner")).findElement(By.className("img")).findElement(By.tagName("img")).isDisplayed()){
				return false;
			}
		}
		return true;
	}

	public boolean exibiuAsFlagDeVotadoEmAlgumaFoto() {
		for(int i=0; i<listaDeOpcoesDeVotoDeCadaEnquete().size(); i++){
			List <WebElement> possuiFlagDeVotado = listaDeOpcoesDeVotoDeCadaEnquete().get(i).findElement(By.className("inner")).findElement(By.className("img")).findElements(By.tagName("span"));
			if(possuiFlagDeVotado.size() > 0){
				return false;
			}
		}
		return true;
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

	public boolean exibiuAsOpcoesDeVotoComUmaDescricao() {
		for(int i=0; i<listaDeOpcoesDeVotoDeCadaEnquete().size(); i++){
			if(listaDeOpcoesDeVotoDeCadaEnquete().get(i).findElement(By.className("inner")).findElement(By.className("desc")).getText().isEmpty()){
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
			if(!listaDeOpcoesDeVotoDeCadaEnquete().get(i).findElement(By.className("inner")).findElement(By.className("vote-btn")).findElement(By.tagName("a")).getText().equals("Votar")){
				return false;
			}
		}
		return true;
	}

}
