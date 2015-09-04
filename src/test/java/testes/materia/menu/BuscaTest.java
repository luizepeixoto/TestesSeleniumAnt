package testes.materia.menu;

import static org.junit.Assert.*;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import pages.materia.menu.MenuBusca;

import br.com.infoglobo.pages.Navegador;
import br.com.infoglobo.pages.OrdemExecucaoTeste;
import br.com.infoglobo.pages.OrdenadorTestes;
import br.com.infoglobo.pages.RegraTirarScreenShot;

@RunWith(OrdenadorTestes.class)
public class BuscaTest {
	
	private static MenuBusca menuBusca;
	
	@Rule
	public RegraTirarScreenShot tirarScreenShot = new RegraTirarScreenShot(menuBusca.getDriver());
	
	@BeforeClass
	public static void antesDeCadaTeste() throws Exception {
		menuBusca = new MenuBusca(Navegador.CHROME);
	}

	@AfterClass
	public static void depoisDeCadaTeste() {
		menuBusca.fechar();
	}
	
	@OrdemExecucaoTeste(Ordem=1)
	@Test
	public void verificaSeOBoxQueContemABuscaEstaSendoExibidoNoMenu() throws InterruptedException{
		assertNotNull(menuBusca.exibiuBoxDeBusca());
	}
	
	@OrdemExecucaoTeste(Ordem=2)
	@Test
	public void verificaSeOTituloBuscarEstaSendoExibidoNoMenu(){
		String resultadoEsperado = "BUSCAR";
		assertEquals(resultadoEsperado, menuBusca.getBoxBuscaTitulo());
	}
	
	@OrdemExecucaoTeste(Ordem=3)
	@Test
	public void verificaSeAoClicarOCampoBuscarEstaSendoExibido() throws InterruptedException{
		assertTrue(menuBusca.verificarExibicaoDaBusca());
	}
	
	@OrdemExecucaoTeste(Ordem=4)
	@Test
	public void verificaSeAoClicarOTextoBuscarEstaSendoExibidoNoCampoDeBusca(){
		assertTrue(menuBusca.getBoxBuscaPlaceholder());
	}
}