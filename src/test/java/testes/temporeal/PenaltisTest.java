package testes.temporeal;

import static org.junit.Assert.*;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Rule;
import org.junit.Test;

import pages.temporeal.Penaltis;

import br.com.infoglobo.pages.Navegador;
import br.com.infoglobo.pages.RegraTirarScreenShot;

public class PenaltisTest {
	
	private static Penaltis tempoReal;
	
	@Rule
	public RegraTirarScreenShot tirarScreenShot = new RegraTirarScreenShot(tempoReal.getDriver());
	
	@BeforeClass
	public static void iniciarExecucaoTestes() throws Exception {
		tempoReal = new Penaltis(Navegador.CHROME);
		tempoReal.esperaCarregar3Segundos();
	}
	
	@AfterClass
	public static void finalizaTeste() {
		tempoReal.fechar();
	}
	
	@Test
	public void verificaSeTextoDisputaDePenaltisEstaSendoExibidoEntreOsDoisPlacares() {
		String tituloEsperado = "DISPUTA DE PÊNALTIS";
		assertEquals(tituloEsperado, tempoReal.exibiuTextoDisputaDePenaltis());
	}
	
	@Test
	public void verificaSeOPlacarDaDisputaDePenaltisTimeAEstaSendoExibido() {
		assertTrue(tempoReal.exibiuPlacarFinalDeDisputaDePenaltisDoTimeA());
	}
	
	@Test
	public void verificaSeOPlacarDaDisputaDePenaltisTimeBEstaSendoExibido() {
		assertTrue(tempoReal.exibiuPlacarFinalDeDisputaDePenaltisDoTimeB());
	}
	
	@Test
	public void verificaSeEstaSendoExibidoDezBolinhasNaDisputaDePenaltisTimeA(){
		assertTrue(tempoReal.exibiuDezBolinhasNaDisputaDePenaltisTimeA());
	}
	
	@Test
	public void verificaSeAlgumasDasDezBolinhasDasDisputaDePenaltisTimeAEstaoMarcadasComoAproveitada(){
		assertTrue(tempoReal.exibiuAlgumaDasDezBolinhasDePenaltisDoTimeAComoAproveitada());
	}
	
	@Test
	public void verificaSeAlgumasDasDezBolinhasDasDisputaDePenaltisTimeAEstaoMarcadasComoDesperdicada(){
		assertTrue(tempoReal.exibiuAlgumaDasDezBolinhasDePenaltisDoTimeAComoDesperdicada());
	}
	
	@Test
	public void verificaSeEstaSendoExibidoDezBolinhasNaDisputaDePenaltisTimeB(){
		assertTrue(tempoReal.exibiuDezBolinhasNaDisputaDePenaltisTimeB());
	}
	
	@Test
	public void verificaSeAlgumasDasDezBolinhasDasDisputaDePenaltisTimeBEstaoMarcadasComoAproveitada(){
		assertTrue(tempoReal.exibiuAlgumaDasDezBolinhasDePenaltisDoTimeBComoAproveitada());
	}
	
	@Test
	public void verificaSeAlgumasDasDezBolinhasDasDisputaDePenaltisTimeBEstaoMarcadasComoDesperdicada(){
		assertTrue(tempoReal.exibiuAlgumaDasDezBolinhasDePenaltisDoTimeBComoDesperdicada());
	}
}