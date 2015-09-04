package testes.newsletter.urgente;

import static org.junit.Assert.assertTrue;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Rule;
import org.junit.Test;

import pages.newsletter.urgente.UrgenteRodape;

import br.com.infoglobo.pages.Navegador;
import br.com.infoglobo.pages.RegraTirarScreenShot;

public class UrgenteRodapeTest {
	
	private static UrgenteRodape urgenteRodape;
	
	@Rule
	public RegraTirarScreenShot tirarScreenShot = new RegraTirarScreenShot(urgenteRodape.getDriver());
	
	@BeforeClass
	public static void antesDeCadaTeste() throws Exception {
		urgenteRodape = new UrgenteRodape(Navegador.CHROME);
	}
	
	@AfterClass
	public static void depoisDeCadaTeste() {
		urgenteRodape.fechar();
	}

	@Test
	public void verificaSeOBannerNaoEstaSendoExibido() {
		assertTrue(urgenteRodape.naoExibiuOBanner());
	}
	
	@Test
	public void verificaSeABarraAntesDoFooterEstaComACorEsperada() {
		assertTrue(urgenteRodape.exibiuABarraAntesDoFooterComACorEsperada());
	}
	
	@Test
	public void verificaSeOFooterEstaSendoExibido() {
		assertTrue(urgenteRodape.exibiuOFooter());
	}
}