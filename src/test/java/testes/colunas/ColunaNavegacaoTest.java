package testes.colunas;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import pages.coluna.ColunaNavegacao;

import br.com.infoglobo.pages.Navegador;

public class ColunaNavegacaoTest {
	
	private static ColunaNavegacao coluna;
	
	@BeforeClass
	public static void antesDeCadaTeste() throws Exception {
		coluna = new ColunaNavegacao(Navegador.CHROME);
		coluna.aguardaBoxDeNavegacaoCarregar();
		coluna.executaScrollAteOBoxDePaginacao();
	}

	@AfterClass
	public static void depoisDeCadaTeste() {
		coluna.fechar();
	}
	
	@Test
	public void verificaSeOBoxDeNavegacaoEstaSendoExibido(){
		assertNotNull(coluna.exibiuBoxDeNavegacao());
	}
	
	@Test
	public void verificaSeOBoxDeNavegacaoParaAPlantaoAnteriorEstaSendoExibido(){
		assertNotNull(coluna.exibiuBoxDeNavegacaoAnterior());
	}
	
	@Test
	public void verificaSeOBoxDeNavegacaoAnteriorPossuiUmLink(){
		assertTrue(coluna.exibiuUmLinkNoNoBoxDeNavegacaoAnterior());
	}
	
	@Test
	public void verificaSeOLinkDeNavegacaoMaisAntigaEhValido(){
		assertTrue(coluna.getBoxPaginacaoAntigaLinkValido());
	}
	
	@Test
	public void verificaSeOTituloAnteriorEstaSendoExibido(){
		String tituloEsperado = "ANTERIOR";
		assertEquals(tituloEsperado, coluna.getBoxPaginacaoAntigaTitulo());
	}
	
	@Test
	public void verificaSeOTituloDaPlantaoMaisAntigaEstaSendoExibidoEmNegrito(){
		assertTrue(coluna.exibiuTituloDoPlantaoAnteriorEmNegrito());
	}
	
	@Test
	public void verificaSeOBoxDeNavegacaoParaAPlantaoMaisRecenteEstaSendoExibido(){
		assertNotNull(coluna.exibiuPaginacaoProxima());
	}
	
	@Test
	public void verificaSeOBoxDeNavegacaoMaisRecentePossuiUmLink(){
		assertTrue(coluna.getBoxPaginacaoRecenteLink());
	}
	
	@Test
	public void verificaSeOLinkDeNavegacaoMaisRecenteEhValido(){
		assertTrue(coluna.getBoxPaginacaoRecenteLinkValido());
	}
	
	@Test
	public void verificaSeOTituloMaisRecenteEstaSendoExibidoEmUmaFonteDiferente(){
		String tituloEsperado = "PRÓXIMA";
		assertEquals(tituloEsperado, coluna.getBoxPaginacaoRecenteTitulo());
	}
	
	@Test
	public void verificaSeOTituloDaPlantaoMaisRecenteEstaSendoExibidoEmNegrito(){
		assertTrue(coluna.exibiuTituloDPlantaoProximaEmNegrito());
	}
}