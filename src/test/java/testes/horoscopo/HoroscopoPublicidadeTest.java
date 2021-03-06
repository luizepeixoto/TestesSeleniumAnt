package testes.horoscopo;

import static org.junit.Assert.*;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;

import pages.horoscopo.Horoscopo;


public class HoroscopoPublicidadeTest {
	
private static Horoscopo horoscopo;
	
	@BeforeClass
	public static void BeforeClass() throws Exception {
		horoscopo = new Horoscopo();
	}
	
	@AfterClass
	public static void depoisDeCadaTeste() {
		horoscopo.fechar();
	}
	
	@Test
	public void exibiuBoxDePublicidade(){
		assertNotNull(horoscopo.exibiuPublicidade());
	}
	
	@Ignore
	@Test
	public void exibiuTituloPublicidade(){
		assertTrue(horoscopo.exibiuTituloPublicidade());
	}
	
	@Test
	public void exibiuConteudoDentroDoBoxDePublicidade(){
		assertNotNull(horoscopo.exibiuConteudoPublicidade());
	}
}
