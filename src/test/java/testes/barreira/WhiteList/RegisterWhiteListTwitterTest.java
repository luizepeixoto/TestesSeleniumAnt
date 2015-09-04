package testes.barreira.WhiteList;

import static org.junit.Assert.assertTrue;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Rule;
import org.junit.Test;

import pages.barreira.BarreiraWhiteList;

import br.com.infoglobo.pages.Navegador;
import br.com.infoglobo.pages.RegraTirarScreenShot;

public class RegisterWhiteListTwitterTest {

	private static BarreiraWhiteList barreira;
	
	@Rule
	public RegraTirarScreenShot tirarScreenShot = new RegraTirarScreenShot(barreira.getDriver());
	
	@BeforeClass
	public static void antesDeCadaTeste() throws Exception {
		barreira = new BarreiraWhiteList(Navegador.CHROME);
	}
		
	@AfterClass
	public static void depoisDeCadaTeste() {
		barreira.fechar();
	}
	
	@Test
	public void verificaSeAposNavegarPorOnzeMateriasEPararNaBarreiraDoRegisterUmaMateriaComCompartilhamentoDoTwitterEhExibidaCorretamente() throws Exception{
		barreira.navegarPorDozeMateriasDiferentes("Twitter");
		assertTrue(barreira.exibiuMateriaSemApresentarBarreira());
    }
}