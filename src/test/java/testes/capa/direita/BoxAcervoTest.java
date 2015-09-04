package testes.capa.direita;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Rule;
import org.junit.Test;

import br.com.infoglobo.pages.OrdemExecucaoTeste;
import br.com.infoglobo.pages.OrdenadorTestes;
import br.com.infoglobo.pages.RegraTirarScreenShot;
import static org.junit.Assert.*;

import org.junit.runner.RunWith;

import pages.capa.direita.BoxAcervo;

@RunWith(OrdenadorTestes.class)
public class BoxAcervoTest {
	
	private static BoxAcervo colunaDaDireita;
	
	@Rule
	public RegraTirarScreenShot tirarScreenShot = new RegraTirarScreenShot(colunaDaDireita.getDriver());
	
	@BeforeClass
	public static void antesDeCadaTeste() throws Exception {
		colunaDaDireita = new BoxAcervo();
	}
	
	@AfterClass
	public static void depoisDeCadaTeste() {
		colunaDaDireita.fechar();
	}
	
	@Test
	@OrdemExecucaoTeste(Ordem = 1)
	public void exibiuBoxAcervo(){
		assertTrue(colunaDaDireita.exibiuBoxAcervo());
	}
	
	@Test
	@OrdemExecucaoTeste(Ordem = 2)
	public void exibiuTituloAcervo(){
		assertEquals("acervo", colunaDaDireita.exibiuTituloAcervo());
	}
	
	@Test
	@OrdemExecucaoTeste(Ordem = 3)
	public void exibiuTituloDaChamada(){
		assertTrue(colunaDaDireita.exibiuTituloDaChamada());
	}
	
	@Test
	@OrdemExecucaoTeste(Ordem = 4)
	public void exibiuEditoriaDaChamada(){
		assertTrue(colunaDaDireita.exibiuEditoriaDaChamada());
	}
	
	@Test
	@OrdemExecucaoTeste(Ordem = 5)
	public void clicouNoTituloAcervoERedirecionouParaAPaginaDoAcervo() throws InterruptedException{
		colunaDaDireita.clicounoTituloAcervo();
		assertTrue(colunaDaDireita.redirecionouParaAPaginaDoAcervo());
	}
	
	@Test
	@OrdemExecucaoTeste(Ordem = 6)
	public void clicouNoTituloDaChamadaERedirecionouParaOConteudoDaChamada() throws InterruptedException{
		colunaDaDireita.voltarPaginaAnterior();
		colunaDaDireita.clicouNoTituloDaChamada();
		assertTrue(colunaDaDireita.redirecionouParaOConteudoDaChamada());
	}
}
