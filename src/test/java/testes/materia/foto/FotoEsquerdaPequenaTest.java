package testes.materia.foto;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.By;

import pages.materia.foto.MateriaComFotoEsquerdaPequena;

import br.com.infoglobo.pages.Navegador;
import br.com.infoglobo.pages.OrdemExecucaoTeste;
import br.com.infoglobo.pages.OrdenadorTestes;
import br.com.infoglobo.pages.RegraTirarScreenShot;

@RunWith(OrdenadorTestes.class)
public class FotoEsquerdaPequenaTest {
	
	private static MateriaComFotoEsquerdaPequena materia;
	
	@Rule
	public RegraTirarScreenShot tirarScreenShot = new RegraTirarScreenShot(materia.getDriver());
	
	@BeforeClass
	public static void antesDeCadaTeste() throws Exception {
		materia = new MateriaComFotoEsquerdaPequena(Navegador.CHROME);
	}

	@AfterClass
	public static void depoisDeCadaTeste() {
		materia.fechar();
	}
	
	@OrdemExecucaoTeste(Ordem=1)
	@Test
	public void verificaSeAQuartaFotoInlineEhDoTipoEsquerdaPequena() throws InterruptedException{
		materia.executarScroll(materia.conteudoInlineDaMateria().findElement(By.className("artigo-imagem")).findElement(By.tagName("img")).getLocation());
		materia.esperaCarregar2Segundos();
		assertNotNull(materia.exibiuFotoEsquerdaPequena());
	}
	
	@OrdemExecucaoTeste(Ordem=2)
	@Test
	public void verificaSeOCropDaFotoEsquerdaPequenaEstaCorreto(){
		assertTrue(materia.exibiuFotoEsquerdaPequenaComOCropCorreto());
	}
	
	@OrdemExecucaoTeste(Ordem=3)
	@Test
	public void verificaSeAQuartaFotoInlineEsquerdaPequenaPossuiOWidthCorreto(){
		assertTrue(materia.exibiuFotoEsquerdaPequenaComWidthCorreto());
	}
	
	@OrdemExecucaoTeste(Ordem=4)
	@Test
	public void verificaSeAQuartaFotoInlineEsquerdaPequenaPossuiOHeightCorreto(){
		assertTrue(materia.exibiuFotoEsquerdaPequenaComHeightCorreto());
	}
	
	@OrdemExecucaoTeste(Ordem=5)
	@Test
	public void verificaSeALegendaDaFotoInlineEsquerdaPequenaEstaSendoExibida() throws InterruptedException {
		materia.executaMouseOverNaImagem();
		materia.esperaCarregar1Segundo();
		assertTrue(materia.exibiuLegendaparaFotoEsquerdaPequena());
	}
	
	@OrdemExecucaoTeste(Ordem=6)
	@Test
	public void verificaSeALegendaDaFotoEsquerdaPequenaPossuiAFonteOGloboCondensed(){
		materia.executaMouseOverNaImagem();
		assertTrue(materia.exibiuAFonteOGloboCondensedParaALegendaDaFotoEsquerdaPequena());
	}
	
	@OrdemExecucaoTeste(Ordem=7)
	@Test
	public void verificaSeALegendaDaFotoEsquerdaPequenaOTamanhoDe15px(){
		assertTrue(materia.exibiuOTamanhoDe15pxParaALegendaDaFotoEsquerdaPequena());
	}
	
	@OrdemExecucaoTeste(Ordem=8)
	@Test  
	public void verificaSeALegendaDaFotoInlineEsquerdaPequenaEstaExibindoOAutor() throws InterruptedException {
		materia.executaMouseOverNaImagem();
		materia.esperaCarregar1Segundo();
		assertTrue(materia.exibiuAutorNaLegenda());
	}
	
	@OrdemExecucaoTeste(Ordem=9)
	@Test
	public void verificaSeOTextoDaMateriaEstaSendoExibido(){
		assertTrue(materia.exibiuTextoNaMateria());
	}
}