package testes.barreira.WhiteList;

import static org.junit.Assert.assertEquals;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Rule;
import org.junit.Test;

import pages.barreira.BarreiraEspecialPublicitario;

import br.com.infoglobo.pages.Navegador;
import br.com.infoglobo.pages.RegraTirarScreenShot;

public class BarreiraEspecialPublicitarioTest {

	private static BarreiraEspecialPublicitario barreira;
	
	@Rule
	public RegraTirarScreenShot tirarScreenShot = new RegraTirarScreenShot(barreira.getDriver());
	
	@BeforeClass
	public static void antesDeCadaTeste() throws Exception {
		barreira = new BarreiraEspecialPublicitario(Navegador.CHROME);
	}
		
	@AfterClass
	public static void depoisDeCadaTeste() {
		barreira.fechar();
	}
	
	@Test
	public void verificaSeAposNavegarPorDezMateriasAoClicarNaDecimaPrimeiraABarreiraNaoEhExibida() throws Exception{
		String tituloEsperado = "ESPECIAL PUBLICITÁRIO";
		barreira.navegarPorOnzeMateriasDiferentes();
		assertEquals(tituloEsperado, barreira.exibiuPaginaDoEspecialPublicitario());
    }
}