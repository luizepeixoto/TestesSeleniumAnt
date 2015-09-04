package testes.newsletter.destaquesDoDia;

import static org.junit.Assert.assertTrue;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Rule;
import org.junit.Test;

import pages.newsletter.destaquesDoDia.DestaquesDoDiaRodape;

import br.com.infoglobo.pages.Navegador;
import br.com.infoglobo.pages.RegraTirarScreenShot;

public class DestaquesDoDiaRodapeTest {
	
	private static DestaquesDoDiaRodape destaquesDoDiaRodape;
	
	@Rule
	public RegraTirarScreenShot tirarScreenShot = new RegraTirarScreenShot(destaquesDoDiaRodape.getDriver());
	
	@BeforeClass
	public static void antesDeCadaTeste() throws Exception {
		destaquesDoDiaRodape = new DestaquesDoDiaRodape(Navegador.CHROME);
	}
	
	@AfterClass
	public static void depoisDeCadaTeste() {
		destaquesDoDiaRodape.fechar();
	}
	
	@Test
	public void verificaSeAOpcaoReceberNewsletterNaoEstaSendoExibida() {
		assertTrue(destaquesDoDiaRodape.naoExibiuAOpcaoReceberNewsletter());
	}
	
	@Ignore //teste ignorado pois ainda não existe a tela de cardápio
	@Test
	public void verificaSeAOpcaoReceberNewsletterDiariaPossuiUmIconeDeLinkExterno() {
		assertTrue(destaquesDoDiaRodape.exibiuUmIconeDeLinkExternoNaOpcaoReceberNewsletterDiaria());
	}
	
	@Ignore //teste ignorado pois ainda não existe a tela de cardápio
	@Test
	public void verificaSeOIconeDeLinkExternoDaOpcaoReceberNewsletterDiariaNaoPossuiUmaBorda() {
		assertTrue(destaquesDoDiaRodape.exibiuOIconeDeLinkExternoDaOpcaoReceberNewsletterDiariaSemBorda());
	}
	
	@Test
	public void verificaSeOBannerEstaSendoExibido() {
		assertTrue(destaquesDoDiaRodape.exibiuOBanner());
	}
	
	@Test
	public void verificaSeOBannerEstaComOEstiloCorreto() {
		assertTrue(destaquesDoDiaRodape.exibiuOBannerComOEstiloCorreto());
	}
	
	@Test
	public void verificaSeOBannerPossuiUmLink() {
		assertTrue(destaquesDoDiaRodape.exibiuUmLinkNoBanner());
	}
	
	@Test
	public void verificaSeOBannerNaoPossuiUmaBorda() {
		assertTrue(destaquesDoDiaRodape.exibiuOBannerSemBorda());
	}
	
	@Test
	public void verificaSeOLogoDoOGloboEstaSendoExibidoNoRodape() {
		assertTrue(destaquesDoDiaRodape.exibiuOLogoDoOGloboNoRodape());
	}
	
	@Test
	public void verificaSeOLogoDoOGloboNoRodapePossuiUmLink() {
		assertTrue(destaquesDoDiaRodape.exibiuUmLinkNoLogoDoOGloboNoRodape());
	}
	
	@Test
	public void verificaSeOLogoDoOGloboNoRodapeNaoPossuiUmaBorda() {
		assertTrue(destaquesDoDiaRodape.exibiuOLogoDoOGloboNoRodapeSemBorda());
	}
	
	@Test
	public void verificaSeAsRedesSociaisDoOGloboEstaoSendoExibidasNoRodape() {
		assertTrue(destaquesDoDiaRodape.exibiuAsRedesSociaisDoOGloboNoRodape());
	}
	
	@Test
	public void verificaSeParaCadaRedeSocialExibidaAImagemEOLinkEstaoSendoExibidosCorretamente() {
		assertTrue(destaquesDoDiaRodape.exibiuParaCadaRedeSocialDoRodapeAImagemEOLinkCorretamente());
	}
	
	@Test
	public void verificaSeParaCadaRedeSocialExibidaAImagemNaoPossuiUmaBorda() {
		assertTrue(destaquesDoDiaRodape.exibiuParaCadaRedeSocialDoRodapeAImagemSemBorda());
	}

	@Test
	public void verificaSeOFooterEstaSendoExibido() {
		assertTrue(destaquesDoDiaRodape.exibiuOFooter());
	}
}