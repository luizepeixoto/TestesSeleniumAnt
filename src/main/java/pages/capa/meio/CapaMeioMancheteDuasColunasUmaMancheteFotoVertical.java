package pages.capa.meio;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import crops.CropsCapaColunaDoMeio;

import br.com.infoglobo.pages.AceitacaoAbstractTest;

public class CapaMeioMancheteDuasColunasUmaMancheteFotoVertical extends AceitacaoAbstractTest {
	
	public CapaMeioMancheteDuasColunasUmaMancheteFotoVertical() throws Exception {
		super();
	}
	
	//Início Duas Colunas e uma Manchete - Uma coluna com foto vertical e quatro destaques com foto

	public List<WebElement> listaDePrincipais(){
		return getDriver().findElement(By.className("main-home")).findElements(By.className("lista-materias"));
	}
	
	public WebElement getBoxMancheteDuasColunasUmaMancheteComFoto(){
		return listaDePrincipais().get(3);
	}

	public boolean getMancheteDuasColunasUmaMancheteComFotoEditoria() {
		return !getBoxMancheteDuasColunasUmaMancheteComFoto().findElement(By.className("editoria")).getText().isEmpty();
	}
					  	
	public WebElement exibiuColunaDaEsquerda(){
		return getBoxMancheteDuasColunasUmaMancheteComFoto().findElement(By.className("left"));
	}
	
	public WebElement exibiuColunaDaDireita(){
		return getBoxMancheteDuasColunasUmaMancheteComFoto().findElement(By.className("right"));
	}
	
	public boolean exibiuUmLinkNaFotoDestaque() {
		List<WebElement> exibiuImagem = getBoxMancheteDuasColunasUmaMancheteComFoto().findElement(By.className("destaque")).findElements(By.tagName("img"));
		if(exibiuImagem.size()>0){
			if(!getBoxMancheteDuasColunasUmaMancheteComFoto().findElement(By.className("destaque")).findElement(By.tagName("a")).isDisplayed()){
				return false;
			}
		}
		return true;
	}
	
	public boolean exibiuUmLinkValidoNaFotoDestaque() {
		List<WebElement> exibiuImagem = getBoxMancheteDuasColunasUmaMancheteComFoto().findElement(By.className("destaque")).findElements(By.tagName("img"));
		if(exibiuImagem.size()>0){
			if(getBoxMancheteDuasColunasUmaMancheteComFoto().findElement(By.className("destaque")).findElement(By.tagName("a")).getAttribute("href").isEmpty()){
				return false;
			}
		}
		return true;
	}
	
	public boolean exibiuUmLinkAnimadoNaFoto() {
		List<WebElement> exibiuImagem = getBoxMancheteDuasColunasUmaMancheteComFoto().findElement(By.className("destaque")).findElements(By.tagName("img"));
		if(exibiuImagem.size()>0){
			if(!getBoxMancheteDuasColunasUmaMancheteComFoto().findElement(By.className("destaque")).findElement(By.tagName("a")).getAttribute("class").contains("animado-scale")){
				return false;
			}
		}
		return true;
	}
	
	public boolean exibiuFotoNoDestaque() {
		return getBoxMancheteDuasColunasUmaMancheteComFoto().findElement(By.className("destaque")).findElement(By.tagName("img")).isDisplayed();
	}

	public boolean exibiuCropProporcionalCorretoParaAFotoNoDestaque() {
		String urlDaImagemAtual = getBoxMancheteDuasColunasUmaMancheteComFoto().findElement(By.className("destaque")).findElement(By.tagName("img")).getAttribute("src"); 
		return urlDaImagemAtual.contains(CropsCapaColunaDoMeio.boxDuasColunasUmaMancheteVertical.cropProporcional());
	}
	
	public String exibiuWidthDaFotoDestaque() {
		String resultado = "Não Possui Foto";
		List<WebElement> exibiuImagem = getBoxMancheteDuasColunasUmaMancheteComFoto().findElement(By.className("destaque")).findElements(By.tagName("img"));
		if(exibiuImagem.size()>0){
				return getBoxMancheteDuasColunasUmaMancheteComFoto().findElement(By.className("destaque")).findElement(By.tagName("img")).getAttribute("width");
			}
		return resultado;
	}
	
