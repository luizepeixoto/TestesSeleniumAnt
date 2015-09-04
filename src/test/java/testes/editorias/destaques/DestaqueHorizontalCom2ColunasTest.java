package testes.editorias.destaques;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import pages.editoria.destaques.DestaqueHorizontalCom2Colunas;

import crops.CropsDestaques;


public class DestaqueHorizontalCom2ColunasTest {
	
	/*Destaque duas colunas: Matérias principal com foto, descrição, autor e comentários
	   						 Destaques secundários com foto, descrição, autor e comentários
	   						 Box de opicião com 	foto, antititulo, descrição e autor*/
	
	private static DestaqueHorizontalCom2Colunas editoria;
	
	@BeforeClass
	public static void antesDeCadaTeste() throws Exception {
		editoria = new DestaqueHorizontalCom2Colunas();
	}
	
	@AfterClass
	public static void depoisDeCadaTeste() {
		editoria.fechar();
	}
	
	@Test
	public void exibiuBoxEmDestaque(){
		assertNotNull(editoria.exibiuDestaque());
	}
	
	@Test
	public void exibiuEditoriaEmDestaque(){
		assertTrue(editoria.exibiuEditoriaEmDestaque());
	}
	
	@Test
	public void exibiuLinkNaEditoriaEmDestaque(){
		assertTrue(editoria.exibiuLinkEditoriaEmDestaque());
	}
	
	@Test
	public void exibiuLinkValidoNaEditoriaEmDestaque(){
		assertTrue(editoria.exibiuLinkValido());
	}
	
	/*Início da validação da matéria principal*/
	
	@Test
	public void exibiuUmTituloParaAMateriaEmDestaque(){
		assertTrue(editoria.exibiuTituloEmDestaque());
	}
	
	@Test
	public void exibiuUmLinkNoTituloParaAMateriaEmDestaque(){
		assertTrue(editoria.exibiuLinkNoTitulo());
	}
	
	@Test
	public void exibiuUmLinkValidoUmTituloParaAMateriaEmDestaque(){
		assertTrue(editoria.exibiuLinkValidoNoTitulo());
	}
	
	@Test
	public void exibiuUmaDescricaoParaAMateriaEmDestaque(){
		assertTrue(editoria.exibiuDescricaoEmDestaque());
	}
	
	@Test
	public void exibiuOBalaoDeComentariosNoDestaque(){
		assertTrue(editoria.exibiuBalaoDeComentariosEmDestaque());
	}
	
	@Test
	public void exibiuUmLinkNoBalaoDeComentariosNoDestaque(){
		assertTrue(editoria.exibiuLinkNoBalaoDeComentarios());
	}
	
	@Test
	public void exibiuUmLinkValidoNoBalaoDeComentariosNoDestaque(){
		assertTrue(editoria.exibiuLinkValidoNoBalaoDeComentarios());
	}
				
	@Test
	public void exibiuUmaImagemParaAMateriaEmDestaque(){
		assertTrue(editoria.exibiuImagemNoDestaque());
	}
	
	@Test
	public void exibiuUmaImagemParaAMateriaEmDestaqueComOCropCorreto(){
		assertTrue(editoria.exibiuImagemNoDestaqueComCropCorreto());
	}
	
	@Test
	public void exibiuAClasseLinkAnimadoNaImagemDaMateriaEmDestaque(){
		assertTrue(editoria.exibiuImagemComLinkAnimado());
	}
	
	@Test
	public void exibiuOWidthCorretoParaImagemDoDestaque(){
		String widthEsperado = CropsDestaques.duasColunasFotoDestaquePrincial.getWidth();
		assertEquals(widthEsperado, editoria.exibiuWidthDoDestaque());
	}			
				
	@Test
	public void exibiuOHeightCorretoParaImagemDoDestaque(){
		String heightEsperado = CropsDestaques.duasColunasFotoDestaquePrincial.getHeight();
		assertEquals(heightEsperado, editoria.exibiuHeightDoDestaque());
	}			
	
	/*Início da validação da lista de matérias secundárias*/
	
	@Test
	public void verificaSeEstaSendoExibidaUmaListaDeMateriasSecundarias(){
		assertTrue(editoria.exibiuUmaListaDeMateriasSecundarias());
	}
	
	@Test
	public void verificaSeAsMateriasSecundariasEstaoExibindoUmImagem(){
		assertTrue(editoria.exibiuImagemParaAsMateriasSecundarias());
	}
	
	@Test
	public void verificaSeAsMateriasSecundariasPossuemOCropCorreto(){
		assertTrue(editoria.exibiuCropCorretoParaAsImagensDasMateriasSecundarias());
	}
	
	@Test
	public void verificaSeAsMateriasSecundariasEstaExibindoAClasseDeAnimacaoOpacity(){
		assertTrue(editoria.exibiuImagemParaAsMateriasSecundariasComAClasseOpacity());
	}
	
