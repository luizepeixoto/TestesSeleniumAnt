package pages.materia.foto;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import br.com.infoglobo.pages.Navegador;

public class MateriaComFotoCentroGrande extends MateriaComMultiplasFotos {
	
	public MateriaComFotoCentroGrande(Navegador navegador) throws Exception {
		super(navegador);
	}
	
	public WebElement exibiuTagFigureCaption(){
		return getDriver().findElement(By.className("foto")).findElement(By.tagName("figcaption"));
	}
	
	public boolean exibiuLegendaparaFotoCentroGrande() {
		return !exibiuTagFigureCaption().getText().isEmpty();
	}
	
	public boolean exibiuAFonteArialParaALegendaDaFotoInlineCentroGrande() {
		return exibiuTagFigureCaption().getCssValue("font-family").equals("Arial, Helveltica, sans-serif");
	}
	
	public boolean exibiuOTamanhoDe13pxParaALegendaDaFotoInlineCentroGrande() {
		return exibiuTagFigureCaption().getCssValue("font-size").equals("13px");
	}

	public boolean exibiuAutorNaLegenda() {
		return !exibiuTagFigureCaption().findElement(By.tagName("b")).getText().isEmpty();
	}
}