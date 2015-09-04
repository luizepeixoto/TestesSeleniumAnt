package testes.fotogaleria;

import static org.junit.Assert.assertTrue;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import pages.fotogaleria.FotogaleriaHome;

import br.com.infoglobo.pages.Navegador;
import br.com.infoglobo.pages.OrdemExecucaoTeste;
import br.com.infoglobo.pages.OrdenadorTestes;
import br.com.infoglobo.pages.RegraTirarScreenShot;

@RunWith(OrdenadorTestes.class)
public class FotogaleriaHomePublicidadeTest {
	
	private static FotogaleriaHome fotogaleria;
	
	@Rule
	public RegraTirarScreenShot tirarScreenShot = new RegraTirarScreenShot(fotogaleria.getDriver());
	
	@BeforeClass
	public static void antesDeCadaTeste() throws Exception {
		fotogaleria = new FotogaleriaHome(Navegador.CHROME);
		fotogaleria.esperaCarregar3Segundos();
	}

	@AfterClass
	public static void depoisDeCadaTeste() {
		fotogaleria.fechar();
	}
	
	@OrdemExecucaoTeste(Ordem=1)
	@Test
	public void verificaSeOBannerSuperLeaderboardEstaSendoExibidaNoTopoDaPagina(){
		assertTrue(fotogaleria.exibiuBannerSuperLeaderboard());
	}
	
	@OrdemExecucaoTeste(Ordem=2)
	@Test
	public void verificaSeOBannerSuperLeaderboardEstaSendoExibidoComOFundoPreto(){
		assertTrue(fotogaleria.exibiuFundoPretoParaOBanner());
	}
	
	@OrdemExecucaoTeste(Ordem=3)
	@Test
	public void verificaSeOBannerDeFotogaleriaNaoEstaSendoExibido() throws InterruptedException{
		fotogaleria.executaScrollParaAparecerOTituloDeUmaPosicao(fotogaleria.acessaClasseLastFrom());
		assertTrue(fotogaleria.exibiuBanner());
	}
	
	@OrdemExecucaoTeste(Ordem=4)
	@Test
	public void verificaSeOTituloDeMaisFotogaleriasEstaSendoExibido() throws InterruptedException{
		fotogaleria.esperaCarregar(3);
		fotogaleria.executaScrollParaAparecerOTituloDeUmaPosicao(fotogaleria.acessaBoxDeUltimas());
		assertTrue(fotogaleria.exibiuLinkDeMaisFotogalerias());
	}
}