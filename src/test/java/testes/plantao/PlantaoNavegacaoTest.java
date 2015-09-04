package testes.plantao;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import pages.plantao.PlantaoNavegacao;

import br.com.infoglobo.pages.Navegador;

public class PlantaoNavegacaoTest {
	
	private static PlantaoNavegacao plantao;
	
	@BeforeClass
	public static void antesDeCadaTeste() throws Exception {
		plantao = new PlantaoNavegacao(Navegador.CHROME);
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
	public void verificaSeOBoxDeNavegacaoParaAPlantaoAnteriorEstaSendoExibido(){
		assertNotNull(plantao.exibiuBoxDeNavegacaoAnterior());
	}
	
	@Test
	public void verificaSeOBoxDeNavegacaoAnteriorPossuiUmLink(){
		assertTrue(plantao.exibiuUmLinkNoNoBoxDeNavegacaoAnterior());
	}
	
	@Test
	public void verificaSeOLinkDeNavegacaoMaisAntigaEhValido(){
		assertTrue(plantao.getBoxPaginacaoAntigaLinkValido());
	}
	
	@Test
	public void verificaSeOTituloAnteriorEstaSendoExibido(){
		String tituloEsperado = "ANTERIOR";
		assertEquals(tituloEsperado, plantao.getBoxPaginacaoAntigaTitulo());
	}
	
	@Test
	public void verificaSeOTituloDaPlantaoMaisAntigaEstaSendoExibidoEmNegrito(){
		assertTrue(plantao.exibiuTituloDoPlantaoAnteriorEmNegrito());
	}
	
	@Test
	public void verificaSeOBoxDeNavegacaoParaAPlantaoMaisRecenteEstaSendoExibido(){
		assertNotNull(plantao.exibiuPaginacaoProxima());
	}
	
	@Test
	public void verificaSeOBoxDeNavegacaoMaisRecentePossuiUmLink(){
		assertTrue(plantao.getBoxPaginacaoRecenteLink());
	}
	
	@Test
	public void verificaSeOLinkDeNavegacaoMaisRecenteEhValido(){
		assertTrue(plantao.getBoxPaginacaoRecenteLinkValido());
	}
	
	@Test
	public void verificaSeOTituloMaisRecenteEstaSendoExibidoEmUmaFonteDiferente(){
		String tituloEsperado = "PRÓXIMA";
		assertEquals(tituloEsperado, plantao.getBoxPaginacaoRecenteTitulo());
	}
	
	@Test
	public void verificaSeOTituloDaPlantaoMaisRecenteEstaSendoExibidoEmNegrito(){
		assertTrue(plantao.exibiuTituloDPlantaoProximaEmNegrito());
	}
}