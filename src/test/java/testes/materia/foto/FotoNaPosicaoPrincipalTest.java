package testes.materia.foto;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Rule;
import org.junit.Test;

import pages.materia.foto.MateriaComFotoPosicaoPrincipal;

import br.com.infoglobo.pages.Navegador;
import br.com.infoglobo.pages.RegraTirarScreenShot;

public class FotoNaPosicaoPrincipalTest {
	
	private static MateriaComFotoPosicaoPrincipal materia;
	
	@Rule
	public RegraTirarScreenShot tirarScreenShot = new RegraTirarScreenShot(materia.getDriver());
	
	@BeforeClass
	public static void antesDeCadaTeste() throws Exception {
		materia = new MateriaComFotoPosicaoPrincipal(Navegador.CHROME);
	}

	@AfterClass
	public static void depoisDeCadaTeste() {
		materia.fechar();
	}
	
	@Test
	public void verificaSeAFotoPrimeiraPosicaoEstaSendoExibidaNaPosicaoPrincipal(){
		assertNotNull(materia.exibiuFotoNaPrimeiraPosicao());
	}
	
	@Test
	public void verificaSeOCropDaFotoNaPosicaoPrincipalEstaCorreto(){
		assertTrue(materia.exibiuFotoNaPosicaoPrincipalComOCropCorreto());
	}
	
	@Test
	public void verificaSeOWidthDaFotoPrimeiraPosicaoEhDe1260px(){
		assertTrue(materia.exibiuFotoNaPrimeiraPosicaoComWidthCorreto());
	}
	
	@Test
	public void verificaSeOHeightDaFotoPrimeiraPosicaoEhDe550px(){
		assertTrue(materia.exibiuFotoNaPrimeiraPosicaoComHeightCorreto());
	}
	
	@Test
	public void verificaSeALegendaDaFotoPrimeiraPosicaoEstaSendoExibida(){
		assertTrue(materia.exibiuLegendaparaFotoPrincipal());
	}
	
	@Test
	public void verificaSeALegendaDaFotoDePrimeiraPosicaoPossuiAFonteArial(){
		assertTrue(materia.exibiuAFonteArialParaALegendaDaFotoDePrimeiraPosicao());
	}
	
	@Test
	public void verificaSeALegendaDaFotoDePrimeiraPosicaoPossuiOTamanhoDe13px(){
		assertTrue(materia.exibiuOTamanhoDe13pxParaParaALegendaDaFotoDePrimeiraPosicao());
	}
	
	@Test
	public void verificaSeALegendaDaFotoPrimeiraPosicaoEstaExibindoOAutorEmNegrito(){
		assertTrue(materia.exibiuAutorNaLegenda());
	}
	
	@Test
	public void verificaSeLogoAbaixoDaLegendaExisteUmDivisorHR(){
		assertTrue(materia.exibiuUmTagHRAbaixoDaFotoPrincipal());
	}
}