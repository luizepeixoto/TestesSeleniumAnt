package testes.fotogaleria;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Rule;
import org.junit.Test;

import pages.fotogaleria.FotogaleriaHome;

import br.com.infoglobo.pages.Navegador;
import br.com.infoglobo.pages.RegraTirarScreenShot;

public class FotogaleriaHomeMenuTest {
	
	private static FotogaleriaHome fotogaleria;
	
	@Rule
	public RegraTirarScreenShot tirarScreenShot = new RegraTirarScreenShot(fotogaleria.getDriver());
	
	@BeforeClass
	public static void antesDeCadaTeste() throws Exception {
		fotogaleria = new FotogaleriaHome(Navegador.CHROME);
		fotogaleria.esperaCarregar(4);
	}

	@AfterClass
	public static void depoisDeCadaTeste() {
		fotogaleria.fechar();
	}
	
	@Test
	public void verificaSeOTituloDaEditoriaDeFotogaleriasEstaSendoExibidoCorretamente(){
		String tituloEsperado = "FOTOGALERIAS";
		assertEquals(tituloEsperado, fotogaleria.exibiuTituloDaEditoriaFotogalerias());
	}
	
	@Test
	public void verificaSeAChamadaDoMenuNaoEstaExibindoOMenuEditoriasConformeEsperado(){
		assertTrue(fotogaleria.exibiuMenuDeEditorias());
	}
	
	@Test
	public void verificaSeOMenuLateralEstaExibindoOConformeEsperado(){
		assertTrue(fotogaleria.exibiuMenuLateral()); /*Correção - DE5337*/
	}
}