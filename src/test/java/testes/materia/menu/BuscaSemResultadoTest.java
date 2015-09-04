package testes.materia.menu;

import static org.junit.Assert.assertTrue;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Rule;
import org.junit.Test;

import pages.materia.menu.MenuBusca;

import br.com.infoglobo.pages.Navegador;
import br.com.infoglobo.pages.RegraTirarScreenShot;

public class BuscaSemResultadoTest {
	
	private static MenuBusca materia;
	
	@Rule
	public RegraTirarScreenShot tirarScreenShot = new RegraTirarScreenShot(materia.getDriver());
	
	@BeforeClass
	public static void antesDeCadaTeste() throws Exception {
		materia = new MenuBusca(Navegador.FIREFOX);
	}

	@AfterClass
	public static void depoisDeCadaTeste() {
		materia.fechar();
	}
	
	@Test
	public void executarUmaBuscaComTextoValidoSemResultados() throws InterruptedException{
		assertTrue(materia.executarBuscaValidaSemResultado());
	}
}