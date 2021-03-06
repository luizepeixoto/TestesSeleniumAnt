package testes.materia.foto;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Rule;
import org.junit.Test;

import pages.materia.foto.MateriaComFotoCentroGrande;

import br.com.infoglobo.pages.Navegador;
import br.com.infoglobo.pages.RegraTirarScreenShot;

public class FotoCentroGrandeTest {
	
	private static MateriaComFotoCentroGrande materia;
	
	@Rule
	public RegraTirarScreenShot tirarScreenShot = new RegraTirarScreenShot(materia.getDriver());
	
	@BeforeClass
	public static void antesDeCadaTeste() throws Exception {
		materia = new MateriaComFotoCentroGrande(Navegador.CHROME);
	}

	@AfterClass
	public static void depoisDeCadaTeste() {
		materia.fechar();
	}
	
	@Test
	public void verificaSeAImagemInlineCentroGrandeEstaSendoExibidaNaMateria(){
		assertNotNull(materia.exibiuFotoCentroGrande());
	}
	
	@Test
	public void verificaSeOCropDaImagemInlineCentroGrandeEstaCorreto(){
		assertTrue(materia.exibiuFotoCentroGrandeComOCropCorreto());
	}
	
	@Test
	public void verificaSeOWidthDaImagemInlineCentroGrandeEhDe700px(){
		assertTrue(materia.exibiuFotoCentroGrandeComWidthCorreto());
	}
	
	@Test
	public void verificaSeOHeightDaImagemInlineCentroGrandeEhDe420px(){
		assertTrue(materia.exibiuFotoCentroGrandeComHeightCorreto());
	}
	
	@Test
	public void verificaSeALegendaDaImagemInlineCentroGrandeEstaSendoExibida(){
		assertTrue(materia.exibiuLegendaparaFotoCentroGrande());
	}
	
	@Test
	public void verificaSeALegendaDaFotoInlineCentroGrandePossuiAFonteArial(){
		assertTrue(materia.exibiuAFonteArialParaALegendaDaFotoInlineCentroGrande());
	}
	
	@Test
	public void verificaSeALegendaDaFotoInlineCentroGrandePossuiOTamanhoDe13px(){
		assertTrue(materia.exibiuOTamanhoDe13pxParaALegendaDaFotoInlineCentroGrande());
	}
	
	@Test  
	public void VerificaSeOAutorDaImagemInlineCentroGrandeEstaSendoExibidoOAutorEmNegrito(){
		assertTrue(materia.exibiuAutorNaLegenda());
	}
	
	@Test
	public void verificaSeOTextoDaMateriaEstaSendoExibido(){
		assertTrue(materia.exibiuTextoNaMateria());
	}
}