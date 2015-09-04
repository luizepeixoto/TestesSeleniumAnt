package testes.materia.menu;

import static org.junit.Assert.assertTrue;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Rule;
import org.junit.Test;

import pages.materia.menu.MenuSubEditorias;

import br.com.infoglobo.pages.Navegador;
import br.com.infoglobo.pages.RegraTirarScreenShot;

public class SubeditoriasNavegadorTest {
	
	private static MenuSubEditorias subeditoria;
	
	@Rule
	public RegraTirarScreenShot tirarScreenShot = new RegraTirarScreenShot(subeditoria.getDriver());
	
	@BeforeClass
	public static void antesDeCadaTeste() throws Exception {
		subeditoria = new MenuSubEditorias(Navegador.CHROME);
	}

	@AfterClass
	public static void depoisDeCadaTeste() {
		subeditoria.fechar();
	}
	
	@Test
	public void verificaSeOMenuEsquerdoDeSubeditoriasEstaExibindoAEditoriaDaMateria() {
		assertTrue(subeditoria.getEditoriaMenuEsquerdo());
	}
	
	@Ignore
	@Test
	public void verificaSeAListaDeSubeditoriasEstaoExibindoONomeDaSubeditoria() throws InterruptedException {
		assertTrue(subeditoria.exibiuNomeSubEditorias());
	}
}