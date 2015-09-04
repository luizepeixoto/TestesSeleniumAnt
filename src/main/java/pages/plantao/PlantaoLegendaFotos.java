package pages.plantao;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import br.com.infoglobo.pages.AceitacaoAbstractTest;
import br.com.infoglobo.pages.Navegador;

public class PlantaoLegendaFotos extends AceitacaoAbstractTest {

	private static final String FONTE_FAMILY_LEGENDA_IMG_CENTRO = "Arial, sans-serif";
	private static final String FONTE_FAMILY_LEGENDA_IMG_ESQUERDA = "OgloboCondensed, Arial, sans-serif";
	
	private static final String TAMANHO_FONTE_LEGENDA_IMG_CENTRO = "13px";
	private static final String TAMANHO_FONTE_LEGENDA_IMG_ESQUERDA = "15px";
	private static final String TAMANHO_FONTE_LEGENDA_IMG_ESQUERDA_VERTICAL = "13px";
	private static final String TAMANHO_FONTE_LEGENDA_IMG_ESQUERDA_PEQUENA = "15px";

	public PlantaoLegendaFotos(Navegador navegador) throws Exception {
		super(navegador);
	}
	
	private WebElement obterPlantao() {
		return getDriver().findElement(By.className("plantao"));
	}
	
	private WebElement obterLegendaDaFotoDePrimeiraPosicao() {
		return obterPlantao().findElement(By.className("float")).findElement(By.tagName("figcaption"));
	}
	
	public boolean exibiuAFonteArialParaALegendaDaFotoDePrimeiraPosicao() {
		return obterLegendaDaFotoDePrimeiraPosicao().getCssValue("font-family").equals(FONTE_FAMILY_LEGENDA_IMG_CENTRO);
	}

	public boolean exibiuOTamanhoDe13pxParaParaALegendaDaFotoDePrimeiraPosicao() {
		return obterLegendaDaFotoDePrimeiraPosicao().getCssValue("font-size").equals(TAMANHO_FONTE_LEGENDA_IMG_CENTRO);
	}
	
	private WebElement obterLegendaDaFotoInlineCentroGrande() {
		return obterPlantao().findElement(By.className("corpo")).findElement(By.className("foto")).findElement(By.tagName("figcaption"));
	}

	public boolean exibiuAFonteArialParaALegendaDaFotoCentroGrande() {
		return obterLegendaDaFotoInlineCentroGrande().getCssValue("font-family").equals(FONTE_FAMILY_LEGENDA_IMG_CENTRO);
	}

	public boolean exibiuOTamanhoDe13pxParaALegendaDaFotoCentroGrande() {
		return obterLegendaDaFotoInlineCentroGrande().getCssValue("font-size").equals(TAMANHO_FONTE_LEGENDA_IMG_CENTRO);
	}
	
	private List<WebElement> obterListaDeFotosDaEsquerda() {
		return obterPlantao().findElement(By.className("corpo")).findElements(By.className("esquerda"));
	}
	
	private WebElement acessaFotoEsquerdaVerticalGrande() {
		return obterListaDeFotosDaEsquerda().get(0);
	}
	
	private WebElement obterLegendaDaFotoEsquerdaVertical() {
		return acessaFotoEsquerdaVerticalGrande().findElement(By.tagName("figcaption"));
	}
	
	public boolean exibiuAFonteOGloboCondensedParaALegendaDaFotoEsquerdaVertical() throws InterruptedException {
		String fonteLegendaEsquerdaVerticalEsperada = "OgloboCondensed, Arial, sans-serif";
		
		executarMouseOver(acessaFotoEsquerdaVerticalGrande().findElement(By.tagName("figure")).findElement(By.tagName("img")));
		esperaCarregar1Segundo();
		String fonteLegendaEsquerdaVerticalAtual = obterLegendaDaFotoEsquerdaVertical().getCssValue("font-family");
		
		if(!fonteLegendaEsquerdaVerticalAtual.equals(fonteLegendaEsquerdaVerticalEsperada)){
			imprimirMensagemDeErroDeUmaTag("Fonte da Legenda Da Foto Esquerda Vertical", fonteLegendaEsquerdaVerticalEsperada, fonteLegendaEsquerdaVerticalAtual);
			return false;
		}
		return true;
	
	}
	
