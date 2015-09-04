package testes.ela.materia.widget;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Rule;
import org.junit.Test;

import pages.ela.materia.widget.BoxTwitterEmbeddedEla;

import br.com.infoglobo.pages.Navegador;
import br.com.infoglobo.pages.RegraTirarScreenShot;

public class BoxTwitterEmbeddedElaTest {
	
	private static BoxTwitterEmbeddedEla twitterEmbedded;
	
	@Rule
	public RegraTirarScreenShot tirarScreenShot = new RegraTirarScreenShot(twitterEmbedded.getDriver());
	
	@BeforeClass
	public static void antesDeCadaTeste() throws Exception {
		twitterEmbedded = new BoxTwitterEmbeddedEla(Navegador.CHROME);
		twitterEmbedded.executaScrollParaAparecerOTituloDeUmaPosicao(twitterEmbedded.getBoxTwitter());
	}

	@AfterClass
	public static void depoisDeCadaTeste() {
		twitterEmbedded.fechar();
	}
	
	@Test
	public void verificaSeOBoxDoTwitterEmbedSendoExibidoNaMateria(){
		assertNotNull("Erro",twitterEmbedded.getBoxTwitter());
	}
	
	@Test
	public void verificaSeOConteudoEmbedDoTwitterEstaSendoExibido(){
		assertTrue("Erro",twitterEmbedded.getBoxTwitterInformacao());
	}
}