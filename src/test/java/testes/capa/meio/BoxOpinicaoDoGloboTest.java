package testes.capa.meio;

import static org.junit.Assert.*;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import pages.capa.meio.BoxOpiniao;


public class BoxOpinicaoDoGloboTest {
	
	private static BoxOpiniao colunaDoMeio;
	
	@BeforeClass
	public static void antesDeCadaTeste() throws Exception {
		colunaDoMeio = new BoxOpiniao();
	}

	@AfterClass
	public static void depoisDeCadaTeste() {
		colunaDoMeio.fechar();
	}
	
	@Test
	public void verificaSeOBoxDeOpiniaoDoGloboEstaSendoExibidoNaColunaDoMeio(){
		assertNotNull(colunaDoMeio.exibiuOBoxDeOpiniaoDoGlobo());
	}
	
	@Test
	public void verificaSeOTituloDoBoxOpiniaoDoGloboEstaSendoExibido(){
		assertTrue(colunaDoMeio.exibiuOTituloOpiniaoDoGlobo());
	}
	
	@Test
	public void verificaSeOTituloDoBoxDeOpiniaoDoGloboPossuiUmLink(){
		assertTrue(colunaDoMeio.exibiuUmLinkParaOTituloDeOpinioes());
	}
	
	@Test
	public void verificaSeOLinkNoTituloDoBoxDeOpiniaoDoGloboEstaCorreto(){
		assertTrue(colunaDoMeio.oLinkNoTituloDeOpinioesEstaCorreto());
	}
	
	@Test
	public void verificaSeOBoxDeOpiniaoDoGloboEstaExibindoUmaListaDeOpinioes(){
		assertTrue(colunaDoMeio.exibiuAsOpinioes());
	}
	
	@Test
	public void verificaSeAsOpinioesEstaoExibindoOAntititulo(){
		assertTrue(colunaDoMeio.exibiuOsAntititulosDasOpinioes());
	}
	
	@Test
	public void verificaSeOTextoDasOpinioesPossuemUmLink(){
		assertTrue(colunaDoMeio.exibiuOLinkNasOpinioes());
	}
	
	@Test
	public void verificaSeOsLinksDasOpinioesSaoValidos(){
		assertTrue(colunaDoMeio.oLinkDaOpiniaoEhValido());
	}
	
	@Test
	public void verificaSeAsOpinioesEstaoExibindoOTexto(){
		assertTrue(colunaDoMeio.exibiuOsTextoDasOpinioes());
	}
	
	@Test
	public void verificaSeAsOpinioesEstaoExibindoOAutor(){
		assertTrue(colunaDoMeio.exibiuOsAutoresDasOpinioes());
	}
	
	@Test
	public void verificaSeOsAntititulosDoBoxDeOpinioesNãoPossuemLink(){
		assertTrue(colunaDoMeio.exibiuLinkParaOsAntititulos());
	}
}