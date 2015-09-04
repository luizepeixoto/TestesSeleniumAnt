package testes.fotogaleria;

import static org.junit.Assert.assertTrue;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Rule;
import org.junit.Test;

import pages.fotogaleria.Fotogaleria;

import br.com.infoglobo.pages.Navegador;
import br.com.infoglobo.pages.RegraTirarScreenShot;

public class FotogaleriaPublicidadeTest {
	
	private static Fotogaleria fotogaleria;
	
	@Rule
	public RegraTirarScreenShot tirarScreenShot = new RegraTirarScreenShot(fotogaleria.getDriver());
	
	@BeforeClass
	public static void antesDeCadaTeste() throws Exception {
		fotogaleria = new Fotogaleria(Navegador.CHROME);
		fotogaleria.esperaCarregar3Segundos();
	}

	@AfterClass
	public static void depoisDeCadaTeste() {
		fotogaleria.fechar();
	}
	
	@Test
	public void verificaSeOBannerSuperLeaderboardEstaSendoExibidaNoTopoDaPagina(){
		assertTrue(fotogaleria.exibiuBannerSuperLeaderboard());
	}
	
	@Test
	public void verificaSeOBannerSuperLeaderboardEstaSendoExibidoComOFundoPreto(){
		assertTrue(fotogaleria.exibiuFundoPretoParaOBanner());
	}
}