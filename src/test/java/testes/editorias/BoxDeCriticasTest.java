package testes.editorias;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import pages.editoria.BoxDeCriticasSemPaginacao;


public class BoxDeCriticasTest {
	
	private static BoxDeCriticasSemPaginacao editoria;
	
	@BeforeClass
	public static void antesDeCadaTeste() throws Exception {
		editoria = new BoxDeCriticasSemPaginacao();
	}
	
	@AfterClass
	public static void depoisDeCadaTeste() {
		editoria.fechar();
	}
	
	@Test
	public void exibiuBoxDeCriticas(){
		assertNotNull(editoria.exibiuBoxDeCriticas());
	}
	
	@Test
	public void exibiuUmTituloNoBoxDeCriticas(){
		assertTrue(editoria.exibiuUmTituloNoBoxDeCriticas());
	}
	
	@Test
	public void exibiuUmTituloComUmLinkNoBoxDeCriticas(){
		assertTrue(editoria.exibiuUmTituloComUmLink());
	}
	
	@Test
	public void exibiuUmLinkValidoNoTituloBoxDeCriticas(){
		assertTrue(editoria.exibiuUmLinkValidoNoTitulo());
	}
	
	@Test
	public void exibiuUmaListaComNoMinimo4Conteudos(){
		assertTrue(editoria.exibiuUmaListaValida());
	}
	
	@Test
	public void exibiuImagemParaOsConteudosDaLista(){
		assertTrue(editoria.exibiuImagemParaOsItensDaLista());
	}
	
	@Test
	public void verificaSeAsImagemDaListaPossuemOCropCorreto(){
		assertTrue(editoria.exibiuCropCorretoParaAsImagem());
	}
	
	@Test
	public void exibiuImagemComUmLinkParaCadaConteudosDaLista(){
		assertTrue(editoria.exibiuImagemComLink());
	}
	
	@Test
	public void exibiuImagemComUmLinkValidoParaCadaConteudosDaLista(){
		assertTrue(editoria.exibiuImagemComLinkValido());
	}
	
	@Test
	public void exibiuImagemComWidthCorretoParaCadaImagemDaLista(){
		assertTrue(editoria.exibiuImagemComWidthCorreto());
	}
	
	@Test
	public void exibiuImagemComHeightCorretoParaCadaImagemDaLista(){
		assertTrue(editoria.exibiuImagemComHeightCorreto());
	}
	
	@Test
	public void exibiuEditoriaParaCadaConteudoDaLista(){
		assertTrue(editoria.exibiuEditoria());
	}
	
	@Test
	public void exibiuUmLinkNaEditoriaDeCadaConteudoDaLista(){
		assertTrue(editoria.exibiuUmLinkNaEditoria());
	}
	
	@Test
	public void exibiuUmLinkValidoNaEditoriaDeCadaConteudoDaLista(){
		assertTrue(editoria.exibiuUmLinkValidoNaEditoria());
	}
	
	@Test
	public void exibiuTituloParaCadaConteudoDaLista(){
		assertTrue(editoria.exibiuTitulo());
	}
	
	@Test
	public void exibiuTituloComLinkParaCadaConteudoDaLista(){
		assertTrue(editoria.exibiuTituloComLink());
	}
	
	@Test
	public void exibiuUmLinkValidoParaCadaTituloDaLista(){
		assertTrue(editoria.exibiuTituloComLinkValido());
	}
	
	@Test
	public void exibiuQuantidadeMaximaDeCaracteresParaOsTitulosDosConteudos(){
		assertTrue(editoria.exibiuQuantidadeMaximaDeCaracteresParaOsTitulosDosConteudos());
	}
	
	@Test
	public void exibiuDescricaoParaCadaConteudoDaLista(){
		assertTrue(editoria.exibiuDescricao());
	}
	
	@Test
	public void exibiuQuantidadeMaximaDeCaracteresParaAsDescricoesDeConteudos(){
		assertTrue(editoria.exibiuQuantidadeMaximaDeCaracteresParaAsDescricoesDeConteudos());
	}
	
	@Test
	public void verificaSeOBoxDeNavegacaoNaoEstaSendoExibido(){
		assertTrue(editoria.exibiuBoxDePaginacao());
	}
}
