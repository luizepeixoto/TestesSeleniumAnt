package testes.capa.meio;

import static org.junit.Assert.*;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import pages.capa.meio.CapaMeioMancheteDuasColunasUmaMancheteFotoHorizontal;

import crops.CropsCapaColunaDoMeio;


public class MancheteDuasColunasUmaMancheteFotoHorizontalTest {
	
	private static CapaMeioMancheteDuasColunasUmaMancheteFotoHorizontal colunaDoMeio;
	
	@BeforeClass
	public static void antesDeCadaTeste() throws Exception {
		colunaDoMeio = new CapaMeioMancheteDuasColunasUmaMancheteFotoHorizontal();
	}

	@AfterClass
	public static void depoisDeCadaTeste() {
		colunaDoMeio.fechar();
	}
	
	@Test
	public void exibiuMancheteDuasColunasUmaMancheteComFotoHorizontal(){
		assertNotNull(colunaDoMeio.getBoxMancheteDuasColunasUmaManchete());
	}
	
	@Test
	public void exibiuEditoriaDaMateriaDaColunaDaEsquerda(){
		assertTrue(colunaDoMeio.exibiuEditoriaNaEsquerda());
	}
	
	@Test
	public void exibiuColunaDaEsquerda(){
		assertNotNull(colunaDoMeio.exibiuColunaDaEsquerda());
	}
	
	@Test
	public void verificaSeAMancheteHorizontalEstaExibindoUmLinkNaImagem(){
		assertTrue(colunaDoMeio.exibiuLinkNaImagemDaMancheteDuasColunasUmaManchete());
	}
	
	@Test
	public void verificaSeAMancheteHorizontalEstaExibindoUmLinkValidoNaImagem(){
		assertTrue(colunaDoMeio.exibiuLinkValidoNaImagemDaMancheteDuasColunasUmaManchete());
	}
	
	@Test
	public void verificaSeAMancheteHorizontalEstaExibindoOLinkAnimadoImagem(){
		assertTrue(colunaDoMeio.exibiuLinkAnimadoNaImagemDaMancheteDuasColunasUmaManchete());
	}
	
	@Test
	public void exibiuImagemNaMateriaDaEsquerda(){
		assertTrue(colunaDoMeio.exibiuImagemNaEsquerda());
	}
	
	@Test
	public void verficaSeOCropDaMancheteHorizontalDaColunaDaEsquerdaPossuiOCropCorreto(){
		assertTrue(colunaDoMeio.exibiuCropCorretoNaImagemNaEsquerda());
	}
	
	@Test
	public void exibiuImagemNaMateriaComWidthCorreto(){
		String widthEsperado=CropsCapaColunaDoMeio.boxDuasColunasUmaMancheteHorizontal.getWidth();
		assertEquals(widthEsperado, colunaDoMeio.getWidthDaImagemNaEsquerda());
	}
	
	@Test
	public void exibiuImagemNaMateriaComHeightCorreto(){
		String heightEsperado=CropsCapaColunaDoMeio.boxDuasColunasUmaMancheteHorizontal.getHeight();
		assertEquals(heightEsperado, colunaDoMeio.getHeightDaImagemNaEsquerda());
	}
	
	@Test
	public void exibiuEditoriaParaAMateriaNaColunaDaEsquerda(){
		assertTrue(colunaDoMeio.exibiuEditoriaDaMateriaNaEsquerda());
	}
	
	@Test
	public void exibiuTituloParaAMateriaNaColunaDaEsquerda(){
		assertTrue(colunaDoMeio.exibiuTituloNaEsquerda());
	}
	
	@Test
	public void exibiuTituloDaMateriaDaEsquerdaComNoMaximo75Caracteres(){
		assertTrue(colunaDoMeio.exibiuTituloDaEsquerdaComMaximoDeCaracteres());
	}
	
	@Test
	public void exibiuLinkNoTituloNaEsquerda(){
		assertTrue(colunaDoMeio.exibiuLinkNoTituloNaEsquerda());
	}
	
	@Test
	public void exibiuUmLinkValidoNoTituloNaEsquerda(){
		assertTrue(colunaDoMeio.exibiuLinkValidoNoTituloNaEsquerda());
	}
	
	@Test
	public void exibiuTotalDeComentariosNaMateriaDaEsquerda(){
		assertTrue(colunaDoMeio.exibiuTotalDeComentariosNaMateriaDaEsquerda());
	}
	
	@Test
	public void exibiuUmLinkNoTotalDeComentariosNaMateriaDaEsquerda(){
		assertTrue(colunaDoMeio.exibiuUmLinkNoTotalDeComentarioNaEsquerda());
	}
	
	@Test
	public void exibiuUmLinkValidoTotalDeComentariosParaAMateriaDaEsquerda(){
		assertTrue(colunaDoMeio.exibiuUmLinkValidoNoTotalDeComentarioNaEsquerda());
	}
	
	@Test
	public void exibiuColunaDaDireita(){
		assertNotNull(colunaDoMeio.exibiuColunaDaDireita());
	}
	
	@Test
	public void exibiuUmaListaDeMateriasNaDireita(){
		assertTrue(colunaDoMeio.exibiuListaDeMateriasNaDireita());
	}
	
	@Test
	public void exibiuAEditoriaParaAListaDeMateriasNaDireita(){
		assertTrue(colunaDoMeio.exibiuAEditoriaParaAListaDeMateriasNaDireita());
	}
	
	@Test
	public void exibiuTituloParaAListaDeMateriasNaDireita(){
		assertTrue(colunaDoMeio.exibiuTituloParaAListaDeMateriasNaDireita());
	}
	
	@Test
	public void exibiuTituloParaAListaDeMateriasNaDireitaComNoMaximo59Caracteres(){
		assertTrue(colunaDoMeio.exibiuTituloDaDireitaComMaximoDeCaracteres());
	}
	
	@Test
	public void exibiuLinkNoTituloParaAListaDeMateriasNaDireita(){
		assertTrue(colunaDoMeio.exibiuLinkNoTituloParaAListaDeMateriasNaDireita());
	}
	
	@Test
	public void exibiuUmLinkValidoNoTituloParaAListaDeMateriasNaDireita(){
		assertTrue(colunaDoMeio.exibiuLinkValidoNoTituloDaDireita());
	}
	
	@Test
	public void verificaSeAsMateriasDoBoxDireitaEstaoExibindoOTotalDeComentarios(){
		assertTrue(colunaDoMeio.getMancheteDuasColunasUmaMancheteBoxDireitaComentario());
	}
	
	@Test
	public void verificaSeAsMateriasDoBoxDireitaEstaoExibindoUmLinkNoTotalDeComentarios(){
		assertTrue(colunaDoMeio.getMancheteDuasColunasUmaMancheteBoxDireitaComentarioLink());
	}
	
	@Test
	public void verificaSeAsMateriasDoBoxDireitaEstaoExibindoUmLinkValidoNoTotalDeComentarios(){
		assertTrue(colunaDoMeio.getMancheteDuasColunasUmaMancheteBoxDireitaComentarioLinkValido());
	}
}