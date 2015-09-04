package pages.capa.esquerda;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import br.com.infoglobo.pages.AceitacaoAbstractTest;

public class ChamadaEspecial extends AceitacaoAbstractTest {
	
		//		- Chamada Especial com os seguintes conteúdos:
		//			*Matéria com foto (Especial), titulo, autor, descrição e total de comentários
		//		- Duas ou mais chamadas secundárias com:
		//			*Foto, título, descrição e total de comentários
		//		- Dois ou mais box de opinião com:
		//			* Foto, titulo do box, Autor e descrição
		//		- Duas ou mais webchamadas de links com:
		//			*Titulo e total de comentários
	
	public ChamadaEspecial() throws Exception {
		super();
	}
	
	public WebElement getBoxChamadaEspecial(){
		return getDriver().findElement(By.className("col-left")).findElement(By.className("materia-especial"));
	}

	public boolean exibiuOTitulo() {
		return !getBoxChamadaEspecial().findElement(By.tagName("h2")).getText().isEmpty();
	}

	public boolean exibiuImagem() {
		return getBoxChamadaEspecial().findElement(By.tagName("img")).isDisplayed();
	}

	public String getImagemWidth() {
		return getBoxChamadaEspecial().findElement(By.tagName("img")).getAttribute("width");
	}

	public String getImagemHeight() {
		return getBoxChamadaEspecial().findElement(By.tagName("img")).getAttribute("height");
	}
	
	public WebElement descricaoMateria() {
		return getBoxChamadaEspecial().findElement(By.tagName("div"));
	}
	
	public boolean exibiuTitulo() {
		return !descricaoMateria().findElement(By.tagName("h3")).getText().isEmpty();
	}

	public boolean exibiuTituloComLink() {
		return descricaoMateria().findElement(By.tagName("h3")).findElement(By.tagName("a")).isDisplayed();
	}

	public boolean exibiuTituloComLinkValido() {
		return !descricaoMateria().findElement(By.tagName("h3")).findElement(By.tagName("a")).getAttribute("href").isEmpty();
	}

	public boolean exibiuAutor() {
		return !descricaoMateria().findElement(By.tagName("span")).findElement(By.tagName("b")).getText().isEmpty();
	}

	public boolean exibiuDescricao() {
		return !descricaoMateria().findElement(By.tagName("span")).getText().isEmpty();
	}

	public boolean exibiuComentarios() {
		return !descricaoMateria().findElement(By.className("comments")).getText().isEmpty();
	}

	public boolean exibiuComentariosComLink() {
		return descricaoMateria().findElement(By.tagName("span")).findElement(By.tagName("a")).isDisplayed();
	}
	
	public WebElement chamadasSecundarias() {
		return getBoxChamadaEspecial().findElement(By.className("materia-relacionada"));
	}
	
	public List<WebElement> listaDeMateriasDentroDaChamadaSecundaria() {
		return chamadasSecundarias().findElements(By.className("clearfix"));
	}
	
	public List<WebElement> listaDeFotosDentroDaChamadaSecundaria() {
		return chamadasSecundarias().findElements(By.className("animado-opacity"));
	}
	
	public boolean exibiuChamadasSecundarias() {
		return listaDeMateriasDentroDaChamadaSecundaria().size() > 0;
	}

	public boolean exibiuFotosParaAsChamadasSecundarias() {
		for(int i=0; i<listaDeMateriasDentroDaChamadaSecundaria().size();i++){
			if(!listaDeFotosDentroDaChamadaSecundaria().get(i).findElement(By.tagName("img")).isDisplayed()){
				return false;
			}
		}
		return true;
	}
	
	public boolean exibiuLinkNasFotosDasChamadasSecundarias() {
		for(int i=0; i<listaDeMateriasDentroDaChamadaSecundaria().size();i++){
			if(listaDeFotosDentroDaChamadaSecundaria().get(i).getAttribute("href").isEmpty()){
				return false;
			}
		}
		return true;
	}
	
	public boolean exibiuTitulosParaAsChamadasSecundarias() {
		for(int i=0; i<listaDeMateriasDentroDaChamadaSecundaria().size();i++){
			if(listaDeMateriasDentroDaChamadaSecundaria().get(i).findElement(By.tagName("h3")).getText().isEmpty()){
				return false;
			}
		}
		return true;
	}
	
	public boolean exibiuTitulosParaAsChamadasSecundariasComLinks() {
		for(int i=0; i<listaDeMateriasDentroDaChamadaSecundaria().size();i++){
			if(!listaDeMateriasDentroDaChamadaSecundaria().get(i).findElement(By.tagName("h3")).findElement(By.tagName("a")).isDisplayed()){
				return false;
			}
		}
		return true;
	}
	
	public boolean exibiuTitulosParaAsChamadasSecundariasComUmLinkValido() {
		for(int i=0; i<listaDeMateriasDentroDaChamadaSecundaria().size();i++){
			if(listaDeMateriasDentroDaChamadaSecundaria().get(i).findElement(By.tagName("h3")).findElement(By.tagName("a")).getAttribute("href").isEmpty()){
				return false;
			}
		}
		return true;
	}
	
	public boolean exibiuDescricaoParaAsChamadasSecundarias() {
		for(int i=0; i<listaDeMateriasDentroDaChamadaSecundaria().size();i++){
			if(listaDeMateriasDentroDaChamadaSecundaria().get(i).findElement(By.tagName("span")).getText().isEmpty()){
				return false;
			}
		}
		return true;
	}