	public String exibiuHeightDaFotoDestaque() {
		String resultado = "Não Possui Foto";
		List<WebElement> exibiuImagem = getBoxMancheteDuasColunasUmaMancheteComFoto().findElement(By.className("destaque")).findElements(By.tagName("img"));
		if(exibiuImagem.size()>0){
				return getBoxMancheteDuasColunasUmaMancheteComFoto().findElement(By.className("destaque")).findElement(By.tagName("img")).getAttribute("height");
			}
		return resultado;
	}

	public boolean exibiuEditoriaDoDestaque() {
		return !getBoxMancheteDuasColunasUmaMancheteComFoto().findElement(By.className("editoria")).findElement(By.tagName("a")).getText().isEmpty();
	}

	public boolean exibiuTituloDoDestaque() {
		return !getBoxMancheteDuasColunasUmaMancheteComFoto().findElement(By.className("destaque")).findElement(By.tagName("h3")).findElement(By.tagName("a")).getText().isEmpty();
	}
	
	public boolean exibiuTituloDoDestaqueComMaximoDe75Caracteres() {
		return getBoxMancheteDuasColunasUmaMancheteComFoto().findElement(By.className("destaque")).findElement(By.tagName("h3")).findElement(By.tagName("a")).getText().length()<75;
	}
	
	public boolean getMancheteDuasColunasUmaMancheteComFotoTituloLink() {
		if(getBoxMancheteDuasColunasUmaMancheteComFoto().findElement(By.className("destaque")).findElement(By.tagName("h3")).findElement(By.tagName("a")).isDisplayed()){
			return true;
		}else{
			return false;
		}
	}

	public boolean getMancheteDuasColunasUmaMancheteComFotoTituloLinkValido() {
		if(getBoxMancheteDuasColunasUmaMancheteComFoto().findElement(By.className("destaque")).findElement(By.tagName("h3")).findElement(By.tagName("a")).getAttribute("href").isEmpty()){
			return false;
		}else{
			return true;
		}
	}

	public boolean getMancheteDuasColunasUmaMancheteComFotoComentarios() {
		List<WebElement> resultadoEsperado = getBoxMancheteDuasColunasUmaMancheteComFoto().findElement(By.className("destaque")).findElements(By.className("comments"));
		if(resultadoEsperado.size()>0){
			if(resultadoEsperado.get(0).getText().isEmpty()){
				return false;
			}
		}
		return true;
	}

	public boolean exibiuComentariosNaEsquerdaComUmLink() {
		List<WebElement> resultadoEsperado = getBoxMancheteDuasColunasUmaMancheteComFoto().findElement(By.className("destaque")).findElements(By.className("comments"));
		if(resultadoEsperado.size()>0){
			if(!getBoxMancheteDuasColunasUmaMancheteComFoto().findElement(By.className("destaque")).findElements(By.tagName("a")).get(1).isDisplayed()){
				return false;
			}
		}
		return true;
	}

	public boolean exibiuComentariosNaEsquerdaComUmLinkValido() {
		List<WebElement> resultadoEsperado = getBoxMancheteDuasColunasUmaMancheteComFoto().findElement(By.className("destaque")).findElements(By.className("comments"));
		if(resultadoEsperado.size()>0){
			if(getBoxMancheteDuasColunasUmaMancheteComFoto().findElement(By.className("destaque")).findElements(By.tagName("a")).get(1).getAttribute("href").isEmpty()){
				return false;
			}
		}
		return true;
	}
	

	public List<WebElement> getMancheteDuasColunasUmaMancheteComFotoBoxDireitaLista() {
		return getBoxMancheteDuasColunasUmaMancheteComFoto().findElement(By.className("right")).findElements(By.className("materia"));
	}

	public boolean getMancheteDuasColunasUmaMancheteComFotoBoxDireitaTamanho() {
		if(getMancheteDuasColunasUmaMancheteComFotoBoxDireitaLista().size() > 0){
			return true;
		}else{
			return false;
		}
	}
	
