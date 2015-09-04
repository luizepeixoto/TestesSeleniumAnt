package testes.temporeal;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Rule;
import org.junit.Test;

import pages.temporeal.TabSobreOJogo;

import static org.junit.Assert.*;
import br.com.infoglobo.pages.Navegador;
import br.com.infoglobo.pages.RegraTirarScreenShot;

public class TabSobreOJogoTest {
	
	private static TabSobreOJogo tempoReal;
	
	@Rule
	public RegraTirarScreenShot tirarScreenShot = new RegraTirarScreenShot(tempoReal.getDriver());
	
	@BeforeClass
	public static void iniciarExecucaoTestes() throws Exception {
		tempoReal = new TabSobreOJogo(Navegador.FIREFOX);
	}
	
	@AfterClass
	public static void finalizaTeste() {
		tempoReal.fechar();
	}
	
	@Test
	public void exibiuConteudoSobreOJogo() throws InterruptedException{
		tempoReal.clicouNaAbaSobreOJogo();
		assertTrue(tempoReal.exibiuConteudoSobreOJogo());
	}
}