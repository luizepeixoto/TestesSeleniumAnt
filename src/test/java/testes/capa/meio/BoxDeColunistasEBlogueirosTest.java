package testes.capa.meio;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import pages.capa.meio.BoxColunistasEBlogueiros;


public class BoxDeColunistasEBlogueirosTest {
	
	private static BoxColunistasEBlogueiros colunaDoMeio;
	
	@BeforeClass
	public static void antesDeCadaTeste() throws Exception {
		colunaDoMeio = new BoxColunistasEBlogueiros();
	}
	
	@AfterClass
	public static void depoisDeCadaTeste() {
		colunaDoMeio.fechar();
	}
	
	@Test
	public void verificaSeODeBoxDeColunistasEstaSendoExibidoNaPagina(){
		assertNotNull(colunaDoMeio.exibiuBoxDeColunistas());
	}
	
	@Test
	public void verificaSeOTituloEstaSendoExibido(){
		assertTrue(colunaDoMeio.exibiuTituloDoBox());
	}
	
	@Test
	public void verificaSeEstaSendoExibidoUmaListaDeColunistasOuBloqueiros(){
		assertTrue(colunaDoMeio.exibiuListaValida());
	}
	
	@Test
	public void verificaSeEstaSendoExibidoUmaImagemParaCadaItemDaLista(){
		assertTrue(colunaDoMeio.exibiuImagemParaCadaItemDaLista());
	}
	
	@Test
	public void verificaSeOCropDaImagemDoBoxDeColunistasEstaSendoExibidaCorretamente(){
		assertTrue(colunaDoMeio.exibiuCropCorretoParaAImagem());
	}
	
	@Test
	public void verificaSesImagensDoBoxDeColunistasPossuemOWidthCorreto(){
		assertTrue(colunaDoMeio.exibiuWidthCorretoParaAImagem());
	}
	
	@Test
	public void verificaSesImagensDoBoxDeColunistasPossuemOHeightCorreto(){
		assertTrue(colunaDoMeio.exibiuHeightCorretoParaAImagem());
	}
	
	@Test
	public void verificaSeEstaSendoExibidoUmLinkNaImagemDeCadaItemDaLista(){
		assertTrue(colunaDoMeio.exibiuLinkNasImagens());
	}
	
	@Test
	public void verificaSeEstaSendoExibidoUmLinkValidoNaImagemDeCadaItemDaLista(){
		assertTrue(colunaDoMeio.exibiuLinkValidoNasImagens());
	}
	
	@Test
	public void verificaSeEstaSendoExibidoOWidthCorretoParaAsImagensDeCadaItemDaLista(){
		assertTrue(colunaDoMeio.exibiuWidthCorretoParaAsImagens());
	}
	
	@Test
	public void verificaSeEstaSendoExibidoOHeightCorretoParaAsImagensDeCadaItemDaLista(){
		assertTrue(colunaDoMeio.exibiuHeightCorretoParaAsImagens());
	}
	
	@Test
	public void verificaSeEstaSendoExibidoUmLinkNoTituloDeCadaItemDaLista(){
		assertTrue("Não Exibiu Antititulo Com Link", colunaDoMeio.exibiuAntiTituloComLink());
		assertTrue("Não Exibiu Título Com Link", colunaDoMeio.exibiuTituloComLink());
		assertTrue("Não Exibiu Descrição Com Link", colunaDoMeio.exibiuDescricaoComLink());
	}
	
	@Test
	public void verificaSeEstaSendoExibidoUmAntiTituloParaCadaItemDaLista(){
		assertTrue(colunaDoMeio.exibiuAntiTitulos());
	}
	
	@Test
	public void verificaSeCadaAntitituloPossuiNoMaximo30Caracteres(){
		assertTrue(colunaDoMeio.exibiuAntiTitulosCom30Caracteres());
	}
	
	@Test
	public void verificaSeEstaSendoExibidoUmTituloParaCadaItemDaLista(){
		assertTrue(colunaDoMeio.exibiuTitulos());
	}
	
	@Test
	public void verificaSeCadaTituloPossuiNoMaximo50Caracteres(){
		assertTrue(colunaDoMeio.exibiuAntititulosCom50Caracteres());
	}
	
	@Test
	public void verificaSeEstaSendoExibidoUmSubTituloParaCadaItemDaLista(){
		assertTrue(colunaDoMeio.exibiuSubTitulos());
	}
	
	@Test
	public void verificaSeCadaSubTituloPossuiNoMaximo93Caracteres(){
		assertTrue(colunaDoMeio.exibiuSubTituloCom93Caracteres());
	}
}
