package testes.newsletter;

import static org.junit.Assert.assertTrue;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import pages.newsletter.ConfirmacaoComErro;

import br.com.infoglobo.pages.Navegador;
import br.com.infoglobo.pages.OrdenadorTestes;
import br.com.infoglobo.pages.RegraTirarScreenShot;

@RunWith(OrdenadorTestes.class)
public class ConfirmacaoComErroTest {
	
	private static ConfirmacaoComErro confirmacaoComErro;
	
	@Rule
	public RegraTirarScreenShot tirarScreenShot = new RegraTirarScreenShot(confirmacaoComErro.getDriver());
	
	@BeforeClass
	public static void antesDeCadaTeste() throws Exception {
		confirmacaoComErro = new ConfirmacaoComErro(Navegador.CHROME);
	}
	
	@AfterClass
	public static void depoisDeCadaTeste() {
		confirmacaoComErro.fechar();
	}
	
	@Test
	public void verificaSeABarraDaGloboComEstaSendoExibida() {
		assertTrue(confirmacaoComErro.exibiuABarraDaGloboCom());
	}
	
	@Test
	public void verificaSeOMenuDoOGloboEstaSendoExibido() {
		assertTrue(confirmacaoComErro.exibiuOMenuDoOGlobo());
	}
	
	@Test
	public void verificaSeOTituloNewsLetterOGloboEstaSendoExibido() {
		assertTrue(confirmacaoComErro.exibiuOTituloNewsLetterOGlobo());
	}
	
	@Test
	public void verificaSeOTextoDeErroDeInscricaoEstaSendoExibido() {
		assertTrue(confirmacaoComErro.exibiuOTextoDeErroDeInscricao());
	}
	
	@Test
	public void verificaSeNaClasseHeadUmaBarraInferiorEstaSendoExibida() {
		assertTrue(confirmacaoComErro.exibiuUmaBarraInferiorNaClasseHead());
	}
	
	@Test
	public void verificaSeOsTextosInformativosEstaoSendoExibidos() {
		assertTrue(confirmacaoComErro.exibiuOsTextosInformativos());
	}
	
	@Test
	public void verificaSeOTextoDePrecisaDeAjudaEstaSendoExibido() {
		assertTrue(confirmacaoComErro.exibiuOTextoDePrecisaDeAjuda());
	}
	
	@Test
	public void verificaSeOTextoDePrecisaDeAjudaSoPossuiATagA() {
		assertTrue(confirmacaoComErro.exibiuApenasATagANoTextoDePrecisaDeAjuda());
	}
	
	@Test
	public void verificaSeOBannerDeAssinaturaEstaSendoExibido() {
		assertTrue(confirmacaoComErro.exibiuOBannerDeAssinatura());
	}
	
	@Test
	public void verificaSeOBannerDeAssinaturaPossuiUmLink() {
		assertTrue(confirmacaoComErro.exibiuUmLinkNoBannerDeAssinatura());
	}
	
	@Test
	public void verificaSeORodapeDoOGloboEstaSendoExibido() {
		assertTrue(confirmacaoComErro.exibiuORodapeDoOGlobo());
	}
	
	@Test
	public void verificaSeAOfertaDeRodapeNaoEstaSendoExibida() {
		assertTrue(confirmacaoComErro.naoExibiuAOfertaDeRodape());
	}
}