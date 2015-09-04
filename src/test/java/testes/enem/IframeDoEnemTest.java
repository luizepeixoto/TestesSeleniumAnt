package testes.enem;

import static org.junit.Assert.*;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;

import pages.enem.EnemIframe;


public class IframeDoEnemTest {
	
	private static EnemIframe pagina;
	
	@BeforeClass
	public static void antesDeCadaTeste() throws Exception {
		pagina = new EnemIframe();
	}
	
	@AfterClass
	public static void depoisDeCadaTeste() {
		pagina.fechar();
	}
	
	@Test
	public void verificaSeAEditoriaEstaSendoExibida(){
		assertTrue(pagina.exibiuEditoria());
	}
	
	@Test
	public void verificaSeOIframeEstaSendoExibido(){
		assertNotNull(pagina.exibiuOIframe());
	}
	
	@Test
	public void verificaSeOIframeEstaSendoExibindoInformacoesDoColegio24Hrs(){
		assertTrue(pagina.exibiuInformacoesDoColegio24Hrs());
	}
	
	@Ignore
	@Test
	public void verificaSeOIframeEstaComOWidthCorreto(){
		String widthEsperado = "920";
		assertEquals(widthEsperado, pagina.getIframeWidth());
	}
	
	@Ignore
	@Test
	public void verificaSeOIframeEstaComOHeightCorreto(){
		String heightEsperado = "";
		assertEquals(heightEsperado, pagina.getIframeHeight());
	}
}
