package testes.temporeal;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Rule;
import org.junit.Test;
import org.openqa.selenium.By;

import pages.temporeal.Cronica;

import br.com.infoglobo.pages.Navegador;
import br.com.infoglobo.pages.RegraTirarScreenShot;

public class CronicaTest {
	
	private static Cronica tempoReal;
	
	@Rule
	public RegraTirarScreenShot tirarScreenShot = new RegraTirarScreenShot(tempoReal.getDriver());
	
	@BeforeClass
	public static void iniciarExecucaoTestes() throws Exception {
		tempoReal = new Cronica(Navegador.CHROME);
		tempoReal.esperaCarregar3Segundos();
		tempoReal.executarScroll(tempoReal.getDriver().findElement(By.className("timeline-tempo-real")).getLocation());
	}
	
	@AfterClass
	public static void finalizaTeste() {
		tempoReal.fechar();
	}
	
	@Test
	public void exibiuBoxDeCronica(){
		assertNotNull(tempoReal.exibiuBoxDeCronica());
	}
	
	@Test
	public void exibiuEditoriaCronica(){
		assertTrue(tempoReal.exibiuEditoriaCronica());
	}
	
	@Test
	public void exibiuAncoraNoTopoDaPagina(){
		assertTrue(tempoReal.exibiuAncoraNoTopoDaPagina());
	}
	
	@Test
	public void exibiuTextoCorretoNaAncora(){
		assertTrue(tempoReal.exibiuTextoCorretoNaAncora());
	}
	
	@Ignore
	@Test
	public void exibiuLinkValidoNaAncora(){
		assertTrue(tempoReal.exibiuLinkValidoNaAncora());
	}
	
	@Test
	public void exibiuTituloDaCronica(){
		assertTrue(tempoReal.exibiuTitulo());
	}
	
	@Test
	public void exibiuAutorDaCronica(){
		assertTrue(tempoReal.exibiuAutor());
	}
	
	@Test
	public void exibiuTextoDaCronica(){
		assertTrue(tempoReal.exibiuTexto());
	}
	
	@Test
	public void exibiuImagem(){
		assertTrue(tempoReal.exibiuImagem());
	}
	
	@Test
	public void exibiuWidthCorretoParaAImagem(){
		assertTrue(tempoReal.getWidth());
	}
	
	@Test
	public void exibiuHeightCorretoParaAImagem(){
		assertTrue(tempoReal.getHeight());
	}
	
	@Test
	public void exibiuLegendaDaImagem(){
		assertTrue(tempoReal.exibiuLegenda());
	}
}