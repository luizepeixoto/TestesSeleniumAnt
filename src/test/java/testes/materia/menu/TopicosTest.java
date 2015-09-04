package testes.materia.menu;

import static org.junit.Assert.*;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import pages.materia.menu.Menu;


public class TopicosTest {
	
	private static Menu menuTopicos;
	
	@BeforeClass
	public static void antesDeCadaTeste() throws Exception {
		menuTopicos = new Menu();
	}

	@AfterClass
	public static void depoisDeCadaTeste() {
		menuTopicos.fechar();
	}
	
	@Test
	public void verificaSeOBoxDeTopicosEstaSendoExibido() {
		assertNotNull(menuTopicos.getBoxDeTopicos());
	}
	
	@Test
	public void verificaSeAListaDeTopicosEhMaiorDoQueZero() {
		assertTrue(menuTopicos.aListaDeTopicosEstaAparecendo());
	}
	
	@Test
	public void verificaSeOsNomesDosTopicosEstaoSendoExibidosNaListaDeTopicosPossuemUmaUrl() {
		assertTrue(menuTopicos.osItensDaListaDeTopicosPossuemUmaURL());
	}
	
	@Test
	public void verificaSeOsLinksApresentadosNosNomesDosTopicosSaoValidos() {
		assertTrue(menuTopicos.asUrlDosItensDaListaDeTopicosEhValida());
	}
}