package testes.capa;

import static org.junit.Assert.*;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import pages.capa.CapaCabecalho;


public class CabecalhoCentralTest {
	
	private static CapaCabecalho cabecalhoCentral;
	
	@BeforeClass
	public static void antesDeCadaTeste() throws Exception {
		cabecalhoCentral = new CapaCabecalho();
	}
	
	@AfterClass
	public static void depoisDeCadaTeste() {
		cabecalhoCentral.fechar();
	}
	
	@Test
	public void exibiuOBoxCentralDoCabecalho(){
		assertNotNull(cabecalhoCentral.exibiuOBoxCentralDoCabecalho());
	}
	
	@Test
	public void exibiuOBannerContendoOGlobo(){
		assertNotNull(cabecalhoCentral.exibiuOBannerDoCabecalho());
	}
	
	@Test
	public void exibiuUmLinkNoBannerOGlobo(){
		assertNotNull(cabecalhoCentral.exibiuUmLinkNoBanner());
	}
	
	@Test
	public void exibiuUmLinkValidoNoBannerOGlobo(){
		assertTrue(cabecalhoCentral.exibiuOLinkCorretoNoBanner());
	}
	
	@Test
	public void exibiuOTextoDePrincipiosEditoriais(){
		String tituloEsperado="Princípios Editoriais";
		assertEquals(tituloEsperado, cabecalhoCentral.exibiuPrincipioEditoriais());
	}
	
	@Test
	public void exibiuUmLinkEmPrincipiosEditoriais(){
		assertTrue(cabecalhoCentral.exibiuLinkEmPrincipioEditoriais());
	}
	
	@Test
	public void exibiuUmLinkCorretoEmPrincipiosEditoriais(){
		assertTrue(cabecalhoCentral.exibiuLinkCorretoEmPrincipioEditoriais());
	}
	
	@Test
	public void exibiuOIconeDoFacebook(){
		assertNotNull(cabecalhoCentral.exibiuOIconeFacebook());
	}
	
	@Test
	public void exibiuUmLinkNoIconeDoFacebook(){
		assertTrue(cabecalhoCentral.exibiuUmLinkNoIconeDoFacebook());
	}
	
	@Test
	public void exibiuUmLinkValidoNoIconeDoFacebook(){
		String urlEsperada="http://facebook.com/JornalOGlobo";
		assertEquals(urlEsperada, cabecalhoCentral.exibiuUmLinkValidoNoIconeDoFacebook());
	}
	
	@Test
	public void exibiuOIconeDoTwitter(){
		assertNotNull(cabecalhoCentral.exibiuOIconeTwitter());
	}
	
	@Test
	public void exibiuUmLinkNoIconeDoTwitter(){
		assertTrue(cabecalhoCentral.exibiuUmLinkNoIconeDoTwitter());
	}
	
	@Test
	public void exibiuUmLinkValidoNoIconeDoTwitter(){
		String urlEsperada="https://twitter.com/JornalOGlobo";
		assertEquals(urlEsperada, cabecalhoCentral.exibiuUmLinkValidoNoIconeDoTwitter());
	}
	
	@Test
	public void exibiuOIconeDoGooglePlus(){
		assertNotNull(cabecalhoCentral.exibiuOIconeGooglePlus());
	}
	
	@Test
	public void exibiuUmLinkNoIconeDoGooglePlus(){
		assertTrue(cabecalhoCentral.exibiuUmLinkNoIconeDoGooglePlus());
	}
	
	@Test
	public void exibiuUmLinkValidoNoIconeDoGooglePlus(){
		String urlEsperada="https://plus.google.com/u/0/+JornalOGlobo/posts";
		assertEquals(urlEsperada, cabecalhoCentral.exibiuUmLinkValidoNoIconeDoGooglePlus());
	}
	
	@Test
	public void exibiuOBannerDeAssinatura(){
		assertNotNull(cabecalhoCentral.exibiuOBannerDeAssinatura());
	}
	
	@Test
	public void exibiuUmLinkNoBannerDeAssinaturas(){
		assertTrue(cabecalhoCentral.exibiuUmLinkNoBannerDeAssinatura());
	}
	
	@Test
	public void exibiuUmLinkValidoNoBannerDeAssinatura(){
		assertTrue(cabecalhoCentral.exibiuUmLinkValidoNoBannerDeAssinatura());
	}
}
