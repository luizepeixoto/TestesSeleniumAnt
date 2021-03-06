package pages.capa.meio;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import crops.CropsCapaColunaDoMeio;

import br.com.infoglobo.pages.AceitacaoAbstractTest;

public class CapaMeioMancheteHorizontal extends AceitacaoAbstractTest {
	
	public CapaMeioMancheteHorizontal() throws Exception {
		super();
	}
	
	public List<WebElement> listaDePrincipais(){
		return getDriver().findElement(By.className("main-home")).findElements(By.className("lista-materias"));
	}
	
	//Início Manchete Horizontal - Duas colunas e três destaques abaixo
	//	- Só pode ter foto na manchete e é opcional.
	//	- Se a manchete tiver foto, a mesma só pode ser horizontal.
	//	- Limitar o título da manchete em duas linhas, até 56 caracteres.
	//	- Limitar o título dos destaque em quatro linhas, até 56 caracteres.
	
	public WebElement exibiuMancheteHorizontal(){
		return listaDePrincipais().get(1);
	}

	public boolean exibiuEditoriaDaMancheteHorizontal() {
		return !exibiuMancheteHorizontal().findElement(By.className("editoria")).getText().isEmpty();
	}
	
	public WebElement getBoxMancheteHorizontalSuperior(){
		return listaDePrincipais().get(1).findElement(By.className("superior"));
	}
	
	public WebElement getBoxMancheteHorizontalInferior(){
		return listaDePrincipais().get(1).findElement(By.className("inferior"));
	}
	
	public boolean exibiuLinkNaImagemDaMancheteHorizontal() {
		List<WebElement> exibiuFoto = exibiuMancheteHorizontal().findElement(By.className("destaque")).findElements(By.tagName("img"));
		if(exibiuFoto.size()>0){
			if(exibiuMancheteHorizontal().findElement(By.className("destaque")).findElement(By.tagName("a")).isDisplayed()){
				return true;
			}
		}
		return false;
	}
	
	public boolean exibiuLinkValidoNaImagemDaMancheteHorizontal() {
		List<WebElement> exibiuFoto = exibiuMancheteHorizontal().findElement(By.className("destaque")).findElements(By.tagName("img"));
		if(exibiuFoto.size()>0){
			if(exibiuMancheteHorizontal().findElement(By.className("destaque")).findElement(By.tagName("a")).getAttribute("href").isEmpty()){
				return false;
			}
		}
		return true;
	}
	
	public boolean exibiuLinkAnimadoNaImagemDaMancheteHorizontal() {
		List<WebElement> exibiuFoto = exibiuMancheteHorizontal().findElement(By.className("destaque")).findElements(By.tagName("img"));
		if(exibiuFoto.size()>0){
			if(!exibiuMancheteHorizontal().findElement(By.className("destaque")).findElement(By.tagName("a")).getAttribute("class").contains("animado-scale")){
				return false;
			}
		}
		return true;
	}
	
	public boolean exibiuImagemNaMancheteHorizontal() {
		List<WebElement> exibiuFoto = exibiuMancheteHorizontal().findElement(By.className("destaque")).findElements(By.tagName("img"));
		if(exibiuFoto.size()>0){
			if(exibiuMancheteHorizontal().findElement(By.className("destaque")).findElement(By.tagName("img")).isDisplayed()){
				return true;
			}
		}
		return false;
	}
	
	public boolean exibiuOCropCorretoParaAImagemHorizontal() {
		return exibiuMancheteHorizontal().findElement(By.className("destaque")).findElement(By.tagName("img")).getAttribute("src").contains(CropsCapaColunaDoMeio.boxMancheteHorizontal.cropProporcional());
	}

	public boolean exibiuImagemComWidthCorreto() {
		return exibiuMancheteHorizontal().findElement(By.className("destaque")).findElement(By.tagName("img")).getAttribute("width").equals(CropsCapaColunaDoMeio.boxMancheteHorizontal.getWidth());
	}

	public boolean exibiuImagemComHeightCorreto() {
		return exibiuMancheteHorizontal().findElement(By.className("destaque")).findElement(By.tagName("img")).getAttribute("height").equals(CropsCapaColunaDoMeio.boxMancheteHorizontal.getHeight());
	}

	public boolean getMancheteHorizontalSubEditoria() {
		List<WebElement> exibiuEditoria = exibiuMancheteHorizontal().findElement(By.className("destaque")).findElements(By.tagName("h2"));
		if(exibiuEditoria.size()>0){
			if(exibiuMancheteHorizontal().findElement(By.className("destaque")).findElement(By.tagName("h2")).getText().isEmpty()){
				return false;
			}
		}
		return true;
	}
	
	public WebElement acessaTituloDoBox() {
		return exibiuMancheteHorizontal().findElement(By.className("destaque")).findElement(By.tagName("h3")).findElement(By.tagName("a"));
	}
	
	public boolean getMancheteHorizontalTitulo() {
		return !acessaTituloDoBox().getText().isEmpty();
	}
	
	public boolean exibiuTituloMancheteHorizontalComMaximoDeCaracteres() {
		return !(acessaTituloDoBox().getText().length()>59);
	}
	
	public boolean getMancheteHorizontalTituloLink() {
		return acessaTituloDoBox().isDisplayed();
	}

