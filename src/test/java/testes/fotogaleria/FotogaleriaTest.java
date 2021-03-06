package testes.fotogaleria;

import static org.junit.Assert.assertTrue;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import pages.fotogaleria.Fotogaleria;

import br.com.infoglobo.pages.Navegador;
import br.com.infoglobo.pages.OrdemExecucaoTeste;
import br.com.infoglobo.pages.OrdenadorTestes;
import br.com.infoglobo.pages.RegraTirarScreenShot;

@RunWith(OrdenadorTestes.class)
public class FotogaleriaTest {
	
	private static Fotogaleria fotogaleria;
	
	@Rule
	public RegraTirarScreenShot tirarScreenShot = new RegraTirarScreenShot(fotogaleria.getDriver());
	
	@BeforeClass
	public static void antesDeCadaTeste() throws Exception {
		fotogaleria = new Fotogaleria(Navegador.CHROME);
		fotogaleria.esperaCarregar3Segundos();
	}

	@AfterClass
	public static void depoisDeCadaTeste() {
		fotogaleria.fechar();
	}
	
	@OrdemExecucaoTeste(Ordem=1)
	@Test
	public void verificaSeAOpcaoDeAmpliarAImagemEstaSendoExibidaNoTopoDaPagina(){
		assertTrue(fotogaleria.exibiuOpcaoDeAmpliarImagem());
	}
	
	@OrdemExecucaoTeste(Ordem=2)
	@Test
	public void verificaSeOTituloDaFotogaleriaEstaSendoExibida(){
		assertTrue(fotogaleria.exibiuTituloDaFotogaleria());
	}
	
	@OrdemExecucaoTeste(Ordem=3)
	@Test
	public void verificaSeOTotalDeFotosDaFotogaleriaEstaSendoExibida(){
		assertTrue(fotogaleria.exibiuTotalDeFotosDaFotogaleria());
	}
	
	@OrdemExecucaoTeste(Ordem=4)
	@Test
	public void verificaSeAPaginacaoDaFotogaleriaEhUmaListaCircular(){
		assertTrue(fotogaleria.exibiuUmaListaCircularNaPaginacaoDaFotogaleria());
	}
	
	@OrdemExecucaoTeste(Ordem=5)
	@Test
	public void verificaSeAFotogaleriaEstaExibindoAsInformacoesCorretasParaAsImagens() throws InterruptedException{
		assertTrue(fotogaleria.exibiuCropHeightWidthCorretoParaAsImagens());
	}
	
	@OrdemExecucaoTeste(Ordem=6)
	@Test
	public void verificaSeParaCadaFotoEstaSendoExibidaOTituloEOTotalDeFotos() throws InterruptedException{
		assertTrue(fotogaleria.exibiuTituloAutorETotalDeImagens());
	}
}