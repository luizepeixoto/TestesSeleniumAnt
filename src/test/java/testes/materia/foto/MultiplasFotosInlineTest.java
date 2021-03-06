package testes.materia.foto;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Rule;
import org.junit.Test;

import pages.materia.foto.MateriaComMultiplasFotos;

import br.com.infoglobo.pages.Navegador;
import br.com.infoglobo.pages.RegraTirarScreenShot;

public class MultiplasFotosInlineTest {
	
	private static MateriaComMultiplasFotos materia;
	
	@Rule
	public RegraTirarScreenShot tirarScreenShot = new RegraTirarScreenShot(materia.getDriver());
	
	@BeforeClass
	public static void antesDeCadaTeste() throws Exception {
		materia = new MateriaComMultiplasFotos(Navegador.CHROME);
	}

	@AfterClass
	public static void depoisDeCadaTeste() {
		materia.fechar();
	}
	
	/*Matéria com fotos inline nesta ordem: 
	  - Foto na posição Principal; 
	  - Foto inline 1ª posicão: Centro Grande;
	  - Foto inline 2ª posicão: Esquerda Vertical;
	  - Foto inline 3ª posicão: Esquerda Grande;
	  - Foto inline 4ª posicão: Esquerda Pequena;*/
	
	/*Foto Posição Principal*/
	@Test
	public void verificaSeEstaSendoExibidaUmaFotoNaPosicaoPrincipalDaMateria(){
		assertNotNull(materia.exibiuFotoNaPrimeiraPosicao());
	}
	
	@Test
	public void verificaSeOCropDaFotoNaPosicaoPrincipalEstaCorreto(){
		assertTrue(materia.exibiuFotoNaPosicaoPrincipalComOCropCorreto());
	}
	
	@Test
	public void verificaSeQueEstaSendoExibidaNaPosicaoPrincipalPossuiOWidthCorreto(){
		assertTrue(materia.exibiuFotoNaPrimeiraPosicaoComWidthCorreto());
	}
	
	@Test
	public void verificaSeQueEstaSendoExibidaNaPosicaoPrincipalPossuiOHeightCorreto(){
		assertTrue(materia.exibiuFotoNaPrimeiraPosicaoComHeightCorreto());
	}
	
	@Test
	public void verificaSeALegendaDaFotoDePrimeiraPosicaoPossuiAFonteArial(){
		assertTrue(materia.exibiuAFonteArialParaALegendaDaFotoDePrimeiraPosicao());
	}
	
	@Test
	public void verificaSeALegendaDaFotoDePrimeiraPosicaoPossuiOTamanhoDe13px(){
		assertTrue(materia.exibiuOTamanhoDe13pxParaParaALegendaDaFotoDePrimeiraPosicao());
	}
	
	/*Foto inline Centro Grande*/
	@Test
	public void verificaSeAPrimeiraFotoInlineEhDoTipoCentroGrande(){
		assertNotNull(materia.exibiuFotoCentroGrande());
	}
	
	@Test
	public void verificaSeOCropDaImagemInlineCentroGrandeEstaCorreto(){
		assertTrue(materia.exibiuFotoCentroGrandeComOCropCorreto());
	}
	
	@Test
	public void verificaSeAPrimeiraFotoInlineCentroGrandePossuiOWidthCorreto(){
		assertTrue(materia.exibiuFotoCentroGrandeComWidthCorreto());
	}
	
	@Test
	public void verificaSeAPrimeiraFotoInlineCentroGrandePossuiOHeightCorreto(){
		assertTrue(materia.exibiuFotoCentroGrandeComHeightCorreto());
	}
	
	@Test
	public void verificaSeALegendaDaFotoInlineCentroGrandePossuiAFonteArial(){
		assertTrue(materia.exibiuAFonteArialParaALegendaDaFotoInlineCentroGrande());
	}
	
	@Test
	public void verificaSeALegendaDaFotoInlineCentroGrandePossuiOTamanhoDe13px(){
		assertTrue(materia.exibiuOTamanhoDe13pxParaALegendaDaFotoInlineCentroGrande());
	}
	
	/*Foto inline Esquerda Vertical*/
	@Test
	public void verificaSeASegundaFotoInlineEhDoTipoEsquerdaVertical(){
		assertNotNull(materia.exibiuFotoEsquerdaVertical());
	}
	
	@Test
	public void verificaSeOCropDaFotoEsquerdaVerticalEstaCorreto(){
		assertTrue(materia.exibiuFotoEsquerdaVerticalComOCropCorreto());
	}
	
	@Test
	public void verificaSeASegundaFotoInlineEsquerdaVerticalPossuiOWidthCorreto(){
		assertTrue(materia.exibiuFotoEsquerdaVerticalComWidthCorreto());
	}
	
	@Test
	public void verificaSeASegundaFotoInlineEsquerdaVerticalPossuiOHeightCorreto(){
		assertTrue(materia.exibiuFotoEsquerdaVerticalComHeightCorreto());
	}
	
	/*Foto inline Esquerda Grande*/
	@Test
	public void verificaSeATerceiraFotoInlineEhDoTipoEsquerdaGrande(){
		assertNotNull(materia.exibiuFotoEsquerdaGrande());
	}
	
	@Test
	public void verificaSeOCropDaFotoEsquerdaGrandeEstaCorreto(){
		assertTrue(materia.exibiuFotoEsquerdaGrandeComOCropCorreto());
	}
	
	@Test
	public void verificaSeATerceiraFotoInlineEsquerdaGrandePossuiOWidthCorreto(){
		assertTrue(materia.exibiuFotoEsquerdaGrandeComWidthCorreto());
	}
	
	@Test
	public void verificaSeATerceiraFotoInlineEsquerdaGrandePossuiOHeightCorreto(){
		assertTrue(materia.exibiuFotoEsquerdaGrandeComHeightCorreto());
	}
	
	/*Foto inline Esquerda Pequena*/
	@Test
	public void verificaSeAQuartaFotoInlineEhDoTipoEsquerdaPequena(){
		assertNotNull(materia.exibiuFotoEsquerdaPequena());
	}
	
	@Test
	public void verificaSeOCropDaFotoEsquerdaPequenaEstaCorreto(){
		assertTrue(materia.exibiuFotoEsquerdaPequenaComOCropCorreto());
	}
	
	@Test
	public void verificaSeAQuartaFotoInlineEsquerdaPequenaPossuiOWidthCorreto(){
		assertTrue(materia.exibiuFotoEsquerdaPequenaComWidthCorreto());
	}
	
	@Test
	public void verificaSeAQuartaFotoInlineEsquerdaPequenaPossuiOHeightCorreto(){
		assertTrue(materia.exibiuFotoEsquerdaPequenaComHeightCorreto());
	}
}