	public boolean exibiuFotoParaAsMateriasDaDireita() {
		for(int i=0;i<getMancheteDuasColunasUmaMancheteComFotoBoxDireitaLista().size();i++){
			List<WebElement> possuiFotoNaPosicao = getMancheteDuasColunasUmaMancheteComFotoBoxDireitaLista().get(i).findElements(By.tagName("img"));
			if(possuiFotoNaPosicao.size()>0){
				if(!getMancheteDuasColunasUmaMancheteComFotoBoxDireitaLista().get(i).findElement(By.tagName("img")).isDisplayed()){
					return false;
				}
			}
		}
		return true;
	}
	
	public boolean exibiuUmLinkNasFotosDasMateriasDaDireita() {
		for(int i=0;i<getMancheteDuasColunasUmaMancheteComFotoBoxDireitaLista().size();i++){
			List<WebElement> possuiFotoNaPosicao = getMancheteDuasColunasUmaMancheteComFotoBoxDireitaLista().get(i).findElements(By.tagName("img"));
			if(possuiFotoNaPosicao.size()>0){
				if(!getMancheteDuasColunasUmaMancheteComFotoBoxDireitaLista().get(i).findElement(By.tagName("a")).isDisplayed()){
					return false;
				}
			}
		}
		return true;
	}
	
	public boolean exibiuUmLinkValidoNasFotosDasMateriasDaDireita() {
		for(int i=0;i<getMancheteDuasColunasUmaMancheteComFotoBoxDireitaLista().size();i++){
			List<WebElement> possuiFotoNaPosicao = getMancheteDuasColunasUmaMancheteComFotoBoxDireitaLista().get(i).findElements(By.tagName("img"));
			if(possuiFotoNaPosicao.size()>0){
				if(getMancheteDuasColunasUmaMancheteComFotoBoxDireitaLista().get(i).findElement(By.tagName("a")).getAttribute("href").isEmpty()){
					return false;
				}
			}
		}
		return true;
	}
	
	
	
	public boolean exibiuClasseAnimadoOpacityNasFotosDasMateriasDaDireita() {
		for(int i=0;i<getMancheteDuasColunasUmaMancheteComFotoBoxDireitaLista().size();i++){
			List<WebElement> possuiFotoNaPosicao = getMancheteDuasColunasUmaMancheteComFotoBoxDireitaLista().get(i).findElements(By.tagName("img"));
			if(possuiFotoNaPosicao.size()>0){
				if(!getMancheteDuasColunasUmaMancheteComFotoBoxDireitaLista().get(i).findElement(By.tagName("a")).getAttribute("class").contains("animado-opacity")){
					return false;
				}
			}
		}
		return true;
	}
	
	public boolean exibiuWidthNasFotosDasMateriasDaDireita() {
		for(int i=0;i<getMancheteDuasColunasUmaMancheteComFotoBoxDireitaLista().size();i++){
			List<WebElement> possuiFotoNaPosicao = getMancheteDuasColunasUmaMancheteComFotoBoxDireitaLista().get(i).findElements(By.tagName("img"));
			if(possuiFotoNaPosicao.size()>0){
				if(!getMancheteDuasColunasUmaMancheteComFotoBoxDireitaLista().get(i).findElement(By.tagName("img")).getAttribute("width").equals("140")){
					return false;
				}
			}
		}
		return true;
	}
	
	public boolean exibiuHeightNasFotosDasMateriasDaDireita() {
		for(int i=0;i<getMancheteDuasColunasUmaMancheteComFotoBoxDireitaLista().size();i++){
			List<WebElement> possuiFotoNaPosicao = getMancheteDuasColunasUmaMancheteComFotoBoxDireitaLista().get(i).findElements(By.tagName("img"));
			if(possuiFotoNaPosicao.size()>0){
				if(!getMancheteDuasColunasUmaMancheteComFotoBoxDireitaLista().get(i).findElement(By.tagName("img")).getAttribute("height").equals("84")){
					return false;
				}
			}
		}
		return true;
	}
	
	
	public boolean exibiuEditoriaParaAsMateriasDaDireita() {
		for(int i=0;i<getMancheteDuasColunasUmaMancheteComFotoBoxDireitaLista().size();i++){
			if(getMancheteDuasColunasUmaMancheteComFotoBoxDireitaLista().get(i).findElement(By.tagName("h2")).getText().isEmpty()){
				return false;
			}
		}
		return true;
	}

