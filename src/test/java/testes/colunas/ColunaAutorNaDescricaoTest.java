package testes.colunas;

import static org.junit.Assert.*;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import pages.coluna.ColunaComAutorNaDescricao;

import br.com.infoglobo.pages.Navegador;

public class ColunaAutorNaDescricaoTest {
	
	private static ColunaComAutorNaDescricao coluna;
	
	@BeforeClass
	public static void antesDeCadaTeste() throws Exception {
		coluna = new ColunaComAutorNaDescricao(Navegador.CHROME);
	}

	@AfterClass
	public static void depoisDeCadaTeste() {
		coluna.fechar();
	}
	
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
	public void verificaSeOTituloDaColunaEstaSendoExibido(){
		assertTrue(coluna.exibiuOTituloDaColuna());
	}
	
	@Test
	public void verificaSeOAutorEstaSendoExibidoNaDescricaoDaColuna(){
		assertTrue(coluna.exibiuOAutorDaColunaNaDescricao());
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
	public void verificaSeOCorpoDaColunaEstaSendoExibido(){
		assertNotNull(coluna.exibiuCorpoDaColuna());
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
	public void verificaSeOTextoDaPostagemEstaSendoExibido(){
		assertTrue(coluna.exibiuOTexto());
	}
}