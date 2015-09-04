package pages.capa.meio;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import crops.CropsCapaColunaDoMeio;

import br.com.infoglobo.pages.AceitacaoAbstractTest;

public class BoxEspecial extends AceitacaoAbstractTest {
	
		//Box Especial com os seguintes conteúdos:
		//		- Matéria com foto (Especial), Editoria, titulo, autor, descrição e total de comentários
		//		- Duas ou mais webchamadas de links dentro da matéria principal (subchamada) com:
		//			*Titulo e total de comentários
		//		Como matéria relacionada:	
		// 			- Duas ou mais chamadas secundárias com:
		//				*Foto, título, autor, descrição e total de comentários
		//			- Dois ou mais box de opinião com:
		//				* Foto, titulo do box, Autor e descrição
		//			- Duas ou mais webchamadas de links com:
		//				*Titulo e total de comentários
		
	
	public BoxEspecial() throws Exception {
		super();
	}
	
	public WebElement getBoxChamadaEspecial(){
		return getDriver().findElement(By.className("main-home")).findElement(By.className("box-especial"));
	}

	public boolean exibiuOTitulo() {
		return !getBoxChamadaEspecial().findElement(By.tagName("h2")).getText().isEmpty();
	}
	
	public WebElement exibiuMateriaPrincipal(){
		return getBoxChamadaEspecial().findElement(By.className("materia-principal"));
	}
	
	public boolean exibiuImagem() {
		return exibiuMateriaPrincipal().findElement(By.tagName("img")).isDisplayed();
	}
	
	public boolean exibiuCropCorretoParaImagemPrincipal() {
		return exibiuMateriaPrincipal().findElement(By.tagName("img")).getAttribute("src").contains(CropsCapaColunaDoMeio.boxEspecialChamadaPrincipal.cropProporcional());
	}
	
	public String getImagemWidth() {
		return exibiuMateriaPrincipal().findElement(By.tagName("img")).getAttribute("width");
	}

	public String getImagemHeight() {
		return exibiuMateriaPrincipal().findElement(By.tagName("img")).getAttribute("height");
	}
	
	public WebElement descricaoMateria() {
		return exibiuMateriaPrincipal().findElement(By.tagName("div"));
	}
	
