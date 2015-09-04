package testes.temporeal;

import static org.junit.Assert.assertTrue;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import pages.temporeal.PlacarDoJogo;

import br.com.infoglobo.pages.Navegador;
import br.com.infoglobo.pages.OrdemExecucaoTeste;
import br.com.infoglobo.pages.OrdenadorTestes;
import br.com.infoglobo.pages.RegraTirarScreenShot;

@RunWith(OrdenadorTestes.class)
public class PlacarDoJogoTest {
		
	private static PlacarDoJogo tempoReal;
	
	@Rule
	public RegraTirarScreenShot tirarScreenShot = new RegraTirarScreenShot(tempoReal.getDriver());
	
	@BeforeClass
	public static void iniciarExecucaoTestes() throws Exception {
		tempoReal = new PlacarDoJogo(Navegador.CHROME);
	}
	
	@AfterClass
	public static void finalizaTeste() {
		tempoReal.fechar();
	}
	
	@OrdemExecucaoTeste(Ordem=1)
	@Test
	public void exibiuNomeDoPrimeiroTime() throws InterruptedException{
		assertTrue(tempoReal.exibiuNomeDoPrimeiroTime());
	}
	
	@OrdemExecucaoTeste(Ordem=2)
	@Test
	public void exibiuNomeDoSegundoTime(){
		assertTrue(tempoReal.exibiuNomeDoSegundoTime());
	}
	
	@OrdemExecucaoTeste(Ordem=3)
	@Test
	public void exibiuEscudoDoPrimeiroTime(){
		assertTrue(tempoReal.exibiuEscudoDoPrimeiroTime());
	}
	
	@OrdemExecucaoTeste(Ordem=4)
	@Test
	public void exibiuEscudoDoSegundoTime(){
		assertTrue(tempoReal.exibiuEscudoDoSegundoTime());
	}
	
	@OrdemExecucaoTeste(Ordem=5)
	@Test
	public void exibiuNumeroDeGolsDoPrimeiroTime(){
		assertTrue(tempoReal.exibiuNumeroDeGolsDoPrimeiroTime());
	}
	
	@OrdemExecucaoTeste(Ordem=6)
	@Test
	public void exibiuNumeroDeGolsDoSegundoTime(){
		assertTrue(tempoReal.exibiuNumeroDeGolsDoSegundoTime());
	}
	
	@OrdemExecucaoTeste(Ordem=7)
	@Test
	public void exibiuImagemBackground(){
		assertTrue(tempoReal.exibiuImagemBackground());
	}
}