package testes.fotogaleria;

import static org.junit.Assert.assertTrue;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import pages.fotogaleria.FotogaleriaAmpliada;

import br.com.infoglobo.pages.Navegador;
import br.com.infoglobo.pages.OrdemExecucaoTeste;
import br.com.infoglobo.pages.OrdenadorTestes;
import br.com.infoglobo.pages.RegraTirarScreenShot;

@RunWith(OrdenadorTestes.class)
public class FotogaleriaAmpliadaTest {
	
	private static FotogaleriaAmpliada fotogaleria;
	
	@Rule
	public RegraTirarScreenShot tirarScreenShot = new RegraTirarScreenShot(fotogaleria.getDriver());
	
	@BeforeClass
	public static void antesDeCadaTeste() throws Exception {
		fotogaleria = new FotogaleriaAmpliada(Navegador.CHROME);
		fotogaleria.esperaCarregar(3);
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
	public void verificaSeAClicarNaOpcaoDeAmpliarAImagemEstaSendoExibidaAmpliada() throws InterruptedException{
		fotogaleria.clicarNaImagemParaAmpliar();
		fotogaleria.esperaCarregar(2);
		assertTrue(fotogaleria.exibiuBotaoDeReduzirAmpliacao());
	}
	
	@OrdemExecucaoTeste(Ordem=3)
	@Test
	public void verificaSeAPaginacaoDaFotogaleriaQuandoAmpliadaEhUmaListaCircular(){
		assertTrue(fotogaleria.exibiuUmaListaCircularNaAmpliacaoDaPaginacaoDaFotogaleria());
	}
	
	@OrdemExecucaoTeste(Ordem=4)
	@Test
	public void verificaSeAFotogaleriaAoSerAmpliadaEstaExibindoAsInformacoesCorretasParaAsImagens() throws InterruptedException{
		assertTrue(fotogaleria.exibiuCropHeightWidthCorretoParaAsImagens());
	}
	
	@OrdemExecucaoTeste(Ordem=5)
	@Test
	public void verificaSeAFotogaleriaAoSerAmpliadaEstaExibindoALegendaEOTotalDeFotos() throws InterruptedException{
		fotogaleria.esperaCarregar(2);
		fotogaleria.clicarNaFotoAnteriorAmpliada();
		assertTrue(fotogaleria.exibiuTituloAutorETotalDeImagens());
	}
	
	@OrdemExecucaoTeste(Ordem=6)
	@Test
	public void verificaSeAoClicarParaFecharAmpliacaoAFotoDeixaSerExibidaAmpliada() throws InterruptedException{
		fotogaleria.clicarParaFecharAmplicao();
		fotogaleria.esperaCarregar(2);
		assertTrue(fotogaleria.exibiuTitulo());
	}
}