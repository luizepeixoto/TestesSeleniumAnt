package testes.fotogaleria;

import static org.junit.Assert.assertTrue;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Rule;
import org.junit.Test;
import org.openqa.selenium.By;

import pages.fotogaleria.FotogaleriaHome;

import br.com.infoglobo.pages.Navegador;
import br.com.infoglobo.pages.RegraTirarScreenShot;

public class FotogaleriaHomeTest {
	
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
	public void verificaSeOTituloDeRecomendadasEstaSendoExibidoNoTopoDaPagina(){
		assertTrue(fotogaleria.exibiuTituloDeRecomendadas());
	}
	
	@Test
	public void verificaSeEstaSendoExibidoUmaListaDeFotogalerias(){
		assertTrue(fotogaleria.exibiuUmaListaDeFotogalerias());
	}
	
	@Test
	public void verificaSeAsFotogaleriasEstaoExibindoUmaImagem(){
		assertTrue(fotogaleria.exibiuUmaImagemParaCadaUmaDasFotogalerias());
	}
	
	@Test
	public void verificaSeAsFotogaleriasEstaoExibindoUmLinkNaImagem(){
		assertTrue(fotogaleria.exibiuUmLinkNasImagensDasFotogalerias());
	}
	
	@Test
	public void verificaSeAsFotogaleriasEstaoExibindoAImagemComOCropCorreto(){
		assertTrue(fotogaleria.exibiuCropCorretoParaAsImagensDasFotogalerias());
	}
	
	@Test
	public void verificaSeAsFotogaleriasEstaoExibindoOWidthCorreto(){
		assertTrue(fotogaleria.exibiuWidthCorretoParaAsImagensDasFotogalerias());
	}
	
	@Test
	public void verificaSeAsFotogaleriasEstaoExibindoOEfeitoDeHoverNasImagens(){
		assertTrue(fotogaleria.exibiuEfeitoDeHoverParaAsImagensDasFotogalerias());
	}
	
	@Test
	public void verificaSeAsFotogaleriasEstaoExibindoOHeightCorreto(){
		assertTrue(fotogaleria.exibiuHeightCorretoParaAsImagensDasFotogalerias());
	}
	
	@Test
	public void verificaSeAsFotogaleriasEstaoExibindoUmTitulo(){
		assertTrue(fotogaleria.exibiuUmTituloParaAsImagensDasFotogalerias());
	}
	
	@Test
	public void verificaSeOTituloDasFotogaleriasEstaSendoExibindosCorretamente(){
		assertTrue(fotogaleria.exibiuFonteETamanhoDaImagemCorretamenteParasTituloDasFotogalerias());
	}
}