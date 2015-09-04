package testes.materia.widget.generico;

import static org.junit.Assert.assertTrue;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Rule;
import org.junit.Test;

import pages.materia.widget.generico.BoxGenericoDailymotion;

import br.com.infoglobo.pages.Navegador;
import br.com.infoglobo.pages.RegraTirarScreenShot;

public class BoxDailymotionTest {
	
	private static BoxGenericoDailymotion materia;
	
	@Rule
	public RegraTirarScreenShot tirarScreenShot = new RegraTirarScreenShot(materia.getDriver());
	
	@BeforeClass
	public static void antesDeCadaTeste() throws Exception {
		materia = new BoxGenericoDailymotion(Navegador.CHROME);
		materia.esperaCarregar(2);
		materia.executarScroll(materia.acessaDailyMotion().getLocation());
	}

	@AfterClass
	public static void depoisDeCadaTeste() {
		materia.fechar();
	}
	
	@Test
	public void verificaSeOBoxComOEmbedDoDailyMotionEstaSendoExibidoNaPagina(){
		assertTrue(materia.exibiuBoxDoWidgetGenericoComDailymotion(materia.acessaDailyMotion()));
	}
}