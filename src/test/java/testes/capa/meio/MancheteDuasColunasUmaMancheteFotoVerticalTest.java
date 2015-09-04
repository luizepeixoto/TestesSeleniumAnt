package testes.capa.meio;

import static org.junit.Assert.*;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import pages.capa.meio.CapaMeioMancheteDuasColunasUmaMancheteFotoVertical;

import crops.CropsCapaColunaDoMeio;


public class MancheteDuasColunasUmaMancheteFotoVerticalTest {
	
	private static CapaMeioMancheteDuasColunasUmaMancheteFotoVertical colunaDoMeio;
	
	@BeforeClass
	public static void antesDeCadaTeste() throws Exception {
		colunaDoMeio = new CapaMeioMancheteDuasColunasUmaMancheteFotoVertical();
	}

	@AfterClass
	public static void depoisDeCadaTeste() {
		colunaDoMeio.fechar();
	}
	
	@Test
	public void exibiuOBoxMancheteDuasColunasUmaMancheteComFotoVertical(){
		assertNotNull(colunaDoMeio.getBoxMancheteDuasColunasUmaMancheteComFoto());
	}
	
	@Test
	public void verificaSeAMancheteDuasColunasUmaMancheteComFotoEstaExibindoAEditoria(){
		assertTrue(colunaDoMeio.getMancheteDuasColunasUmaMancheteComFotoEditoria());
	}
	
	@Test
	public void exibiuColunaDaEsquerda(){
		assertNotNull(colunaDoMeio.exibiuColunaDaEsquerda());
	}
	
	@Test
	public void exibiuLinkNaFotoDaColunaDaEsquerda(){
		assertTrue(colunaDoMeio.exibiuUmLinkNaFotoDestaque());
	}
	
	@Test
	public void exibiuUmLinkValidoNaFotoDaColunaDaEsquerda(){
		assertTrue(colunaDoMeio.exibiuUmLinkValidoNaFotoDestaque());
	}
	
	@Test
	public void exibiuUmLinkAnimadoNaFotoDaColunaDaEsquerda(){
		assertTrue(colunaDoMeio.exibiuUmLinkAnimadoNaFoto());
	}
	
	@Test
	public void exibiuFotoParaDestaqueDaColunaDaEsquerda(){
		assertTrue(colunaDoMeio.exibiuFotoNoDestaque());
	}
	
	@Test
	public void verificaSeAFotoEmDestaqueDaColunaDaEsquerdaPossuiOCropProporcionalCorreto(){
		assertTrue(colunaDoMeio.exibiuCropProporcionalCorretoParaAFotoNoDestaque());
	}
	
	@Test
	public void exibiuWidthCorretoParaAFotoEmDestaqueDaColunaDaEsquerda(){
		String widthEsperado = CropsCapaColunaDoMeio.boxDuasColunasUmaMancheteVertical.getWidth();
		assertEquals(widthEsperado, colunaDoMeio.exibiuWidthDaFotoDestaque());
	}
	
	@Test
	public void exibiuHeightCorretoParaAFotoEmDestaqueDaColunaDaEsquerda(){
		String heightEsperado = CropsCapaColunaDoMeio.boxDuasColunasUmaMancheteVertical.getHeight();
		assertEquals(heightEsperado, colunaDoMeio.exibiuHeightDaFotoDestaque());
	}
	
	@Test
	public void exibiuAEditoriaParaODestaqueDaEsquerda(){
		assertTrue(colunaDoMeio.exibiuEditoriaDoDestaque());
	}
	
	@Test
	public void verificaSeOTituloDaMateriaDoBoxEsquerdaEstaSendoExibido(){
		assertTrue(colunaDoMeio.exibiuTituloDoDestaque());
	}
	
	@Test
	public void verificaSeOTituloDaMateriaDoBoxEsquerdaComNoMaximo75Caracteres(){
		assertTrue(colunaDoMeio.exibiuTituloDoDestaqueComMaximoDe75Caracteres());
	}
	
	@Test
	public void verificaSeOTituloDaMateriaDoBoxEsquerdaPossuiUmLink(){
		assertTrue(colunaDoMeio.getMancheteDuasColunasUmaMancheteComFotoTituloLink());
	}
	
