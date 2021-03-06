package testes.temporeal;

import static org.junit.Assert.*;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Rule;
import org.junit.Test;

import pages.temporeal.TabEmCampo;

import br.com.infoglobo.pages.Navegador;
import br.com.infoglobo.pages.RegraTirarScreenShot;

public class TabEmCampoTest {
	
	private static TabEmCampo tempoReal;
	
	@Rule
	public RegraTirarScreenShot tirarScreenShot = new RegraTirarScreenShot(tempoReal.getDriver());
	
	@BeforeClass
	public static void iniciarExecucaoTestes() throws Exception {
		tempoReal = new TabEmCampo(Navegador.CHROME);
	}
	
	@AfterClass
	public static void finalizaTeste() {
		tempoReal.fechar();
	}
	
	@Test
	public void exibiuOnzeTitularesEscaladosParaTimeUm(){
		assertTrue(tempoReal.exibiuOnzeTitularesEscaladosParaTimeUm());
	}
	
	@Test
	public void exibiuOnzeTitularesEscaladosParaTimeDois(){
		assertTrue(tempoReal.exibiuOnzeTitularesEscaladosParaTimeDois());
	}
	
	@Test
	public void exibiuNomeDoTecnicoDoTimeUm(){
		assertTrue(tempoReal.exibiuNomeDoTecnicoDoTimeUm());
	}
	
	@Test
	public void exibiuNomeDoTecnicoDoTimeDois(){
		assertTrue(tempoReal.exibiuNomeDoTecnicoDoTimeDois());
	}
	
	@Test
	public void exibiuEscudoTimeUm(){
		assertTrue(tempoReal.exibiuEscudoTimeUm());
	}
	
	@Test
	public void exibiuEscudoTimeDois(){
		assertTrue(tempoReal.exibiuEscudoTimeDois());
	}
}