package testes.newsletter;

import static org.junit.Assert.assertTrue;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import pages.newsletter.ConfirmacaoComSucesso;

import br.com.infoglobo.pages.Navegador;
import br.com.infoglobo.pages.OrdenadorTestes;
import br.com.infoglobo.pages.RegraTirarScreenShot;

@RunWith(OrdenadorTestes.class)
public class ConfirmacaoComSucessoTest {
	
	private static ConfirmacaoComSucesso confirmacaoComSucesso;
	
	@Rule
	public RegraTirarScreenShot tirarScreenShot = new RegraTirarScreenShot(confirmacaoComSucesso.getDriver());
	
	@BeforeClass
	public static void antesDeCadaTeste() throws Exception {
		confirmacaoComSucesso = new ConfirmacaoComSucesso(Navegador.CHROME);
	}
	
	@AfterClass
	public static void depoisDeCadaTeste() {
		confirmacaoComSucesso.fechar();
	}
	
	@Test
	public void verificaSeABarraDaGloboComEstaSendoExibida() {
		assertTrue(confirmacaoComSucesso.exibiuABarraDaGloboCom());
	}
	
	@Test
	public void verificaSeOMenuDoOGloboEstaSendoExibido() {
		assertTrue(confirmacaoComSucesso.exibiuOMenuDoOGlobo());
	}
	
	@Test
	public void verificaSeOTituloNewsLetterOGloboEstaSendoExibido() {
		assertTrue(confirmacaoComSucesso.exibiuOTituloNewsLetterOGlobo());
	}
	
	@Test
	public void verificaSeASetaVerdeEstaSendoExibida() {
		assertTrue(confirmacaoComSucesso.exibiuASetaVerde());
	}
	
	@Test
	public void verificaSeOTextoDeConfirmacaoDeInscricaoEstaSendoExibido() {
		assertTrue(confirmacaoComSucesso.exibiuOTextoDeConfirmacaoDeInscricao());
	}
	
	@Test
	public void verificaSeOTextoDePrincipaisNoticiasGratuitamenteEstaSendoExibido() {
		assertTrue(confirmacaoComSucesso.exibiuOTextoDePrincipaisNoticiasGratuitamente());
	}
	
	@Test
	public void verificaSeNaClasseHeadUmaBarraInferiorEstaSendoExibida() {
		assertTrue(confirmacaoComSucesso.exibiuUmaBarraInferiorNaClasseHead());
	}
	
	@Test
	public void verificaSeOsTextosInformativosEstaoSendoExibidos() {
		assertTrue(confirmacaoComSucesso.exibiuOsTextosInformativos());
	}
	
	@Test
	public void verificaSeOTextoDePrecisaDeAjudaEstaSendoExibido() {
		assertTrue(confirmacaoComSucesso.exibiuOTextoDePrecisaDeAjuda());
	}
	
	@Test
	public void verificaSeOTextoDePrecisaDeAjudaSoPossuiATagA() {
		assertTrue(confirmacaoComSucesso.exibiuApenasATagANoTextoDePrecisaDeAjuda());
	}
	
	@Test
	public void verificaSeOBannerDeAssinaturaEstaSendoExibido() {
		assertTrue(confirmacaoComSucesso.exibiuOBannerDeAssinatura());
	}
	
	@Test
	public void verificaSeOBannerDeAssinaturaPossuiUmLink() {
		assertTrue(confirmacaoComSucesso.exibiuUmLinkNoBannerDeAssinatura());
	}
	
	@Test
	public void verificaSeORodapeDoOGloboEstaSendoExibido() {
		assertTrue(confirmacaoComSucesso.exibiuORodapeDoOGlobo());
	}
	
	@Test
	public void verificaSeAOfertaDeRodapeNaoEstaSendoExibida() {
		assertTrue(confirmacaoComSucesso.naoExibiuAOfertaDeRodape());
	}
}