package pages.materia.foto;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import br.com.infoglobo.pages.Navegador;

public class MateriaComFotoEsquerdaPequena extends MateriaComMultiplasFotos {
	
	public MateriaComFotoEsquerdaPequena(Navegador navegador) throws Exception {
		super(navegador);
	}
	
	private static final String FONTE_FAMILY_IMGS_ESQUERDA = "OgloboCondensed, Arial, sans-serif";
	private static final String TAMANHO_FONTE_IMGS_ESQUERDA = "15px";
	
	public WebElement exibiuTagFigureCaption(){
		return getDriver().findElement(By.className("artigo-imagem")).findElement(By.tagName("figcaption"));
	}
	
	public void executaMouseOverNaImagem() {
		executarMouseOver(getDriver().findElement(By.className("novo")).findElement(By.className("artigo-imagem")).findElement(By.tagName("img")));
	}
	
	public boolean exibiuLegendaparaFotoEsquerdaPequena() {
		return !exibiuTagFigureCaption().getAttribute("textContent").isEmpty();
	}
	
	public boolean exibiuAFonteOGloboCondensedParaALegendaDaFotoEsquerdaPequena() {
		return exibiuTagFigureCaption().getCssValue("font-family").equals(FONTE_FAMILY_IMGS_ESQUERDA);
	}
	
	public boolean exibiuOTamanhoDe15pxParaALegendaDaFotoEsquerdaPequena() {
		return exibiuTagFigureCaption().getCssValue("font-size").equals(TAMANHO_FONTE_IMGS_ESQUERDA);
	}

	public boolean exibiuAutorNaLegenda() {
		return !exibiuTagFigureCaption().findElement(By.tagName("b")).getAttribute("innerHTML").isEmpty();
	}
}