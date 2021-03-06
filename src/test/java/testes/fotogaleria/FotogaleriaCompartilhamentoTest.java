package testes.fotogaleria;

import static org.junit.Assert.assertTrue;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Rule;
import org.junit.Test;

import pages.fotogaleria.FotogaleriaCompartilhamento;

import br.com.infoglobo.pages.Navegador;
import br.com.infoglobo.pages.RegraTirarScreenShot;

public class FotogaleriaCompartilhamentoTest {
	
	private static FotogaleriaCompartilhamento fotogaleria;
	
	@Rule
	public RegraTirarScreenShot tirarScreenShot = new RegraTirarScreenShot(fotogaleria.getDriver());
	
	@BeforeClass
	public static void antesDeCadaTeste() throws Exception {
		fotogaleria = new FotogaleriaCompartilhamento(Navegador.CHROME);
		fotogaleria.esperaCarregar(3);
		fotogaleria.executarScroll(fotogaleria.acessaTitulo.getLocation());
	}

	@AfterClass
	public static void depoisDeCadaTeste() {
		fotogaleria.fechar();
	}
	
	@Test
	public void verificaSeParaCadaFotoEstaSendoExibidaAsRedesSociais() throws InterruptedException{
		assertTrue(fotogaleria.exibiuRedesSociais());
	}
	
//	@Test
//	public void verificaSeParaCadaFotoEstaSendoExibidoACorDasRedesSociais() throws InterruptedException{
//		assertTrue(fotogaleria.exibiuACorDasRedesSociais());
//	}
	
//	@Test
//	public void verificaSeParaCadaFotoContemLinkValidoParaCadaRedeSocial() throws InterruptedException{
//		assertTrue(fotogaleria.exibiuLinkValido());
//	}
//	
//	@Test
//	public void verificaSeParaCadaFotoContemLinkComTargetBlankParaCadaRedeSocial() throws InterruptedException{
//		assertTrue(fotogaleria.contemLinkComTargetBlank());
//	}
}