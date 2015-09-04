package testes.materia.widget.generico;

import static org.junit.Assert.*;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Rule;
import org.junit.Test;

import pages.materia.widget.generico.BoxGenericoFacebookComVideo;

import br.com.infoglobo.pages.Navegador;
import br.com.infoglobo.pages.RegraTirarScreenShot;

public class BoxFacebookComVideoTest {
	
	private static BoxGenericoFacebookComVideo materia;
	
	@Rule
	public RegraTirarScreenShot tirarScreenShot = new RegraTirarScreenShot(materia.getDriver());
	
	@BeforeClass
	public static void antesDeCadaTeste() throws Exception {
		materia = new BoxGenericoFacebookComVideo(Navegador.CHROME);
		materia.esperaCarregar(2);
		materia.executarScroll(materia.acessaClasseEmbedSocial().getLocation());
	}

	@AfterClass
	public static void depoisDeCadaTeste() {
		materia.fechar();
	}
	
	@Test
	public void verificaSeOBoxComOEmbedDoFacebookComVideoEstaSendoExibidoNaPagina(){
		assertTrue(materia.exibiuBoxDoWidgetGenericoDoFacebookComVideo(materia.acessaClasseEmbedSocial()));
	}
}