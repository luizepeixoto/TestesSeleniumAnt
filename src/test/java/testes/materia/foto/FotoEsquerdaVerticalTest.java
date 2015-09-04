package testes.materia.foto;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.awt.AWTException;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.By;

import pages.materia.foto.MateriaComFotoEsquerdaVertical;

import br.com.infoglobo.pages.Navegador;
import br.com.infoglobo.pages.OrdemExecucaoTeste;
import br.com.infoglobo.pages.OrdenadorTestes;
import br.com.infoglobo.pages.RegraTirarScreenShot;

@RunWith(OrdenadorTestes.class)
public class FotoEsquerdaVerticalTest {
	
	private static MateriaComFotoEsquerdaVertical materia;
	
	@Rule
	public RegraTirarScreenShot tirarScreenShot = new RegraTirarScreenShot(materia.getDriver());
	
	@BeforeClass
	public static void antesDeCadaTeste() throws Exception {
		materia = new MateriaComFotoEsquerdaVertical(Navegador.CHROME);
		materia.executarScroll(materia.getDriver().findElement(By.className("esquerda")).getLocation());
	}

	@AfterClass
	public static void depoisDeCadaTeste() {
		materia.fechar();
	}
	
	@OrdemExecucaoTeste(Ordem = 1)
	@Test
	public void verificaSeAMateriaPossuiUmaFotoInlineDoTipoEsquerdaVertical(){
		assertNotNull(materia.exibiuFotoEsquerdaVertical());
	}
	
	@OrdemExecucaoTeste(Ordem = 2)
	@Test
	public void verificaSeOCropDaFotoEsquerdaVerticalEstaCorreto(){
		assertTrue(materia.exibiuFotoEsquerdaVerticalComOCropCorreto());
	}
	
	@Test
	public void verificaSeAFotoInlineEsquerdaVerticalPossuiOWidthCorreto(){
		assertTrue(materia.exibiuFotoEsquerdaVerticalComWidthCorreto());
	}

	@OrdemExecucaoTeste(Ordem = 3)
	@Test
	public void verificaSeAFotoInlineEsquerdaVerticalPossuiOHeightCorreto(){
		assertTrue(materia.exibiuFotoEsquerdaVerticalComHeightCorreto());
	}

	@OrdemExecucaoTeste(Ordem = 4)
	@Test
	public void verificaSeALegendaDaFotoInlineEsquerdaVerticalEstaSendoExibida() throws AWTException{
		materia.executaMouseOverNaImagem();
		assertTrue(materia.exibiuLegendaParaFotoEsquerdaVertical());
	}

	@OrdemExecucaoTeste(Ordem = 5)
	@Test
	public void verificaSeALegendaDaFotoEsquerdaVerticalPossuiAFonteOGloboCondensed() throws AWTException{
		assertTrue(materia.exibiuAFonteOGloboCondensedParaALegendaDaFotoEsquerdaVertical());
	}

	@OrdemExecucaoTeste(Ordem = 6)
	@Test
	public void verificaSeALegendaDaFotoEsquerdaVerticalOTamanhoDe15px() throws AWTException{
		assertTrue(materia.exibiuOTamanhoDe15pxParaALegendaDaFotoEsquerdaVertical());
	}

	@OrdemExecucaoTeste(Ordem = 7)
	@Test  
	public void verificaSeALegendaDaFotoInlineEsquerdaVerticalEstaExibindoOAutor() throws AWTException{
		assertTrue(materia.exibiuAutorNaLegenda());
	}

	@OrdemExecucaoTeste(Ordem = 8)
	@Test
	public void verificaSeOTextoDaMateriaEstaSendoExibido(){
		assertTrue(materia.exibiuTextoNaMateria());
	}
}