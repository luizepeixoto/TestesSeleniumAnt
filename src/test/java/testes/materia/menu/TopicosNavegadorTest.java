package testes.materia.menu;

import static org.junit.Assert.*;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Rule;
import org.junit.Test;

import pages.materia.menu.Menu;

import br.com.infoglobo.pages.Navegador;
import br.com.infoglobo.pages.RegraTirarScreenShot;

public class TopicosNavegadorTest {
	
	private static Menu menuTopicos;
	
	@Rule
	public RegraTirarScreenShot tirarScreenShot = new RegraTirarScreenShot(menuTopicos.getDriver());
	
	@BeforeClass
	public static void antesDeCadaTeste() throws Exception {
		menuTopicos = new Menu(Navegador.FIREFOX);
		menuTopicos.habilitarMenuEditoria();
	}

	@AfterClass
	public static void depoisDeCadaTeste() {
		menuTopicos.fechar();
	}
	
	@Test
	public void verificaSeOTituloTopicosEstaSendoExibido() {
		String tituloEsperado = "Tópicos";
		assertEquals(tituloEsperado, menuTopicos.exibiuOTituloDeTopicos());
	}
	
	@Test
	public void verificaSeOsNomesDosTopicosEstaoSendoExibidosNaListaDeTopicos() {
		assertTrue(menuTopicos.osItensDaListaDeTopicosEstaoAparecendoONomeDoTopico());
	}
}