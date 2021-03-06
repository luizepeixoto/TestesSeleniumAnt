package testes.colunas;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import pages.coluna.ColunaNavegacaoSemAnterior;

import br.com.infoglobo.pages.Navegador;

public class ColunaNavegacaoSemAnteriorTest {
	
	private static ColunaNavegacaoSemAnterior coluna;
	
	@BeforeClass
	public static void antesDeCadaTeste() throws Exception {
		coluna = new ColunaNavegacaoSemAnterior(Navegador.CHROME);
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
	public void verificaSeOBoxDeNavegacaoParaAMateriaMaisAntigaEstaSendoExibidoNaCorCinza(){
		assertTrue(coluna.exibiuBoxDeAnteriorDesativado());
	}
	
	@Test
	public void verificaSeOBoxDeNavegacaoAnteriorEstaSendoExibidoSemLinkLink(){
		assertTrue(coluna.exibiuUmLinkNoBoxDePaginacaoAnterior());
	}
	
	@Test
	public void verificaSeOTituloAnteriorEstaSendoExibidoCorretamente(){
		String tituloEsperado = "ANTERIOR";
		assertEquals(tituloEsperado, coluna.exibiuTitulodaMateriaNoBoxPaginacaoMaisAntiga());
	}
	
	@Test
	public void verificaSeOTituloDaMateriaAnteriorEstaSendoExibidoEmNegrito(){
		assertTrue(coluna.exibiuTituloDaMateriaAnteriorEmNegrito());
	}
	
	@Test
	public void verificaSeOTituloDaMateriaDoBoxDeNavegacaoAnteriorEhOMesmoTituloDaMateriaDaPagina(){
		assertTrue(coluna.exibiuOTituloDoBoxAnteriorIgualAoTituloDaMateria());
	}
}