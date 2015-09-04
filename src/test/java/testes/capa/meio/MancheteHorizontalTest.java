package testes.capa.meio;

import static org.junit.Assert.*;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import pages.capa.meio.CapaMeioMancheteHorizontal;


public class MancheteHorizontalTest {
	
	private static CapaMeioMancheteHorizontal colunaDoMeio;
	
	@BeforeClass
	public static void antesDeCadaTeste() throws Exception {
		colunaDoMeio = new CapaMeioMancheteHorizontal();
	}

	@AfterClass
	public static void depoisDeCadaTeste() {
		colunaDoMeio.fechar();
	}
	
	@Test
	public void verificaSeOBoxDaMancheteHorizontalEstaSendoExibido(){
		assertNotNull(colunaDoMeio.exibiuMancheteHorizontal());
	}
	
	@Test
	public void verificaSeAMancheteHorizontalEstaExibindoAEditoria(){
		assertTrue(colunaDoMeio.exibiuEditoriaDaMancheteHorizontal());
	}
	
	@Test
	public void verificaSeOBoxSuperiorDaMancheteHorizontalEstaSendoExibido(){
		assertNotNull(colunaDoMeio.getBoxMancheteHorizontalSuperior());
	}
	
	@Test
	public void verificaSeAMancheteHorizontalEstaExibindoUmLinkNaImagem(){
		assertTrue(colunaDoMeio.exibiuLinkNaImagemDaMancheteHorizontal());
	}
	
	@Test
	public void verificaSeAMancheteHorizontalEstaExibindoUmLinkValidoNaImagem(){
		assertTrue(colunaDoMeio.exibiuLinkValidoNaImagemDaMancheteHorizontal());
	}
	
	@Test
	public void verificaSeAMancheteHorizontalEstaExibindoOLinkAnimadoImagem(){
		assertTrue(colunaDoMeio.exibiuLinkAnimadoNaImagemDaMancheteHorizontal());
	}
	
	@Test
	public void verificaSeAMancheteHorizontalEstaExibindoUmaImagem(){
		assertTrue(colunaDoMeio.exibiuImagemNaMancheteHorizontal());
	}
	
	@Test
	public void verificaSeAImagemDaMancheteHorizontalPossuiOCropCorreto(){
		assertTrue(colunaDoMeio.exibiuOCropCorretoParaAImagemHorizontal());
	}
	
	@Test
	public void verificaSeAImagemDaMancheteHorizontalPossuiOWidthDe460Px(){
		assertTrue(colunaDoMeio.exibiuImagemComWidthCorreto());
	}
	
	@Test
	public void verificaSeAImagemDaMancheteHorizontalPossuiOHeightDe200Px(){
		assertTrue(colunaDoMeio.exibiuImagemComHeightCorreto());
	}
	
	@Test
	public void verificaSeASubEditoriaDaMateriaDoBoxSuperiorEstaSendoExibido(){
		assertTrue(colunaDoMeio.getMancheteHorizontalSubEditoria());
	}
	
	@Test
	public void verificaSeOTituloDaMateriaDoBoxSuperiorEstaSendoExibido(){
		assertTrue(colunaDoMeio.getMancheteHorizontalTitulo());
	}
	
	@Test
	public void verificaSeOTituloDaMateriaDoBoxSuperiorPossuiNoMaximo59Caracteres(){
		assertTrue(colunaDoMeio.exibiuTituloMancheteHorizontalComMaximoDeCaracteres());
	}
	
	@Test
	public void verificaSeOTituloDaMateriaDoBoxSuperiorPossuiUmLink(){
		assertTrue(colunaDoMeio.getMancheteHorizontalTituloLink());
	}
	
	@Test
	public void verificaSeOTituloDaMateriaDoBoxSuperiorPossuiUmLinkValido(){
		assertTrue(colunaDoMeio.getMancheteHorizontalTituloLinkValido());
	}
	
	@Test
	public void verificaSeOTotalDeComentariosDaMateriaDoBoxSuperiorEstaSendoExibido(){
		assertTrue(colunaDoMeio.getMancheteHorizontalComentarios());
	}
	
	@Test
	public void verificaSeOTotalDeComentariosDaMateriaDoBoxSuperiorPossuiUmLink(){
		assertTrue(colunaDoMeio.getMancheteHorizontalComentariosLink());
	}
	
	@Test
	public void verificaSeOTotalDeComentariosDaMateriaDoBoxSuperiorPossuiUmLinkValido(){
		assertTrue(colunaDoMeio.getMancheteHorizontalComentariosLinkValido());
	}
	
	@Test
	public void verificaSeOBoxInferiorDaMancheteHorizontalEstaSendoExibido(){
		assertNotNull(colunaDoMeio.getBoxMancheteHorizontalInferior());
	}
	
	@Test
	public void verificaSeAListaDeMateriasDoBoxInferiorEhMaiorQueZero(){
		assertTrue(colunaDoMeio.getMancheteHorizontalBoxInferiorTamanho());
	}
	
	@Test
	public void verificaSeAsMateriasDoBoxInferiorEstaoExibindoAEditoria(){
		assertTrue(colunaDoMeio.getMancheteHorizontalBoxInferiorEditoria());
	}
	
	@Test
	public void verificaSeAsMateriasDoBoxInferiorEstaoExibindoOTitulo(){
		assertTrue(colunaDoMeio.getMancheteHorizontalBoxInferiorTitulo());
	}
	
	@Test
	public void verificaSeAsMateriasDoBoxInferiorEstaoExibindoOTituloComOMaximoDeCaracteres(){
		assertTrue(colunaDoMeio.exibiuTotalMaximoDeCaracteres());
	}
	
	@Test
	public void verificaSeAsMateriasDoBoxInferiorEstaoExibindoUmLinkNoTitulo(){
		assertTrue(colunaDoMeio.getMancheteHorizontalBoxInferiorTituloLink());
	}
	
	@Test
	public void verificaSeAsMateriasDoBoxInferiorEstaoExibindoUmLinkValidoNoTitulo(){
		assertTrue(colunaDoMeio.getMancheteHorizontalBoxInferiorTituloLinkValido());
	}
	
	@Test
	public void verificaSeAsMateriasDoBoxInferiorEstaoExibindoOTotalDeComentarios(){
		assertTrue(colunaDoMeio.getMancheteHorizontalBoxInferiorComentario());
	}
	
	@Test
	public void verificaSeAsMateriasDoBoxInferiorEstaoExibindoUmLinkNoTotalDeComentarios(){
		assertTrue(colunaDoMeio.getMancheteHorizontalBoxInferiorComentarioLink());
	}
	
	@Test
	public void verificaSeAsMateriasDoBoxInferiorEstaoExibindoUmLinkValidoNoTotalDeComentarios(){
		assertTrue(colunaDoMeio.getMancheteHorizontalBoxInferiorComentarioLinkValido());
	}
}