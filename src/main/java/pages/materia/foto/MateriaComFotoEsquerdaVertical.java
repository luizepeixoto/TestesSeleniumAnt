package pages.materia.foto;

import java.awt.AWTException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import br.com.infoglobo.pages.Navegador;

public class MateriaComFotoEsquerdaVertical extends MateriaComMultiplasFotos {
	
	public MateriaComFotoEsquerdaVertical(Navegador navegador) throws Exception {
		super(navegador);
	}
	
	private static final String FONTE_FAMILY_IMGS_ESQUERDA = "OgloboCondensed, Arial, sans-serif";
	private static final String TAMANHO_FONTE_IMGS_ESQUERDA = "15px";
	
	public WebElement exibiuTagFigureCaption(){
		return getDriver().findElement(By.className("esquerda")).findElement(By.tagName("figcaption"));
	}
	
	public void executaMouseOverNaImagem() throws AWTException{
		executarMouseOver(getDriver().findElement(By.className("novo")).findElement(By.className("esquerda")).findElement(By.tagName("img")));
	}
	
	public boolean exibiuLegendaParaFotoEsquerdaVertical() {
		return !exibiuTagFigureCaption().getText().isEmpty();
	}
	
	public boolean exibiuAFonteOGloboCondensedParaALegendaDaFotoEsquerdaVertical() {
		return exibiuTagFigureCaption().getCssValue("font-family").equals(FONTE_FAMILY_IMGS_ESQUERDA);
	}
	
	public boolean exibiuOTamanhoDe15pxParaALegendaDaFotoEsquerdaVertical() {
		return exibiuTagFigureCaption().getCssValue("font-size").equals(TAMANHO_FONTE_IMGS_ESQUERDA);
	}

	public boolean exibiuAutorNaLegenda() {
		return !exibiuTagFigureCaption().findElement(By.tagName("b")).getText().isEmpty();
	}
}