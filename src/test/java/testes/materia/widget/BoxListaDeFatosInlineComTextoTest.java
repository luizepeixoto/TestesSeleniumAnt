package testes.materia.widget;

import static org.junit.Assert.*;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;

import pages.materia.widget.BoxListaDeFatosInlineComTexto;

import br.com.infoglobo.pages.Navegador;
import br.com.infoglobo.pages.OrdemExecucaoTeste;
import br.com.infoglobo.pages.OrdenadorTestes;

@RunWith(OrdenadorTestes.class)
public class BoxListaDeFatosInlineComTextoTest {
	
	private static BoxListaDeFatosInlineComTexto materia;
	
	@BeforeClass
	public static void antesDeCadaTeste() throws Exception {
		materia = new BoxListaDeFatosInlineComTexto(Navegador.CHROME);
		materia.esperaCarregar(3);
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
	public void verificaSeCadaFatoDaListaDeFatosEstaExibindoTituloDescricaoCorretamente() throws InterruptedException{
		assertTrue(materia.exibiuTituloDescricaoTotalDeFotosParaCadaFato());
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