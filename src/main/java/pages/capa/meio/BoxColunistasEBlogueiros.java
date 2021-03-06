package pages.capa.meio;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import crops.CropsCapaColunaDoMeio;

import br.com.infoglobo.pages.AceitacaoAbstractTest;
import br.com.infoglobo.pages.Navegador;

public class BoxColunistasEBlogueiros extends AceitacaoAbstractTest {
	
	public BoxColunistasEBlogueiros() throws Exception{
		super();
	}
	
	public BoxColunistasEBlogueiros(Navegador navegador) throws Exception{
		super(navegador);
	}

	public WebElement exibiuBoxDeColunistas() {
		return getDriver().findElement(By.className("colunistas"));
	}

	public boolean exibiuTituloDoBox() {
		return !exibiuBoxDeColunistas().findElement(By.className("editoria")).getText().isEmpty();
	}

	public List<WebElement> listaDeColunistas() {
		return exibiuBoxDeColunistas().findElement(By.className("lista-blogs")).findElements(By.tagName("li"));
	}
	
	public boolean exibiuListaValida() {
		return listaDeColunistas().size()>0;
	}

	public boolean exibiuImagemParaCadaItemDaLista() {
		for(int i=0;i<listaDeColunistas().size();i++){
			if(!listaDeColunistas().get(i).findElement(By.className("left")).findElement(By.tagName("img")).isDisplayed()){
				return false;
			}
		}
		return true;
	}
	
	public boolean exibiuWidthCorretoParaAImagem() {
		for(int i=0;i<listaDeColunistas().size();i++){
			if(!listaDeColunistas().get(i).findElement(By.className("left")).findElement(By.tagName("img")).getAttribute("width").equals(CropsCapaColunaDoMeio.boxColunistas.getWidth())){
				return false;
			}
		}
		return true;
	}
	
	public boolean exibiuHeightCorretoParaAImagem() {
		for(int i=0;i<listaDeColunistas().size();i++){
			if(!listaDeColunistas().get(i).findElement(By.className("left")).findElement(By.tagName("img")).getAttribute("height").equals(CropsCapaColunaDoMeio.boxColunistas.getHeight())){
				return false;
			}
		}
		return true;
	}
	
	public boolean exibiuCropCorretoParaAImagem() {
		for(int i=0;i<listaDeColunistas().size();i++){
			String imagemNaPosicaoAtual = listaDeColunistas().get(i).findElement(By.className("left")).findElement(By.tagName("img")).getAttribute("src").toString();
			if(!(imagemNaPosicaoAtual.contains(CropsCapaColunaDoMeio.boxColunistas.cropProporcional()))){
				return false;
			}
		}
		return true;
	}

	public boolean exibiuLinkNasImagens() {
		for(int i=0;i<listaDeColunistas().size();i++){
			if(!listaDeColunistas().get(i).findElements(By.tagName("a")).get(0).getAttribute("class").equals("left")){
				return false;
			}
		}
		return true;
	}

	public boolean exibiuLinkValidoNasImagens() {
		for(int i=0;i<listaDeColunistas().size();i++){
			if(listaDeColunistas().get(i).findElements(By.tagName("a")).get(0).getAttribute("href").isEmpty()){
				return false;
			}
		}
		return true;
	}

	public boolean exibiuWidthCorretoParaAsImagens() {
		for(int i=0;i<listaDeColunistas().size();i++){
			if(!listaDeColunistas().get(i).findElement(By.className("left")).findElement(By.tagName("img")).getAttribute("width").equals("100")){
				return false;
			}
		}
		return true;
	}

	public boolean exibiuHeightCorretoParaAsImagens() {
		for(int i=0;i<listaDeColunistas().size();i++){
			if(!listaDeColunistas().get(i).findElement(By.className("left")).findElement(By.tagName("img")).getAttribute("height").equals("100")){
				return false;
			}
		}
		return true;
	}
	
	public boolean exibiuAntiTituloComLink() {
		for(int i=0;i<listaDeColunistas().size();i++){
			if(!listaDeColunistas().get(i).findElements(By.tagName("a")).get(1).findElement(By.className("nome-blog")).isDisplayed()){
				return false;
			}
		}
		return true;
	}
	
	public boolean exibiuTituloComLink() {
		for(int i=0;i<listaDeColunistas().size();i++){
			if(!listaDeColunistas().get(i).findElements(By.tagName("a")).get(1).findElement(By.className("titulo-post")).isDisplayed()){
				return false;
			}
		}
		return true;
	}
	
	public boolean exibiuDescricaoComLink() {
		for(int i=0;i<listaDeColunistas().size();i++){
			if(!listaDeColunistas().get(i).findElements(By.tagName("a")).get(1).findElement(By.className("resume-post")).isDisplayed()){
				return false;
			}
		}
		return true;
	}

	public boolean exibiuAntiTitulos() {
		for(int i=0;i<listaDeColunistas().size();i++){
			if(listaDeColunistas().get(i).findElement(By.className("right")).findElement(By.className("nome-blog")).getText().isEmpty()){
				return false;
			}
		}
		return true;
	}

	public boolean exibiuAntiTitulosCom30Caracteres() {
		for(int i=0;i<listaDeColunistas().size();i++){
			if(listaDeColunistas().get(i).findElement(By.className("right")).findElement(By.className("nome-blog")).getText().length() > 33){
				return false;
			}
		}
		return true;
	}

	public boolean exibiuTitulos() {
		for(int i=0;i<listaDeColunistas().size();i++){
			if(listaDeColunistas().get(i).findElement(By.className("right")).findElement(By.className("titulo-post")).getText().isEmpty()){
				return false;
			}
		}
		return true;
	}

	public boolean exibiuAntititulosCom50Caracteres() {
		for(int i=0;i<listaDeColunistas().size();i++){
			if(listaDeColunistas().get(i).findElement(By.className("right")).findElement(By.className("titulo-post")).getText().length() > 53){
				return false;
			}
		}
		return true;
	}

	public boolean exibiuSubTitulos() {
		for(int i=0;i<listaDeColunistas().size();i++){
			if(listaDeColunistas().get(i).findElement(By.className("right")).findElement(By.className("resume-post")).getText().isEmpty()){
				return false;
			}
		}
		return true;
	}

	public boolean exibiuSubTituloCom93Caracteres() {
		for(int i=0;i<listaDeColunistas().size();i++){
			if(listaDeColunistas().get(i).findElement(By.className("right")).findElement(By.className("titulo-post")).getText().length() > 93){
				return false;
			}
		}
		return true;
	}
	
}