	@Test
	public void verificaSeOTituloDaMateriaDoBoxEsquerdaPossuiUmLinkValido(){
		assertTrue(colunaDoMeio.getMancheteDuasColunasUmaMancheteComFotoTituloLinkValido());
	}
	
	@Test
	public void verificaSeOTotalDeComentariosDaMateriaDoBoxEsquerdaEstaSendoExibido(){
		assertTrue(colunaDoMeio.getMancheteDuasColunasUmaMancheteComFotoComentarios());
	}
	
	@Test
	public void exibiuComentariosNaMateriaDaEsquerdaComUmLink(){
		assertTrue(colunaDoMeio.exibiuComentariosNaEsquerdaComUmLink());
	}
	
	@Test
	public void exibiuComentariosNaMateriaDaEsquerdaComUmLinkValido(){
		assertTrue(colunaDoMeio.exibiuComentariosNaEsquerdaComUmLinkValido());
	}
	
	@Test
	public void exibiuColunaDaDireita(){
		assertNotNull(colunaDoMeio.exibiuColunaDaDireita());
	}
	
	@Test
	public void verificaSeAListaDeMateriasDoBoxDireitaEhMaiorQueZero(){
		assertTrue(colunaDoMeio.getMancheteDuasColunasUmaMancheteComFotoBoxDireitaTamanho());
	}
	
	@Test
	public void exibiuFotoParaAsMateriasDaDireita(){
		assertTrue(colunaDoMeio.exibiuFotoParaAsMateriasDaDireita());
	}
	
	@Test
	public void verificaSeMateriasDaDireitaQuePossuemImagemPossuiUmLink(){
		assertTrue(colunaDoMeio.exibiuUmLinkNasFotosDasMateriasDaDireita());
	}
	
	@Test
	public void verificaSeMateriasDaDireitaQuePossuemImagemPossuiUmLinkValido(){
		assertTrue(colunaDoMeio.exibiuUmLinkValidoNasFotosDasMateriasDaDireita());
	}
	
	@Test
	public void verificaSeAsMateriasDaDireitaPossuemLinkAnimadoOpacity(){
		assertTrue(colunaDoMeio.exibiuClasseAnimadoOpacityNasFotosDasMateriasDaDireita());
	}
	
	@Test
	public void exibiuWidthCorretoParaAsFotosDaDireita(){
		assertTrue(colunaDoMeio.exibiuWidthNasFotosDasMateriasDaDireita());
	}
	
	@Test
	public void exibiuHeightCorretoParaAsFotosDaDireita(){
		assertTrue(colunaDoMeio.exibiuHeightNasFotosDasMateriasDaDireita());
	}
	
	@Test
	public void exibiuEditoriaParaAsMateriasDaDireita(){
		assertTrue(colunaDoMeio.exibiuEditoriaParaAsMateriasDaDireita());
	}
	
	@Test
	public void exibiuTituloParaAsMateriasDaDireita(){
		assertTrue(colunaDoMeio.exibiuTituloParaAsMateriasDaDireita());
	}
	
	@Test
	public void exibiuTituloParaAsMateriasDaDireitaComMaximoDeCaracteresPermitidos(){
		assertTrue(colunaDoMeio.exibiuAsMateriasDaDireitaComMaximoDeCaracteresPermitidos());
	}
	
	@Test
	public void exibiuLinkNoTituloDasMateriasDaDireita(){
		assertTrue(colunaDoMeio.exibiuLinkNoTituloDasMateriasDaDireita());
	}
	
	@Test
	public void exibiuUmLinkValidoNoTituloDasMateriasDaDireita(){
		assertTrue(colunaDoMeio.exibiuUmLinkValidoNoTituloDasMateriasDaDireita());
	}
	
	@Test
	public void exibiuTotalDeComentariosParaAsMateriasDaDireita(){
		assertTrue(colunaDoMeio.exibiuTotalDeComentarisParaAsMateriasDaDireita());
	}
	
	@Test
	public void exibiuTotalDeComentariosComUmLinkNasMateriasDaDireita(){
		assertTrue(colunaDoMeio.exibiuUmLinkNoTotalDeComentarisParaAsMateriasDaDireita());
	}
	
	@Test
	public void exibiuTotalDeComentariosComUmLinkValidoNasMateriasDaDireita(){
		assertTrue(colunaDoMeio.exibiuUmLinkValidoNoTotalDeComentarisParaAsMateriasDaDireita());
	}
}