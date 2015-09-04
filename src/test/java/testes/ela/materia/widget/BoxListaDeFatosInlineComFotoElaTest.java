package testes.ela.materia.widget;

import static org.junit.Assert.assertTrue;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import pages.ela.materia.widget.BoxListaDeFatosInlineComFotoEla;

import br.com.infoglobo.pages.Navegador;
import br.com.infoglobo.pages.OrdemExecucaoTeste;
import br.com.infoglobo.pages.OrdenadorTestes;
import br.com.infoglobo.pages.RegraTirarScreenShot;

@RunWith(OrdenadorTestes.class)
public class BoxListaDeFatosInlineComFotoElaTest {
	
	private static BoxListaDeFatosInlineComFotoEla materia;
	
	@Rule
	public RegraTirarScreenShot tirarScreenShot = new RegraTirarScreenShot(materia.getDriver());
	
	@BeforeClass
	public static void antesDeCadaTeste() throws Exception {
		materia = new BoxListaDeFatosInlineComFotoEla(Navegador.CHROME);
		materia.executaScrollParaAparecerOTituloDeUmaPosicao(materia.acessaBoxDeListaDeFatosInline());
	}

	@AfterClass
	public static void depoisDeCadaTeste() {
		materia.fechar();
	}
	
	@OrdemExecucaoTeste(Ordem=1)
	@Test
	public void verificaSeOBoxDeListaDeFatosInlineEstaSendoExibido(){
		assertTrue(materia.exibiuBoxDeListaDeFatosInline());
	}
	
	@OrdemExecucaoTeste(Ordem=2)
	@Test
	public void verificaSeOTituloDaListaDeFatosInlineEstaSendoExibido(){
		assertTrue(materia.exibiuTituloDaListaDeFatosInline());
	}
	
	@OrdemExecucaoTeste(Ordem=3)
	@Test
	public void verificaSeOTituloDaListaDeFatosInlineEstaSendoExibidoComOLayoutCorreto(){
		assertTrue(materia.exibiuLayoutCorretoParaOTituloDaListaDeFatosInline());
	}
	
	@OrdemExecucaoTeste(Ordem=4)
	@Test
	public void verificaSeAPagincaoDaListaDeFatosInlineEstaSendoExibido(){
		assertTrue(materia.exibiuPaginacaoDaListaDeFatosInline());
	}
	
	@OrdemExecucaoTeste(Ordem=5)
	@Test
	public void verificaSeNaPrimeiraFotoAPagincaoDaEsquerdaEstaDesabilitadaEADaDireitaEstaHabilitada(){
		assertTrue(materia.exibiuPaginacaoDoPrimeiroFatoDeFormaCorreta());
	}
	
	@OrdemExecucaoTeste(Ordem=6)
	@Test
	public void verificaSeAsImagensDaListaDeFatosEstaSendoExibidoCorretamente() throws InterruptedException{
		assertTrue(materia.exibiuCropWidthEHeightCorretosParaAsImagensDeCadaFatos());
	}
	
	@OrdemExecucaoTeste(Ordem=7)
	@Test
	public void verificaSeNaUltimaFotoAPagincaoDaEsquerdaEstaHabilitadaEADaDireitaEstaDesabilitada() throws InterruptedException{
		assertTrue(materia.exibiuPaginacaoDaUltimoFatoDeFormaCorreta());
	}
	
	@OrdemExecucaoTeste(Ordem=8)
	@Test
	public void verificaSeCadaFatoDaListaDeFatosEstaExibindoTituloDescricaoTotalDeFatosELegendaCorretamente() throws InterruptedException{
		assertTrue(materia.exibiuTituloDescricaoTotalDeFotosELegendaParaCadaFato());
	}
	
	@OrdemExecucaoTeste(Ordem=9)
	@Test
	public void verificaSeOTextoDaFatoDaListaDeFatosInlineEstaExibindoIgualAoTextoDoArticleListaDeFatos() throws Exception{
		assertTrue(materia.exibiuOMesmoConteudoTextoParaConteudoInlineEConteudoArticle());
	}
}