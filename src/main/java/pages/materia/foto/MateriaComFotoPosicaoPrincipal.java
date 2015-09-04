package pages.materia.foto;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import br.com.infoglobo.pages.Navegador;

public class MateriaComFotoPosicaoPrincipal extends MateriaComMultiplasFotos {
	
	public MateriaComFotoPosicaoPrincipal(Navegador navegador) throws Exception {
		super(navegador);
	}
	
	public WebElement exibiuTagFigureCaption(){
		return getDriver().findElement(By.className("super-foto")).findElement(By.tagName("figure")).findElement(By.tagName("figcaption"));
	}
	
	public boolean exibiuLegendaparaFotoPrincipal() {
		return !exibiuTagFigureCaption().getText().isEmpty();
	}
	
	public boolean exibiuAFonteArialParaALegendaDaFotoDePrimeiraPosicao() {
		return exibiuTagFigureCaption().getCssValue("font-family").equals("Arial, Helveltica, sans-serif");
	}
	
	public boolean exibiuOTamanhoDe13pxParaParaALegendaDaFotoDePrimeiraPosicao() {
		return exibiuTagFigureCaption().getCssValue("font-size").equals("13px");
	}

	public boolean exibiuAutorNaLegenda() {
		return !exibiuTagFigureCaption().findElement(By.tagName("b")).getText().isEmpty();
	}
	
	public List<WebElement> listaDeRowDentroDaClasseArticle() {
		return getDriver().findElement(By.tagName("article")).findElements(By.className("row"));
	}
	
	public boolean exibiuUmTagHRAbaixoDaFotoPrincipal() {
		return listaDeRowDentroDaClasseArticle().get(2).findElement(By.tagName("hr")).isDisplayed();
	}
}