	public boolean exibiuClasseFade() {
		return exibiuMateriaPrincipal().findElement(By.className("fadeToBlack")).isDisplayed();
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
	
	public WebElement exibiuClasseExtra() {
		return getDriver().findElement(By.className("extras"));
	}
	
	public List<WebElement> listaDeSubchamadas() {
		return exibiuClasseExtra().findElement(By.className("subchamada")).findElements(By.tagName("li"));
	}
	
	public boolean exibiuLinkDeWebchamadaDaMateriaPrincipal() {
		return listaDeSubchamadas().size()>0;
	}
	
	public boolean exibiuTituloDasWebchamadaDaMateriaPrincipal() {
		for(int i=0;i<listaDeSubchamadas().size();i++){
			if(listaDeSubchamadas().get(i).getText().isEmpty()){
				return false;
			}
		}
		return true;
	}
	
	public boolean exibiuTituloDasWebchamadaDaMateriaPrincipalComUmLink() {
		for(int i=0;i<listaDeSubchamadas().size();i++){
			if(!listaDeSubchamadas().get(i).findElement(By.tagName("a")).isDisplayed()){
				return false;
			}
		}
		return true;
	}
	
	public boolean exibiuTituloDasWebchamadaDaMateriaPrincipalComLinksValidos() {
		for(int i=0;i<listaDeSubchamadas().size();i++){
			if(listaDeSubchamadas().get(i).findElement(By.tagName("a")).getAttribute("href").isEmpty()){
				return false;
			}
		}
		return true;
	}
	
	public boolean exibiuTotalDeComentariosDasWebchamadasDaMateriaPrincipal() {
		for(int i=0;i<listaDeSubchamadas().size();i++){
			List<WebElement> possuiComentario = listaDeSubchamadas().get(i).findElements(By.className("comments"));
			if(possuiComentario.size() > 0){
				if(listaDeSubchamadas().get(i).findElement(By.className("comments")).getText().isEmpty()){
					return false;
				}
			}
		}
		return true;
	}
	
	public boolean exibiuTotalDeComentariosDasWebchamadasDaMateriaPrincipalComUmLink() {
		for(int i=0;i<listaDeSubchamadas().size();i++){
			List<WebElement> possuiComentario = listaDeSubchamadas().get(i).findElements(By.className("comments"));
			if(possuiComentario.size() > 0){
				if(!listaDeSubchamadas().get(i).findElements(By.tagName("a")).get(1).isDisplayed()){
					return false;
				}
			}
		}
		return true;
	}
	
	public WebElement chamadasSecundarias() {
		return getBoxChamadaEspecial().findElement(By.className("materia-relacionada"));
	}
	
	public List<WebElement> listaDeMateriasDentroDaChamadaSecundaria() {
		return chamadasSecundarias().findElements(By.className("clearfix"));
	}
	
	public List<WebElement> listaDeFotosDentroDaChamadaSecundaria() {
		return chamadasSecundarias().findElements(By.tagName("animado-opacity"));
	}
	
	public boolean exibiuChamadasSecundarias() {
		return listaDeMateriasDentroDaChamadaSecundaria().size() > 0;
	}

	public boolean exibiuFotosParaAsChamadasSecundarias() {
		for(int i=0; i<listaDeFotosDentroDaChamadaSecundaria().size();i++){
			if(!listaDeFotosDentroDaChamadaSecundaria().get(i).findElement(By.tagName("img")).isDisplayed()){
				return false;
			}
		}
		return true;
	}
	
	public boolean exibiuCropParaAsFotosDeChamadasSecundarias() {
		for(int i=0; i<listaDeFotosDentroDaChamadaSecundaria().size();i++){
			if(!listaDeFotosDentroDaChamadaSecundaria().get(i).findElement(By.tagName("img")).getAttribute("src").contains(CropsCapaColunaDoMeio.boxEspecialChamadaSecundaria.cropProporcional())){
				return false;
			}
		}
		return true;
	}
	
	public boolean exibiuOWidthDasFotosDeChamadasSecundarias() {
		for(int i=0; i<listaDeFotosDentroDaChamadaSecundaria().size();i++){
			if(!listaDeFotosDentroDaChamadaSecundaria().get(i).findElement(By.tagName("img")).getAttribute("width").equals(CropsCapaColunaDoMeio.boxEspecialChamadaSecundaria.getWidth())){
				return false;
			}
		}
		return true;
	}
	
	public boolean exibiuOHeightDasFotosDeChamadasSecundarias() {
		for(int i=0; i<listaDeFotosDentroDaChamadaSecundaria().size();i++){
			if(!listaDeFotosDentroDaChamadaSecundaria().get(i).findElement(By.tagName("img")).getAttribute("height").equals(CropsCapaColunaDoMeio.boxEspecialChamadaSecundaria.getHeight())){
				return false;
			}
		}
		return true;
	}
	
	public boolean exibiuLinkNasFotosDasChamadasSecundarias() {
		for(int i=0; i<listaDeFotosDentroDaChamadaSecundaria().size();i++){
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
	
	public boolean exibiuImagemComCropProporcional() {
		for(int i=0; i<listaDeBoxesDeOpiniao().size(); i++){
			if(!listaDeBoxesDeOpiniao().get(i).findElement(By.tagName("img")).getAttribute("src").contains(CropsCapaColunaDoMeio.boxEspecialOpiniao.cropProporcional())){
				return false;
			}
		}
		return true;
	}

	public boolean getBoxDeOpiniaoImagemWidth() {
		for(int i=0; i<listaDeBoxesDeOpiniao().size(); i++){
			if(!listaDeBoxesDeOpiniao().get(i).findElement(By.tagName("img")).getAttribute("width").equals(CropsCapaColunaDoMeio.boxEspecialOpiniao.getWidth())){
				return false;
			}
		}
		return true;
	}

	public boolean getBoxDeOpiniaoImagemHeight() {
		for(int i=0; i<listaDeBoxesDeOpiniao().size(); i++){
			if(!listaDeBoxesDeOpiniao().get(i).findElement(By.tagName("img")).getAttribute("height").equals(CropsCapaColunaDoMeio.boxEspecialOpiniao.getHeight())){
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
	
	public List<WebElement> listaDeExtras(){
		return getBoxChamadaEspecial().findElements(By.className("extras"));
	}
	
	public WebElement webChamadasLinks() {
		return listaDeExtras().get(1);
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
