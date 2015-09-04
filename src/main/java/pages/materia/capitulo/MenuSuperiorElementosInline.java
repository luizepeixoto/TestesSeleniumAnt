package pages.materia.capitulo;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import pages.materia.widget.BoxListaDeFatosInlinePadrao;

import br.com.infoglobo.pages.Navegador;

public class MenuSuperiorElementosInline extends BoxListaDeFatosInlinePadrao {
	
	public MenuSuperiorElementosInline() throws Exception {
		super();
	}
	
	public MenuSuperiorElementosInline(Navegador navegador) throws Exception {
		super(navegador);
	}
	
	private static final String FONTE_FAMILY_ESPERADA = "Arial, Helveltica, sans-serif";
	private static final String TAMANHO_FONTE_ESPERADO = "13px";
	
	public WebElement exibiuMateriaEmCapitulos() {
		return getDriver().findElement(By.className("materia-capitulos"));
	}
	
	public WebElement acessaMenuSuperior(){
		return exibiuMateriaEmCapitulos().findElement(By.id("sticker-capitulo"));
	}

	public List<WebElement> posicoesDoMenuLateral() {
		return acessaMenuSuperior().findElement(By.className("menu")).findElements(By.tagName("ul")).get(0).findElements(By.tagName("li"));
	}

	public void clicaNoCapituloDesejado(int capituloDesejado){
		posicoesDoMenuLateral().get(capituloDesejado).findElement(By.tagName("a")).click();
	}
	
	/*Validação da materia principal*/
	
	private WebElement obterLegendaDaFotoInlineCentroGrandeDaMateriaPrincipal() {
		return exibiuMateriaEmCapitulos().findElement(By.className("resumo-capitulos"))
				.findElement(By.className("foto")).findElement(By.tagName("figcaption"));
	}
	
	public boolean exibiuAFonteArialParaALegendaDaFotoInlineCentroGrandeDaMateriaPrincipal() {
		return obterLegendaDaFotoInlineCentroGrandeDaMateriaPrincipal().getCssValue("font-family").equals(FONTE_FAMILY_ESPERADA);
	}
	
	public boolean exibiuOTamanhoDe13pxParaALegendaDaFotoInlineCentroGrandeDaMateriaPrincipal() {
		return obterLegendaDaFotoInlineCentroGrandeDaMateriaPrincipal().getCssValue("font-size").equals(TAMANHO_FONTE_ESPERADO);
	}

	/*Inicio da validação dos capitulos*/
	
	public List<WebElement> listaTotalDeMaterias() {
		return exibiuMateriaEmCapitulos().findElements(By.className("capituloPage"));
	}
	
	public boolean exibiuUmaListaDeMaterias() {
		return listaTotalDeMaterias().size() > Integer.parseInt("2");
	}
	
	public boolean exibiuNoPrimeiroCapituloUmaFotoCentroGrande() {
		String cropCorreto = "FT1086A/420";
		return listaTotalDeMaterias().get(0).findElement(By.className("foto")).findElement(By.tagName("img")).getAttribute("src").contains(cropCorreto);
	}
	
	private WebElement obterLegendaDaFotoInlineCentroGrandeDoPrimeiroCapitulo() {
		return listaTotalDeMaterias().get(0).findElement(By.className("foto")).findElement(By.tagName("figcaption"));
	}
	
	public boolean exibiuAFonteArialParaALegendaDaFotoInlineCentroGrandeDoPrimeiroCapitulo() {
		return obterLegendaDaFotoInlineCentroGrandeDoPrimeiroCapitulo().getCssValue("font-family").equals(FONTE_FAMILY_ESPERADA);
	}
	
	public boolean exibiuOTamanhoDe13pxParaALegendaDaFotoInlineCentroGrandeDoPrimeiroCapitulo() {
		return obterLegendaDaFotoInlineCentroGrandeDoPrimeiroCapitulo().getCssValue("font-size").equals(TAMANHO_FONTE_ESPERADO);
	}
	
