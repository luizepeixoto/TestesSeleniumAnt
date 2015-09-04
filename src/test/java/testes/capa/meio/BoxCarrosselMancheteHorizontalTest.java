package testes.capa.meio;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import pages.capa.meio.BoxCarrosselMancheteHorizontal;


public class BoxCarrosselMancheteHorizontalTest {
	
	private static BoxCarrosselMancheteHorizontal colunaDoMeio;
	
	@BeforeClass
	public static void antesDeCadaTeste() throws Exception {
		colunaDoMeio = new BoxCarrosselMancheteHorizontal();
	}
	
	@AfterClass
	public static void depoisDeCadaTeste() {
		colunaDoMeio.fechar();
	}
	
	@Test
	public void exibiuBoxCarrossel(){
		assertNotNull(colunaDoMeio.exibiuCarrossel());
	}
	
	@Test
	public void exibiuFotosNoCarrossel(){
		assertTrue(colunaDoMeio.exibiuFotos());
	}
	
	@Test
	public void exibiuUmAltparaCadaFotoNoCarrossel(){
		assertTrue(colunaDoMeio.exibiuAltNasFotos());
	}
	
	@Test
	public void exibiuMaisDeUmaFotoNoCarrossel(){
		assertTrue(colunaDoMeio.exibiuMaisDeUmaFoto());
	}
	
	@Test
	public void exibiuUmLinkParaCadaFoto(){
		assertTrue(colunaDoMeio.exibiuLinkParaCadaFoto());
	}
	
	@Test
	public void exibiuUmLinkValidoParaCadaFoto(){
		assertTrue(colunaDoMeio.exibiuLinkValidoParaCadaFoto());
	}
	
	@Test
	public void verificaSeAsImagensDoCarrosselEstaoApresenandoOCropProporcionalCorreto(){
		assertTrue(colunaDoMeio.exibiuCropCorretoParaAsImagensDoCarrossel());
	}
	
	@Test
	public void verificaSeAsImagensDoCarrosselEstaoExibindoOWidthCorreto(){
		assertTrue(colunaDoMeio.exibiuWidthCorretoParaAsImagensDoCarrossel());
	}
	
	@Test
	public void verificaSeAsImagensDoCarrosselEstaoExibindoOHeightCorreto(){
		assertTrue(colunaDoMeio.exibiuHeightCorretoParaAsImagensDoCarrossel());
	}
	
	@Test
	public void exibiuTitulo(){
		assertTrue(colunaDoMeio.exibiuTitulo());
	}
	
	@Test
	public void exibiuUmLinkNoTitulo(){
		assertTrue(colunaDoMeio.exibiuUmLinkNoTitulo());
	}
	
	@Test
	public void exibiuUmLinkValidoNoTitulo(){
		assertTrue(colunaDoMeio.exibiuUmLinkValidoNoTitulo());
	}
	
	@Test
	public void exibiuDescricao(){
		assertTrue(colunaDoMeio.exibiuDescricao());
	}
	
	@Test
	public void exibiuUmLink(){
		assertTrue(colunaDoMeio.exibiuLink());
	}
	
	@Test
	public void exibiuOLinkComUmTexto(){
		assertTrue(colunaDoMeio.exibiuTextoNoLink());
	}
	
	@Test
	public void exibiuUmLinkValidoNoTexto(){
		assertTrue(colunaDoMeio.exibiuLinkValido());
	}
	
	@Test
	public void exibiuBoxDeNavegacao(){
		assertNotNull(colunaDoMeio.exibiuNavegacao());
	}
	
	@Test
	public void verificaSeOTotalDeFotosEstaSendoExibido(){
		assertTrue(colunaDoMeio.exibiuTotalDeFotos());
	}
	
	@Test
	public void exibiuSetaDeNavegacaoParaDireitaDesativada(){
		assertTrue(colunaDoMeio.exibiuNavegacaoParaDireitaDesativada());
	}
	
	@Test
	public void exibiuSetaDeNavegacaoParaEsquerda(){
		assertTrue(colunaDoMeio.exibiuNavegacaoParaEsquerda());
	}
}