package pages.capa.meio;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import crops.CropsCapaColunaDoMeio;

import br.com.infoglobo.pages.AceitacaoAbstractTest;

public class CapaMeioMancheteDuasColunasDuasManchetes extends AceitacaoAbstractTest {
	
	public CapaMeioMancheteDuasColunasDuasManchetes() throws Exception {
		super();
	}
	
	public List<WebElement> listaDePrincipais(){
		return getDriver().findElement(By.className("main-home")).findElements(By.className("lista-materias"));
	}
	
	//Início Duas Colunas e duas Manchetes - Duas manchetes em uma coluna com quatro destaques
	//	- É obrigatória a exibição da foto na primeira manchete. Se não tiver, não exibe o box.
	//	- Limita em quatro chamadas na coluna da direita e não permite imagens.
	//	- limitar o título da primeira manchete em quatro linhas, até 72 caracteres
	//	- limitar o título da segunda manchete em três linhas, até 72 caracteres
	//	- limitar o título das camadas em quatro linhas, até 52 caracteres
	
	public WebElement exibiuMancheteDuasColunasDuasManchetes(){
		return listaDePrincipais().get(0);
	}

	public boolean exibiuEditoriaPrincipalDoBox() {
		return !exibiuMancheteDuasColunasDuasManchetes().findElement(By.className("editoria")).getText().isEmpty();
	}
	
	public WebElement exibiuColunaDaEsquerda(){
		return exibiuMancheteDuasColunasDuasManchetes().findElement(By.className("left"));
	}
	
	public WebElement exibiuColunaDaDireita(){
		return exibiuMancheteDuasColunasDuasManchetes().findElement(By.className("right"));
	}
	
	public boolean exibiuFotoEmDestaque() {
		return exibiuMancheteDuasColunasDuasManchetes().findElement(By.className("destaque")).findElement(By.tagName("img")).isDisplayed();
	}
	
	public boolean exibiuCropCorretoParaFotoEmDestaque() {
		String UrLDaImagem =  exibiuMancheteDuasColunasDuasManchetes().findElement(By.className("destaque")).findElement(By.tagName("img")).getAttribute("src");
		return UrLDaImagem.contains(CropsCapaColunaDoMeio.boxDuasColunasDuasManchetes.cropProporcional());
	}
	
	public boolean exibiuClasseAnimadaEmDestaque() {
		List<WebElement> possuiImagem = exibiuMancheteDuasColunasDuasManchetes().findElement(By.className("destaque")).findElements(By.tagName("img"));
		if(possuiImagem.size()>0){
			if(!exibiuMancheteDuasColunasDuasManchetes().findElement(By.className("destaque")).findElement(By.tagName("a")).getAttribute("class").contains("animado-scale")){
				return false;
			}
		}
		return true;
	}
	
	public boolean exibiuLinkNaFotoEmDestaque() {
		List<WebElement> possuiImagem = exibiuMancheteDuasColunasDuasManchetes().findElement(By.className("destaque")).findElements(By.tagName("img"));
		if(possuiImagem.size()>0){
			if(!exibiuMancheteDuasColunasDuasManchetes().findElement(By.className("destaque")).findElement(By.tagName("a")).isDisplayed()){
				return false;
			}
		}
		return true;
	}
	
	public boolean exibiuLinkValidoNaFotoEmDestaque() {
		List<WebElement> possuiImagem = exibiuMancheteDuasColunasDuasManchetes().findElement(By.className("destaque")).findElements(By.tagName("img"));
		if(possuiImagem.size()>0){
			if(exibiuMancheteDuasColunasDuasManchetes().findElement(By.className("destaque")).findElement(By.tagName("a")).getAttribute("href").isEmpty()){
				return false;
			}
		}
		return true;
	}
	
	public String getWidthDaFotoEmDestaque() {
		return exibiuMancheteDuasColunasDuasManchetes().findElement(By.className("destaque")).findElement(By.tagName("img")).getAttribute("width");
	}

	public String getHeightDaFotoEmDestaque() {
		return exibiuMancheteDuasColunasDuasManchetes().findElement(By.className("destaque")).findElement(By.tagName("img")).getAttribute("height");
	}

	public boolean exibiuEditoriaDaMateriaEmDestaque() {
		return !exibiuMancheteDuasColunasDuasManchetes().findElement(By.className("destaque")).findElement(By.tagName("h2")).getText().isEmpty();
	}

	public boolean exibiuTituloDaMateriaEmDestaque() {
		return !exibiuMancheteDuasColunasDuasManchetes().findElement(By.className("destaque")).findElement(By.tagName("h3")).findElement(By.tagName("a")).getText().isEmpty();
	}
	