	public boolean exibiuNoPrimeiroCapituloUmaFotoEsquerdaVertical() {
		return listaTotalDeMaterias().get(0).findElements(By.className("esquerda")).get(0).findElement(By.tagName("img")).getAttribute("height").equals("770");
	}

	public boolean exibiuNoPrimeiroCapituloUmaFotoEsquerdaGrande() {
		return listaTotalDeMaterias().get(0).findElements(By.className("esquerda")).get(1).findElement(By.tagName("img")).getAttribute("height").equals("275");
	}

	public boolean exibiuNoPrimeiroCapituloUmaFotoEsquerdaPequena() {
		return listaTotalDeMaterias().get(0).findElement(By.className("artigo-imagem")).findElement(By.tagName("img")).getAttribute("height").equals("180");
	}

	public boolean exibiuNoSegundoCapituloUmBoxDeConteudoRelacionado() {
		if(listaTotalDeMaterias().get(1).findElement(By.className("box-vejaTambem")).isDisplayed()){
			List<WebElement> totalDeLinksNoBox = listaTotalDeMaterias().get(1).findElement(By.className("box-vejaTambem")).findElements(By.tagName("li"));
			for(int i=0; i< totalDeLinksNoBox.size(); i++){
				if(!totalDeLinksNoBox.get(i).findElement(By.tagName("a")).isDisplayed()){
					return false;
				}
			}
			return true;
		}
		return false;
	}

	public boolean exibiuNoTerceiroCapituloUmBoxDeCitacao() {
		return listaTotalDeMaterias().get(2).findElement(By.className("box-citacao")).isDisplayed();
	}

	public boolean exibiuNoQuartoCapituloUmBoxDeTweeterEmbed() {
		return listaTotalDeMaterias().get(3).findElement(By.className("artigo-twitter")).isDisplayed();
	}
	
	public List<WebElement> totalDeVideosNoCapitulo(){
		return listaTotalDeMaterias().get(4).findElements(By.className("artigo-video"));
	}
	
	public boolean exibiuNoQuintoCapituloUmVideoDaGloboCom() {
		return totalDeVideosNoCapitulo().get(0).getAttribute("id").contains("player-wrapper2");
	}

	public boolean exibiuNoQuintoCapituloUmVideoDoYoutube() {
		return totalDeVideosNoCapitulo().get(1).findElement(By.tagName("iframe")).getAttribute("src").contains("youtube");
	}

	public boolean exibiuNoQuintoCapituloUmVideoDoVimeo() {
		return totalDeVideosNoCapitulo().get(2).findElement(By.tagName("iframe")).getAttribute("src").contains("vimeo");
	}

	public boolean exibiuNoQuintoCapituloUmVideoDoVevo() {
		return totalDeVideosNoCapitulo().get(3).findElement(By.tagName("iframe")).getAttribute("src").contains("vevo");
	}

	public boolean exibiuNoQuintoCapituloUmVideoDoLiveStream() {
		return totalDeVideosNoCapitulo().get(4).findElement(By.tagName("iframe")).getAttribute("src").contains("ustream");
	}

	public boolean exibiuNoQuintoCapituloUmVideoDoUsStream() {
		return totalDeVideosNoCapitulo().get(5).findElement(By.tagName("iframe")).getAttribute("src").contains("livestream");
	}

	public boolean exibiuNoSextoCapituloUmBoxDeMusicaVertical() {
		return listaTotalDeMaterias().get(5).findElement(By.className("box-musica")).isDisplayed();
	}

	public boolean exibiuNoSetimoCapituloUmBoxDeMusicaHorizontal() {
		return listaTotalDeMaterias().get(6).findElement(By.className("box-musica-block")).isDisplayed();
	}
	
	public boolean exibiuNoOitavoCapituloUmaFotogaleriaInline() {
		return listaTotalDeMaterias().get(7).findElement(By.className("row")).findElement(By.className("fotogaleriasmateriaCapitulos")).isDisplayed();
	}
}