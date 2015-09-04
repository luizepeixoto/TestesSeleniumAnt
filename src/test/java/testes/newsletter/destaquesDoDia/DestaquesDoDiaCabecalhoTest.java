package testes.newsletter.destaquesDoDia;

import static org.junit.Assert.assertTrue;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Rule;
import org.junit.Test;

import pages.newsletter.destaquesDoDia.DestaquesDoDiaCabecalho;

import br.com.infoglobo.pages.Navegador;
import br.com.infoglobo.pages.RegraTirarScreenShot;

public class DestaquesDoDiaCabecalhoTest {
	
	private static DestaquesDoDiaCabecalho destaquesDoDiaTopo;
	
	@Rule
	public RegraTirarScreenShot tirarScreenShot = new RegraTirarScreenShot(destaquesDoDiaTopo.getDriver());
	
	@BeforeClass
	public static void antesDeCadaTeste() throws Exception {
		destaquesDoDiaTopo = new DestaquesDoDiaCabecalho(Navegador.CHROME);
	}
	
	@AfterClass
	public static void depoisDeCadaTeste() {
		destaquesDoDiaTopo.fechar();
	}
	
	@Test
	public void verificaSeOLogoDoOGloboEstaSendoExibidoNoCabecalho() {
		assertTrue(destaquesDoDiaTopo.exibiuOLogoDoOGloboNoCabecalho());
	}
	
	@Test
	public void verificaSeOLogoDoOGloboNoCabecalhoPossuiUmLink() {
		assertTrue(destaquesDoDiaTopo.exibiuUmLinkNoLogoDoOGloboNoCabecalho());
	}
	
	@Test
	public void verificaSeOLogoDoOGloboNoCabecalhoNaoPossuiUmaBorda() {
		assertTrue(destaquesDoDiaTopo.exibiuOLogoDoOGloboNoCabecalhoSemBorda());
	}
	
	@Test
	public void verificaSeAsRedesSociaisDoOGloboEstaoSendoExibidasNoCabecalho() {
		assertTrue(destaquesDoDiaTopo.exibiuAsRedesSociaisDoOGloboNoCabecalho());
	}
	
	@Test
	public void verificaSeParaCadaRedeSocialExibidaAImagemEOLinkEstaoSendoExibidosCorretamente() {
		assertTrue(destaquesDoDiaTopo.exibiuParaCadaRedeSocialAImagemEOLinkCorretamente());
	}
	
	@Test
	public void verificaSeParaCadaRedeSocialExibidaAImagemNaoPossuiUmaBorda() {
		assertTrue(destaquesDoDiaTopo.exibiuParaCadaRedeSocialDoRodapeAImagemSemBorda());
	}
	
	@Test
	public void verificaSeOTituloDestaquesDoDiaEstaSendoExibido() {
		assertTrue(destaquesDoDiaTopo.exibiuOTituloDestaquesDoDia());
	}
	
	@Test
	public void verificaSeADataEstaSendoExibida() {
		assertTrue(destaquesDoDiaTopo.exibiuAData());
	}
	
	@Test
	public void verificaSeACorDeFundoDoHeaderEstaSendoExibida() {
		assertTrue(destaquesDoDiaTopo.exibiuACorDeFundoDoHeader());
	}
}