package testes.horoscopo;

import static org.junit.Assert.assertTrue;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;

import pages.horoscopo.Horoscopo;


public class HoroscopoTest {
	
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
	public void exibiuTituloDePrevisoesDeSignos(){
		assertTrue(horoscopo.exibiuTituloDePrevisoes());
	}
	
	@Test
	public void exibiuDataDasPrevisoesDosSignos(){
		assertTrue(horoscopo.exibiuData());
	}
	
	@Test
	public void exibiuDozeSignos() {
		assertTrue(horoscopo.obterQuantidadeDeSignos());
	}
	
	@Test
	public void exibiuImagemParaCadaSigno() {
		assertTrue(horoscopo.exibiuImagemParaCadaSigno());
	}
	
	@Test
	public void exibiuTituloDoSigno() {
		assertTrue(horoscopo.exibiuTituloParaCadaSigno());
	}
	
	@Test
	public void exibiuRegenteDoSigno() {
		assertTrue(horoscopo.exibiuRegenteParaCadaSigno());
	}
	
	@Ignore
	@Test
	public void exibiuDescricaoDoSigno() {
		assertTrue(horoscopo.exibiuDescricaoParaCadaSigno());
	}
	
	@Test
	public void verificaSeOBannerDeAssinaturaNaoEstaSendoExibido(){
		assertTrue("O Banner está sendo exibido. Verifique se está configurado.", horoscopo.exibiuBannerDeAssinatura());
	}
}
