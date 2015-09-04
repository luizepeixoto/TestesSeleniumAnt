package testes.destaquesSemiAutomaticos;

import static org.junit.Assert.*;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import pages.destaques.DestaquesTopicoAutomatico;

public class DestaqueTopicoAutomaticoTest {
	
	private static DestaquesTopicoAutomatico destaque;
	
	@BeforeClass
	public static void antesDeCadaTeste() throws Exception {
		destaque = new DestaquesTopicoAutomatico();
	}

	@AfterClass
	public static void depoisDeCadaTeste() {
		destaque.fechar();
	}
	
	@Test
	public void exibiuTituloDoTopicoNoTopoDaPaginaDeUltimas(){
		assertTrue(destaque.exibiuTituloDoTopico());
	}
	
	@Test
	public void exibiuAChamadaDoTituloMaisDeLogoAbaixoDosDestaques(){
		assertTrue(destaque.exibiuAChamadaDoTituloMaisDe());
	}
	
	@Test
	public void exibiuAPalavraTopicoNaoEstaSendoExibidaJuntoDoTituloMaisDe(){
		assertTrue(destaque.exibiuTituloMaisDeComAPalavraTopico());
	}
	
	@Test
	public void exibiuONomeDoTopicoJuntoDoTituloMaisDe(){
		assertTrue(destaque.exibiuTituloDoTopicoAposOTituloDeMaisDe());
	}
	
	@Test
	public void exibiuBannerHalfPage(){
		assertTrue(destaque.exibiuBannerHalfPage());
	}
	
	@Test
	public void exibiuONomePublicidadeAcimaDoBannerHalfPage(){
		assertEquals("Publicidade",destaque.exibiuNomePublicidade());
	}
}