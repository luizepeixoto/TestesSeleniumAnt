package testes.capa.direita;

import static org.junit.Assert.*;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import pages.capa.direita.BoxRevistaDaTv;

import br.com.infoglobo.pages.OrdemExecucaoTeste;
import br.com.infoglobo.pages.OrdenadorTestes;
import br.com.infoglobo.pages.RegraTirarScreenShot;

@RunWith(OrdenadorTestes.class)
public class BoxRevistaDaTvTest {
	
	private static BoxRevistaDaTv colunaDaDireita;
	
	@Rule
	public RegraTirarScreenShot tirarScreenShot = new RegraTirarScreenShot(colunaDaDireita.getDriver());
	
	@BeforeClass
	public static void antesDeCadaTeste() throws Exception {
		colunaDaDireita = new BoxRevistaDaTv();
	}
	
	@AfterClass
	public static void depoisDeCadaTeste() {
		colunaDaDireita.fechar();
	}
	
	@Test
	@OrdemExecucaoTeste(Ordem = 1)
	public void exibiuBoxRevistaDaTv(){
		assertTrue(colunaDaDireita.exibiuBoxRevistaDaTv());
	}
	
	@Test
	@OrdemExecucaoTeste(Ordem = 2)
	public void exibiuTituloRevistaDaTv(){
		assertTrue(colunaDaDireita.exibiuTituloRevistaDaTv());
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
	public void exibiuBotaoResumoDasNovelas(){
		assertTrue(colunaDaDireita.exibiuBotaoResumoDasNovelas());
	}
	
	@Test
	@OrdemExecucaoTeste(Ordem = 6)
	public void exibiuImagemDoConteudo(){
		assertTrue(colunaDaDireita.exibiuImagemDoConteudo());
	}
	
	@Test
	@OrdemExecucaoTeste(Ordem = 7)
	public void clicouNoTituloDoConteudoERedirecionouParaAPaginaDoConteudo(){
		colunaDaDireita.clicouNoTituloDoConteudo();
		assertTrue(colunaDaDireita.redirecionouParaAPaginaDoConteudo());
		colunaDaDireita.voltarPaginaAnterior();
	}
	
	@Test
	@OrdemExecucaoTeste(Ordem = 8)
	public void clicouNaImagemDoConteudoERedirecionouParaAPaginaDoConteudo(){
		colunaDaDireita.clicouNaImagemDoConteudo();
		assertTrue(colunaDaDireita.redirecionouParaAPaginaDoConteudo());
	}
		

}
