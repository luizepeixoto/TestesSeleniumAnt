package testes.newsletter;

import static org.junit.Assert.assertTrue;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Rule;
import org.junit.Test;

import pages.newsletter.NewsletterCardapio;

import br.com.infoglobo.pages.Navegador;
import br.com.infoglobo.pages.RegraTirarScreenShot;

public class CardapioTest {
	
	private static NewsletterCardapio newsletter;
	
	@Rule
	public RegraTirarScreenShot tirarScreenShot = new RegraTirarScreenShot(newsletter.getDriver());
	
	@BeforeClass
	public static void antesDeCadaTeste() throws Exception {
		newsletter = new NewsletterCardapio(Navegador.CHROME);
	}
	
	@AfterClass
	public static void depoisDeCadaTeste() {
		newsletter.fechar();
	}
	
	@Test
	public void verificaSeOTituloEADescricaoDaPaginaDeNewsLetterEstaoSendoExibidos() {
		assertTrue(newsletter.exibiuOTituloEDescricaoNoTopoDaPagina());
	}
	
	
}