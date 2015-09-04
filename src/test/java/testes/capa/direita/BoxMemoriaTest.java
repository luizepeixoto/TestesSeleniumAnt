package testes.capa.direita;

import static org.junit.Assert.*;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Rule;
import org.junit.Test;

import br.com.infoglobo.pages.OrdemExecucaoTeste;
import br.com.infoglobo.pages.OrdenadorTestes;
import br.com.infoglobo.pages.RegraTirarScreenShot;

import org.junit.runner.RunWith;

import pages.capa.direita.BoxMemoria;

@RunWith(OrdenadorTestes.class)
public class BoxMemoriaTest {
	
	private static BoxMemoria colunaDaDireita;
	
	@Rule
	public RegraTirarScreenShot tirarScreenShot = new RegraTirarScreenShot(colunaDaDireita.getDriver());
	
	@BeforeClass
	public static void antesDeCadaTeste() throws Exception {
		colunaDaDireita = new BoxMemoria();
	}
	
	@AfterClass
	public static void depoisDeCadaTeste() {
		colunaDaDireita.fechar();
	}
	
	@Test
	@OrdemExecucaoTeste(Ordem = 1)
	public void exibiuBoxMemoria(){
		assertTrue(colunaDaDireita.exibiuBoxMemoria());
	}
	
	@Test
	@OrdemExecucaoTeste(Ordem = 2)
	public void exibiuTituloMemoria(){
		assertEquals("memoria", colunaDaDireita.exibiuTituloMemoria());
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
	public void clicouNoTituloMemoriaERedirecionouParaAPaginaDoMemoria() throws InterruptedException{
		colunaDaDireita.clicounoTituloMemoria();
		assertTrue(colunaDaDireita.redirecionouParaAPaginaDoMemoria());
	}
	
	@Test
	@OrdemExecucaoTeste(Ordem = 6)
	public void clicouNoTituloDaChamadaERedirecionouParaOConteudoDaChamada() throws InterruptedException{
		colunaDaDireita.voltarPaginaAnterior();
		colunaDaDireita.clicouNoTituloDaChamada();
		assertTrue(colunaDaDireita.redirecionouParaOConteudoDaChamada());
	}
}
