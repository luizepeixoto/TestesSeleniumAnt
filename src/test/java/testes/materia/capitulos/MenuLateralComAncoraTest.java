package testes.materia.capitulos;

import static org.junit.Assert.assertTrue;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Rule;
import org.junit.Test;

import pages.materia.capitulo.MenuLateralComAncora;

import br.com.infoglobo.pages.Navegador;
import br.com.infoglobo.pages.RegraTirarScreenShot;

public class MenuLateralComAncoraTest {
	
	private static MenuLateralComAncora materiaEmCapitulo;
	
	@Rule
	public RegraTirarScreenShot tirarScreenShot = new RegraTirarScreenShot(materiaEmCapitulo.getDriver());
	
	@BeforeClass
	public static void antesDeCadaTeste() throws Exception {
		materiaEmCapitulo = new MenuLateralComAncora(Navegador.CHROME);
	}

	@AfterClass
	public static void depoisDeCadaTeste() {
		materiaEmCapitulo.fechar();
	}
	
	/*A âncora será passada para o terceiro capítulo*/
	
	@Test
	public void verificaSeOCapituloSelecionadoPelaAncoraEstaAparecendoComoAtivaAoCarregarAMateria() {
		assertTrue(materiaEmCapitulo.exibiuAClasseDaAncoraComoAtiva());
	}
}