	public boolean exibiuComentariosParaAsChamadasSecundarias() {
		for(int i=0; i<listaDeMateriasDentroDaChamadaSecundaria().size();i++){
			if(listaDeMateriasDentroDaChamadaSecundaria().get(i).findElement(By.tagName("span")).findElement(By.className("comments")).getText().isEmpty()){
				return false;
			}
		}
		return true;
	}

	public boolean exibiuLinkNosComentariosDasChamadasSecundarias() {
		for(int i=0; i<listaDeMateriasDentroDaChamadaSecundaria().size();i++){
			if(!listaDeMateriasDentroDaChamadaSecundaria().get(i).findElement(By.tagName("span")).findElement(By.tagName("a")).isDisplayed()){
				return false;
			}
		}
		return true;
	}
	
	public WebElement chamadasDeOpiniao() {
		return getBoxChamadaEspecial().findElement(By.className("web-chamada"));
	}
	
	public List<WebElement> listaDeBoxesDeOpiniao() {
		return chamadasDeOpiniao().findElements(By.tagName("div"));
	}
	
	public boolean exibiuBoxDeOpiniao() {
		return listaDeBoxesDeOpiniao().size() > 0;
	}

	public boolean exibiuImagemNoBoxDeOpiniao() {
		for(int i=0; i<listaDeBoxesDeOpiniao().size(); i++){
			if(!listaDeBoxesDeOpiniao().get(i).findElement(By.tagName("img")).isDisplayed()){
				return false;
			}
		}
		return true;
	}

	public boolean getBoxDeOpiniaoImagemWidth() {
		for(int i=0; i<listaDeBoxesDeOpiniao().size(); i++){
			if(!listaDeBoxesDeOpiniao().get(i).findElement(By.tagName("img")).getAttribute("width").equals("60")){
				return false;
			}
		}
		return true;
	}

	public boolean getBoxDeOpiniaoImagemHeight() {
		for(int i=0; i<listaDeBoxesDeOpiniao().size(); i++){
			if(!listaDeBoxesDeOpiniao().get(i).findElement(By.tagName("img")).getAttribute("height").equals("60")){
				return false;
			}
		}
		return true;
	}

	public boolean exibiuTituloDoBoxDeOpiniao() {
		for(int i=0; i<listaDeBoxesDeOpiniao().size(); i++){
			if(listaDeBoxesDeOpiniao().get(i).findElement(By.tagName("h4")).getText().isEmpty()){
				return false;
			}
		}
		return true;
	}

	public boolean exibiuAutorDoBoxDeOpiniao() {
		for(int i=0; i<listaDeBoxesDeOpiniao().size(); i++){
			if(listaDeBoxesDeOpiniao().get(i).findElement(By.tagName("h5")).getText().isEmpty()){
				return false;
			}
		}
		return true;
	}

	public boolean exibiuDescricaoDoBoxDeOpiniao() {
		for(int i=0; i<listaDeBoxesDeOpiniao().size(); i++){
			if(listaDeBoxesDeOpiniao().get(i).findElement(By.tagName("span")).getText().isEmpty()){
				return false;
			}
		}
		return true;
	}

	public boolean exibiuMaximoDeCaracteresDaDescricaoDoBoxDeOpiniao() {
		for(int i=0; i<listaDeBoxesDeOpiniao().size(); i++){
			if(listaDeBoxesDeOpiniao().get(i).findElement(By.tagName("span")).getText().length() > 44){
				return false;
			}
		}
		return true;
	}
	
	public WebElement webChamadasLinks() {
		return getBoxChamadaEspecial().findElement(By.className("manchetes-secundarias"));
	}
	
	public List<WebElement> listaDeWebChamadasLinks() {
		return webChamadasLinks().findElements(By.tagName("li"));
	}
	
	public boolean exibiuLinkDeWebchamada() {
		return listaDeWebChamadasLinks().size() >0;
	}

	public boolean exibiuTituloDosLinkDeWebchamada() {
		for(int i=0; i<listaDeWebChamadasLinks().size(); i++){
			if(listaDeWebChamadasLinks().get(i).findElements(By.tagName("a")).get(0).getText().isEmpty()){
				return false;
			}
		}
		return true;
	}

	public boolean exibiuTituloDosLinkDeWebchamadaComUmLink() {
		for(int i=0; i<listaDeWebChamadasLinks().size(); i++){
			if(!listaDeWebChamadasLinks().get(i).findElements(By.tagName("a")).get(0).isDisplayed()){
				return false;
			}
		}
		return true;
	}

	public boolean exibiuTituloDosLinkDeWebchamadaComLinksvalidos() {
		for(int i=0; i<listaDeWebChamadasLinks().size(); i++){
			if(listaDeWebChamadasLinks().get(i).findElements(By.tagName("a")).get(0).getAttribute("href").isEmpty()){
				return false;
			}
		}
		return true;
	}

	public boolean exibiuTotalDeComentariosDosLinksDeWebchamadas() {
		for(int i=0; i<listaDeWebChamadasLinks().size(); i++){
			if(listaDeWebChamadasLinks().get(i).findElements(By.tagName("a")).get(1).getText().isEmpty()){
				return false;
			}
		}
		return true;
	}

	public boolean exibiuTotalDeComentariosDosLinksDeWebchamadasComUmLink() {
		for(int i=0; i<listaDeWebChamadasLinks().size(); i++){
			if(!listaDeWebChamadasLinks().get(i).findElements(By.tagName("a")).get(1).isDisplayed()){
				return false;
			}
		}
		return true;
	}

	
}
