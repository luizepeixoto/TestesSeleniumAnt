package testes.horoscopo;

import static org.junit.Assert.*;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import pages.horoscopo.HoroscopoCabecalho;


public class HoroscopoCabecalhoCentralTest {
	
	private static HoroscopoCabecalho horoscopo;
	
	@BeforeClass
	public static void antesDeCadaTeste() throws Exception {
		horoscopo = new HoroscopoCabecalho();
	}
	
	@AfterClass
	public static void depoisDeCadaTeste() {
		horoscopo.fechar();
	}
	
	@Test
	public void exibiuOBoxCentralDoCabecalho(){
		assertNotNull(horoscopo.exibiuOBoxCentralDoCabecalho());
	}
	
	@Test
	public void exibiuOBannerContendoOGlobo(){
		assertNotNull(horoscopo.exibiuOBannerDoCabecalho());
	}
	
	@Test
	public void exibiuUmLinkNoBannerOGlobo(){
		assertNotNull(horoscopo.exibiuUmLinkNoBanner());
	}
	
	@Test
	public void exibiuUmLinkValidoNoBannerOGlobo(){
		assertTrue(horoscopo.exibiuOLinkCorretoNoBanner());
	}
	
	@Test
	public void exibiuOIconeDoFacebook(){
		assertNotNull(horoscopo.exibiuOIconeFacebook());
	}
	
	@Test
	public void exibiuUmLinkNoIconeDoFacebook(){
		assertTrue(horoscopo.exibiuUmLinkNoIconeDoFacebook());
	}
	
	@Test
	public void exibiuUmLinkValidoNoIconeDoFacebook(){
		String urlEsperada="http://facebook.com/JornalOGlobo";
		assertEquals(urlEsperada, horoscopo.exibiuUmLinkValidoNoIconeDoFacebook());
	}
	
	@Test
	public void exibiuOIconeDoTwitter(){
		assertNotNull(horoscopo.exibiuOIconeTwitter());
	}
	
	@Test
	public void exibiuUmLinkNoIconeDoTwitter(){
		assertTrue(horoscopo.exibiuUmLinkNoIconeDoTwitter());
	}
	
	@Test
	public void exibiuUmLinkValidoNoIconeDoTwitter(){
		String urlEsperada="https://twitter.com/JornalOGlobo";
		assertEquals(urlEsperada, horoscopo.exibiuUmLinkValidoNoIconeDoTwitter());
	}
	
	@Test
	public void exibiuOIconeDoGooglePlus(){
		assertNotNull(horoscopo.exibiuOIconeGooglePlus());
	}
	
	@Test
	public void exibiuUmLinkNoIconeDoGooglePlus(){
		assertTrue(horoscopo.exibiuUmLinkNoIconeDoGooglePlus());
	}
	
	@Test
	public void exibiuUmLinkValidoNoIconeDoGooglePlus(){
		String urlEsperada="https://plus.google.com/u/0/+JornalOGlobo/posts";
		assertEquals(urlEsperada, horoscopo.exibiuUmLinkValidoNoIconeDoGooglePlus());
	}
	
	@Test
	public void exibiuOBannerDeAssinatura(){
		assertNotNull(horoscopo.exibiuOBannerDeAssinatura());
	}
	
	@Test
	public void exibiuUmLinkNoBannerDeAssinaturas(){
		assertTrue(horoscopo.exibiuUmLinkNoBannerDeAssinatura());
	}
	
	@Test
	public void exibiuUmLinkValidoNoBannerDeAssinatura(){
		assertTrue(horoscopo.exibiuUmLinkValidoNoBannerDeAssinatura());
	}
}
