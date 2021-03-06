package pages.plantao;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import pages.materia.foto.MateriaComMultiplasFotos;

import crops.CropsDeArticles;

import br.com.infoglobo.pages.Navegador;

public class PlantaoMultiplasFotos extends MateriaComMultiplasFotos{
	
	public PlantaoMultiplasFotos() throws Exception {
		super();
	}
	
	public PlantaoMultiplasFotos(Navegador navegador) throws Exception {
		super(navegador);
	}

	/*Foto 1ª Posição Principal Centro Grande*/
	
	public WebElement exibiuBordaFotoCentroGrande(){
		return getDriver().findElement(By.className("texteira")).findElement(By.tagName("hr"));
	}
	
	public String exibiuFotoCentroGrandeComBorderBottom() {
		return exibiuBordaFotoCentroGrande().getCssValue("background-color");
	}
	
	public WebElement exibiuFotoNaPrimeiraPosicao(){
		return getDriver().findElement(By.className("float")).findElement(By.tagName("img"));
	}
	
	public boolean exibiuFotoNaPosicaoPrincipalComOCropCorreto(){
		String urlDaFotoAtual = exibiuFotoNaPrimeiraPosicao().getAttribute("src");
		return  urlDaFotoAtual.contains(CropsDeArticles.plantaoFotoNaPrimeiraPosicao.cropProporcional());
	}
	
	public boolean exibiuFotoNaPrimeiraPosicaoComWidthCorreto(){
		String tamanhoDoWidth = exibiuFotoNaPrimeiraPosicao().getAttribute("width");
		return  Integer.parseInt(tamanhoDoWidth) <= Integer.parseInt(CropsDeArticles.plantaoFotoNaPrimeiraPosicao.getWidth());
	}
	
	public boolean exibiuFotoNaPrimeiraPosicaoComHeightCorreto(){
		String tamanhoDoWidth = exibiuFotoNaPrimeiraPosicao().getAttribute("height");
		return  Integer.parseInt(tamanhoDoWidth) <= Integer.parseInt(CropsDeArticles.plantaoFotoNaPrimeiraPosicao.getHeight());
	}
	
	/*Foto inline Centro Grande*/
	
	public WebElement conteudoInlineDaMateria(){
		return getDriver().findElement(By.className("corpo"));
	}
	
	public WebElement exibiuFotoCentroGrande(){
		return conteudoInlineDaMateria().findElement(By.className("foto")).findElement(By.tagName("figure")).findElement(By.tagName("img"));
	}
	
	public boolean exibiuFotoCentroGrandeComOCropCorreto(){
		String urlDaImagem = exibiuFotoCentroGrande().getAttribute("src");
		return  urlDaImagem.contains(CropsDeArticles.materiaFotoCentroGrande.cropProporcional());
	}
	
	public boolean exibiuFotoCentroGrandeComWidthCorreto(){
		String tamanhoDoWidth = exibiuFotoCentroGrande().getAttribute("width");
		return  Integer.parseInt(tamanhoDoWidth) <= Integer.parseInt(CropsDeArticles.plantaoFotoCentroGrande.getWidth());
	}
	
	public boolean exibiuFotoCentroGrandeComHeightCorreto(){
		String tamanhoDoWidth = exibiuFotoCentroGrande().getAttribute("height");
		return  Integer.parseInt(tamanhoDoWidth) <= Integer.parseInt(CropsDeArticles.plantaoFotoCentroGrande.getHeight());
	}
	
	/*Foto inline Esquerda Vertical*/

	public WebElement exibiuFotoEsquerdaVertical() {
		return conteudoInlineDaMateria().findElement(By.className("esquerda")).findElement(By.tagName("figure")).findElement(By.tagName("img"));
	}
	
	public boolean exibiuFotoEsquerdaVerticalComOCropCorreto(){
		String urlDaFotoAtual = exibiuFotoEsquerdaVertical().getAttribute("src");
		return  urlDaFotoAtual.contains(CropsDeArticles.plantaoFotoEsquerdaVertical.cropProporcional());
	}
	
	public boolean exibiuFotoEsquerdaVerticalComWidthCorreto() {
		String tamanhoDoWidth = exibiuFotoEsquerdaVertical().getAttribute("width");
		return  Integer.parseInt(tamanhoDoWidth) <= Integer.parseInt(CropsDeArticles.plantaoFotoEsquerdaVertical.getWidth());
	}

	public boolean exibiuFotoEsquerdaVerticalComHeightCorreto() {
		String tamanhoDoWidth = exibiuFotoEsquerdaVertical().getAttribute("height");
		return  Integer.parseInt(tamanhoDoWidth) <= Integer.parseInt(CropsDeArticles.plantaoFotoEsquerdaVertical.getHeight());
	}
	
	public List<WebElement> listaDeFotosComClasseEsquerda() {
		return conteudoInlineDaMateria().findElements(By.className("esquerda"));
	}
	
	/*Foto inline Esquerda Grande*/
	
	public WebElement exibiuFotoEsquerdaGrande() {
		return listaDeFotosComClasseEsquerda().get(1).findElement(By.tagName("figure")).findElement(By.tagName("img"));
	}
	
	public boolean exibiuFotoEsquerdaGrandeComOCropCorreto(){
		String urlDaFotoAtual = exibiuFotoEsquerdaGrande().getAttribute("src");
		return  urlDaFotoAtual.contains(CropsDeArticles.plantaoFotoEsquerdaGrande.cropProporcional());
	}
	
	public boolean exibiuFotoEsquerdaGrandeComWidthCorreto() {
		String tamanhoDoWidth = exibiuFotoEsquerdaGrande().getAttribute("width");
		return  Integer.parseInt(tamanhoDoWidth)<= Integer.parseInt(CropsDeArticles.plantaoFotoEsquerdaGrande.getWidth());
	}

	public boolean exibiuFotoEsquerdaGrandeComHeightCorreto() {
		String tamanhoDoWidth = exibiuFotoEsquerdaGrande().getAttribute("height");
		return  Integer.parseInt(tamanhoDoWidth)<= Integer.parseInt(CropsDeArticles.plantaoFotoEsquerdaGrande.getHeight());
	}
	
	/*Foto inline Esquerda Pequena*/

	public WebElement exibiuFotoEsquerdaPequena() {
		return conteudoInlineDaMateria().findElement(By.className("artigo-imagem")).findElement(By.tagName("img"));
	}
	
	public boolean exibiuFotoEsquerdaPequenaComOCropCorreto(){
		String urlDaFotoAtual = exibiuFotoEsquerdaPequena().getAttribute("src");
		return  urlDaFotoAtual.contains(CropsDeArticles.plantaoFotoEsquerdaPequena.cropProporcional());
	}
	
	public boolean exibiuFotoEsquerdaPequenaComWidthCorreto() {
		return exibiuFotoEsquerdaPequena().getAttribute("width").equals(CropsDeArticles.plantaoFotoEsquerdaPequena.getWidth());
	}

	public boolean exibiuFotoEsquerdaPequenaComHeightCorreto() {
		return exibiuFotoEsquerdaPequena().getAttribute("height").equals(CropsDeArticles.plantaoFotoEsquerdaPequena.getHeight());
	}

}
