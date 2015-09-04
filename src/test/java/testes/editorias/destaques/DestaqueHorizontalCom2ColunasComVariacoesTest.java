package testes.editorias.destaques;

import static org.junit.Assert.assertTrue;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import pages.editoria.destaques.DestaqueHorizontalCom2ColunasComVariacoes;


public class DestaqueHorizontalCom2ColunasComVariacoesTest {
	
	/*Variaçoes de destaque com chamadas com foto grande: Uma matérias com foto e autor e Uma matéria sem foto e sem autor.
	  Variaçoes de destaque com chamadas com foto pequena: Três chamadas de matérias 1) Duas com foto e autor e; 2) Uma sem foto e sem autor.*/
	
	private static DestaqueHorizontalCom2ColunasComVariacoes editoria;
	
	@BeforeClass
	public static void antesDeCadaTeste() throws Exception {
		editoria = new DestaqueHorizontalCom2ColunasComVariacoes();
	}
	
	@AfterClass
	public static void depoisDeCadaTeste() {
		editoria.fechar();
	}
	
	/* CHAMADA COM FOTO GRANDE */
	
	@Test
	public void exibiuChamadaComFotoGrande(){
		assertTrue(editoria.exibiuChamadaComFotoGrande());	
	}
	
	@Test
	public void exibiuTituloDaChamadaComFotoGrande(){
		assertTrue(editoria.exibiuTituloDaChamadaComFotoGrande());	
	}
	
	@Test
	public void exibiuAutorDaChamadaComFotoGrande(){
		assertTrue(editoria.exibiuAutorDaChamadaComFotoGrande());
	}
	
	@Test
	public void exibiuSubtituloDaChamadaComFotoGrande(){
		assertTrue(editoria.exibiuSubtituloDaChamadaComFotoGrande());
	}
	
	@Test
	public void exibiuUmLinkValidoNoTituloDaChamadaComFotoGrande(){
		assertTrue(editoria.exibiuUmLinkValidoNoTituloDaChamadaComFotoGrande());
	}
	
	@Test
	public void verificaSeAChamadaComFotoGrandeEstaExibindoUmaImagem(){
		assertTrue(editoria.exibiuImagemDaChamadaComFotoGrande());
	}
	
	@Test
	public void verificaSeAImagemDaChamadaComFotoGrandeEstaExibindoAAnimacao(){
		assertTrue(editoria.exibiClasseAnimadaOpacityNaChamadaComFotoGrande());
	}
	
	@Test
	public void verificaSeAImagemDaChamadaComFotoGrandePossuiOCropCorreto(){
		assertTrue(editoria.exibiuOCropCorretoParaAImagemDaChamadaComFotoGrande());
	}
	
	@Test
	public void verificaSeAImagemDaChamadaComFotoGrandePossuiOWidthCorreto(){
		assertTrue(editoria.exibiuOWidthCorretoParaAImagemDaChamadaComFotoGrande());
	}
	
	@Test
	public void verificaSeAImagemDaChamadaComFotoGrandePossuiOHeightCorreto(){
		assertTrue(editoria.exibiuOHeightCorretoParaAImagemDaChamadaComFotoGrande());
	}
	
	@Test
	public void exibiuUmLinkValidoNaImagemDaChamadaComFotoGrande(){
		assertTrue(editoria.exibiuUmLinkValidoNaImagemDaChamadaComFotoGrande());
	}
	
	@Test
	public void naoExibiuImagemDaChamadaComFotoGrande(){
		assertTrue(editoria.naoExibiuImagemDaChamadaComFotoGrande());
	}

	/* CHAMADA COM FOTO PEQUENA */ 
	
	@Test
	public void exibiuChamadaComFotoPequena(){
		assertTrue(editoria.exibiuChamadaComFotoPequena());
	}
	
	@Test
	public void exibiuTituloDaChamadaComFotoPequena(){
		assertTrue(editoria.exibiuTituloDaChamadaComFotoPequena());
	}

	@Test
	public void exibiuAutorDaChamadaComFotoPequena(){
		assertTrue(editoria.exibiuAutorDaChamadaComFotoPequena());
	}

	@Test
	public void exibiuSubtituloDaChamadaComFotoPequena(){
		assertTrue(editoria.exibiuSubtituloDaChamadaComFotoPequena());
	}
	
	@Test
	public void exibiuUmLinkValidoNoTituloDaChamadaComFotoPequena(){
		assertTrue(editoria.exibiuUmLinkValidoNoTituloDaChamadaComFotoPequena());
	}

	@Test
	public void exibiuImagemDaChamadaComFotoPequena(){
		assertTrue(editoria.exibiuImagemDaChamadaComFotoPequena());
	}

	@Test
	public void verificaSeAImagemDaChamadaComFotoPequenaPossuiOCropCorreto(){
		assertTrue(editoria.exibiuCropCorretoParaAImagemDaChamadaComFotoPequena());
	}
	
	@Test
	public void verificaSeAImagemDaChamadaComFotoPequenaPossuiOWidthCorreto(){
		assertTrue(editoria.exibiuWidthCorretoParaAImagemDaChamadaComFotoPequena());
	}
	
	@Test
	public void verificaSeAImagemDaChamadaComFotoPequenaPossuiOHeightCorreto(){
		assertTrue(editoria.exibiuHeightCorretoParaAImagemDaChamadaComFotoPequena());
	}
	
	@Test
	public void exibiuUmLinkValidoNaImagemDaChamadaComFotoPequena(){
		assertTrue(editoria.exibiuUmLinkValidoNaImagemDaChamadaComFotoPequena());
	}

	@Test
	public void exibiuImagemDaChamadaComFotoPequenaComAClasseOpacity(){
		assertTrue(editoria.exibiuImagemDaChamadaComFotoPequenaComAClasseOpacity());
	}

	@Test
	public void naoExibiuImagemDaChamadaComFotoPequena(){
		assertTrue(editoria.naoExibiuImagemDaChamadaComFotoPequena());
	}
}