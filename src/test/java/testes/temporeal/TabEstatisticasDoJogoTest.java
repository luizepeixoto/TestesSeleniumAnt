package testes.temporeal;

import static org.junit.Assert.assertTrue;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import pages.temporeal.TabEstatisticasDoJogo;

import br.com.infoglobo.pages.Navegador;
import br.com.infoglobo.pages.OrdemExecucaoTeste;
import br.com.infoglobo.pages.OrdenadorTestes;
import br.com.infoglobo.pages.RegraTirarScreenShot;

@RunWith(OrdenadorTestes.class)
public class TabEstatisticasDoJogoTest {
	
	private static TabEstatisticasDoJogo tempoReal;
	
	@Rule
	public RegraTirarScreenShot tirarScreenShot = new RegraTirarScreenShot(tempoReal.getDriver());
	
	@BeforeClass
	public static void iniciarExecucaoTestes() throws Exception {
		tempoReal = new TabEstatisticasDoJogo(Navegador.FIREFOX);
	}
	
	@AfterClass
	public static void finalizaTeste() {
		tempoReal.fechar();
	}
	
	@OrdemExecucaoTeste(Ordem=1)
	@Test
	public void exibiuConteudoEstatisticaSobreOJogo() throws InterruptedException{
		tempoReal.clicouNaAbaEstatisticasDoJogo();
		assertTrue(tempoReal.exibiuImagem());
	}
	
	@OrdemExecucaoTeste(Ordem=2)
	@Test
	public void exibiuWidthCorretoParaAImagemDaEscalacaoDoTime() throws InterruptedException{
		assertTrue(tempoReal.exibiuWidth());
	}
	
	@OrdemExecucaoTeste(Ordem=3)
	@Test
	public void exibiuHeightCorretoParaAImagemDaEscalacaoDoTime() throws InterruptedException{
		assertTrue(tempoReal.exibiuHeight());
	}
}