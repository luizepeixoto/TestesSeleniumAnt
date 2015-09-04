package testes.colunas;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import pages.coluna.ColunaComFoto;

import br.com.infoglobo.pages.Navegador;

public class ColunaComFotoTest {
	
	private static ColunaComFoto coluna;
	
	@BeforeClass
	public static void antesDeCadaTeste() throws Exception {
		coluna = new ColunaComFoto(Navegador.CHROME);
	}

	@AfterClass
	public static void depoisDeCadaTeste() {
		coluna.fechar();
	}
	/*Coluna com:
	  - Foto do autor sendo exibida
	  - Foto Inline*/
	@Test
	public void verificaSeOCabecalhoDeColunaEstaSendoExibidoAbaixoDoBanner(){
		assertNotNull(coluna.exibiuCabecalhoDaColuna());
	}
	
	@Test
	public void verificaSeASubEditoriaComOTituloColunaEstaSendoExibida(){
		String tituloEsperado="COLUNA";
		assertEquals(tituloEsperado, coluna.exibiuOTituloColuna());
	}
	
	@Test
	public void verificaSeOAutorDaColunaEstaSendoExibido(){
		assertTrue(coluna.exibiuOTituloComOAutorDaColuna());
	}
	
	@Test
	public void verificaSeADescricaoDaColunaEstaSendoExibida(){
		assertTrue(coluna.exibiuADescricaoDaColuna());
	}
	
	@Test
	public void verificaSeAFotoDoColunistaEstaSendoExibida(){
		assertTrue(coluna.exibiuAFotoDoColunista());
	}
	
	@Test
	public void verificaSeAFotoDoColunistaEstaSendoExibidaComOCropCorreto(){
		assertTrue(coluna.exibiuAFotoDoColunistaComOCropCorreto());
	}
	
	@Test
	public void verificaSeAFotoDoColunistaEstaSendoExibidaComOWidthCorreto(){
		assertTrue(coluna.exibiuAFotoDoColunistaComOWidthCorreto());
	}
	
	@Test
	public void verificaSeAFotoDoColunistaEstaSendoExibidaComOHeightCorreto(){
		assertTrue(coluna.exibiuAFotoDoColunistaComOHeightCorreto());
	}
	
	@Test
	public void verificaSeOBoxDaColunaEstaSendoExibido(){
		assertNotNull(coluna.exibiuBoxColuna());
	}
	
	@Test
	public void verificaSeADataDaPostagemEstaSendoExibida(){
		assertTrue(coluna.exibiuAData());
	}
	
	@Test
	public void verificaSeOTituloDaPostagemEstaSendoExibido(){
		assertTrue(coluna.exibiuOTitulo());
	}
	
	@Test
	public void verificaSeAFotoNaPrimeiraPosicaoEstaSendoExibida(){
		assertTrue(coluna.exibiuFotoNaPrimeiraPosicao());
	}
	
	@Test
	public void verificaSeOCropDaFotoInlineEstaCorreto(){
		assertTrue(coluna.exibiuCropCorretoNaFotoInline());
	}
	
	@Test
	public void verificaSeANaPrimeiraPosicaoEstaSendoExibidaComWidth700Px(){
		assertTrue(coluna.exibiuWidthDaPrimeiraPosicao());
	}
	
	@Test
	public void verificaSeANaPrimeiraPosicaoEstaSendoExibidaComHeight420Px(){
		assertTrue(coluna.exibiuHeightDaPrimeiraPosicao());
	}
	
	@Test
	public void verificaSeALegendaEstaSendoExibidaAbaixoDaFoto(){
		assertTrue(coluna.exibiuLegendaDaFoto());
	}
	
	@Test
	public void verificaSeALegendaEstaExibindoOAutorDaFoto(){
		assertTrue(coluna.exibiuOAutorDaFoto());
	}
	
	@Test
	public void verificaSeOCorpoDaColunaEstaSendoExibido(){
		assertNotNull(coluna.exibiuCorpoDaColuna());
	}
	
	@Test
	public void verificaSeOTextoDaPostagemEstaSendoExibido(){
		assertTrue(coluna.exibiuOTexto());
	}
	
	@Test
	public void verificaSeOLinkLeiaTodasAsColunasEstaSendoExibidoNoFimDoTexto(){
		assertTrue(coluna.exibiuUmLinkEmLeiatodasAsColunas());
	}
	
	@Test
	public void verificaSeOLinkExibidoEmLeiaTodasAsColunasEhValido(){
		assertTrue(coluna.exibiuUmLinkValidoEmLeiatodasAsColunas());
	}
	
	@Test
	public void verificaSeOTextoLeiaTodasAsColunasEstaSendoExibidoNoFimDoTexto(){
		String resultadoEsperado = "LEIA TODAS AS COLUNAS...";
		assertEquals(resultadoEsperado, coluna.exibiuOTituloNoFimDaPaginaLeiaTodasAsColunas());
	}
}