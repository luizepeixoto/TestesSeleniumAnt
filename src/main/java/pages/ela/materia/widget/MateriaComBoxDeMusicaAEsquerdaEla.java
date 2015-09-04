package pages.ela.materia.widget;

import org.openqa.selenium.By;

import pages.materia.widget.MateriaComBoxDeMusicaAEsquerda;

import br.com.infoglobo.pages.Navegador;

public class MateriaComBoxDeMusicaAEsquerdaEla extends MateriaComBoxDeMusicaAEsquerda {

	public MateriaComBoxDeMusicaAEsquerdaEla(Navegador navegador) throws Exception{
		super(navegador);
	}
	
	public boolean exibiuAFonteCorretaNoBoxDeMusica() {
		String fonteEsperada = "OgloboXCondensed, sans-serif";
		return getDriver().findElement(By.xpath("//div[@class='box box-musica ng-scope']")).getCssValue("font-family").equals(fonteEsperada);
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