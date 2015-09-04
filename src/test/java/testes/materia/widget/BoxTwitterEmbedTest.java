package testes.materia.widget;

import static org.junit.Assert.*;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Rule;
import org.junit.Test;

import pages.materia.widget.BoxTwitterEmbed;

import br.com.infoglobo.pages.Navegador;
import br.com.infoglobo.pages.RegraTirarScreenShot;

public class BoxTwitterEmbedTest {
	
	private static BoxTwitterEmbed twitterEmbedded;
	
	@Rule
	public RegraTirarScreenShot tirarScreenShot = new RegraTirarScreenShot(twitterEmbedded.getDriver());
	
	@BeforeClass
	public static void antesDeCadaTeste() throws Exception {
		twitterEmbedded = new BoxTwitterEmbed(Navegador.CHROME);
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