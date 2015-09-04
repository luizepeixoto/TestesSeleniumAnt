package pages.capa.meio;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import crops.CropsCapaColunaDoMeio;

import br.com.infoglobo.pages.AceitacaoAbstractTest;

public class CapaMeioMancheteDuasColunasUmaMancheteFotoHorizontal extends AceitacaoAbstractTest {
	
	public CapaMeioMancheteDuasColunasUmaMancheteFotoHorizontal() throws Exception {
		super();
	}
	
	public List<WebElement> listaDePrincipais(){
		return getDriver().findElement(By.className("main-home")).findElements(By.className("lista-materias"));
	}
	
	//Início Duas Colunas e uma Manchete - Uma coluna, com foto horizontal e quatro destaques

	//- É obrigatória a exibição da foto na primeira manchete. Se não tiver, não exibe o box.
	//- Se a manchete tiver foto horizontal, limita em três chamadas na coluna da direita e não permite imagens.
	//- Se a manchete tiver foto vertical, limita em quatro chamadas na coluna da direita e permite imagens.
	//- limitar o título em quatro linhas nos dois casos, até 72 caracteres para a manchete e até 56 caracteres para as outras chamadas

	public WebElement getBoxMancheteDuasColunasUmaManchete(){
		return listaDePrincipais().get(2);
	}

	public boolean exibiuEditoriaNaEsquerda() {
		return !getBoxMancheteDuasColunasUmaManchete().findElement(By.className("editoria")).getText().isEmpty();
	}
	
	public WebElement exibiuColunaDaEsquerda(){
		return getBoxMancheteDuasColunasUmaManchete().findElement(By.className("left"));
	}
	
	public WebElement exibiuColunaDaDireita(){
		return getBoxMancheteDuasColunasUmaManchete().findElement(By.className("right"));
	}
	
	public boolean exibiuLinkNaImagemDaMancheteDuasColunasUmaManchete() {
		List<WebElement> possuiFoto = getBoxMancheteDuasColunasUmaManchete().findElement(By.className("destaque")).findElements(By.tagName("img"));
		if(possuiFoto.size()>0){
			if(!getBoxMancheteDuasColunasUmaManchete().findElement(By.className("destaque")).findElement(By.tagName("a")).isDisplayed()){
				return false;
			}
		}
		return true;
	}
	
	public boolean exibiuLinkValidoNaImagemDaMancheteDuasColunasUmaManchete() {
		List<WebElement> possuiFoto = getBoxMancheteDuasColunasUmaManchete().findElement(By.className("destaque")).findElements(By.tagName("img"));
		if(possuiFoto.size()>0){
			if(getBoxMancheteDuasColunasUmaManchete().findElement(By.className("destaque")).findElement(By.tagName("a")).getAttribute("href").isEmpty()){
				return false;
			}
		}
		return true;
	}
	
	public boolean exibiuLinkAnimadoNaImagemDaMancheteDuasColunasUmaManchete() {
		List<WebElement> possuiFoto = getBoxMancheteDuasColunasUmaManchete().findElement(By.className("destaque")).findElements(By.tagName("img"));
		if(possuiFoto.size()>0){
			if(!getBoxMancheteDuasColunasUmaManchete().findElement(By.className("destaque")).findElement(By.tagName("a")).getAttribute("class").contains("animado-scale")){
				return false;
			}
		}
		return true;
	}
	
	public boolean exibiuImagemNaEsquerda() {
		return getBoxMancheteDuasColunasUmaManchete().findElement(By.className("destaque")).findElement(By.tagName("img")).isDisplayed();
	}
	
	public boolean exibiuCropCorretoNaImagemNaEsquerda() {
		String urlDaImagemAtual = getBoxMancheteDuasColunasUmaManchete().findElement(By.className("destaque")).findElement(By.tagName("img")).getAttribute("src");
		return urlDaImagemAtual.contains(CropsCapaColunaDoMeio.boxDuasColunasUmaMancheteHorizontal.cropProporcional());
	}
	
	public String getWidthDaImagemNaEsquerda() {
		return getBoxMancheteDuasColunasUmaManchete().findElement(By.className("destaque")).findElement(By.tagName("img")).getAttribute("width");
	}

	public String getHeightDaImagemNaEsquerda() {
		return getBoxMancheteDuasColunasUmaManchete().findElement(By.className("destaque")).findElement(By.tagName("img")).getAttribute("height");
			
	}

	public boolean exibiuEditoriaDaMateriaNaEsquerda() {
		return !getBoxMancheteDuasColunasUmaManchete().findElement(By.className("destaque")).findElement(By.tagName("h2")).getText().isEmpty();
	}

	public boolean exibiuTituloNaEsquerda() {
		return !getBoxMancheteDuasColunasUmaManchete().findElement(By.className("destaque")).findElement(By.tagName("h3")).findElement(By.tagName("a")).getText().isEmpty();
	}
	
	public boolean exibiuTituloDaEsquerdaComMaximoDeCaracteres() {
		if(getBoxMancheteDuasColunasUmaManchete().findElement(By.className("destaque")).findElement(By.tagName("h3")).findElement(By.tagName("a")).getText().length()>75){
			return false;
		}
		return true;
	}

	public boolean exibiuLinkNoTituloNaEsquerda() {
		return getBoxMancheteDuasColunasUmaManchete().findElement(By.className("destaque")).findElement(By.tagName("h3")).findElement(By.tagName("a")).isDisplayed();
	}

	public boolean exibiuLinkValidoNoTituloNaEsquerda() {
		return !getBoxMancheteDuasColunasUmaManchete().findElement(By.className("destaque")).findElement(By.tagName("h3")).findElement(By.tagName("a")).getAttribute("href").isEmpty();
	}

