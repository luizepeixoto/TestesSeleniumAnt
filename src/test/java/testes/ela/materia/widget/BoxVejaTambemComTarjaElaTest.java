package testes.ela.materia.widget;

import static org.junit.Assert.assertTrue;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Rule;
import org.junit.Test;

import pages.ela.materia.widget.BoxVejaTambemComTarjaEla;

import br.com.infoglobo.pages.Navegador;
import br.com.infoglobo.pages.RegraTirarScreenShot;

public class BoxVejaTambemComTarjaElaTest {
	
	private static BoxVejaTambemComTarjaEla materia;
	
	@Rule
	public RegraTirarScreenShot tirarScreenShot = new RegraTirarScreenShot(materia.getDriver());
	
	@BeforeClass
	public static void antesDeCadaTeste() throws Exception {
		materia = new BoxVejaTambemComTarjaEla(Navegador.CHROME);
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