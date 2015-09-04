package testes.capa;

import static org.junit.Assert.*;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Rule;
import org.junit.Test;

import pages.capa.CapaCabecalhoPublicidade;

import br.com.infoglobo.pages.Navegador;
import br.com.infoglobo.pages.RegraTirarScreenShot;

public class CabecalhoPublicidadeTest {
	
	private static CapaCabecalhoPublicidade publicidade;
	
	@Rule
	public RegraTirarScreenShot tirarScreenShot = new RegraTirarScreenShot(publicidade.getDriver());
	
	@BeforeClass
	public static void antesDeCadaTeste() throws Exception {
		publicidade = new CapaCabecalhoPublicidade(Navegador.CHROME);
	}
	
	@AfterClass
	public static void depoisDeCadaTeste() {
		publicidade.fechar();
	}
	
	@Test
	public void verificaSeOBannerSuperLeaderboardEstaSendoExibidoNoTopoDapagina(){
		assertTrue(publicidade.exibiuBannerSuperLeaderboard());
	}

	@Test
	public void verificaSeOSuperLeaderboardPossuiOTituloPublicidadeAcimaDoBanner() throws InterruptedException{
		String tituloEsperado = "PUBLICIDADE";
		assertEquals(tituloEsperado, publicidade.exibiuTituloPropaganda());
	}
	
	@Test
	public void verificaSeOTituloPropagandaAcimaDoSuperLeaderboardPossuiUmLink(){
		assertTrue(publicidade.exibiuTituloPropagandaComUmlink());
	}
	
	@Test
	public void verificaSeOTituloPropagandaAcimaDoSuperLeaderboardPossuiUmLinkValido(){
		assertTrue(publicidade.exibiuUmLinkValidoNoTituloPropaganda());
	}
	
	@Test
	public void verificaSeOLinkDoTituloPropagandaAcimaDoSuperLeaderboardEstaAbrindoNumaNovaJanela(){
		assertTrue(publicidade.exibiuOLinkDoTituloPropagandaNumaNovaJanela());
	}
}
