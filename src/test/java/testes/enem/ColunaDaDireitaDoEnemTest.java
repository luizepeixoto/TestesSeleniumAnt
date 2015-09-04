package testes.enem;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import pages.enem.EnemIframe;


public class ColunaDaDireitaDoEnemTest {
	
	private static EnemIframe editoria;
	
	@BeforeClass
	public static void antesDeCadaTeste() throws Exception {
		editoria = new EnemIframe();
	}
	
	@AfterClass
	public static void depoisDeCadaTeste() {
		editoria.fechar();
	}
	
	@Test
	public void verificaSeAColunaDaDireitaEstaSendoExibida(){
		assertNotNull(editoria.exibiuColunaDaDireita());
	}
	
	@Test
	public void verificaSeOBannerArrobaEstaSendoExibido(){
		assertTrue(editoria.exibiuBannerArroba());
	}
	
	@Test
	public void verificaSeOTituloPublicidadeDoBannerArrobaEstaSendoExibido(){
		assertTrue(editoria.exibiuTituloPublicidade());
	}
	
}
