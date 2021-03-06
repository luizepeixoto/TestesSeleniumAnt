package testes.plantao;

import static org.junit.Assert.assertTrue;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import pages.plantao.Plantao;


public class PaginaDePlantaoTest {
	
	private static Plantao plantao;
	
	@BeforeClass
	public static void antesDeCadaTeste() throws Exception {
		plantao = new Plantao();
	}

	@AfterClass
	public static void depoisDeCadaTeste() {
		plantao.fechar();
	}
	
	@Test
	public void exibiuDataDoPlatao(){
		assertTrue(plantao.exibiuData());
	}
	
	@Test
	public void exibiuEditoriaDoPlatao(){
		assertTrue(plantao.exibiuEditoria());
	}
	
	@Test
	public void exibiuTituloDoPlatao(){
		assertTrue(plantao.exibiuTitulo());
	}
	
	@Test
	public void exibiuFoto(){
		assertTrue(plantao.exibiuFoto());
	}
	
	@Test
	public void exibiuWidthCorretoParaFoto(){
		assertTrue(plantao.exibiuWidth());
	}
	
	@Test
	public void exibiuHeightCorretoParaFoto(){
		assertTrue(plantao.exibiuHeight());
	}
	
	@Test
	public void exibiuTextoDoPlantao(){
		assertTrue(plantao.exibiuTextoDoPlantao());
	}
}