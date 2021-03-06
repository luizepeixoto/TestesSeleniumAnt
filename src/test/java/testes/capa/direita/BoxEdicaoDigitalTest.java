package testes.capa.direita;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import pages.capa.direita.BoxEdicaoDigital;

import br.com.infoglobo.pages.Navegador;
import br.com.infoglobo.pages.OrdemExecucaoTeste;
import br.com.infoglobo.pages.OrdenadorTestes;
import br.com.infoglobo.pages.RegraTirarScreenShot;

@RunWith(OrdenadorTestes.class)
public class BoxEdicaoDigitalTest {
	
	private static BoxEdicaoDigital colunaDaDireita;
	
	@Rule
	public RegraTirarScreenShot tirarScreenShot = new RegraTirarScreenShot(colunaDaDireita.getDriver());
	
	@BeforeClass
	public static void antesDeCadaTeste() throws Exception {
		colunaDaDireita = new BoxEdicaoDigital(Navegador.FIREFOX);
	}
	
	@AfterClass
	public static void depoisDeCadaTeste() {
		colunaDaDireita.fechar();
	}
	
	@Test
	@OrdemExecucaoTeste(Ordem = 1)
	public void exibiuBoxEdicaoDigital() throws InterruptedException {
		assertTrue(colunaDaDireita.exibiuBoxEdicaoDigital());
	}
	
	@Test
	@OrdemExecucaoTeste(Ordem = 2)
	public void exibiuTituloEdicaoDigital() {
		String tituloEsperado = "Edição Digital";
		assertEquals(tituloEsperado, colunaDaDireita.tituloEdicaoDigital());
	}
	
	@Test
	@OrdemExecucaoTeste(Ordem = 3)
	public void exibiuUmLinkNoTituloDeEdicaoDigital(){
		assertTrue(colunaDaDireita.exibiuLinkNoTituloDeEdicaoDigital());
	}
	
	@Test
	@OrdemExecucaoTeste(Ordem = 4)
	public void exibiuUmLinkValidoNoTituloDeEdicaoDigital(){
		assertTrue(colunaDaDireita.exibiuLinkValidoNoTituloDeEdicaoDigital());
	}
	
	@Test
	@OrdemExecucaoTeste(Ordem = 5)
	public void exibiuTituloAutoCritica(){
		String resultadoEsperado = "autocrítica";
		assertEquals(resultadoEsperado, colunaDaDireita.tituloAutoCritica());
	}
	
	@Test
	@OrdemExecucaoTeste(Ordem = 6)
	public void exibiuDescricaoAutoCritica(){
		assertTrue(colunaDaDireita.descricaoDigital());
	}
	
	@Test
	@OrdemExecucaoTeste(Ordem = 7)
	public void exibiuBotaoParaAcessarAEdicaoDigital(){
		assertTrue(colunaDaDireita.exibiuBotaoParaVersaoWeb());
	}
	
	@Test
	@OrdemExecucaoTeste(Ordem = 8)
	public void exibiuUmLinkNoBotaoDaVersaoWeb(){
		assertTrue(colunaDaDireita.exibiuLinkNoBotaoDaVersaoWeb());
	}
	
	@Test
	@OrdemExecucaoTeste(Ordem = 9)
	public void exibiuUmLinkValidoNoBotaoDaVersaoWeb(){
		assertTrue(colunaDaDireita.exibiuLinkValidoNoBotaoDaVersaoWeb());
	}
	
	@Test
	@OrdemExecucaoTeste(Ordem = 10)
	public void exibiuBotaoAssine(){
		assertTrue(colunaDaDireita.botaoAssine());
	}
	
	@Test
	@OrdemExecucaoTeste(Ordem = 11)
	public void exibiuBotaoParaVersaoCelular(){
		assertTrue(colunaDaDireita.botaoVersaoCelular());
	}
	
	@Test
	@OrdemExecucaoTeste(Ordem = 12)
	public void exibiuUmLinkNoBotaoDaVersaoCelular(){
		assertTrue(colunaDaDireita.exibiuLinkNoBotaoDaVersaoCelular());
	}
	
	@Test
	@OrdemExecucaoTeste(Ordem = 13)
	public void exibiuUmLinkValidoNoBotaoDaVersaoCelular(){
		assertTrue(colunaDaDireita.exibiuLinkValidoNoBotaoDaVersaoCelular());
	}
	
	@Test
	@OrdemExecucaoTeste(Ordem = 14)
	public void clicouNoBotaoParaAcessarAEdicaoDigitalERedirecionouParaAPagina(){
		//boxEdicaoDigital.voltarPaginaAnterior();
		colunaDaDireita.clicouNoBotaoParaAcessarAEdicaoDigital();
		assertTrue(colunaDaDireita.redirecionouParaAEdicaoDigital());
	}
	
	@Test
	@OrdemExecucaoTeste(Ordem = 15)
	public void clicouNoBotaoAssineERedirecionouParaAPagina(){
		colunaDaDireita.voltarPaginaAnterior();
		colunaDaDireita.clicouNoBotaoAssine();
		assertTrue(colunaDaDireita.redirecionouParaAssinar());
	}
	
	@Test
	@OrdemExecucaoTeste(Ordem = 16)
	public void clicouNoBotaoParaVersaoCelularERedirecionouParaAPagina(){
		colunaDaDireita.voltarPaginaAnterior();
		colunaDaDireita.clicouNoBotaoParaVersaoCelular();
		assertTrue(colunaDaDireita.redirecionouParaVersaoCelular());
	}
	
	@Test
	@OrdemExecucaoTeste(Ordem = 17)
	public void clicouNoTituloEdicaoDigitalERedirecionouParaOGloboDigital(){
		colunaDaDireita.voltarPaginaAnterior();
		colunaDaDireita.clicouNoTituloEdicaoDigital();
		assertTrue(colunaDaDireita.redirecionouParaOGloboDigital());
	}
	
	@Test
	@OrdemExecucaoTeste(Ordem = 18)
	public void clicouNaCapinhaERedirecionouParaOGloboDigital(){
		colunaDaDireita.voltarPaginaAnterior();
		colunaDaDireita.clicouNaCapinha();
		assertTrue(colunaDaDireita.redirecionouParaOGloboDigital());
	}
}