	public boolean getMancheteHorizontalTituloLinkValido() {
		return !acessaTituloDoBox().getAttribute("href").isEmpty();
	}

	public boolean getMancheteHorizontalComentarios() {
		List<WebElement> resultadoEsperado = exibiuMancheteHorizontal().findElement(By.className("destaque")).findElements(By.className("comments"));
		if(resultadoEsperado.size()>0){
			if(exibiuMancheteHorizontal().findElement(By.className("destaque")).findElement(By.className("comments")).getText().isEmpty()){
				return false;
			}
			return true;
		}
		return true;
	}

	public boolean getMancheteHorizontalComentariosLink() {
		List<WebElement> resultadoEsperado = exibiuMancheteHorizontal().findElement(By.className("destaque")).findElement(By.tagName("h3")).findElements(By.tagName("a"));
		if(resultadoEsperado.size()>0){
			if(!resultadoEsperado.get(1).isDisplayed()){
				return false;
			}
		}
		return true;
	}

	public boolean getMancheteHorizontalComentariosLinkValido() {
		List<WebElement> resultadoEsperado = exibiuMancheteHorizontal().findElement(By.className("destaque")).findElement(By.tagName("h3")).findElements(By.tagName("a"));
		if(resultadoEsperado.size()>0){
			if(resultadoEsperado.get(1).getAttribute("href").isEmpty()){
				return false;
			}
		}
		return true;
	}
	
	public List<WebElement> getMancheteHorizontalBoxInferiorLista() {
		return exibiuMancheteHorizontal().findElement(By.className("inferior")).findElements(By.className("materia"));
	}

	public boolean getMancheteHorizontalBoxInferiorTamanho() {
		if(getMancheteHorizontalBoxInferiorLista().size() > 0){
			return true;
		}else{
			return false;
		}
	}

	public boolean getMancheteHorizontalBoxInferiorEditoria() {
		for(int i=0;i<getMancheteHorizontalBoxInferiorLista().size();i++){
			if(getMancheteHorizontalBoxInferiorLista().get(i).findElement(By.tagName("h2")).getText().isEmpty()){
				return false;
			}
		}
		return true;
	}

	public boolean getMancheteHorizontalBoxInferiorTitulo() {
		for(int i=0;i<getMancheteHorizontalBoxInferiorLista().size();i++){
			if(getMancheteHorizontalBoxInferiorLista().get(i).findElement(By.tagName("h3")).findElements(By.tagName("a")).get(0).getText().isEmpty()){
				return false;
			}
		}
		return true;
	}
	
	public boolean exibiuTotalMaximoDeCaracteres() {
		for(int i=0;i<getMancheteHorizontalBoxInferiorLista().size();i++){
			if(getMancheteHorizontalBoxInferiorLista().get(i).findElement(By.tagName("h3")).findElements(By.tagName("a")).get(0).getText().length()>58){
				return false;
			}
		}
		return true;
	}
	
	public boolean getMancheteHorizontalBoxInferiorTituloLink() {
		for(int i=0;i<getMancheteHorizontalBoxInferiorLista().size();i++){
			if(!getMancheteHorizontalBoxInferiorLista().get(i).findElement(By.tagName("h3")).findElements(By.tagName("a")).get(0).isDisplayed()){
				return false;
			}
		}
		return true;
	}

	public boolean getMancheteHorizontalBoxInferiorTituloLinkValido() {
		for(int i=0;i<getMancheteHorizontalBoxInferiorLista().size();i++){
			if(getMancheteHorizontalBoxInferiorLista().get(i).findElement(By.tagName("h3")).findElements(By.tagName("a")).get(0).getAttribute("href").isEmpty()){
				return false;
			}
		}
		return true;
	}

	public boolean getMancheteHorizontalBoxInferiorComentario() {
		for(int i=0;i<getMancheteHorizontalBoxInferiorLista().size();i++){
			List<WebElement> resultadoEsperado = getMancheteHorizontalBoxInferiorLista().get(i).findElement(By.tagName("h3")).findElements(By.tagName("a"));
			if(resultadoEsperado.size()>1){
				if(resultadoEsperado.get(1).getText().isEmpty()){
					return false;
				}
			}
		}
		return true;
	}

	public boolean getMancheteHorizontalBoxInferiorComentarioLink() {
		for(int i=0;i<getMancheteHorizontalBoxInferiorLista().size();i++){
			List<WebElement> resultadoEsperado = getMancheteHorizontalBoxInferiorLista().get(i).findElement(By.tagName("h3")).findElements(By.tagName("a"));
			if(resultadoEsperado.size()>1){
				if(!resultadoEsperado.get(1).isDisplayed()){
					return false;
				}
			}
		}
		return true;
	}

	public boolean getMancheteHorizontalBoxInferiorComentarioLinkValido() {
		for(int i=0;i<getMancheteHorizontalBoxInferiorLista().size();i++){
			List<WebElement> resultadoEsperado = getMancheteHorizontalBoxInferiorLista().get(i).findElement(By.tagName("h3")).findElements(By.tagName("a"));
			if(resultadoEsperado.size()>1){
				if(resultadoEsperado.get(1).getAttribute("href").isEmpty()){
					return false;
				}
			}
		}
		return true;
	}
	//Fim Manchete Horizontal - Duas colunas e três destaques abaixo
}