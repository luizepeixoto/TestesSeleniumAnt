package testes.newsletter.urgente;

import static org.junit.Assert.assertTrue;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Rule;
import org.junit.Test;

import pages.newsletter.urgente.UrgenteCabecalho;

import br.com.infoglobo.pages.Navegador;
import br.com.infoglobo.pages.RegraTirarScreenShot;

public class UrgenteCabecalhoTest {
	
	private static UrgenteCabecalho urgenteCabecalho;
	
	@Rule
	public RegraTirarScreenShot tirarScreenShot = new RegraTirarScreenShot(urgenteCabecalho.getDriver());
	
	@BeforeClass
	public static void antesDeCadaTeste() throws Exception {
		urgenteCabecalho = new UrgenteCabecalho(Navegador.CHROME);
	}
	
	@AfterClass
	public static void depoisDeCadaTeste() {
		urgenteCabecalho.fechar();
	}
	
	@Test
	public void verificaSeOLogoDoOGloboEstaSendoExibidoNoCabecalho() {
		assertTrue(urgenteCabecalho.exibiuOLogoDoOGloboNoCabecalho());
	}
	
	@Test
	public void verificaSeOLogoDoOGloboNoCabecalhoPossuiUmLink() {
		assertTrue(urgenteCabecalho.exibiuUmLinkNoLogoDoOGloboNoCabecalho());
	}
	
	@Test
	public void verificaSeOLogoDoOGloboNoCabecalhoNaoPossuiUmaBorda() {
		assertTrue(urgenteCabecalho.exibiuOLogoDoOGloboNoCabecalhoSemBorda());
	}
	
	@Test
	public void verificaSeAsRedesSociaisDoOGloboEstaoSendoExibidasNoCabecalho() {
		assertTrue(urgenteCabecalho.exibiuAsRedesSociaisDoOGloboNoCabecalho());
	}
	
	@Test
	public void verificaSeParaCadaRedeSocialExibidaAImagemEOLinkEstaoSendoExibidosCorretamente() {
		assertTrue(urgenteCabecalho.exibiuParaCadaRedeSocialAImagemEOLinkCorretamente());
	}
	
	@Test
	public void verificaSeParaCadaRedeSocialExibidaAImagemNaoPossuiUmaBorda() {
		assertTrue(urgenteCabecalho.exibiuParaCadaRedeSocialDoRodapeAImagemSemBorda());
	}
	
	@Test
	public void verificaSeOTituloSelecaoDosEditoresEstaSendoExibido() {
		assertTrue(urgenteCabecalho.exibiuOTituloSelecaoDosEditores());
	}
	
	@Test
	public void verificaSeADataEstaSendoExibida() {
		assertTrue(urgenteCabecalho.exibiuAData());
	}
	
	@Test
	public void verificaSeAposADataUmaBarraEstaSendoExibida() {
		assertTrue(urgenteCabecalho.exibiuUmaBarraAposAData());
	}
}