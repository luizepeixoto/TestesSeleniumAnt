package testes.capa.direita;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Rule;
import org.junit.Test;

import br.com.infoglobo.pages.OrdemExecucaoTeste;
import br.com.infoglobo.pages.OrdenadorTestes;
import br.com.infoglobo.pages.RegraTirarScreenShot;

import org.junit.runner.RunWith;

import pages.capa.direita.BoxHoroscopo;

import static org.junit.Assert.*;

@RunWith(OrdenadorTestes.class)
public class BoxHoroscopoTest {

	private static BoxHoroscopo colunaDaDireita;
	
	@Rule
	public RegraTirarScreenShot tirarScreenShot = new RegraTirarScreenShot(colunaDaDireita.getDriver());
	
	@BeforeClass
	public static void antesDeCadaTeste() throws Exception {
		colunaDaDireita = new BoxHoroscopo();						
	}
	
	@AfterClass
	public static void depoisDeCadaTeste() {
		colunaDaDireita.fechar();
	}
	
	@Test
	@OrdemExecucaoTeste(Ordem = 1)
	public void exibiuBoxHoroscopo(){
		assertTrue(colunaDaDireita.exibiuBoxHoroscopo());
	}
	
	@Test
	@OrdemExecucaoTeste(Ordem = 2)
	public void exibiuTituloHoroscopo(){
		assertTrue(colunaDaDireita.exibiuTituloHoroscopo());
	}

	@Test
	@OrdemExecucaoTeste(Ordem = 3)
	public void exibiuImagemDoSigno(){
		assertTrue(colunaDaDireita.exibiuImagemDoSigno());
	}
	
	@Test
	@OrdemExecucaoTeste(Ordem = 4)
	public void exibiuNomeDoSigno(){
		assertTrue(colunaDaDireita.exibiuNomeDoSigno());
	}
	
	@Test
	@OrdemExecucaoTeste(Ordem = 5)
	public void exibiuIntervaloDeDatasDoSigno(){
		assertTrue(colunaDaDireita.exibiuIntervaloDeDatasDoSigno());
	}
	
	@Test
	@OrdemExecucaoTeste(Ordem = 6)
	public void exibiutextoDoSigno(){
		assertTrue(colunaDaDireita.exibiutextoDoSigno());
	}
	
	@Test
	@OrdemExecucaoTeste(Ordem = 7)
	public void exibiuLinkLeiaMais(){
		assertTrue(colunaDaDireita.exibiuLinkLeiaMais());
	}
	
	@Test
	@OrdemExecucaoTeste(Ordem = 8)
	public void exibiuDozeImagensDosSignos(){
		assertTrue(colunaDaDireita.exibiuDozeImagensDosSignos() == Integer.parseInt("12"));
	}
	
	@Ignore
	@Test
	@OrdemExecucaoTeste(Ordem = 9)
	public void clicouNoTituloHoroscopoERedirecionouParaAPaginaDoHoroscopo(){
		colunaDaDireita.clicouNoTituloHoroscopo();
		assertTrue(colunaDaDireita.redirecionouParaAPaginaDoHoroscopo());		
	}
	
	@Ignore
	@Test
	@OrdemExecucaoTeste(Ordem = 10)
	public void clicouNoTextoDoSignoERedirecionouParaAPaginaDoHoroscopo(){
		colunaDaDireita.voltarPaginaAnterior();
		colunaDaDireita.clicouNoTextoDoSigno();
		assertTrue(colunaDaDireita.redirecionouParaAPaginaDoHoroscopo());
	}
	
	@Ignore
	@Test
	@OrdemExecucaoTeste(Ordem = 11)
	public void clicouNoLinkLeiaMaisERedirecionouParaAPaginaDoHoroscopo(){
		colunaDaDireita.voltarPaginaAnterior();
		colunaDaDireita.clicouNoLinkLeiaMais();
		assertTrue(colunaDaDireita.redirecionouParaAPaginaDoHoroscopo());
	}
	
	@Ignore
	@Test
	@OrdemExecucaoTeste(Ordem = 12)
	public void clicouEmUmSignoDaListagemERedirecionouParaAPaginaDoHoroscopo(){
		colunaDaDireita.voltarPaginaAnterior();
		colunaDaDireita.clicouEmUmSignoDaListagem();
		assertTrue(colunaDaDireita.redirecionouParaAPaginaDoHoroscopo());
	}
}