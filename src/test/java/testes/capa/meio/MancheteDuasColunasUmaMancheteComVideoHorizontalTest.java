package testes.capa.meio;

import static org.junit.Assert.assertTrue;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import pages.capa.meio.CapaMeioMancheteDuasColunasUmaMancheteComVideoHorizontal;


public class MancheteDuasColunasUmaMancheteComVideoHorizontalTest {
	
	private static CapaMeioMancheteDuasColunasUmaMancheteComVideoHorizontal colunaDoMeio;
	
	@BeforeClass
	public static void antesDeCadaTeste() throws Exception {
		colunaDoMeio = new CapaMeioMancheteDuasColunasUmaMancheteComVideoHorizontal();
	}
	
	@AfterClass
	public static void depoisDeCadaTeste() {
		colunaDoMeio.fechar();
	}
	
	@Test
	public void exibiuVideoHorizontalComoDestaqueEmMancheteDuasColunasUmaManchete(){
		assertTrue(colunaDoMeio.exibiuVideoHorizontalComoDestaqueEmMancheteDuasColunasUmaManchete());
	}	
}