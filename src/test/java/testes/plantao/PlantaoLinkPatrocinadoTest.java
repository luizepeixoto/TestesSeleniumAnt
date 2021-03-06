package testes.plantao;

import static org.junit.Assert.*;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import pages.plantao.Plantao;


public class PlantaoLinkPatrocinadoTest {
	
	private static Plantao paginaDePlantao;
	
	@BeforeClass
	public static void antesDeCadaTeste() throws Exception {
		paginaDePlantao = new Plantao();
	}

	@AfterClass
	public static void depoisDeCadaTeste() {
		paginaDePlantao.fechar();
	}
	
	@Test
	public void verificaSeOBoxDaPropagandaArrobaEstaSendoExibido(){
		assertNotNull(paginaDePlantao.exibiuBoxDaArroba());
	}
	
	@Test
	public void verificaSeOBoxDeLinkPatrocinadosEstaSendoExibidoNoFimDaPagina(){
		assertNotNull(paginaDePlantao.exibiuBoxDeLinkPatrocinado());
	}
}