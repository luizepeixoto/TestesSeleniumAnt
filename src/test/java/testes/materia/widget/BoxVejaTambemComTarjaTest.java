package testes.materia.widget;

import static org.junit.Assert.*;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Rule;
import org.junit.Test;

import pages.materia.widget.BoxVejaTambemComTarja;

import br.com.infoglobo.pages.Navegador;
import br.com.infoglobo.pages.RegraTirarScreenShot;

public class BoxVejaTambemComTarjaTest {
	
	private static BoxVejaTambemComTarja materia;
	
	@Rule
	public RegraTirarScreenShot tirarScreenShot = new RegraTirarScreenShot(materia.getDriver());
	
	@BeforeClass
	public static void antesDeCadaTeste() throws Exception {
		materia = new BoxVejaTambemComTarja(Navegador.CHROME);
		materia.executaScrollParaAparecerOTituloDeUmaPosicao(materia.getBoxVeja());
	}

	@AfterClass
	public static void depoisDeCadaTeste() {
		materia.fechar();
	}
	
	@Test
	public void verificaSeATarjaDeVideoDaMateriaDoBoxDoVejaTambemEstaSendoExibida(){
		assertTrue(materia.getTarja());
	}
	
	@Test
	public void verificaSeATarjaDeGaleriaDaMateriaDoBoxDoVejaTambemEstaSendoExibida(){
		assertTrue(materia.getTarja());
	}
	
	@Test
	public void verificaSeATarjaDeInfograficoDaMateriaDoBoxDoVejaTambemEstaSendoExibida(){
		assertTrue(materia.getTarja());
	}
}