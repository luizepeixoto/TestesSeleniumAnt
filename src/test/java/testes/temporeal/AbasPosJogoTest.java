package testes.temporeal;

import static org.junit.Assert.*;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Rule;
import org.junit.Test;

import br.com.infoglobo.pages.Navegador;
import br.com.infoglobo.pages.OrdemExecucaoTeste;
import br.com.infoglobo.pages.OrdenadorTestes;
import br.com.infoglobo.pages.RegraTirarScreenShot;

import org.junit.runner.RunWith;

import pages.temporeal.AbasPosJogo;

@RunWith(OrdenadorTestes.class)
public class AbasPosJogoTest {

	private static AbasPosJogo tempoReal;
	
	@Rule
	public RegraTirarScreenShot tirarScreenShot = new RegraTirarScreenShot(tempoReal.getDriver());
	
	@BeforeClass
	public static void iniciarExecucaoTestes() throws Exception {
		tempoReal = new AbasPosJogo(Navegador.CHROME);
	}
	
	@AfterClass
	public static void finalizaTeste() {
		tempoReal.fechar();
	}
	
	@Test
	@OrdemExecucaoTeste(Ordem = 1)
	public void exibiuCincoAbas(){
		assertTrue(tempoReal.exibiuCincoAbas() == Integer.parseInt("5"));
	}
	
	@Test
	@OrdemExecucaoTeste(Ordem = 2)
	public void exibiuTituloImagensOuImagem(){
		assertTrue(tempoReal.exibiuTituloImagensOuImagem());
	}
	
	@Test
	@OrdemExecucaoTeste(Ordem = 3)
	public void exibiuTituloAtuações(){
		assertEquals("ATUAÇÕES", tempoReal.exibiuTituloAtuações());
	}
	
	@Test
	@OrdemExecucaoTeste(Ordem = 4)
	public void exibiuTituloEstatisticas(){
		assertEquals("ESTATÍSTICAS", tempoReal.exibiuTituloEstatisticas());
	}
	
	@Test
	@OrdemExecucaoTeste(Ordem = 5)
	public void exibiuTituloJogadas(){
		assertEquals("JOGADAS", tempoReal.exibiuTituloJogadas());
	}
	
	@Test
	@OrdemExecucaoTeste(Ordem = 6)
	public void exibiuTituloDestaques(){
		assertEquals("DESTAQUES", tempoReal.exibiuTituloDestaques());
	}
	
	@Test
	@OrdemExecucaoTeste(Ordem = 7)
	public void exibiuConteudoDaAbaImagens(){
		assertTrue(tempoReal.exibiuConteudoDaAbaImagens());
	}
	
	@Test
	@OrdemExecucaoTeste(Ordem = 8)
	public void exibiuConteudoDaAbaAtuacoes() throws InterruptedException{
		tempoReal.clicouNaAbaAtuacoes();
		assertTrue(tempoReal.exibiuConteudoDaAbaAtuacoes());
	}
	
	@Test
	@OrdemExecucaoTeste(Ordem = 9)
	public void exibiuConteudoDaAbaEstatisticas() throws InterruptedException{
		tempoReal.clicouNaAbaEstatisticas();
		assertTrue(tempoReal.exibiuConteudoDaAbaEstatisticas());
	}
	
	@Test
	@OrdemExecucaoTeste(Ordem = 10)
	public void exibiuConteudoDaAbaJogadas() throws InterruptedException{
		tempoReal.clicouNaAbaJogadas();
		assertTrue(tempoReal.exibiuConteudoDaAbaJogadas());
	}
	
	@Test
	@OrdemExecucaoTeste(Ordem = 11)
	public void exibiuConteudoDaAbaDestaques() throws InterruptedException{
		tempoReal.clicouNaAbaDestaques();
		assertTrue(tempoReal.exibiuConteudoDaAbaDestaques());
	}
}