	public boolean exibiuTituloComQuantidadeMaximaPermitida() {
		return exibiuMancheteDuasColunasDuasManchetes().findElement(By.className("destaque")).findElement(By.tagName("h3")).findElement(By.tagName("a")).getText().length()<75;
	}

	public boolean exibiuTituloDaMateriaEmDestaqueComLink() {
		return exibiuMancheteDuasColunasDuasManchetes().findElement(By.className("destaque")).findElement(By.tagName("h3")).findElement(By.tagName("a")).isDisplayed();
	}

	public boolean exibiuUmLinkValidoNoTituloDaMateriaEmDestaque() {
		return !exibiuMancheteDuasColunasDuasManchetes().findElement(By.className("destaque")).findElement(By.tagName("h3")).findElement(By.tagName("a")).getAttribute("href").isEmpty();
	}

	public boolean exibiuTotalDeComentariosParaAMateriaEmDestaque() {
		List<WebElement> resultadoEsperado = exibiuMancheteDuasColunasDuasManchetes().findElement(By.className("destaque")).findElements(By.className("comments"));
		if(resultadoEsperado.size()>0){
			if(exibiuMancheteDuasColunasDuasManchetes().findElement(By.className("destaque")).findElement(By.tagName("h3")).findElements(By.tagName("a")).get(1).getText().isEmpty()){
				return false;
			}
		}
		return true;
	}

	public boolean exibiuLinkNosComentariosParaAMateriaEmDestaque() {
		List<WebElement> resultadoEsperado = exibiuMancheteDuasColunasDuasManchetes().findElement(By.className("destaque")).findElements(By.className("comments"));
		if(resultadoEsperado.size()>0){
			if(!exibiuMancheteDuasColunasDuasManchetes().findElement(By.className("destaque")).findElement(By.tagName("h3")).findElements(By.tagName("a")).get(1).isDisplayed()){
				return false;
			}
		}
		return true;
	}

	public boolean exibiuLinkValidoNosComentariosParaAMateriaEmDestaque() {
			List<WebElement> resultadoEsperado = exibiuMancheteDuasColunasDuasManchetes().findElement(By.className("destaque")).findElements(By.className("comments"));
			if(resultadoEsperado.size()>0){
				if(!exibiuMancheteDuasColunasDuasManchetes().findElement(By.className("destaque")).findElement(By.tagName("h3")).findElements(By.tagName("a")).get(1).getAttribute("href").contains("#comments")){
					return false;
				}
			}
			return true;
	}
	
	public boolean exibiuEditoriaDaMateriaEmSubDestaque() {
		return !exibiuMancheteDuasColunasDuasManchetes().findElement(By.className("sub-destaque")).findElement(By.tagName("h2")).getText().isEmpty();
	}

	public boolean exibiuTituloDaMateriaEmSubDestaque() {
		return !exibiuMancheteDuasColunasDuasManchetes().findElement(By.className("sub-destaque")).findElement(By.tagName("h3")).findElement(By.tagName("a")).getText().isEmpty();
	}

	public boolean exibiuLinkNoTituloDaMateriaEmSubDestaque() {
		return exibiuMancheteDuasColunasDuasManchetes().findElement(By.className("sub-destaque")).findElement(By.tagName("h3")).findElement(By.tagName("a")).isDisplayed();
	}

	public boolean exibiuTituloDeSubDestaqueComQuantidadeMaximaPermitida() {
		return exibiuMancheteDuasColunasDuasManchetes().findElement(By.className("sub-destaque")).findElement(By.tagName("h3")).findElement(By.tagName("a")).getText().length()<75;
	}
	
	public boolean exibiuLinkValidoNoTituloDaMateriaEmSubDestaque() {
		return !exibiuMancheteDuasColunasDuasManchetes().findElement(By.className("sub-destaque")).findElement(By.tagName("h3")).findElement(By.tagName("a")).getAttribute("href").isEmpty();
	}

	public boolean exibiuTotalDeComentariosEmSubDestaque() {
		List<WebElement> possuiComentario = exibiuMancheteDuasColunasDuasManchetes().findElement(By.className("sub-destaque")).findElements(By.className("comments"));
		if(possuiComentario.size()>0){
			if(possuiComentario.get(0).getText().isEmpty()){
				return false;
			}
		}
		return true;
	}

