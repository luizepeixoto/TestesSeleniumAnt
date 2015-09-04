package testes.capa.direita;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Rule;
import org.junit.Test;

import static org.junit.Assert.*;
import br.com.infoglobo.pages.Navegador;
import br.com.infoglobo.pages.OrdemExecucaoTeste;
import br.com.infoglobo.pages.OrdenadorTestes;
import br.com.infoglobo.pages.RegraTirarScreenShot;

import org.junit.runner.RunWith;

import pages.capa.direita.BoxEuReporter;

@RunWith(OrdenadorTestes.class)
public class BoxEuReporterTest {

	private static BoxEuReporter colunaDaDireita;
	
	@Rule
	public RegraTirarScreenShot tirarScreenShot = new RegraTirarScreenShot(colunaDaDireita.getDriver());
	
	@BeforeClass
	public static void antesDeCadaTeste() throws Exception {
		colunaDaDireita = new BoxEuReporter(Navegador.FIREFOX);
	}
	
	@AfterClass
	public static void depoisDeCadaTeste() {
		colunaDaDireita.fechar();
	}
	
	@Test
	@OrdemExecucaoTeste(Ordem = 1)
	public void exibiuBoxEuReporter(){
		assertTrue(colunaDaDireita.exibiuBoxEuReporter());
	}
	
	@Test
	@OrdemExecucaoTeste(Ordem = 2)
	public void exibiuTituloEuReporter(){
		assertEquals("Eu Repórter", colunaDaDireita.exibiuTituloEuReporter());
	}
	
	@Test
	@OrdemExecucaoTeste(Ordem = 3)
	public void exibiuConteudoBoxEuReporter(){
		assertTrue(colunaDaDireita.exibiuConteudoBoxEuReporter());
	}
	
	@Test
	@OrdemExecucaoTeste(Ordem = 4)
	public void exibiuTituloDaChamada(){
		assertTrue(colunaDaDireita.exibiuTituloDaChamada());
	}
	
	@Test
	@OrdemExecucaoTeste(Ordem = 5)
	public void clicouNoTituloEuReporterERedirecionouParaAPaginaDoEuReporter(){
		colunaDaDireita.clicouNoTituloEuReporter();
		assertTrue(colunaDaDireita.redirecionouParaAPaginaDoEuReporter());
	}
	
	@Test
	@OrdemExecucaoTeste(Ordem = 6)
	public void clicouNoTituloDaChamadaERedirecionouParaOConteudoDaChamada(){
		colunaDaDireita.voltarPaginaAnterior();
		colunaDaDireita.clicouNoTituloDaChamada();
		assertTrue(colunaDaDireita.redirecionouParaOConteudoDaChamada());
	}
}