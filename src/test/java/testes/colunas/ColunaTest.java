package testes.colunas;

import static org.junit.Assert.*;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;

import pages.coluna.Coluna;

import br.com.infoglobo.pages.Navegador;
import br.com.infoglobo.pages.OrdemExecucaoTeste;
import br.com.infoglobo.pages.OrdenadorTestes;

@RunWith(OrdenadorTestes.class)
public class ColunaTest {
	
	private static Coluna coluna;
	
	@BeforeClass
	public static void antesDeCadaTeste() throws Exception {
		coluna = new Coluna(Navegador.CHROME);
	}

	@AfterClass
	public static void depoisDeCadaTeste() {
		coluna.fechar();
	}
	
	@OrdemExecucaoTeste(Ordem=1)
	@Test
	public void verificaSeASubEditoriaComOTituloColunaEstaSendoExibida(){
		String tituloEsperado="COLUNA";
		assertEquals(tituloEsperado, coluna.exibiuOTituloColuna());
	}
	
	@OrdemExecucaoTeste(Ordem=2)
	@Test
	public void verificaSeOAutorDaColunaEstaSendoExibido(){
		assertTrue(coluna.exibiuOTituloComOAutorDaColuna());
	}
	
	@OrdemExecucaoTeste(Ordem=3)
	@Test
	public void verificaSeADescricaoDaColunaEstaSendoExibida(){
		assertTrue(coluna.exibiuADescricaoDaColuna());
	}
	
	@OrdemExecucaoTeste(Ordem=4)
	@Test
	public void verificaSeAFotoDoColunistaEstaSendoExibida(){
		assertTrue(coluna.exibiuAFotoDoColunista());
	}
	
	@OrdemExecucaoTeste(Ordem=5)
	@Test
	public void verificaSeOCorpoDaColunaEstaSendoExibido(){
		assertNotNull(coluna.exibiuCorpoDaColuna());
	}
	
	@OrdemExecucaoTeste(Ordem=6)
	@Test
	public void verificaSeADataDaPostagemEstaSendoExibida(){
		assertTrue(coluna.exibiuAData());
	}
	
	@OrdemExecucaoTeste(Ordem=7)
	@Test
	public void verificaSeOTituloDaColunaEstaSendoExibido(){
		assertTrue(coluna.exibiuOTitulo());
	}
	
	@OrdemExecucaoTeste(Ordem=8)
	@Test
	public void verificaSeOTextoDaColunaEstaSendoExibido(){
		assertTrue(coluna.exibiuOTexto());
	}
}