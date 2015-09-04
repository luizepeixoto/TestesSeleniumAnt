package testes.materia.menu;

import static org.junit.Assert.assertTrue;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Rule;
import org.junit.Test;

import pages.materia.menu.MenuBusca;

import br.com.infoglobo.pages.Navegador;
import br.com.infoglobo.pages.RegraTirarScreenShot;

public class BuscaComResultadoTest {
	
	private static MenuBusca busca;
	
	@Rule
	public RegraTirarScreenShot tirarScreenShot = new RegraTirarScreenShot(busca.getDriver());
	
	@BeforeClass
	public static void antesDeCadaTeste() throws Exception {
		busca = new MenuBusca(Navegador.FIREFOX);
	}

	@AfterClass
	public static void depoisDeCadaTeste() {
		busca.fechar();
	}
	
	@Test
	public void verificaSeAoexecutarUmaBuscaComTextoValidoOsResultadosEstaoSendoExibido() throws InterruptedException{
		assertTrue(busca.executarBuscaValidaComResultado());
	}
}