package testes.capa.esquerda;

import static org.junit.Assert.*;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import pages.capa.esquerda.ChamadaConteudoComVideo;


public class ChamadaConteudoComVideoTest {
	
	private static ChamadaConteudoComVideo chamadaConteudoComVideo;
	
	@BeforeClass
	public static void antesDeCadaTeste() throws Exception {
		chamadaConteudoComVideo = new ChamadaConteudoComVideo();
	}

	@AfterClass
	public static void depoisDeCadaTeste() {
		chamadaConteudoComVideo.fechar();
	}
	
	@Test
	public void exibiuVideoComoDestaque(){
		assertTrue(chamadaConteudoComVideo.exibiuVideoComoDestaque());
	}
}
