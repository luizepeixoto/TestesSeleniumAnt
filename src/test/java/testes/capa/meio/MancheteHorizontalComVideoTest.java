package testes.capa.meio;

import static org.junit.Assert.assertTrue;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import pages.capa.meio.CapaMeioMancheteHorizontalComVideo;


public class MancheteHorizontalComVideoTest {
	
	private static CapaMeioMancheteHorizontalComVideo colunaDoMeio;
	
	@BeforeClass
	public static void antesDeCadaTeste() throws Exception {
		colunaDoMeio = new CapaMeioMancheteHorizontalComVideo();
	}
	
	@AfterClass
	public static void depoisDeCadaTeste() {
		colunaDoMeio.fechar();
	}
	
	@Test
	public void exibiuVideoComoDestaqueMancheteHorizontal(){
		assertTrue(colunaDoMeio.exibiuVideoComoDestaqueMancheteHorizontal());
	}	
}