	@Test
	public void verificaSeAsMateriasSecundariasEstaoExibindoAsImagemComOWidthCorreto(){
		assertTrue(editoria.exibiuWidthCorretoParaMateriasSecundarias());
	}
	
	@Test
	public void verificaSeAsMateriasSecundariasEstaoExibindoAsImagemComOHeightCorreto(){
		assertTrue(editoria.exibiuHeightCorretoParaMateriasSecundarias());
	}
				
	@Test
	public void verificaSeAsMateriasSecundariasEstaoExibindoUmTitulo(){
		assertTrue(editoria.exibiuUmTituloParaAsMateriasSecundarias());
	}
	
	@Test
	public void verificaSeAsMateriasSecundariasEstaoExibindoUmTituloComLink(){
		assertTrue(editoria.exibiuLinkNoTituloDasMateriasSecundarias());
	}
	
	@Test
	public void verificaSeAsMateriasSecundariasEstaoExibindoUmTituloComLinkValido(){
		assertTrue(editoria.exibiuLinkValidoNoTituloParaDasMateriasSecundarias());
	}
	
	@Test
	public void verificaSeAsMateriasSecundariasEstaoExibindoUmaDescricao(){
		assertTrue(editoria.exibiuUmaDescricaoParaAsMateriasSecundarias());
	}
	
	@Test
	public void verificaSeAsMateriasSecundariasEstaoExibindoOBalaoDeComentarios(){
		assertTrue(editoria.exibiuBalaoDeComentariosParaAsMateriasSecundarias());
	}
	
	@Test
	public void verificaSeAsMateriasSecundariasEstaoExibindoUmLinkNoBalaoDeComentarios(){
		assertTrue(editoria.exibiuLinkNoBalaoDeComentariosParaAsMateriasSecundarias());
	}
	
	@Test
	public void verificaSeAsMateriasSecundariasEstaoExibindoUmLinkValidoNoBalaoDeComentarios(){
		assertTrue(editoria.exibiuLinkValidoNoBalaoDeComentariosDasMateriasSecundarias());
	}			
		
	/*Início da validação das matérias dos box de opinião*/
	
	@Test
	public void exibiuOBoxOpiniao(){
		assertNotNull(editoria.exibiuBoxOpiniao());
	}			
	
	@Test
	public void exibiuUmaListaDeOpinioes(){
		assertTrue(editoria.exibiuListaDeOpiniao());
	}
				
	@Test
	public void exibiuUmaFotoParaAsOpinioes(){
		assertTrue(editoria.exibiuFotoParaAsOpinioes());
	}
	
	@Test
	public void verificaSeAsFotosDoBoxDeOpiniaoEstaoExibindoOCropCorreto(){
		assertTrue(editoria.exibiuFotoComCropCorretoParaAsOpinioes());
	}
	
	@Test
	public void exibiuTituloConfigurado(){
		assertTrue(editoria.exibiuTituloParaOpinioes());
	}
	
	@Test
	public void exibiuAutorParaAsOpinioes(){
		assertTrue(editoria.exibiuAutorParaOpinioes());
	}
		
	@Test
	public void exibiuDescricaoParaAsOpinioes(){
		assertTrue(editoria.exibiuDescricaoParaOpinioes());
	}
	
	@Test
	public void exibiuDescricaoParaAsOpinioesComLink(){
		assertTrue(editoria.exibiuDescricaoParaOpinioesComLink());
	}
	
	@Test
	public void exibiuUmLinkValidoNaDescricaoDasOpinioes(){
		assertTrue(editoria.exibiuDescricaoParaOpinioesComUmLinkValido());
	}
	
	@Test
	public void exibiuDescricaoComNoMaximo55Caracteres(){
		assertTrue(editoria.exibiuDescricaoComMaximoDe55Caracteres());
	}
	
	@Test
	public void exibiuAutorNaChamadaPrincipal(){
		assertTrue(editoria.exibiuAutorNaChamadaPrincipal());
	}
	
	@Test
	public void exibiuAutorNaChamadaSecundaria(){
		assertTrue(editoria.exibiuAutorNaChamadaSecundaria());
	}
	
//	***** CHAMADA COM FOTO GRANDE *****
//	Duas chamadas:
// 	1) Uma com foto e autor e;
//  2) Uma sem foto e sem autor.	
	
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
	public void exibiuImagemDaChamadaComFotoGrande(){
		assertTrue(editoria.exibiuImagemDaChamadaComFotoGrande());
	}
	
	@Test
	public void exibiuUmLinkValidoNaImagemDaChamadaComFotoGrande(){
		assertTrue(editoria.exibiuUmLinkValidoNaImagemDaChamadaComFotoGrande());
	}
	
	@Test
	public void naoExibiuImagemDaChamadaComFotoGrande(){
		assertTrue(editoria.naoExibiuImagemDaChamadaComFotoGrande());
	}

//	***** CHAMADA COM FOTO PEQUENA ***** 
//	Três chamadas:
// 	1) Duas com foto e autor e;
//  2) Uma sem foto e sem autor.	
	
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
