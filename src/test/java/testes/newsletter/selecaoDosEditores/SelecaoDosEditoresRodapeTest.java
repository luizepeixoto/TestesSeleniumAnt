package testes.newsletter.selecaoDosEditores;

import static org.junit.Assert.assertTrue;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Rule;
import org.junit.Test;

import pages.newsletter.selecaoDosEditores.SelecaoDosEditoresRodape;

import br.com.infoglobo.pages.Navegador;
import br.com.infoglobo.pages.RegraTirarScreenShot;

public class SelecaoDosEditoresRodapeTest {
	
	private static SelecaoDosEditoresRodape selecaoDosEditoresRodape;
	
	@Rule
	public RegraTirarScreenShot tirarScreenShot = new RegraTirarScreenShot(selecaoDosEditoresRodape.getDriver());
	
	@BeforeClass
	public static void antesDeCadaTeste() throws Exception {
		selecaoDosEditoresRodape = new SelecaoDosEditoresRodape(Navegador.CHROME);
	}
	
	@AfterClass
	public static void depoisDeCadaTeste() {
		selecaoDosEditoresRodape.fechar();
	}
	
	@Test
	public void verificaSeAOpcaoReceberNewsletterDiariaNaoEstaSendoExibida() {
		assertTrue(selecaoDosEditoresRodape.naoExibiuAOpcaoReceberNewsletter());
	}
	
	@Ignore //teste ignorado pois ainda não existe a tela de cardápio
	@Test
	public void verificaSeAOpcaoReceberNewsletterDiariaPossuiUmIconeDeLinkExterno() {
		assertTrue(selecaoDosEditoresRodape.exibiuUmIconeDeLinkExternoNaOpcaoReceberNewsletterDiaria());
	}
	
	@Ignore //teste ignorado pois ainda não existe a tela de cardápio
	@Test
	public void verificaSeOIconeDeLinkExternoDaOpcaoReceberNewsletterDiariaNaoPossuiUmaBorda() {
		assertTrue(selecaoDosEditoresRodape.exibiuOIconeDeLinkExternoDaOpcaoReceberNewsletterDiariaSemBorda());
	}
	
	@Test
	public void verificaSeOBannerEstaSendoExibido() {
		assertTrue(selecaoDosEditoresRodape.exibiuOBanner());
	}
	
	@Test
	public void verificaSeOBannerEstaComOEstiloCorreto() {
		assertTrue(selecaoDosEditoresRodape.exibiuOBannerComOEstiloCorreto());
	}
	
	@Test
	public void verificaSeOBannerPossuiUmLink() {
		assertTrue(selecaoDosEditoresRodape.exibiuUmLinkNoBanner());
	}
	
	@Test
	public void verificaSeOBannerNaoPossuiUmaBorda() {
		assertTrue(selecaoDosEditoresRodape.exibiuOBannerSemBorda());
	}
	
	@Test
	public void verificaSeOLogoDoOGloboEstaSendoExibidoNoRodape() {
		assertTrue(selecaoDosEditoresRodape.exibiuOLogoDoOGloboNoRodape());
	}
	
	@Test
	public void verificaSeOLogoDoOGloboNoRodapePossuiUmLink() {
		assertTrue(selecaoDosEditoresRodape.exibiuUmLinkNoLogoDoOGloboNoRodape());
	}
	
	@Test
	public void verificaSeOLogoDoOGloboNoRodapeNaoPossuiUmaBorda() {
		assertTrue(selecaoDosEditoresRodape.exibiuOLogoDoOGloboNoRodapeSemBorda());
	}
	
	@Test
	public void verificaSeAsRedesSociaisDoOGloboEstaoSendoExibidasNoRodape() {
		assertTrue(selecaoDosEditoresRodape.exibiuAsRedesSociaisDoOGloboNoRodape());
	}
	
	@Test
	public void verificaSeParaCadaRedeSocialExibidaAImagemEOLinkEstaoSendoExibidosCorretamente() {
		assertTrue(selecaoDosEditoresRodape.exibiuParaCadaRedeSocialDoRodapeAImagemEOLinkCorretamente());
	}
	
	@Test
	public void verificaSeParaCadaRedeSocialExibidaAImagemNaoPossuiUmaBorda() {
		assertTrue(selecaoDosEditoresRodape.exibiuParaCadaRedeSocialDoRodapeAImagemSemBorda());
	}

	@Test
	public void verificaSeOFooterEstaSendoExibido() {
		assertTrue(selecaoDosEditoresRodape.exibiuOFooter());
	}
}