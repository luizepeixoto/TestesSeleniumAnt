package testes.materia.capitulos;

import static org.junit.Assert.assertTrue;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import pages.materia.capitulo.MenuSuperiorSemAutor;

import br.com.infoglobo.pages.Navegador;

public class MenuSuperiorSemAutorTest {
	
	private static MenuSuperiorSemAutor materia;
	
	@BeforeClass
	public static void antesDeCadaTeste() throws Exception {
		materia = new MenuSuperiorSemAutor(Navegador.CHROME);
	}

	@AfterClass
	public static void depoisDeCadaTeste() {
		materia.fechar();
	}
	
	/*CONFIGURAÇÃO DA MATÉRIA*/
	/*Todos os capitulos sem autor*/ 
	
	@Test
	public void verificaSeOsCapitulosConfiguradosSemAutorNaoEstaoExibindoOAutor() {
		assertTrue(materia.exibiuUmAutorParaCadaCapitulo());
	}
}