	public boolean exibiuLinkEmTotalDeComentariosParaSubDestaque() {
		List<WebElement> possuiComentario = exibiuMancheteDuasColunasDuasManchetes().findElement(By.className("sub-destaque")).findElements(By.className("comments"));
		if(possuiComentario.size()>1){
			if(exibiuMancheteDuasColunasDuasManchetes().findElement(By.className("sub-destaque")).findElements(By.tagName("a")).get(1).isDisplayed()){
				return true;
			}
		}
		return true;
	}

	public boolean exibiuLinkValidoEmTotalDeComentariosParaSubDestaque() {
		List<WebElement> possuiComentario = exibiuMancheteDuasColunasDuasManchetes().findElement(By.className("sub-destaque")).findElements(By.className("comments"));
		if(possuiComentario.size()>1){
			if(exibiuMancheteDuasColunasDuasManchetes().findElement(By.className("sub-destaque")).findElements(By.tagName("a")).get(1).getAttribute("href").isEmpty()){
				return true;
			}
		}
		return true;
	}
	
	public List<WebElement> listaDeMateriasDaDireita() {
		return exibiuMancheteDuasColunasDuasManchetes().findElement(By.className("right")).findElements(By.className("materia"));
	}

	public boolean exibiuMaterias() {
		return listaDeMateriasDaDireita().size() > 0;
	}

	public boolean exibiuEditoriaParaAsMateriasDaDireita() {
		for(int i=0;i<listaDeMateriasDaDireita().size();i++){
			if(listaDeMateriasDaDireita().get(i).findElement(By.tagName("h2")).getText().isEmpty()){
				return false;
			}
		}
		return true;
	}

	public boolean exibiuTituloParaAsMateriasDaDireita() {
		for(int i=0;i<listaDeMateriasDaDireita().size();i++){
			if(listaDeMateriasDaDireita().get(i).findElement(By.tagName("h3")).findElements(By.tagName("a")).get(0).getText().isEmpty()){
				return false;
			}
		}
		return true;
	}
	
	public boolean exibiuTituloParaAsMateriasDaDireitaComMaximoDeCaracteres() {
		for(int i=0;i<listaDeMateriasDaDireita().size();i++){
			if(listaDeMateriasDaDireita().get(i).findElement(By.tagName("h3")).findElements(By.tagName("a")).get(0).getText().length()>55){
				return false;
			}
		}
		return true;
	}

	public boolean exibiuLinkNoTituloNasMateriasDaDireita() {
		for(int i=0;i<listaDeMateriasDaDireita().size();i++){
			if(!listaDeMateriasDaDireita().get(i).findElement(By.tagName("h3")).findElements(By.tagName("a")).get(0).isDisplayed()){
				return false;
			}
		}
		return true;
	}

	public boolean exibiuLinkValidoNoTituloNasMateriasDaDireita() {
		for(int i=0;i<listaDeMateriasDaDireita().size();i++){
			if(listaDeMateriasDaDireita().get(i).findElement(By.tagName("h3")).findElements(By.tagName("a")).get(0).getAttribute("href").isEmpty()){
				return false;
			}
		}
		return true;
	}

	public boolean exibiuTotalDeComentariosParaAsMateriasDaDireita() {
		for(int i=0;i<listaDeMateriasDaDireita().size();i++){
			List<WebElement> exibiuComentario = listaDeMateriasDaDireita().get(i).findElement(By.tagName("h3")).findElements(By.className("comments"));
			if(exibiuComentario.size()>0){
				if(listaDeMateriasDaDireita().get(i).findElement(By.tagName("h3")).findElements(By.tagName("a")).get(1).getText().isEmpty()){
					return false;
				}
			}
		}
		return true;
	}

	public boolean exibiuUmLinkNosComentariosDasMateriasDaDireita() {
		for(int i=0;i<listaDeMateriasDaDireita().size();i++){
			List<WebElement> exibiuComentario = listaDeMateriasDaDireita().get(i).findElement(By.tagName("h3")).findElements(By.className("comments"));
			if(exibiuComentario.size()>0){
				if(!listaDeMateriasDaDireita().get(i).findElement(By.tagName("h3")).findElements(By.tagName("a")).get(1).isDisplayed()){
					return false;
				}
			}
		}
		return true;
	}

	public boolean exibiuUmLinkValidoNosComentariosDasMateriasDaDireita() {
		for(int i=0;i<listaDeMateriasDaDireita().size();i++){
			List<WebElement> exibiuComentario = listaDeMateriasDaDireita().get(i).findElement(By.tagName("h3")).findElements(By.className("comments"));
			if(exibiuComentario.size()>0){
				if(listaDeMateriasDaDireita().get(i).findElement(By.tagName("h3")).findElements(By.tagName("a")).get(1).getAttribute("href").isEmpty()){
					return false;
				}
			}
		}
		return true;
	}
}
