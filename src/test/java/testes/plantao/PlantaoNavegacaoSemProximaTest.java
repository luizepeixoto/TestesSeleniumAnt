package testes.plantao;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import pages.plantao.PlantaoNavegacaoSemProxima;

import br.com.infoglobo.pages.Navegador;

public class PlantaoNavegacaoSemProximaTest {
	
	private static PlantaoNavegacaoSemProxima plantao;
	
	@BeforeClass
	public static void antesDeCadaTeste() throws Exception {
		plantao = new PlantaoNavegacaoSemProxima(Navegador.CHROME);
		plantao.aguardaBoxDeNavegacaoCarregar();
		plantao.executaScrollAteOBoxDePaginacao();
	}

	@AfterClass
	public static void depoisDeCadaTeste() {
		plantao.fechar();
	}
	
	@Test
	public void verificaSeOBoxDeNavegacaoEstaSendoExibido(){
		assertNotNull(plantao.exibiuBoxDeNavegacao());
	}
	
	@Test
	public void verificaSeOBoxDeNavegacaoParaAMateriaMaisRecenteEstaSendoExibidoNaCorCinza(){
		assertTrue(plantao.exibiuBoxDeNavegacaoDeProximaDesativado());
	}
	
	@Test
	public void verificaSeOBoxDeNavegacaoMaisRecenteNaoPossuiUmLink(){
		assertTrue(plantao.exibiuBoxDeProximaSemLink());
	}
	
	@Test
	public void verificaSeOTituloProximaEstaSendoExibidoEmUmaFonteDiferente(){
		String tituloEsperado = "PRÓXIMA";
		assertEquals(tituloEsperado, plantao.getBoxPaginacaoRecenteTitulo());
	}
	
	@Test
	public void verificaSeOTituloDaMateriaProximaEstaSendoExibidoEmNegrito(){
		assertTrue(plantao.exibiuOTituloDoBoxDeProximoEmNegrito());
	}
	
	@Test
	public void verificaSeOTituloDaMateriaDoBoxDeNavegacaoMaisRecenteEhOMesmoTituloDaMateriaDaPagina(){
		assertTrue(plantao.exibiuOTituloDoBoxProximaIgualAoTituloDaMateria());
	}
}