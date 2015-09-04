package pages.materia.foto;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import crops.CropsDeArticles;

import br.com.infoglobo.pages.AceitacaoAbstractTest;
import br.com.infoglobo.pages.Navegador;

public class MateriaComMultiplasFotos extends AceitacaoAbstractTest {
	
	public MateriaComMultiplasFotos() throws Exception {
		super();
	}
	
	public MateriaComMultiplasFotos(Navegador navegador) throws Exception {
		super(navegador);
	}
	
	private static final String FONTE_FAMILY_ESPERADA = "Arial, Helveltica, sans-serif";
	private static final String TAMANHO_FONTE_ESPERADO = "13px";
	
	public WebElement exibiuFotoNaPrimeiraPosicao(){
		return getDriver().findElement(By.className("super-foto")).findElement(By.tagName("img"));
	}
	
	public boolean exibiuFotoNaPosicaoPrincipalComOCropCorreto(){
		String urlDaFotoAtual = exibiuFotoNaPrimeiraPosicao().getAttribute("src");
		return  urlDaFotoAtual.contains(CropsDeArticles.materiaFotoNaPrimeiraPosicao.cropProporcional());
	}
	
	public boolean exibiuFotoNaPrimeiraPosicaoComWidthCorreto(){
		String tamanhoDoWidth = exibiuFotoNaPrimeiraPosicao().getAttribute("width");
		return  Integer.parseInt(tamanhoDoWidth) <= Integer.parseInt(CropsDeArticles.materiaFotoNaPrimeiraPosicao.getWidth());
	}
	
	public boolean exibiuFotoNaPrimeiraPosicaoComHeightCorreto(){
		String tamanhoDoWidth = exibiuFotoNaPrimeiraPosicao().getAttribute("height");
		return  Integer.parseInt(tamanhoDoWidth) <= Integer.parseInt(CropsDeArticles.materiaFotoNaPrimeiraPosicao.getHeight());
	}
	
	private WebElement obterLegendaDaFotoDePrimeiraPosicao() {
		return getDriver().findElement(By.className("super-foto")).findElement(By.tagName("figcaption"));
	}
	
	public boolean exibiuAFonteArialParaALegendaDaFotoDePrimeiraPosicao() {
		return obterLegendaDaFotoDePrimeiraPosicao().getCssValue("font-family").equals(FONTE_FAMILY_ESPERADA);
	}
	
	public boolean exibiuOTamanhoDe13pxParaParaALegendaDaFotoDePrimeiraPosicao() {
		return obterLegendaDaFotoDePrimeiraPosicao().getCssValue("font-size").equals(TAMANHO_FONTE_ESPERADO);
	}
	
	public WebElement conteudoInlineDaMateria(){
		return getDriver().findElement(By.className("novo"));
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
		return  Integer.parseInt(tamanhoDoWidth) <= Integer.parseInt(CropsDeArticles.materiaFotoCentroGrande.getWidth());
	}
	
	public boolean exibiuFotoCentroGrandeComHeightCorreto(){
		String tamanhoDoWidth = exibiuFotoCentroGrande().getAttribute("height");
		return  Integer.parseInt(tamanhoDoWidth) <= Integer.parseInt(CropsDeArticles.materiaFotoCentroGrande.getHeight());
	}
	
	private WebElement obterLegendaDaFotoInlineCentroGrande() {
		return conteudoInlineDaMateria().findElement(By.className("foto")).findElement(By.tagName("figcaption"));
	}
	
	public boolean exibiuAFonteArialParaALegendaDaFotoInlineCentroGrande() {
		return obterLegendaDaFotoInlineCentroGrande().getCssValue("font-family").equals(FONTE_FAMILY_ESPERADA);
	}
	
	public boolean exibiuOTamanhoDe13pxParaALegendaDaFotoInlineCentroGrande() {
		return obterLegendaDaFotoInlineCentroGrande().getCssValue("font-size").equals(TAMANHO_FONTE_ESPERADO);
	}

