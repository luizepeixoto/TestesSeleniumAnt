package testes.capa.direita;

import static org.junit.Assert.*;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import pages.capa.direita.BoxOGloboAMais;

import br.com.infoglobo.pages.OrdemExecucaoTeste;
import br.com.infoglobo.pages.OrdenadorTestes;
import br.com.infoglobo.pages.RegraTirarScreenShot;

@RunWith(OrdenadorTestes.class)
public class BoxOGloboAMaisTest {
	
	private static BoxOGloboAMais colunaDaDireita;
	
	@Rule
	public RegraTirarScreenShot tirarScreenShot = new RegraTirarScreenShot(colunaDaDireita.getDriver());
	
	@BeforeClass
	public static void antesDeCadaTeste() throws Exception {
		colunaDaDireita = new BoxOGloboAMais();
	}
	
	@AfterClass
	public static void depoisDeCadaTeste() {
		colunaDaDireita.fechar();
	}
	
	@Test
	@OrdemExecucaoTeste(Ordem = 1)
	public void exibiuBoxOGloboAMais(){
		assertTrue(colunaDaDireita.exibiuBoxOGloboAMais());
	}
	
	@Test
	@OrdemExecucaoTeste(Ordem = 2)
	public void exibiuTituloOGloboAMais(){
		assertTrue(colunaDaDireita.exibiuTituloOGloboAMais());
	}
	
	@Test
	@OrdemExecucaoTeste(Ordem = 3)
	public void exibiuAntetituloDoConteudo(){
		assertTrue(colunaDaDireita.exibiuAntetituloDoConteudo());
	}
	
	@Test
	@OrdemExecucaoTeste(Ordem = 4)
	public void exibiuTituloDoConteudo(){
		assertTrue(colunaDaDireita.exibiuTituloDoConteudo());
	}
	
	@Test
	@OrdemExecucaoTeste(Ordem = 5)
	public void exibiuImagemDoConteudo(){
		assertTrue(colunaDaDireita.exibiuImagemDoConteudo());
	}
	
	@Ignore
	@Test
	@OrdemExecucaoTeste(Ordem = 6)
	public void clicouNoTituloDoConteudoERedirecionouParaAPaginaDoConteudo() throws InterruptedException{
		colunaDaDireita.clicouNoTituloDoConteudo();
		assertTrue(colunaDaDireita.redirecionouParaAPaginaDoConteudo());
	}
	
	@Ignore
	@Test
	@OrdemExecucaoTeste(Ordem = 7)
	public void clicouNaImagemDoConteudoERedirecionouParaAPaginaDoConteudo() throws InterruptedException{
		colunaDaDireita.clicouNaImagemDoConteudo();
		assertTrue(colunaDaDireita.redirecionouParaAPaginaDoConteudo());
	}

}
