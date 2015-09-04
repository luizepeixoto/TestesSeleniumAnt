package testes.colunas;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import pages.coluna.ColunaNavegacaoSemProxima;

import br.com.infoglobo.pages.Navegador;

public class ColunaNavegacaoSemProximaTest {
	
	private static ColunaNavegacaoSemProxima coluna;
	
	@BeforeClass
	public static void antesDeCadaTeste() throws Exception {
		coluna = new ColunaNavegacaoSemProxima(Navegador.CHROME);
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
	public void verificaSeOBoxDeNavegacaoParaAMateriaMaisRecenteEstaSendoExibidoNaCorCinza(){
		assertTrue(coluna.exibiuBoxDeNavegacaoDeProximaDesativado());
	}
	
	@Test
	public void verificaSeOBoxDeNavegacaoMaisRecenteNaoPossuiUmLink(){
		assertTrue(coluna.exibiuBoxDeProximaSemLink());
	}
	
	@Test
	public void verificaSeOTituloProximaEstaSendoExibidoEmUmaFonteDiferente(){
		String tituloEsperado = "PRÓXIMA";
		assertEquals(tituloEsperado, coluna.getBoxPaginacaoRecenteTitulo());
	}
	
	@Test
	public void verificaSeOTituloDaMateriaProximaEstaSendoExibidoEmNegrito(){
		assertTrue(coluna.exibiuOTituloDoBoxDeProximoEmNegrito());
	}
	
	@Test
	public void verificaSeOTituloDaMateriaDoBoxDeNavegacaoMaisRecenteEhOMesmoTituloDaMateriaDaPagina(){
		assertTrue(coluna.exibiuOTituloDoBoxProximaIgualAoTituloDaMateria());
	}
}