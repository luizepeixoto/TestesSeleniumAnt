package testes.materia.video;

import static org.junit.Assert.*;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Rule;
import org.junit.Test;
import org.openqa.selenium.By;

import pages.materia.video.MateriaComVideoLivestream;

import br.com.infoglobo.pages.Navegador;
import br.com.infoglobo.pages.RegraTirarScreenShot;

public class MateriaComVideoLivestreamTest {
	
	private static MateriaComVideoLivestream materia;
	
	@Rule
	public RegraTirarScreenShot tirarScreenShot = new RegraTirarScreenShot(materia.getDriver());
	
	@BeforeClass
	public static void antesDeCadaTeste() throws Exception {
		materia = new MateriaComVideoLivestream(Navegador.CHROME);
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
		assertTrue(materia.exibiuBoxDeVideo());
	}
	
	@Test
	public void verificaSeOVideoDoLivestreamEstaSendoExibido(){
		assertTrue(materia.getVideoLivestream());
	}
}