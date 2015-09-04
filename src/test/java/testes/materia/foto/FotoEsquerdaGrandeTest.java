package testes.materia.foto;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Rule;
import org.junit.Test;
import org.openqa.selenium.By;

import pages.materia.foto.MateriaComFotoEsquerdaGrande;

import br.com.infoglobo.pages.Navegador;
import br.com.infoglobo.pages.OrdemExecucaoTeste;
import br.com.infoglobo.pages.RegraTirarScreenShot;

public class FotoEsquerdaGrandeTest {
	
	private static MateriaComFotoEsquerdaGrande materia;
	
	@Rule
	public RegraTirarScreenShot tirarScreenShot = new RegraTirarScreenShot(materia.getDriver());
	
	@BeforeClass
	public static void antesDeCadaTeste() throws Exception {
		materia = new MateriaComFotoEsquerdaGrande(Navegador.CHROME);
	}

	@AfterClass
	public static void depoisDeCadaTeste() {
		materia.fechar();
	}
	
	@OrdemExecucaoTeste(Ordem=1)
	@Test
	public void verificaSeATerceiraFotoInlineEhDoTipoEsquerdaGrande() throws InterruptedException {
		materia.executarScroll(materia.conteudoInlineDaMateria().findElement(By.className("esquerda")).findElement(By.tagName("img")).getLocation());
		materia.esperaCarregar2Segundos();
		assertNotNull(materia.exibiuFotoEsquerdaGrande());
	}
	
	@OrdemExecucaoTeste(Ordem=2)
	@Test
	public void verificaSeATerceiraFotoInlineEsquerdaGrandePossuiOWidthCorreto(){
		assertTrue(materia.exibiuFotoEsquerdaGrandeComWidthCorreto());
	}
	
	@OrdemExecucaoTeste(Ordem=3)
	@Test
	public void verificaSeATerceiraFotoInlineEsquerdaGrandePossuiOHeightCorreto(){
		assertTrue(materia.exibiuFotoEsquerdaGrandeComHeightCorreto());
	}
	
	@OrdemExecucaoTeste(Ordem=4)
	@Test
	public void verificaSeALegendaDaFotoInlineEsquerdaGrandeEstaSendoExibida() {
		materia.executaMouseOverNaImagem();
		assertTrue(materia.exibiuLegendaparaFotoEsquerdaGrande());
	}
	
	@OrdemExecucaoTeste(Ordem=5)
	@Test
	public void verificaSeALegendaDaFotoEsquerdaGrandePossuiAFonteOGloboCondensed(){
		materia.executaMouseOverNaImagem();
		assertTrue(materia.exibiuAFonteOGloboCondensedParaALegendaDaFotoEsquerdaGrande());
	}
	
	@OrdemExecucaoTeste(Ordem=6)
	@Test
	public void verificaSeALegendaDaFotoEsquerdaGrandeOTamanhoDe15px(){
		materia.executaMouseOverNaImagem();
		assertTrue(materia.exibiuOTamanhoDe15pxParaALegendaDaFotoEsquerdaGrande());
	}
	
	@OrdemExecucaoTeste(Ordem=7)
	@Test  
	public void verificaSeALegendaDaFotoInlineEsquerdaGrandeEstaExibindoOAutor() {
		materia.executaMouseOverNaImagem();
		assertTrue(materia.exibiuAutorNaLegenda());
	}
	
	@OrdemExecucaoTeste(Ordem=8)
	@Test
	public void verificaSeOTextoDaMateriaEstaSendoExibido(){
		assertTrue(materia.exibiuTextoNaMateria());
	}
}