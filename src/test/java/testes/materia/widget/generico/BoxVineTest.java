package testes.materia.widget.generico;

import static org.junit.Assert.*;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Rule;
import org.junit.Test;

import pages.materia.widget.generico.BoxGenericoVine;

import br.com.infoglobo.pages.Navegador;
import br.com.infoglobo.pages.RegraTirarScreenShot;

public class BoxVineTest {
	
	private static BoxGenericoVine materia;
	
	@Rule
	public RegraTirarScreenShot tirarScreenShot = new RegraTirarScreenShot(materia.getDriver());
	
	@BeforeClass
	public static void antesDeCadaTeste() throws Exception {
		materia = new BoxGenericoVine(Navegador.CHROME);
		materia.esperaCarregar(2);
		materia.executarScroll(materia.acessaClasseEmbedSocial().getLocation());
	}

	@AfterClass
	public static void depoisDeCadaTeste() {
		materia.fechar();
	}
	
	@Test
	public void verificaSeOBoxComOEmbedDoVineEstaSendoExibidoNaPagina(){
		assertTrue(materia.exibiuBoxDoWidgetGenericoComVine(materia.acessaClasseEmbedSocial()));
	}
}