	public boolean exibiuTotalDeComentariosNaMateriaDaEsquerda() {
		List<WebElement> resultadoEsperado = getBoxMancheteDuasColunasUmaManchete().findElement(By.className("destaque")).findElements(By.className("comments"));
		if(resultadoEsperado.size()>0){
			if(resultadoEsperado.get(0).getText().isEmpty()){
				return false;
			}
		}
		return true;
	}

	public boolean exibiuUmLinkNoTotalDeComentarioNaEsquerda() {
		List<WebElement> resultadoEsperado = getBoxMancheteDuasColunasUmaManchete().findElement(By.className("destaque")).findElement(By.tagName("h3")).findElements(By.className("comments"));
		if(resultadoEsperado.size()>0){
			if(!getBoxMancheteDuasColunasUmaManchete().findElement(By.className("destaque")).findElement(By.tagName("h3")).findElements(By.tagName("a")).get(1).isDisplayed()){
				return false;
			}
		}
		return true;
	}

	public boolean exibiuUmLinkValidoNoTotalDeComentarioNaEsquerda() {
		List<WebElement> resultadoEsperado = getBoxMancheteDuasColunasUmaManchete().findElement(By.className("destaque")).findElement(By.tagName("h3")).findElements(By.className("comments"));
		if(resultadoEsperado.size()>0){
			if(getBoxMancheteDuasColunasUmaManchete().findElement(By.className("destaque")).findElement(By.tagName("h3")).findElements(By.tagName("a")).get(1).getAttribute("href").isEmpty()){
				return false;
			}
		}
		return true;
	}
	

	public List<WebElement> tamanhoDaListaDeMaterias() {
		return getBoxMancheteDuasColunasUmaManchete().findElement(By.className("right")).findElements(By.className("materia"));
	}

	public boolean exibiuListaDeMateriasNaDireita() {
		return tamanhoDaListaDeMaterias().size() > 0;
	}

	public boolean exibiuAEditoriaParaAListaDeMateriasNaDireita() {
		for(int i=0;i<tamanhoDaListaDeMaterias().size();i++){
			if(tamanhoDaListaDeMaterias().get(i).findElement(By.tagName("h2")).getText().isEmpty()){
				return false;
			}
		}
		return true;
	}

	public boolean exibiuTituloParaAListaDeMateriasNaDireita() {
		for(int i=0;i<tamanhoDaListaDeMaterias().size();i++){
			if(tamanhoDaListaDeMaterias().get(i).findElement(By.tagName("h3")).findElements(By.tagName("a")).get(0).getText().isEmpty()){
				return false;
			}
		}
		return true;
	}
	
	public boolean exibiuTituloDaDireitaComMaximoDeCaracteres() {
		for(int i=0;i<tamanhoDaListaDeMaterias().size();i++){
			if(tamanhoDaListaDeMaterias().get(i).findElement(By.tagName("h3")).findElements(By.tagName("a")).get(0).getText().length()>59){
				return false;
			}
		}
		return true;
	}
	
	
	public boolean exibiuLinkNoTituloParaAListaDeMateriasNaDireita() {
		for(int i=0;i<tamanhoDaListaDeMaterias().size();i++){
			if(!tamanhoDaListaDeMaterias().get(i).findElement(By.tagName("h3")).findElements(By.tagName("a")).get(0).isDisplayed()){
				return false;
			}
		}
		return true;
	}

	public boolean exibiuLinkValidoNoTituloDaDireita() {
		for(int i=0;i<tamanhoDaListaDeMaterias().size();i++){
			if(tamanhoDaListaDeMaterias().get(i).findElement(By.tagName("h3")).findElements(By.tagName("a")).get(0).getAttribute("href").isEmpty()){
				return false;
			}
		}
		return true;
	}

	public boolean getMancheteDuasColunasUmaMancheteBoxDireitaComentario() {
		for(int i=0;i<tamanhoDaListaDeMaterias().size();i++){
			List<WebElement> possuiComentarioNaPosicao = tamanhoDaListaDeMaterias().get(i).findElement(By.tagName("h3")).findElements(By.className("comments"));
			if(possuiComentarioNaPosicao.size()>0){
				if(tamanhoDaListaDeMaterias().get(i).findElement(By.tagName("h3")).findElement(By.className("comments")).getText().isEmpty()){
					return false;
				}
			}
		}
		return true;
	}

	public boolean getMancheteDuasColunasUmaMancheteBoxDireitaComentarioLink() {
		for(int i=0;i<tamanhoDaListaDeMaterias().size();i++){
			List<WebElement> possuiComentarioNaPosicao = tamanhoDaListaDeMaterias().get(i).findElement(By.tagName("h3")).findElements(By.className("comments"));
			if(possuiComentarioNaPosicao.size()>0){
				if(tamanhoDaListaDeMaterias().get(i).findElement(By.tagName("h3")).findElements(By.tagName("a")).get(1).getText().isEmpty()){
					return false;
				}
			}
		}
		return true;
	}

	public boolean getMancheteDuasColunasUmaMancheteBoxDireitaComentarioLinkValido() {
		for(int i=0;i<tamanhoDaListaDeMaterias().size();i++){
			List<WebElement> possuiComentarioNaPosicao = tamanhoDaListaDeMaterias().get(i).findElement(By.tagName("h3")).findElements(By.className("comments"));
			if(possuiComentarioNaPosicao.size()>0){
				if(tamanhoDaListaDeMaterias().get(i).findElement(By.tagName("h3")).findElements(By.tagName("a")).get(1).getAttribute("href").isEmpty()){
					return false;
				}
			}
		}
		return true;
	}
	
	//Fim Duas Colunas e uma Manchete - Uma coluna, com foto (vertical ou horizontal) e até quatro destaques ao lado	
}