	public WebElement exibiuFotoEsquerdaVertical() {
		return conteudoInlineDaMateria().findElement(By.className("esquerda")).findElement(By.tagName("figure")).findElement(By.tagName("img"));
	}
	
	public boolean exibiuFotoEsquerdaVerticalComOCropCorreto(){
		String urlDaFotoAtual = exibiuFotoEsquerdaVertical().getAttribute("src");
		return  urlDaFotoAtual.contains(CropsDeArticles.materiaFotoEsquerdaVertical.cropProporcional());
	}
	
	public boolean exibiuFotoEsquerdaVerticalComWidthCorreto() {
		String tamanhoDoWidth = exibiuFotoEsquerdaVertical().getAttribute("width");
		return  Integer.parseInt(tamanhoDoWidth) <= Integer.parseInt(CropsDeArticles.materiaFotoEsquerdaVertical.getWidth());
	}

	public boolean exibiuFotoEsquerdaVerticalComHeightCorreto() {
		String tamanhoDoWidth = exibiuFotoEsquerdaVertical().getAttribute("height");
		return  Integer.parseInt(tamanhoDoWidth) <= Integer.parseInt(CropsDeArticles.materiaFotoEsquerdaVertical.getHeight());
	}
	
	public List<WebElement> listaDeFotosComClasseEsquerda() {
		return conteudoInlineDaMateria().findElements(By.className("esquerda"));
	}
	
	public WebElement exibiuFotoEsquerdaGrande() {
		return listaDeFotosComClasseEsquerda().get(1).findElement(By.tagName("figure")).findElement(By.tagName("img"));
	}
	
	public boolean exibiuFotoEsquerdaGrandeComOCropCorreto(){
		String urlDaFotoAtual = exibiuFotoEsquerdaGrande().getAttribute("src");
		return  urlDaFotoAtual.contains(CropsDeArticles.materiaFotoEsquerdaGrande.cropProporcional());
	}
	
	public boolean exibiuFotoEsquerdaGrandeComWidthCorreto() {
		String tamanhoDoWidth = exibiuFotoEsquerdaGrande().getAttribute("width");
		return  Integer.parseInt(tamanhoDoWidth)<= Integer.parseInt(CropsDeArticles.materiaFotoEsquerdaGrande.getWidth());
	}

	public boolean exibiuFotoEsquerdaGrandeComHeightCorreto() {
		String tamanhoDoWidth = exibiuFotoEsquerdaGrande().getAttribute("height");
		return  Integer.parseInt(tamanhoDoWidth)<= Integer.parseInt(CropsDeArticles.materiaFotoEsquerdaGrande.getHeight());
	}

	public WebElement exibiuFotoEsquerdaPequena() {
		return conteudoInlineDaMateria().findElement(By.className("artigo-imagem")).findElement(By.tagName("img"));
	}
	
	public boolean exibiuFotoEsquerdaPequenaComOCropCorreto(){
		String urlDaFotoAtual = exibiuFotoEsquerdaPequena().getAttribute("src");
		return  urlDaFotoAtual.contains(CropsDeArticles.materiaFotoEsquerdaPequena.cropProporcional());
	}
	
	public boolean exibiuFotoEsquerdaPequenaComWidthCorreto() {
		return exibiuFotoEsquerdaPequena().getAttribute("width").equals(CropsDeArticles.materiaFotoEsquerdaPequena.getWidth());
	}

	public boolean exibiuFotoEsquerdaPequenaComHeightCorreto() {
		return exibiuFotoEsquerdaPequena().getAttribute("height").equals(CropsDeArticles.materiaFotoEsquerdaPequena.getHeight());
	}
	
	public boolean exibiuTextoNaMateria() {
		return !getDriver().findElement(By.className("novo")).findElement(By.tagName("p")).getText().isEmpty();
	}
}