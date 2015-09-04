package testes.fotogaleria;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Rule;
import org.junit.Test;
import org.openqa.selenium.By;

import pages.fotogaleria.FotogaleriaHome;

import br.com.infoglobo.pages.Navegador;
import br.com.infoglobo.pages.RegraTirarScreenShot;

public class FotogaleriaHomeMaisVistasTest {
	
	private static FotogaleriaHome fotogaleria;
	
	@Rule
	public RegraTirarScreenShot tirarScreenShot = new RegraTirarScreenShot(fotogaleria.getDriver());
	
	@BeforeClass
	public static void antesDeCadaTeste() throws Exception {
		fotogaleria = new FotogaleriaHome(Navegador.CHROME);
		fotogaleria.esperaCarregar3Segundos();
		fotogaleria.executarScroll(fotogaleria.getDriver().findElement(By.className("title")).getLocation());
	}

	@AfterClass
	public static void depoisDeCadaTeste() {
		fotogaleria.fechar();
	}
	
	@Test
	public void verificaSeOSeBoxDeMaisVistasEstaSendoExibidoNaPagina(){
		assertTrue(fotogaleria.exibiuOBoxDeMaisVistas());
	}
	
	@Test
	public void verificaSeOTituloDoBoxDeMaisVistasEstaSendoExibidoNoTopoDaPagina(){
		String tituloEsperado = "MAIS VISTAS";
		assertEquals(tituloEsperado, fotogaleria.exibiuTituloDeMaisVistas());
	}
	
	@Test
	public void verificaSeEstaSendoExibidoNoMaximoTresFotogalerias(){
		assertTrue(fotogaleria.exibiuTresFotogaleriasNoBoxDeMaisVistas());
	}
	
	@Test
	public void verificaSeAsFotogaleriasDeMaisVistasEstaoExibindoUmaImagem(){
		assertTrue(fotogaleria.exibiuUmaImagemParaCadaUmaDasFotogaleriasDoBoxDeMaisVistas());
	}
	
	@Test
	public void verificaSeAsFotogaleriasDoBoxDeMaisVistasEstaoExibindoUmLinkNaImagem(){
		assertTrue(fotogaleria.exibiuUmLinkNasImagensDasFotogaleriasDoBoxDeMaisVistas());
	}
	
	@Test
	public void verificaSeAsFotogaleriasDoBoxDeMaisVistasEstaoExibindoAImagemComOCropCorreto(){
		assertTrue(fotogaleria.exibiuCropCorretoParaAsImagensDasFotogaleriasDoBoxDeMaisVistas());
	}
	
	@Test
	public void verificaSeAsFotogaleriasDoBoxDeMaisVistasEstaoExibindoOWidthCorreto(){
		assertTrue(fotogaleria.exibiuWidthCorretoParaAsImagensDasFotogaleriasDoBoxDeMaisVistas());
	}
	
	@Test
	public void verificaSeAsFotogaleriasDoBoxDeMaisVistasEstaoExibindoOHeightCorreto(){
		assertTrue(fotogaleria.exibiuHeightCorretoParaAsImagensDasFotogaleriasDoBoxDeMaisVistas());
	}
	
	@Test
	public void verificaSeAsFotogaleriasDoBoxDeMaisVistasEstaoExibindoUmTitulo(){
		assertTrue(fotogaleria.exibiuUmTituloParaAsImagensDasFotogaleriasDoBoxDeMaisVistas());
	}
	
	@Test
	public void verificaSeOTituloDasFotogaleriasDoBoxDeMaisVistasEstaSendoExibindosCorretamente(){
		assertTrue(fotogaleria.exibiuFonteETamanhoDaImagemCorretamenteParasTituloDasFotogaleriasDoBoxDeMaisVistas());
	}
	 
	@Test
	public void verificaSeOBannerArrobaSendoExibindoCorretamente(){
		assertTrue(fotogaleria.exibiuBannerArroba());
	}
}