package testes.plantao;

import static org.junit.Assert.*;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import pages.plantao.PlantaoMultiplasFotos;

import br.com.infoglobo.pages.Navegador;
import br.com.infoglobo.pages.OrdemExecucaoTeste;
import br.com.infoglobo.pages.OrdenadorTestes;
import br.com.infoglobo.pages.RegraTirarScreenShot;

@RunWith(OrdenadorTestes.class)
public class PlantaoMultiplasFotosTest {
	
private static PlantaoMultiplasFotos plantao;
	
	@Rule
	public RegraTirarScreenShot tirarScreenShot = new RegraTirarScreenShot(plantao.getDriver());
	
	@BeforeClass
	public static void antesDeCadaTeste() throws Exception {
		plantao = new PlantaoMultiplasFotos(Navegador.CHROME);
	}

	@AfterClass
	public static void depoisDeCadaTeste() {
		plantao.fechar();
	}
	
	/*Plantão com fotos inline nesta ordem: 
	  - Foto na posição Principal; 
	  - Foto inline 1ª posicão: Centro Grande;
	  - Foto inline 2ª posicão: Esquerda Vertical;
	  - Foto inline 3ª posicão: Esquerda Grande;
	  - Foto inline 4ª posicão: Esquerda Pequena;*/
	
	/*Foto Posição Principal*/
	@OrdemExecucaoTeste(Ordem=1)
	@Test
	public void verificaSeEstaSendoExibidaUmaFotoNaPosicaoPrincipalDePlantao(){
		assertNotNull(plantao.exibiuFotoNaPrimeiraPosicao());
	}
	
	@OrdemExecucaoTeste(Ordem=2)
	@Test
	public void verificaSeOCropDaFotoNaPosicaoPrincipalEstaCorreto(){
		assertTrue(plantao.exibiuFotoNaPosicaoPrincipalComOCropCorreto());
	}
	
	@OrdemExecucaoTeste(Ordem=3)
	@Test
	public void verificaSeQueEstaSendoExibidaNaPosicaoPrincipalPossuiOWidthCorreto(){
		assertTrue(plantao.exibiuFotoNaPrimeiraPosicaoComWidthCorreto());
	}
	
	@OrdemExecucaoTeste(Ordem=4)
	@Test
	public void verificaSeQueEstaSendoExibidaNaPosicaoPrincipalPossuiOHeightCorreto(){
		assertTrue(plantao.exibiuFotoNaPrimeiraPosicaoComHeightCorreto());
	}
	
	@OrdemExecucaoTeste(Ordem=5)
	@Test
	public void verificaSeOBorderBottomDaImagemCentroGrandeEhExibido(){
		assertEquals("rgba(221, 221, 221, 1)",plantao.exibiuFotoCentroGrandeComBorderBottom());
	}
	
	
	/*Foto inline Centro Grande*/
	@OrdemExecucaoTeste(Ordem=6)
	@Test
	public void verificaSeAPrimeiraFotoInlineEhDoTipoCentroGrande(){
		assertNotNull(plantao.exibiuFotoCentroGrande());
	}
	
	@OrdemExecucaoTeste(Ordem=7)
	@Test
	public void verificaSeOCropDaImagemInlineCentroGrandeEstaCorreto(){
		assertTrue(plantao.exibiuFotoCentroGrandeComOCropCorreto());
	}
	
	@OrdemExecucaoTeste(Ordem=8)
	@Test
	public void verificaSeAPrimeiraFotoInlineCentroGrandePossuiOWidthCorreto(){
		assertTrue(plantao.exibiuFotoCentroGrandeComWidthCorreto());
	}
	
	@OrdemExecucaoTeste(Ordem=9)
	@Test
	public void verificaSeAPrimeiraFotoInlineCentroGrandePossuiOHeightCorreto(){
		assertTrue(plantao.exibiuFotoCentroGrandeComHeightCorreto());
	}
	
	
	/*Foto inline Esquerda Vertical*/
	@OrdemExecucaoTeste(Ordem=10)
	@Test
	public void verificaSeASegundaFotoInlineEhDoTipoEsquerdaVertical(){
		assertNotNull(plantao.exibiuFotoEsquerdaVertical());
	}
	
	@OrdemExecucaoTeste(Ordem=11)
	@Test
	public void verificaSeOCropDaFotoEsquerdaVerticalEstaCorreto(){
		assertTrue(plantao.exibiuFotoEsquerdaVerticalComOCropCorreto());
	}
	
	@OrdemExecucaoTeste(Ordem=12)
	@Test
	public void verificaSeASegundaFotoInlineEsquerdaVerticalPossuiOWidthCorreto(){
		assertTrue(plantao.exibiuFotoEsquerdaVerticalComWidthCorreto());
	}
	
	
	/*Foto inline Esquerda Grande*/
	@OrdemExecucaoTeste(Ordem=13)
	@Test
	public void verificaSeATerceiraFotoInlineEhDoTipoEsquerdaGrande(){
		assertNotNull(plantao.exibiuFotoEsquerdaGrande());
	}
	
	@OrdemExecucaoTeste(Ordem=14)
	@Test
	public void verificaSeOCropDaFotoEsquerdaGrandeEstaCorreto(){
		assertTrue(plantao.exibiuFotoEsquerdaGrandeComOCropCorreto());
	}
	
	@OrdemExecucaoTeste(Ordem=15)
	@Test
	public void verificaSeATerceiraFotoInlineEsquerdaGrandePossuiOWidthCorreto(){
		assertTrue(plantao.exibiuFotoEsquerdaGrandeComWidthCorreto());
	}
	
	@OrdemExecucaoTeste(Ordem=16)
	@Test
	public void verificaSeATerceiraFotoInlineEsquerdaGrandePossuiOHeightCorreto(){
		assertTrue(plantao.exibiuFotoEsquerdaGrandeComHeightCorreto());
	}
	
	/*Foto inline Esquerda Pequena*/
	@OrdemExecucaoTeste(Ordem=17)
	@Test
	public void verificaSeAQuartaFotoInlineEhDoTipoEsquerdaPequena(){
		assertNotNull(plantao.exibiuFotoEsquerdaPequena());
	}
	
	@OrdemExecucaoTeste(Ordem=18)
	@Test
	public void verificaSeOCropDaFotoEsquerdaPequenaEstaCorreto(){
		assertTrue(plantao.exibiuFotoEsquerdaPequenaComOCropCorreto());
	}
	
	@OrdemExecucaoTeste(Ordem=19)
	@Test
	public void verificaSeAQuartaFotoInlineEsquerdaPequenaPossuiOWidthCorreto(){
		assertTrue(plantao.exibiuFotoEsquerdaPequenaComWidthCorreto());
	}
	
	@OrdemExecucaoTeste(Ordem=20)
	@Test
	public void verificaSeAQuartaFotoInlineEsquerdaPequenaPossuiOHeightCorreto(){
		assertTrue(plantao.exibiuFotoEsquerdaPequenaComHeightCorreto());
	}
}

