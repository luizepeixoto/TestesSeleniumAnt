package testes.plantao;

import static org.junit.Assert.assertTrue;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import pages.plantao.PlantaoDoVaiRio;


public class PlantaoVaiRioTest {
	
	private static PlantaoDoVaiRio plantao;
	
	@BeforeClass
	public static void antesDeCadaTeste() throws Exception {
		plantao = new PlantaoDoVaiRio();
	}

	@AfterClass
	public static void depoisDeCadaTeste() {
		plantao.fechar();
	}
	
	@Test
	public void verificaSeAposDesativacaoDaEditoriaDoVaiRioOsPlantoesContinuamSendoExibidos(){
		assertTrue(plantao.exibiuPaginaDePlantao());
	}
	
	@Test
	public void verificaSeADataDeUmPlantaoJaDesativadoDoVaiRioEstaSendoExibido(){
		assertTrue(plantao.exibiuData());
	}
	
	@Test
	public void verificaSeAEditoriaDeUmPlantaoJaDesativadoDoVaiRioEstaSendoExibido(){
		assertTrue(plantao.exibiuEditoria());
	}
	
	@Test
	public void verificaSeOTituloDeUmPlantaoJaDesativadoDoVaiRioEstaSendoExibido(){
		assertTrue(plantao.exibiuTitulo());
	}
	
	@Test
	public void verificaSeADescricaoDeUmPlantaoJaDesativadoDoVaiRioEstaSendoExibido(){
		assertTrue(plantao.exibiuTextoDoPlantao());
	}
}