package testes.materia.menu;

import static org.junit.Assert.assertTrue;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import pages.materia.menu.MenuTopicoVazio;


public class TopicosVazioTest {
	
	private static MenuTopicoVazio menuSemTopicos;
	
	@BeforeClass
	public static void antesDeCadaTeste() throws Exception {
		menuSemTopicos = new MenuTopicoVazio();
	}

	@AfterClass
	public static void depoisDeCadaTeste() {
		menuSemTopicos.fechar();
	}
	
	@Test
	public void verificaSeAListaDeTopicosNaoEstaSendoExibida() {
		assertTrue(menuSemTopicos.aListaDeTopicosEstaAparecendo());
	}
}