	public boolean exibiuOTamanhoDe13pxParaALegendaDaFotoEsquerdaVertical() throws InterruptedException {
		String tamanhoDaLegendaEsquerdaVerticalEsperada = "15px";
		esperaCarregar1Segundo();
		executarMouseOver(acessaFotoEsquerdaVerticalGrande().findElement(By.tagName("figure")).findElement(By.tagName("img")));
		esperaCarregar1Segundo();
		String tamanhoDaFonteLegendaEsquerdaVerticalAtual = obterLegendaDaFotoEsquerdaVertical().getCssValue("font-size");
		
		if(!tamanhoDaFonteLegendaEsquerdaVerticalAtual.equals(tamanhoDaLegendaEsquerdaVerticalEsperada)){
			imprimirMensagemDeErroDeUmaTag("Tamanho da Fonte da Legenda Da Foto Esquerda Vertical", tamanhoDaLegendaEsquerdaVerticalEsperada, tamanhoDaFonteLegendaEsquerdaVerticalAtual);
			return false;
		}
		return true;
	}
	
	private WebElement obterFotoEsquerdaGrande() {
		return obterListaDeFotosDaEsquerda().get(1);
	}
	
	private WebElement obterLegendaDaFotoEsquerdaGrande() {
		return obterFotoEsquerdaGrande().findElement(By.tagName("figcaption"));
	}
	
	public boolean exibiuAFonteOGloboCondensedParaALegendaDaFotoEsquerdaGrande() throws InterruptedException {
		esperaCarregar1Segundo();
		executarMouseOver(obterFotoEsquerdaGrande().findElement(By.tagName("img")));
		return obterLegendaDaFotoEsquerdaGrande().getCssValue("font-family").equals(FONTE_FAMILY_LEGENDA_IMG_ESQUERDA);
	}
	
	public boolean exibiuOTamanhoDe15pxParaALegendaDaFotoEsquerdaGrande() {
		executarMouseOver(obterFotoEsquerdaGrande().findElement(By.tagName("img")));
		return obterLegendaDaFotoEsquerdaGrande().getCssValue("font-size").equals(TAMANHO_FONTE_LEGENDA_IMG_ESQUERDA);
	}
	
	private WebElement obterFotoEsquerdaPequena() {
		return obterPlantao().findElement(By.className("corpo")).findElement(By.className("artigo-imagem"));
	}
	
	private WebElement obterLegendaDaFotoEsquerdaPequena() {
		return obterFotoEsquerdaPequena().findElement(By.tagName("figcaption"));
	}
	
	public boolean exibiuAFonteOGloboCondensedParaALegendaDaFotoEsquerdaPequena() throws InterruptedException {
		esperaCarregar2Segundos();
		executarScroll(getDriver().findElement(By.className("artigo-imagem")).getLocation());
		executarMouseOver(getDriver().findElement(By.className("artigo-imagem")).findElement(By.tagName("img")));
		return obterLegendaDaFotoEsquerdaPequena().getCssValue("font-family").equals(FONTE_FAMILY_LEGENDA_IMG_ESQUERDA);
	}
	
	public boolean exibiuOTamanhoDe15pxParaALegendaDaFotoEsquerdaPequena() throws InterruptedException {
		esperaCarregar2Segundos();
		executarMouseOver(getDriver().findElement(By.className("artigo-imagem")).findElement(By.tagName("img")));
		
		if(!obterLegendaDaFotoEsquerdaPequena().getCssValue("font-size").equals(TAMANHO_FONTE_LEGENDA_IMG_ESQUERDA_PEQUENA)){
			imprimirMensagemDeErroDeUmaTag("Legenda Da Foto Esquerda Vertical", TAMANHO_FONTE_LEGENDA_IMG_ESQUERDA_PEQUENA, obterLegendaDaFotoEsquerdaPequena().getCssValue("font-size"));
			return false;
		}
		return true;
		
	}
}