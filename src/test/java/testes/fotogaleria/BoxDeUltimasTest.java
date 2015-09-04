package testes.fotogaleria;

import static org.junit.Assert.assertTrue;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import pages.fotogaleria.BoxDeUltimasFotogalerias;

import br.com.infoglobo.pages.Navegador;
import br.com.infoglobo.pages.OrdemExecucaoTeste;
import br.com.infoglobo.pages.OrdenadorTestes;
import br.com.infoglobo.pages.RegraTirarScreenShot;

@RunWith(OrdenadorTestes.class)
public class BoxDeUltimasTest {
	
	private static BoxDeUltimasFotogalerias fotogaleria;
	
	@Rule
	public RegraTirarScreenShot tirarScreenShot = new RegraTirarScreenShot(fotogaleria.getDriver());
	
	@BeforeClass
	public static void antesDeCadaTeste() throws Exception {
		fotogaleria = new BoxDeUltimasFotogalerias(Navegador.CHROME);
		fotogaleria.executaScrollParaAparecerOTituloDeUmaPosicao(fotogaleria.acessaClasseLastFrom());
		fotogaleria.esperaCarregar(4);
	}

	@AfterClass
	public static void depoisDeCadaTeste() {
		fotogaleria.fechar();
	}
	
	@OrdemExecucaoTeste(Ordem=1)
	@Test
	public void verificaSeOBoxDeUltimasFotogaleriasEstaSendoExibidaNoFimDaPagina(){
		assertTrue(fotogaleria.exibiuBoxDeUltimasFotogalerias());
	}
	
	@OrdemExecucaoTeste(Ordem=2)
	@Test
	public void verificaSeNaoEstaSendoExibidoOTituloDoMenuUltimasDeFotogaleria(){
		assertTrue(fotogaleria.exibiuTituloDeUltimasDe());
	}
	
	@OrdemExecucaoTeste(Ordem=3)
	@Test
	public void verificaSeOMenuUltimasDeFotogaleriaDeUmaEditoriaSendoExibida(){
		assertTrue(fotogaleria.exibiuMenuUltimasDeFotogalerias());
	}
	
	@OrdemExecucaoTeste(Ordem=4)
	@Test
	public void verificaSeAPrimeiraOpcaoDoMenuUltimasDeFotogaleriaEhODeTodas(){
		assertTrue(fotogaleria.exibiuPrimeiraOpcaoTodasDoMenuUltimasDeFotogalerias());
	}
	
	@OrdemExecucaoTeste(Ordem=5)
	@Test
	public void verificaSeAOpcaoTodasDoMenuUltimasDeFotogaleriaEstaMarcadaComoAtiva(){
		assertTrue(fotogaleria.exibiuPrimeiraOpcaoTodasEstaSelecionadaComoAtiva());
	}
	
	@OrdemExecucaoTeste(Ordem=6)
	@Test
	public void verificaSeAsOpcoesDoMenuUltimasEstaoExibindoAEditoria(){
		assertTrue(fotogaleria.exibiuEditoriaNasOpcoesDoMenu());
	}
	
	@OrdemExecucaoTeste(Ordem=7)
	@Test
	public void verificaSeAsOpcoesDoMenuUltimasPossuemUmLink(){
		assertTrue(fotogaleria.exibiuEditoriaNasOpcoesDoMenuComUmLink());
	}
	
	@OrdemExecucaoTeste(Ordem=8)
	@Test
	public void verificaSeAsEstaSendoExibidoUmaListaDeFotogalerias(){
		assertTrue(fotogaleria.exibiuUmaListaDeFotogalerias());
	}
	
	@OrdemExecucaoTeste(Ordem=9)
	@Test
	public void verificaSeAsFotogaleriasEstaoExibindoUmaImagem(){
		assertTrue(fotogaleria.exibiuUmaListaDeFotogaleriasComUmaImagem());
	}
	
	@OrdemExecucaoTeste(Ordem=10)
	@Test
	public void verificaSeAsFotogaleriasEstaExibindoUmLinkNaImagemENoTitulo(){
		assertTrue(fotogaleria.exibiuUmLinkNasImagensENosTitulosDasFotogalerias());
	}
	
	@OrdemExecucaoTeste(Ordem=11)
	@Test
	public void verificaSeAsImagensDasFotogaleriasEstaoExibindoOCropCorreto(){
		assertTrue(fotogaleria.exibiuAsFotosDaListaDeFotogaleriasComOCropCorreto());
	}
	
	@OrdemExecucaoTeste(Ordem=12)
	@Test
	public void verificaSeAsImagensDasFotogaleriasEstaoExibindoOWidthCorreto(){
		assertTrue(fotogaleria.exibiuAsFotosDaListaDeFotogaleriasComOWidthCorreto());
	}
	
	@OrdemExecucaoTeste(Ordem=13)
	@Test
	public void verificaSeAsImagensDasFotogaleriasEstaoExibindoOHeightCorreto(){
		assertTrue(fotogaleria.exibiuAsFotosDaListaDeFotogaleriasComOHeightCorreto());
	}
	
	@OrdemExecucaoTeste(Ordem=14)
	@Test
	public void verificaSeAsFotogaleriasEstaoExibindoOTitulo(){
		assertTrue(fotogaleria.exibiuTituloParaAsOpcoesDeFotogalerias());
	}
	
	@OrdemExecucaoTeste(Ordem=15)
	@Test
	public void verificaSeOBoxDeUltimasFotogaleriasEstaExibindoAPaginacao(){
		assertTrue(fotogaleria.exibiuPaginacaoDeFotogalerias());
	}
	
	@OrdemExecucaoTeste(Ordem=16)
	@Test
	public void verificaSeAPaginacaoDosBoxDeUltimasFotogaleriasEhUmaListaCircular(){
		assertTrue(fotogaleria.exibiuUmaListaCircularNaPaginacaoDoBoxDeFotogalerias());
	}
	
	@OrdemExecucaoTeste(Ordem=17)
	@Test
	public void verificaSeAoClicarNaNavegacaoDoBoxAsImagensSaoMudadas() throws InterruptedException{
		assertTrue(fotogaleria.exibiuUmaFotogaleriaDiferenteAoPaginarOBox());
	}
	
	@OrdemExecucaoTeste(Ordem=18)
	@Test
	public void verificaSeNoFimDoBoxEstaSendoExibidoUmTituloComUmLinkParaVerOutrasFotogalerias() throws InterruptedException{
		assertTrue(fotogaleria.exibiuUmTituloComUmLinkParaAEditoriaDeFotogaleria());
	}
	
	@OrdemExecucaoTeste(Ordem=18)
	@Test
	public void verificaSeOLinkParaVerOutrasFotogaleriasEstaComOLayoutCorreto() throws InterruptedException{
		assertTrue(fotogaleria.exibiuUmTituloComUmLinkComOLayoutCorreto());
	}
}