	public boolean exibiuTituloParaAsMateriasDaDireita() {
		for(int i=0;i<getMancheteDuasColunasUmaMancheteComFotoBoxDireitaLista().size();i++){
			if(getMancheteDuasColunasUmaMancheteComFotoBoxDireitaLista().get(i).findElement(By.tagName("h3")).findElements(By.tagName("a")).get(0).getText().isEmpty()){
				return false;
			}
		}
		return true;
	}
	
	public boolean exibiuAsMateriasDaDireitaComMaximoDeCaracteresPermitidos() {
		for(int i=0;i<getMancheteDuasColunasUmaMancheteComFotoBoxDireitaLista().size();i++){
			if(getMancheteDuasColunasUmaMancheteComFotoBoxDireitaLista().get(i).findElement(By.tagName("h3")).findElements(By.tagName("a")).get(0).getText().length()>59){
				return false;
			}
		}
		return true;
	}
	

	public boolean exibiuLinkNoTituloDasMateriasDaDireita() {
		for(int i=0;i<getMancheteDuasColunasUmaMancheteComFotoBoxDireitaLista().size();i++){
			if(!getMancheteDuasColunasUmaMancheteComFotoBoxDireitaLista().get(i).findElement(By.tagName("h3")).findElements(By.tagName("a")).get(0).isDisplayed()){
				return false;
			}
		}
		return true;
	}

	public boolean exibiuUmLinkValidoNoTituloDasMateriasDaDireita() {
		for(int i=0;i<getMancheteDuasColunasUmaMancheteComFotoBoxDireitaLista().size();i++){
			if(getMancheteDuasColunasUmaMancheteComFotoBoxDireitaLista().get(i).findElement(By.tagName("h3")).findElements(By.tagName("a")).get(0).getAttribute("href").isEmpty()){
				return false;
			}
		}
		return true;
	}

	public boolean exibiuTotalDeComentarisParaAsMateriasDaDireita() {
		for(int i=0;i<getMancheteDuasColunasUmaMancheteComFotoBoxDireitaLista().size();i++){
			List<WebElement> possuiComentarioNaPosicao = getMancheteDuasColunasUmaMancheteComFotoBoxDireitaLista().get(i).findElement(By.tagName("h3")).findElements(By.className("comments"));
			if(possuiComentarioNaPosicao.size()>0){
				if(getMancheteDuasColunasUmaMancheteComFotoBoxDireitaLista().get(i).findElement(By.tagName("h3")).findElements(By.tagName("a")).get(1).getText().isEmpty()){
					return false;
				}
			}
		}
		return true;
	}

	public boolean exibiuUmLinkNoTotalDeComentarisParaAsMateriasDaDireita() {
		for(int i=0;i<getMancheteDuasColunasUmaMancheteComFotoBoxDireitaLista().size();i++){
			List<WebElement> possuiComentarioNaPosicao = getMancheteDuasColunasUmaMancheteComFotoBoxDireitaLista().get(i).findElement(By.tagName("h3")).findElements(By.className("comments"));
			if(possuiComentarioNaPosicao.size()>0){
				if(!getMancheteDuasColunasUmaMancheteComFotoBoxDireitaLista().get(i).findElement(By.tagName("h3")).findElements(By.tagName("a")).get(1).isDisplayed()){
					return false;
				}
			}
		}
		return true;
	}

	public boolean exibiuUmLinkValidoNoTotalDeComentarisParaAsMateriasDaDireita() {
		for(int i=0;i<getMancheteDuasColunasUmaMancheteComFotoBoxDireitaLista().size();i++){
			List<WebElement> possuiComentarioNaPosicao = getMancheteDuasColunasUmaMancheteComFotoBoxDireitaLista().get(i).findElement(By.tagName("h3")).findElements(By.className("comments"));
			if(possuiComentarioNaPosicao.size()>0){
				if(getMancheteDuasColunasUmaMancheteComFotoBoxDireitaLista().get(i).findElement(By.tagName("h3")).findElements(By.tagName("a")).get(1).getAttribute("href").isEmpty()){
					return false;
				}
			}
		}
		return true;
	}
}
