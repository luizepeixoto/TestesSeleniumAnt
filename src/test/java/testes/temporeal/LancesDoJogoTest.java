package testes.temporeal;

import static org.junit.Assert.*;

import org.apache.commons.lang3.StringUtils;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Rule;
import org.junit.Test;

import pages.temporeal.LancesDoJogo;

import br.com.infoglobo.pages.Navegador;
import br.com.infoglobo.pages.RegraTirarScreenShot;

public class LancesDoJogoTest {
	
	private static LancesDoJogo tempoReal;
	
	@Rule
	public RegraTirarScreenShot tirarScreenShot = new RegraTirarScreenShot(tempoReal.getDriver());
	
	@BeforeClass
	public static void iniciarExecucaoTestes() throws Exception {
		tempoReal = new LancesDoJogo(Navegador.FIREFOX);
	}
	
	@AfterClass
	public static void finalizaTeste() {
		tempoReal.fechar();
	}
	
	@Test
	public void exibiuTituloTempoReal() throws InterruptedException{
		assertEquals("Tempo Real",tempoReal.exibiuTituloTempoReal());
	}
	
	@Test
	public void exibiuDataDoEvento() throws InterruptedException{
		assertTrue(tempoReal.exibiuDataDoEvento());
	}
	
	@Test
	public void exibiuDataNoFormatoHHMM()  throws InterruptedException{
		String horaCompleta = tempoReal.exibiuDataNoFormatoHHMM();
		String hora = horaCompleta.split(":")[0];
		String minuto = horaCompleta.split(":")[1];
		System.out.println(horaCompleta);
		assertTrue(StringUtils.isNumeric(hora) && StringUtils.isNumeric(minuto));
	}
	
	@Test
	public void exibiuNomeDoEstadio()  throws InterruptedException{
		assertTrue(tempoReal.exibiuNomeDoEstadio());
	}
	
	@Test
	public void exibiuNomeDoEditorDoJogo()  throws InterruptedException{
		assertTrue(tempoReal.exibiuNomeDoEditorDoJogo());
	}
	
	@Test
	public void exibiuConteudoDosLances()  throws InterruptedException{
		assertTrue(tempoReal.exibiuConteudoDosLances());
	}
}