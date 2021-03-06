package testes.newsletter.selecaoDosEditores;

import static org.junit.Assert.assertTrue;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Rule;
import org.junit.Test;

import pages.newsletter.selecaoDosEditores.SelecaoDosEditoresCabecalho;

import br.com.infoglobo.pages.Navegador;
import br.com.infoglobo.pages.RegraTirarScreenShot;

public class SelecaoDosEditoresCabecalhoTest {
	
	private static SelecaoDosEditoresCabecalho selecaoDosEditoresCabecalho;
	
	@Rule
	public RegraTirarScreenShot tirarScreenShot = new RegraTirarScreenShot(selecaoDosEditoresCabecalho.getDriver());
	
	@BeforeClass
	public static void antesDeCadaTeste() throws Exception {
		selecaoDosEditoresCabecalho = new SelecaoDosEditoresCabecalho(Navegador.CHROME);
	}
	
	@AfterClass
	public static void depoisDeCadaTeste() {
		selecaoDosEditoresCabecalho.fechar();
	}
	
	@Test
	public void verificaSeOLogoDoOGloboEstaSendoExibidoNoCabecalho() {
		assertTrue(selecaoDosEditoresCabecalho.exibiuOLogoDoOGloboNoCabecalho());
	}
	
	@Test
	public void verificaSeOLogoDoOGloboNoCabecalhoPossuiUmLink() {
		assertTrue(selecaoDosEditoresCabecalho.exibiuUmLinkNoLogoDoOGloboNoCabecalho());
	}
	
	@Test
	public void verificaSeOLogoDoOGloboNoCabecalhoNaoPossuiUmaBorda() {
		assertTrue(selecaoDosEditoresCabecalho.exibiuOLogoDoOGloboNoCabecalhoSemBorda());
	}
	
	@Test
	public void verificaSeAsRedesSociaisDoOGloboEstaoSendoExibidasNoCabecalho() {
		assertTrue(selecaoDosEditoresCabecalho.exibiuAsRedesSociaisDoOGloboNoCabecalho());
	}
	
	@Test
	public void verificaSeParaCadaRedeSocialExibidaAImagemEOLinkEstaoSendoExibidosCorretamente() {
		assertTrue(selecaoDosEditoresCabecalho.exibiuParaCadaRedeSocialAImagemEOLinkCorretamente());
	}
	
	@Test
	public void verificaSeParaCadaRedeSocialExibidaAImagemNaoPossuiUmaBorda() {
		assertTrue(selecaoDosEditoresCabecalho.exibiuParaCadaRedeSocialDoRodapeAImagemSemBorda());
	}
	
	@Test
	public void verificaSeOTituloSelecaoDosEditoresEstaSendoExibido() {
		assertTrue(selecaoDosEditoresCabecalho.exibiuOTituloSelecaoDosEditores());
	}
	
	@Test
	public void verificaSeADataEstaSendoExibida() {
		assertTrue(selecaoDosEditoresCabecalho.exibiuAData());
	}
	
	@Test
	public void verificaSeACorDeFundoDoHeaderEstaSendoExibida() {
		assertTrue(selecaoDosEditoresCabecalho.exibiuACorDeFundoDoHeader());
	}
}