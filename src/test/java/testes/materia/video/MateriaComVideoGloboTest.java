package testes.materia.video;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Rule;
import org.junit.Test;
import org.openqa.selenium.By;

import pages.materia.video.MateriaComVideoGlobo;

import br.com.infoglobo.pages.Navegador;
import br.com.infoglobo.pages.RegraTirarScreenShot;

public class MateriaComVideoGloboTest {
	
	private static MateriaComVideoGlobo materia;
	
	@Rule
	public RegraTirarScreenShot tirarScreenShot = new RegraTirarScreenShot(materia.getDriver());
	
	@BeforeClass
	public static void antesDeCadaTeste() throws Exception {
		materia = new MateriaComVideoGlobo(Navegador.CHROME);
		materia.esperaCarregar3Segundos();
		materia.executarScroll(materia.getDriver().findElement(By.className("artigo-video")).getLocation());
		materia.esperaCarregar1Segundo();
	}

	@AfterClass
	public static void depoisDeCadaTeste() {
		materia.fechar();
	}
	
	@Test
	public void verificaSeOBoxDeVideoEstaSendoExibidoNaMateria(){
		assertNotNull(materia.exibiuBoxDeVideo());
	}
	
	@Test
	public void verificaSeOVideoDaGloboPontoComEstaSendoExibido(){
		assertTrue(materia.exibiuVideoDaGloboCom());
	}
}