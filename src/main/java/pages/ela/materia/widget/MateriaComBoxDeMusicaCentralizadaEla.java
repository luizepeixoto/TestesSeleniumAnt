package pages.ela.materia.widget;

import org.openqa.selenium.By;

import pages.materia.widget.MateriaComBoxDeMusicaCentralizada;

import br.com.infoglobo.pages.Navegador;

public class MateriaComBoxDeMusicaCentralizadaEla extends MateriaComBoxDeMusicaCentralizada {

	public MateriaComBoxDeMusicaCentralizadaEla(Navegador navegador) throws Exception{
		super(navegador);
	}
	
	public boolean exibiuAFonteCorretaNoBoxDeMusica() {
		String fonteEsperada = "OgloboXCondensed";
		return getDriver().findElement(By.xpath("//div[@class='box-musica-block ng-scope']")).getCssValue("font-family").equals(fonteEsperada);
	}
	
	public boolean exibiuOCssCorretoNoTituloTopMusicas() {
		return false;
	}

	public boolean exibiuOCssCorretoNoNomeDoArtista() {
		return false;
	}

	public boolean exibiuOCssCorretoNoLinkMaisLetrasTraducoesEClipes() {
		return false;
	}
}